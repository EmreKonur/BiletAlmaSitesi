/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.BillsDAO;
import entity.Bills;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named(value = "billsBean")
@SessionScoped
public class BillsBean implements Serializable {

    private Bills entity;
    private BillsDAO dao;
    private List<Bills> list;
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

    public BillsBean() {

    }

    public void create() throws SQLException, ClassNotFoundException {
        this.getDao().createBills(entity);
        this.entity = new Bills();
    }

    public void delete(Bills u) throws ClassNotFoundException, SQLException {
        this.getDao().delete(u);
    }

    public Bills getEntity() {
        if (this.entity == null) {
            this.entity = new Bills();
        }
        return entity;
    }

    public void setEntity(Bills entity) {
        this.entity = entity;
    }

    public void update() throws SQLException, ClassNotFoundException {
        this.getDao().update(entity);
    }

    public BillsDAO getDao() {
        if (this.dao == null) {
            this.dao = new BillsDAO();
        }
        return dao;
    }

    public void clear() {
        this.entity = new Bills();
    }

    public void setDao(BillsDAO dao) {
        this.dao = dao;
    }

    public List<Bills> getList() throws SQLException, ClassNotFoundException {
        this.list = this.getDao().getBillsList(page, pageSize);
        return list;
    }

    public void setList(List<Bills> list) {
        this.list = list;
    }
}
