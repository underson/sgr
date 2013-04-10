/*
 * PedidoController.java
 *
 * Criado em 28/04/2012, 17:42:31
 */
package br.com.sca.controller;

import br.com.sca.datamodel.MTMaterial;
import br.com.sca.datamodel.MTMaterialCompra;
import br.com.sca.datamodel.MTItemEntrega;
import br.com.sca.datamodel.MTItenCompra;
import br.com.sca.entidades.Materiais;
import br.com.sca.entidades.MaterialCompra;
import br.com.sca.persistencia.Dao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Alves
 * @since 
 */
public class PedidoController {

    public static final int MODELO_MATERIAL_COMPLETO = 1;
    public static final int MODELO_MATERIAL_EM_LIMITE = 2;
    private Dao dao;

    public PedidoController() {
        dao = new Dao();
    }

    public MTMaterialCompra pesquisarPorNome(String nome){
        List<MaterialCompra> listaMateriaisPedidos = new ArrayList<MaterialCompra>(dao.pesquisar("MaterialCompra.encontrarPorNomeMaterialLike",  new Object[]{"%" + nome.toLowerCase() + "%"}));
        return new MTMaterialCompra(listaMateriaisPedidos);
    }

    public MTMaterial pesquisarPorNome(String nome, boolean emLimiteEstoque) {
        if (emLimiteEstoque) {
            List<Materiais> listaMateriais = new ArrayList<Materiais>(dao.pesquisar("Materiais.encontrarPorNomeLikeEmLimiteEstoque", new Object[]{"%" + nome.toLowerCase() + "%"}));
            listaMateriais = new ArrayList<Materiais>(eliminaMateriaisPedidos(listaMateriais));
            return new MTMaterial(listaMateriais);
        } else {
            List<Materiais> listaMateriais = new ArrayList<Materiais>(dao.pesquisar("Materiais.encontrarPorNomeLike", new Object[]{"%" + nome.toLowerCase() + "%"}));
            listaMateriais = new ArrayList<Materiais>(eliminaMateriaisPedidos(listaMateriais));
            return new MTMaterial(listaMateriais);
        }
    }

    public boolean realizarPedido(List<Materiais> listaParaPedir) {
        try {
            for (Materiais material : listaParaPedir) {
                MaterialCompra materialCompra = new MaterialCompra();
                materialCompra.setMateriais(material);
                dao.gravar(materialCompra);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean realizarPedido(Materiais material) {
        try {
            MaterialCompra materialCompra = new MaterialCompra();
            materialCompra.setMateriais(material);
            dao.gravar(materialCompra);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Materiais pegarMaterialNoIndice(int indice, MTMaterial modelo) {
        return (Materiais) modelo.getObjectAt(indice);
    }

    public MaterialCompra pegarMaterialCompraNoIndice(int indice, MTMaterialCompra modelo){
        return (MaterialCompra) modelo.getObjectAt(indice);
    }

    public MaterialCompra pegarMaterialCompraNoIndice(int indice, MTItemEntrega modelo){
        return (MaterialCompra) modelo.getObjectAt(indice);
    }

    public MaterialCompra pegarItemCompraNoIndice(int indice, MTItenCompra modelo){
        return (MaterialCompra) modelo.getObjectAt(indice);
    }

    public boolean cancelarPedido(MaterialCompra materialCompra) {
        if ((materialCompra.getCompra() != null) || (materialCompra.getPrecoMatcom() != null) || (materialCompra.getQuantMatcom() != null)) {
            return false;
        } else {
            if (dao.excluir(materialCompra) != Dao.SUCESSO) {
                return false;
            }
            return true;
        }
    }

    private List<Materiais> eliminaMateriaisPedidos(List<Materiais> lista) {
        List<Materiais> listaAuxMateriais = new ArrayList<Materiais>(lista);
        List<MaterialCompra> listaMateriaisPedidos = new ArrayList<MaterialCompra>(dao.pesquisar("MaterialCompra.encontrarMaterialNaoEntregue"));
        List<MaterialCompra> lista2 = dao.pesquisar("MaterialCompra.encontrarMateriaisPedidos");
        for(MaterialCompra mat : lista2){
            listaMateriaisPedidos.add(mat);
        }
        for (MaterialCompra materialCompra : listaMateriaisPedidos) {
            for (Materiais material : listaAuxMateriais) {
                if(material.equals(materialCompra.getMateriais())) {
                    lista.remove(material);
                }
            }
        }
        return lista;
    }

    /**
     * método que pesquisa todos os materiais disponíveis para pedido, ou seja,
     * que ainda não se tornaram materiais de compra pendentes.
     * @return ModelTabelaMaterialNaoPedido : modelo de dados para JTable
     */
    private MTMaterial preencherTabelaComTodos() {
        List<Materiais> listaMateriais = new ArrayList<Materiais>(eliminaMateriaisPedidos(listaMateriais = dao.pesquisar("Materiais.encontrarTodos")));
        return new MTMaterial(listaMateriais);
    }

    /**
     * método que procura todos os materiais em limite de estoque
     * @return ModelTabelaMaterialNaoPedido : modelo de dados para JTable
     */
    private MTMaterial preencherTabelaComMaterialEmLimite() {
        List<Materiais> listaMateriais = new ArrayList<Materiais>(dao.pesquisar("Materiais.encontrarEmLimiteEstoque"));
        listaMateriais = new ArrayList<Materiais>(eliminaMateriaisPedidos(listaMateriais));
        return new MTMaterial(listaMateriais);
    }

    public MTMaterial preencherTabelaComMaterial(int escolha) {
        if (escolha == MODELO_MATERIAL_COMPLETO) {
            return preencherTabelaComTodos();
        } else {
            return preencherTabelaComMaterialEmLimite();
        }
    }

    /**
     * método que preencha a tabela com todos os materiais com pedidos pendentes
     * @return ModelTabelaMaterialPedido : modelo de dados para JTable
     */
    public MTMaterialCompra preencherTabelaComMaterialPedido() {
        List<MaterialCompra> listaMateriaisPedidos = new ArrayList<MaterialCompra>(dao.pesquisar("MaterialCompra.encontrarMateriaisPedidos"));
        return new MTMaterialCompra(listaMateriaisPedidos);
    }
}
