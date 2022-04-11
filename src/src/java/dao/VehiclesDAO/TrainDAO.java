/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.VehiclesDAO;

import entity.Vehicles.Train;
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
public class TrainDAO extends DBConnection{
    private Connection db;

    public void createTrain(Train u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "insert into train (train_id,company_id,seat_id,travel_route_id) values"+
                " ('"+u.getTrain_id()+"','"+u.getTrain_id()+"','"+u.getSeat_id()+"','"+u.getTravel_route_id()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(Train u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "delete from train where train_id='"+u.getTrain_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    public List<Train> getTrainList() throws SQLException, ClassNotFoundException{
        List<Train> trainList=new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query="Select * from train";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            trainList.add(new Train(rs.getString("train_id"),rs.getString("company_id"),rs.getString("seat_id"),rs.getString("travel_route_id")));
        }
        return trainList;
    }
    public void update(Train u) throws SQLException, ClassNotFoundException{
        Statement st=this.connect().createStatement();
        String query = "update train set company_id='" + "', seat_id='"
                + u.getSeat_id() + "', travel_route_id='" + u.getTravel_route_id()  + "'";
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

    
    public Train findByID(String train_id){
        Train t=null;
        try{
            Statement st = this.connect().createStatement();
            
            String query = "select * from train where train_id="+ train_id ;
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                t = new Train(rs.getString("train_id"),rs.getString("company_id"),rs.getString("seat_id"),rs.getString("travel_route_id"));
                
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return t;
    }
    

    
}

    

