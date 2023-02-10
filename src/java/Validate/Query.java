/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validate;

/**
 *
 * @author TRAN DUC HIEU
 */
public class Query {
    public static String QUERY_SELECT_NUM_TOTAL_QUESTION = "Select count(*) from question";
    public static String QUERY_SELECT_ACCOUNT_WHERE_PASSWORD_EMAIL = "SELECT * FROM Account WHERE [password] = ? and Email = ?";
    public static String QUERY_SELECT_ACCOUNT_TOTAL_QUESTION = "Select * From Account WHERE Email = ?";
}
