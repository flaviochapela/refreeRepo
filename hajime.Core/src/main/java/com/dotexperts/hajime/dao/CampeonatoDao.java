/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.dao;

import com.dotexperts.hajime.model.Campeonato;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admprodesp
 */
public class CampeonatoDao extends GenericDao<Campeonato> {

    
    

    public Campeonato getCampeonato(int id) {

        this.em = getEntityManager();
        
        Campeonato c = null;
        Query q = em.createNamedQuery("Campeonato.findByIdcampeonato");
        q.setParameter("idcampeonato", id);
        c = (Campeonato) q.getSingleResult();
        c.getCampeonatoarbitroCollection().size();
        c.getIddelegacia().getIdFederacao().getClass();
        return c;
    }

}
