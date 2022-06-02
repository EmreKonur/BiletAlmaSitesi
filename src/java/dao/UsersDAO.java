/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bills;
import java.sql.Connection;
import util.DBConnection;
import entity.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DBConnection {

    private Connection db;

    public void createUsers(Users u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "insert into users (user_tckn,user_name,user_phone_number,"
                + "user_address,user_email,user_gender,user_username,user_password) values"
                + "('" + u.getUser_tckn() + "',"
                + "'" + u.getUser_name() + "',"
                + "'" + u.getUser_phone_number() + "',"
                + "'" + u.getUser_address() + "',"
                + "'" + u.getUser_email() + "',"
                + "'" + u.getUser_gender() + "',"
                + "'" + u.getUser_username() + "',"
                + "'" + u.getUser_password() + "')";
        int r = st.executeUpdate(query);
    }

    public Users getUser(String eposta, String sifre) {
        Users u = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from users where user_email='" + eposta + "' and user_password='" + sifre + "'");
            rs.next();
            u = new Users(rs.getString("user_tckn"), rs.getString("user_name"),
                    rs.getString("user_phone_number"), rs.getString("user_address"),
                    rs.getString("user_email"), rs.getString("user_gender"),
                    rs.getString("user_username"), rs.getString("user_password"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    public void delete(Users u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "delete from users where user_tckn='" + u.getUser_tckn() + "'";
        int r = st.executeUpdate(query);
    }

    public List<Users> getUsersList() throws SQLException, ClassNotFoundException {
        List<Users> usersList = new ArrayList<>();

        Statement st = this.getDb().createStatement();
        String query = "Select * from users";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            usersList.add(new Users(rs.getString("user_tckn"), rs.getString("user_name"),
                    rs.getString("user_phone_number"), rs.getString("user_address"),
                    rs.getString("user_email"), rs.getString("user_gender"),
                    rs.getString("user_username"), rs.getString("user_password")));
        }

        return usersList;
    }

    public void update(Users u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();
        String query = "update users set user_name='" + u.getUser_name() + "', user_phone_number='"
                + u.getUser_phone_number() + "', user_address='" + u.getUser_address()
                + "', user_email='" + u.getUser_email()
                + "', user_gender='" + u.getUser_gender()
                + "', user_username='" + u.getUser_username()
                + "',user_password='" + u.getUser_password()
                + "'  where user_tckn='" + u.getUser_tckn() + "'";
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

    public Users findByID(String user_id) {
        Users z = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from users where user_id=" + user_id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                z = new Users(rs.getString("user_tckn"), rs.getString("user_name"),
                        rs.getString("user_phone_number"), rs.getString("user_address"),
                        rs.getString("user_email"), rs.getString("user_gender"),
                        rs.getString("user_username"), rs.getString("user_password"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return z;
    }
}
