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
@Table(name = "categoria")
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCateg", query = "SELECT c FROM Categoria c WHERE c.idCateg = :idCateg"),
    @NamedQuery(name = "Categoria.findByNomeCateg", query = "SELECT c FROM Categoria c WHERE LOWER(c.nomeCateg) LIKE :nomeCateg"),
    @NamedQuery(name = "Categoria.findByDescrCateg", query = "SELECT c FROM Categoria c WHERE c.descrCateg = :descrCateg"),
    @NamedQuery(name = "Categoria.findByDtCadCateg", query = "SELECT c FROM Categoria c WHERE c.dtCadCateg = :dtCadCateg")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categ")
    private Integer idCateg;
    @Basic(optional = false)
    @Column(name = "nome_categ")
    private String nomeCateg;
    @Column(name = "descr_categ")
    private String descrCateg;
    @Basic(optional = false)
    @Column(name = "dt_cad_categ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadCateg;
    @OneToMany(mappedBy = "categoria")
    private List<Materiais> materiaisList;

    public Categoria() {
    }

    public Categoria(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public Integer getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public String getNomeCateg() {
        return nomeCateg;
    }

    public void setNomeCateg(String nomeCateg) {
        this.nomeCateg = nomeCateg;
    }

    public String getDescrCateg() {
        return descrCateg;
    }

    public void setDescrCateg(String descrCateg) {
        this.descrCateg = descrCateg;
    }

    public Date getDtCadCateg() {
        return dtCadCateg;
    }

    public void setDtCadCateg(Date dtCadCateg) {
        this.dtCadCateg = dtCadCateg;
    }

    public List<Materiais> getMateriaisList() {
        return materiaisList;
    }

    public void setMateriaisList(List<Materiais> materiaisList) {
        this.materiaisList = materiaisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCateg != null ? idCateg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCateg == null && other.idCateg != null) || (this.idCateg != null && !this.idCateg.equals(other.idCateg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sca.entidades.Categoria[idCateg=" + idCateg + "]";
    }

}
