/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByIdUsuario", query = "SELECT l FROM Login l WHERE l.idUsuario = ?1")
    , @NamedQuery(name = "Login.findByCCurp", query = "SELECT l FROM Login l WHERE l.cCurp = ?1")
    , @NamedQuery(name = "Login.findByCLlave", query = "SELECT l FROM Login l WHERE l.cLlave = ?1")
    , @NamedQuery(name = "Login.findByDCreacion", query = "SELECT l FROM Login l WHERE l.dCreacion = ?1")
    , @NamedQuery(name = "Login.findByBStatus", query = "SELECT l FROM Login l WHERE l.bStatus = ?1")})
public class Login implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<UresoHymInteres> uresoHymInteresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<UresoHymAptitud> uresoHymAptitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<UsuarioExamen> usuarioExamenList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_curp")
    private String cCurp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_llave")
    private String cLlave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_status")
    private boolean bStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<LoginRol> loginRolList;

    public Login() {
    }

    public Login(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Login(Long idUsuario, String cCurp, String cLlave, Date dCreacion, boolean bStatus) {
        this.idUsuario = idUsuario;
        this.cCurp = cCurp;
        this.cLlave = cLlave;
        this.dCreacion = dCreacion;
        this.bStatus = bStatus;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCCurp() {
        return cCurp;
    }

    public void setCCurp(String cCurp) {
        this.cCurp = cCurp;
    }

    public String getCLlave() {
        return cLlave;
    }

    public void setCLlave(String cLlave) {
        this.cLlave = cLlave;
    }

    public Date getDCreacion() {
        return dCreacion;
    }

    public void setDCreacion(Date dCreacion) {
        this.dCreacion = dCreacion;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.Login[ idUsuario=" + idUsuario + " ]";
    }

    @XmlTransient
    public List<UresoHymInteres> getUresoHymInteresList() {
        return uresoHymInteresList;
    }

    public void setUresoHymInteresList(List<UresoHymInteres> uresoHymInteresList) {
        this.uresoHymInteresList = uresoHymInteresList;
    }

    @XmlTransient
    public List<UresoHymAptitud> getUresoHymAptitudList() {
        return uresoHymAptitudList;
    }

    public void setUresoHymAptitudList(List<UresoHymAptitud> uresoHymAptitudList) {
        this.uresoHymAptitudList = uresoHymAptitudList;
    }

    @XmlTransient
    public List<UsuarioExamen> getUsuarioExamenList() {
        return usuarioExamenList;
    }

    public void setUsuarioExamenList(List<UsuarioExamen> usuarioExamenList) {
        this.usuarioExamenList = usuarioExamenList;
    }
    
}
