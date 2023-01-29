/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bogdan
 */
@Entity
@Table(name = "mesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesto.findAll", query = "SELECT m FROM Mesto m"),
    @NamedQuery(name = "Mesto.findByIdMesto", query = "SELECT m FROM Mesto m WHERE m.idMesto = :idMesto"),
    @NamedQuery(name = "Mesto.findByPo\u0161tanskiBroj", query = "SELECT m FROM Mesto m WHERE m.po\u0161tanskiBroj = :po\u0161tanskiBroj"),
    @NamedQuery(name = "Mesto.findByNaziv", query = "SELECT m FROM Mesto m WHERE m.naziv = :naziv")})
public class Mesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMesto")
    private Integer idMesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Po\u0161tanskiBroj")
    private String poštanskiBroj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sediste")
    private List<Komitenti> komitentiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mestoFilijale")
    private List<Filijala> filijalaList;

    public Mesto() {
    }

    public Mesto(Integer idMesto) {
        this.idMesto = idMesto;
    }

    public Mesto(Integer idMesto, String poštanskiBroj, String naziv) {
        this.idMesto = idMesto;
        this.poštanskiBroj = poštanskiBroj;
        this.naziv = naziv;
    }

    public Integer getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(Integer idMesto) {
        this.idMesto = idMesto;
    }

    public String getPoštanskiBroj() {
        return poštanskiBroj;
    }

    public void setPoštanskiBroj(String poštanskiBroj) {
        this.poštanskiBroj = poštanskiBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<Komitenti> getKomitentiList() {
        return komitentiList;
    }

    public void setKomitentiList(List<Komitenti> komitentiList) {
        this.komitentiList = komitentiList;
    }

    @XmlTransient
    public List<Filijala> getFilijalaList() {
        return filijalaList;
    }

    public void setFilijalaList(List<Filijala> filijalaList) {
        this.filijalaList = filijalaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesto != null ? idMesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesto)) {
            return false;
        }
        Mesto other = (Mesto) object;
        if ((this.idMesto == null && other.idMesto != null) || (this.idMesto != null && !this.idMesto.equals(other.idMesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mesto[ idMesto=" + idMesto + " ]";
    }
    
}
