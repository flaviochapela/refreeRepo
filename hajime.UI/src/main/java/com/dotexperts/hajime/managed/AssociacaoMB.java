/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.hajime.interfaces.iAssociacao;
import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.interfaces.iFederacao;
import com.dotexperts.hajime.model.Associacao;
import com.dotexperts.hajime.model.Delegacia;
import com.dotexperts.hajime.model.Federacao;
import java.io.Serializable;
import java.util.ArrayList;
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
public class AssociacaoMB extends GenericMB<Associacao> implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    @EJB
    private iFederacao ejbfederecao;
    
    @EJB
    private iDelegacia ejbdelegacia;
    
    @EJB
    private iAssociacao ejbassociacao;
    
    private Delegacia delegacia;

    private List<Federacao> federacoes;
    
    @PostConstruct
    public void init() {
        
        this.delegacia = ejbdelegacia.get(Integer.parseInt(getParameter("id")));
        this.ejb = ejbassociacao;
        this.setListItens(new ArrayList<>());
        this.getListItens().addAll(this.delegacia.getAssociacaoCollection());
        newItem();        
    }    

    @Override
    public void newItem() {
        this.setItem(new Associacao());
        this.getItem().setIddelegacia(this.delegacia);
        this.getItem().getIddelegacia().setIdFederacao(this.delegacia.getIdFederacao());
    }
    
    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }
}
