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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "PERSONALAS")
@NamedQueries({
    @NamedQuery(name = "Personalas.findAll", query = "SELECT p FROM Personalas p"),
    @NamedQuery(name = "Personalas.findById", query = "SELECT p FROM Personalas p WHERE p.id = :id"),
    @NamedQuery(name = "Personalas.findByVardas", query = "SELECT p FROM Personalas p WHERE p.vardas = :vardas"),
    @NamedQuery(name = "Personalas.findByPavarde", query = "SELECT p FROM Personalas p WHERE p.pavarde = :pavarde"),
    @NamedQuery(name = "Personalas.findByAsmensKodas", query = "SELECT p FROM Personalas p WHERE p.asmensKodas = :asmensKodas"),
    @NamedQuery(name = "Personalas.findByOptLockVersion", query = "SELECT p FROM Personalas p WHERE p.optLockVersion = :optLockVersion")})
public class Personalas implements Serializable {

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
    private String asmensKodas;
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @JoinTable(name = "PERSONALAS_TROBELE", joinColumns = {
        @JoinColumn(name = "PERSONALAS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TROBELE_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Trobele> trobeleList;

    public Personalas() {
    }

    public Personalas(Integer id) {
        this.id = id;
    }

    public Personalas(Integer id, String asmensKodas) {
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

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Trobele> getTrobeleList() {
        return trobeleList;
    }

    public void setTrobeleList(List<Trobele> trobeleList) {
        this.trobeleList = trobeleList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.asmensKodas);
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
        final Personalas other = (Personalas) obj;
        if (!Objects.equals(this.asmensKodas, other.asmensKodas)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "lt.vu.mif.trobeliunuoma.entities.Personalas[ id=" + id + " ]";
    }
    
}
