/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author berat
 */
public class Bills {

    private String bills_id, bills_date;

    public Bills() {
    }

    public Bills(String bills_id, String bills_date) {
        this.bills_id = bills_id;
        this.bills_date = bills_date;
    }

    public String getBills_id() {
        return bills_id;
    }

    public void setBills_id(String bills_id) {
        this.bills_id = bills_id;
    }

    public String getBills_date() {
        return bills_date;
    }

    public void setBills_date(String bills_date) {
        this.bills_date = bills_date;
    }

}
