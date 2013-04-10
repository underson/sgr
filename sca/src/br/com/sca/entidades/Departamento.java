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
import javax.persistence.Lob;
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
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdDept", query = "SELECT d FROM Departamento d WHERE d.idDept = :idDept"),
    @NamedQuery(name = "Departamento.findByNomeDept", query = "SELECT d FROM Departamento d WHERE LOWER(d.nomeDept) LIKE :nomeDept"),
    @NamedQuery(name = "Departamento.findByDtCadDept", query = "SELECT d FROM Departamento d WHERE d.dtCadDept = :dtCadDept")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dept")
    private Integer idDept;
    @Basic(optional = false)
    @Column(name = "nome_dept")
    private String nomeDept;
    @Lob
    @Column(name = "desc_dept")
    private String descDept;
    @Basic(optional = false)
    @Column(name = "ativo_dept")
    private boolean ativoDept;
    @Basic(optional = false)
    @Column(name = "dt_cad_dept")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadDept;
    @OneToMany(mappedBy = "departamento")
    private List<Requisicao> requisicaoList;
    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarioList;

    public Departamento() {
    }

    public Departamento(Integer idDept) {
        this.idDept = idDept;
    }

    public Integer getIdDept() {
        return idDept;
    }

    public boolean isAtivoDept() {
        return ativoDept;
    }

    public void setAtivoDept(boolean ativoDept) {
        this.ativoDept = ativoDept;
    }

    public void setIdDept(Integer idDept) {
        this.idDept = idDept;
    }

    public String getNomeDept() {
        return nomeDept;
    }

    public void setNomeDept(String nomeDept) {
        this.nomeDept = nomeDept;
    }

    public String getDescDept() {
        return descDept;
    }

    public void setDescDept(String descDept) {
        this.descDept = descDept;
    }

    public Date getDtCadDept() {
        return dtCadDept;
    }

    public void setDtCadDept(Date dtCadDept) {
        this.dtCadDept = dtCadDept;
    }

    public List<Requisicao> getRequisicaoList() {
        return requisicaoList;
    }

    public void setRequisicaoList(List<Requisicao> requisicaoList) {
        this.requisicaoList = requisicaoList;
    }
	
	public List<Funcionario> getFuncionarioList(){
		return funcionarioList;
	}
	
	public void setFuncionarioList(List<Funcionario> funcionarioList){
		this.funcionarioList = funcionarioList;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDept != null ? idDept.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDept == null && other.idDept != null) || (this.idDept != null && !this.idDept.equals(other.idDept))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Departamento[idDept=" + idDept + "]";
    }

}
