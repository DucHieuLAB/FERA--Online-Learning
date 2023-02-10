/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.AnswerDAO;
import Dao.LessonDAO;
import Dao.QuestionDAO;
import Dao.QuizDAO;
import Dao.QuizQuestionDAO;
import Dao.ResultDAO;
import Dao.ResultDetailDAO;
import Dao.SubjectDAO;
import Model.Answer;
import Model.Lesson;
import Model.LessonForSelected;
import Model.Question;
import Model.Quiz;
import Model.QuizQuestion;
import Model.QuizzList;
import Model.Result;
import Model.ResultDetail;
import Model.Subject;
import Service.QuizCalculating;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TRAN DUC HIEU
 */
@WebServlet(name = "QuizHandleServlet", urlPatterns = {"/QuizHandle"})
public class QuizHandleServlet extends HttpServlet {

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
        String QuizID = request.getParameter("QuizID");
        QuizID = "2";
        try {
            // get quiz
            LessonForSelected tmp_Lesson;
            Subject tmp_Subject;
            QuizzList quizzList = new QuizzList();
            Quiz quiz = new QuizDAO().getQuizById(QuizID);

            tmp_Lesson = new LessonDAO().getLessionByID(Integer.parseInt(QuizID));
            tmp_Subject = new SubjectDAO().getSubjectByID(tmp_Lesson.getSubjectID());
            List<Question> lstQuestions = new QuestionDAO().getListQuestionByQuizID(quiz.getLessionID());
            List Answer = null;
            for (Question q : lstQuestions) {
                Answer = new QuestionDAO().getListAnswer(q.getId());
                q.setAnswer(Answer);
            }
            quizzList = new QuizzList(quiz, tmp_Lesson, tmp_Subject, lstQuestions);
            request.setAttribute("quizzList", quizzList);

            long startTime = System.currentTimeMillis();
            int duration = quiz.getDuration();
            long duration_mili = duration * 60 * 1000;
            String Time = formartTime(duration_mili);
            HttpSession session = request.getSession();
            if (session.getAttribute("TimeTaked") == null) {
                session.setAttribute("TimeTaked", startTime);
            } else {
                startTime = (long) session.getAttribute("TimeTaked");
                long time_left = duration_mili - (System.currentTimeMillis() - startTime);
                if (time_left <= 0) {
                    session.removeAttribute("TimeTaked");
                    request.getRequestDispatcher("QuizHandle.jsp").forward(request, response);
                }
                Time = formartTime(time_left);

            }
            request.setAttribute("time", Time);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("QuizHandle.jsp").forward(request, response);
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
        String QuizID = request.getParameter("QuizID");
        String result = request.getParameter("result");
        HttpSession session = request.getSession(false);
        long startTime = (long) session.getAttribute("TimeTaked");
        session.removeAttribute("TimeTaked");
        long currentTime = System.currentTimeMillis();
        try {
            Quiz quiz = new QuizDAO().getQuizById(QuizID);
            Lesson lesson = new LessonDAO().getLessonByID(quiz.getLessionID());
            long takTime = currentTime - startTime;
            long duration_mili = quiz.getDuration() * 60 * 1000;
            if (takTime >= duration_mili) {
                takTime = duration_mili;
            }
            Date date = new Date(System.currentTimeMillis());
            List<Question> lstQuestions = new QuestionDAO().getListQuestionByQuizID(quiz.getLessionID());
            String[] lstIDAnswer = result.split("-");
            List<Answer> lstAnswer = new ArrayList<>();
            for (String id : lstIDAnswer) {
                if (id != "" && id != null) {
                    lstAnswer.add(new AnswerDAO().getAnswerByID(Integer.parseInt(id)));
                }
            }
            QuizCalculating cal = new QuizCalculating(quiz, lstQuestions, lstAnswer);
            float num_result = cal.getResult();
            boolean isPass = false;
            if (num_result >= ((float) quiz.getPass_rate() / 100)) {
                isPass = true;
            }
            //get AccountID
            int AccountID = 4;
            //save into Database Reslut Table
            List<QuizQuestion> quizQuestions = new QuizQuestionDAO().getLstQuizQuestionByLessonID(quiz.getLessionID());
            boolean isSaveResult = new ResultDAO().checkResultExist(AccountID, quiz.getLessionID());
            if (isSaveResult) {
                isSaveResult = new ResultDAO().updateResult(new Result(AccountID, quiz.getLessionID(), isPass, date, takTime, cal.numUnAnswer));
//                 remove resultDetail
                boolean isRemove = new ResultDetailDAO().removeOldQuiz(AccountID, quiz.getLessionID());
//                if (!isRemove) {
//                    throw new Exception("Errol remove old database");
//                }
                List<ResultDetail> resultDetails = new ArrayList<>();
                for (Answer a : lstAnswer) {
                    ResultDetail tmp_reDetail = new ResultDetail(getQuizQuestionID(a.getQuestionID(), quizQuestions), AccountID, a.getID());
                    resultDetails.add(tmp_reDetail);
                }
                boolean saveAnswer = new ResultDetailDAO().insertListResultDetail(resultDetails);
            } else {
                isSaveResult = new ResultDAO().insertReslut(new Result(AccountID, quiz.getLessionID(), isPass, date, takTime, cal.numUnAnswer));
                List<ResultDetail> resultDetails = new ArrayList<>();
                for (Answer a : lstAnswer) {
                    ResultDetail tmp_reDetail = new ResultDetail(getQuizQuestionID(a.getQuestionID(), quizQuestions), AccountID, a.getID());
                    resultDetails.add(tmp_reDetail);
                }
                // save answer into database
                boolean saveAnswer = new ResultDetailDAO().insertListResultDetail(resultDetails);
            }

            request.setAttribute("lstQuestions", lstQuestions);
            request.setAttribute("isPass", isPass);
            request.setAttribute("Lesson", lesson);
            request.setAttribute("Quiz", quiz);
            request.setAttribute("takTime", formartTime(takTime));
            request.setAttribute("QuizCalculating", cal);

        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("QuizReview.jsp").forward(request, response);
        }
    }

    public String formartTime(long millis) {
        long minutes = (millis / 1000) / 60;
        long seconds = (millis / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public int getQuizQuestionID(int QuestionID, List<QuizQuestion> list) {
        for (QuizQuestion quizQuestion : list) {
            if (quizQuestion.getQuestionID() == QuestionID) {
                return quizQuestion.getID();
            }
        }
        return 0;
    }

}
