/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Validate.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRAN DUC HIEU
 */
public class CustomerDAO {

    public boolean checkEmailExist(String email) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = ConnectJDBC.getSQLServerConnection();
        String query = "Select * From Account WHERE Email = ?";
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, email);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            result = true;
        }
        conn.close();
        return result;
    }

    public String getNewPassword(String Email) throws SQLException, ClassNotFoundException {
        String result = generateRandomPassword(8);
        Connection conn = ConnectJDBC.getSQLServerConnection();
        String query = "Update Account SET [password] = ? WHERE Email = ?";
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, result);
        pstm.setString(2, Email);
        if (pstm.executeUpdate() <= 0) {
            throw new SQLException("Sever can't generate New Password");
        }
        conn.close();
        return result;
    }

    public boolean checkEmailPassword(String email, String pass) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = ConnectJDBC.getSQLServerConnection();
        String query = Query.QUERY_SELECT_ACCOUNT_WHERE_PASSWORD_EMAIL;
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, pass);
        pstm.setString(2, email);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            result = true;
        }
        conn.close();
        return result;
    }

    public boolean changePassword(String email, String newPassword) throws SQLException, ClassNotFoundException {
        boolean result = true;
        Connection conn = ConnectJDBC.getSQLServerConnection();
        String query = "Update Account SET [password] = ? WHERE Email = ?";
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, newPassword);
        pstm.setString(2, email);
        if (pstm.executeUpdate() <= 0) {
            result = false;
            throw new SQLException("Sever can't generate New Password");
        }
        conn.close();
        return result;
    }

    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                + "jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }

}
