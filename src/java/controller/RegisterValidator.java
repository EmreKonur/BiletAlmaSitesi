/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

/**
 *
 * @author berat
 */
@Named("registerValidator")
@FacesValidator
public class RegisterValidator implements Validator{
    String turkceKarakterler="ğĞçÇşŞüÜöÖıİ";
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public boolean emailValidator(FacesContext fc, UIComponent uic, Object t) throws ValidatorException{
        String email=(String)t;
        
        if(!email.contains("@")){
            throw new ValidatorException(new FacesMessage("Lutfen geçerli bir email giriniz. '@' içermelidir."));
        }
        return true;
    }
    public boolean passValidator(FacesContext fc, UIComponent uic, Object t) throws ValidatorException{
        
        String pass=(String)t;
        if(pass.matches(turkceKarakterler)){
            throw new ValidatorException(new FacesMessage("Türkçe Karakter Giremezsiniz."));
        }
        return true;  
    }
    public boolean tcknValidator(FacesContext fc, UIComponent uic, Object t) throws ValidatorException{
        
        String tckn=(String)t;
        if(tckn.length()<11){
            throw new ValidatorException(new FacesMessage("11 karakter girmeniz gerekli."));
        }
        return true;  
    }
    
}
