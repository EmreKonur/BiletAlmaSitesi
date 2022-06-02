/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.Vehicles.Bus;
import entity.Vehicles.Plane;
import entity.Vehicles.Train;

/**
 *
 * @author emrek
 */
public class Tickets {
    private String ticket_id,ticket_date,ticket_price,departure_date,arrival_date;
    private Company company;
    private Users users;
    private Plane plane;
    private Bus bus;
    private Train train;
    private Bills bills;
    
            

    public Tickets() {
    }

    public Tickets(String ticket_id,String ticket_date,String ticket_price,String departure_date,String arrival_date,Company company,Users users,Plane plane,Bus bus,Train train,Bills bills) {
        this.ticket_id = ticket_id;
        this.ticket_date = ticket_date;
        this.ticket_price = ticket_price;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.company = company;
        this.users = users;
        this.plane = plane;
        this.bus = bus;
        this.train = train;
        this.bills = bills;
        
        
        
    }

    public Tickets(String string, String string0, String string1, String string2, String string3, Company u, Plane p, Bills b, Users z, Bus c, Train t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTicket_date() {
        return ticket_date;
    }

    public void setTicket_date(String ticket_date) {
        this.ticket_date = ticket_date;
    }

    public String getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(String ticket_price) {
        this.ticket_price = ticket_price;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Bills getBills() {
        return bills;
    }

    public void setBills(Bills bills) {
        this.bills = bills;
    }
    

     

 

    

    

    


   

    
    

}