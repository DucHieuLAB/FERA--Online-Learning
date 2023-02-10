/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Answer;
import Model.Lesson;
import Model.Question;
import Model.Quiz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieutdhe141410
 */
public class QuizCalculating {

    private Quiz quiz;
    private List<Question> lstQuestions;
    private List<Question> lstCorrectQuestion;   
    private List<Answer> ans_result;
    public float score;
    public int numcorrect;
    public int numUnAnswer;
    public int numAnswer;
    public int tmp_num;

    public void initValue() {
        score = 0;
        numcorrect = 0;
        numUnAnswer = 0;
        numAnswer = 0;
        tmp_num = 0;
        lstCorrectQuestion = new ArrayList<>();
    }

    public QuizCalculating() {
        initValue();
    }

    public QuizCalculating(Quiz quiz, List<Question> lstQuestions, List<Answer> ans_result) {
        this.quiz = quiz;
        this.lstQuestions = lstQuestions;
        this.ans_result = ans_result;

        initValue();
    }

    public float getResult() {
        int num_question = lstQuestions.size();
        for (Question q : lstQuestions) {
            boolean hadAns = false;
            boolean correct_ques = true;
            for (Answer a : q.getAnswer()) {
                boolean correct = a.isCorrect();
                if (checkAnsIDExits(a.getID())) {
                    hadAns = true;
                    if (!correct) {
                        correct_ques = false;
                    }
                } else {
                    if (correct) {
                        correct_ques = false;
                    }
                }
            }
            if (correct_ques) {
                numcorrect++;
                lstCorrectQuestion.add(q);
            }
            if (!hadAns) {
                numUnAnswer++;
            }
        }
        this.score =(float) numcorrect / num_question;
        return score;
    }

    public boolean checkAnsIDExits(int id) {
        for (Answer a : ans_result) {
            if (a.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Question> getLstQuestions() {
        return lstQuestions;
    }

    public void setLstQuestions(List<Question> lstQuestions) {
        this.lstQuestions = lstQuestions;
    }

    public List<Question> getLstCorrectQuestion() {
        return lstCorrectQuestion;
    }

    public void setLstCorrectQuestion(List<Question> lstCorrectQuestion) {
        this.lstCorrectQuestion = lstCorrectQuestion;
    }

    public List<Answer> getAns_result() {
        return ans_result;
    }

    public void setAns_result(List<Answer> ans_result) {
        this.ans_result = ans_result;
    }



    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getNumcorrect() {
        return numcorrect;
    }

    public void setNumcorrect(int numcorrect) {
        this.numcorrect = numcorrect;
    }

    public int getNumUnAnswer() {
        return numUnAnswer;
    }

    public void setNumUnAnswer(int numUnAnswer) {
        this.numUnAnswer = numUnAnswer;
    }

    public int getNumAnswer() {
        return numAnswer;
    }

    public void setNumAnswer(int numAnswer) {
        this.numAnswer = numAnswer;
    }

    public int getTmp_num() {
        return tmp_num;
    }

    public void setTmp_num(int tmp_num) {
        this.tmp_num = tmp_num;
    }
    
}
