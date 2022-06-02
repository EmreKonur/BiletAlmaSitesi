/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SeatsDAO.BusSeatsDAO;
import entity.Seats.BusSeats;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.System;
import java.lang.NullPointerException;
/**
 *
 * @author ucaro
 */
@FacesConverter
public class BusSeatConverter implements Converter{
    private BusSeatsDAO psDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String id =string;
        BusSeats ps=this.getPsDao().findByID(id);
        return ps;
    }
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        BusSeats ps=(BusSeats)t;
        return ps.getSeat_id();
    }
    public BusSeatsDAO getPsDao() {
        if(psDao==null)psDao=new BusSeatsDAO(); 
        return psDao;
    }

    public void setPsDao(BusSeatsDAO psDao) {
        this.psDao = psDao;
    }
    
}
