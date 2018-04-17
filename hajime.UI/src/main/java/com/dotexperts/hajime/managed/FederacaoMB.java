/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.hajime.interfaces.iFederacao;
import com.dotexperts.hajime.model.Federacao;
import java.io.Serializable;
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
public class FederacaoMB extends GenericMB<Federacao> implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    @EJB
    private iFederacao ejbfederecao;
    
    @PostConstruct
    public void init() {
        this.ejb = ejbfederecao;
        allItens();
        newItem();        
    }    

    @Override
    public void newItem() {
       this.setItem(new Federacao());
    }
}
