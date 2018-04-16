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
    
    private List<Delegacia> delegacias;
    
    private List<Federacao> federacoes;
    
    @PostConstruct
    public void init() {
        this.ejb = ejbassociacao;
        allItens();
        newItem();        
    }    

    @Override
    public void newItem() {
        this.setItem(new Associacao());
        this.getItem().setIddelegacia(new Delegacia());
        this.getItem().getIddelegacia().setIdFederacao(new Federacao());
    }
}
