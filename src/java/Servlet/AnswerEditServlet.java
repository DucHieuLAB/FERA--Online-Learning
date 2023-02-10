/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.AnswerDAO;
import Model.Answer;
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
public class AnswerEditServlet extends HttpServlet {
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
        String QuestionId = request.getParameter("EditQuestionID");
        String id = request.getParameter("EditAnswerID");
        String submit = request.getParameter("submit");
        try {
            boolean status = false;
            if (submit.equals("Update")) {
                String AnswerContent = request.getParameter("AnswerContent").toString().trim();
                String AnswerComent = request.getParameter("AnswerComent").toString().trim();
                String ansCorrect = request.getParameter("ansCorrect");
                boolean Bcorrect = false;
                if(ansCorrect != null){
                    Bcorrect = true;
                }
                status = new AnswerDAO().updateAnswer(new Answer(Integer.parseInt(id), Integer.parseInt(QuestionId),AnswerContent, Bcorrect , AnswerComent));
                if (status) {
                    request.setAttribute("message", "Update Success!");
                }
            } else if(submit.equals("Delete")){
                status = new AnswerDAO().deleteAnswer(Integer.parseInt(id));
                if(status){
                    request.setAttribute("message", "Delete Success!");
                }
                
            }

        } catch (Exception ex) {
            request.setAttribute("errorAns", ex.getMessage());
        } finally {
            response.sendRedirect("/FeraOnlineLearning/QuestionEdit?id=" + QuestionId);
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
        String AnsQuestionID = request.getParameter("AnsQuestionID").toString().trim();
        try {

            String AnswerContent = request.getParameter("AnswerContent").toString().trim();
            String ansCorrect = request.getParameter("ansCorrect");
            boolean correct = ansCorrect == null ? false : true;
            String CommentAns = request.getParameter("CommentAns").toString().trim();
            boolean status = new AnswerDAO().createAnswer(new Answer(Integer.parseInt(AnsQuestionID), AnswerContent, correct, CommentAns));
            if (status) {
                request.setAttribute("message", "Add Answer Sucess!");
            }
        } catch (Exception e) {
            request.setAttribute("errorAns", e.getMessage());
        } finally {

            response.sendRedirect("/FeraOnlineLearning/QuestionEdit?id=" + AnsQuestionID);
        }

    }
}
