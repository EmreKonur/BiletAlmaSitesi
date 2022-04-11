/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.VehiclesDAO;

import dao.CompanyDAO;
import dao.SeatsDAO.TrainSeatsDAO;
import dao.TravelRouteDAO.TrainTravelRouteDAO;
import entity.Company;
import entity.Seats.TrainSeats;
import entity.TravelRoute.TrainTravelRoute;
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
    private CompanyDAO compDao;
    private TrainSeatsDAO psDao;
    private TrainTravelRouteDAO ptrDao;

    public void createTrain(Train u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();
        String query = "insert into train (train_id,company_id,seat_id,travel_route_id) values"+
                " ('"+u.getTrain_id()+"','"+u.getCompany().getCompany_id()+"','"
                +u.getTrainseats().getSeat_id()+"','"+u.getTrainTravelRoute().getTravel_route_id()+"')";
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
            Company c= this.getCompDao().findByID(rs.getString("company_id"));
            TrainSeats ps=this.getPsDao().findByID(rs.getString("seat_id"));
            TrainTravelRoute ptr=this.getPtrDao().findByID(rs.getString("travel_route_id"));
            trainList.add(new Train(rs.getString("train_id"),ps,ptr,c));
        }
        return trainList;
    }
    public void update(Train u) throws SQLException, ClassNotFoundException{
        Statement st=this.connect().createStatement();
        String query = "update train set company_id='" +u.getCompany().getCompany_id()+ "', seat_id='"
                + u.getTrainseats().getSeat_id()+ "', travel_route_id='" + u.getTrainTravelRoute().getTravel_route_id()+ "'";
        st.executeUpdate(query);
    }
    
    
    public Connection getDb() throws SQLException, ClassNotFoundException {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public CompanyDAO getCompDao() {
        return compDao;
    }

    public void setCompDao(CompanyDAO compDao) {
        this.compDao = compDao;
    }

   public TrainSeatsDAO getPsDao() {
        if(psDao==null)psDao=new TrainSeatsDAO(); 
        return psDao;
    }

    public void setPsDao(TrainSeatsDAO psDao) {
        this.psDao = psDao;
    }
    
    public TrainTravelRouteDAO getPtrDao() {
        if(ptrDao==null)ptrDao=new TrainTravelRouteDAO();
        return ptrDao;
    }

    public void setPtrDao(TrainTravelRouteDAO ptrDao) {
        this.ptrDao = ptrDao;
    }
    
}
