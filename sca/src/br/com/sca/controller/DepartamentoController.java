/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.controller;


import br.com.sca.datamodel.ModelTabelaDepartamento;
import br.com.sca.entidades.Departamento;
import br.com.sca.persistencia.Dao;
import java.util.List;

/**
 *
 * @author
 */
public class DepartamentoController {

    private List<Departamento> listaDepartamento;
    private ModelTabelaDepartamento modelTabelaDepartamento;

    public DepartamentoController() {
    }

    private List pequisarTodos(Dao dao) {
        listaDepartamento = dao.pesquisar("Departamento.findAll");
        return listaDepartamento;
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários
     */

    public ModelTabelaDepartamento retornaModelTabelaCompleta(Dao dao) {
        return modelTabelaDepartamento = new ModelTabelaDepartamento(pequisarTodos(dao));
    }
    /*
     * método para preencher o ModelTabelaFuncionario com todos os funcionários com o nome igual ao da pesquisa
     * @param nome: o nome do funcionário a buscar
     */

    public ModelTabelaDepartamento preencherTabelaParametroNome(Dao dao, String nome) {
        listaDepartamento = dao.pesquisar("Departamento.findByNomeDept", new Object[]{"%" + nome.toLowerCase() + "%"});
        return modelTabelaDepartamento = new ModelTabelaDepartamento(listaDepartamento);
    }
    /*
     * método pra retornar o funcionario do modelTabelaFuncionario no indice passado como parametro
     */

    public Departamento retornarDepartamentoIndex(int indice) {
        return (Departamento) modelTabelaDepartamento.getObjectAt(indice);
    }
    // O método gravar retorna um integer que é comparado no frame

    public int gravar(Dao dao, Departamento departamento) {
        return dao.gravar(departamento);
    }
    // O método excluir retorna um integer que é comparado no frame

    public int excluir(Dao dao, Departamento departamento) {
        return dao.excluir(departamento);
    }
}
