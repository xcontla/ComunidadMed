/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "login_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginRol.findAll", query = "SELECT l FROM LoginRol l")
    , @NamedQuery(name = "LoginRol.findByIdUsuarioRol", query = "SELECT l FROM LoginRol l WHERE l.idUsuarioRol = ?1")
    , @NamedQuery(name = "LoginRol.findByDCreacion", query = "SELECT l FROM LoginRol l WHERE l.dCreacion = ?1")})
public class LoginRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_rol")
    private Long idUsuarioRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dCreacion;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private CatRol idRol;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Login idUsuario;

    public LoginRol() {
    }

    public LoginRol(Long idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public LoginRol(Long idUsuarioRol, Date dCreacion) {
        this.idUsuarioRol = idUsuarioRol;
        this.dCreacion = dCreacion;
    }

    public Long getIdUsuarioRol() {
        return idUsuarioRol;
    }

    public void setIdUsuarioRol(Long idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Date getDCreacion() {
        return dCreacion;
    }

    public void setDCreacion(Date dCreacion) {
        this.dCreacion = dCreacion;
    }

    public CatRol getIdRol() {
        return idRol;
    }

    public void setIdRol(CatRol idRol) {
        this.idRol = idRol;
    }

    public Login getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Login idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioRol != null ? idUsuarioRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginRol)) {
            return false;
        }
        LoginRol other = (LoginRol) object;
        if ((this.idUsuarioRol == null && other.idUsuarioRol != null) || (this.idUsuarioRol != null && !this.idUsuarioRol.equals(other.idUsuarioRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.LoginRol[ idUsuarioRol=" + idUsuarioRol + " ]";
    }
    
}
