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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TRAN DUC HIEU
 */
public class QuestionEditServlet extends HttpServlet {

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
            request.setAttribute("Topic", topic);
            request.setAttribute("Dimenstion", dimenstion);
            request.setAttribute("Subject", subject);
            request.setAttribute("LstTopic", LstTopic);
            request.setAttribute("LstDimenstion", LstDimenstion);
            request.setAttribute("LstSubject", LstSubjects);
            request.setAttribute("Question", question);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());

        } finally {
            request.getRequestDispatcher("QuestionEdit.jsp").forward(
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
        String id = request.getParameter("QuestionID").toString().trim();
        String QuestionName = request.getParameter("QuestionName").toString().trim();
        String Explanation = request.getParameter("Explanation").toString().trim();
        String DimenstionID = request.getParameter("DimenstionID").toString().trim();
        String TopicID = request.getParameter("TopicID").toString().trim();
        String SubjectID = request.getParameter("SubjectID").toString().trim();
        String Status = request.getParameter("Status");
        boolean bstatus = Status== null ? false:true;
        String QuestionDetail = request.getParameter("QuestionDetail").toString().trim();
        try {
            Question question = new QuestionDAO().getQuestionByID(Integer.parseInt(id));
            question.setQuestionName(QuestionName);
            question.setExplanation(Explanation);
            question.setDimensionID(Integer.parseInt(DimenstionID));
            question.setTopicID(Integer.parseInt(TopicID));
            question.setSubjectID(Integer.parseInt(SubjectID));
            question.setStatus(bstatus);
            question.setQuestionDetail(QuestionDetail);
            boolean status = new QuestionDAO().updateQuestion(question);
            if (status) {
                request.setAttribute("message", "Edit Succesfull");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            
        } finally {            
            response.sendRedirect(request.getContextPath()+"/QuestionDetail?id="+id);
        }
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
