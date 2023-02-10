/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
public class TopicDAO {

    public Topic getTopicByID(int ID) throws SQLException, ClassNotFoundException {
        Topic result = null;
        String query = "SELECT * FROM Topic WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        }
        return result;
    }

    public List<Topic> getAll() throws SQLException, ClassNotFoundException {
        List<Topic> result = new ArrayList<>();
        String query = "SELECT * FROM Topic";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result.add(new Topic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        }
        return result;
    }
}
