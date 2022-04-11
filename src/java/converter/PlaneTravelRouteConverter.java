/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.TravelRouteDAO.PlaneTravelRouteDAO;
import entity.TravelRoute.PlaneTravelRoute;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.lang.System;
import java.lang.NullPointerException;

/**
 *
 * @author berat
 */
@FacesConverter("planetravelrouteConverter")
public class PlaneTravelRouteConverter implements Converter{
    private PlaneTravelRouteDAO ptrDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String id=string;
    PlaneTravelRoute ptr=this.getPtrDao().findByID(id);
    return ptr;
      }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        PlaneTravelRoute ptr=(PlaneTravelRoute)t;
        return ptr.getTravel_route_id();
    }

    public PlaneTravelRouteDAO getPtrDao() {
        if(ptrDao==null)ptrDao=new PlaneTravelRouteDAO();
        return ptrDao;
    }

    public void setPtrDao(PlaneTravelRouteDAO ptrDao) {
        this.ptrDao = ptrDao;
    }
    
}
