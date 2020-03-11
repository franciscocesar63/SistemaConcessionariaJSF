/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.controller;

import br.edu.fafic.model.Pessoa;
import br.edu.fafic.service.LoginService;
import br.edu.fafic.util.FacesMessageUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luciano
 */
@ManagedBean(name = "loginMB")
@ViewScoped
public class LoginController implements Serializable {

    @EJB
    private LoginService loginService;

    private String login;

    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void logar() {

        try {
            String paginaDestino = "login.xtml";
            StringBuilder builder = new StringBuilder();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Pessoa p;
            p = loginService.getPessoaByLogin(login, senha);

            if (p != null) {
                paginaDestino = "";
                paginaDestino = builder.append("/")
                        .append(p.getTipoPessoa().getTipo()
                                .toLowerCase()).append("/index.xhtml?faces-redirect=true").toString();
                System.out.println("Página de destino: " + paginaDestino);
            } else {
                FacesMessageUtil.fail("Login ou senha inválidos");
            }
            NavigationHandler navigation = facesContext.getApplication().getNavigationHandler();
            navigation.handleNavigation(facesContext, null, paginaDestino);

         }catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }

 }
}