/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admprodesp
 */
@Entity
@Table(name = "Pedido_Convocacao", catalog = "hajime", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoConvocacao.findAll", query = "SELECT p FROM PedidoConvocacao p")
    , @NamedQuery(name = "PedidoConvocacao.findByIdPedidoConvocacao", query = "SELECT p FROM PedidoConvocacao p WHERE p.idPedidoConvocacao = :idPedidoConvocacao")
    , @NamedQuery(name = "PedidoConvocacao.findByIdCampeonato", query = "SELECT p FROM PedidoConvocacao p WHERE p.idCampeonato = :idCampeonato")
    , @NamedQuery(name = "PedidoConvocacao.findByIdDelegacia", query = "SELECT p FROM PedidoConvocacao p WHERE p.idDelegacia = :idDelegacia")
    , @NamedQuery(name = "PedidoConvocacao.findByQuantidade", query = "SELECT p FROM PedidoConvocacao p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "PedidoConvocacao.findByTipo", query = "SELECT p FROM PedidoConvocacao p WHERE p.tipo = :tipo")})
public class PedidoConvocacao extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPedido_Convocacao")
    private Integer idPedidoConvocacao;
    @Column(name = "idCampeonato")
    private Integer idCampeonato;
    @Column(name = "idDelegacia")
    private Integer idDelegacia;
    @Column(name = "Quantidade")
    private Integer quantidade;
    @Column(name = "Tipo")
    private Integer tipo;

    public PedidoConvocacao() {
    }

    public PedidoConvocacao(Integer idPedidoConvocacao) {
        this.idPedidoConvocacao = idPedidoConvocacao;
    }

    public Integer getId() {
        return idPedidoConvocacao;
    }

    public void setId(Integer idPedidoConvocacao) {
        this.idPedidoConvocacao = idPedidoConvocacao;
    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public Integer getIdDelegacia() {
        return idDelegacia;
    }

    public void setIdDelegacia(Integer idDelegacia) {
        this.idDelegacia = idDelegacia;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoConvocacao != null ? idPedidoConvocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoConvocacao)) {
            return false;
        }
        PedidoConvocacao other = (PedidoConvocacao) object;
        if ((this.idPedidoConvocacao == null && other.idPedidoConvocacao != null) || (this.idPedidoConvocacao != null && !this.idPedidoConvocacao.equals(other.idPedidoConvocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dotexperts.hajime.model.PedidoConvocacao[ idPedidoConvocacao=" + idPedidoConvocacao + " ]";
    }
    
}
