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
@Table(name = "usuario_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRespuesta.findAll", query = "SELECT u FROM UsuarioRespuesta u")
    , @NamedQuery(name = "UsuarioRespuesta.findByIdUsuarioRespuesta", query = "SELECT u FROM UsuarioRespuesta u WHERE u.idUsuarioRespuesta = :idUsuarioRespuesta")
    , @NamedQuery(name = "UsuarioRespuesta.findByDCreacion", query = "SELECT u FROM UsuarioRespuesta u WHERE u.dCreacion = :dCreacion")
    , @NamedQuery(name = "UsuarioRespuesta.findByDModificacion", query = "SELECT u FROM UsuarioRespuesta u WHERE u.dModificacion = :dModificacion")})
public class UsuarioRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_respuesta")
    private Long idUsuarioRespuesta;
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
    @JoinColumn(name = "id_usuario_examen", referencedColumnName = "id_usuario_examen")
    @ManyToOne(optional = false)
    private UsuarioExamen idUsuarioExamen;
    @JoinColumn(name = "id_examen_pregunta", referencedColumnName = "id_examen_pregunta")
    @ManyToOne(optional = false)
    private ExamenPregunta idExamenPregunta;
    @JoinColumn(name = "id_opcion", referencedColumnName = "id_opcion")
    @ManyToOne
    private Opcion idOpcion;

    public UsuarioRespuesta() {
    }

    public UsuarioRespuesta(Long idUsuarioRespuesta) {
        this.idUsuarioRespuesta = idUsuarioRespuesta;
    }

    public UsuarioRespuesta(Long idUsuarioRespuesta, Date dCreacion, Date dModificacion) {
        this.idUsuarioRespuesta = idUsuarioRespuesta;
        this.dCreacion = dCreacion;
        this.dModificacion = dModificacion;
    }

    public Long getIdUsuarioRespuesta() {
        return idUsuarioRespuesta;
    }

    public void setIdUsuarioRespuesta(Long idUsuarioRespuesta) {
        this.idUsuarioRespuesta = idUsuarioRespuesta;
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

    public UsuarioExamen getIdUsuarioExamen() {
        return idUsuarioExamen;
    }

    public void setIdUsuarioExamen(UsuarioExamen idUsuarioExamen) {
        this.idUsuarioExamen = idUsuarioExamen;
    }

    public ExamenPregunta getIdExamenPregunta() {
        return idExamenPregunta;
    }

    public void setIdExamenPregunta(ExamenPregunta idExamenPregunta) {
        this.idExamenPregunta = idExamenPregunta;
    }

    public Opcion getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Opcion idOpcion) {
        this.idOpcion = idOpcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioRespuesta != null ? idUsuarioRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRespuesta)) {
            return false;
        }
        UsuarioRespuesta other = (UsuarioRespuesta) object;
        if ((this.idUsuarioRespuesta == null && other.idUsuarioRespuesta != null) || (this.idUsuarioRespuesta != null && !this.idUsuarioRespuesta.equals(other.idUsuarioRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.UsuarioRespuesta[ idUsuarioRespuesta=" + idUsuarioRespuesta + " ]";
    }
    
}
