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
import Model.LessonForSelected;
import Model.Quiz;
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
@WebServlet(name = "CreateQuizServlet", urlPatterns = {"/CreateQuiz"})
public class CreateQuizServlet extends HttpServlet {

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
        String SubjectID = request.getParameter("SubjectID");
        String LessionID = request.getParameter("LessionID");
        if (SubjectID != null) {
            request.setAttribute("SubjectID", SubjectID);
        }
        if (LessionID != null) {
            request.setAttribute("LessionID", LessionID);
        }       
        try {
            List<Subject> lstSubject = new SubjectDAO().getAll();
            List<LessonForSelected> lstLession = null;
            if(SubjectID == null && LessionID== null){
                request.setAttribute("SubjectID", lstSubject.get(0).getSubjectID());
            }
            if (SubjectID != null) {
                lstLession = new LessonDAO().getListLessionBySubjectID(SubjectID);
            }else{
            lstLession = new LessonDAO().getListLessionBySubjectID(""+lstSubject.get(0).getSubjectID());
            }
            if(LessionID != null){
                LessonForSelected lession = new LessonDAO().getLessionByID(Integer.parseInt(LessionID));
                int NumOfQuestion = new QuestionDAO().getNumQuestionByLession(lession);
                request.setAttribute("NumOfQuestion", NumOfQuestion);
            }else{
                LessonForSelected lession = new LessonDAO().getLessionByID(lstLession.get(0).getID());
                int NumOfQuestion = new QuestionDAO().getNumQuestionByLession(lession);
                request.setAttribute("NumOfQuestion", NumOfQuestion);
                request.setAttribute("LessionID", lstLession.get(0).getID());
            }
            request.setAttribute("LstLession", lstLession);
            request.setAttribute("lstSubject", lstSubject);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("CreateQuiz.jsp").forward(
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
        String LessionID = request.getParameter("SelectedlessionID");
        String Duration = request.getParameter("Duration");
        String Pass_rate = request.getParameter("Pass_rate");
        String Description = request.getParameter("Description").trim();
        String Media = request.getParameter("Media");
        String NumOfQuestion = request.getParameter("NumOfQuestion");        
        Quiz q = new Quiz(Integer.parseInt(LessionID), Integer.parseInt(Duration), Integer.parseInt(Pass_rate), Description, Media, 2,Integer.parseInt(NumOfQuestion));
        try {
            boolean Status = new QuizDAO().createQuiz(q);
            if(Status){
                // Import Question 
                if(new QuizDAO().importQuestionToQuiz(q)) {request.setAttribute("message","Create Success!");}
                
            }
        } catch (Exception ex) {
             request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("CreateQuiz.jsp").forward(
                    request, response);
        } 

    }
}
