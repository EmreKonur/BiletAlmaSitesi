/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.TravelRouteDAO.TrainTravelRouteDAO;
import entity.TravelRoute.TrainTravelRoute;
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
@FacesConverter("traintravelrouteConverter")
public class TrainTravelRouteConverter implements Converter{
    private TrainTravelRouteDAO ptrDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    String id=string;
    TrainTravelRoute ptr=this.getPtrDao().findByID(id);
    return ptr;
      }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        TrainTravelRoute ptr=(TrainTravelRoute)t;
        return ptr.getTravel_route_id();
    }

    public TrainTravelRouteDAO getPtrDao() {
        if(ptrDao==null)ptrDao=new TrainTravelRouteDAO();
        return ptrDao;
    }

    public void setPtrDao(TrainTravelRouteDAO ptrDao) {
        this.ptrDao = ptrDao;
    }
    
}
