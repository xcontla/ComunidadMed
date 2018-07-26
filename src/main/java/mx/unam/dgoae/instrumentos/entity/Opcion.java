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
import javax.persistence.OneToOne;
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
@Table(name = "opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
    , @NamedQuery(name = "Opcion.findByIdOpcion", query = "SELECT o FROM Opcion o WHERE o.idOpcion = :idOpcion")
    , @NamedQuery(name = "Opcion.findByCPosIndice", query = "SELECT o FROM Opcion o WHERE o.cPosIndice = :cPosIndice")
    , @NamedQuery(name = "Opcion.findByCOpcion", query = "SELECT o FROM Opcion o WHERE o.cOpcion = :cOpcion")
    , @NamedQuery(name = "Opcion.findByNValor", query = "SELECT o FROM Opcion o WHERE o.nValor = :nValor")
    , @NamedQuery(name = "Opcion.findByBStatus", query = "SELECT o FROM Opcion o WHERE o.bStatus = :bStatus")
    , @NamedQuery(name = "Opcion.findByIdExamenPreguntaAndBStatus", query = "SELECT o FROM Opcion o WHERE o.idExamenPregunta = ?1 and o.bStatus = ?2")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private Long idOpcion;
    @Size(max = 3)
    @Column(name = "c_pos_indice")
    private String cPosIndice;
    @Size(max = 200)
    @Column(name = "c_opcion")
    private String cOpcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_valor")
    private int nValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @JoinColumn(name = "id_examen_pregunta", referencedColumnName = "id_examen_pregunta")
    @ManyToOne(optional = false)
    private ExamenPregunta idExamenPregunta;
    @JoinColumn(name = "id_tipo_dato", referencedColumnName = "id_tipo_dato")
    @ManyToOne
    private CatTipoDato idTipoDato;
    @OneToMany(mappedBy = "idOpcion")
    private List<UsuarioRespuesta> usuarioRespuestaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "opcion")
    private OpcionImagen opcionImagen;

    public Opcion() {
    }

    public Opcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Opcion(Long idOpcion, int nValor, boolean bStatus) {
        this.idOpcion = idOpcion;
        this.nValor = nValor;
        this.bStatus = bStatus;
    }

    public Long getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getCPosIndice() {
        return cPosIndice;
    }

    public void setCPosIndice(String cPosIndice) {
        this.cPosIndice = cPosIndice;
    }

    public String getCOpcion() {
        return cOpcion;
    }

    public void setCOpcion(String cOpcion) {
        this.cOpcion = cOpcion;
    }

    public int getNValor() {
        return nValor;
    }

    public void setNValor(int nValor) {
        this.nValor = nValor;
    }

    public boolean getBStatus() {
        return bStatus;
    }

    public void setBStatus(boolean bStatus) {
        this.bStatus = bStatus;
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

    @XmlTransient
    public List<UsuarioRespuesta> getUsuarioRespuestaList() {
        return usuarioRespuestaList;
    }

    public void setUsuarioRespuestaList(List<UsuarioRespuesta> usuarioRespuestaList) {
        this.usuarioRespuestaList = usuarioRespuestaList;
    }

    public OpcionImagen getOpcionImagen() {
        return opcionImagen;
    }

    public void setOpcionImagen(OpcionImagen opcionImagen) {
        this.opcionImagen = opcionImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.Opcion[ idOpcion=" + idOpcion + " ]";
    }
    
}
