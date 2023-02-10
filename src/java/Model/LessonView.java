package Model;

import java.util.List;

/**
 *
 * @author TRAN DUC HIEU
 */
public class LessonView {
    private Subject subject;
    List<LessonManager> LstManagerLessons;

    public LessonView() {
    }

    public LessonView(Subject subject, List<LessonManager> LstManagerLessons) {
        this.subject = subject;
        this.LstManagerLessons = LstManagerLessons;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<LessonManager> getLstManagerLessons() {
        return LstManagerLessons;
    }

    public void setLstManagerLessons(List<LessonManager> LstManagerLessons) {
        this.LstManagerLessons = LstManagerLessons;
    }

  
    
}
