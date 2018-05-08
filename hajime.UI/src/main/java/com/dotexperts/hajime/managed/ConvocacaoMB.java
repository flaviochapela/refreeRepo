/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.enummerators.EnumPresenca;
import com.dotexperts.enummerators.EnumSituacaoConvocacao;
import com.dotexperts.enummerators.EnumTipoConvocacao;
import com.dotexperts.hajime.interfaces.iArbitro;
import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.interfaces.iCampeonatoArbitro;
import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Campeonatoarbitro;
import com.dotexperts.hajime.model.Delegacia;
import com.dotexperts.hajime.util.AreasRelatorio;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.ReorderEvent;

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

    @EJB
    private iDelegacia ejbDelegacia;

    private Campeonato campeonato;  
    private List<Arbitro> arbitrosFull;
    private List<Arbitro> arbitros;
    private List<Campeonatoarbitro> convocadosFull;
    private List<Campeonatoarbitro> convocados;
    private List<Delegacia> delegacias;
    private String filterNome;
    private int filterDelegacia;
    private List<Integer> areas;
    private List<List<Campeonatoarbitro>> listAreas;

    @PostConstruct
    public void init() {
        this.ejb = ejbCampeonatoArbitro;
        this.arbitros = this.arbitrosFull = ejbArbitro.listAll();
        this.campeonato = ejbCampeonato.get(Integer.parseInt(getParameter("id")));
        makeAreas(this.campeonato.getAreas());

        this.convocadosFull = new ArrayList<>();
        this.convocados = new ArrayList<>();
        this.listAreas = new ArrayList<>();

        if (this.campeonato.getCampeonatoarbitroCollection().size() > 0) {
            this.convocados.addAll(this.campeonato.getCampeonatoarbitroCollection());
            this.convocadosFull.addAll(this.campeonato.getCampeonatoarbitroCollection());
        }
        this.delegacias = ejbDelegacia.listAll();
    }

    @Override
    public void newItem() {

    }
    
    public void addVoluntario(Arbitro arbitro) throws IOException
    {
        addArbitroCampeonato(arbitro, EnumTipoConvocacao.voluntario, EnumSituacaoConvocacao.aceita, EnumPresenca.aguardando);
    }
    
     public void addConvocacao(Arbitro arbitro)
    {
        addArbitroCampeonato(arbitro, EnumTipoConvocacao.nominal, EnumSituacaoConvocacao.aceita, EnumPresenca.aguardando);
    }

    public void addArbitroCampeonato(Arbitro arbitro, EnumTipoConvocacao tipo, EnumSituacaoConvocacao situacao, EnumPresenca presenca) {

        final boolean find;
        Campeonatoarbitro ca = new Campeonatoarbitro();
        ca.setIdcampeonato(this.campeonato);
        ca.setIdarbitro(arbitro);
        ca.setTipo(tipo);
        ca.setSituacao(situacao);
        ca.setPresenca(presenca);
        ca.setArea(0);
        ca.setOrdem(0);

        if (this.convocados.stream().filter(a -> a.getIdarbitro().equals(arbitro)).count() == 0) {
            this.convocados.add(ca);
            this.item = ca;
            saveItem();
        }
    }

    public void removeConvocacao(Campeonatoarbitro ca) {
        this.arbitros.add(ca.getIdarbitro());
        this.convocados.remove(ca);
        this.item = ca;
        deleteItem();
    }

    public void onArbitroDrop(DragDropEvent ddEvent) {

        Arbitro a = ((Arbitro) ddEvent.getData());
        addConvocacao(a);
        this.arbitros.remove(a);
    }

    public void onReorder(ReorderEvent event) {

        DataTable myDatatable = (DataTable) event.getSource();
        this.item = (Campeonatoarbitro) myDatatable.getRowData();
        this.item.setOrdem(event.getToIndex() + 1);
        saveItem();

    }

    public void gerarRelatorio() {
        try {
            AreasRelatorio rel = new AreasRelatorio();

            List<Campeonatoarbitro> r = new ArrayList<>();
            Campeonato c = new Campeonato();
            c = ejbCampeonato.get(this.campeonato.getId());
            r.addAll(c.getCampeonatoarbitroCollection());

            rel.imprimir(r);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }
  
    public void filterArbitros() {
        if (filterDelegacia != 0)
        {
            this.arbitros = this.arbitrosFull.stream().filter(a -> a.getNome().contains(filterNome)).collect(Collectors.toList());
        }else
        {
            this.arbitros = this.arbitrosFull.stream().filter(a -> a.getNome().contains(filterNome) && a.getIdassociacao().getIddelegacia().getId() == filterDelegacia).collect(Collectors.toList());
        }
    }

    public void filterConvocados() {
        this.convocados = this.convocadosFull.stream().filter(a -> a.getIdarbitro().getNome().contains(filterNome)).collect(Collectors.toList());
    }

  
    public void makeAreas(int qtd) {
        this.areas = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            this.areas.add(i + 1);
        }
    }

    public void addArea(int idarea, boolean add) {
        int ordem = 1;
        for (Campeonatoarbitro ca : this.convocados) {
            if (add) {
                if (ca.isSelecionado()) {
                    saveArea(ca, idarea, ordem++);
                }
            } else {
                if (ca.getArea() == idarea) {
                    saveArea(ca, idarea, ordem++);
                }
            }
        }
    }
    
    
    public void checkIn() {
        
        this.item.setPresenca(EnumPresenca.presente);
        saveItem();
    }
    
     public void saveArea(Campeonatoarbitro ca, int area, int ordem) {

        ca.setSelecionado(false);
        ca.setArea(area);
        ca.setOrdem(ordem);
        this.item = ca;
        saveItem();
    }

    public void RemoveArea(Campeonatoarbitro ca) {
        this.item = ca;
        this.item.setArea(0);
        saveItem();
    }

// <editor-fold defaultstate="collapsed" desc="Form Properties">
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

    public List<Delegacia> getDelegacias() {
        return delegacias;
    }

    public void setDelegacias(List<Delegacia> delegacias) {
        this.delegacias = delegacias;
    }

    public String getFilterNome() {
        return filterNome;
    }

    public void setFilterNome(String filterNome) {
        this.filterNome = filterNome;
    }

    public int getFilterDelegacia() {
        return filterDelegacia;
    }

    public void setFilterDelegacia(int filterDelegacia) {
        this.filterDelegacia = filterDelegacia;
    }

    public List<Integer> getAreas() {
        return areas;
    }

    public void setAreas(List<Integer> areas) {
        this.areas = areas;
    }

    public List<List<Campeonatoarbitro>> getListAreas() {
        return listAreas;
    }

    public void setListAreas(List<List<Campeonatoarbitro>> listAreas) {
        this.listAreas = listAreas;
    }

    public List<Campeonatoarbitro> getConvocadosFull() {
        return convocadosFull;
    }

    public void setConvocadosFull(List<Campeonatoarbitro> convocadosFull) {
        this.convocadosFull = convocadosFull;
    }
    
     public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    // </editor-fold>
}
