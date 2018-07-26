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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "cat_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatSeccion.findAll", query = "SELECT c FROM CatSeccion c")
    , @NamedQuery(name = "CatSeccion.findByIdSeccion", query = "SELECT c FROM CatSeccion c WHERE c.idSeccion = :idSeccion")
    , @NamedQuery(name = "CatSeccion.findByCnombreSeccion", query = "SELECT c FROM CatSeccion c WHERE c.cnombreSeccion = :cnombreSeccion")
    , @NamedQuery(name = "CatSeccion.findByBStatus", query = "SELECT c FROM CatSeccion c WHERE c.bStatus = :bStatus")})
public class CatSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seccion")
    private Integer idSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_nombreSeccion")
    private String cnombreSeccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeccion")
    private List<ExamenPregunta> examenPreguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeccion")
    private List<UsuarioExamen> usuarioExamenList;

    public CatSeccion() {
    }

    public CatSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public CatSeccion(Integer idSeccion, String cnombreSeccion, boolean bStatus) {
        this.idSeccion = idSeccion;
        this.cnombreSeccion = cnombreSeccion;
        this.bStatus = bStatus;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getCnombreSeccion() {
        return cnombreSeccion;
    }

    public void setCnombreSeccion(String cnombreSeccion) {
        this.cnombreSeccion = cnombreSeccion;
    }

    public boolean getBStatus() {
        return bStatus;
    }

    public void setBStatus(boolean bStatus) {
        this.bStatus = bStatus;
    }

    @XmlTransient
    public List<ExamenPregunta> getExamenPreguntaList() {
        return examenPreguntaList;
    }

    public void setExamenPreguntaList(List<ExamenPregunta> examenPreguntaList) {
        this.examenPreguntaList = examenPreguntaList;
    }

    @XmlTransient
    public List<UsuarioExamen> getUsuarioExamenList() {
        return usuarioExamenList;
    }

    public void setUsuarioExamenList(List<UsuarioExamen> usuarioExamenList) {
        this.usuarioExamenList = usuarioExamenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatSeccion)) {
            return false;
        }
        CatSeccion other = (CatSeccion) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.CatSeccion[ idSeccion=" + idSeccion + " ]";
    }
    
}
