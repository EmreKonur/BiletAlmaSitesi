/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TicketsDAO;
import entity.Tickets;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emrek
 */
@Named(value = "ticketsBean")
@SessionScoped
public class TicketsBean implements Serializable{
    
    private Tickets entity;
    private TicketsDAO dao;
    private List<Tickets> list;
    public TicketsBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createTickets(entity);
        this.entity=new Tickets();
    }
    
    public void delete(Tickets u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    
    public Tickets getEntity() {
        if(this.entity==null ){
            this.entity=new Tickets();
        }
        return entity;
    }

    public void setEntity(Tickets entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public TicketsDAO getDao() {
        if(this.dao==null ){
            this.dao=new TicketsDAO();
        }
        return dao;
    }
    public void clear(){
        this.entity=new Tickets();
    }

    public void setDao(TicketsDAO dao) {
        this.dao = dao;
    }

    public List<Tickets> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getTicketsList();
        return list;
    }

    public void setList(List<Tickets> list) {
        this.list = list;
    }
}
    
    

