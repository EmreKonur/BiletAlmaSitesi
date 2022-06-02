/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CompanyDAO;
import entity.Company;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named(value = "companyBean")
@SessionScoped
public class CompanyBean implements Serializable {

    private Company entity;
    private CompanyDAO dao;
    private List<Company> list;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public CompanyBean() {

    }

    public void create() throws SQLException, ClassNotFoundException {
        this.getDao().createCompany(entity);
        this.entity = new Company();
    }

    public String getCompany_name(String company_id) {
        Company u = this.getDao().findByID(company_id);
        return u.getCompany_name();
    }

    public void delete(Company u) throws ClassNotFoundException, SQLException {
        this.getDao().delete(u);
    }

    public Company getEntity() {
        if (this.entity == null) {
            this.entity = new Company();
        }
        return entity;
    }

    public void setEntity(Company entity) {
        this.entity = entity;
    }

    public void update() throws SQLException, ClassNotFoundException {
        this.getDao().update(entity);
    }

    public CompanyDAO getDao() {
        if (this.dao == null) {
            this.dao = new CompanyDAO();
        }
        return dao;
    }

    public void clear() {
        this.entity = new Company();
    }

    public void setDao(CompanyDAO dao) {
        this.dao = dao;
    }

    public List<Company> getList() throws SQLException, ClassNotFoundException {
        this.list = this.getDao().getCompanyList(page,pageSize);
        return list;
    }

    public void setList(List<Company> list) {
        this.list = list;
    }
}
