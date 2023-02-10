/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hieutdhe141410
 */
public class ResultDAO {

    public boolean insertReslut(Result result) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "INSERT INTO Result VALUES(?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, result.getAccountID());
        pstm.setInt(2, result.getLessonID());
        pstm.setBoolean(3, result.isStatus());
        pstm.setDate(4, result.getDateUpdate());
        pstm.setInt(5, (int) result.getTotalTime());
        pstm.setInt(6, result.getUnAnswerQuestion());
        status = pstm.executeUpdate() > 0 ? true : false;
        return status;
    }

    public Result getResultByAccountIdAndLessonID(int AccountID, int LessonID) throws SQLException, ClassNotFoundException {
        Result result = null;
        String query = "SELECT AccountID,LessonID,[Status],DateUpdate,TotalTime,UnAnswerQuestion\n"
                + "FROM Result\n"
                + "WHERE AccountID = ? and LessonID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, AccountID);
        pstm.setInt(2, LessonID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = new Result(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getDate(4), rs.getLong(5), rs.getInt(6));
        }
        return result;
    }

    public boolean checkResultExist(int AccountID, int LessonID) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "SELECT AccountID,LessonID,[Status],DateUpdate,TotalTime,UnAnswerQuestion\n"
                + "FROM Result\n"
                + "WHERE AccountID = ? and LessonID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, AccountID);
        pstm.setInt(2, LessonID);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            status = true;
        }
        return status;
    }

    public boolean updateResult(Result result) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "Update Result set [Status] = ?, DateUpdate = ? , TotalTime = ? , UnAnswerQuestion = ? \n"
                + "WHERE AccountID = ? and LessonID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setBoolean(1, result.isStatus());
        pstm.setDate(2, result.getDateUpdate());
        pstm.setInt(3, (int) result.getTotalTime());
        pstm.setInt(4, result.getUnAnswerQuestion());
        pstm.setInt(5, result.getAccountID());
        pstm.setInt(6, result.getLessonID());
        status = pstm.executeUpdate() > 0 ? true : false;
        return status;
    }

}
