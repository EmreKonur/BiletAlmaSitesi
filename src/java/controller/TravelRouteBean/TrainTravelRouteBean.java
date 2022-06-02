/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.TravelRouteBean;

import dao.TravelRouteDAO.TrainTravelRouteDAO;
import entity.TravelRoute.TrainTravelRoute;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emrek
 */

@Named(value = "traintravelrouteBean")
@SessionScoped
public class TrainTravelRouteBean implements Serializable {
 
    private TrainTravelRoute entity;
    private TrainTravelRouteDAO dao;
    private List<TrainTravelRoute> list;
         private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public TrainTravelRouteBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createTrainTravelRoute(entity);
        this.entity=new TrainTravelRoute();
    }
    
    public void delete(TrainTravelRoute u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    public TrainTravelRoute getEntity() {
        if(this.entity==null ){
            this.entity=new TrainTravelRoute();
        }
        return entity;
    }

    public void setEntity(TrainTravelRoute entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public TrainTravelRouteDAO getDao() {
        if(this.dao==null ){
            this.dao=new TrainTravelRouteDAO();
        }
        return dao;
    }
    
    public void clear(){
        this.entity=new TrainTravelRoute();
    }

    public void setDao(TrainTravelRouteDAO dao) {
        this.dao = dao;
    }
    public List<TrainTravelRoute> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getTrainTravelRouteList(page,pageSize);
        return list;
    }

    public void setList(List<TrainTravelRoute> list) {
        this.list = list;
    }

    
}

