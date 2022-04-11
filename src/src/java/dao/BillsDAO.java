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

public class BillsDAO extends DBConnection{
    private Connection db;
    
    public Bills findByID(String bills_id){
        Bills b=null;
        try{
            Statement st = this.connect().createStatement();
            
            String query = "select * from bills where bills_id="+ bills_id ;
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                b = new Bills(rs.getString("bills_id"),rs.getString("bills_date"));
                
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return b;
    }
    public void createBills(Bills u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "insert into bills (bills_id,bills_date) values"+
                " ('"+u.getBills_id()+"','"+u.getBills_date()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(Bills u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "delete from bills where bills_id='"+u.getBills_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    public List<Bills> getBillsList() throws SQLException, ClassNotFoundException{
        List<Bills> billsList=new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query="Select * from bills";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            billsList.add(new Bills(rs.getString("bills_id"),rs.getString("bills_date")));
        }
        return billsList;
    }
    public void update(Bills u) throws SQLException, ClassNotFoundException{
        Statement st=this.connect().createStatement();
        String query="update bills set bills_date='"+u.getBills_date()+"' where bills_id='"+u.getBills_id()+"'";
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
