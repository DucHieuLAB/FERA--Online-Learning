/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author hieutdhe141410
 */
public class Result {
    private int AccountID;
    private int LessonID;
    private boolean Status;
    private Date DateUpdate;
    private long TotalTime;
    private int UnAnswerQuestion;

    public Result() {
    }

    public Result(int AccountID, int LessonID, boolean Status, Date DateUpdate, long TotalTime, int UnAnswerQuestion) {
        this.AccountID = AccountID;
        this.LessonID = LessonID;
        this.Status = Status;
        this.DateUpdate = DateUpdate;
        this.TotalTime = TotalTime;
        this.UnAnswerQuestion = UnAnswerQuestion;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getLessonID() {
        return LessonID;
    }

    public void setLessonID(int LessonID) {
        this.LessonID = LessonID;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Date getDateUpdate() {
        return DateUpdate;
    }

    public void setDateUpdate(Date DateUpdate) {
        this.DateUpdate = DateUpdate;
    }

    public long getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(long TotalTime) {
        this.TotalTime = TotalTime;
    }

    public int getUnAnswerQuestion() {
        return UnAnswerQuestion;
    }

    public void setUnAnswerQuestion(int UnAnswerQuestion) {
        this.UnAnswerQuestion = UnAnswerQuestion;
    }
    
}
