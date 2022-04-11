/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.VehiclesDAO.PlaneDAO;
import entity.Vehicles.Plane;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author emrek
 */
@FacesConverter("planeConverter")
public class PlaneConverter implements Converter {
    private PlaneDAO planedao;
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        String id = arg2;
        Plane p = this.getPlanedao().findByID(id);
        return p;
        
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Plane p=(Plane)arg2;
        return p.getPlane_id();
    }

    public PlaneDAO getPlanedao() {
        if(planedao==null){
            planedao = new PlaneDAO();
        }
        return planedao;
        
    }

    public void setPlanedao(PlaneDAO planedao) {
        this.planedao = planedao;
    }

    

    
    
    
    
}
