/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import dao.UsersDAO;
import entity.Users;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable{
    private Users user;
    private UsersDAO udao;
    private String eposta;
    private String sifre;

    public SessionBean() {
    }

    public String login() {
        Users user = this.getUdao().getUser(this.eposta, this.sifre);
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("users", user);
            return "index?=faces-redirect=true"; 
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı bilgileri geçersiz."));
            return "login?=faces-redirect=true"; 
        }
    }
    
    

    public Users getUser() {
        return user;
    }
    
    public Users updateUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UsersDAO getUdao() {
        if (this.udao == null) {
            this.udao = new UsersDAO();
        }
        return udao;
    }

    public void setUdao(UsersDAO udao) {
        this.udao = udao;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
