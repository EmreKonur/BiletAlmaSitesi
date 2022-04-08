/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author berat
 */
public class Users {
    private String user_tckn;
    private String user_name,user_phone_number,user_address,user_email,user_gender,user_username,user_password;

    public Users() {
    }

    public Users(String user_tckn, String user_name, String user_phone_number, String user_address, String user_email, String user_gender, String user_username, String user_password) {
        this.user_tckn = user_tckn;
        this.user_name = user_name;
        this.user_phone_number = user_phone_number;
        this.user_address = user_address;
        this.user_email = user_email;
        this.user_gender = user_gender;
        this.user_username = user_username;
        this.user_password = user_password;
    }

    public String getUser_tckn() {
        return user_tckn;
    }

    public void setUser_tckn(String user_tckn) {
        this.user_tckn = user_tckn;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "Users{" + "user_tckn=" + user_tckn + ", user_name=" + user_name + ", user_phone_number=" + user_phone_number + ", user_address=" + user_address + ", user_email=" + user_email + ", user_gender=" + user_gender + ", user_username=" + user_username + ", user_password=" + user_password + '}';
    }
    
    
}
