/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import util.DBConnection;
import entity.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO extends DBConnection{
    private Connection db;

    public void createCompany(Company u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "insert into company (company_id,company_name,company_email,company_address,company_phone_number) values"+
                " ('"+u.getCompany_id()+"','"+u.getCompany_name()+"','"+u.getCompany_address()+"','"+u.getCompany_phone_number()+"','"+u.getCompany_email()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(Company u) throws SQLException, ClassNotFoundException {
        Statement st = this.connect().createStatement();

        String query = "delete from company where company_id='"+u.getCompany_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    public List<Company> getCompanyList() throws SQLException, ClassNotFoundException{
        List<Company> companyList=new ArrayList<>();
        Statement st = this.getDb().createStatement();
        String query="Select * from company";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            companyList.add(new Company(rs.getString("company_id"),rs.getString("company_name"),rs.getString("company_address"),rs.getString("company_phone_number"),rs.getString("company_email")));
        }
        return companyList;
    }
    public void update(Company u) throws SQLException, ClassNotFoundException{
        Statement st=this.connect().createStatement();
        String query = "update company set company_name='" + u.getCompany_name() + "', company_phone_number='"
                + u.getCompany_phone_number() + "', company_address='" + u.getCompany_address() 
                + "', company_email='" + u.getCompany_email()
                + "'  where company_id='" + u.getCompany_id() + "'";
        st.executeUpdate(query);
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
