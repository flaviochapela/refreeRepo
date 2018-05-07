/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.model;

import com.dotexperts.enummerators.EnumPresenca;
import com.dotexperts.enummerators.EnumSituacaoConvocacao;
import com.dotexperts.enummerators.EnumTipoConvocacao;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admprodesp
 */
@Entity
@Table(name = "Campeonato_arbitro", catalog = "hajime", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campeonatoarbitro.findAll", query = "SELECT c FROM Campeonatoarbitro c")
    , @NamedQuery(name = "Campeonatoarbitro.findByArea", query = "SELECT c FROM Campeonatoarbitro c WHERE c.area = :area")
    , @NamedQuery(name = "Campeonatoarbitro.findByOrdem", query = "SELECT c FROM Campeonatoarbitro c WHERE c.ordem = :ordem")
    , @NamedQuery(name = "Campeonatoarbitro.findById", query = "SELECT c FROM Campeonatoarbitro c WHERE c.id = :id")
    , @NamedQuery(name = "Campeonatoarbitro.findByTipo", query = "SELECT c FROM Campeonatoarbitro c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Campeonatoarbitro.findBySituacao", query = "SELECT c FROM Campeonatoarbitro c WHERE c.situacao = :situacao")})
public class Campeonatoarbitro extends GenericModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private int area;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordem")
    private int ordem;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipo")
    private EnumTipoConvocacao tipo;
    @Column(name = "situacao")
    private EnumSituacaoConvocacao situacao;
    @JoinColumn(name = "idarbitro", referencedColumnName = "idarbitro")
    @ManyToOne(optional = false)
    private Arbitro idarbitro;
    @JoinColumn(name = "idcampeonato", referencedColumnName = "idcampeonato")
    @ManyToOne(optional = false)
    private Campeonato idcampeonato;
    
    @Column(name = "presenca")
    private EnumPresenca presenca;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacao")
    private String observacao;

       
    @Transient
    private boolean selecionado;
  
  
    public Campeonatoarbitro() {
    }

    public Campeonatoarbitro(Integer id) {
        this.id = id;
    }

    public Campeonatoarbitro(Integer id, int area, int ordem) {
        this.id = id;
        this.area = area;
        this.ordem = ordem;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnumTipoConvocacao getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoConvocacao tipo) {
        this.tipo = tipo;
    }

    public EnumSituacaoConvocacao getSituacao() {
        return situacao;
    }

    public void setSituacao(EnumSituacaoConvocacao situacao) {
        this.situacao = situacao;
    }

    public Arbitro getIdarbitro() {
        return idarbitro;
    }

    public void setIdarbitro(Arbitro idarbitro) {
        this.idarbitro = idarbitro;
    }

    public Campeonato getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(Campeonato idcampeonato) {
        this.idcampeonato = idcampeonato;
    }
    
   
    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
    
     public EnumPresenca getPresenca() {
        return presenca;
    }

    public void setPresenca(EnumPresenca presenca) {
        this.presenca = presenca;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campeonatoarbitro)) {
            return false;
        }
        Campeonatoarbitro other = (Campeonatoarbitro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dotexperts.hajime.model.Campeonatoarbitro[ id=" + id + " ]";
    }
    
}
