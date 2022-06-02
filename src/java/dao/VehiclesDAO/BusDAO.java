/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.VehiclesDAO;


import dao.CompanyDAO;
import dao.SeatsDAO.BusSeatsDAO;
import entity.Company;
import entity.Seats.BusSeats;
import entity.Vehicles.Bus;
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
public class BusDAO extends DBConnection{
    private Connection db;
    private BusSeatsDAO bsdao;
    private CompanyDAO cdao;

    public void createBus(Bus u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();
        String query = "insert into bus (bus_id,company_id,seat_id,travel_route_id,seat_design,bus_plate_number) values"+
                " ('"+u.getBus_id()+"','"+u.getC().getCompany_id()+"','"+u.getB().getSeat_id()+"','"+u.getTravel_route_id()+"','"+u.getBus_plate_number()+"','"+u.getSeat_design()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(Bus u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "delete from bus where bus_id='"+u.getBus_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    public List<Bus> getBusList() throws SQLException, ClassNotFoundException{
        List<Bus> busList=new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query="Select * from bus";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            BusSeats b= this.bsdao.findByID(rs.getString("seat_id"));
            Company c=this.cdao.findByID(rs.getString("company_id"));
            busList.add(new Bus(rs.getString("bus_id"),c,b,rs.getString("travel_route_id"),rs.getString("bus_plate_number"),rs.getString("seat_design")));
        }
        return busList;
    }
    public void update(Bus u) throws SQLException, ClassNotFoundException{
        Statement st=this.getConnection().createStatement();
        String query = "update bus set company_id='" +u.getC().getCompany_id()+"', seat_id='"
                + u.getB().getSeat_id()+ "', travel_route_id='" + u.getTravel_route_id()  + "', bus_plate_number='" + u.getBus_plate_number()  + "', seat_design='" + u.getSeat_design()  + "'";
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
    
    public Bus findByID(String bus_id){
        Bus c=null;
        try{
            Statement st = this.getConnection().createStatement();
            
            String query = "select * from bus where bus_id='"+ bus_id+"'" ;
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                
                BusSeats b= this.bsdao.findByID(rs.getString("seat_id"));
                
                Company x=this.cdao.findByID(rs.getString("company_id"));
                c = new Bus(rs.getString("bus_id"),x,b,rs.getString("travel_route_id"),rs.getString("bus_plate_number"),rs.getString("seat_design"));
                
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    

    
}

    

