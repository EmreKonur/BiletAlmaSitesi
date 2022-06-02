/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.Vehicles;

/**
 *
 * @author emrek
 */
public class Train {
    private String train_id;
    private String company_id,seat_id,travel_route_id;
    public String getTrain_id;

    public Train() {
    }

    public Train(String train_id, String company_id, String seat_id, String travel_route_id) {
        this.train_id = train_id;
        this.company_id = company_id;
        this.seat_id = seat_id;
        this.travel_route_id = travel_route_id;
    }

    public Train(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
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

    public Train findByID(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    


   

    
    

}