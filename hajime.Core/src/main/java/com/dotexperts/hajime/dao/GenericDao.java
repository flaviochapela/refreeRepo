/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.dao;

import com.dotexperts.hajime.model.GenericModel;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        this.em = getEntityManager();
        T t;
        em.flush();
        t = em.find(entity, id);
        em.refresh(t);
        return t;
    }

    public T save(T t) {
        this.em = getEntityManager();
        
        if (t.getId() == null) {
            em.persist(t);
        } else {
            t = em.merge(t);
        }
        em.flush();
        return t;
    }

    public void remove(int id) {
        this.em = getEntityManager();
        T t;
        t = get(id);
        em.remove(t);
    }

    public List<T> listAll() {
        this.em = getEntityManager();
        TypedQuery<T> query = em.createQuery(String.format("Select x FROM %s x", entity.getName()), entity);
        em.flush();
        return query.getResultList();
    }

    public List<T> byNamedQuery(String namedQuery, Hashtable<String, String> params) {
        this.em = getEntityManager();
        
        List<T> t;
        Query q = em.createNamedQuery(namedQuery);

        params.forEach((a, b)
                -> {
            q.setParameter(a, b);
        });

        t = (List<T>) q.getResultList();

        return t;
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hajime.PU");
        EntityManager entityManager = factory.createEntityManager();        
        return entityManager;
    }

}
