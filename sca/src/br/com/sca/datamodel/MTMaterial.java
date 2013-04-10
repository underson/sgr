/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.datamodel;

import br.com.sca.entidades.Materiais;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anderson
 */
public class MTMaterial extends AbstractTableModel {

    private List<String> colunas;
    private List<Materiais> objetos;

    public MTMaterial(List<Materiais> objetos) {
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
        colunas.add("Tipo");
        colunas.add("Categoria");
        colunas.add("Estoque");
        colunas.add("Limite Estoque");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'funcionario.getIdFunc()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            Materiais material = objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return material.getNomeMat();
            } else if (colunaIndex == 1) {
                return material.getTipoMat();
            } else if (colunaIndex == 2) {
                return material.getCategoria().getNomeCateg();
            } else if (colunaIndex == 3) {
                return material.getQtdEstqMat();
            } else if (colunaIndex == 4){
                return material.getQtdMinMat();
            }
              else {
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
