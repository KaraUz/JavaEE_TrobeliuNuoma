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
@Table(name = "TROBELES")
@NamedQueries({
    @NamedQuery(name = "Trobeles.findAll", query = "SELECT t FROM Trobeles t"),
    @NamedQuery(name = "Trobeles.findById", query = "SELECT t FROM Trobeles t WHERE t.id = :id"),
    @NamedQuery(name = "Trobeles.findByPavadinimas", query = "SELECT t FROM Trobeles t WHERE t.pavadinimas = :pavadinimas"),
    @NamedQuery(name = "Trobeles.findByKambariuSkaicius", query = "SELECT t FROM Trobeles t WHERE t.kambariuSkaicius = :kambariuSkaicius"),
    @NamedQuery(name = "Trobeles.findByRezervuotas", query = "SELECT t FROM Trobeles t WHERE t.rezervuotas = :rezervuotas")})
public class Trobeles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "PAVADINIMAS")
    private String pavadinimas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KAMBARIU_SKAICIUS")
    private int kambariuSkaicius;
    @Column(name = "REZERVUOTAS")
    private Boolean rezervuotas;
    @ManyToMany(mappedBy = "trobelesList")
    private List<Personalas> personalasList;

    public Trobeles() {
    }

    public Trobeles(Integer id) {
        this.id = id;
    }

    public Trobeles(Integer id, int kambariuSkaicius) {
        this.id = id;
        this.kambariuSkaicius = kambariuSkaicius;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getKambariuSkaicius() {
        return kambariuSkaicius;
    }

    public void setKambariuSkaicius(int kambariuSkaicius) {
        this.kambariuSkaicius = kambariuSkaicius;
    }

    public Boolean getRezervuotas() {
        return rezervuotas;
    }

    public void setRezervuotas(Boolean rezervuotas) {
        this.rezervuotas = rezervuotas;
    }

    public List<Personalas> getPersonalasList() {
        return personalasList;
    }

    public void setPersonalasList(List<Personalas> personalasList) {
        this.personalasList = personalasList;
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
        if (!(object instanceof Trobeles)) {
            return false;
        }
        Trobeles other = (Trobeles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.Trobeles[ id=" + id + " ]";
    }
    
}
