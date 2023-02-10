/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TRAN DUC HIEU
 */
public class ConnectJDBC {

 public static Connection getSQLServerConnection()
         throws SQLException, ClassNotFoundException {
     String hostName = "localhost";
     String sqlInstanceName = "MSSQLSERVER";
     String database = "FERA_ONL_LEARNING";
     String userName = "sa";
     String password = "123456";

     return getSQLServerConnection(hostName, sqlInstanceName,
             database, userName, password);
 }


 public static Connection getSQLServerConnection(String hostName,
         String sqlInstanceName, String database, String userName,
         String password) throws ClassNotFoundException, SQLException {

     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
             + ";instance=" + sqlInstanceName + ";databaseName=" + database;

     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}
