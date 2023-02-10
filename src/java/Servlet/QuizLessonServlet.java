/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.LessonDAO;
import Dao.QuestionDAO;
import Dao.QuizDAO;
import Dao.SubjectDAO;
import Dao.TopicDAO;
import Model.LessonForSelected;
import Model.Question;
import Model.Quiz;
import Model.QuizzList;
import Model.Subject;
import Model.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.Order;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRAN DUC HIEU
 */
@WebServlet(name = "QuizLessonServlet", urlPatterns = {"/QuizLesson"})
public class QuizLessonServlet extends HttpServlet {

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
        
        try {
            Quiz quiz = new QuizDAO().getQuizById("1");
            LessonForSelected lession = new LessonDAO().getLessionByID(1);
            Subject subject = new SubjectDAO().getSubjectByID(lession.getSubjectID());
            Topic topic = new TopicDAO().getTopicByID(lession.getTopicID());
            List<Question> lstQuestion = new QuestionDAO().getListQuestionByQuizID(lession.getID());
            QuizzList quizzList = new QuizzList(quiz, lession, subject, lstQuestion);
            request.setAttribute("topic", topic);
            request.setAttribute("quizzList", quizzList);
            quizzList.getQuiz().getNumOfQuestion();
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("LessonView.jsp").forward(
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
