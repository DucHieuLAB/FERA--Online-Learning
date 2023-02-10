/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Dimenstion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRAN DUC HIEU
 */
public class DimenstionDAO {

    public Dimenstion getDimenstionByID(int ID) throws SQLException, ClassNotFoundException {
        Dimenstion dimenstion = null;
        String query = "SELECT * FROM Dimenstion WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ID);
        ResultSet rs = pstm.executeQuery();
         while (rs.next()) {
            dimenstion = new Dimenstion(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
        }
        return dimenstion;
    }
    public List<Dimenstion> getAll() throws SQLException, ClassNotFoundException{
        List<Dimenstion> result = new ArrayList<>();
         String query = "SELECT * FROM Dimenstion";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()) {
            result.add( new Dimenstion(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
        }
        return result;
    }
}
