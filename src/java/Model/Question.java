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
public class Question {

    private int id;
    private String QuestionName;
    private String QuestionDetail;
    private int TopicID;
    private int NumAnsCorrect;
    private String Explanation;
    private boolean Status;
    private String media;
    private int SubjectID;
    private int DimensionID;
    List<Answer> Answer;
    

    public Question() {
    }

    public Question(int id, String QuestionName, String QuestionDetail, int TopicID, int NumAnsCorrect, String Explanation, boolean Status, String media, int SubjectID, int DimensionID, List<Answer> Answer) {
        this.id = id;
        this.QuestionName = QuestionName;
        this.QuestionDetail = QuestionDetail;
        this.TopicID = TopicID;
        this.NumAnsCorrect = NumAnsCorrect;
        this.Explanation = Explanation;
        this.Status = Status;
        this.media = media;
        this.SubjectID = SubjectID;
        this.DimensionID = DimensionID;
        this.Answer = Answer;
    }

    public Question(int id, String QuestionName, String QuestionDetail, int TopicID, int NumAnsCorrect, String Explanation, boolean Status, String media, int SubjectID, int DimensionID) {
        this.id = id;
        this.QuestionName = QuestionName;
        this.QuestionDetail = QuestionDetail;
        this.TopicID = TopicID;
        this.NumAnsCorrect = NumAnsCorrect;
        this.Explanation = Explanation;
        this.Status = Status;
        this.media = media;
        this.SubjectID = SubjectID;
        this.DimensionID = DimensionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionName() {
        return QuestionName;
    }

    public void setQuestionName(String QuestionName) {
        this.QuestionName = QuestionName;
    }

    public String getQuestionDetail() {
        return QuestionDetail;
    }

    public void setQuestionDetail(String QuestionDetail) {
        this.QuestionDetail = QuestionDetail;
    }

    public int getTopicID() {
        return TopicID;
    }

    public void setTopicID(int TopicID) {
        this.TopicID = TopicID;
    }

    public int getNumAnsCorrect() {
        return NumAnsCorrect;
    }

    public void setNumAnsCorrect(int NumAnsCorrect) {
        this.NumAnsCorrect = NumAnsCorrect;
    }

    public String getExplanation() {
        return Explanation;
    }

    public void setExplanation(String Explanation) {
        this.Explanation = Explanation;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public int getDimensionID() {
        return DimensionID;
    }   

    public void setDimensionID(int DimensionID) {
        this.DimensionID = DimensionID;
    }

    public List<Answer> getAnswer() {
        return Answer;
    }

    public void setAnswer(List<Answer> Answer) {
        this.Answer = Answer;
    }

    
}
