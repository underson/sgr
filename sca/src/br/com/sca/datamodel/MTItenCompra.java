package br.com.sca.datamodel;

import br.com.sca.entidades.MaterialCompra;
import br.com.sca.entidades.MtCompraEntregue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anderson
 */
public class MTItenCompra extends AbstractTableModel {

    private List<String> colunas;
    private List<MaterialCompra> objetos;

    public MTItenCompra(List<MaterialCompra> objetos) {
        this.objetos = objetos;
        nameColumns();
    }

    public List<MaterialCompra> getList() {
        return this.objetos;
    }

    /*
     * método para nomear as colunas que vão aparecer na tabela
     * (Na ordem em que os nomes forem adicionados eles serão exibidos)
     */
    private void nameColumns() {
        colunas = new ArrayList<String>();
        colunas.add("Nome");
        colunas.add("Tipo");
        colunas.add("Qtd Pedida");
        colunas.add("Preço");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'funcionario.getIdFunc()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            MaterialCompra materialCompra = objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return materialCompra.getMateriais().getNomeMat();
            } else if (colunaIndex == 1) {
                return materialCompra.getMateriais().getTipoMat();
            } else if (colunaIndex == 2) {
                return materialCompra.getQuantMatcom();
            } else if (colunaIndex == 3) {
                return materialCompra.getPrecoMatcom().toString().replace(".", ",");
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

