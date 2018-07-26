/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.entity;

import java.io.Serializable;
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
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta")
    , @NamedQuery(name = "Pregunta.findByCPregunta", query = "SELECT p FROM Pregunta p WHERE p.cPregunta = :cPregunta")
    , @NamedQuery(name = "Pregunta.findByBStatus", query = "SELECT p FROM Pregunta p WHERE p.bStatus = :bStatus")
    , @NamedQuery(name = "Pregunta.findByIdExamenPreguntaAndBStatus", query = "SELECT p FROM Pregunta p WHERE p.idExamenPregunta = ?1 and p.bStatus = ?2")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pregunta")
    private Long idPregunta;
    @Size(max = 512)
    @Column(name = "c_pregunta")
    private String cPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pregunta")
    private PreguntaImagen preguntaImagen;
    @JoinColumn(name = "id_examen_pregunta", referencedColumnName = "id_examen_pregunta")
    @ManyToOne(optional = false)
    private ExamenPregunta idExamenPregunta;
    @JoinColumn(name = "id_tipo_dato", referencedColumnName = "id_tipo_dato")
    @ManyToOne(optional = false)
    private CatTipoDato idTipoDato;

    public Pregunta() {
    }

    public Pregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Pregunta(Long idPregunta, boolean bStatus) {
        this.idPregunta = idPregunta;
        this.bStatus = bStatus;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getCPregunta() {
        return cPregunta;
    }

    public void setCPregunta(String cPregunta) {
        this.cPregunta = cPregunta;
    }

    public boolean getBStatus() {
        return bStatus;
    }

    public void setBStatus(boolean bStatus) {
        this.bStatus = bStatus;
    }

    public PreguntaImagen getPreguntaImagen() {
        return preguntaImagen;
    }

    public void setPreguntaImagen(PreguntaImagen preguntaImagen) {
        this.preguntaImagen = preguntaImagen;
    }

    public ExamenPregunta getIdExamenPregunta() {
        return idExamenPregunta;
    }

    public void setIdExamenPregunta(ExamenPregunta idExamenPregunta) {
        this.idExamenPregunta = idExamenPregunta;
    }

    public CatTipoDato getIdTipoDato() {
        return idTipoDato;
    }

    public void setIdTipoDato(CatTipoDato idTipoDato) {
        this.idTipoDato = idTipoDato;
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
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.Pregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
