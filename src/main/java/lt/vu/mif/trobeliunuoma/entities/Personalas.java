/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.trobeliunuoma.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Karolis
 */
@Entity
@Table(name = "PERSONALAS")
@NamedQueries({
    @NamedQuery(name = "Personalas.findAll", query = "SELECT p FROM Personalas p"),
    @NamedQuery(name = "Personalas.findById", query = "SELECT p FROM Personalas p WHERE p.id = :id"),
    @NamedQuery(name = "Personalas.findByVardas", query = "SELECT p FROM Personalas p WHERE p.vardas = :vardas"),
    @NamedQuery(name = "Personalas.findByPavarde", query = "SELECT p FROM Personalas p WHERE p.pavarde = :pavarde"),
    @NamedQuery(name = "Personalas.findByAsmensNr", query = "SELECT p FROM Personalas p WHERE p.asmensNr = :asmensNr")})
public class Personalas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "VARDAS")
    private String vardas;
    @Size(max = 20)
    @Column(name = "PAVARDE")
    private String pavarde;
    @Column(name = "ASMENS_NR")
    private Integer asmensNr;
    @JoinTable(name = "PERSONALAS_TROBELES", joinColumns = {
        @JoinColumn(name = "PERSONALAS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TROBELE_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Trobeles> trobelesList;

    public Personalas() {
    }

    public Personalas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Integer getAsmensNr() {
        return asmensNr;
    }

    public void setAsmensNr(Integer asmensNr) {
        this.asmensNr = asmensNr;
    }

    public List<Trobeles> getTrobelesList() {
        return trobelesList;
    }

    public void setTrobelesList(List<Trobeles> trobelesList) {
        this.trobelesList = trobelesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personalas)) {
            return false;
        }
        Personalas other = (Personalas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.Personalas[ id=" + id + " ]";
    }
    
}
