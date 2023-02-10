/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author TRAN DUC HIEU
 */
public class QuizQuestion {
    private int ID;
    private int QuizID;
    private int QuestionID;

    public QuizQuestion() {
    }

    public QuizQuestion(int ID, int QuizID, int QuestionID) {
        this.ID = ID;
        this.QuizID = QuizID;
        this.QuestionID = QuestionID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuizID() {
        return QuizID;
    }

    public void setQuizID(int QuizID) {
        this.QuizID = QuizID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" + "ID=" + ID + ", QuizID=" + QuizID + ", QuestionID=" + QuestionID + '}';
    }
    
}
