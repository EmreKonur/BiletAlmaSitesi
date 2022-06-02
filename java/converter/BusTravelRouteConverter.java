/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.TravelRouteDAO.BusTravelRouteDAO;
import entity.TravelRoute.BusTravelRoute;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.lang.System;
import java.lang.NullPointerException;

/**
 *
 * @author ucaro
 */
@FacesConverter
public class BusTravelRouteConverter implements Converter{
    private BusTravelRouteDAO ptrDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String id=string;
    BusTravelRoute ptr=this.getPtrDao().findByID(id);
    return ptr;
      }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        BusTravelRoute ptr=(BusTravelRoute)t;
        return ptr.getTravel_route_id();
    }

    public BusTravelRouteDAO getPtrDao() {
        if(ptrDao==null)ptrDao=new BusTravelRouteDAO();
        return ptrDao;
    }

    public void setPtrDao(BusTravelRouteDAO ptrDao) {
        this.ptrDao = ptrDao;
    }
    
}
