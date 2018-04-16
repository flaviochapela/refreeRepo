/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.ui;

import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.interfaces.iFederacao;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Delegacia;
import com.dotexperts.hajime.model.Federacao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author admprodesp
 */
@ManagedBean
@RequestScoped
public class PesquisaEventosMB implements Serializable {

    @EJB
    private iCampeonato campeonatoejb;

    @EJB
    private iFederacao federacaoejb;
    
    @EJB
    private iDelegacia delegaciaejb;

    private static final long serialVersionUID = 1L;
    private List<Campeonato> campeonatos;
    private Campeonato unitCampeonato;   
    private List<Campeonato> filteredcampeonatos;
    private List<Federacao> federacoes;
    private List<Delegacia> delegacias; 

    @PostConstruct
    public void init() {   
        this.campeonatos = campeonatoejb.listAll();
        this.federacoes = federacaoejb.listAll();
        this.delegacias = delegaciaejb.listAll();
        this.unitCampeonato = new Campeonato();
    }
  
    public List<Campeonato> getCampeonatos() {
        return this.campeonatos;
    }

    public List<Campeonato> getFilteredcampeonatos() {
        return filteredcampeonatos;
    }

    public void setFilteredcampeonatos(List<Campeonato> filteredcampeonatos) {
        this.filteredcampeonatos = filteredcampeonatos;
    }

    public List<Federacao> getFederacoes() {
        return federacoes;
    }

    public void salvar() {
        try {
              this.campeonatoejb.insert(unitCampeonato);
              addMessage("Salvo com Sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            addMessage("Erro ao salvar :o(", FacesMessage.SEVERITY_FATAL);
        }
    }

   
    public void addMessage(String summary, Severity type) {
        FacesMessage message = new FacesMessage(type, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public Campeonato getUnitCampeonato() {
        return unitCampeonato;
    }

    public void setUnitCampeonato(Campeonato unitCampeonato) {
        this.unitCampeonato = unitCampeonato;
    }
    
    public List<Delegacia> getDelegacias() {
        return delegacias;
    }

    public void setDelegacias(List<Delegacia> delegacias) {
        this.delegacias = delegacias;
    }
}
