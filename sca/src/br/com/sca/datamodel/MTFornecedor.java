/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.datamodel;

import br.com.sca.entidades.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anderson
 */
public class MTFornecedor extends AbstractTableModel {

    private List<String> colunas;
    private List<Fornecedor> objetos;

    public MTFornecedor(List<Fornecedor> objetos) {
        this.objetos = objetos;
        nameColumns();
    }

    /*
     * método para nomear as colunas que vão aparecer na tabela
     * (Na ordem em que os nomes forem adicionados eles serão exibidos)
     */
    private void nameColumns() {
        colunas = new ArrayList<String>();
        colunas.add("Razão Social");
        colunas.add("Endereço");
        colunas.add("E-Mail");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'funcionario.getIdFunc()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            Fornecedor fornecedor = objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return fornecedor.getRzSocFornec();
            } else if (colunaIndex == 1) {
                return fornecedor.getEndFornec();
            } else if (colunaIndex == 2) {
                return fornecedor.getEmailFornec();
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
