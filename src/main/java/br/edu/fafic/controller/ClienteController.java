/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.controller;

import br.edu.fafic.model.Cliente;
import br.edu.fafic.service.ClienteService;
import br.edu.fafic.util.FacesMessageUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteController implements Serializable {
    
    
    private Cliente cliente;
    
    @EJB
    private ClienteService clienteService;

    public Cliente getCliente() {
      if(cliente == null)  {
          cliente = new Cliente();
      }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void save(){
        try{
            clienteService.save(cliente);
            FacesMessageUtil.success();
        }catch(Exception e){
            FacesMessageUtil.fail("Um erro ocorreu. Operação não realizada!");
        }
    }
    
    
}
