/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.SeatsDAO;

import entity.Seats.TrainSeats;
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
public class TrainSeatsDAO extends DBConnection{ 

    private Connection db;

    public void createUsers(TrainSeats u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "insert into trainseats (seat_id,available_seat,number_of_seats) values"
                + "('" + u.getSeat_id()+ "',"
                + "'" + u.getAvailable_seat()+ "',"
                + "'" + u.getNumber_of_seats()+ "')";
        int r = st.executeUpdate(query);
    }

    public void delete(TrainSeats u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "delete from trainseats where seat_id='" + u.getSeat_id() + "'";
        int r = st.executeUpdate(query);
    }

    public List<TrainSeats> getTrainSeatsList() throws SQLException, ClassNotFoundException {
        List<TrainSeats> TrainSeatsList = new ArrayList<>();

        Statement st = this.getDb().createStatement();
        String query = "Select * from trainseats";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            TrainSeatsList.add(new TrainSeats(rs.getString("seat_id"), rs.getString("available_seat"),rs.getString("number_of_seats")));
        }

        return TrainSeatsList;
    }

    public void update(TrainSeats u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();
        String query = "update trainseats set available_seat='"
                + u.getAvailable_seat()+ "', number_of_seats='" + u.getNumber_of_seats()
                + "'  where seat_id='" + u.getSeat_id()+ "'";
        st.executeUpdate(query);
    }

    public Connection getDb() throws SQLException, ClassNotFoundException {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
    public TrainSeats findByID(String seat_id) {
        TrainSeats u = null;
        try {
            Statement st = this.connect().createStatement();

            String query = "select * from planeseats where seat_id=" + seat_id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                u = new TrainSeats(rs.getString("seat_id"), rs.getString("available_seat"), rs.getString("number_of_seats"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
}
    

