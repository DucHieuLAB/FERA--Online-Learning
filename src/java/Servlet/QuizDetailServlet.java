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
import Model.Question;
import Model.Quiz;
import Model.QuizzList;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "QuizDetailServlet", urlPatterns = {"/QuizDetail"})
public class QuizDetailServlet extends HttpServlet {

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
        String LessionId = request.getParameter("id");
        try {
            List<Subject> lstSubject = new SubjectDAO().getAll();
            QuizzList quizzList = new QuizzList();
            LessonForSelected tmp_Lesson;
            Subject tmp_Subject;
            Quiz quiz = new QuizDAO().getQuizById(LessionId);
            tmp_Lesson = new LessonDAO().getLessionByID(Integer.parseInt(LessionId));
            tmp_Subject = new SubjectDAO().getSubjectByID(tmp_Lesson.getSubjectID());
            List<LessonForSelected> lstLession = new LessonDAO().getListLessionBySubjectID("" + tmp_Subject.getSubjectID());
            List<Question> lstQuestions = new QuestionDAO().getListQuestionByQuizID(quiz.getLessionID());
            quizzList = new QuizzList(quiz, tmp_Lesson, tmp_Subject, lstQuestions);
            List<Question> lstQuestions2 = new QuestionDAO().getListQuestionByLesson(tmp_Lesson);
            request.setAttribute("lstSubject", lstSubject);
            request.setAttribute("quizzList", quizzList);
            request.setAttribute("LstLession", lstLession);
            request.setAttribute("LstQuestion", lstQuestions2);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("QuizDetail.jsp").forward(
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

            String LessionID = request.getParameter("LessionID");
            String Duration = request.getParameter("Duration");
            String Pass_rate = request.getParameter("Pass_rate");
            String Description = request.getParameter("Description").trim();
            String Media = request.getParameter("Media");
            String message = "";
        try {
            Quiz q = new Quiz(Integer.parseInt(LessionID),Integer.parseInt(Duration), Integer.parseInt(Pass_rate), Description, Media, 0);
            boolean status = new QuizDAO().UpdateQuizInfo(q);
        if(status){
            request.setAttribute("message", "Update Success !!");
            message = "&message=Update Success!!";
        }else{
            message = "&message=Update False!!";
        }
        } catch (Exception ex) {
             request.setAttribute("error", ex.getMessage());
            message = "&error="+ex.getMessage(); 
        } finally{         
            response.sendRedirect("QuizDetail?id=" + LessionID+""+message);
        }
    }
}
