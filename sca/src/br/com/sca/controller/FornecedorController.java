/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.controller;

import br.com.sca.datamodel.ModelTabelaFornecedor;
import br.com.sca.entidades.Fornecedor;
import br.com.sca.persistencia.Dao;
import java.util.List;

/**
 *
 * @author
 */
public class FornecedorController {

    private List<Fornecedor> listaFornecedor;
    private ModelTabelaFornecedor modelTabelaFornecedor;

    public FornecedorController() {
    }

    private List pequisarTodos(Dao dao) {
        listaFornecedor = dao.pesquisar("Fornecedor.findAll");
        return listaFornecedor;
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários
     */

    public ModelTabelaFornecedor retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaFornecedor = new ModelTabelaFornecedor(pequisarTodos(dao));
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários com o nome igual ao da pesquisa
     * @param nome: o nome do funcionário a buscar
     */

    public ModelTabelaFornecedor preencherTabelaParametroNome(Dao dao, String razao) {
        listaFornecedor = dao.pesquisar("Fornecedor.findByRzSocFornec", new Object[]{"%" + razao.toLowerCase() + "%"});
        return modelTabelaFornecedor = new ModelTabelaFornecedor(listaFornecedor);
    }
    /*
     * método pra retornar o funcionario do modelTabelaFuncionario no indice passado como parametro
     */

    public Fornecedor retornarFornecedorIndex(int indice) {
        return (Fornecedor) modelTabelaFornecedor.getObjectAt(indice);
    }
    // O método gravar retorna um integer que é comparado no frame

    public int gravar(Dao dao, Fornecedor fornecedor) {
        return dao.gravar(fornecedor);
    }
    // O método excluir retorna um integer que é comparado no frame

    public int excluir(Dao dao, Fornecedor fornecedor) {
        return dao.excluir(fornecedor);
    }
}
