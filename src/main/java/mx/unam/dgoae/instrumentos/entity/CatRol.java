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
@Table(name = "cat_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatRol.findAll", query = "SELECT c FROM CatRol c")
    , @NamedQuery(name = "CatRol.findByIdRol", query = "SELECT c FROM CatRol c WHERE c.idRol = ?1")
    , @NamedQuery(name = "CatRol.findByCnombreRol", query = "SELECT c FROM CatRol c WHERE c.cnombreRol = ?1")
    , @NamedQuery(name = "CatRol.findByBStatus", query = "SELECT c FROM CatRol c WHERE c.bStatus = ?1")})
public class CatRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol")
    private Integer idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_nombreRol")
    private String cnombreRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<LoginRol> loginRolList;

    public CatRol() {
    }

    public CatRol(Integer idRol) {
        this.idRol = idRol;
    }

    public CatRol(Integer idRol, String cnombreRol, boolean bStatus) {
        this.idRol = idRol;
        this.cnombreRol = cnombreRol;
        this.bStatus = bStatus;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getCnombreRol() {
        return cnombreRol;
    }

    public void setCnombreRol(String cnombreRol) {
        this.cnombreRol = cnombreRol;
    }

    public boolean getBStatus() {
        return bStatus;
    }

    public void setBStatus(boolean bStatus) {
        this.bStatus = bStatus;
    }

    @XmlTransient
    public List<LoginRol> getLoginRolList() {
        return loginRolList;
    }

    public void setLoginRolList(List<LoginRol> loginRolList) {
        this.loginRolList = loginRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatRol)) {
            return false;
        }
        CatRol other = (CatRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.CatRol[ idRol=" + idRol + " ]";
    }
    
}
