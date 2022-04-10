/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller.SeatsBean;

import dao.SeatsDAO.TrainSeatsDAO;
import entity.Seats.TrainSeats;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named(value = "trainseatsBean")
@SessionScoped
public class TrainSeatsBean implements Serializable {

    private TrainSeats entity;
    private TrainSeatsDAO dao;
    private List<TrainSeats> list;

    public TrainSeatsBean() {

    }

    public void create() throws SQLException, ClassNotFoundException {
        this.getDao().createUsers(entity);
        this.entity = new TrainSeats();
    }

    public void clear() {
        this.entity = new TrainSeats();
    }

    public void delete(TrainSeats u) throws ClassNotFoundException, SQLException {
        this.getDao().delete(u);
    }

    public TrainSeats getEntity() {
        if (this.entity == null) {
            this.entity = new TrainSeats();
        }
        return entity;
    }

    public void setEntity(TrainSeats entity) {
        this.entity = entity;
    }

    public TrainSeatsDAO getDao() {
        if (this.dao == null) {
            this.dao = new TrainSeatsDAO();
        }
        return dao;
    }

    public void setDao(TrainSeatsDAO dao) {
        this.dao = dao;
    }

    public List<TrainSeats> getList() throws SQLException, ClassNotFoundException {
        this.list = this.getDao().getTrainSeatsList();
        return list;
    }

    public void update() throws SQLException, ClassNotFoundException {
        this.getDao().update(entity);
        this.entity = new TrainSeats();
    }

    public void setList(List<TrainSeats> list) {
        this.list = list;
    }
}