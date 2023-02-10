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
import Model.LessonManager;
import Model.LessonView;
import Model.Subject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Lesson;
import Model.LessonForSelected;
import Model.Question;
import Model.Quiz;
import Model.QuizzList;
import Model.Topic;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author TRAN DUC HIEU
 */
@WebServlet(name = "LessonViewController", urlPatterns = {"/Lesson"})
public class LessonViewController extends HttpServlet {

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
        String id = request.getParameter("subjectID");
        String lessonId = request.getParameter("lessonID");

        try {
            Subject subject = new SubjectDAO().getSubjectByID(Integer.parseInt(id));
            List<Lesson> lstLesson = new LessonDAO().getAllLessonBySubjectID(id);
            List<LessonManager> lstMngLessons = new ArrayList<>();
            List<Lesson> tmp_Lessons = null;

            for (Lesson l : lstLesson) {
                if (l.getLessonID() == l.getLessonParent()) {
                    LessonManager managerLesson = new LessonDAO().getManagerLessonByParentID(l.getLessonID());
                    lstMngLessons.add(managerLesson);
                }
            }
            for (LessonManager m : lstMngLessons) {
                List<Lesson> tmp_listLesson = m.getLstLesson();
                Collections.sort(tmp_listLesson, new Comparator<Lesson>() {
                    @Override
                    public int compare(Lesson o1, Lesson o2) {
                        return o1.getOrder() > o2.getOrder() ? 1 : -1;
                    }
                });
                m.setLstLesson(tmp_listLesson);
            }
            LessonView lessonView = new LessonView(subject, lstMngLessons);
            if (lessonId != null) {
                Lesson lesson = new LessonDAO().getLessonByID(Integer.parseInt(lessonId));
                request.setAttribute("Lesson", lesson);
                boolean hasQuiz = new QuizDAO().checkQuizExits(lessonId);
                if (hasQuiz) {
                    Quiz quiz = new QuizDAO().getQuizById(lessonId);
                    LessonForSelected lessionSe = new LessonDAO().getLessionByID(1);
                    Subject subject1 = new SubjectDAO().getSubjectByID(lessionSe.getSubjectID());
                    Topic topic = new TopicDAO().getTopicByID(lessionSe.getTopicID());
                    List<Question> lstQuestion = new QuestionDAO().getListQuestionByQuizID(lessionSe.getID());
                    QuizzList quizzList = new QuizzList(quiz, lessionSe, subject1, lstQuestion);
                    request.setAttribute("topic", topic);
                    request.setAttribute("quizzList", quizzList);
                    quizzList.getQuiz().getNumOfQuestion();
                }
            }
            request.setAttribute("lessonView", lessonView);

        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("LessonView.jsp").forward(request, response);
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
