/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.trobeliunuoma.entities;

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
import javax.persistence.Version;

/**
 *
 * @author B
 */
@Entity
@Table(name = "VARTOTOJAS")
@NamedQueries({
    @NamedQuery(name = "Vartotojas.findAll", query = "SELECT v FROM Vartotojas v"),
    @NamedQuery(name = "Vartotojas.findById", query = "SELECT v FROM Vartotojas v WHERE v.id = :id"),
    @NamedQuery(name = "Vartotojas.findByVardas", query = "SELECT v FROM Vartotojas v WHERE v.vardas = :vardas"),
    @NamedQuery(name = "Vartotojas.findByPavarde", query = "SELECT v FROM Vartotojas v WHERE v.pavarde = :pavarde"),
    @NamedQuery(name = "Vartotojas.findByAsmensKodas", query = "SELECT v FROM Vartotojas v WHERE v.asmensKodas = :asmensKodas"),
    @NamedQuery(name = "Vartotojas.findByRankas", query = "SELECT v FROM Vartotojas v WHERE v.rankas = :rankas"),
    @NamedQuery(name = "Vartotojas.findByOptLockVersion", query = "SELECT v FROM Vartotojas v WHERE v.optLockVersion = :optLockVersion")})
public class Vartotojas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VARDAS")
    private String vardas;
    @Column(name = "PAVARDE")
    private String pavarde;
    @Basic(optional = false)
    @Column(name = "ASMENS_KODAS")
    private int asmensKodas;
    @Column(name = "RANKAS")
    private String rankas;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @JoinColumn(name = "PIRMUMO_GRUPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private PirmumoGrupe pirmumoGrupeId;

    public Vartotojas() {
    }

    public Vartotojas(Integer id) {
        this.id = id;
    }

    public Vartotojas(Integer id, int asmensKodas) {
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

    public int getAsmensKodas() {
        return asmensKodas;
    }

    public void setAsmensKodas(int asmensKodas) {
        this.asmensKodas = asmensKodas;
    }

    public String getRankas() {
        return rankas;
    }

    public void setRankas(String rankas) {
        this.rankas = rankas;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public PirmumoGrupe getPirmumoGrupeId() {
        return pirmumoGrupeId;
    }

    public void setPirmumoGrupeId(PirmumoGrupe pirmumoGrupeId) {
        this.pirmumoGrupeId = pirmumoGrupeId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.asmensKodas;
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
        final Vartotojas other = (Vartotojas) obj;
        if (this.asmensKodas != other.asmensKodas) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.Vartotojas[ id=" + id + " ]";
    }
    
}
