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
public enum EnumSituacaoConvocacao {
    solicitada(0),
    aceita(1),
    recusada(2);
    
    public int valor;
    EnumSituacaoConvocacao(int valor) {
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
