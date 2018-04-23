/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.core;

import com.dotexperts.enummerators.EnumSituacaoConvocacao;
import com.dotexperts.enummerators.EnumTipoConvocacao;
import com.dotexperts.hajime.dao.CampeonatoDao;
import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.interfaces.iCampeonatoArbitro;
import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Campeonatoarbitro;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author admprodesp
 */
@Stateless
public class CampeonatoEJB extends baseEJB<Campeonato> implements iCampeonato {

    @EJB
    private iCampeonatoArbitro caEJB;

    @Override
    public Campeonatoarbitro addConvocacao(int idCampeoanto, Arbitro arbitro, EnumTipoConvocacao tipo) {

        try {
            Campeonatoarbitro ca = new Campeonatoarbitro();
            Campeonato c = new Campeonato();
            c.setId(idCampeoanto);
            ca.setIdcampeonato(c);
            ca.setIdarbitro(arbitro);
            ca.setArea(0);
            ca.setOrdem(0);
            ca.setTipo(tipo);
            ca.setSituacao(EnumSituacaoConvocacao.solicitada);
            return caEJB.insert(ca);
        } catch (Exception ex) {
            Logger.getLogger(CampeonatoEJB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public int solicitacaoConvocacao(int quantidade, EnumTipoConvocacao tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int respostaConvocacao(int idcampeonato, int idarbitro, boolean resposta, String justificativa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campeonatoarbitro addArbitroArea(Campeonatoarbitro ca) {

        try {
            return caEJB.insert(ca);
        } catch (Exception ex) {
            Logger.getLogger(CampeonatoEJB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    } 

    @Override
    public Campeonato getCampeonato(int id) {
        CampeonatoDao dao = new CampeonatoDao();
        
        return dao.getCampeonato(id);
        
    }

}
