/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.interfaces.iFederacao;
import com.dotexperts.hajime.model.Delegacia;
import com.dotexperts.hajime.model.Federacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    
    private Federacao federacao;
    
    @PostConstruct
    public void init() {
        this.ejb = ejbdelegacia;
        this.federacao = ejbfederecao.get(1);
        this.setListItens(new ArrayList<>());
        this.getListItens().addAll(this.federacao.getDelegaciaCollection());  
        newItem();        
    } 
    
     @Override
    public void newItem() {
        this.setItem(new Delegacia());
        this.getItem().setIdFederacao(this.federacao);
    }

    public Federacao getFederacao() {
        return federacao;
    }

    public void setFederacoes(Federacao federacao) {
        this.federacao = federacao;
    }
    
    
}
