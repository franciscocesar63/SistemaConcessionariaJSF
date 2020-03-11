/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;


import br.edu.fafic.enums.TipoPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Luciano
 */
@Entity
public class Loja extends PessoaJuridica {
    
    @OneToMany(mappedBy = "loja", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    public List<Funcionario> getFuncionarios() {
      if(funcionarios == null)  {
          funcionarios = new ArrayList();
      }
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
           
    public Loja(){
        setTipoPessoa(TipoPessoa.Pessoa_Juridica);
    }

       
    
}
