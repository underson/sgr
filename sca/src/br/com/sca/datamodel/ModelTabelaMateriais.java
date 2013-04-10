/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.datamodel;

import br.com.sca.entidades.Materiais;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bruno Gomes
 */
public class ModelTabelaMateriais extends AbstractTableModel{

    private List<String> colunas;
    private List<Materiais> objetos;

    public ModelTabelaMateriais(List<Materiais> objetos) {
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
        colunas.add("Nome");
        colunas.add("Qtd em estoque");
        colunas.add("Qtd mínima");
        colunas.add("Tipo de material");
        colunas.add("Descrição");
        colunas.add("Data Cadastro");
        colunas.add("Situação");
        colunas.add("Categoria");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'materiais.getIdMat()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            Materiais materiais = (Materiais) objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return materiais.getIdMat();
            } else if (colunaIndex == 1) {
                return materiais.getNomeMat();
            } else if (colunaIndex == 2) {
                return materiais.getQtdEstqMat();
            } else if (colunaIndex == 3) {
                return materiais.getQtdMinMat();
            } else if (colunaIndex == 4) {
                return materiais.getTipoMat();
            } else if (colunaIndex == 5) {
                return materiais.getDescMat();
            } else if (colunaIndex == 6) {
                return new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(materiais.getDtCadMat());
            } else if (colunaIndex == 7) {
                String aux;
                if(materiais.isAtivoMat() == true){
                    aux = "Ativo";
                }else{
                    aux = "Inativo";
                }
                return aux;
            } else if (colunaIndex == 8) {
                return materiais.getCategoria().getNomeCateg();
            } else {
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
