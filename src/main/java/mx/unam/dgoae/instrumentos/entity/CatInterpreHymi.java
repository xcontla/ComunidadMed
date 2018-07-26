/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "cat_interpre_hymi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatInterpreHymi.findAll", query = "SELECT c FROM CatInterpreHymi c")
    , @NamedQuery(name = "CatInterpreHymi.findByIdItpHymi", query = "SELECT c FROM CatInterpreHymi c WHERE c.idItpHymi = :idItpHymi")
    , @NamedQuery(name = "CatInterpreHymi.findByCAcronimo", query = "SELECT c FROM CatInterpreHymi c WHERE c.cAcronimo = ?1")
    , @NamedQuery(name = "CatInterpreHymi.findByCNombre", query = "SELECT c FROM CatInterpreHymi c WHERE c.cNombre = :cNombre")
    , @NamedQuery(name = "CatInterpreHymi.findByBStatus", query = "SELECT c FROM CatInterpreHymi c WHERE c.bStatus = :bStatus")})
public class CatInterpreHymi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_itp_hymi")
    private Integer idItpHymi;
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
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "c_interpretacion")
    private String cInterpretacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "c_profesiones")
    private String cProfesiones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @JoinColumn(name = "id_cat_hym", referencedColumnName = "id_cat_hym")
    @ManyToOne(optional = false)
    private CatResultadoHerreraymontes idCatHym;

    public CatInterpreHymi() {
    }

    public CatInterpreHymi(Integer idItpHymi) {
        this.idItpHymi = idItpHymi;
    }

    public CatInterpreHymi(Integer idItpHymi, String cAcronimo, String cNombre, String cInterpretacion, String cProfesiones, boolean bStatus) {
        this.idItpHymi = idItpHymi;
        this.cAcronimo = cAcronimo;
        this.cNombre = cNombre;
        this.cInterpretacion = cInterpretacion;
        this.cProfesiones = cProfesiones;
        this.bStatus = bStatus;
    }

    public Integer getIdItpHymi() {
        return idItpHymi;
    }

    public void setIdItpHymi(Integer idItpHymi) {
        this.idItpHymi = idItpHymi;
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

    public String getCInterpretacion() {
        return cInterpretacion;
    }

    public void setCInterpretacion(String cInterpretacion) {
        this.cInterpretacion = cInterpretacion;
    }

    public String getCProfesiones() {
        return cProfesiones;
    }

    public void setCProfesiones(String cProfesiones) {
        this.cProfesiones = cProfesiones;
    }

    public boolean getBStatus() {
        return bStatus;
    }

    public void setBStatus(boolean bStatus) {
        this.bStatus = bStatus;
    }

    public CatResultadoHerreraymontes getIdCatHym() {
        return idCatHym;
    }

    public void setIdCatHym(CatResultadoHerreraymontes idCatHym) {
        this.idCatHym = idCatHym;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItpHymi != null ? idItpHymi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatInterpreHymi)) {
            return false;
        }
        CatInterpreHymi other = (CatInterpreHymi) object;
        if ((this.idItpHymi == null && other.idItpHymi != null) || (this.idItpHymi != null && !this.idItpHymi.equals(other.idItpHymi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.CatInterpreHymi[ idItpHymi=" + idItpHymi + " ]";
    }
    
}
