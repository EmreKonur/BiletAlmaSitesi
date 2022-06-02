/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bills;
import entity.Company;
import entity.Tickets;
import entity.Users;
import entity.Vehicles.Bus;
import entity.Vehicles.Plane;
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
public class TicketsDAO extends DBConnection{
    private Connection db;
    private CompanyDAO cdao;
    private Plane pdao;
    private Bills bdao;
    private Users udao;
    private Bus xdao;
    private Train tdao;

    public CompanyDAO getCdao() {
        return cdao;
    }

    public void setCdao(CompanyDAO cdao) {
        this.cdao = cdao;
    }

    public Plane getPdao() {
        return pdao;
    }

    public void setPdao(Plane pdao) {
        this.pdao = pdao;
    }

    public Bills getBdao() {
        return bdao;
    }

    public void setBdao(Bills bdao) {
        this.bdao = bdao;
    }

    public Users getUdao() {
        return udao;
    }

    public void setUdao(Users udao) {
        this.udao = udao;
    }

    public Bus getXdao() {
        return xdao;
    }

    public void setXdao(Bus xdao) {
        this.xdao = xdao;
    }

    public Train getTdao() {
        return tdao;
    }

    public void setTdao(Train tdao) {
        this.tdao = tdao;
    }
    
    
    
    public void createTickets(Tickets u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "insert into tickets (ticket_id,ticket_date,ticket_price,departure_date,arrival_date,company_id,user_tckn,plane_id,bus_id,train_id,bills_id) values"+
                " ('"+u.getTicket_id()+"','"+u.getTicket_date()+"','"+u.getTicket_price()+"','"+u.getDeparture_date()+"','"+u.getArrival_date()+"','"+u.getCompany().getCompany_id()+"','"+u.getUsers().getUser_tckn+"','"+u.getPlane().getPlane_id+"','"+u.getBus().getBus_id+"','"+u.getTrain().getTrain_id+"','"+u.getBills().getBills_id()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(Tickets u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "delete from tickets where ticket_id='"+u.getTicket_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    public List<Tickets> getTicketsList() throws SQLException, ClassNotFoundException{
        List<Tickets> ticketList=new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query="Select * from tickets";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            Company u =this.getCdao().findByID(rs.getString("company_id"));
            Plane p = this.getPdao().findByID(rs.getString("plane_id"));
            Bills b = this.getBdao().findByID(rs.getString("bills_id"));
            Users z = this.getUdao().findByID(rs.getString("user_tckn"));
            Bus c = this.getXdao().findByID(rs.getString("bus_id"));
            Train t = this.getTdao().findByID(rs.getString("train_id"));
            ticketList.add(new Tickets(rs.getString("ticket_id"),rs.getString("ticket_date"),rs.getString("ticket_price"),rs.getString("departure_date"),rs.getString("arrival_date"),u,p,b,z,c,t));
        }
        return ticketList;
    }
    public void update(Tickets u) throws SQLException, ClassNotFoundException{
        Statement st=this.getConnection().createStatement();
        String query = "update tickets set user_tckn='" + "', ticket_date='"
                + u.getTicket_date() + "', ticket_price='" + u.getTicket_price()  + "', departure_date='" + u.getDeparture_date()  + "', arrival_date='" + u.getArrival_date()  + "'"
                +"', company_id='" + u.getCompany().getCompany_id()  + "', plane_id='" + u.getPlane().getPlane_id()  + "', bus_id='" + u.getBus().getBus_id()  + "', train_id='" + u.getTrain().getTrain_id()  + "'"
                +"', bills_id='" + u.getBills().getBills_id()  + "'";
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

    

