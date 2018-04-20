/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.hajime.converter;

import com.dotexperts.hajime.model.Campeonatoarbitro;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//@FacesConverter(value="caConverter")
//public class CampeonatoArbitroConverter implements Converter {
//   
// @ManagedProperty(value = "#{convocacaoMB.convocados}")
//  private List<Campeonatoarbitro> cas;
// 
//
//    @Override
//    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
//         int caId = Integer.parseInt(string);
//         
//         for (Campeonatoarbitro ca: cas) {
//            if(ca.getId() == caId)
//            {
//                return ca;
//            }
//        }
//         return null;
//    }
//
//    @Override
//    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
//         Campeonatoarbitro ca = (Campeonatoarbitro)o ;
//         return "" + ca.getId();
//    }
//}