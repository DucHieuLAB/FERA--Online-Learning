/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.QuizQuestion;
import Model.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRAN DUC HIEU
 */
public class QuizQuestionDAO {

    public List<QuizQuestion> getLstQuizQuestionByLessonID(int LessonID) throws SQLException, ClassNotFoundException {
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        String query = "SELECT * FROM QuizQuestion WHERE QuizID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, LessonID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          quizQuestions.add(new QuizQuestion(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
        }
        return quizQuestions;
    }
}
