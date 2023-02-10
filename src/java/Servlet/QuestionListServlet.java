/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.QuestionDAO;
import Model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRAN DUC HIEU
 */
public class QuestionListServlet extends HttpServlet {
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
        String indexPage = request.getParameter("index");
        String searchKey = request.getParameter("SearchKEY");
        String searchBy = request.getParameter("search");
        String order = request.getParameter("order");
        String filter = request.getParameter("filter");
        if (order == null) {
            order = "";
        }
        if(filter == null){
            filter = "ID";
        }
        if (searchBy == null) {
            searchBy = "QuestionName";
        }
        if (searchKey == null) {
            searchKey = "";
        }
        int index = 1;
        if (indexPage != null) {
            index = Integer.parseInt(indexPage);
        }

        QuestionDAO questionDAO = new QuestionDAO();
        try {
            int count = questionDAO.getNumTotalQuesion(searchBy, searchKey);
            if (count < 0) {
                throw new Exception("Database is empty");
            }
            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            List<Question> lstQuestion = questionDAO.pagingQuestion(index, searchBy, searchKey , filter,order);
            request.setAttribute("searchBY", searchBy);
            request.setAttribute("searchKey", searchKey);
            request.setAttribute("filter", filter);
            request.setAttribute("order", order);
            request.setAttribute("endP", endPage);
            request.setAttribute("lstQuestion", lstQuestion);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("QuestionList.jsp").forward(
                    request, response);
        }

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

    }

}
