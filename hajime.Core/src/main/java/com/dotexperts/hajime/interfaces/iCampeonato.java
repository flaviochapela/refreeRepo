/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.interfaces;

import com.dotexperts.enummerators.EnumTipoConvocacao;
import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Campeonatoarbitro;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author admprodesp
 */
@Remote
public interface iCampeonato extends iBase<Campeonato> {
    public Campeonatoarbitro addConvocacao(int idCampeoanto, Arbitro arbitro, EnumTipoConvocacao tipo);
    public int solicitacaoConvocacao(int quantidade, EnumTipoConvocacao tipo);
    public int respostaConvocacao(int idcampeonato, int idarbitro, boolean resposta, String justificativa);
    public Campeonatoarbitro addArbitroArea(Campeonatoarbitro ca);
    public Campeonato getCampeonato(int id);
 }
