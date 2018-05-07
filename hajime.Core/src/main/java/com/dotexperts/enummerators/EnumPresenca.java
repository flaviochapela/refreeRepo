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
public enum EnumPresenca {
    aguardando(0),
    presente(1),
    ausente(2);
    
    public int valor;
    EnumPresenca(int valor) {
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}