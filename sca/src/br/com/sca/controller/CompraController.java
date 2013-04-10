package br.com.sca.controller;

import br.com.sca.datamodel.MTCompra;
import br.com.sca.datamodel.MTFornecedor;
import br.com.sca.datamodel.MTMaterialCompra;
import br.com.sca.datamodel.MTItemEntrega;
import br.com.sca.datamodel.MTItemPesquisa;
import br.com.sca.datamodel.MTItenCompra;
import br.com.sca.entidades.Compra;
import br.com.sca.entidades.Fornecedor;
import br.com.sca.entidades.MaterialCompra;
import br.com.sca.entidades.MtCompraEntregue;
import br.com.sca.frames.TelaPrincipal;
import br.com.sca.persistencia.Dao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Anderson
 */
public class CompraController {

    private Dao dao;
    private List<Fornecedor> listaFornecedor;
    private List<MaterialCompra> listaMaterialCompra;
    private List<MaterialCompra> listaMateriaisPedidos;
    private List<Compra> listaCompra;
    private MTFornecedor modeloFornecedor;
    private TelaPrincipal telaPrincipal;

    public CompraController(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        dao = new Dao();
        listaMaterialCompra = new ArrayList<MaterialCompra>();
    }

    public CompraController() {
        dao = new Dao();
        listaMaterialCompra = new ArrayList<MaterialCompra>();
    }

    public MTFornecedor preencherTabela() {
        listaFornecedor = dao.pesquisar("Fornecedor.encontrarTodos");
        return new MTFornecedor(listaFornecedor);
    }

    public MTItenCompra adicionarItemCompra(MaterialCompra material) {
        listaMaterialCompra.add(material);
        return new MTItenCompra(listaMaterialCompra);
    }

    public MTItenCompra removerItemCompra(MaterialCompra material) {
        listaMaterialCompra.remove(material);
        return new MTItenCompra(listaMaterialCompra);
    }

    public MTMaterialCompra adicionarItemPedido(MaterialCompra material) {
        listaMateriaisPedidos.add(material);
        return new MTMaterialCompra(listaMateriaisPedidos);
    }

    public MTMaterialCompra removerItemPedido(MaterialCompra material) {
        listaMateriaisPedidos.remove(material);
        return new MTMaterialCompra(listaMateriaisPedidos);
    }

    public MTMaterialCompra preencherTabelaComMaterialPedido() {
        listaMateriaisPedidos = new ArrayList<MaterialCompra>(dao.pesquisar("MaterialCompra.encontrarMateriaisPedidos"));
        return new MTMaterialCompra(listaMateriaisPedidos);
    }

    public MTMaterialCompra removerMaterialItemCompra(MTMaterialCompra modelo) {
        List<MaterialCompra> lista = modelo.getList();
        List<MaterialCompra> listaAux = new ArrayList<MaterialCompra>(lista);
        for (MaterialCompra material : listaAux) {
            for (MaterialCompra materialCompra : listaMaterialCompra) {
                if (materialCompra.equals(material)) {
                    lista.remove(material);
                }
            }
        }
        return new MTMaterialCompra(lista);
    }

    public MTMaterialCompra pesquisarItemCompra(String pesquisa) {
        List<MaterialCompra> listaMateriais = new ArrayList<MaterialCompra>(listaMaterialCompra);
        List<MaterialCompra> listaAux = new ArrayList<MaterialCompra>(listaMateriais);
        for (MaterialCompra material : listaAux) {
            if (!material.getMateriais().getNomeMat().toLowerCase().contains(pesquisa.toLowerCase())) {
                listaMateriais.remove(material);
            }
        }
        return new MTMaterialCompra(listaMateriais);
    }

    public Fornecedor retornarFornecedorNoIndice(int indice, MTFornecedor modelo) {
        return (Fornecedor) modelo.getObjectAt(indice);
    }

    public MaterialCompra retornarItemEntregaNoIndice(int indice, MTItemEntrega modelo) {
        return (MaterialCompra) modelo.getObjectAt(indice);
    }

    public MTFornecedor pesquisarFornecedorPorRzSc(String nome) {
        listaFornecedor = dao.pesquisar("Fornecedor.encontrarPorRzScLike", new Object[]{"%" + nome.toLowerCase() + "%"});
        modeloFornecedor = new MTFornecedor(listaFornecedor);
        return modeloFornecedor;
    }

    public boolean finalizarVenda(List<MaterialCompra> itensCompra, Date data, Fornecedor fornecedor) {
        Compra compra = new Compra();
        compra.setDataPedidoCompra(data);
        compra.setFornecedor(fornecedor);
        compra.setAlmoxarife(this.telaPrincipal.almoxarife);
        compra = (Compra) dao.gravarObjeto(compra);
        for (MaterialCompra itemCompra : itensCompra) {
            itemCompra.setCompra(compra);
            if (dao.gravar(itemCompra) != Dao.SUCESSO) {
                return false;
            }
        }
        return true;
    }

    public MTCompra preencherTabelaDeCompraAberta() {
        listaCompra = dao.pesquisar("Compra.encontrarTodas");
        return new MTCompra(listaCompra);
    }

    public Compra pegarCompraNoIndice(int indice, MTCompra modeloCompra) {
        return (Compra) modeloCompra.getObjectAt(indice);
    }

    public MTItemEntrega preencherTabelaDeItensCompra(Compra compra) {
        return new MTItemEntrega(compra.getMaterialCompraList());
    }

    public void alterarItemCompra(MaterialCompra material) {
        dao.gravar(material);
    }

    public boolean salvarCompra(Compra compra) {
        if (dao.gravar(compra) == Dao.SUCESSO) {
            return true;
        } else {
            return false;
        }
    }

    public MTItemPesquisa retornarMtCompraEntregue(Compra compra, String nrNotaFiscal) {
        return new MTItemPesquisa(dao.pesquisar("MtCompraEntregue.encontrarMaterialPorCompraENotaFiscal", new Object[]{compra, nrNotaFiscal}));
    }

    public List<String> retornarNrNotasFiscais(Compra compra) {
        List<MtCompraEntregue> listaMateriais = dao.pesquisar("MtCompraEntregue.encontrarMaterialPorCompra", new Object[]{compra});
        Set<String> notas = new HashSet();
        for (MtCompraEntregue material : listaMateriais) {
            notas.add(material.getNrNotaFiscalMce());
        }
        return new ArrayList<String>(notas);
    }

    public String retornarTotalDaEntrega(Compra compra, String nrNotaFiscal) {
        BigDecimal total = new BigDecimal("0.0");
        for (MtCompraEntregue materialEntregue : (List<MtCompraEntregue>) dao.pesquisar("MtCompraEntregue.encontrarMaterialPorCompraENotaFiscal", new Object[]{compra, nrNotaFiscal})) {
            total = total.add(materialEntregue.getMaterialCompra().getPrecoMatcom().multiply(new BigDecimal(materialEntregue.getQuatEntregueMce())));
        }
        return total.setScale(2, RoundingMode.FLOOR).toString().replace(".", ",");
    }

}
