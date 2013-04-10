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
@Table(name = "telefone")
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t"),
    @NamedQuery(name = "Telefone.findByIdTelefone", query = "SELECT t FROM Telefone t WHERE t.idTelefone = :idTelefone"),
    @NamedQuery(name = "Telefone.findByNumeroTelefone", query = "SELECT t FROM Telefone t WHERE t.numeroTelefone = :numeroTelefone"),
    @NamedQuery(name = "Telefone.findByTipoTelefone", query = "SELECT t FROM Telefone t WHERE t.tipoTelefone = :tipoTelefone")})
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_telefone")
    private Integer idTelefone;
    @Column(name = "numero_telefone")
    private String numeroTelefone;
    @Column(name = "tipo_telefone")
    private String tipoTelefone;
    @JoinColumn(name = "id_fornec_telefone", referencedColumnName = "id_fornec")
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;

    public Telefone() {
    }

    public Telefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefone != null ? idTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.idTelefone == null && other.idTelefone != null) || (this.idTelefone != null && !this.idTelefone.equals(other.idTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Telefone[idTelefone=" + idTelefone + "]";
    }

}
