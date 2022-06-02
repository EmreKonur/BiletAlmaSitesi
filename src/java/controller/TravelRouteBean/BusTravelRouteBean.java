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
        this.list=this.getDao().getBusTravelRouteList(page, pageSize);
        return list;
    }

    public void setList(List<BusTravelRoute> list) {
        this.list = list;
    }

    
}
