/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.controller;

import br.com.sca.datamodel.MTMaterial;
import br.com.sca.datamodel.MTRequisicao;
import br.com.sca.datamodel.ModelTabelaFuncionario;
import br.com.sca.datamodel.ModelTabelaMateriais;
import br.com.sca.entidades.Materiais;
import br.com.sca.persistencia.Dao;
import java.util.List;

/**
 *
 * @author Bruno Gomes
 */
public class MateriaisController {

    private List<Materiais> listaMateriais;
    private ModelTabelaMateriais modelTabelaMateriais;
    private MTMaterial modeloTabelaMaterialReq;
    private List listaFuncionario;
    private ModelTabelaFuncionario modelTabelaFuncionario;

    public MateriaisController() {
    }



     private List pequisarTodos(Dao dao) {
        listaMateriais = dao.pesquisar("Materiais.findAll");
        return listaMateriais;
    }

      public MTMaterial retornaModelTabelaCompletaReq(Dao dao) {
        return modeloTabelaMaterialReq = new MTMaterial(pequisarTodos(dao));
    }

     /*
     * método para preencher o ModelTabelaMateriais com todos os materiais
     */
    public ModelTabelaMateriais retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaMateriais = new ModelTabelaMateriais(pequisarTodos(dao));
    }

     /*
     * método para preencher o ModelTabelaMateriais com todos os materiais com o nome igual ao da pesquisa
     * @param nome: o nome do material a buscar
     */
    public ModelTabelaMateriais preencherTabelaParametroNome(Dao dao, String nome) {
        listaMateriais = dao.pesquisar("Materiais.encontrarPorNomeLike", new Object[]{"%" + nome.toLowerCase() + "%"});
        return modelTabelaMateriais  = new ModelTabelaMateriais (listaMateriais);
    }

    /*
     * método pra retornar o material do modelTabelaMateriais no indice passado como parametro
     */
    public Materiais retornarMateriaisIndex(int indice) {
        return (Materiais) modelTabelaMateriais.getObjectAt(indice);
    }

     // O método gravar retorna um integer que é comparado no frame
    public int gravar(Dao dao, Materiais materiais) {
        return dao.gravar(materiais);
    }

    // O método excluir retorna um integer que é comparado no frame
    public int excluir(Dao dao, Materiais materiais) {
        return dao.excluir(materiais);
    }


}
