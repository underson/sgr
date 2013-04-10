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
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFunc", query = "SELECT f FROM Funcionario f WHERE f.idFunc = :idFunc"),
    @NamedQuery(name = "Funcionario.findByCpfFunc", query = "SELECT f FROM Funcionario f WHERE f.cpfFunc = :cpfFunc"),
    @NamedQuery(name = "Funcionario.findByNomeFunc", query = "SELECT f FROM Funcionario f WHERE LOWER(f.nomeFunc) like :nomeFunc"),
    @NamedQuery(name = "Funcionario.findByDtCadFunc", query = "SELECT f FROM Funcionario f WHERE f.dtCadFunc = :dtCadFunc"),
    /*
     *
     */
     @NamedQuery(name = "Funcionario.findByFuncAtivo", query = "SELECT f FROM Funcionario f WHERE f.ativoFunc = :ativoFunc"),
    @NamedQuery(name = "Funcionario.menosAlmoxarife", query = "SELECT f FROM Funcionario f WHERE f.idFunc NOT IN(SELECT a.funcionario.idFunc FROM Almoxarife a)"),
    @NamedQuery(name = "Funcionario.menosAlmoxarifePorNome", query = "SELECT f FROM Funcionario f WHERE f.idFunc NOT IN(SELECT a.funcionario.idFunc FROM Almoxarife a) AND LOWER(f.nomeFunc) like :nomeFunc"),
    @NamedQuery(name = "Funcionario.findByNomeFunc", query = "SELECT f FROM Funcionario f WHERE LOWER(f.nomeFunc) like :nomeFunc")

})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_func")
    private Integer idFunc;
    @Basic(optional = false)
    @Column(name = "cpf_func")
    private String cpfFunc;
    @Basic(optional = false)
    @Column(name = "nome_func")
    private String nomeFunc;
    @Basic(optional = false)
    @Column(name = "dt_cad_func")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadFunc;
    @Basic(optional = false)
    @Column(name = "ativo_func")
    private boolean ativoFunc;
    @JoinColumn(name = "id_dept_func", referencedColumnName = "id_dept")
    @ManyToOne(optional = false)
    private Departamento departamento;
    @OneToMany(mappedBy = "funcionario")
    private List<Almoxarife> almoxarifeList;
    @OneToMany(mappedBy = "funcionario")
    private List<Requisicao> requisicaoList;

    public Funcionario() {
    }

    public Funcionario(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public boolean isAtivoFunc() {
        return ativoFunc;
    }

    public void setAtivoFunc(boolean ativoFunc) {
        this.ativoFunc = ativoFunc;
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public Date getDtCadFunc() {
        return dtCadFunc;
    }

    public void setDtCadFunc(Date dtCadFunc) {
        this.dtCadFunc = dtCadFunc;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepaartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Almoxarife> getAlmoxarifeList() {
        return almoxarifeList;
    }

    public void setAlmoxarifeList(List<Almoxarife> almoxarifeList) {
        this.almoxarifeList = almoxarifeList;
    }

    public List<Requisicao> getRequisicaoList() {
        return requisicaoList;
    }

    public void setRequisicaoList(List<Requisicao> requisicaoList) {
        this.requisicaoList = requisicaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFunc != null ? idFunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFunc == null && other.idFunc != null) || (this.idFunc != null && !this.idFunc.equals(other.idFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Funcionario[idFunc=" + idFunc + "]";
    }
}
