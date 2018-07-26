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
@Table(name = "cat_parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatParte.findAll", query = "SELECT c FROM CatParte c")
    , @NamedQuery(name = "CatParte.findByIdParte", query = "SELECT c FROM CatParte c WHERE c.idParte = :idParte")
    , @NamedQuery(name = "CatParte.findByCnombreParte", query = "SELECT c FROM CatParte c WHERE c.cnombreParte = :cnombreParte")
    , @NamedQuery(name = "CatParte.findByBStatus", query = "SELECT c FROM CatParte c WHERE c.bStatus = :bStatus")})
public class CatParte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parte")
    private Integer idParte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_nombreParte")
    private String cnombreParte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParte")
    private List<ExamenPregunta> examenPreguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParte")
    private List<UsuarioExamen> usuarioExamenList;

    public CatParte() {
    }

    public CatParte(Integer idParte) {
        this.idParte = idParte;
    }

    public CatParte(Integer idParte, String cnombreParte, boolean bStatus) {
        this.idParte = idParte;
        this.cnombreParte = cnombreParte;
        this.bStatus = bStatus;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public String getCnombreParte() {
        return cnombreParte;
    }

    public void setCnombreParte(String cnombreParte) {
        this.cnombreParte = cnombreParte;
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
        hash += (idParte != null ? idParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatParte)) {
            return false;
        }
        CatParte other = (CatParte) object;
        if ((this.idParte == null && other.idParte != null) || (this.idParte != null && !this.idParte.equals(other.idParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.CatParte[ idParte=" + idParte + " ]";
    }
    
}
