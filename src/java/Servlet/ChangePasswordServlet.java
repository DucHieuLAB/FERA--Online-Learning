/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRAN DUC HIEU
 */
public class ChangePasswordServlet extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        request.getRequestDispatcher("ChangePassword.jsp").forward(
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
    String oldPassword = request.getParameter("oldPassword");
    String newPassword = request.getParameter("newPassword");
    String cfnewPassword = request.getParameter("cfnewPassword");
    String Email = request.getParameter("email");
    
        CustomerDAO customerDAO = new CustomerDAO();
        try {
             if(customerDAO.checkEmailPassword(Email, oldPassword)){
                 if(!cfnewPassword.equals(newPassword)) throw new Exception("Re-Password is not Correct !");
                 if(customerDAO.changePassword(Email, newPassword)){
                 request.setAttribute("Message", "SuccessFul");
                 request.getRequestDispatcher("Home.jsp").forward(
                 request, response);
                 }else{
                 throw new Exception("Server Enrrol !!");
                 }
             }else{
             throw new Exception("Wrong Password");
             } 
        } catch (Exception e) {
             request.setAttribute("Email", Email);
                 request.setAttribute("Message", e.getMessage());
                 request.getRequestDispatcher("ChangePassword.jsp").forward(
                 request, response);
        }
      
    // check old password is correct
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
