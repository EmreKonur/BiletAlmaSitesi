/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.TravelRouteBean;

import dao.TravelRouteDAO.BusTravelRouteDAO;
import entity.TravelRoute.BusTravelRoute;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emrek
 */

@Named(value = "bustravelrouteBean")
@SessionScoped
public class BusTravelRouteBean implements Serializable {
 
    private BusTravelRoute entity;
    private BusTravelRouteDAO dao;
    private List<BusTravelRoute> list;
    public BusTravelRouteBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createBusTravelRoute(entity);
        this.entity=new BusTravelRoute();
    }
    
    public void delete(BusTravelRoute u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    public BusTravelRoute getEntity() {
        if(this.entity==null ){
            this.entity=new BusTravelRoute();
        }
        return entity;
    }

    public void setEntity(BusTravelRoute entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public BusTravelRouteDAO getDao() {
        if(this.dao==null ){
            this.dao=new BusTravelRouteDAO();
        }
        return dao;
    }
    
    public void clear(){
        this.entity=new BusTravelRoute();
    }

    public void setDao(BusTravelRouteDAO dao) {
        this.dao = dao;
    }
    public List<BusTravelRoute> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getBusTravelRouteList();
        return list;
    }

    public void setList(List<BusTravelRoute> list) {
        this.list = list;
    }

    
}
