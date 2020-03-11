/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.controller;

import br.edu.fafic.model.Veiculo;
import br.edu.fafic.service.VeiculoService;
import br.edu.fafic.util.FacesMessageUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "veiculoMB")
@ViewScoped
public class VeiculoController implements Serializable {

    @EJB
    private VeiculoService vs;
    private boolean renderedInit, renderedBtnCadastro;

    @PostConstruct
    public void init() {
        renderedInit = false;
        renderedBtnCadastro = true;
    }

    private Veiculo veiculo;

    public Veiculo getVeiculo() {
        if (veiculo == null) {
            veiculo = new Veiculo();
        }
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void save() {
        try {
            vs.save(veiculo);
            FacesMessageUtil.success();
        } catch (Exception e) {
            FacesMessageUtil.fail("Um erro ocorreu! A operação não realizada");
        }
        veiculo = null;
        renderedInit = false;
    }

    public List<Veiculo> veiculos() {
        return vs.getAll();
    }

    public void prepareRemoveVeiculo(Veiculo veiculo) {
             this.veiculo = veiculo;
     }
    
    public void confirmRemove() {
        try {
            vs.remove(this.veiculo);
            FacesMessageUtil.success();
        } catch (Exception ex) {
            FacesMessageUtil.fail("Um erro ocorreu! A operação não realizada");
        }

    }

    public boolean isRenderedInit() {
        return renderedInit;
    }

    public void setRenderedInit(boolean renderedInit) {
        this.renderedInit = renderedInit;
        buttonCadastro();
    }

    public boolean isRenderedBtnCadastro() {
        return renderedBtnCadastro;
    }

    public void setRenderedBtnCadastro(boolean renderedBtnCadastro) {
        this.renderedBtnCadastro = renderedBtnCadastro;
    }

    public void buttonCadastro() {
        setRenderedBtnCadastro(false);
    }
    
    public void prepareUpdate(Veiculo veiculo){
        this.veiculo = veiculo;
        this.renderedInit = true;
        
    }
    
   
}
