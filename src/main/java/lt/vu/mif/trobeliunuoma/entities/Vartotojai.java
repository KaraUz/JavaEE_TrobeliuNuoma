/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.trobeliunuoma.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VARTOTOJAI")
@NamedQueries({
    @NamedQuery(name = "Vartotojai.findAll", query = "SELECT v FROM Vartotojai v"),
    @NamedQuery(name = "Vartotojai.findById", query = "SELECT v FROM Vartotojai v WHERE v.id = :id"),
    @NamedQuery(name = "Vartotojai.findByVardas", query = "SELECT v FROM Vartotojai v WHERE v.vardas = :vardas"),
    @NamedQuery(name = "Vartotojai.findByPavarde", query = "SELECT v FROM Vartotojai v WHERE v.pavarde = :pavarde"),
    @NamedQuery(name = "Vartotojai.findByAsmensKodas", query = "SELECT v FROM Vartotojai v WHERE v.asmensKodas = :asmensKodas"),
    @NamedQuery(name = "Vartotojai.findByRankas", query = "SELECT v FROM Vartotojai v WHERE v.rankas = :rankas")})
public class Vartotojai implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ASMENS_KODAS")
    private String asmensKodas;
    @Size(max = 20)
    @Column(name = "RANKAS")
    private String rankas;
    @JoinColumn(name = "PIRMUMO_GRUPE", referencedColumnName = "ID")
    @ManyToOne
    private PirmumoGrupes pirmumoGrupe;

    public Vartotojai() {
    }

    public Vartotojai(Integer id) {
        this.id = id;
    }

    public Vartotojai(Integer id, String asmensKodas) {
        this.id = id;
        this.asmensKodas = asmensKodas;
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

    public String getAsmensKodas() {
        return asmensKodas;
    }

    public void setAsmensKodas(String asmensKodas) {
        this.asmensKodas = asmensKodas;
    }

    public String getRankas() {
        return rankas;
    }

    public void setRankas(String rankas) {
        this.rankas = rankas;
    }

    public PirmumoGrupes getPirmumoGrupe() {
        return pirmumoGrupe;
    }

    public void setPirmumoGrupe(PirmumoGrupes pirmumoGrupe) {
        this.pirmumoGrupe = pirmumoGrupe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.asmensKodas);
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
        final Vartotojai other = (Vartotojai) obj;
        if (!Objects.equals(this.asmensKodas, other.asmensKodas)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.Vartotojai[ id=" + id + " ]";
    }
    
}
