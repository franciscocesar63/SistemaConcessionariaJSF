/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Luciano
 */
@Entity
@NamedQueries({
@NamedQuery(name = "funcionarioByMatricula" , query =  "select f from Funcionario f where f.matricula=:matricula "),
@NamedQuery(name = "funcionario.getAll" , query = "select v from Funcionario v")    
})
public class Funcionario extends Pessoa {

    @ManyToOne(cascade = CascadeType.MERGE)
    private Loja loja;
    @Column(unique = true)
    private String matricula;
    private Double salario;

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "loja=" + loja + ", matricula=" + matricula + ", salario=" + salario + '}';
    }

   
    
    
    
    
    
    
    
    
    
}
