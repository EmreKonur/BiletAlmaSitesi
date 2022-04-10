/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.Seats;

/**
 *
 * @author emrek
 */
public class PlaneSeats {
    

    private String seat_id,available_seat,number_of_seats;

    public PlaneSeats() {
    }

    public PlaneSeats(String seat_id, String available_seat, String number_of_seats) {
        this.seat_id = seat_id;
        this.available_seat = available_seat;
        this.number_of_seats = number_of_seats;
    }

    public String getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(String seat_id) {
        this.seat_id = seat_id;
    }

    public String getAvailable_seat() {
        return available_seat;
    }

    public void setAvailable_seat(String available_seat) {
        this.available_seat = available_seat;
    }

    public String getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(String number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    
}
    
