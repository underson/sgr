/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.datamodel;

import br.com.sca.entidades.MtCompraEntregue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Anderson
 */
public class MTItemPesquisa extends AbstractTableModel {

    private List<String> colunas;
    private List<MtCompraEntregue> objetos;

    public MTItemPesquisa(List<MtCompraEntregue> objetos) {
        this.objetos = objetos;
        nameColumns();
    }

    public List<MtCompraEntregue> getList() {
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
        colunas.add("Qtd Recebida");
        colunas.add("Preço");
        colunas.add("Data Entrega");
    }

    /*
     * Método que preenche a tabela: cada if, else if; define os dados de uma coluna
     * Ex: (colunaIndex 0 vai exibir 'funcionario.getIdFunc()')
     */
    public Object getValueAt(int LinhaIndex, int colunaIndex) {
        if (objetos != null && LinhaIndex >= 0 && LinhaIndex < objetos.size()) {
            MtCompraEntregue materialCompra = objetos.get(LinhaIndex);
            if (colunaIndex == 0) {
                return materialCompra.getMaterialCompra().getMateriais().getNomeMat();
            } else if (colunaIndex == 1) {
                return materialCompra.getMaterialCompra().getMateriais().getTipoMat();
            } else if (colunaIndex == 2) {
                return materialCompra.getMaterialCompra().getQuantMatcom();
            } else if (colunaIndex == 3) {
                return materialCompra.getQuatEntregueMce();
            } else if (colunaIndex == 4) {
                return materialCompra.getMaterialCompra().getPrecoMatcom().toString().replace(".", ",");
            } else if (colunaIndex == 5) {
                return new SimpleDateFormat("E dd/MM/yyyy").format(materialCompra.getMaterialCompra().getCompra().getDataPedidoCompra());
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
