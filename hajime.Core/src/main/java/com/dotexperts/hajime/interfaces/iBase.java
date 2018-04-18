/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.interfaces;

import com.dotexperts.hajime.model.Campeonato;
import java.util.List;

/**
 *
 * @author admprodesp
 * @param <T>
 */
public interface iBase<T> {
    public T get(int id);
    public T insert(T obj) throws Exception;    
    public void remove(int id) throws Exception;
    public List<T> listAll();
}
