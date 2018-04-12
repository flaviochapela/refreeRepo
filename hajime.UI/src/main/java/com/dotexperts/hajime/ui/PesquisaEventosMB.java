/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.ui;

import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.interfaces.iFederacao;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Federacao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author admprodesp
 */
@ManagedBean
@ViewScoped
public class PesquisaEventosMB implements Serializable {

    @EJB
    private iCampeonato campeonatoejb;

    @EJB
    private iFederacao federacaoejb;

    private static final long serialVersionUID = 1L;
    private List<Campeonato> campeonatos;
    private Campeonato unitCampeonato;   
    private List<Campeonato> filteredcampeonatos;
    private List<Federacao> federacoes;

    @PostConstruct
    public void init() {        
        this.campeonatos = campeonatoejb.listAll();
        this.federacoes = federacaoejb.listAll();
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

    public void editar(Campeonato Campeonato) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("campeonato/formularioCampeonato.xhtml");
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public Campeonato getUnitCampeonato() {
        return unitCampeonato;
    }

    public void setUnitCampeonato(Campeonato unitCampeonato) {
        this.unitCampeonato = unitCampeonato;
    }
}
