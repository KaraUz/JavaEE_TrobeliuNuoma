/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.trobeliunuoma.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author B
 */
@Entity
@Table(name = "TROBELE")
@NamedQueries({
    @NamedQuery(name = "Trobele.findAll", query = "SELECT t FROM Trobele t"),
    @NamedQuery(name = "Trobele.findById", query = "SELECT t FROM Trobele t WHERE t.id = :id"),
    @NamedQuery(name = "Trobele.findByPavadinimas", query = "SELECT t FROM Trobele t WHERE t.pavadinimas = :pavadinimas"),
    @NamedQuery(name = "Trobele.findByKambariuSkaicius", query = "SELECT t FROM Trobele t WHERE t.kambariuSkaicius = :kambariuSkaicius"),
    @NamedQuery(name = "Trobele.findByRezervuotas", query = "SELECT t FROM Trobele t WHERE t.rezervuotas = :rezervuotas"),
    @NamedQuery(name = "Trobele.findByOptLockVersion", query = "SELECT t FROM Trobele t WHERE t.optLockVersion = :optLockVersion")})
public class Trobele implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PAVADINIMAS")
    private String pavadinimas;
    @Column(name = "KAMBARIU_SKAICIUS")
    private Integer kambariuSkaicius;
    @Column(name = "REZERVUOTAS")
    private Boolean rezervuotas;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @ManyToMany(mappedBy = "trobeleList")
    private List<Personalas> personalasList;

    public Trobele() {
    }

    public Trobele(Integer id) {
        this.id = id;
    }

    public Trobele(Integer id, String pavadinimas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
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

    public Integer getKambariuSkaicius() {
        return kambariuSkaicius;
    }

    public void setKambariuSkaicius(Integer kambariuSkaicius) {
        this.kambariuSkaicius = kambariuSkaicius;
    }

    public Boolean getRezervuotas() {
        return rezervuotas;
    }

    public void setRezervuotas(Boolean rezervuotas) {
        this.rezervuotas = rezervuotas;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Personalas> getPersonalasList() {
        return personalasList;
    }

    public void setPersonalasList(List<Personalas> personalasList) {
        this.personalasList = personalasList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.pavadinimas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trobele other = (Trobele) obj;
        if (!Objects.equals(this.pavadinimas, other.pavadinimas)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.Trobele[ id=" + id + " ]";
    }
    
}
