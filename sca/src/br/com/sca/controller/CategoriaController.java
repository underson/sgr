/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.controller;

import br.com.sca.datamodel.ModelTabelaCategoria;
import br.com.sca.entidades.Categoria;
import br.com.sca.persistencia.Dao;
import java.util.List;

/**
 *
 * @author Bruno Gomes
 */
public class CategoriaController {

    private List<Categoria> listaCategoria;
    private ModelTabelaCategoria modelTabelaCategoria;

    public CategoriaController() {
    }

    private List pequisarTodos(Dao dao) {
        listaCategoria = dao.pesquisar("Categoria.findAll");
        return listaCategoria;
    }

    /*
     * método para preencher o ModelTabelaCategoria com todos as categorias
     */

    public ModelTabelaCategoria retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaCategoria = new ModelTabelaCategoria(pequisarTodos(dao));
    }

    /*
     * método para preencher o ModelTabelaCategoria com todos as categorias com o nome igual ao da pesquisa
     * @param nome: o nome da categoria a buscar
     */

    public ModelTabelaCategoria preencherTabelaParametroNome(Dao dao, String nome) {
        listaCategoria = dao.pesquisar("Categoria.findByNomeCateg", new Object[]{"%" + nome.toLowerCase() + "%"});
        return modelTabelaCategoria = new ModelTabelaCategoria(listaCategoria);
    }
    /*
     * método pra retornar a categoria do modelTabelaCategoria no indice passado como parametro
     */

    public Categoria retornarCategoriaIndex(int indice) {
        return (Categoria) modelTabelaCategoria.getObjectAt(indice);
    }

    // O método gravar retorna um integer que é comparado no frame

    public int gravar(Dao dao, Categoria categoria) {
        return dao.gravar(categoria);
    }

    // O método excluir retorna um integer que é comparado no frame

    public int excluir(Dao dao, Categoria categoria) {
        return dao.excluir(categoria);
    }
}
