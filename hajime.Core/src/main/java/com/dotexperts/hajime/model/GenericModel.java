/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.model;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author admprodesp
 */
public abstract class GenericModel { 
    public abstract Integer getId();
    public abstract void setId(Integer id);
    public Class mytype()
    {
        return this.getClass();
    }
}
