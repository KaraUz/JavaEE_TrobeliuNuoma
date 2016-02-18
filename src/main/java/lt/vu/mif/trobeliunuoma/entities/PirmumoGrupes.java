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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Karolis
 */
@Entity
@Table(name = "PIRMUMO_GRUPES")
@NamedQueries({
    @NamedQuery(name = "PirmumoGrupes.findAll", query = "SELECT p FROM PirmumoGrupes p"),
    @NamedQuery(name = "PirmumoGrupes.findById", query = "SELECT p FROM PirmumoGrupes p WHERE p.id = :id"),
    @NamedQuery(name = "PirmumoGrupes.findByPrioritetas", query = "SELECT p FROM PirmumoGrupes p WHERE p.prioritetas = :prioritetas"),
    @NamedQuery(name = "PirmumoGrupes.findByPavadinimas", query = "SELECT p FROM PirmumoGrupes p WHERE p.pavadinimas = :pavadinimas")})
public class PirmumoGrupes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIORITETAS")
    private int prioritetas;
    @Size(max = 20)
    @Column(name = "PAVADINIMAS")
    private String pavadinimas;
    @OneToMany(mappedBy = "pirmumoGrupe")
    private List<Vartotojai> vartotojaiList;

    public PirmumoGrupes() {
    }

    public PirmumoGrupes(Integer id) {
        this.id = id;
    }

    public PirmumoGrupes(Integer id, int prioritetas) {
        this.id = id;
        this.prioritetas = prioritetas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrioritetas() {
        return prioritetas;
    }

    public void setPrioritetas(int prioritetas) {
        this.prioritetas = prioritetas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<Vartotojai> getVartotojaiList() {
        return vartotojaiList;
    }

    public void setVartotojaiList(List<Vartotojai> vartotojaiList) {
        this.vartotojaiList = vartotojaiList;
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
        if (!(object instanceof PirmumoGrupes)) {
            return false;
        }
        PirmumoGrupes other = (PirmumoGrupes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.PirmumoGrupes[ id=" + id + " ]";
    }
    
}
