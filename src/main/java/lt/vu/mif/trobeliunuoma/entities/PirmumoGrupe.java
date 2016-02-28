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
@Table(name = "PIRMUMO_GRUPE")
@NamedQueries({
    @NamedQuery(name = "PirmumoGrupe.findAll", query = "SELECT p FROM PirmumoGrupe p"),
    @NamedQuery(name = "PirmumoGrupe.findById", query = "SELECT p FROM PirmumoGrupe p WHERE p.id = :id"),
    @NamedQuery(name = "PirmumoGrupe.findByPavadinimas", query = "SELECT p FROM PirmumoGrupe p WHERE p.pavadinimas = :pavadinimas"),
    @NamedQuery(name = "PirmumoGrupe.findByPrioritetas", query = "SELECT p FROM PirmumoGrupe p WHERE p.prioritetas = :prioritetas")})
public class PirmumoGrupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PAVADINIMAS")
    private String pavadinimas;
    @Column(name = "PRIORITETAS")
    private Integer prioritetas;
    @OneToMany(mappedBy = "pirmumoGrupeId")
    private List<Vartotojas> vartotojasList;

    public PirmumoGrupe() {
    }

    public PirmumoGrupe(Integer id) {
        this.id = id;
    }

    public PirmumoGrupe(Integer id, String pavadinimas) {
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

    public Integer getPrioritetas() {
        return prioritetas;
    }

    public void setPrioritetas(Integer prioritetas) {
        this.prioritetas = prioritetas;
    }

    public List<Vartotojas> getVartotojasList() {
        return vartotojasList;
    }

    public void setVartotojasList(List<Vartotojas> vartotojasList) {
        this.vartotojasList = vartotojasList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final PirmumoGrupe other = (PirmumoGrupe) obj;
        if (!Objects.equals(this.pavadinimas, other.pavadinimas)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.PirmumoGrupe[ id=" + id + " ]";
    }
    
}
