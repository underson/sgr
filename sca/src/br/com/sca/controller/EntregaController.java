/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.controller;

import br.com.sca.datamodel.MTItemEntrega;
import br.com.sca.datamodel.MTItemPesquisa;
import br.com.sca.entidades.Compra;
import br.com.sca.entidades.Materiais;
import br.com.sca.entidades.MaterialCompra;
import br.com.sca.entidades.MtCompraEntregue;
import br.com.sca.persistencia.Dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class EntregaController {

    private List<MaterialCompra> listaMaterialParaEntrega;
    private List<MaterialCompra> listaMaterialEntregue;
    private Dao dao;

    public EntregaController() {
        listaMaterialEntregue = new ArrayList<MaterialCompra>();
        dao = new Dao();
    }

    public MTItemEntrega preencherTabelaItemCompraNaoEntregue(Compra compra) {
        List<MaterialCompra> listaMtCompra = new ArrayList<MaterialCompra>(dao.pesquisar("MaterialCompra.encontrarMaterialPorCompra", new Object[]{compra}));
        List<MaterialCompra> listaAux = new ArrayList<MaterialCompra>(listaMtCompra);
        for (MaterialCompra mt : listaAux) {
            int qtdEntregue = 0;
            for (MtCompraEntregue mc : mt.getMtCompraEntregueList()) {
                qtdEntregue = qtdEntregue + mc.getQuatEntregueMce();
            }
            if (mt.getQuantMatcom().intValue() <= qtdEntregue) {
                listaMtCompra.remove(mt);
            }
        }
        listaMaterialParaEntrega = new ArrayList<MaterialCompra>(listaMtCompra);
        return new MTItemEntrega(listaMtCompra);
    }

    public MTItemEntrega removerItemEntrega(MaterialCompra material) {
        listaMaterialParaEntrega.remove(material);
        return new MTItemEntrega(listaMaterialParaEntrega);
    }

    public MTItemEntrega adicionarItemEntrega(MaterialCompra material) {
        if (!listaMaterialParaEntrega.contains(material)) {
            material = (MaterialCompra) dao.encontrar(MaterialCompra.class, material.getIdMatcom());
            listaMaterialParaEntrega.add(material);
            return new MTItemEntrega(listaMaterialParaEntrega);
        } else {
            return new MTItemEntrega(listaMaterialParaEntrega);
        }
    }

    /**
     * método para adicionar um material da compra á lista de materiais entregues
     * @param material: o material a ser acrescentado
     * @param notaFiscal: o numero da nota fiscal da entrega
     * @param dataEntrega: a data da entrega
     * @param adicionarQuant: se o material deve receber a quantidade que falta para finalizar a compra
     * @param quantidade: se o material receber uma quantidade menor que a quantidade para finalizar a compra
     * @return
     */
    public MTItemEntrega adicionarItemEntregue(MaterialCompra material, String notaFiscal, Date dataEntrega, boolean adicionarQuant, int quantidade) {
        int indice = verificarSeMaterialJaEstaNaListaDeMateriais(material, listaMaterialEntregue);
        if (indice != -1) {
            if (adicionarQuant) {
                material = adicionarQuantidadeQueFaltaEntregarAMaterial(notaFiscal, material);
            } else {
                material = adicionarQuatidadeAMtCompraEntregue(notaFiscal, material, quantidade);
            }
            listaMaterialEntregue.remove(indice);
            listaMaterialEntregue.add(indice, material);
            return new MTItemEntrega(listaMaterialEntregue);
        } else {
            if (adicionarQuant) {
                material = adicionarMtCompraEntregueAMaterialNaoEntregue(material, notaFiscal, dataEntrega, true, 0);
            } else {
                material = adicionarMtCompraEntregueAMaterialNaoEntregue(material, notaFiscal, dataEntrega, false, quantidade);
            }
            listaMaterialEntregue.add(material);
            return new MTItemEntrega(listaMaterialEntregue);
        }
    }

    public MTItemEntrega removerItemEntregue(MaterialCompra material, String nrNota) {
        int indice = listaMaterialEntregue.indexOf(material);
        boolean jaTemMaterialEntregue = false;
        List<MtCompraEntregue> lista = new ArrayList<MtCompraEntregue>(material.getMtCompraEntregueList());
        for (MtCompraEntregue mat : lista) {
            if (mat.getIdMce() != null) {
                if (mat.getNrNotaFiscalMce().equals(nrNota)) {
                    jaTemMaterialEntregue = true;
                }
                break;
            }
        }
        if (jaTemMaterialEntregue) {
            listaMaterialEntregue.remove(indice);
            material = (MaterialCompra) dao.encontrar(MaterialCompra.class, material.getIdMatcom());
            listaMaterialEntregue.add(indice, material);
            return new MTItemEntrega(listaMaterialEntregue);
        } else {
            listaMaterialEntregue.remove(material);
            return new MTItemEntrega(listaMaterialEntregue);
        }
    }

    /**
     * adiciona um objeto MtCompraEntregue, á lista destes objetos, no material de compra
     * @param material
     * @param notaFiscal
     * @param dataEntrega
     * @param adicionarQtdFalta: se deve ser incluído o MtCompraEntregue com a quantidade que falta entregar
     * @param qtd: se não for incluído o MtCompraEntregue com a quantidade que falta entregar, será setada esta quantidade
     * @return
     */
    private MaterialCompra adicionarMtCompraEntregueAMaterialNaoEntregue(MaterialCompra material, String notaFiscal, Date dataEntrega, boolean adicionarQtdFalta, int qtd) {
        int quantidadeEntregue = 0;
        MtCompraEntregue entregue = new MtCompraEntregue();
        for (MtCompraEntregue mtEntregue : material.getMtCompraEntregueList()) {
            quantidadeEntregue = quantidadeEntregue + mtEntregue.getQuatEntregueMce();
        }
        if (adicionarQtdFalta) {
            if (quantidadeEntregue < material.getQuantMatcom().intValue()) {
                int qtdFalta = material.getQuantMatcom().intValue() - quantidadeEntregue;
                entregue.setQuatEntregueMce(qtdFalta);
                entregue.setDtEntregaMce(dataEntrega);
                entregue.setNrNotaFiscalMce(notaFiscal);
            }
        } else {
            entregue.setQuatEntregueMce(qtd);
            entregue.setDtEntregaMce(dataEntrega);
            entregue.setNrNotaFiscalMce(notaFiscal);
        }
        material.getMtCompraEntregueList().add(entregue);
        return material;
    }

    /**
     * Método para encontrar materiais de compra já entregues, na mesma compra e com o mesmo
     * número de nota fiscal passados como parâmetros
     * @param compra
     * @param notaFiscal
     * @return
     */
    private List<MaterialCompra> encontrarMateriaisEntregues(Compra compra, String notaFiscal) {
        return dao.pesquisar("MtCompraEntregue.encontrarMtPorCompraENotaFiscal", new Object[]{compra, notaFiscal});
    }

    public MTItemEntrega preencherTabelaComMateriaisJaEntregues(Compra compra, String notaFiscal) {
        return new MTItemEntrega(listaMaterialEntregue = new ArrayList<MaterialCompra>((encontrarMateriaisEntregues(compra, notaFiscal))));
    }

    /**
     * método para verificar se algum objeto Material, na lista de materiaisCompra(param) é igual ao material no materialCompra(param);
     * se encontrar um objeto igual, retorna o indice da lista onde ele se encontra, caso contrário retorna -1
     * @param material
     * @param listaMaterial
     * @return indiceMaterialEncontrado
     */
    private int verificarSeMaterialJaEstaNaListaDeMateriais(MaterialCompra material, List<MaterialCompra> listaMaterial) {
        int indice = -1;
        int indiceLista = 0;
        for (MaterialCompra materialIterado : listaMaterial) {
            if (materialIterado.getMateriais().equals(material.getMateriais())) {
                indice = indiceLista;
            }
            indiceLista++;
        }
        return indice;
    }

    /**
     * método que adiciona á quantidade de Materiais entregues, em MtCompraEntregue que possui o mesmo numero de nota fiscal
     * passado como paramentro, a quantidade que falta entregar para concluir o pedido
     * @param notaFiscal
     * @param material
     * @return
     */
    private MaterialCompra adicionarQuantidadeQueFaltaEntregarAMaterial(String notaFiscal, MaterialCompra material) {
        int quantidadeFaltaEntregar = retornarQuantidadeQueFaltaEntregar(material);
        return adicionarQuatidadeAMtCompraEntregue(notaFiscal, material, quantidadeFaltaEntregar);
    }

    /**
     * adiciona quantidade ao material de MtCompraEntregue do MaterialCompra com o mesmo numero de nota fiscal
     * @param notaFiscal
     * @param material
     * @param qtd
     * @return
     */
    private MaterialCompra adicionarQuatidadeAMtCompraEntregue(String notaFiscal, MaterialCompra material, int qtd) {
        for (MtCompraEntregue mtEntregue : material.getMtCompraEntregueList()) {
            if (mtEntregue.getNrNotaFiscalMce().equals(notaFiscal.trim())) {
                mtEntregue.setQuatEntregueMce(mtEntregue.getQuatEntregueMce() + qtd);
                mtEntregue.setMaterialCompra(material);
                break;
            }
        }
        return material;
    }

    public int retornarQuantidadeQueFaltaEntregar(MaterialCompra material) {
        int quantidadeEntregue = 0;
        for (MtCompraEntregue mtEntregue : material.getMtCompraEntregueList()) {
            quantidadeEntregue = quantidadeEntregue + mtEntregue.getQuatEntregueMce();
        }
        return material.getQuantMatcom().intValue() - quantidadeEntregue;
    }

    /**
     * método que devolve o material de compra encontrado no indice passado como parâmetro, de uma tabela
     * criada com o modelo MTItenntrega
     * @param indice
     * @param modelo
     * @return
     */
    public MaterialCompra pegarMaterialEntregueNoIndice(int indice, MTItemEntrega modelo) {
        return (MaterialCompra) modelo.getObjectAt(indice);
    }

    private List<MtCompraEntregue> encontrarMtCompraEntreguePorNotaFiscal(List<MaterialCompra> materiaisEntregues, String notaFiscal) {
        List<MtCompraEntregue> materiaisDessaNota = new ArrayList<MtCompraEntregue>();
        for (MaterialCompra material : materiaisEntregues) {
            for (MtCompraEntregue materialEntregue : material.getMtCompraEntregueList()) {
                if (materialEntregue.getNrNotaFiscalMce().equals(notaFiscal)) {
                    materialEntregue.setMaterialCompra(material);
                    materiaisDessaNota.add(materialEntregue);
                }
            }
        }
        return materiaisDessaNota;
    }

    private List<MtCompraEntregue> encontrarQuantidadeAAtualizar(List<MtCompraEntregue> materiaisEntregues) {
        for (MtCompraEntregue materialEntregue : materiaisEntregues) {
            if (materialEntregue.getIdMce() != null) {
                int qtdTotal = materialEntregue.getQuatEntregueMce();
                materialEntregue = (MtCompraEntregue) dao.encontrar(MtCompraEntregue.class, materialEntregue.getIdMce());
                materialEntregue.setQuatEntregueMce(qtdTotal - materialEntregue.getQuatEntregueMce());
            }
        }
        return materiaisEntregues;
    }
    public void finalizarEntrega(String notaFiscal) {
        EstoqueController estoque = new EstoqueController();
        List<MtCompraEntregue> lista = encontrarMtCompraEntreguePorNotaFiscal(listaMaterialEntregue, notaFiscal);
        for(MtCompraEntregue cpm : lista){
            dao.gravar(cpm);
        }
        lista = new ArrayList<MtCompraEntregue>(encontrarQuantidadeAAtualizar(lista));
        for(MtCompraEntregue materialEntrega : lista){
            estoque.adicionarQuantidadeDeMaterialAoEstoque(materialEntrega.getMaterialCompra().getMateriais(), materialEntrega.getQuatEntregueMce());
        }
    }

    public MtCompraEntregue retornarMaterialEntregueNoIndice(int indice, MTItemPesquisa modelo){
        return (MtCompraEntregue) modelo.getObjectAt(indice);
    }

    public boolean eAlmoxarifeSuperior(String usuario, String senha){
        if(dao.pesquisar("Almoxarife.findBySenhaLogin", new Object[] {usuario, senha}).isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
    public void estornar (MtCompraEntregue material, int quantidadeAEstornar){
        material.setQuatEntregueMce(material.getQuatEntregueMce() - quantidadeAEstornar);
        material.getMaterialCompra().getMateriais().setQtdEstqMat(material.getMaterialCompra().getMateriais().getQtdEstqMat() - quantidadeAEstornar);
        dao.gravar(material);
        dao.gravar(material.getMaterialCompra().getMateriais());
    }
    
}
