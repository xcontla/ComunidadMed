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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "examen_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenPregunta.findAll", query = "SELECT e FROM ExamenPregunta e")
    , @NamedQuery(name = "ExamenPregunta.findByIdExamenPregunta", query = "SELECT e FROM ExamenPregunta e WHERE e.idExamenPregunta = :idExamenPregunta")
    , @NamedQuery(name = "ExamenPregunta.findByCIndice", query = "SELECT e FROM ExamenPregunta e WHERE e.cIndice = :cIndice")
    , @NamedQuery(name = "ExamenPregunta.findByIdExamenAndIdParteAndIdSeccion", query = "SELECT e FROM ExamenPregunta e WHERE e.idExamen = ?1 and e.idParte = ?2 and e.idSeccion = ?3")})
public class ExamenPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_examen_pregunta")
    private Long idExamenPregunta;
    @Size(max = 4)
    @Column(name = "c_indice")
    private String cIndice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamenPregunta")
    private List<Opcion> opcionList;
    @JoinColumn(name = "id_examen", referencedColumnName = "id_examen")
    @ManyToOne(optional = false)
    private CatExamen idExamen;
    @JoinColumn(name = "id_parte", referencedColumnName = "id_parte")
    @ManyToOne(optional = false)
    private CatParte idParte;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion")
    @ManyToOne(optional = false)
    private CatSeccion idSeccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamenPregunta")
    private List<Pregunta> preguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamenPregunta")
    private List<UsuarioRespuesta> usuarioRespuestaList;

    public ExamenPregunta() {
    }

    public ExamenPregunta(Long idExamenPregunta) {
        this.idExamenPregunta = idExamenPregunta;
    }

    public Long getIdExamenPregunta() {
        return idExamenPregunta;
    }

    public void setIdExamenPregunta(Long idExamenPregunta) {
        this.idExamenPregunta = idExamenPregunta;
    }

    public String getCIndice() {
        return cIndice;
    }

    public void setCIndice(String cIndice) {
        this.cIndice = cIndice;
    }

    @XmlTransient
    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
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

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
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
        hash += (idExamenPregunta != null ? idExamenPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenPregunta)) {
            return false;
        }
        ExamenPregunta other = (ExamenPregunta) object;
        if ((this.idExamenPregunta == null && other.idExamenPregunta != null) || (this.idExamenPregunta != null && !this.idExamenPregunta.equals(other.idExamenPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.ExamenPregunta[ idExamenPregunta=" + idExamenPregunta + " ]";
    }

}
