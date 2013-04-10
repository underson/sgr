/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "mt_compra_entregue")
@NamedQueries({
    @NamedQuery(name = "MtCompraEntregue.findAll", query = "SELECT m FROM MtCompraEntregue m"),
    @NamedQuery(name = "MtCompraEntregue.findByIdMce", query = "SELECT m FROM MtCompraEntregue m WHERE m.idMce = :idMce"),
    @NamedQuery(name = "MtCompraEntregue.findByDtEntregaMce", query = "SELECT m FROM MtCompraEntregue m WHERE m.dtEntregaMce = :dtEntregaMce"),
    @NamedQuery(name = "MtCompraEntregue.findByNrNotaFiscalMce", query = "SELECT m FROM MtCompraEntregue m WHERE m.nrNotaFiscalMce = :nrNotaFiscalMce"),
    @NamedQuery(name = "MtCompraEntregue.findByQuatEntregueMce", query = "SELECT m FROM MtCompraEntregue m WHERE m.quatEntregueMce = :quatEntregueMce"),
    
    /*
     *
     */
   
    @NamedQuery(name = "MtCompraEntregue.encontrarMaterialPorCompraENotaFiscal", query = "SELECT m FROM MtCompraEntregue m WHERE m.materialCompra.compra = :compra AND m.nrNotaFiscalMce = :nrNotaFiscalMce"),
    @NamedQuery(name = "MtCompraEntregue.encontrarMtPorCompraENotaFiscal", query = "SELECT m.materialCompra FROM MtCompraEntregue m WHERE m.materialCompra.compra = :compra AND m.nrNotaFiscalMce = :nrNotaFiscalMce"),
    @NamedQuery(name = "MtCompraEntregue.encontrarMaterialPorCompra", query = "SELECT m FROM MtCompraEntregue m WHERE m.materialCompra.compra = :compra")
    })

public class MtCompraEntregue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mce")
    private Integer idMce;
    @Basic(optional = false)
    @Column(name = "dt_entrega_mce")
    @Temporal(TemporalType.DATE)
    private Date dtEntregaMce;
    @Basic(optional = false)
    @Column(name = "nr_nota_fiscal_mce")
    private String nrNotaFiscalMce;
    @Basic(optional = false)
    @Column(name = "quat_entregue_mce")
    private int quatEntregueMce;
    @JoinColumn(name = "id_matcom_mce", referencedColumnName = "id_matcom")
    @ManyToOne(optional = false)
    private MaterialCompra materialCompra;

    public MtCompraEntregue() {
    }

    public MtCompraEntregue(Integer idMce) {
        this.idMce = idMce;
    }

    public Integer getIdMce() {
        return idMce;
    }

    public void setIdMce(Integer idMce) {
        this.idMce = idMce;
    }

    public MaterialCompra getMaterialCompra() {
        return materialCompra;
    }

    public void setMaterialCompra(MaterialCompra materialCompra) {
        this.materialCompra = materialCompra;
    }

    public Date getDtEntregaMce() {
        return dtEntregaMce;
    }

    public void setDtEntregaMce(Date dtEntregaMce) {
        this.dtEntregaMce = dtEntregaMce;
    }

    public String getNrNotaFiscalMce() {
        return nrNotaFiscalMce;
    }

    public void setNrNotaFiscalMce(String nrNotaFiscalMce) {
        this.nrNotaFiscalMce = nrNotaFiscalMce;
    }

    public int getQuatEntregueMce() {
        return quatEntregueMce;
    }

    public void setQuatEntregueMce(int quatEntregueMce) {
        this.quatEntregueMce = quatEntregueMce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMce != null ? idMce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MtCompraEntregue)) {
            return false;
        }
        MtCompraEntregue other = (MtCompraEntregue) object;
        if ((this.idMce == null && other.idMce != null) || (this.idMce != null && !this.idMce.equals(other.idMce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.MtCompraEntregue[idMce=" + idMce + "]";
    }

}
