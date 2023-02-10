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
public class QuizzList {
    private Quiz quiz;
    private LessonForSelected lession;
    private Subject subject;
    private List<Question> lstQuestion;

    public QuizzList() {
    }

    public QuizzList(Quiz quiz) {
        this.quiz = quiz;
    }

    public QuizzList(LessonForSelected lession) {
        this.lession = lession;
    }

    public QuizzList(Subject subject) {
        this.subject = subject;
    }

    public QuizzList(List<Question> lstQuestion) {
        this.lstQuestion = lstQuestion;
    }

    public QuizzList(Quiz quiz, LessonForSelected lession) {
        this.quiz = quiz;
        this.lession = lession;
    }

    public QuizzList(Quiz quiz, LessonForSelected lession, Subject subject) {
        this.quiz = quiz;
        this.lession = lession;
        this.subject = subject;
    }

    public QuizzList(Quiz quiz, LessonForSelected lession, Subject subject, List<Question> lstQuestion) {
        this.quiz = quiz;
        this.lession = lession;
        this.subject = subject;
        this.lstQuestion = lstQuestion;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public LessonForSelected getLession() {
        return lession;
    }

    public void setLession(LessonForSelected lession) {
        this.lession = lession;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Question> getLstQuestion() {
        return lstQuestion;
    }

    public void setLstQuestion(List<Question> lstQuestion) {
        this.lstQuestion = lstQuestion;
    }
    
    
    
}
