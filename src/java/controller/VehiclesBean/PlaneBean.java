/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.VehiclesBean;

import dao.VehiclesDAO.PlaneDAO;
import entity.Vehicles.Plane;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emrek
 */
@Named(value = "planeBean")
@SessionScoped
public class PlaneBean implements Serializable{
    
    private Plane entity;
    private PlaneDAO dao;
    private List<Plane> list;
    public PlaneBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createPlane(entity);
        this.entity=new Plane();
    }
    
    public void delete(Plane u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    
    public Plane getEntity() {
        if(this.entity==null ){
            this.entity=new Plane();
        }
        return entity;
    }

    public void setEntity(Plane entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public PlaneDAO getDao() {
        if(this.dao==null ){
            this.dao=new PlaneDAO();
        }
        return dao;
    }
    public void clear(){
        this.entity=new Plane();
    }

    public void setDao(PlaneDAO dao) {
        this.dao = dao;
    }

    public List<Plane> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getPlaneList();
        return list;
    }

    public void setList(List<Plane> list) {
        this.list = list;
    }
}
    
    

