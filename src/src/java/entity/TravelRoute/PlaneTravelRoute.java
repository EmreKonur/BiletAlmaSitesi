/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.TravelRoute;

/**
 *
 * @author emrek
 */
public class PlaneTravelRoute{
    private String travel_route_id,to,from;

    public PlaneTravelRoute() {
    }

    
    public PlaneTravelRoute(String travel_route_id, String to, String from) {
        this.travel_route_id = travel_route_id;
        this.to = to;
        this.from = from;
        
    
}

    public String getTravel_route_id() {
        return travel_route_id;
    }

    public void setTravel_route_id(String travel_route_id) {
        this.travel_route_id = travel_route_id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    
}
    

