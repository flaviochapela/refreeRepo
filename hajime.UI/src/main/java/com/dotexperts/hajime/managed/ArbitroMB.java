/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.hajime.interfaces.iArbitro;
import com.dotexperts.hajime.interfaces.iAssociacao;
import com.dotexperts.hajime.interfaces.iDelegacia;
import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Associacao;
import com.dotexperts.hajime.model.Delegacia;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author admprodesp
 */
@ManagedBean
@ViewScoped
public class ArbitroMB extends GenericMB<Arbitro> implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private iArbitro ejbarbitro;

    @EJB
    private iDelegacia ejbdelegacia;

    @EJB
    private iAssociacao ejbassociacao;

    private List<Associacao> associacoes;
    private Delegacia delegacia;
    private List<SelectItem> delegaciaOptions;  
   

    @PostConstruct
    public void init() {
        this.ejb = ejbarbitro;
        this.delegacia = ejbdelegacia.get(Integer.parseInt(getParameter("id")));
        this.setListItens(ejbarbitro.getDelegaciaArbitros(this.delegacia.getId()));
        newItem();
        associacaoOptions();
    }

    @Override
    public void newItem() {
        this.item = new Arbitro();
        this.item.setIdassociacao(new Associacao());
    }
 
    
    public void saveModal(Arbitro arbitro)
    {
        this.item = arbitro;
        saveItem();
    }

    public void upload(FileUploadEvent event) throws Exception {
        
        if (event.getFile()!= null) {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String resHomeImgPath = servletContext.getRealPath("resources/images/arbitros");
            File file = new File(resHomeImgPath, String.format("%s.jpg", this.item.getId()));
 
            OutputStream out = new FileOutputStream(file);
            out.write(event.getFile().getContents());
            out.close();
            
        }
    }
       
    public void associacaoOptions()
    {
        List<Delegacia> delegacias = ejbdelegacia.listAll();
        delegaciaOptions = new ArrayList<>();
        
        delegacias.stream().map((d) -> {
            SelectItemGroup g = new SelectItemGroup(d.getDelegacia());
            List<SelectItem> groupItems = new ArrayList<>();
            d.getAssociacaoCollection().forEach((a) -> {
                groupItems.add(new SelectItem(a.getId(), a.getNome()));
            });
            g.setSelectItems(groupItems.toArray(new SelectItem[groupItems.size()]));
            return g;
        }).forEachOrdered((g) -> {
            delegaciaOptions.add(g);
        });
    }
    
    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }
    
    public List<SelectItem> getDelegaciaOptions() {
        return delegaciaOptions;
    }

    public void setDelegaciaOptions(List<SelectItem> delegaciaOptions) {
        this.delegaciaOptions = delegaciaOptions;
    }
}
