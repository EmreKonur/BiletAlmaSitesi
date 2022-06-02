package dao;

import entity.Documents;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentsDAO extends DBConnection {

      public List<Documents> findAll() {
        List<Documents> dList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from doc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Documents d = new Documents();
                d.setId(rs.getLong("id"));
                d.setFilePath(rs.getString("filepath"));
                d.setFileName(rs.getString("filename"));
                d.setFileType(rs.getString("filetype"));
                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }
  

    public void insert(Documents d) {

        

        String query = "insert into doc(filepath, filename, filetype) values(?,?,?)";
        try {
           PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}