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
@Table(name = "materiais")
@NamedQueries({
    @NamedQuery(name = "Materiais.findAll", query = "SELECT m FROM Materiais m"),
    @NamedQuery(name = "Materiais.findByIdMat", query = "SELECT m FROM Materiais m WHERE m.idMat = :idMat"),
    @NamedQuery(name = "Materiais.findByNomeMat", query = "SELECT m FROM Materiais m WHERE m.nomeMat = :nomeMat"),
    @NamedQuery(name = "Materiais.findByQtdEstqMat", query = "SELECT m FROM Materiais m WHERE m.qtdEstqMat = :qtdEstqMat"),
    @NamedQuery(name = "Materiais.findByQtdMinMat", query = "SELECT m FROM Materiais m WHERE m.qtdMinMat = :qtdMinMat"),
    @NamedQuery(name = "Materiais.findByTipoMat", query = "SELECT m FROM Materiais m WHERE m.tipoMat = :tipoMat"),
    @NamedQuery(name = "Materiais.findByDescMat", query = "SELECT m FROM Materiais m WHERE m.descMat = :descMat"),
    @NamedQuery(name = "Materiais.findByDtCadMat", query = "SELECT m FROM Materiais m WHERE m.dtCadMat = :dtCadMat"),
    @NamedQuery(name = "Materiais.findByAtivoMat", query = "SELECT m FROM Materiais m WHERE m.ativoMat = :ativoMat"),
    /*
     *
     */
    @NamedQuery(name= "Materiais.encontrarTodosAtivos", query = "SELECT m from Materiais m WHERE m.ativoMat = :ativoMat AND m.qtdEstqMat > '0'"),
    @NamedQuery(name = "Materiais.encontrarTodos", query = "SELECT m FROM Materiais m"),
    @NamedQuery(name = "Materiais.encontrarPorNomeLike", query = "SELECT m FROM Materiais m WHERE LOWER(m.nomeMat) LIKE :nomeMat"),
    @NamedQuery(name = "Materiais.encontrarEmLimiteEstoque", query = "SELECT m FROM Materiais m WHERE m.qtdEstqMat <= m.qtdMinMat"),
    @NamedQuery(name = "Materiais.encontrarPorNomeLikeEmLimiteEstoque", query = "SELECT m FROM Materiais m WHERE LOWER(m.nomeMat) LIKE :nomeMat AND (m.qtdEstqMat <= m.qtdMinMat)")
})
public class Materiais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mat")
    private Integer idMat;
    @Basic(optional = false)
    @Column(name = "nome_mat")
    private String nomeMat;
    @Basic(optional = false)
    @Column(name = "marca_mat")
    private String marcaMat;
    @Basic(optional = false)
    @Column(name = "qtd_estq_mat")
    private long qtdEstqMat;
    @Basic(optional = false)
    @Column(name = "qtd_min_mat")
    private long qtdMinMat;
    @Basic(optional = false)
    @Column(name = "tipo_mat")
    private String tipoMat;
    @Column(name = "desc_mat")
    private String descMat;
    @Basic(optional = false)
    @Column(name = "dt_cad_mat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadMat;
    @Basic(optional = false)
    @Column(name = "ativo_mat")
    private boolean ativoMat;
    @JoinColumn(name = "categ_id_mat", referencedColumnName = "id_categ")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @OneToMany(mappedBy = "materiais")
    private List<MaterialRequisicao> materialRequisicaoList;
    @OneToMany(mappedBy = "materiais")
    private List<MaterialCompra> materialCompraList;

    public Materiais() {
    }

    public String getMarcaMat() {
        return marcaMat;
    }

    public void setMarcaMat(String marcaMat) {
        this.marcaMat = marcaMat;
    }

    public boolean isAtivoMat() {
        return ativoMat;
    }

    public Materiais(Integer idMat) {
        this.idMat = idMat;
    }

    public Integer getIdMat() {
        return idMat;
    }

    public void setIdMat(Integer idMat) {
        this.idMat = idMat;
    }

    public String getNomeMat() {
        return nomeMat;
    }

    public void setNomeMat(String nomeMat) {
        this.nomeMat = nomeMat;
    }

    public long getQtdEstqMat() {
        return qtdEstqMat;
    }

    public void setQtdEstqMat(long qtdEstqMat) {
        this.qtdEstqMat = qtdEstqMat;
    }

    public long getQtdMinMat() {
        return qtdMinMat;
    }

    public void setQtdMinMat(long qtdMinMat) {
        this.qtdMinMat = qtdMinMat;
    }

    public String getTipoMat() {
        return tipoMat;
    }

    public void setTipoMat(String tipoMat) {
        this.tipoMat = tipoMat;
    }

    public String getDescMat() {
        return descMat;
    }

    public void setDescMat(String descMat) {
        this.descMat = descMat;
    }

    public Date getDtCadMat() {
        return dtCadMat;
    }

    public void setDtCadMat(Date dtCadMat) {
        this.dtCadMat = dtCadMat;
    }

    public boolean getAtivoMat() {
        return ativoMat;
    }

    public void setAtivoMat(boolean ativoMat) {
        this.ativoMat = ativoMat;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<MaterialRequisicao> getMaterialRequisicaoList() {
        return materialRequisicaoList;
    }

    public void setMaterialRequisicaoList(List<MaterialRequisicao> materialRequisicaoList) {
        this.materialRequisicaoList = materialRequisicaoList;
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
        hash += (idMat != null ? idMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiais)) {
            return false;
        }
        Materiais other = (Materiais) object;
        if ((this.idMat == null && other.idMat != null) || (this.idMat != null && !this.idMat.equals(other.idMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Materiais[idMat=" + idMat + "]";
    }
}
