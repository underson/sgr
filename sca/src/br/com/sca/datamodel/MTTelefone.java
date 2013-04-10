package br.com.sca.datamodel;

import br.com.sca.entidades.Materiais;
import br.com.sca.entidades.Telefone;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anderson
 */
public class MTTelefone extends AbstractTableModel {

    private List<String> colunas;
    private List<Telefone> objetos;

    public MTTelefone(List<Telefone> objetos) {
        this.objetos = objetos;
        nameColumns();
    }

    /*
     * método para nomear as colunas que vão aparecer na tabela
     * (Na ordem em que os nomes forem adicionados eles serão exibidos)
     */
    private void nameColumns() {
        colunas = new ArrayList<String>();
        colunas.add("Tipo");
        colunas.add("Número");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'funcionario.getIdFunc()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            Telefone telefone = objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return telefone.getTipoTelefone();
            } else if (colunaIndex == 1) {
                return telefone.getNumeroTelefone();
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
