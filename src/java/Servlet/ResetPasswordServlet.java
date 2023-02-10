/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.CustomerDAO;
import Service.EmailUtility;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRAN DUC HIEU
 */
public class ResetPasswordServlet extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("ForgotPass.jsp").forward(
        request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Email = request.getParameter("email");
        String resultMessage = "";
        // Check Email Exits in system      
        boolean status = true;
        try {
            CustomerDAO customerDAO = new CustomerDAO(); 
            if(!customerDAO.checkEmailExist(Email)){
            throw new Exception("Email not esxit!");
            }         
            String newPassword = customerDAO.getNewPassword(Email);
            String subject = "[Fera Reset Yor Password]";
            String content = "Your new Password "
                    + "[ "+newPassword+" ]";
           
            EmailUtility.sendEmail(host, port, user, pass, Email, subject,
                    content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
             status = false;  
        }
        if(!status){
        request.setAttribute("Message", resultMessage);
        request.getRequestDispatcher("ForgotPass.jsp").forward(
        request, response);
        }
        request.setAttribute("Email", Email);
        request.getRequestDispatcher("ChangePassword.jsp").forward(
        request, response);
        


        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This Servlet use to Change user Password and save new Password into Database";
    }

}
