/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.QuizQuestion;
import Model.ResultDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hieutdhe141410
 */
public class ResultDetailDAO {

    public boolean removeOldQuiz(int AccountID, int LessonID) throws SQLException, ClassNotFoundException {
        boolean status = true;
        List<QuizQuestion> lstQuizQuestion = new QuizQuestionDAO().getLstQuizQuestionByLessonID(LessonID);
        for (QuizQuestion quizQuestion : lstQuizQuestion) {          
            if (!removeAnswer(quizQuestion.getID(), AccountID)) {
                status = false;
            }
        }
        return status;
    }

    public boolean removeAnswer(int QuizQuestionID, int AccountID) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "delete from ResultDetail where AccountID = ? and QuizQuestionID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, AccountID);
        pstm.setInt(2, QuizQuestionID);
         status = pstm.executeUpdate() > 0 ? true : false;
        return status;
    }

    public boolean insertResultDetail(ResultDetail resultDetail) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "INSERT INTO ResultDetail VALUES(?,?,?)";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, resultDetail.getQuizQuestionID());
        pstm.setInt(2, resultDetail.getAccountID());
        pstm.setInt(3, resultDetail.getChooseAnswerID());
        status = pstm.executeUpdate() > 0 ? true : false;
        return status;
    }
    
    public boolean insertListResultDetail(List<ResultDetail> resultDetails) throws SQLException, ClassNotFoundException{
        boolean status = true;
        for (ResultDetail resultDetail : resultDetails) {
            if(!insertResultDetail(resultDetail)){
                status = false;
            }
        }
        return status;
    }
}
