/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Luciano
 */
@Entity
@NamedQueries({
@NamedQuery(name = "veiculoaByAno" , query =  "select v.modelo from Veiculo v where v.anoFabricacao=:ano"),
@NamedQuery(name = "veiculos.getAll", query = "select v from Veiculo v")    
})
public class Veiculo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_seq")
    @SequenceGenerator(allocationSize = 1, sequenceName = "veiculo_seq", name = "veiculo_seq")
    private Long id;
    private String marca;
    private String modelo;
    @Column(unique = true)
    private String placa;
    private Double valor;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Pessoa pessoa;
    private String anoFabricacao;
    @ManyToMany(mappedBy = "veiculos", cascade = CascadeType.ALL)
    private List<Acessorio> acessorios;
    
    

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String placa, Double valor, String anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.valor = valor;
        this.anoFabricacao = anoFabricacao;
    }
    
    

   
    
    public Long getId() {
        return id;
    }

    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
    
    

    @Override
    public String toString() {
        return "Veiculo{" + "marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", valor=" + valor + ", pessoa=" + pessoa + ", anoFabricacao=" + anoFabricacao + '}';
    }
    
    
    

       
    
    
    
    
}
