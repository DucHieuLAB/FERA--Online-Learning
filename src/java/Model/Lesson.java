/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tra My
 */
public class Lesson {
    private int lessonID;
    private String Title;
    private int topicID;
    private int subjectID;
    private String type;
    private boolean status;
    private String video_link;
    private String content;
    private int order;
    private int lessonParent;

    public Lesson() {
    }

    public Lesson(int lessonID, String Title, int topicID, int subjectID, String type, boolean status, String video_link, String content, int order, int lessonParent) {
        this.lessonID = lessonID;
        this.Title = Title;
        this.topicID = topicID;
        this.subjectID = subjectID;
        this.type = type;
        this.status = status;
        this.video_link = video_link;
        this.content = content;
        this.order = order;
        this.lessonParent = lessonParent;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getLessonParent() {
        return lessonParent;
    }

    public void setLessonParent(int lessonParent) {
        this.lessonParent = lessonParent;
    }

    @Override
    public String toString() {
        return "Lesson{" + "lessonID=" + lessonID + ", Title=" + Title + ", topicID=" + topicID + ", subjectID=" + subjectID + ", type=" + type + ", status=" + status + ", video_link=" + video_link + ", content=" + content + ", order=" + order + ", lessonParent=" + lessonParent + '}';
    }
    
    
    
}
