/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.model;

import java.io.Serializable;
import java.util.Collection;
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
 * @author admprodesp
 */
@Entity
@Table(name = "Federacao", catalog = "hajime", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Federacao.findAll", query = "SELECT f FROM Federacao f")
    , @NamedQuery(name = "Federacao.findByIdFederacao", query = "SELECT f FROM Federacao f WHERE f.idFederacao = :idFederacao")
    , @NamedQuery(name = "Federacao.findByFederacao", query = "SELECT f FROM Federacao f WHERE f.federacao = :federacao")
    , @NamedQuery(name = "Federacao.findByEstado", query = "SELECT f FROM Federacao f WHERE f.estado = :estado")})
public class Federacao extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFederacao")
    private Integer idFederacao;
    @Size(max = 255)
    @Column(name = "Federacao")
    private String federacao;
    @Size(max = 2)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFederacao")
    private Collection<Delegacia> delegaciaCollection;

    public Federacao() {
    }

    public Federacao(Integer idFederacao) {
        this.idFederacao = idFederacao;
    }

    public Integer getId() {
        return idFederacao;
    }

    public void setId(Integer idFederacao) {
        this.idFederacao = idFederacao;
    }

    public String getFederacao() {
        return federacao;
    }

    public void setFederacao(String federacao) {
        this.federacao = federacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Delegacia> getDelegaciaCollection() {
        return delegaciaCollection;
    }

    public void setDelegaciaCollection(Collection<Delegacia> delegaciaCollection) {
        this.delegaciaCollection = delegaciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFederacao != null ? idFederacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Federacao)) {
            return false;
        }
        Federacao other = (Federacao) object;
        if ((this.idFederacao == null && other.idFederacao != null) || (this.idFederacao != null && !this.idFederacao.equals(other.idFederacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dotexperts.hajime.model.Federacao[ idFederacao=" + idFederacao + " ]";
    }
    
}
