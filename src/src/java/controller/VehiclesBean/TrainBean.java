/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.VehiclesBean;

import dao.VehiclesDAO.TrainDAO;
import entity.Vehicles.Train;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author emrek
 */
@Named(value = "trainBean")
@SessionScoped
public class TrainBean implements Serializable{
    
    private Train entity;
    private TrainDAO dao;
    private List<Train> list;
    public TrainBean() {
        
    }
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createTrain(entity);
        this.entity=new Train();
    }
    
    public void delete(Train u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u);
    }
    
    public Train getEntity() {
        if(this.entity==null ){
            this.entity=new Train();
        }
        return entity;
    }

    public void setEntity(Train entity) {
        this.entity = entity;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
    }

    public TrainDAO getDao() {
        if(this.dao==null ){
            this.dao=new TrainDAO();
        }
        return dao;
    }
    public void clear(){
        this.entity=new Train();
    }

    public void setDao(TrainDAO dao) {
        this.dao = dao;
    }

    public List<Train> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getTrainList();
        return list;
    }

    public void setList(List<Train> list) {
        this.list = list;
    }
}
    
    

