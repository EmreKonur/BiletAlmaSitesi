/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;
import dao.UsersDAO;
import entity.Users;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named(value = "usersBean")
@SessionScoped
public class UsersBean implements Serializable {
    
    private Users entity;
    private UsersDAO dao;
    private List<Users> list;
    
    public UsersBean() {
        
    }
    
    public void create() throws SQLException, ClassNotFoundException{
        this.getDao().createUsers(entity);
        this.entity=new Users();
    }
    public void clear(){
        this.entity=new Users();
    }
    public void delete(Users u) throws ClassNotFoundException, SQLException{
        this.getDao().delete(u); 
    }
    
    public Users getEntity() {
        if(this.entity==null ){
            this.entity=new Users();
        }
        return entity;
    }

    public void setEntity(Users entity) {
        this.entity = entity;
    }

    public UsersDAO getDao() {
        if(this.dao==null ){
            this.dao=new UsersDAO();
        }
        return dao;
    }

    public void setDao(UsersDAO dao) {
        this.dao = dao;
    }

    public List<Users> getList() throws SQLException, ClassNotFoundException {
        this.list=this.getDao().getUsersList();
        return list;
    }
    
    public void update() throws SQLException, ClassNotFoundException{
        this.getDao().update(entity);
        this.entity =new Users();
    }
    public void setList(List<Users> list) {
        this.list = list;
    }
    
}
