/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import util.DBConnection;
import entity.Bills;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillsDAO extends DBConnection {

    private Connection db;

    public Bills findByID(String bills_id) {
        Bills b = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from bills where bills_id=" + bills_id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                b = new Bills(rs.getString("bills_id"), rs.getString("bills_date"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return b;
    }

    public void createBills(Bills u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "insert into bills (bills_id,bills_date) values"
                + " ('" + u.getBills_id() + "','" + u.getBills_date() + "')";
        int r = st.executeUpdate(query);
    }

    public void delete(Bills u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "delete from bills where bills_id='" + u.getBills_id() + "'";
        int r = st.executeUpdate(query);
    }

    public List<Bills> getBillsList(int page, int pageSize) throws SQLException, ClassNotFoundException {
        List<Bills> billsList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        Statement st = this.getDb().createStatement();
        String query = "Select * from bills order by bills_id asc limit '" + pageSize + "' offset '" + start + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            billsList.add(new Bills(rs.getString("bills_id"), rs.getString("bills_date")));
        }
        return billsList;
    }

    public int count() {
        int count = 0;

        try {

            Statement st = this.getConnection().createStatement();
            String q = "select count(bills_id) as bills_count from bills";
            ResultSet rs = st.executeQuery(q);
            rs.next();
            count = rs.getInt("bills_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return count;
    }

    public void update(Bills u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();
        String query = "update bills set bills_date='" + u.getBills_date() + "' where bills_id='" + u.getBills_id() + "'";
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
}
