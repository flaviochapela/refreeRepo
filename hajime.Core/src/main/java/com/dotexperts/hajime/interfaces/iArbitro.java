/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.interfaces;

import com.dotexperts.hajime.model.Arbitro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admprodesp
 */
@Local
public interface iArbitro extends iBase<Arbitro> {
     public List<Arbitro> getDelegaciaArbitros(int idDelegacia);
}
