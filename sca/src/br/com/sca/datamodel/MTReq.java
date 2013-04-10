/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.datamodel;

import br.com.sca.entidades.MaterialRequisicao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gregório Araújo
 */
public class MTReq extends AbstractTableModel{

    private List<String> colunas;
    private List<MaterialRequisicao> objetos;
    int quantidade;

    public MTReq(List<MaterialRequisicao> objetos) {

        this.objetos = objetos;
        nameColumns();
    }

        public List<MaterialRequisicao> getList() {
        return this.objetos;
    }

    /*
     * método para nomear as colunas que vão aparecer na tabela
     * (Na ordem em que os nomes forem adicionados eles serão exibidos)
     */
    private void nameColumns() {
        colunas = new ArrayList<String>();
        colunas.add("Nome");
        colunas.add("Categoria");
        colunas.add("Tipo");
        colunas.add("Quantidade");

    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'materiais.getIdMat()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            MaterialRequisicao materiais = (MaterialRequisicao) objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return materiais.getMateriais().getNomeMat();
            } else if (colunaIndex == 1) {
                return materiais.getMateriais().getCategoria().getNomeCateg();
            } else if (colunaIndex == 2) {
                return materiais.getMateriais().getTipoMat();
            } else if (colunaIndex == 3) {
                return materiais.getQtdMatreq();
            }  else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Object getObjectAt(int linha) {
        return objetos.get(linha);
    }

    @Override
    public String getColumnName(int coluna) {
        String nome = colunas.get(coluna);
        return nome;
    }

    public int getRowCount() {
        return objetos.size();
    }

    public int getColumnCount() {
        return colunas.size();
    }



}
