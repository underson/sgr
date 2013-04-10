/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "material_requisicao")
@NamedQueries({
    @NamedQuery(name = "MaterialRequisicao.findAll", query = "SELECT m FROM MaterialRequisicao m"),
    @NamedQuery(name = "MaterialRequisicao.encontrarPorNomeLike", query = "SELECT m FROM MaterialRequisicao m WHERE LOWER(m.materiais.nomeMat) LIKE :nomeMat"),
    @NamedQuery(name = "MaterialRequisicao.findByIdMatreq", query = "SELECT m FROM MaterialRequisicao m WHERE m.idMatreq = :idMatreq"),
    @NamedQuery(name = "MaterialRequisicao.findByQtdMatreq", query = "SELECT m FROM MaterialRequisicao m WHERE m.qtdMatreq = :qtdMatreq")})
public class MaterialRequisicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matreq")
    private Integer idMatreq;
    @Basic(optional = false)
    @Column(name = "qtd_matreq")
    private long qtdMatreq;
    @JoinColumn(name = "id_mat_matreq", referencedColumnName = "id_mat")
    @ManyToOne(optional = false)
    private Materiais materiais;
    @JoinColumn(name = "id_req_matreq", referencedColumnName = "id_req")
    @ManyToOne(optional = false)
    private Requisicao requisicao;

    public MaterialRequisicao() {
    }

    public MaterialRequisicao(Integer idMatreq) {
        this.idMatreq = idMatreq;
    }

    public Integer getIdMatreq() {
        return idMatreq;
    }

    public void setIdMatreq(Integer idMatreq) {
        this.idMatreq = idMatreq;
    }

    public long getQtdMatreq() {
        return qtdMatreq;
    }

    public void setQtdMatreq(long qtdMatreq) {
        this.qtdMatreq = qtdMatreq;
    }

    public Materiais getMateriais() {
        return materiais;
    }

    public void setMateriais(Materiais materiais) {
        this.materiais = materiais;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatreq != null ? idMatreq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialRequisicao)) {
            return false;
        }
        MaterialRequisicao other = (MaterialRequisicao) object;
        if ((this.idMatreq == null && other.idMatreq != null) || (this.idMatreq != null && !this.idMatreq.equals(other.idMatreq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.MaterialRequisicao[idMatreq=" + idMatreq + "]";
    }

}
