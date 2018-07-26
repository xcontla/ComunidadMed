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
@Table(name = "ureso_hym_interes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UresoHymInteres.findAll", query = "SELECT u FROM UresoHymInteres u")
    , @NamedQuery(name = "UresoHymInteres.findByIdUresHymInt", query = "SELECT u FROM UresoHymInteres u WHERE u.idUresHymInt = :idUresHymInt")
    , @NamedQuery(name = "UresoHymInteres.findByDAplicacion", query = "SELECT u FROM UresoHymInteres u WHERE u.dAplicacion = :dAplicacion")
    , @NamedQuery(name = "UresoHymInteres.findByDCreacion", query = "SELECT u FROM UresoHymInteres u WHERE u.dCreacion = :dCreacion")
    , @NamedQuery(name = "UresoHymInteres.findByNValor", query = "SELECT u FROM UresoHymInteres u WHERE u.nValor = :nValor")
    , @NamedQuery(name = "UresoHymInteres.findByDModificacion", query = "SELECT u FROM UresoHymInteres u WHERE u.dModificacion = :dModificacion")})
public class UresoHymInteres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ures_hym_int")
    private Long idUresHymInt;
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

    public UresoHymInteres() {
    }

    public UresoHymInteres(Long idUresHymInt) {
        this.idUresHymInt = idUresHymInt;
    }

    public UresoHymInteres(Long idUresHymInt, Date dAplicacion, Date dCreacion, int nValor, Date dModificacion) {
        this.idUresHymInt = idUresHymInt;
        this.dAplicacion = dAplicacion;
        this.dCreacion = dCreacion;
        this.nValor = nValor;
        this.dModificacion = dModificacion;
    }

    public Long getIdUresHymInt() {
        return idUresHymInt;
    }

    public void setIdUresHymInt(Long idUresHymInt) {
        this.idUresHymInt = idUresHymInt;
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
        hash += (idUresHymInt != null ? idUresHymInt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UresoHymInteres)) {
            return false;
        }
        UresoHymInteres other = (UresoHymInteres) object;
        if ((this.idUresHymInt == null && other.idUresHymInt != null) || (this.idUresHymInt != null && !this.idUresHymInt.equals(other.idUresHymInt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.UresoHymInteres[ idUresHymInt=" + idUresHymInt + " ]";
    }
    
}
