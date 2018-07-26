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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UNAM
 */
@Entity
@Table(name = "cat_tipo_dato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatTipoDato.findAll", query = "SELECT c FROM CatTipoDato c")
    , @NamedQuery(name = "CatTipoDato.findByIdTipoDato", query = "SELECT c FROM CatTipoDato c WHERE c.idTipoDato = :idTipoDato")
    , @NamedQuery(name = "CatTipoDato.findByCNombreDato", query = "SELECT c FROM CatTipoDato c WHERE c.cNombreDato = :cNombreDato")})
public class CatTipoDato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_dato")
    private Short idTipoDato;
    @Size(max = 10)
    @Column(name = "c_nombre_dato")
    private String cNombreDato;
    @OneToMany(mappedBy = "idTipoDato")
    private List<Opcion> opcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDato")
    private List<Pregunta> preguntaList;

    public CatTipoDato() {
    }

    public CatTipoDato(Short idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public Short getIdTipoDato() {
        return idTipoDato;
    }

    public void setIdTipoDato(Short idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public String getCNombreDato() {
        return cNombreDato;
    }

    public void setCNombreDato(String cNombreDato) {
        this.cNombreDato = cNombreDato;
    }

    @XmlTransient
    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDato != null ? idTipoDato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoDato)) {
            return false;
        }
        CatTipoDato other = (CatTipoDato) object;
        if ((this.idTipoDato == null && other.idTipoDato != null) || (this.idTipoDato != null && !this.idTipoDato.equals(other.idTipoDato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.unam.dgoae.instrumentos.entity.CatTipoDato[ idTipoDato=" + idTipoDato + " ]";
    }
    
}
