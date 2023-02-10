/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.LessonDAO;
import Dao.QuizDAO;
import Dao.SubjectDAO;
import Model.LessonForSelected;
import Model.Quiz;
import Model.QuizzList;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRAN DUC HIEU
 */
@WebServlet(name = "QuizzesListServlet", urlPatterns = {"/QuizzesList"})
public class QuizzesListServlet extends HttpServlet {

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
        String indexPage = request.getParameter("index");
        String searchKey = request.getParameter("SearchKEY");
        String order = request.getParameter("order");
        String filter = request.getParameter("filter");
        int index = 1;
        if (searchKey == null) {
            searchKey = "";
        }
        if (filter == null) {
            filter = "LessionID";
        }
        if (order == null) {
            order = "ASC";
        }
        try {
            if (indexPage != null) {
                index = Integer.parseInt(indexPage);
            }
            int count = 0;
            count = new QuizDAO().getNumTotalQuizzList("Title", searchKey);
            if (count <= 0) {
                throw new Exception("Database is empty");
            }
            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            List<QuizzList> lstQuizzLists = new ArrayList<>();
            LessonForSelected tmp_Lesson;
            Subject tmp_Subject;
            List<Quiz> lstQuiz = new QuizDAO().pagingQuizzList(index, "Title", searchKey, filter, order);
            if (lstQuiz != null) {
                for (Quiz q : lstQuiz) {
                    tmp_Lesson = new LessonDAO().getLessionByID(q.getLessionID());
                    tmp_Subject = new SubjectDAO().getSubjectByID(tmp_Lesson.getSubjectID());
                    lstQuizzLists.add(new QuizzList(q, tmp_Lesson, tmp_Subject));
                }
            }
            request.setAttribute("LstQuizz", lstQuizzLists);
            request.setAttribute("endP", endPage);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.setAttribute("order", order);
            request.setAttribute("SearchKEY", searchKey);
            request.getRequestDispatcher("QuizzesList.jsp").forward(
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
