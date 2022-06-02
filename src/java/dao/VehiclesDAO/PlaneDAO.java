package dao.VehiclesDAO;

import dao.CompanyDAO;
import dao.SeatsDAO.PlaneSeatsDAO;
import dao.TravelRouteDAO.PlaneTravelRouteDAO;
import entity.Company;
import entity.Seats.PlaneSeats;
import entity.TravelRoute.PlaneTravelRoute;
import entity.Vehicles.Plane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class PlaneDAO extends DBConnection {

    private Connection db;
    private CompanyDAO compDao;
    private PlaneSeatsDAO psDao;
    private PlaneTravelRouteDAO ptrDao;

    public void createPlane(Plane u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();
        String query = "insert into plane (plane_id,company_id,seat_id,travel_route_id) values"
                + " ('" + u.getPlane_id() + "','" + u.getCompany().getCompany_id() + "','"
                + u.getPlaneseats().getSeat_id() + "','" + u.getPlaneTravelRoute().getTravel_route_id() + "')";
        int r = st.executeUpdate(query);
    }

    public void delete(Plane u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "delete from plane where plane_id='" + u.getPlane_id() + "'";
        int r = st.executeUpdate(query);
    }

    public List<Plane> getPlaneList() throws SQLException, ClassNotFoundException {
        List<Plane> planeList = new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query = "Select * from plane";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Company c = this.getCompDao().findByID(rs.getString("company_id"));
            PlaneSeats ps = this.getPsDao().findByID(rs.getString("seat_id"));
            PlaneTravelRoute ptr = this.getPtrDao().findByID(rs.getString("travel_route_id"));
            planeList.add(new Plane(rs.getString("plane_id"), ps, ptr, c));
        }
        return planeList;
    }

    public void update(Plane u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();
        String query = "update plane set company_id='" + u.getCompany().getCompany_id() + "', seat_id='"
                + u.getPlaneseats().getSeat_id() + "', travel_route_id='" + u.getPlaneTravelRoute().getTravel_route_id() + "'";
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

    public CompanyDAO getCompDao() {
        if (compDao == null) {
            this.compDao = new CompanyDAO();
        }
        return compDao;
    }

    public void setCompDao(CompanyDAO compDao) {
        this.compDao = compDao;
    }

    public PlaneSeatsDAO getPlaneDao() {
        if (psDao == null) {
            psDao = new PlaneSeatsDAO();
        }
        return psDao;
    }

    public void setPlaneDao(PlaneSeatsDAO psDao) {
        this.psDao = psDao;
    }

    public PlaneTravelRouteDAO getPtrDao() {
        if (ptrDao == null) {
            ptrDao = new PlaneTravelRouteDAO();
        }
        return ptrDao;
    }

    public void setPtrDao(PlaneTravelRouteDAO ptrDao) {
        this.ptrDao = ptrDao;
    }

    public Plane findByID(String seat_id) {
        Plane p = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from plane where seat_id='" + seat_id + "'";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Company c = this.getCompDao().findByID(rs.getString("company_id"));
                PlaneSeats ps = this.getPsDao().findByID(rs.getString("seat_id"));
                PlaneTravelRoute ptr = this.getPtrDao().findByID(rs.getString("travel_route_id"));
                p = new Plane(rs.getString("plane_id"), ps, ptr, c);
            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    public PlaneSeatsDAO getPsDao() {
        return psDao;
    }

    public void setPsDao(PlaneSeatsDAO psDao) {
        this.psDao = psDao;
    }

}
