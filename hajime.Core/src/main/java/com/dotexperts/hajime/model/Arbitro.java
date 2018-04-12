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
@Table(name = "Arbitro", catalog = "hajime", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arbitro.findAll", query = "SELECT a FROM Arbitro a")
    , @NamedQuery(name = "Arbitro.findByIdarbitro", query = "SELECT a FROM Arbitro a WHERE a.idarbitro = :idarbitro")
    , @NamedQuery(name = "Arbitro.findByNome", query = "SELECT a FROM Arbitro a WHERE a.nome = :nome")
    , @NamedQuery(name = "Arbitro.findByCategoria", query = "SELECT a FROM Arbitro a WHERE a.categoria = :categoria")
    , @NamedQuery(name = "Arbitro.findByCoordenador", query = "SELECT a FROM Arbitro a WHERE a.coordenador = :coordenador")})
public class Arbitro extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarbitro")
    private Integer idarbitro;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Column(name = "categoria")
    private Integer categoria;
    @Column(name = "coordenador")
    private Short coordenador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarbitro")
    private Collection<Campeonatoarbitro> campeonatoarbitroCollection;
    @JoinColumn(name = "idassociacao", referencedColumnName = "idassociacao")
    @ManyToOne
    private Associacao idassociacao;

    public Arbitro() {
    }

    public Arbitro(Integer idarbitro) {
        this.idarbitro = idarbitro;
    }

    public Integer getId() {
        return idarbitro;
    }

    public void setId(Integer idarbitro) {
        this.idarbitro = idarbitro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Short getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Short coordenador) {
        this.coordenador = coordenador;
    }

    @XmlTransient
    public Collection<Campeonatoarbitro> getCampeonatoarbitroCollection() {
        return campeonatoarbitroCollection;
    }

    public void setCampeonatoarbitroCollection(Collection<Campeonatoarbitro> campeonatoarbitroCollection) {
        this.campeonatoarbitroCollection = campeonatoarbitroCollection;
    }

    public Associacao getIdassociacao() {
        return idassociacao;
    }

    public void setIdassociacao(Associacao idassociacao) {
        this.idassociacao = idassociacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarbitro != null ? idarbitro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbitro)) {
            return false;
        }
        Arbitro other = (Arbitro) object;
        if ((this.idarbitro == null && other.idarbitro != null) || (this.idarbitro != null && !this.idarbitro.equals(other.idarbitro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dotexperts.hajime.model.Arbitro[ idarbitro=" + idarbitro + " ]";
    }
    
}
