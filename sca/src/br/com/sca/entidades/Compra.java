/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByDataPedidoCompra", query = "SELECT c FROM Compra c WHERE c.dataPedidoCompra = :dataPedidoCompra"),

    /*
     *
     */
    @NamedQuery(name = "Compra.encontrarTodas", query = "SELECT c FROM Compra c")
})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compra")
    private Integer idCompra;
    @Basic(optional = false)
    @Column(name = "data_pedido_compra")
    @Temporal(TemporalType.DATE)
    private Date dataPedidoCompra;
    @JoinColumn(name = "id_fornec_compra", referencedColumnName = "id_fornec")
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;
    @JoinColumn(name = "id_almoxarife_compra", referencedColumnName = "id_almoxarife")
    @ManyToOne(optional = false)
    private Almoxarife almoxarife;
    @OneToMany(mappedBy = "compra")
    private List<MaterialCompra> materialCompraList;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Date getDataPedidoCompra() {
        return dataPedidoCompra;
    }

    public void setDataPedidoCompra(Date dataPedidoCompra) {
        this.dataPedidoCompra = dataPedidoCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Almoxarife getAlmoxarife() {
        return almoxarife;
    }

    public void setAlmoxarife(Almoxarife almoxarife) {
        this.almoxarife = almoxarife;
    }


    public List<MaterialCompra> getMaterialCompraList() {
        return materialCompraList;
    }

    public void setMaterialCompraList(List<MaterialCompra> materialCompraList) {
        this.materialCompraList = materialCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Compra[idCompra=" + idCompra + "]";
    }

}
