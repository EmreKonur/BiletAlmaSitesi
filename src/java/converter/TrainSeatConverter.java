/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SeatsDAO.TrainSeatsDAO;
import entity.Seats.TrainSeats;
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
@FacesConverter("trainseatsConverter")
public class TrainSeatConverter implements Converter{

    private TrainSeatsDAO psDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String id =string;
        TrainSeats ps=this.getPsDao().findByID(id);
        return ps;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        TrainSeats ps=(TrainSeats)t;
        return ps.getSeat_id();
    }
    public TrainSeatsDAO getPsDao() {
        if(psDao==null)psDao=new TrainSeatsDAO(); 
        return psDao;
    }

    public void setPsDao(TrainSeatsDAO psDao) {
        this.psDao = psDao;
    }
    
}
