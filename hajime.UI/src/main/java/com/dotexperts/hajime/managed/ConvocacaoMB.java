/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.enummerators.EnumSituacaoConvocacao;
import com.dotexperts.enummerators.EnumTipoConvocacao;
import com.dotexperts.hajime.interfaces.iArbitro;
import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.interfaces.iCampeonatoArbitro;
import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Campeonatoarbitro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author admprodesp
 */
@ManagedBean
@ViewScoped
public class ConvocacaoMB extends GenericMB<Campeonatoarbitro> implements Serializable {

    @EJB
    private iCampeonato ejbCampeonato;

    @EJB
    private iCampeonatoArbitro ejbCampeonatoArbitro;

    @EJB
    private iArbitro ejbArbitro;

    private Campeonato campeonato;
    private List<Arbitro> arbitros;
    private List<Campeonatoarbitro> convocados;

    @PostConstruct
    public void init() {
        this.ejb = ejbCampeonatoArbitro;
        this.arbitros = ejbArbitro.listAll();
        this.convocados = new ArrayList<>();
        this.campeonato = ejbCampeonato.get(2);
    }

    @Override
    public void newItem() {

    }

    public void addConvocacao(Arbitro arbitro) {
        
        final boolean find;
        Campeonatoarbitro ca = new Campeonatoarbitro();
        ca.setIdcampeonato(this.campeonato);
        ca.setIdarbitro(arbitro);
        ca.setTipo(EnumTipoConvocacao.nominal);
        ca.setSituacao(EnumSituacaoConvocacao.aceita);
        ca.setArea(0);
        ca.setOrdem(0);

       if (this.convocados.stream().filter(a->a.getIdarbitro().equals(arbitro)).count() ==0)
       {
            this.convocados.add(ca);
            //this.item = ca;
            //saveItem();
       }
    }
    
    public void removeConvocacao(Campeonatoarbitro ca)
    {
        this.arbitros.add(ca.getIdarbitro());
        this.convocados.remove(ca);
        //this.item = ca;
        //deleteItem();
    }
    
     public void onArbitroDrop(DragDropEvent ddEvent)  {
         
        Arbitro a = ((Arbitro) ddEvent.getData());
        addConvocacao(a);
        this.arbitros.remove(a);
    }

    public List<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(List<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public List<Campeonatoarbitro> getConvocados() {
        return convocados;
    }

    public void setConvocados(List<Campeonatoarbitro> convocados) {
        this.convocados = convocados;
    }
}
