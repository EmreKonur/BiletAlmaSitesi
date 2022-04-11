/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller.SeatsBean;

import dao.SeatsDAO.PlaneSeatsDAO;
import entity.Seats.PlaneSeats;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named(value = "planeseatsBean")
@SessionScoped
public class PlaneSeatsBean implements Serializable {

    private PlaneSeats entity;
    private PlaneSeatsDAO dao;
    private List<PlaneSeats> list;

    public PlaneSeatsBean() {

    }

    public void create() throws SQLException, ClassNotFoundException {
        this.getDao().createUsers(entity);
        this.entity = new PlaneSeats();
    }

    public void clear() {
        this.entity = new PlaneSeats();
    }

    public void delete(PlaneSeats u) throws ClassNotFoundException, SQLException {
        this.getDao().delete(u);
    }

    public PlaneSeats getEntity() {
        if (this.entity == null) {
            this.entity = new PlaneSeats();
        }
        return entity;
    }

    public void setEntity(PlaneSeats entity) {
        this.entity = entity;
    }

    public PlaneSeatsDAO getDao() {
        if (this.dao == null) {
            this.dao = new PlaneSeatsDAO();
        }
        return dao;
    }

    public void setDao(PlaneSeatsDAO dao) {
        this.dao = dao;
    }

    public List<PlaneSeats> getList() throws SQLException, ClassNotFoundException {
        this.list = this.getDao().getPlaneSeatsList();
        return list;
    }

    public void update() throws SQLException, ClassNotFoundException {
        this.getDao().update(entity);
        this.entity = new PlaneSeats();
    }

    public void setList(List<PlaneSeats> list) {
        this.list = list;
    }
}