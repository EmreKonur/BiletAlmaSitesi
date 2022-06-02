/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CompanyDAO;
import entity.Company;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author emrek
 */
@FacesConverter("companyConverter")
public class CompanyConverter implements Converter {

    private CompanyDAO compDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String id = string;
        Company c = this.getCompDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Company c = (Company) t;
        return c.getCompany_id();
    }

    public CompanyDAO getCompDao() {
        if (compDao == null) {
            this.compDao = new CompanyDAO();
        }
        return compDao;
    }

    public void setCompDao(CompanyDAO compDao) {
        this.compDao = compDao;
    }

}
