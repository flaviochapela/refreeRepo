/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admprodesp
 */
@Entity
@Table(name = "Campeonato", catalog = "hajime", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campeonato.findAll", query = "SELECT c FROM Campeonato c")
    , @NamedQuery(name = "Campeonato.findByIdcampeonato", query = "SELECT c FROM Campeonato c WHERE c.idcampeonato = :idcampeonato")
    , @NamedQuery(name = "Campeonato.findByNome", query = "SELECT c FROM Campeonato c WHERE c.nome = :nome")
    , @NamedQuery(name = "Campeonato.findByLocal", query = "SELECT c FROM Campeonato c WHERE c.local = :local")
    , @NamedQuery(name = "Campeonato.findByCidade", query = "SELECT c FROM Campeonato c WHERE c.cidade = :cidade")
    , @NamedQuery(name = "Campeonato.findByData", query = "SELECT c FROM Campeonato c WHERE c.data = :data")
    , @NamedQuery(name = "Campeonato.findByAreas", query = "SELECT c FROM Campeonato c WHERE c.areas = :areas")})
public class Campeonato extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcampeonato")
    private Integer idcampeonato;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "local")
    private String local;
    @Size(max = 255)
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "areas")
    private Integer areas;
    @JoinColumn(name = "iddelegacia", referencedColumnName = "idDelegacia")
    @ManyToOne(optional = false)
    private Delegacia iddelegacia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampeonato")
    private Collection<Campeonatoarbitro> campeonatoarbitroCollection;

    public Campeonato() {
    }

    public Campeonato(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public Integer getId() {
        return idcampeonato;
    }

    public void setId(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getAreas() {
        return areas;
    }

    public void setAreas(Integer areas) {
        this.areas = areas;
    }

    public Delegacia getIddelegacia() {
        return iddelegacia;
    }

    public void setIddelegacia(Delegacia iddelegacia) {
        this.iddelegacia = iddelegacia;
    }

    @XmlTransient
    public Collection<Campeonatoarbitro> getCampeonatoarbitroCollection() {
        return campeonatoarbitroCollection;
    }

    public void setCampeonatoarbitroCollection(Collection<Campeonatoarbitro> campeonatoarbitroCollection) {
        this.campeonatoarbitroCollection = campeonatoarbitroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampeonato != null ? idcampeonato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campeonato)) {
            return false;
        }
        Campeonato other = (Campeonato) object;
        if ((this.idcampeonato == null && other.idcampeonato != null) || (this.idcampeonato != null && !this.idcampeonato.equals(other.idcampeonato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dotexperts.hajime.model.Campeonato[ idcampeonato=" + idcampeonato + " ]";
    }
    
}
