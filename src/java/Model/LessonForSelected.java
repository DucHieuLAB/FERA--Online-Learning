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
public class LessonForSelected {
    private int ID;
    private String Name;
    private int TopicID;
    private int Order;
    private int SubjectID;
    private String Type;
    private int lessonParent;
    
    public LessonForSelected() {
    }

    public LessonForSelected(int ID, String Name, int TopicID, int Order, int SubjectID, String Type, int lessonParent) {
        this.ID = ID;
        this.Name = Name;
        this.TopicID = TopicID;
        this.Order = Order;
        this.SubjectID = SubjectID;
        this.Type = Type;
        this.lessonParent = lessonParent;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTopicID() {
        return TopicID;
    }

    public void setTopicID(int TopicID) {
        this.TopicID = TopicID;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int Order) {
        this.Order = Order;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getLessonParent() {
        return lessonParent;
    }

    public void setLessonParent(int lessonParent) {
        this.lessonParent = lessonParent;
    }

    @Override
    public String toString() {
        return "Lession{" + "ID=" + ID + ", Name=" + Name + ", TopicID=" + TopicID + ", Order=" + Order + ", SubjectID=" + SubjectID + ", Type=" + Type + ", lessonParent=" + lessonParent + '}';
    }
    
}
