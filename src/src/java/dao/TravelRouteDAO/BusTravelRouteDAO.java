/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.TravelRouteDAO;

import entity.TravelRoute.BusTravelRoute;
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
public class BusTravelRouteDAO extends DBConnection{


    private Connection db;

    public void createBusTravelRoute(BusTravelRoute u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "insert into bustravelroute (travel_route_id,\"to\",\"from\") values"+
                " ('"+u.getTravel_route_id()+"','"+u.getTo()+"','"+u.getFrom()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(BusTravelRoute u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "delete from bustravelroute where travel_route_id='"+u.getTravel_route_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    
    public List<BusTravelRoute> getBusTravelRouteList() throws SQLException, ClassNotFoundException{
        List<BusTravelRoute> BusTravelRouteList=new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query="Select * from bustravelroute";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            BusTravelRouteList.add(new BusTravelRoute(rs.getString("travel_route_id"),rs.getString("to"),rs.getString("from")));
        }
         
         return BusTravelRouteList;
    }
    
    public void update(BusTravelRoute u) throws SQLException, ClassNotFoundException{
        Statement st=this.connect().createStatement();
        String query="update bustravelroute set \"to\"='"+u.getTo()+"' ,\"from\"='"+u.getFrom()+"' where travel_route_id='"+u.getTravel_route_id()+"'";
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

    

