/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.BillsDAO;
import entity.Bills;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named(value = "billsBean")
@SessionScoped
public class BillsBean implements Serializable {
    private Bills entity;
    private BillsDAO dao;
    private List<Bills> list;
    public BillsBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createBills(entity);
        this.entity=new Bills();
    }
    
    public void delete(Bills u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    
    public Bills getEntity() {
        if(this.entity==null ){
            this.entity=new Bills();
        }
        return entity;
    }

    public void setEntity(Bills entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public BillsDAO getDao() {
        if(this.dao==null ){
            this.dao=new BillsDAO();
        }
        return dao;
    }
    public void clear(){
        this.entity=new Bills();
    }

    public void setDao(BillsDAO dao) {
        this.dao = dao;
    }

    public List<Bills> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getBillsList();
        return list;
    }

    public void setList(List<Bills> list) {
        this.list = list;
    }
}