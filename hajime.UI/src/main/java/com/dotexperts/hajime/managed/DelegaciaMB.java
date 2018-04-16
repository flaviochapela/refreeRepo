/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

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
import javax.faces.bean.ViewScoped;

/**
 *
 * @author admprodesp
 */

@ManagedBean
@ViewScoped
public class DelegaciaMB extends GenericMB<Delegacia> implements Serializable {
   
    private static final long serialVersionUID = 1L;
 
    @EJB
    private iDelegacia ejbdelegacia;
    
    @EJB
    private iFederacao ejbfederecao;
    
    private List<Federacao> federacoes;
    
    @PostConstruct
    public void init() {
        this.ejb = ejbdelegacia;
        this.federacoes = ejbfederecao.listAll();
        allItens();
        newItem();        
    } 
    
     @Override
    public void newItem() {
        this.setItem(new Delegacia());
        this.getItem().setIdFederacao(new Federacao());
    }

    public List<Federacao> getFederacoes() {
        return federacoes;
    }

    public void setFederacoes(List<Federacao> federacoes) {
        this.federacoes = federacoes;
    }
    
    
}
