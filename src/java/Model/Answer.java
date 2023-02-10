/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TRAN DUC HIEU
 */
public class Answer {
    private int ID;
    private int QuestionID;
    private String AnswerContent;
    private boolean Correct;
    private String Comment;

    public Answer() {
    }

    public Answer(int QuestionID, String AnswerContent, boolean Correct, String Comment) {
        this.QuestionID = QuestionID;
        this.AnswerContent = AnswerContent;
        this.Correct = Correct;
        this.Comment = Comment;
    }
    
    public Answer(int ID, int QuestionID, String AnswerContent, boolean Correct, String Comment) {
        this.ID = ID;
        this.QuestionID = QuestionID;
        this.AnswerContent = AnswerContent;
        this.Correct = Correct;
        this.Comment = Comment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getAnswerContent() {
        return AnswerContent;
    }

    public void setAnswerContent(String AnswerContent) {
        this.AnswerContent = AnswerContent;
    }

    public boolean isCorrect() {
        return Correct;
    }

    public void setCorrect(boolean Correct) {
        this.Correct = Correct;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }
    
}
