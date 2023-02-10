/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.DimenstionDAO;
import Dao.QuestionDAO;
import Dao.SubjectDAO;
import Dao.TopicDAO;
import Model.Dimenstion;
import Model.Question;
import Model.Subject;
import Model.Topic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRAN DUC HIEU
 */
public class QuestionDetailServlet extends HttpServlet {

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
            String questionId = request.getParameter("id");
            if (questionId == null) {
                throw new Exception("Don't have parameter QuestionID");
            }
            QuestionDAO questionDAO = new QuestionDAO();
            Question question = questionDAO.getQuestionByID(Integer.parseInt(questionId));

            if (question == null) {
                throw new Exception("Question is empty");
            }       
            Topic topic = new TopicDAO().getTopicByID(question.getTopicID());
            Dimenstion dimenstion = new DimenstionDAO().getDimenstionByID(question.getId());
            Subject subject = new SubjectDAO().getSubjectByID(question.getSubjectID());
            List<Topic> LstTopic = new TopicDAO().getAll();
            List<Dimenstion> LstDimenstion = new DimenstionDAO().getAll();
            List<Subject> LstSubjects = new SubjectDAO().getAll();
            request.setAttribute("Topic",topic );
            request.setAttribute("Dimenstion", dimenstion);
            request.setAttribute("Subject", subject);
            request.setAttribute("LstTopic", LstTopic);

            request.setAttribute("LstDimenstion", LstDimenstion);
            request.setAttribute("LstSubject", LstSubjects);
            request.setAttribute("Question", question);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());

        } finally {
            request.getRequestDispatcher("QuestionDetail.jsp").forward(
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
