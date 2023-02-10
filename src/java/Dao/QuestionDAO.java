/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Answer;
import Model.LessonForSelected;
import Model.Question;
import Validate.Query;
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
public class QuestionDAO {

    public int getNumTotalQuesion(String searchBy, String SearchKey) throws SQLException, ClassNotFoundException {
        int result = -1;
        String query = "Select count(*) as Count from Question where " + searchBy + " like ?";
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

    public List<Question> pagingQuestion(int index, String searchBy, String searchKey, String filter, String order) throws SQLException, ClassNotFoundException {
        List<Question> lst = new ArrayList<>();
        Question question_tmp;
        String query = "SELECT * FROM Question \n"
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
            question_tmp = new Question(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getBoolean(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10));
            lst.add(question_tmp);

        };
        rs.close();
        pstm.close();
        conn.close();
        return lst;
    }

    public List<Question> getListQuestion() throws SQLException, ClassNotFoundException {
        List<Question> lstQuestions = new ArrayList<>();
        Question question_tmp;
        Connection conn = ConnectJDBC.getSQLServerConnection();
        String query = "SELECT * FROM Question";
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            question_tmp = new Question(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getBoolean(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10));

            lstQuestions.add(question_tmp);
        };
        rs.close();
        pstm.close();
        conn.close();
        return lstQuestions;
    }

    public Question getQuestionByID(int questionId) throws SQLException, ClassNotFoundException {
        Question result = null;
        String query = "SELECT * FROM Question WHERE ID = ? ";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, questionId);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = new Question(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getBoolean(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10));
            result.setAnswer(getListAnswer(result.getId()));
        };
        rs.close();
        pstm.close();
        conn.close();
        return result;
    }

    public boolean updateQuestion(Question question) throws ClassNotFoundException, SQLException {
        boolean status = false;
        String query = "UPDATE Question SET QuestionName = ? ,"
                + " QuestionDetail = ?,"
                + " TopicID = ? , "
                + " NumAnsCorrect = ?, "
                + " Explanation = ?, "
                + " media = ? , "
                + " SubjectID = ?, "
                + " DimensionID = ? "
                + " WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, question.getQuestionName());
        pstm.setString(2, question.getQuestionDetail());
        pstm.setInt(3, question.getTopicID());
        pstm.setInt(4, question.getNumAnsCorrect());
        pstm.setString(5, question.getExplanation());
        pstm.setString(6, question.getMedia());
        pstm.setInt(7, question.getSubjectID());
        pstm.setInt(8, question.getDimensionID());
        pstm.setInt(9, question.getId());
        int row = pstm.executeUpdate();
        if (row > 0) {
            status = true;
        }
        pstm.close();
        conn.close();
        return status;
    }

    public boolean deleteQuestion(int Id) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "DELETE FROM Question WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, Id);
        int row = pstm.executeUpdate();
        if (row > 0) {
            status = true;
        }
        pstm.close();
        conn.close();
        return status;
    }

    public boolean createQuestion(Question question) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "INSERT INTO Question VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, question.getQuestionName());
        pstm.setString(2, question.getQuestionDetail());
        pstm.setInt(3, question.getTopicID());
        pstm.setInt(4, question.getNumAnsCorrect());
        pstm.setString(5, question.getExplanation());
        pstm.setBoolean(6, question.isStatus());
        pstm.setString(7, question.getMedia());
        pstm.setInt(8, question.getSubjectID());
        pstm.setInt(9, question.getDimensionID());
        int row = pstm.executeUpdate();
        if (row > 0) {
            status = true;
        }
        pstm.close();
        conn.close();
        return status;
    }

    public List<Answer> getListAnswer(int questionID) throws SQLException, ClassNotFoundException {
        List<Answer> ans = new ArrayList<Answer>();
        Answer Ans_tmp = null;
        String query = "SELECT *\n"
                + "FROM Answer\n"
                + "WHERE Answer.QuestionID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, questionID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Ans_tmp = new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4), rs.getString(5));
            ans.add(Ans_tmp);
        }
        rs.close();
        pstm.close();
        conn.close();
        return ans;
    }

    public int getQuestion(Question question) throws SQLException, ClassNotFoundException {
        int ID = -1;
        String query = "SELECT *FROM Question WHERE QuestionName = ? and [QuestionDetail] = ? and [TopicID] = ? and [NumAnsCorrect] = ? and [Explanation] = ? and [Status]= ? and [media] = ? and [SubjectID] = ? and [DimensionID] = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, question.getQuestionName());
        pstm.setString(2, question.getQuestionDetail());
        pstm.setInt(3, question.getTopicID());
        pstm.setInt(4, question.getNumAnsCorrect());
        pstm.setString(5, question.getExplanation());
        pstm.setBoolean(6, question.isStatus());
        pstm.setString(7, question.getMedia());
        pstm.setInt(8, question.getSubjectID());
        pstm.setInt(9, question.getDimensionID());
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            ID = rs.getInt(1);
        }
        rs.close();
        pstm.close();
        conn.close();
        return ID;
    }

    public int getNumQuestionByLession(LessonForSelected lession) throws SQLException, ClassNotFoundException {
        int result = 0;
        String query = "  Select Count(*) as Count \n"
                + "  FROM Question \n"
                + "  WHERE Question.SubjectID = ? and Question.TopicID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, lession.getSubjectID());
        pstm.setInt(2, lession.getTopicID());
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = rs.getInt("Count");
        }
        rs.close();
        pstm.close();
        conn.close();
        return result;
    }

    public List<Question> getListQuestionByQuizID(int LessionId) throws SQLException, ClassNotFoundException {
        List<Question> result = new ArrayList<>();
        Question question_tmp = null;
        List<Answer> tmp_ans = null;
        String query = "  SELECT * \n"
                + "  FROM Question, QuizQuestion\n"
                + "  WHERE Question.ID = QuizQuestion.QuestionID and QuizID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, LessionId);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            question_tmp = new Question(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getBoolean(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10));
            tmp_ans = getListAnswer(question_tmp.getId());
            question_tmp.setAnswer(tmp_ans);
            result.add(question_tmp);
        };
        rs.close();
        pstm.close();
        conn.close();
        return result;
    }

    public List<Question> getListQuestionByLesson(LessonForSelected lession) throws SQLException, ClassNotFoundException {
        List<Question> result = new ArrayList<>();
        Question question_tmp = null;
        String query = "  Select *  \n"
                + "  FROM Question \n"
                + "  WHERE Question.SubjectID = ? and Question.TopicID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, lession.getSubjectID());
        pstm.setInt(2, lession.getTopicID());
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            question_tmp = new Question(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getBoolean(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10));
            result.add(question_tmp);
        };
        rs.close();
        pstm.close();
        conn.close();
        return result;
    }

    public boolean updateNumAnsCorrectByQuestionID(int QuestionID, int count) throws SQLException, ClassNotFoundException {
        boolean status = false;
        String query = "UPDATE Question SET NumAnsCorrect = NumAnsCorrect + " + count + " WHERE ID = ? ";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, QuestionID);
        int row = pstm.executeUpdate();
        if (row > 0) {
            status = true;
        }
        return status;
    }
}
