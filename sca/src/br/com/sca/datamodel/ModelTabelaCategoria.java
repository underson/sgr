/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.datamodel;

import br.com.sca.entidades.Categoria;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Bruno Gomes
 */
public class ModelTabelaCategoria extends AbstractTableModel{

    private List<String> colunas;
    private List<Categoria> objetos;

    public ModelTabelaCategoria(List<Categoria> objetos) {
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
        colunas.add("Descrição");
        colunas.add("Data de Cadastro");
    }
     /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'categoria.getIdFunc()')
     */

     public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            Categoria categoria = (Categoria) objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return categoria.getIdCateg();
            } else if (colunaIndex == 1) {
                return categoria.getNomeCateg();
            } else if (colunaIndex == 2) {
                return categoria.getDescrCateg();
            } else if (colunaIndex == 3) {
                return new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss").format(categoria.getDtCadCateg());
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
