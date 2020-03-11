/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.enums;

/**
 *
 * @author Luciano
 */
public enum TipoPessoa {
    
    Cliente("Cliente"),Funcionario("Funcionario"),Pessoa_Juridica("Pessoa_Juridica"),Administrador("Administrador");
    
    private final  String tipo;
    
    private TipoPessoa(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    public static TipoPessoa getEnum(String value){
        for(TipoPessoa tp : values()){
            if(tp.getTipo().equalsIgnoreCase(value))
                return tp;
         }
            throw new IllegalArgumentException();
        
    }
    
    
    
}
