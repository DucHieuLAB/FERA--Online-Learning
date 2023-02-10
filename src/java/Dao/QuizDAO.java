/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRAN DUC HIEU
 */
public class QuizDAO {

    public int getNumTotalQuizzList(String searchBy, String SearchKey) throws SQLException, ClassNotFoundException {
        int result = -1;
        String query = "Select count(*) as Count "
                + " from Quiz "
                + " Join Lesson on Lesson.ID = Quiz.LessionID \n"
                + "where " + searchBy + " like ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, "%" + SearchKey + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = rs.getInt("Count");
        }
        rs.close();
        pstm.close();
        conn.close();
        return result;
    }

    public List<Quiz> pagingQuizzList(int index, String searchBy, String searchKey, String filter, String order) throws SQLException, ClassNotFoundException {
        List<Quiz> lst = new ArrayList<>();
        Quiz quiz_tmp;
        String query = "SELECT * FROM Quiz \n"
                + " Join Lesson on Lesson.ID = Quiz.LessionID \n"
                + "WHERE " + searchBy + " like ?  \n"
                + "Order By " + filter + " " + order + "\n"
                + "OFFSET ? ROW FETCH NEXT 10 ROW ONLY \n"
                + " ;";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, "%" + searchKey + "%");
        pstm.setInt(2, (index - 1) * 10);

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            lst.add(new Quiz(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
        };
        rs.close();
        pstm.close();
        conn.close();
        return lst;
    }

    public boolean createQuiz(Quiz quiz) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "INSERT INTO Quiz VALUES (?,?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, quiz.getLessionID());
        pstm.setInt(2, quiz.getDuration());
        pstm.setInt(3, quiz.getPass_rate());
        pstm.setString(4, quiz.getDescription());
        pstm.setString(5, quiz.getMedia());
        pstm.setInt(6, quiz.getAccountID());
        pstm.setInt(7, quiz.getNumOfQuestion());
        status = pstm.executeUpdate() > 0 ? true : false;
        pstm.close();
        conn.close();
        return status;
    }

    public boolean importQuestionToQuiz(Quiz q) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "  INSERT INTO QuizQuestion  SELECT TOP " + q.getNumOfQuestion() + " Quiz.LessionID,Question.ID\n"
                + "  FROM Question,Quiz,Lesson\n"
                + "  WHERE Quiz.LessionID = Lesson.ID and Question.SubjectID = Lesson.SubjectID and Question.TopicID = Lesson.TopicID and Quiz.LessionID = ? \n"
                + "  ORDER BY NEWID()";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, q.getLessionID());
        status = pstm.executeUpdate() > 0 ? true : false;
        pstm.close();
        conn.close();
        return status;
    }

    public Quiz getQuizById(String LessionId) throws SQLException, ClassNotFoundException {
        Quiz result = null;
        String query = "SELECT * FROM Quiz WHERE Quiz.LessionID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, LessionId);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = new Quiz(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
        };
        return result;
    }

    public boolean checkQuizExits(String lessonId) throws SQLException, ClassNotFoundException {
        boolean result = false;
        String query = "Select * FROM Quiz Where LessionID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, lessonId);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            result = true;
        }
        return result;
    }

    public boolean updateNumofQuestion(int QuizID, int num) throws SQLException, ClassNotFoundException {
        boolean result = false;
        String query = " UPDATE Quiz\n"
                + " SET NumOfQuestion = NumOfQuestion + " + num + ""
                + " WHERE LessionID = ?; ";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, QuizID);
        result = pstm.executeUpdate() > 0 ? true : false;
        return result;
    }

    public boolean removeQuestionByQuizID(int QuestionID, int QuizID) throws SQLException, ClassNotFoundException {
        boolean result = false;
        String query = "DELETE FROM QuizQuestion WHERE QuestionID = ? and  QuizID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, QuestionID);
        pstm.setInt(2, QuizID);
        result = pstm.executeUpdate() > 0 ? true : false;
        if (result) {
            result = updateNumofQuestion(QuizID, -1);
        }
        return result;
    }

    public boolean AddNewQuestionToQuiz(int QuestionID, int QuizID) throws SQLException, ClassNotFoundException {
        boolean result = false;
        String query = "INSERT INTO QuizQuestion VALUES(?,?)";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);

        pstm.setInt(1, QuizID);
        pstm.setInt(2, QuestionID);
        result = pstm.executeUpdate() > 0 ? true : false;
        if (result) {
            result = updateNumofQuestion(QuizID, 1);
        }
        return result;
    }

    public boolean UpdateQuizInfo(Quiz q) throws SQLException, ClassNotFoundException {
        boolean result = false;
        String query = " UPDATE Quiz\n"
                + " SET [Duration] = ? , Pass_rate = ? , Description = ?, Media = ?  "
                + " WHERE LessionID = ?  ";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, q.getDuration());
        pstm.setInt(2, q.getPass_rate());
        pstm.setString(3, q.getDescription());
        pstm.setString(4, q.getMedia());
        pstm.setInt(5, q.getLessionID());
        result = pstm.executeUpdate() > 0 ? true : false;
        return result;
    }
}
