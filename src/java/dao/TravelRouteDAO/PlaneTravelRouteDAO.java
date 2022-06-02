/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.TravelRouteDAO;

import entity.TravelRoute.PlaneTravelRoute;
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
public class PlaneTravelRouteDAO extends DBConnection{


    private Connection db;

    public void createPlaneTravelRoute(PlaneTravelRoute u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "insert into planetravelroute (travel_route_id,\"to\",\"from\") values"+
                " ('"+u.getTravel_route_id()+"','"+u.getTo()+"','"+u.getFrom()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(PlaneTravelRoute u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "delete from planetravelroute where travel_route_id='"+u.getTravel_route_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    
    public List<PlaneTravelRoute> getPlaneTravelRouteList(int page,int pageSize) throws SQLException, ClassNotFoundException{
        List<PlaneTravelRoute> PlaneTravelRouteList=new ArrayList<>();
        int start = (page - 1) * pageSize;
        Statement st = this.getDb().createStatement();
        String query="Select * from planetravelroute order by travel_route_id asc limit '" + pageSize + "' offset '" + start + "'";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            PlaneTravelRouteList.add(new PlaneTravelRoute(rs.getString("travel_route_id"),rs.getString("to"),rs.getString("from")));
        }
         
         return PlaneTravelRouteList;
    }
    
                    public int count() {
        int count = 0;

        try {

            Statement st = this.getConnection().createStatement();
            String q = "select count(travel_route_id) as planetravelroute_count from planetravelroute";
            ResultSet rs = st.executeQuery(q);
            rs.next();
            count = rs.getInt("planetravelroute_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return count;
    }
    
    public void update(PlaneTravelRoute u) throws SQLException, ClassNotFoundException{
        Statement st=this.getConnection().createStatement();
        String query="update planetravelroute set \"to\"='"+u.getTo()+"', \"from\"='"+u.getFrom()+"' where travel_route_id='"+u.getTravel_route_id()+"'";
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
    public PlaneTravelRoute findByID(String travel_route_id) {
        PlaneTravelRoute u = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from planetravelroute where travel_route_id=" + travel_route_id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                u = new PlaneTravelRoute(rs.getString("seat_id"), rs.getString("available_seat"), rs.getString("number_of_seats"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
}

    


