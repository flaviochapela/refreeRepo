/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.dao;

import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Delegacia;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Chapela
 */
public class ArbitroDAO extends GenericDao<Arbitro> {

    public List<Arbitro> getArbitrosbyDelegacia(int idDelegacia) {
        
        this.em = getEntityManager();

        List<Arbitro> a;
        Query q = em.createNamedQuery("Arbitro.findByDelegacia");

        q.setParameter("delegacia", idDelegacia);
        a = q.getResultList();
        em.flush();
        
        return a;
    }
}
