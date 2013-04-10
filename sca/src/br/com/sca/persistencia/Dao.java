package br.com.sca.persistencia;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.Parameter;
import javax.persistence.EntityManager;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 * Classe genérica responsével por realizar a persistêcia de entidades no banco de dados.
 * @author Anderson Alves
 * @since 03/04/2012
 * @version 1.0
 */
public class Dao {

    private EntityManager entityManager;
    public static final int SUCESSO = 0;
    public static final int ERRO = 1;
    public static final int ERRO_1451 = 2;

    public Dao() {
    }

    /**
     * O método gravar (Object objeto) recebe o objeto a ser persistido e retorna um
     * numero inteiro para ser comparado com os campos estáticos do Dao (SUCESSO, ERRO)
     * @param objeto: O objeto que se deseja persistir
     */
    public int gravar(Object objeto) {
        entityManager = Factory.getEntityManager();
        int resultado = Dao.ERRO;
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            resultado = Dao.SUCESSO;
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            resultado = Dao.ERRO;
        } finally {
            entityManager.close();
            return resultado;
        }
    }

    /**
     * O método gravar (Object objeto) recebe o objeto a ser persistido e retorna o
     * objeto persistido.
     * @param objeto: O objeto que se deseja persistir
     */
    public Object gravarObjeto(Object objeto) {
        entityManager = Factory.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return objeto;
    }

    public Object encontrar (Class classe, int chavePrimaria){
        entityManager = Factory.getEntityManager();
        return  entityManager.find(classe, chavePrimaria);
    }

    /**
     * O metodo excluir (Object objeto) recebe o objeto a ser excluído do banco de dados e
     * retorna um inteiro para ser comparado com os campos estáticos do Dao (SUCESSO, ERRO, ERRO_1451)
     * @param objeto: O objeto que se deseja excluir
     */
    public int excluir(Object objeto) {
        entityManager = Factory.getEntityManager();
        int resultado = Dao.ERRO;
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(objeto));
            entityManager.flush();
            entityManager.getTransaction().commit();
            resultado = Dao.SUCESSO;
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            if (exception.getCause().getClass() == DatabaseException.class) {
                DatabaseException databaseException = (DatabaseException) exception.getCause();
                resultado = Dao.ERRO;
                if (databaseException.getDatabaseErrorCode() == 1451) {
                    resultado = Dao.ERRO_1451;
                }
            } else {
                resultado = Dao.ERRO;
            }
        } finally {
            entityManager.close();
            return resultado;
        }
    }

    /**
     * O método pesquisar(String namedQuery, Object[] objeto)
     * exige que o programador envie o nome da named query e
     * um ou mais parâmetros para executar a busca.
     * @param namedQuery: Query que se deseja executar.
     * @param object[]: Array de parametros da namedQuery.
     */
    public List pesquisar(String nomeQuery, Object[] objeto) {
        entityManager = Factory.getEntityManager();
        int i = 0;
        Query query = entityManager.createNamedQuery(nomeQuery);
        for (Parameter parametro : query.getParameters()) {
            query.setParameter(parametro, objeto[i++]);
        }
        return query.getResultList();
    }

    /**
     * O método listar(String namedQuery)
     * devolve uma lista de objetos através de uma
     * named query sem parâmetros
     * @param namedQuery: Query que se deseja executar.
     */
    public List pesquisar(String namedQuery) {
        entityManager = Factory.getEntityManager();
        return entityManager.createNamedQuery(namedQuery).getResultList();
    }
}
