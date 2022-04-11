/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SeatsDAO.PlaneSeatsDAO;
import entity.Seats.PlaneSeats;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author emrek
 */
@FacesConverter("planeseatsConverter")
public class PlaneSeatConverter implements Converter{
    private PlaneSeatsDAO psDao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String id =string;
        PlaneSeats ps=this.getPsDao().findByID(id);
        return ps;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        PlaneSeats ps=(PlaneSeats)t;
        return ps.getSeat_id();
    }
    public PlaneSeatsDAO getPsDao() {
        if(psDao==null)psDao=new PlaneSeatsDAO(); 
        return psDao;
    }

    public void setPsDao(PlaneSeatsDAO psDao) {
        this.psDao = psDao;
    }
}
