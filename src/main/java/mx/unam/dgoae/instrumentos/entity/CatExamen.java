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
@Table(name = "cat_examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatExamen.findAll", query = "SELECT c FROM CatExamen c")
    , @NamedQuery(name = "CatExamen.findByIdExamen", query = "SELECT c FROM CatExamen c WHERE c.idExamen = :idExamen")
    , @NamedQuery(name = "CatExamen.findByCnombreExamen", query = "SELECT c FROM CatExamen c WHERE c.cnombreExamen = :cnombreExamen")
    , @NamedQuery(name = "CatExamen.findByBStatus", query = "SELECT c FROM CatExamen c WHERE c.bStatus = :bStatus")})
public class CatExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_examen")
    private Integer idExamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_nombreExamen")
    private String cnombreExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamen")
    private List<ExamenPregunta> examenPreguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamen")
    private List<UsuarioExamen> usuarioExamenList;

    public CatExamen() {
    }

    public CatExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public CatExamen(Integer idExamen, String cnombreExamen, boolean bStatus) {
        this.idExamen = idExamen;
        this.cnombreExamen = cnombreExamen;
        this.bStatus = bStatus;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getCnombreExamen() {
        return cnombreExamen;
    }

    public void setCnombreExamen(String cnombreExamen) {
        this.cnombreExamen = cnombreExamen;
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
        hash += (idExamen != null ? idExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatExamen)) {
            return false;
        }
        CatExamen other = (CatExamen) object;
        if ((this.idExamen == null && other.idExamen != null) || (this.idExamen != null && !this.idExamen.equals(other.idExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.CatExamen[ idExamen=" + idExamen + " ]";
    }
    
}
