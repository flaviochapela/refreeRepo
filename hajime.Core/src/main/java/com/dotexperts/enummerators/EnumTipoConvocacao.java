/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotexperts.enummerators;

/**
 *
 * @author admprodesp
 */
public enum EnumTipoConvocacao {
    voluntario(0),
    nominal(1),
    vagadelegacia(2);
    
    public int valor;
    EnumTipoConvocacao(int valor) {
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
