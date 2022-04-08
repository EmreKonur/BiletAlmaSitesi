/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import util.DBConnection;
import entity.Users;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DBConnection{

    private Connection db;

    public void createUsers(Users u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

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
        int r=st.executeUpdate(query);
    }
    
    public void delete(Users u) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "delete from users where user_tckn='"+u.getUser_tckn()+"'";
        int r=st.executeUpdate(query);
    }
    
    /*public void update(Users y) throws SQLException, ClassNotFoundException {
        Statement st = this.getDb().createStatement();

        String query = "update users set where user_tckn='"+y.getUser_tckn()+"'";
        int r=st.executeUpdate(query);
    }*/
    
    
    
    public List<Users> getUsersList() throws SQLException, ClassNotFoundException{
         List<Users> usersList=new ArrayList<>();
        
        Statement st = this.getDb().createStatement();
        String query="Select * from users";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            usersList.add(new Users(rs.getString("user_tckn"),rs.getString("user_name"),rs.getString("user_phone_number"),rs.getString("user_address"),rs.getString("user_email"),rs.getString("user_gender"),rs.getString("user_username"),rs.getString("user_password")));
        }
         
         return usersList;
    }

    public Connection getDb() throws SQLException, ClassNotFoundException {
        if (this.db == null) {
            this.db = this.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
