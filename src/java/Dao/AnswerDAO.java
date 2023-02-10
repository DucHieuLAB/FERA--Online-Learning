/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TRAN DUC HIEU
 */
public class AnswerDAO {

    public boolean createAnswer(Answer ans) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "INSERT INTO [dbo].[Answer]\n"
                + "           ([QuestionID]\n"
                + "           ,[AnswerContent]\n"
                + "           ,[Correct]\n"
                + "           ,[Comment])\n"
                + "     VALUES(?,?,?,?)";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ans.getQuestionID());
        pstm.setString(2, ans.getAnswerContent());
        pstm.setBoolean(3, ans.isCorrect());
        pstm.setString(4, ans.getComment());
        int row = pstm.executeUpdate();
        if (row > 0) {
            status = true;
        }
        if (status) {
            if (ans.isCorrect()) {
                new QuestionDAO().updateNumAnsCorrectByQuestionID(ans.getQuestionID(), 1);
            }

        }
        return status;
    }

    public boolean deleteAnswer(int ID) throws SQLException, ClassNotFoundException {
        boolean status = false;
        Answer oldAnswer = getAnswerByID(ID);
        String query = "DELETE FROM Answer WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ID);
        int row = pstm.executeUpdate();
        if (row > 0) {
            status = true;
        }
        if(status){
            if(oldAnswer.isCorrect() == true){
                new QuestionDAO().updateNumAnsCorrectByQuestionID(oldAnswer.getQuestionID(), -1);
            }
        }
        return status;
    }

    public boolean updateAnswer(Answer ans) throws SQLException, ClassNotFoundException {
        boolean status = false;
        Answer tmp_answer = getAnswerByID(ans.getID());
        String query = "UPDATE [dbo].[Answer]\n"
                + "   SET [QuestionID] = ?\n"
                + "      ,[AnswerContent] = ?\n"
                + "      ,[Correct] = ?\n"
                + "      ,[Comment] = ?\n"
                + " WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ans.getQuestionID());
        pstm.setString(2, ans.getAnswerContent());
        pstm.setBoolean(3, ans.isCorrect());
        pstm.setString(4, ans.getComment());
        pstm.setInt(5, ans.getID());
        int row = pstm.executeUpdate();
        if (row > 0) {
            status = true;
        }
        if (status) {
            if (tmp_answer.isCorrect() == false && ans.isCorrect() == true) {
                new QuestionDAO().updateNumAnsCorrectByQuestionID(ans.getQuestionID(), 1);
            } else if (tmp_answer.isCorrect() == true && ans.isCorrect() == false) {
                new QuestionDAO().updateNumAnsCorrectByQuestionID(ans.getQuestionID(), -1);
            }
        }
        return status;
    }

    public Answer getAnswerByID(int ID) throws SQLException, ClassNotFoundException {
        Answer answer = null;
        String query = "SELECT * FROM Answer WHERE ID=?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            answer = new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getString(5));
        }
        return answer;
    }
}
