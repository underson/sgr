/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sca.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.annotations.PrivateOwned;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByIdFornec", query = "SELECT f FROM Fornecedor f WHERE f.idFornec = :idFornec"),
    @NamedQuery(name = "Fornecedor.findByRzSocFornec", query = "SELECT f FROM Fornecedor f WHERE LOWER(f.rzSocFornec) LIKE :rzSocFornec"),
    @NamedQuery(name = "Fornecedor.findByEndFornec", query = "SELECT f FROM Fornecedor f WHERE f.endFornec = :endFornec"),
    @NamedQuery(name = "Fornecedor.findByEmailFornec", query = "SELECT f FROM Fornecedor f WHERE f.emailFornec = :emailFornec"),
    @NamedQuery(name = "Fornecedor.findByCpfCnpjFornec", query = "SELECT f FROM Fornecedor f WHERE f.cpfCnpjFornec = :cpfCnpjFornec"),
    @NamedQuery(name = "Fornecedor.findByDtCadFornec", query = "SELECT f FROM Fornecedor f WHERE f.dtCadFornec = :dtCadFornec"),
    /*
     *
     */
    @NamedQuery(name = "Fornecedor.encontrarTodos", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.encontrarPorRzScLike", query = "SELECT f FROM Fornecedor f WHERE LOWER(f.rzSocFornec) LIKE :rzSocFornec")
     })
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fornec")
    private Integer idFornec;
    @Basic(optional = false)
    @Column(name = "rz_soc_fornec")
    private String rzSocFornec;
    @Basic(optional = false)
    @Column(name = "end_fornec")
    private String endFornec;
    @Column(name = "email_fornec")
    private String emailFornec;
    @Basic(optional = false)
    @Column(name = "cpf_cnpj_fornec")
    private String cpfCnpjFornec;
    @Basic(optional = false)
    @Column(name = "contato_fornec")
    private String contatoFornec;
    @Basic(optional = false)
    @Column(name = "dt_cad_fornec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadFornec;
    @OneToMany(mappedBy = "fornecedor")
    private List<Compra> compraList;
    @PrivateOwned
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    private List<Telefone> telefoneList;

    public Fornecedor() {
    }

    public String getContatoFornec() {
        return contatoFornec;
    }

    public void setContatoFornec(String contatoFornec) {
        this.contatoFornec = contatoFornec;
    }

    public Fornecedor(Integer idFornec) {
        this.idFornec = idFornec;
    }
    

    public Integer getIdFornec() {
        return idFornec;
    }

    public void setIdFornec(Integer idFornec) {
        this.idFornec = idFornec;
    }

    public String getRzSocFornec() {
        return rzSocFornec;
    }

    public void setRzSocFornec(String rzSocFornec) {
        this.rzSocFornec = rzSocFornec;
    }

    public String getEndFornec() {
        return endFornec;
    }

    public void setEndFornec(String endFornec) {
        this.endFornec = endFornec;
    }

    public String getEmailFornec() {
        return emailFornec;
    }

    public void setEmailFornec(String emailFornec) {
        this.emailFornec = emailFornec;
    }

    public String getCpfCnpjFornec() {
        return cpfCnpjFornec;
    }

    public void setCpfCnpjFornec(String cpfCnpjFornec) {
        this.cpfCnpjFornec = cpfCnpjFornec;
    }

    public Date getDtCadFornec() {
        return dtCadFornec;
    }

    public void setDtCadFornec(Date dtCadFornec) {
        this.dtCadFornec = dtCadFornec;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornec != null ? idFornec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornec == null && other.idFornec != null) || (this.idFornec != null && !this.idFornec.equals(other.idFornec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Fornecedor[idFornec=" + idFornec + "]";
    }

}
