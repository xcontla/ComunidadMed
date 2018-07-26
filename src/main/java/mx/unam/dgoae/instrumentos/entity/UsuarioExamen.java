/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "usuario_examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioExamen.findAll", query = "SELECT u FROM UsuarioExamen u")
    , @NamedQuery(name = "UsuarioExamen.findByIdUsuarioExamen", query = "SELECT u FROM UsuarioExamen u WHERE u.idUsuarioExamen = :idUsuarioExamen")
    , @NamedQuery(name = "UsuarioExamen.findByDCreacion", query = "SELECT u FROM UsuarioExamen u WHERE u.dCreacion = :dCreacion")
    , @NamedQuery(name = "UsuarioExamen.findByDModificacion", query = "SELECT u FROM UsuarioExamen u WHERE u.dModificacion = :dModificacion")})
public class UsuarioExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_examen")
    private Integer idUsuarioExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dModificacion;
    @JoinColumn(name = "id_examen", referencedColumnName = "id_examen")
    @ManyToOne(optional = false)
    private CatExamen idExamen;
    @JoinColumn(name = "id_parte", referencedColumnName = "id_parte")
    @ManyToOne(optional = false)
    private CatParte idParte;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion")
    @ManyToOne(optional = false)
    private CatSeccion idSeccion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Login idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioExamen")
    private List<UsuarioRespuesta> usuarioRespuestaList;

    public UsuarioExamen() {
    }

    public UsuarioExamen(Integer idUsuarioExamen) {
        this.idUsuarioExamen = idUsuarioExamen;
    }

    public UsuarioExamen(Integer idUsuarioExamen, Date dCreacion, Date dModificacion) {
        this.idUsuarioExamen = idUsuarioExamen;
        this.dCreacion = dCreacion;
        this.dModificacion = dModificacion;
    }

    public Integer getIdUsuarioExamen() {
        return idUsuarioExamen;
    }

    public void setIdUsuarioExamen(Integer idUsuarioExamen) {
        this.idUsuarioExamen = idUsuarioExamen;
    }

    public Date getDCreacion() {
        return dCreacion;
    }

    public void setDCreacion(Date dCreacion) {
        this.dCreacion = dCreacion;
    }

    public Date getDModificacion() {
        return dModificacion;
    }

    public void setDModificacion(Date dModificacion) {
        this.dModificacion = dModificacion;
    }

    public CatExamen getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(CatExamen idExamen) {
        this.idExamen = idExamen;
    }

    public CatParte getIdParte() {
        return idParte;
    }

    public void setIdParte(CatParte idParte) {
        this.idParte = idParte;
    }

    public CatSeccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(CatSeccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Login getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Login idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<UsuarioRespuesta> getUsuarioRespuestaList() {
        return usuarioRespuestaList;
    }

    public void setUsuarioRespuestaList(List<UsuarioRespuesta> usuarioRespuestaList) {
        this.usuarioRespuestaList = usuarioRespuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioExamen != null ? idUsuarioExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioExamen)) {
            return false;
        }
        UsuarioExamen other = (UsuarioExamen) object;
        if ((this.idUsuarioExamen == null && other.idUsuarioExamen != null) || (this.idUsuarioExamen != null && !this.idUsuarioExamen.equals(other.idUsuarioExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.UsuarioExamen[ idUsuarioExamen=" + idUsuarioExamen + " ]";
    }
    
}
