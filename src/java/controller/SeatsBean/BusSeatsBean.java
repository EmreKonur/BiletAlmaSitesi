/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller.SeatsBean;

import dao.SeatsDAO.BusSeatsDAO;
import entity.Seats.BusSeats;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named(value = "busseatsBean")
@SessionScoped
public class BusSeatsBean implements Serializable {

    private BusSeats entity;
    private BusSeatsDAO dao;
    private List<BusSeats> list;

    public BusSeatsBean() {

    }

    public void create() throws SQLException, ClassNotFoundException {
        this.getDao().createUsers(entity);
        this.entity = new BusSeats();
    }

    public void clear() {
        this.entity = new BusSeats();
    }

    public void delete(BusSeats u) throws ClassNotFoundException, SQLException {
        this.getDao().delete(u);
    }

    public BusSeats getEntity() {
        if (this.entity == null) {
            this.entity = new BusSeats();
        }
        return entity;
    }

    public void setEntity(BusSeats entity) {
        this.entity = entity;
    }

    public BusSeatsDAO getDao() {
        if (this.dao == null) {
            this.dao = new BusSeatsDAO();
        }
        return dao;
    }

    public void setDao(BusSeatsDAO dao) {
        this.dao = dao;
    }

    public List<BusSeats> getList() throws SQLException, ClassNotFoundException {
        this.list = this.getDao().getBusSeatsList();
        return list;
    }

    public void update() throws SQLException, ClassNotFoundException {
        this.getDao().update(entity);
        this.entity = new BusSeats();
    }

    public void setList(List<BusSeats> list) {
        this.list = list;
    }
}