/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.controller;

import br.com.sca.datamodel.ModelTabelaAlmoxarife;
import br.com.sca.entidades.Almoxarife;
import br.com.sca.persistencia.Dao;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Anderson Alves
 */
public class AlmoxarifeController {

    private List<Almoxarife> listaAlmoxarife;
    private ModelTabelaAlmoxarife modelTabelaAlmoxarife;

    public AlmoxarifeController() {
    }

    public int quantidadeAlmoxarife(Dao dao) {
        listaAlmoxarife = dao.pesquisar("Almoxarife.findAll");
		
        int aux = listaAlmoxarife.size();
        return aux;
    }
    
    public int quantidadeLogin(Dao dao, String login) {
        listaAlmoxarife = dao.pesquisar("Almoxarife.findByLoginAlmoxarife", new Object[]{login.toLowerCase()});
        int aux = listaAlmoxarife.size();
        return aux;
    }
    
    public Almoxarife findAlmoxarife(Dao dao, String login) {
        Almoxarife aux = new Almoxarife();
        listaAlmoxarife = dao.pesquisar("Almoxarife.findByLoginAlmoxarife", new Object[]{login.toLowerCase()});
        aux = listaAlmoxarife.get(0);
        return aux;
    }
        
    public int quantidadeAlmoxarifeSupervisor(Dao dao) {
        listaAlmoxarife = dao.pesquisar("Almoxarife.findAllSupervisor");
        int aux = listaAlmoxarife.size();
        return aux;
    }
    
    private List pequisarTodos(Dao dao) {
        listaAlmoxarife = dao.pesquisar("Almoxarife.findAll");
        return listaAlmoxarife;
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários
     */


    public ModelTabelaAlmoxarife retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaAlmoxarife = new ModelTabelaAlmoxarife(pequisarTodos(dao));
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários com o nome igual ao da pesquisa
     * @param nome: o nome do funcionário a buscar
     */

    public ModelTabelaAlmoxarife preencherTabelaParametroNome(Dao dao, String nome) {
        listaAlmoxarife = dao.pesquisar("Almoxarife.encontrarPorNome", new Object[]{"%" + nome.toLowerCase() + "%"});
        return modelTabelaAlmoxarife = new ModelTabelaAlmoxarife(listaAlmoxarife);
    }
    /*
     * método pra retornar o funcionario do modelTabelaFuncionario no indice passado como parametro
     */

    public Almoxarife retornarAlmoxarifeIndex(int indice) {
        return (Almoxarife) modelTabelaAlmoxarife.getObjectAt(indice);
    }
    // O método gravar retorna um integer que é comparado no frame

    public int gravar(Dao dao, Almoxarife almoxarife) {
        return dao.gravar(almoxarife);
    }
    // O método excluir retorna um integer que é comparado no frame

    public int excluir(Dao dao, Almoxarife almoxarife) {
        return dao.excluir(almoxarife);
    }
}
