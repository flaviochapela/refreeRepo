/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.managed;

import com.dotexperts.hajime.interfaces.iBase;
import com.dotexperts.hajime.model.GenericModel;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.print.DocFlavor;

/**
 *
 * @author admprodesp
 * @param <T>
 */
public abstract class GenericMB<T extends GenericModel> {

    iBase<T> ejb;

    private List<T> listItens;
    private List<T> filteredItens;
    T item;

    public abstract void newItem();
      

    public void allItens() {
        this.listItens = this.ejb.listAll();
    }

    public void saveItem() throws Exception {
        try {            
            this.ejb.insert(item);            
            if(!this.listItens.contains(item))
            {
                this.listItens.add(item);
            }
            addMessage("Salvo com sucesso!");
        } catch (Exception e) {
            addMessage(String.format("Erro ao Salvar: %s", e.getMessage()));
        }
    }

    public void deleteItem() throws Exception {
        try {
            this.ejb.remove(item.getId());
            addMessage("Removido com sucesso!");
        } catch (Exception e) {
            addMessage(String.format("Erro ao Remover: %s", e.getMessage()));
        }
    }

    public List<T> getListItens() {
        return listItens;
    }

    public void setListItens(List<T> listItens) {
        this.listItens = listItens;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T Item) {
        this.item = Item;
    }

    public List<T> getFilteredItens() {
        return filteredItens;
    }

    public void setFilteredItens(List<T> filteredItens) {
        this.filteredItens = filteredItens;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void redirect(String url, GenericModel o) throws IOException
    {
         FacesContext.getCurrentInstance().getExternalContext().redirect(String.format("%s?id=%s", url, o.getId())); 
//        StringBuilder sb = new StringBuilder();
//        
//        for (int i = 0; i < params.length; i++) {
//            sb.append(String.format("%s=%s", params[i], values[i]));
//        }
//        
//        return url + "?faces-redirect=true&id=" + this.item.getId(); 
    }
    
    public String getParameter(String param)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        return  params.get(param);
    }

}
