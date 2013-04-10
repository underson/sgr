/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.datamodel;

import br.com.sca.entidades.Almoxarife;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Júnior
 */
public class ModelTabelaAlmoxarife extends AbstractTableModel {

    private List<String> colunas;
    private List<Almoxarife> objetos;

    public ModelTabelaAlmoxarife(List<Almoxarife> objetos) {
        this.objetos = objetos;
        nameColumns();
    }

    /*
     * método para nomear as colunas que vão aparecer na tabela
     * (Na ordem em que os nomes forem adicionados eles serão exibidos)
     */
    private void nameColumns() {
        colunas = new ArrayList<String>();
        colunas.add("Nome");
        colunas.add("CPF");
        colunas.add("Tipo");
        colunas.add("Departamento");
        colunas.add("Situação");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'funcionario.getIdFunc()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            Almoxarife almoxarife = objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return almoxarife.getFuncionario().getNomeFunc();
            } else if (colunaIndex == 1) {
                return almoxarife.getFuncionario().getCpfFunc();
            } else if (colunaIndex == 2) {
                return (almoxarife.getSupervisorAlmoxarife()==true)?"Supervisor":"Almoxarife";
            } else if (colunaIndex == 3) {
                return almoxarife.getFuncionario().getDepartamento().getNomeDept();
            } else if (colunaIndex == 4) {
                return (almoxarife.getAtivoAlmoxarife()==true)?"Ativo":"Desativo";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public int getRowCount() {
        return objetos.size();
    }

    public int getColumnCount() {
        return colunas.size();
    }

    public Object getObjectAt(int linha) {
        return objetos.get(linha);
    }

    @Override
    public String getColumnName(int coluna) {
        String nome = colunas.get(coluna);
        return nome;
    }
}