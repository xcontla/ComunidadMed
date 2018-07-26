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
@Table(name = "opcion_imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionImagen.findAll", query = "SELECT o FROM OpcionImagen o")
    , @NamedQuery(name = "OpcionImagen.findByIdOpcion", query = "SELECT o FROM OpcionImagen o WHERE o.idOpcion = :idOpcion")
    , @NamedQuery(name = "OpcionImagen.findByCNombreArchvio", query = "SELECT o FROM OpcionImagen o WHERE o.cNombreArchvio = :cNombreArchvio")})
public class OpcionImagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_opcion")
    private Long idOpcion;
    @Size(max = 200)
    @Column(name = "c_nombre_archvio")
    private String cNombreArchvio;
    @JoinColumn(name = "id_opcion", referencedColumnName = "id_opcion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Opcion opcion;

    public OpcionImagen() {
    }

    public OpcionImagen(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Long getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getCNombreArchvio() {
        return cNombreArchvio;
    }

    public void setCNombreArchvio(String cNombreArchvio) {
        this.cNombreArchvio = cNombreArchvio;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
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
        if (!(object instanceof OpcionImagen)) {
            return false;
        }
        OpcionImagen other = (OpcionImagen) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.OpcionImagen[ idOpcion=" + idOpcion + " ]";
    }
    
}
