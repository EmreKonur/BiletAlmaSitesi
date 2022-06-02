/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bus;
import java.sql.Connection;
import util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BusDAO extends DBConnection {

    private Connection db;

    public void create(Bus b) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();
        String query = "insert into bus (bus_id,company_id,seat_id"
                + "travel_route_id,bus_plate_number,seat_design) values"
                 + "'" + b.getBus_id()+ "',"
                + "'" + b.getCompany_id()+ "',"
                + "'" + b.getSeat_id() + "',"
                + "'" + b.getTravel_route_id() + "',"
                + "'" + b.getBus_plate_number() + "',"
                + "'" + b.getSeat_design() + "')";        
        int r = st.executeUpdate(query);
    }

    public void delete(Bus b) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "delete from bus where bus_id='" + b.getBus_id() + "'";
        int r = st.executeUpdate(query);
    }

    public List<Bus> getBusList() throws SQLException, ClassNotFoundException {
        List<Bus> busList = new ArrayList<>();

        Statement st = this.getDb().createStatement();
        String query = "Select * from bus";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            busList.add(new Bus(rs.getString("bus_id"), rs.getString("company_id"),
                    rs.getString("seat_id"), rs.getString("travel_route_id"),
                    rs.getString("bus_plate_number"), rs.getString("seat_design")));
        }

        return busList;
    }

    public void update(Bus b) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();
        String query = " ='"+ b.getCompany_id() + "', Seat_id='" + b.getTravel_route_id()
                + "', bus_plate_number='" + b.getBus_plate_number()
                + "',seat_design='" + b.getSeat_design()
                + "'  where bus_id='" + b.getBus_id() + "'";
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
}
