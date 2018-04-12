/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "Associacao", catalog = "hajime", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Associacao.findAll", query = "SELECT a FROM Associacao a")
    , @NamedQuery(name = "Associacao.findByIdassociacao", query = "SELECT a FROM Associacao a WHERE a.idassociacao = :idassociacao")
    , @NamedQuery(name = "Associacao.findByNome", query = "SELECT a FROM Associacao a WHERE a.nome = :nome")
    , @NamedQuery(name = "Associacao.findByCidade", query = "SELECT a FROM Associacao a WHERE a.cidade = :cidade")})
public class Associacao extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idassociacao")
    private Integer idassociacao;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "cidade")
    private String cidade;
    @JoinColumn(name = "iddelegacia", referencedColumnName = "idDelegacia")
    @ManyToOne
    private Delegacia iddelegacia;
    @OneToMany(mappedBy = "idassociacao")
    private Collection<Arbitro> arbitroCollection;

    public Associacao() {
    }

    public Associacao(Integer idassociacao) {
        this.idassociacao = idassociacao;
    }

    public Integer getId() {
        return idassociacao;
    }

    public void setId(Integer idassociacao) {
        this.idassociacao = idassociacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Delegacia getIddelegacia() {
        return iddelegacia;
    }

    public void setIddelegacia(Delegacia iddelegacia) {
        this.iddelegacia = iddelegacia;
    }

    @XmlTransient
    public Collection<Arbitro> getArbitroCollection() {
        return arbitroCollection;
    }

    public void setArbitroCollection(Collection<Arbitro> arbitroCollection) {
        this.arbitroCollection = arbitroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idassociacao != null ? idassociacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Associacao)) {
            return false;
        }
        Associacao other = (Associacao) object;
        if ((this.idassociacao == null && other.idassociacao != null) || (this.idassociacao != null && !this.idassociacao.equals(other.idassociacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dotexperts.hajime.model.Associacao[ idassociacao=" + idassociacao + " ]";
    }
    
}
