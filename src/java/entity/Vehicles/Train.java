/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.Vehicles;

import entity.Company;
import entity.Seats.TrainSeats;
import entity.TravelRoute.TrainTravelRoute;

/**
 *
 * @author emrek
 */
public class Train {
    
    private String train_id;
    private TrainTravelRoute trainTravelRoute;
    private Company company;
    private TrainSeats trainseats;

    public Train() {
    }

    public Train(String train_id, TrainSeats trainseats, TrainTravelRoute trainTravelRoute, Company company) {
        this.train_id = train_id;
        this.trainseats=trainseats;
        this.trainTravelRoute=trainTravelRoute;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public TrainSeats getTrainseats() {
        return trainseats;
    }

    public void setTrainseats(TrainSeats trainseats) {
        this.trainseats = trainseats;
    }

    public TrainTravelRoute getTrainTravelRoute() {
        return trainTravelRoute;
    }

    public void setTrainTravelRoute(TrainTravelRoute trainTravelRoute) {
        this.trainTravelRoute = trainTravelRoute;
    }

}
