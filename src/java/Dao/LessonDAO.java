/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.LessonForSelected;
import Model.LessonManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Lesson;

/**
 *
 * @author TRAN DUC HIEU
 */
public class LessonDAO {

    public LessonForSelected getLessionByID(int ID) throws SQLException, ClassNotFoundException {
        LessonForSelected result = null;
        String query = "SELECT ID,[Title],TopicID,[Order],SubjectID,[Type],lessonParent FROM Lesson WHERE ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setInt(1, ID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result = new LessonForSelected(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
        }
        return result;
    }

    public List<LessonForSelected> getListSelectedLession() throws SQLException, ClassNotFoundException {
        List<LessonForSelected> result = new ArrayList<>();
        String query = "SELECT ID,[Title],TopicID,[Order],SubjectID,[Type],lessonParent \n"
                + "FROM Lesson";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result.add(new LessonForSelected(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7)));
        }
        return result;
    }

    public List<LessonForSelected> getListLessionBySubjectID(String SubjectID) throws SQLException, ClassNotFoundException {
        List<LessonForSelected> result = new ArrayList<>();
        String query = "SELECT ID,[Title],TopicID,[Order],SubjectID,[Type],lessonParent \n"
                + "FROM Lesson \n"
                + "Where SubjectID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(query);
        pstm.setString(1, SubjectID);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            result.add(new LessonForSelected(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7)));
        }
        return result;
    }

    public boolean changeLessonType(int lessionID) throws SQLException, ClassNotFoundException {
        boolean status = false;
//        String query = "Update Question set Type = 'Quiz' Where LessionID = ?";
//        Connection conn = ConnectJDBC.getSQLServerConnection();
//        PreparedStatement pstm = null;
//        pstm = conn.prepareStatement(query);
//        pstm.setInt(1, lessionID);
//        status = pstm.executeUpdate() > 0 ? true : false;
        return status;
    }

    public List<Lesson> getAllLessonBySubjectID(String subjectId) throws SQLException, ClassNotFoundException {
        List<Lesson> list = new ArrayList<>();
        String sql = "select * from Lesson where SubjectID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement stm = null;
        stm = conn.prepareStatement(sql);
        stm.setString(1, subjectId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Lesson lesson = new Lesson(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getBoolean(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10)
            );
            list.add(lesson);
        }
        return list;
    }

    public List<Lesson> getAllLessonByParentID(int lessonID) throws SQLException, ClassNotFoundException {
        List<Lesson> list = new ArrayList<>();
        String sql = "select * from Lesson where lessonParent = ? and ID != ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement stm = null;
        stm = conn.prepareStatement(sql);
        stm.setInt(1, lessonID);
        stm.setInt(2, lessonID);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Lesson lesson = new Lesson(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getBoolean(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10)
            );
            list.add(lesson);
        }
        return list;
    }

    public Lesson getLessonByID(int lessonID) throws SQLException, ClassNotFoundException {
        Lesson result = null;
        String query = "Select * from Lesson Where ID = ?";
        Connection conn = ConnectJDBC.getSQLServerConnection();
        PreparedStatement stm = null;
        stm = conn.prepareStatement(query);
        stm.setInt(1, lessonID);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            result = new Lesson(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getBoolean(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getInt(10)
            );
        }
        return result;
    }

    public LessonManager getManagerLessonByParentID(int lessonID) throws SQLException, ClassNotFoundException {
        LessonManager managerLesson = null;
        Lesson lesson = getLessonByID(lessonID);
        List<Lesson> LstLesson = getAllLessonByParentID(lessonID);
        managerLesson = new LessonManager(lesson, LstLesson);
        return managerLesson;

    }

}
