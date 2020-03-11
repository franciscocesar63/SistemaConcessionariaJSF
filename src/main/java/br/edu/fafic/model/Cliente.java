/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

import br.edu.fafic.enums.TipoPessoa;
import javax.persistence.Entity;

/**
 *
 * @author Luciano
 */
@Entity
public class Cliente  extends PessoaFisica {
   

  public Cliente(){
      setTipoPessoa(TipoPessoa.Cliente);
  }

    
    
}
