/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.entidades;

import java.io.Serializable;
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
@Table(name = "almoxarife")
@NamedQueries({
    @NamedQuery(name = "Almoxarife.findAll", query = "SELECT a FROM Almoxarife a"),
    @NamedQuery(name = "Almoxarife.findAllSupervisor", query = "SELECT a FROM Almoxarife a WHERE a.supervisorAlmoxarife = '1' AND a.ativoAlmoxarife = '1'"),
    @NamedQuery(name = "Almoxarife.findByIdAlmoxarife", query = "SELECT a FROM Almoxarife a WHERE a.idAlmoxarife = :idAlmoxarife"),
    @NamedQuery(name = "Almoxarife.findByLoginAlmoxarife", query = "SELECT a FROM Almoxarife a WHERE a.loginAlmoxarife = :loginAlmoxarife"),
    @NamedQuery(name = "Almoxarife.findBySenhaAlmoxarife", query = "SELECT a FROM Almoxarife a WHERE a.senhaAlmoxarife = :senhaAlmoxarife"),
    @NamedQuery(name = "Almoxarife.findByAtivoAlmoxarife", query = "SELECT a FROM Almoxarife a WHERE a.ativoAlmoxarife = :ativoAlmoxarife"),
    @NamedQuery(name = "Almoxarife.findBySupervisorAlmoxarife", query = "SELECT a FROM Almoxarife a WHERE a.supervisorAlmoxarife = :supervisorAlmoxarife"),
    @NamedQuery(name = "Almoxarife.encontrarPorNome", query = "SELECT a FROM Almoxarife a WHERE LOWER(a.funcionario.nomeFunc) LIKE :nomeFunc"),
    @NamedQuery(name = "Almoxarife.findBySenhaLogin", query = "SELECT a FROM Almoxarife a WHERE a.loginAlmoxarife = :loginAlmoxarife AND a.senhaAlmoxarife = :senhaAlmoxarife")
})
public class Almoxarife implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_almoxarife")
    private Integer idAlmoxarife;
    @Column(name = "login_almoxarife")
    private String loginAlmoxarife;
    @Column(name = "senha_almoxarife")
    private String senhaAlmoxarife;
    @Basic(optional = false)
    @Column(name = "ativo_almoxarife")
    private boolean ativoAlmoxarife;
    @Basic(optional = false)
    @Column(name = "supervisor_almoxarife")
    private boolean supervisorAlmoxarife;
    @JoinColumn(name = "id_func_almoxarife", referencedColumnName = "id_func")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @OneToMany(mappedBy = "almoxarife")
    private List<Requisicao> requisicaoList;

    public Almoxarife() {
    }

    public Almoxarife(Integer idAlmoxarife) {
        this.idAlmoxarife = idAlmoxarife;
    }

    public Integer getIdAlmoxarife() {
        return idAlmoxarife;
    }

    public void setIdAlmoxarife(Integer idAlmoxarife) {
        this.idAlmoxarife = idAlmoxarife;
    }

    public String getLoginAlmoxarife() {
        return loginAlmoxarife;
    }

    public void setLoginAlmoxarife(String loginAlmoxarife) {
        this.loginAlmoxarife = loginAlmoxarife;
    }

    public String getSenhaAlmoxarife() {
        return senhaAlmoxarife;
    }

    public void setSenhaAlmoxarife(String senhaAlmoxarife) {
        this.senhaAlmoxarife = senhaAlmoxarife;
    }

    public boolean getAtivoAlmoxarife() {
        return ativoAlmoxarife;
    }

    public void setAtivoAlmoxarife(boolean ativoAlmoxarife) {
        this.ativoAlmoxarife = ativoAlmoxarife;
    }

    public boolean getSupervisorAlmoxarife() {
        return supervisorAlmoxarife;
    }

    public void setSupervisorAlmoxarife(boolean supervisorAlmoxarife) {
        this.supervisorAlmoxarife = supervisorAlmoxarife;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        hash += (idAlmoxarife != null ? idAlmoxarife.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almoxarife)) {
            return false;
        }
        Almoxarife other = (Almoxarife) object;
        if ((this.idAlmoxarife == null && other.idAlmoxarife != null) || (this.idAlmoxarife != null && !this.idAlmoxarife.equals(other.idAlmoxarife))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Almoxarife[idAlmoxarife=" + idAlmoxarife + "]";
    }

}
