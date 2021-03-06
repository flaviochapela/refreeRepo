/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.enummerators.EnumSituacaoConvocacao;
import com.dotexperts.enummerators.EnumTipoConvocacao;
import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.interfaces.iFederacao;
import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Campeonatoarbitro;
import com.dotexperts.hajime.model.Delegacia;
import com.dotexperts.hajime.model.Federacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author admprodesp
 */
@ManagedBean
@ViewScoped
public class CampeonatoMB extends GenericMB<Campeonato> implements Serializable {

    @EJB
    private iCampeonato ejbCampeonato;

    @EJB
    private iFederacao ejbfederacao;

    @EJB
    private iDelegacia ejbdelegacia;

    private PieChartModel pieModel1;
    private static final long serialVersionUID = 1L;
    private List<Delegacia> delegacias;
    private List<Federacao> federacoes;
    private List<Arbitro> arbitros;
    private List<Campeonatoarbitro> convocados;

    @PostConstruct
    public void init() {
        createPieModel1();
        this.ejb = ejbCampeonato;
        allItens();
        newItem();
        this.convocados = new ArrayList<>();
        this.delegacias = ejbdelegacia.listAll();
    }
  

    @Override
    public void newItem() {
        this.setItem(new Campeonato());
        this.getItem().setIddelegacia(new Delegacia());
    }
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Brand 1", 540);
        pieModel1.set("Brand 2", 325);
        pieModel1.set("Brand 3", 702);
        pieModel1.set("Brand 4", 421);
         
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Form Properties">
    
     public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public List<Delegacia> getDelegacias() {
        return delegacias;
    }

    public void setDelegacias(List<Delegacia> delegacias) {
        this.delegacias = delegacias;
    }

    public List<Federacao> getFederacoes() {
        return federacoes;
    }

    public void setFederacoes(List<Federacao> federacoes) {
        this.federacoes = federacoes;
    }
    
    public List<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(List<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }
    //</editor-fold>
  
}
