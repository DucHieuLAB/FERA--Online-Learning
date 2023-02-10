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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *CreateQuestionServlet
 * @author TRAN DUC HIEU
 */
public class CreateQuestionServlet extends HttpServlet {

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
        String questionId = request.getParameter("QuestionID");
        try {
            if (questionId != null) {
                Question question = new QuestionDAO().getQuestionByID(Integer.parseInt(questionId));
                Topic topic = new TopicDAO().getTopicByID(question.getTopicID());
                Dimenstion dimenstion = new DimenstionDAO().getDimenstionByID(question.getId());
                Subject subject = new SubjectDAO().getSubjectByID(question.getSubjectID());
                request.setAttribute("Topic", topic);
                request.setAttribute("Dimenstion", dimenstion);
                request.setAttribute("Subject", subject);
            }
            List<Topic> LstTopic = new TopicDAO().getAll();
            List<Dimenstion> LstDimenstion = new DimenstionDAO().getAll();
            List<Subject> LstSubjects = new SubjectDAO().getAll();
            request.setAttribute("LstTopic", LstTopic);
            request.setAttribute("LstDimenstion", LstDimenstion);
            request.setAttribute("LstSubject", LstSubjects);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());

        } finally {
            request.getRequestDispatcher("CreateQuestion.jsp").forward(
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
        try {
            String QuestionName = request.getParameter("QuestionName").toString().trim();
            String Explanation = request.getParameter("Explanation").toString().trim();
            String DimenstionID = request.getParameter("DimenstionID").toString().trim();
            String TopicID = request.getParameter("TopicID").toString().trim();
            String SubjectID = request.getParameter("SubjectID").toString().trim();
            String Status = request.getParameter("Status");
            boolean bstatus = Status == null ? false : true;
            String QuestionDetail = request.getParameter("QuestionDetail").toString().trim();
            boolean CreateStatus = new QuestionDAO().createQuestion(new Question(0, QuestionName, QuestionDetail, Integer.parseInt(TopicID), 0, Explanation, bstatus, "", Integer.parseInt(SubjectID), Integer.parseInt(DimenstionID)));
            if (CreateStatus) {
                int Id = new QuestionDAO().getQuestion(new Question(0, QuestionName, QuestionDetail, Integer.parseInt(TopicID), 0, Explanation, bstatus, "", Integer.parseInt(SubjectID), Integer.parseInt(DimenstionID)));
                request.setAttribute("message", "Create Succes!");
                if (Id > 0) {
                    Question question = new QuestionDAO().getQuestionByID(Id);
                    Topic topic = new TopicDAO().getTopicByID(question.getTopicID());
                    Dimenstion dimenstion = new DimenstionDAO().getDimenstionByID(question.getId());
                    Subject subject = new SubjectDAO().getSubjectByID(question.getSubjectID());
                    request.setAttribute("QuestionID", Id);
                    request.setAttribute("Topic", topic);
                    request.setAttribute("Dimenstion", dimenstion);
                    request.setAttribute("Subject", subject);
                    request.setAttribute("Question", question);
                    List<Topic> LstTopic = new TopicDAO().getAll();
                    List<Dimenstion> LstDimenstion = new DimenstionDAO().getAll();
                    List<Subject> LstSubjects = new SubjectDAO().getAll();
                    request.setAttribute("LstTopic", LstTopic);
                    request.setAttribute("LstDimenstion", LstDimenstion);
                    request.setAttribute("LstSubject", LstSubjects);
                }

            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        } finally {
            request.getRequestDispatcher("CreateQuestion.jsp").forward(
                    request, response);
        }
    }
}
