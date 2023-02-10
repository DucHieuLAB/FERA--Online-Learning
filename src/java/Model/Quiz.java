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
public class Quiz {
    private int LessionID;
    private int Duration;
    private int Pass_rate;
    private String Description;
    private String Media;
    private int AccountID;
    private int NumOfQuestion;

    public Quiz() {
    }

    public Quiz(int LessionID, int Duration, int Pass_rate, String Description, String Media, int NumOfQuestion) {
        this.LessionID = LessionID;
        this.Duration = Duration;
        this.Pass_rate = Pass_rate;
        this.Description = Description;
        this.Media = Media;
        this.NumOfQuestion = NumOfQuestion;
    }

    public Quiz(int LessionID, int Duration, int Pass_rate, String Description, String Media, int AccountID, int NumOfQuestion) {
        this.LessionID = LessionID;
        this.Duration = Duration;
        this.Pass_rate = Pass_rate;
        this.Description = Description;
        this.Media = Media;
        this.AccountID = AccountID;
        this.NumOfQuestion = NumOfQuestion;
    }

    public int getLessionID() {
        return LessionID;
    }

    public void setLessionID(int LessionID) {
        this.LessionID = LessionID;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public int getPass_rate() {
        return Pass_rate;
    }

    public void setPass_rate(int Pass_rate) {
        this.Pass_rate = Pass_rate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getMedia() {
        return Media;
    }

    public void setMedia(String Media) {
        this.Media = Media;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getNumOfQuestion() {
        return NumOfQuestion;
    }

    public void setNumOfQuestion(int NumOfQuestion) {
        this.NumOfQuestion = NumOfQuestion;
    }

    @Override
    public String toString() {
        return "Quiz{" + "LessionID=" + LessionID + ", Duration=" + Duration + ", Pass_rate=" + Pass_rate + ", Description=" + Description + ", Media=" + Media + ", AccountID=" + AccountID + ", NumOfQuestion=" + NumOfQuestion + '}';
    }    
}
