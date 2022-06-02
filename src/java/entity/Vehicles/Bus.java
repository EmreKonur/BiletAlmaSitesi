/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.Vehicles;

import entity.Company;
import entity.Seats.BusSeats;

/**
 *
 * @author emrek
 */
public class Bus {
    private String bus_id,bus_plate_number,seat_design;
    private String company_id,seat_id,travel_route_id;
    public String getBus_id;
    private BusSeats b;
    private Company c;

    public Bus() {
    }

    public Bus(String bus_id, Company c, BusSeats b, String travel_route_id,String bus_plate_number,String seat_design) {
        this.bus_id = bus_id;
        this.c = c;
        this.b=b;
        this.travel_route_id = travel_route_id;
        this.bus_plate_number = bus_plate_number;
        this.seat_design = seat_design;
    }

    public Company getC() {
        return c;
    }

    public void setC(Company c) {
        this.c = c;
    }

    public BusSeats getB() {
        return b;
    }

    public void setB(BusSeats b) {
        this.b = b;
    }

    public String getBus_plate_number() {
        return bus_plate_number;
    }

    public void setBus_plate_number(String bus_plate_number) {
        this.bus_plate_number = bus_plate_number;
    }

    public String getSeat_design() {
        return seat_design;
    }

    public void setSeat_design(String seat_design) {
        this.seat_design = seat_design;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String comany_id) {
        this.company_id = comany_id;
    }

    public String getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(String seat_id) {
        this.seat_id = seat_id;
    }

    public String getTravel_route_id() {
        return travel_route_id;
    }

    public void setTravel_route_id(String travel_route_id) {
        this.travel_route_id = travel_route_id;
    }

    public Bus findByID(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    


   

    
    

}