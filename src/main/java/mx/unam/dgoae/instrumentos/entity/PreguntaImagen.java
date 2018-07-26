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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "pregunta_imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaImagen.findAll", query = "SELECT p FROM PreguntaImagen p")
    , @NamedQuery(name = "PreguntaImagen.findByIdPregunta", query = "SELECT p FROM PreguntaImagen p WHERE p.idPregunta = :idPregunta")
    , @NamedQuery(name = "PreguntaImagen.findByCNombreArchvio", query = "SELECT p FROM PreguntaImagen p WHERE p.cNombreArchvio = :cNombreArchvio")})
public class PreguntaImagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pregunta")
    private Long idPregunta;
    @Size(max = 200)
    @Column(name = "c_nombre_archvio")
    private String cNombreArchvio;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pregunta pregunta;

    public PreguntaImagen() {
    }

    public PreguntaImagen(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getCNombreArchvio() {
        return cNombreArchvio;
    }

    public void setCNombreArchvio(String cNombreArchvio) {
        this.cNombreArchvio = cNombreArchvio;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaImagen)) {
            return false;
        }
        PreguntaImagen other = (PreguntaImagen) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.PreguntaImagen[ idPregunta=" + idPregunta + " ]";
    }
    
}
