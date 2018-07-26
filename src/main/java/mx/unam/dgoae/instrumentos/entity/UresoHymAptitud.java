/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "ureso_hym_aptitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UresoHymAptitud.findAll", query = "SELECT u FROM UresoHymAptitud u")
    , @NamedQuery(name = "UresoHymAptitud.findByIdUresHymAp", query = "SELECT u FROM UresoHymAptitud u WHERE u.idUresHymAp = :idUresHymAp")
    , @NamedQuery(name = "UresoHymAptitud.findByDAplicacion", query = "SELECT u FROM UresoHymAptitud u WHERE u.dAplicacion = :dAplicacion")
    , @NamedQuery(name = "UresoHymAptitud.findByDCreacion", query = "SELECT u FROM UresoHymAptitud u WHERE u.dCreacion = :dCreacion")
    , @NamedQuery(name = "UresoHymAptitud.findByNValor", query = "SELECT u FROM UresoHymAptitud u WHERE u.nValor = :nValor")
    , @NamedQuery(name = "UresoHymAptitud.findByDModificacion", query = "SELECT u FROM UresoHymAptitud u WHERE u.dModificacion = :dModificacion")})
public class UresoHymAptitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ures_hym_ap")
    private Long idUresHymAp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_aplicacion")
    @Temporal(TemporalType.DATE)
    private Date dAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_valor")
    private int nValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dModificacion;
    @JoinColumn(name = "id_cat_hym", referencedColumnName = "id_cat_hym")
    @ManyToOne(optional = false)
    private CatResultadoHerreraymontes idCatHym;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Login idUsuario;

    public UresoHymAptitud() {
    }

    public UresoHymAptitud(Long idUresHymAp) {
        this.idUresHymAp = idUresHymAp;
    }

    public UresoHymAptitud(Long idUresHymAp, Date dAplicacion, Date dCreacion, int nValor, Date dModificacion) {
        this.idUresHymAp = idUresHymAp;
        this.dAplicacion = dAplicacion;
        this.dCreacion = dCreacion;
        this.nValor = nValor;
        this.dModificacion = dModificacion;
    }

    public Long getIdUresHymAp() {
        return idUresHymAp;
    }

    public void setIdUresHymAp(Long idUresHymAp) {
        this.idUresHymAp = idUresHymAp;
    }

    public Date getDAplicacion() {
        return dAplicacion;
    }

    public void setDAplicacion(Date dAplicacion) {
        this.dAplicacion = dAplicacion;
    }

    public Date getDCreacion() {
        return dCreacion;
    }

    public void setDCreacion(Date dCreacion) {
        this.dCreacion = dCreacion;
    }

    public int getNValor() {
        return nValor;
    }

    public void setNValor(int nValor) {
        this.nValor = nValor;
    }

    public Date getDModificacion() {
        return dModificacion;
    }

    public void setDModificacion(Date dModificacion) {
        this.dModificacion = dModificacion;
    }

    public CatResultadoHerreraymontes getIdCatHym() {
        return idCatHym;
    }

    public void setIdCatHym(CatResultadoHerreraymontes idCatHym) {
        this.idCatHym = idCatHym;
    }

    public Login getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Login idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUresHymAp != null ? idUresHymAp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UresoHymAptitud)) {
            return false;
        }
        UresoHymAptitud other = (UresoHymAptitud) object;
        if ((this.idUresHymAp == null && other.idUresHymAp != null) || (this.idUresHymAp != null && !this.idUresHymAp.equals(other.idUresHymAp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.UresoHymAptitud[ idUresHymAp=" + idUresHymAp + " ]";
    }
    
}
