/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.validator.Validator;
import jakarta.inject.Named;

@Named("loginValidator")
@FacesValidator
public class LoginValidator implements Validator{
    String turkceKarakterler="ğĞçÇşŞüÜöÖıİ";
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
       
    }
    
    public boolean passValidator(FacesContext fc, UIComponent uic, Object t) throws ValidatorException{
        
        String pass=(String)t;
        if(pass.matches(turkceKarakterler)){
            throw new ValidatorException(new FacesMessage("Türkçe Karakter Giremezsiniz."));
        }
        return true;  
    }
    public boolean emailValidator(FacesContext fc, UIComponent uic, Object t) throws ValidatorException{
        String email=(String)t;
        if(!email.contains("@")){
            throw new ValidatorException(new FacesMessage("Lutfen geçerli bir email giriniz. '@' içermelidir."));
        }
        return true;
    }
}
