/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.datamodel;

import br.com.sca.entidades.Funcionario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 
 */
public class ModelTabelaFuncionario extends AbstractTableModel {

    private List<String> colunas;
    private List<Funcionario> objetos;

    public ModelTabelaFuncionario(List<Funcionario> objetos) {
        this.objetos = objetos;
        nameColumns();
    }

    /*
     * método para nomear as colunas que vão aparecer na tabela
     * (Na ordem em que os nomes forem adicionados eles serão exibidos)
     */
    private void nameColumns() {
        colunas = new ArrayList<String>();
        colunas.add("Código");
        colunas.add("CPF");
        colunas.add("Nome");
        colunas.add("Data de Cadastro");
        colunas.add("Ativo");
        colunas.add("Departamento");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'funcionario.getIdFunc()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            Funcionario funcionario = (Funcionario) objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return funcionario.getIdFunc();
            } else if (colunaIndex == 1) {
                return funcionario.getCpfFunc();
            } else if (colunaIndex == 2) {
                return funcionario.getNomeFunc();
            } else if (colunaIndex == 3) {
                return new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(funcionario.getDtCadFunc());
            }  else if (colunaIndex == 4) {
                return funcionario.isAtivoFunc() == true? "Ativo" : "Inativo";
            }  else if (colunaIndex == 5) {
                return funcionario.getDepartamento().getNomeDept();
            }

            return null;
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
