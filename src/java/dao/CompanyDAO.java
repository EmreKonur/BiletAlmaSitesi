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

    public CompanyDAO() {
    }
    
    public Company findByID(String company_id){
        Company u=null;
        try{
            Statement st = this.getConnection().createStatement();
            
            String query = "select * from company where company_id="+company_id ;
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                u = new Company(rs.getString("company_id"),rs.getString("company_name"),rs.getString("company_address"),rs.getString("company_phone_number"),rs.getString("company_email"));
                
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
    

    public void createCompany(Company u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "insert into company (company_id,company_name,company_email,company_address,company_phone_number) values"+
                " ('"+u.getCompany_id()+"','"+u.getCompany_name()+"','"+u.getCompany_address()+"','"+u.getCompany_phone_number()+"','"+u.getCompany_email()+"')";
        int r=st.executeUpdate(query);
    }
    
    public void delete(Company u) throws SQLException, ClassNotFoundException {
        Statement st = this.getConnection().createStatement();

        String query = "delete from company where company_id='"+u.getCompany_id()+"'";
        int r=st.executeUpdate(query);
    }
    
    public List<Company> getCompanyList(int page,int pageSize) throws SQLException, ClassNotFoundException{
        List<Company> companyList=new ArrayList<>();
        int start = (page - 1) * pageSize;
        Statement st = this.getDb().createStatement();
        String query="Select * from company order by company_id asc limit '" + pageSize + "' offset '" + start + "'";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            companyList.add(new Company(rs.getString("company_id"),rs.getString("company_name"),rs.getString("company_address"),rs.getString("company_phone_number"),rs.getString("company_email")));
        }
        return companyList;
    }
    
        public int count() {
        int count = 0;

        try {

            Statement st = this.getConnection().createStatement();
            String q = "select count(company_id) as company_count from company";
            ResultSet rs = st.executeQuery(q);
            rs.next();
            count = rs.getInt("company_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return count;
    }
    
    public void update(Company u) throws SQLException, ClassNotFoundException{
        Statement st=this.getConnection().createStatement();
        String query = "update company set company_name='" + u.getCompany_name() + "', company_phone_number='"
                + u.getCompany_phone_number() + "', company_address='" + u.getCompany_address() 
                + "', company_email='" + u.getCompany_email()
                + "'  where company_id='" + u.getCompany_id() + "'";
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

    

    

    
}
