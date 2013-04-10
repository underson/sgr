/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.controller;

import br.com.sca.datamodel.ModelTabelaFuncionario;
import br.com.sca.entidades.Funcionario;
import br.com.sca.persistencia.Dao;
import java.util.List;

/**
 *
 * @author
 */
public class FuncionarioController {

    private List<Funcionario> listaFuncionario;
    private ModelTabelaFuncionario modelTabelaFuncionario;

    public FuncionarioController() {
    }

    private List pequisarTodos(Dao dao) {
        listaFuncionario = dao.pesquisar("Funcionario.findAll");
        return listaFuncionario;
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários
     */

    public ModelTabelaFuncionario retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaFuncionario = new ModelTabelaFuncionario(pequisarTodos(dao));
    }

    public ModelTabelaFuncionario retornaModelTabelaCompletaAtivo(Dao dao){
        return modelTabelaFuncionario = new ModelTabelaFuncionario(dao.pesquisar("Funcionario.findByFuncAtivo", new Object[]{true}));
    }

    public ModelTabelaFuncionario preencherTabelaParametroNomeSemAlmoxarife(Dao dao, String nome) {
        listaFuncionario = dao.pesquisar("Funcionario.menosAlmoxarifePorNome", new Object[]{"%" + nome.toLowerCase() + "%"});
        return modelTabelaFuncionario = new ModelTabelaFuncionario(listaFuncionario);
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários com o nome igual ao da pesquisa
     * @param nome: o nome do funcionário a buscar
     */

    public ModelTabelaFuncionario preencherTabelaParametroNome(Dao dao, String nome) {
        listaFuncionario = dao.pesquisar("Funcionario.findByNomeFunc", new Object[]{"%" + nome.toLowerCase() + "%"});
        return modelTabelaFuncionario = new ModelTabelaFuncionario(listaFuncionario);
    }
    /*
     * método pra retornar o funcionario do modelTabelaFuncionario no indice passado como parametro
     */
    /*Método para preencher a tabela com todos os funcionarios, menos os que são almoxarifes
     *
     */

    public ModelTabelaFuncionario retornaModelTabelaCompletaSemAlmoxarife(Dao dao) {
        listaFuncionario = dao.pesquisar("Funcionario.menosAlmoxarife");
        return modelTabelaFuncionario = new ModelTabelaFuncionario(listaFuncionario);
    }

    public Funcionario retornarFuncionarioIndex(int indice) {
        return (Funcionario) modelTabelaFuncionario.getObjectAt(indice);
    }
    // O método gravar retorna um integer que é comparado no frame

    public int gravar(Dao dao, Funcionario funcionario) {
        return dao.gravar(funcionario);
    }
    // O método excluir retorna um integer que é comparado no frame

    public int excluir(Dao dao, Funcionario funcionario) {
        return dao.excluir(funcionario);
    }
}
