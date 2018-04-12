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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Delegacia", catalog = "hajime", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delegacia.findAll", query = "SELECT d FROM Delegacia d")
    , @NamedQuery(name = "Delegacia.findByIdDelegacia", query = "SELECT d FROM Delegacia d WHERE d.idDelegacia = :idDelegacia")
    , @NamedQuery(name = "Delegacia.findByDelegacia", query = "SELECT d FROM Delegacia d WHERE d.delegacia = :delegacia")
    , @NamedQuery(name = "Delegacia.findByCidade", query = "SELECT d FROM Delegacia d WHERE d.cidade = :cidade")
    , @NamedQuery(name = "Delegacia.findByEstado", query = "SELECT d FROM Delegacia d WHERE d.estado = :estado")})
public class Delegacia extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDelegacia")
    private Integer idDelegacia;
    @Size(max = 255)
    @Column(name = "Delegacia")
    private String delegacia;
    @Size(max = 255)
    @Column(name = "Cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddelegacia")
    private Collection<Campeonato> campeonatoCollection;
    @JoinColumn(name = "idFederacao", referencedColumnName = "idFederacao")
    @ManyToOne(optional = false)
    private Federacao idFederacao;
    @OneToMany(mappedBy = "iddelegacia")
    private Collection<Associacao> associacaoCollection;

    public Delegacia() {
    }

    public Delegacia(Integer idDelegacia) {
        this.idDelegacia = idDelegacia;
    }

    public Integer getId() {
        return idDelegacia;
    }

    public void setId(Integer idDelegacia) {
        this.idDelegacia = idDelegacia;
    }

    public String getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(String delegacia) {
        this.delegacia = delegacia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Campeonato> getCampeonatoCollection() {
        return campeonatoCollection;
    }

    public void setCampeonatoCollection(Collection<Campeonato> campeonatoCollection) {
        this.campeonatoCollection = campeonatoCollection;
    }

    public Federacao getIdFederacao() {
        return idFederacao;
    }

    public void setIdFederacao(Federacao idFederacao) {
        this.idFederacao = idFederacao;
    }

    @XmlTransient
    public Collection<Associacao> getAssociacaoCollection() {
        return associacaoCollection;
    }

    public void setAssociacaoCollection(Collection<Associacao> associacaoCollection) {
        this.associacaoCollection = associacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelegacia != null ? idDelegacia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delegacia)) {
            return false;
        }
        Delegacia other = (Delegacia) object;
        if ((this.idDelegacia == null && other.idDelegacia != null) || (this.idDelegacia != null && !this.idDelegacia.equals(other.idDelegacia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dotexperts.hajime.model.Delegacia[ idDelegacia=" + idDelegacia + " ]";
    }
    
}
