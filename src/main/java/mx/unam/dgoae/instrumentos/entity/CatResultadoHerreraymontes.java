/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.entity;

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
 * @author UNAM
 */
@Entity
@Table(name = "cat_resultado_herreraymontes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatResultadoHerreraymontes.findAll", query = "SELECT c FROM CatResultadoHerreraymontes c")
    , @NamedQuery(name = "CatResultadoHerreraymontes.findByIdCatHym", query = "SELECT c FROM CatResultadoHerreraymontes c WHERE c.idCatHym = :idCatHym")
    , @NamedQuery(name = "CatResultadoHerreraymontes.findByCAcronimo", query = "SELECT c FROM CatResultadoHerreraymontes c WHERE c.cAcronimo = :cAcronimo")
    , @NamedQuery(name = "CatResultadoHerreraymontes.findByCNombre", query = "SELECT c FROM CatResultadoHerreraymontes c WHERE c.cNombre = :cNombre")
    , @NamedQuery(name = "CatResultadoHerreraymontes.findByBStatus", query = "SELECT c FROM CatResultadoHerreraymontes c WHERE c.bStatus = :bStatus")})
public class CatResultadoHerreraymontes implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatHym")
    private List<CatInterpreHyma> catInterpreHymaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatHym")
    private List<CatInterpreHymi> catInterpreHymiList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cat_hym")
    private Integer idCatHym;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "c_acronimo")
    private String cAcronimo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "c_nombre")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatHym")
    private List<UresoHymInteres> uresoHymInteresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatHym")
    private List<UresoHymAptitud> uresoHymAptitudList;

    public CatResultadoHerreraymontes() {
    }

    public CatResultadoHerreraymontes(Integer idCatHym) {
        this.idCatHym = idCatHym;
    }

    public CatResultadoHerreraymontes(Integer idCatHym, String cAcronimo, String cNombre, boolean bStatus) {
        this.idCatHym = idCatHym;
        this.cAcronimo = cAcronimo;
        this.cNombre = cNombre;
        this.bStatus = bStatus;
    }

    public Integer getIdCatHym() {
        return idCatHym;
    }

    public void setIdCatHym(Integer idCatHym) {
        this.idCatHym = idCatHym;
    }

    public String getCAcronimo() {
        return cAcronimo;
    }

    public void setCAcronimo(String cAcronimo) {
        this.cAcronimo = cAcronimo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public boolean getBStatus() {
        return bStatus;
    }

    public void setBStatus(boolean bStatus) {
        this.bStatus = bStatus;
    }

    @XmlTransient
    public List<UresoHymInteres> getUresoHymInteresList() {
        return uresoHymInteresList;
    }

    public void setUresoHymInteresList(List<UresoHymInteres> uresoHymInteresList) {
        this.uresoHymInteresList = uresoHymInteresList;
    }

    @XmlTransient
    public List<UresoHymAptitud> getUresoHymAptitudList() {
        return uresoHymAptitudList;
    }

    public void setUresoHymAptitudList(List<UresoHymAptitud> uresoHymAptitudList) {
        this.uresoHymAptitudList = uresoHymAptitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatHym != null ? idCatHym.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatResultadoHerreraymontes)) {
            return false;
        }
        CatResultadoHerreraymontes other = (CatResultadoHerreraymontes) object;
        if ((this.idCatHym == null && other.idCatHym != null) || (this.idCatHym != null && !this.idCatHym.equals(other.idCatHym))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.CatResultadoHerreraymontes[ idCatHym=" + idCatHym + " ]";
    }

    @XmlTransient
    public List<CatInterpreHyma> getCatInterpreHymaList() {
        return catInterpreHymaList;
    }

    public void setCatInterpreHymaList(List<CatInterpreHyma> catInterpreHymaList) {
        this.catInterpreHymaList = catInterpreHymaList;
    }

    @XmlTransient
    public List<CatInterpreHymi> getCatInterpreHymiList() {
        return catInterpreHymiList;
    }

    public void setCatInterpreHymiList(List<CatInterpreHymi> catInterpreHymiList) {
        this.catInterpreHymiList = catInterpreHymiList;
    }
    
}
