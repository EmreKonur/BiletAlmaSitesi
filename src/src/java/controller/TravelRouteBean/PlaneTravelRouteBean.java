/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.TravelRouteBean;

import dao.TravelRouteDAO.PlaneTravelRouteDAO;
import entity.TravelRoute.PlaneTravelRoute;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emrek
 */

@Named(value = "planetravelrouteBean")
@SessionScoped
public class PlaneTravelRouteBean implements Serializable {
 
    private PlaneTravelRoute entity;
    private PlaneTravelRouteDAO dao;
    private List<PlaneTravelRoute> list;
    public PlaneTravelRouteBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createPlaneTravelRoute(entity);
        this.entity=new PlaneTravelRoute();
    }
    
    public void delete(PlaneTravelRoute u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    public PlaneTravelRoute getEntity() {
        if(this.entity==null ){
            this.entity=new PlaneTravelRoute();
        }
        return entity;
    }

    public void setEntity(PlaneTravelRoute entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public PlaneTravelRouteDAO getDao() {
        if(this.dao==null ){
            this.dao=new PlaneTravelRouteDAO();
        }
        return dao;
    }
    
    public void clear(){
        this.entity=new PlaneTravelRoute();
    }

    public void setDao(PlaneTravelRouteDAO dao) {
        this.dao = dao;
    }
    public List<PlaneTravelRoute> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getPlaneTravelRouteList();
        return list;
    }

    public void setList(List<PlaneTravelRoute> list) {
        this.list = list;
    }

    
}

