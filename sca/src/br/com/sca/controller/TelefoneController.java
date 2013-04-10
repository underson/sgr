/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.controller;

import br.com.sca.datamodel.ModelTabelaTelefone;
import br.com.sca.entidades.Telefone;
import br.com.sca.persistencia.Dao;
import java.util.List;

/**
 *
 * @author
 */
public class TelefoneController {

    private List<Telefone> listaTelefone;
    private ModelTabelaTelefone modelTabelaTelefone;

    public TelefoneController() {
    }

    private List pequisarTodos(Dao dao) {
        listaTelefone = dao.pesquisar("Telefone.findAll");
        return listaTelefone;
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários
     */

    public ModelTabelaTelefone retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaTelefone = new ModelTabelaTelefone(pequisarTodos(dao));
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários com o nome igual ao da pesquisa
     * @param nome: o nome do funcionário a buscar
     */

    public ModelTabelaTelefone preencherTabelaParametroNome(Dao dao, String nome) {
        listaTelefone = dao.pesquisar("Telefone.findByNumeroTelefone", new Object[]{"%" + nome.toLowerCase() + "%"});
        return modelTabelaTelefone = new ModelTabelaTelefone(listaTelefone);
    }
    /*
     * método pra retornar o funcionario do modelTabelaFuncionario no indice passado como parametro
     */

    public Telefone retornarTelefoneIndex(int indice, ModelTabelaTelefone modelTabelaTelefone) {
        return (Telefone) modelTabelaTelefone.getObjectAt(indice);
    }
    // O método gravar retorna um integer que é comparado no frame

    public int gravar(Dao dao, Telefone telefone) {
        return dao.gravar(telefone);
    }
    // O método excluir retorna um integer que é comparado no frame

    public int excluir(Dao dao, Telefone telefone) {
        return dao.excluir(telefone);
    }
}
