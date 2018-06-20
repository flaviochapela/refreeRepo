/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.core;

import com.dotexperts.hajime.dao.GenericDao;
import com.dotexperts.hajime.interfaces.iBase;
import com.dotexperts.hajime.model.GenericModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author admprodesp
 * @param <T>
 */
public abstract class baseEJB<T extends GenericModel> implements iBase<T> {

    EntityManager em;

    private static final String TYPE_NAME_PREFIX = "class ";

    @Override
    public T get(int id) {
        T t = null;
        GenericDao dao = new GenericDao(mytype());
        t = (T) dao.get(id);
        return t;
    }

    @Override
    public T insert(T obj) throws Exception {
        try {
            GenericDao dao = new GenericDao(obj.mytype());
            obj = (T) dao.save(obj);
        } catch (Exception e) {
            throw new Exception("Erro ao gravar");
        }
        return obj;
    }

    @Override
    public void remove(int id) throws Exception {
        GenericDao dao = new GenericDao(mytype());
        dao.remove(id);
    }

    @Override
    public List<T> listAll() {
        GenericDao dao = new GenericDao(mytype());
        return dao.listAll();
    }
    
    public void sendMessage()
    {
        
    }

    public Type[] getParameterizedTypes(Object object) {
        Type superclassType = object.getClass().getGenericSuperclass();
        if (!ParameterizedType.class.isAssignableFrom(superclassType.getClass())) {
            return null;
        }
        return ((ParameterizedType) superclassType).getActualTypeArguments();
    }

    public Class<T> mytype() {
        Type[] parameterizedTypes = getParameterizedTypes(this);
        Class<T> clazz = (Class<T>) getClass(parameterizedTypes[0]);
        return clazz;
    }

    public static String getClassName(Type type) {
        if (type == null) {
            return "";
        }
        String className = type.toString();
        if (className.startsWith(TYPE_NAME_PREFIX)) {
            className = className.substring(TYPE_NAME_PREFIX.length());
        }
        return className;
    }

    public Class<?> getClass(Type type) {
        String className = getClassName(type);
        if (className == null || className.isEmpty()) {
            return null;
        }
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(baseEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
