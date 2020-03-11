/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.service;

import br.edu.fafic.model.Cliente;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Luciano
 */
@Stateless
public class ClienteService extends GenerciService<Cliente> {

    @Override
    public void save(Cliente entity) {
        super.save(entity); 
    }

    @Override
    public Cliente getSingleResultNamedQuery(String query, Map<String, Object> parametros) {
        return super.getSingleResultNamedQuery(query, parametros); 
    }
    
    
    
    
    
    
    
}
