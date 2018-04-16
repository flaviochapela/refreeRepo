/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.dao;

import com.dotexperts.hajime.model.GenericModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author admprodesp
 * @param <T>
 */

public class GenericDao<T extends GenericModel> {

    @PersistenceContext
    EntityManager em;
    
    protected Class<T> entity;

    public GenericDao() {
    }

    public GenericDao(Class<T> entity) {
        this.em = getEntityManager();
        this.entity = entity;        
    }

    public T get(int id) {
        T t;
        t = em.find(entity, id);
        return t;
    }

    public T save(T t) {

        if (t.getId() == null) {
            em.persist(t);
            em.flush();
        } else {
            t = em.merge(t);
        }        
        return t;
    }

    public void remove(int id) {
        T t;
        t = get(id);
        em.remove(t);
    }

    public List<T> listAll() {
        TypedQuery<T> query = em.createQuery(String.format("Select x FROM %s x", entity.getName()), entity);
        return query.getResultList();
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hajime.PU");
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }

}
