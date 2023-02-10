/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Subject;
import Model.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRAN DUC HIEU
 */
public class SubjectDAO {
    
    public Subject getSubjectByID(int ID) throws SQLException, ClassNotFoundException {
        Subject result = null;
        String query = "SELECT * FROM Subject WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));
        }
        
        return result;
        
    }
    
    public List<Subject> getAll() throws SQLException, ClassNotFoundException {
        List<Subject> result = new ArrayList<>();
        String query = "SELECT * FROM Subject";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result.add(new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
        }
        return result;
    }
}
