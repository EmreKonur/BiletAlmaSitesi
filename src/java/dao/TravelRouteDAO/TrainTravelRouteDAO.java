/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.TravelRouteDAO;

import entity.TravelRoute.TrainTravelRoute;
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
public class TrainTravelRouteDAO extends DBConnection{


    private Connection db;

    public void createTrainTravelRoute(TrainTravelRoute u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "insert into traintravelroute (travel_route_id,\"to\",\"from\") values"+
                " ('"+u.getTravel_route_id()+"','"+u.getTo()+"','"+u.getFrom()+"')";
                
        System.out.println(u.getTravel_route_id()+query);
        int r=st.executeUpdate(query);
    }
    
    public void delete(TrainTravelRoute u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "delete from traintravelroute where travel_route_id='"+u.getTravel_route_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    
    public List<TrainTravelRoute> getTrainTravelRouteList() throws SQLException, ClassNotFoundException{
        List<TrainTravelRoute> TrainTravelRouteList=new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query="Select * from traintravelroute";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            TrainTravelRouteList.add(new TrainTravelRoute(rs.getString("travel_route_id"),rs.getString("to"),rs.getString("from")));
        }
         
         return TrainTravelRouteList;
    }
    
    public void update(TrainTravelRoute u) throws SQLException, ClassNotFoundException{
        Statement st=this.connect().createStatement();
        String query="update traintravelroute set \"to\"='"+u.getTo()+"', \"from\"='"+u.getFrom()+"' where travel_route_id='"+u.getTravel_route_id()+"'";
        System.out.println(query);
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
    public TrainTravelRoute findByID(String travel_route_id) {
        TrainTravelRoute u = null;
        try {
            Statement st = this.connect().createStatement();

            String query = "select * from planetravelroute where travel_route_id='" + travel_route_id+"'";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                u = new TrainTravelRoute(rs.getString("seat_id"), rs.getString("available_seat"), rs.getString("number_of_seats"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
}

    


