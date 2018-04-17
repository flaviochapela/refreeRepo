/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.interfaces.iFederacao;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Delegacia;
import com.dotexperts.hajime.model.Federacao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author admprodesp
 */
@ManagedBean
@ViewScoped
public class CampeonatoMB extends GenericMB<Campeonato> implements Serializable {

    @EJB
    private iCampeonato ejbCampeonato;

    @EJB
    private iFederacao ejbfederacao;

    @EJB
    private iDelegacia ejbdelegacia;

    private static final long serialVersionUID = 1L;
    private List<Delegacia> delegacias;
    private List<Federacao> federacoes;

    @PostConstruct
    public void init() {
        this.ejb = ejbCampeonato;
        allItens();
        newItem();
        this.delegacias = ejbdelegacia.listAll();
    }

    @Override
    public void newItem() {
        this.setItem(new Campeonato());
        this.getItem().setIddelegacia(new Delegacia());
    }

    public List<Delegacia> getDelegacias() {
        return delegacias;
    }

    public void setDelegacias(List<Delegacia> delegacias) {
        this.delegacias = delegacias;
    }

    public List<Federacao> getFederacoes() {
        return federacoes;
    }

    public void setFederacoes(List<Federacao> federacoes) {
        this.federacoes = federacoes;
    }
}
