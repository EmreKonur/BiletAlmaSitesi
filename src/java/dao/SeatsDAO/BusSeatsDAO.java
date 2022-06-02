/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.SeatsDAO;

import entity.Seats.BusSeats;
import entity.Seats.PlaneSeats;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author emrek
 */
public class BusSeatsDAO extends DBConnection {

    private Connection db;

    public BusSeatsDAO() {
    }

    public void createUsers(BusSeats u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "insert into busseats (seat_id,available_seat,number_of_seats) values"
                + "('" + u.getSeat_id() + "',"
                + "'" + u.getAvailable_seat() + "',"
                + "'" + u.getNumber_of_seats() + "')";
        int r = st.executeUpdate(query);
    }

    public void delete(BusSeats u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "delete from busseats where seat_id='" + u.getSeat_id() + "'";
        int r = st.executeUpdate(query);
    }

    public List<BusSeats> getBusSeatsList() throws SQLException, ClassNotFoundException {
        List<BusSeats> busSeatsList = new ArrayList<>();

        Statement st = this.getDb().createStatement();
        String query = "Select * from busseats";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            busSeatsList.add(new BusSeats(rs.getString("seat_id"), rs.getString("available_seat"), rs.getString("number_of_seats")));
        }

        return busSeatsList;
    }

    public void update(BusSeats u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();
        String query = "update busseats set available_seat='"
                + u.getAvailable_seat() + "', number_of_seats='" + u.getNumber_of_seats()
                + "'  where seat_id='" + u.getSeat_id() + "'";
        st.executeUpdate(query);
    }

    public Connection getDb() throws SQLException, ClassNotFoundException {
        if (this.db == null) {
            this.db = this.getConnection();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public BusSeats findByID(String seat_id) {
        BusSeats u = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from busseats where seat_id= '"+ seat_id + "'";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                u = new BusSeats(rs.getString("seat_id"), rs.getString("available_seat"), rs.getString("number_of_seats"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
}
