/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.hajime.interfaces.iArbitro;
import com.dotexperts.hajime.interfaces.iAssociacao;
import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.model.Arbitro;
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
public class ArbitroMB extends GenericMB<Arbitro> implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private iArbitro ejbarbitro;

    @EJB
    private iDelegacia ejbdelegacia;

    @EJB
    private iAssociacao ejbassociacao;

    @PostConstruct
    public void init() {
        this.ejb = ejbarbitro;
        allItens();
        newItem();
    }

    @Override
    public void newItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
