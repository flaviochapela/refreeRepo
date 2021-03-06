/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.core;

import com.dotexperts.hajime.dao.ArbitroDAO;
import com.dotexperts.hajime.interfaces.iArbitro;
import com.dotexperts.hajime.model.Arbitro;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author admprodesp
 */
@Stateless
public class ArbitroEJB extends baseEJB<Arbitro> implements iArbitro {

    @Override
    public List<Arbitro> getDelegaciaArbitros(int idDelegacia) {
        try {
            ArbitroDAO dao = new ArbitroDAO();
            return dao.getArbitrosbyDelegacia(idDelegacia);
        } catch (Exception e) {
            return null;
        }
    }
    
}
