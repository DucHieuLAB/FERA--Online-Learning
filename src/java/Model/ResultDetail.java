/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hieutdhe141410
 */
public class ResultDetail {
    private int QuizQuestionID;
    private int AccountID;
    private int chooseAnswerID;

    public ResultDetail() {
    }

    public ResultDetail(int QuizQuestionID, int AccountID, int chooseAnswerID) {
        this.QuizQuestionID = QuizQuestionID;
        this.AccountID = AccountID;
        this.chooseAnswerID = chooseAnswerID;
    }

    public int getQuizQuestionID() {
        return QuizQuestionID;
    }

    public void setQuizQuestionID(int QuizQuestionID) {
        this.QuizQuestionID = QuizQuestionID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getChooseAnswerID() {
        return chooseAnswerID;
    }

    public void setChooseAnswerID(int chooseAnswerID) {
        this.chooseAnswerID = chooseAnswerID;
    }
    
    
}
