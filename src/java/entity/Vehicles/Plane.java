/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.Vehicles;

import entity.Company;
import entity.Seats.PlaneSeats;
import entity.TravelRoute.PlaneTravelRoute;

/**
 *
 * @author emrek
 */
public class Plane {

    private String plane_id;
    private PlaneTravelRoute planeTravelRoute;
    private Company company;
    private PlaneSeats planeseats;
    public String getPlane_id;

    public Plane() {
        
    }

    public Plane(String plane_id, PlaneSeats planeseats, PlaneTravelRoute planeTravelRoute, Company company) {
        this.plane_id = plane_id;
        this.planeseats=planeseats;
        this.planeTravelRoute=planeTravelRoute;
        this.company = company;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(String plane_id) {
        this.plane_id = plane_id;
    }

    public PlaneSeats getPlaneseats() {
        return planeseats;
    }

    public void setPlaneseats(PlaneSeats planeseats) {
        this.planeseats = planeseats;
    }

    public PlaneTravelRoute getPlaneTravelRoute() {
        return planeTravelRoute;
    }

    public void setPlaneTravelRoute(PlaneTravelRoute planeTravelRoute) {
        this.planeTravelRoute = planeTravelRoute;
    }

    public Plane findByID(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}