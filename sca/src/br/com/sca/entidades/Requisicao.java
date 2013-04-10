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
@Table(name = "requisicao")
@NamedQueries({
    @NamedQuery(name = "Requisicao.findAll", query = "SELECT r FROM Requisicao r"),
    @NamedQuery(name = "Requisicao.findByIdReq", query = "SELECT r FROM Requisicao r WHERE r.idReq = :idReq"),
    @NamedQuery(name = "Requisicao.findByDataReq", query = "SELECT r FROM Requisicao r WHERE r.dataReq = :dataReq")})
public class Requisicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_req")
    private Integer idReq;
    @Basic(optional = false)
    @Column(name = "data_req")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataReq;
    @Column(name = "observacao_req")
    private String observacaoReq;
    @OneToMany(mappedBy = "requisicao")
    private List<MaterialRequisicao> materialRequisicaoList;
    @JoinColumn(name = "id_dept_req", referencedColumnName = "id_dept")
    @ManyToOne(optional = false)
    private Departamento departamento;
    @JoinColumn(name = "id_almoxarife_req", referencedColumnName = "id_almoxarife")
    @ManyToOne(optional = false)
    private Almoxarife almoxarife;
    @JoinColumn(name = "id_func_req", referencedColumnName = "id_func")
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public Requisicao() {
    }

    public Requisicao(Integer idReq) {
        this.idReq = idReq;
    }

    public Integer getIdReq() {
        return idReq;
    }

    public void setIdReq(Integer idReq) {
        this.idReq = idReq;
    }

    public Date getDataReq() {
        return dataReq;
    }

    public void setDataReq(Date dataReq) {
        this.dataReq = dataReq;
    }

    public String getObservacaoReq() {
        return observacaoReq;
    }

    public void setObservacaoReq(String observacaoReq) {
        this.observacaoReq = observacaoReq;
    }

    public List<MaterialRequisicao> getMaterialRequisicaoList() {
        return materialRequisicaoList;
    }

    public void setMaterialRequisicaoList(List<MaterialRequisicao> materialRequisicaoList) {
        this.materialRequisicaoList = materialRequisicaoList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Almoxarife getAlmoxarife() {
        return almoxarife;
    }

    public void setAlmoxarife(Almoxarife almoxarife) {
        this.almoxarife = almoxarife;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReq != null ? idReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.idReq == null && other.idReq != null) || (this.idReq != null && !this.idReq.equals(other.idReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Requisicao[idReq=" + idReq + "]";
    }

}
