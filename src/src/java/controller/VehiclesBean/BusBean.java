/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.VehiclesBean;

import dao.VehiclesDAO.BusDAO;
import entity.Vehicles.Bus;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emrek
 */
@Named(value = "busBean")
@SessionScoped
public class BusBean implements Serializable{
    
    private Bus entity;
    private BusDAO dao;
    private List<Bus> list;
    public BusBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createBus(entity);
        this.entity=new Bus();
    }
    
    public void delete(Bus u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    
    public Bus getEntity() {
        if(this.entity==null ){
            this.entity=new Bus();
        }
        return entity;
    }

    public void setEntity(Bus entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public BusDAO getDao() {
        if(this.dao==null ){
            this.dao=new BusDAO();
        }
        return dao;
    }
    public void clear(){
        this.entity=new Bus();
    }

    public void setDao(BusDAO dao) {
        this.dao = dao;
    }

    public List<Bus> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getBusList();
        return list;
    }

    public void setList(List<Bus> list) {
        this.list = list;
    }
}
    
    

