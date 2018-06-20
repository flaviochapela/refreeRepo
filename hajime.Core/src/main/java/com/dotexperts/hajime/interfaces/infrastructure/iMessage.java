/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.interfaces.infrastructure;

import javax.ejb.Local;

/**
 *
 * @author admprodesp
 */
@Local
public interface iMessage {
    
    public void sendMessage(String title, String body, String recepient);
}
