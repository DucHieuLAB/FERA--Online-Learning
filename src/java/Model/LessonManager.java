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
public class LessonManager {
    private Lesson LessonParent;
    private List<Lesson> lstLesson;

    public LessonManager() {
    }

    public LessonManager(Lesson LessonParent, List<Lesson> lstLesson) {
        this.LessonParent = LessonParent;
        this.lstLesson = lstLesson;
    }

    public Lesson getLessonParent() {
        return LessonParent;
    }

    public void setLessonParent(Lesson LessonParent) {
        this.LessonParent = LessonParent;
    }

    public List<Lesson> getLstLesson() {
        return lstLesson;
    }

    public void setLstLesson(List<Lesson> lstLesson) {
        this.lstLesson = lstLesson;
    }

    
    
}
