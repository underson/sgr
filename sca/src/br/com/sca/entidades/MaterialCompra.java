/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "material_compra")
@NamedQueries({
    @NamedQuery(name = "MaterialCompra.findAll", query = "SELECT m FROM MaterialCompra m"),
    @NamedQuery(name = "MaterialCompra.findByIdMatcom", query = "SELECT m FROM MaterialCompra m WHERE m.idMatcom = :idMatcom"),
    @NamedQuery(name = "MaterialCompra.findByPrecoMatcom", query = "SELECT m FROM MaterialCompra m WHERE m.precoMatcom = :precoMatcom"),
    @NamedQuery(name = "MaterialCompra.findByQuantMatcom", query = "SELECT m FROM MaterialCompra m WHERE m.quantMatcom = :quantMatcom"),
    /*
     *
     */
    @NamedQuery(name = "MaterialCompra.encontrarMaterialNaoEntregue", query = "SELECT m FROM MaterialCompra m WHERE m.idMatcom NOT IN(SELECT t.materialCompra.idMatcom FROM MtCompraEntregue t)"),
    @NamedQuery(name = "MaterialCompra.encontrarMaterialPorCompra", query = "SELECT m FROM MaterialCompra m WHERE m.compra = :compra"),
    @NamedQuery(name = "MaterialCompra.encontrarPorNomeMaterialLike", query = "SELECT m FROM MaterialCompra m WHERE LOWER(m.materiais.nomeMat) LIKE :nomeMat AND m.compra IS NULL"),
    @NamedQuery(name = "MaterialCompra.encontrarMateriaisPedidos", query = "SELECT m FROM MaterialCompra m WHERE m.compra IS NULL")
})
public class MaterialCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matcom")
    private Integer idMatcom;
    @Column(name = "preco_matcom")
    private BigDecimal precoMatcom;
    @Column(name = "quant_matcom")
    private BigInteger quantMatcom;
    @JoinColumn(name = "compra_id_matcom", referencedColumnName = "id_compra")
    @ManyToOne
    private Compra compra;
    @JoinColumn(name = "id_mat_matcom", referencedColumnName = "id_mat")
    @ManyToOne(optional = false)
    private Materiais materiais;
    @OneToMany(mappedBy = "materialCompra")
    private List<MtCompraEntregue> mtCompraEntregueList;

    public MaterialCompra() {
    }

    public MaterialCompra(Integer idMatcom) {
        this.idMatcom = idMatcom;
    }

    public Integer getIdMatcom() {
        return idMatcom;
    }

    public void setIdMatcom(Integer idMatcom) {
        this.idMatcom = idMatcom;
    }

    public List<MtCompraEntregue> getMtCompraEntregueList() {
        return mtCompraEntregueList;
    }

    public void setMtCompraEntregueList(List<MtCompraEntregue> mtCompraEntregueList) {
        this.mtCompraEntregueList = mtCompraEntregueList;
    }

    public BigDecimal getPrecoMatcom() {
        return precoMatcom;
    }

    public void setPrecoMatcom(BigDecimal precoMatcom) {
        this.precoMatcom = precoMatcom;
    }

    public BigInteger getQuantMatcom() {
        return quantMatcom;
    }

    public void setQuantMatcom(BigInteger quantMatcom) {
        this.quantMatcom = quantMatcom;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Materiais getMateriais() {
        return materiais;
    }

    public void setMateriais(Materiais materiais) {
        this.materiais = materiais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatcom != null ? idMatcom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialCompra)) {
            return false;
        }
        MaterialCompra other = (MaterialCompra) object;
        if ((this.idMatcom == null && other.idMatcom != null) || (this.idMatcom != null && !this.idMatcom.equals(other.idMatcom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.MaterialCompra[idMatcom=" + idMatcom + "]";
    }
}
