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
public class Subject {

    private int subjectID;
    private String subjectName;
    private int categoryID;
    private Boolean status;
    private String picture;
    private String description;
    private int dimenstionID;
    private String level;
    private String time;

    public Subject() {
    }

    public Subject(int subjectID, String subjectName, int categoryID, Boolean status, String picture, String description, int dimenstionID, String level, String time) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.categoryID = categoryID;
        this.status = status;
        this.picture = picture;
        this.description = description;
        this.dimenstionID = dimenstionID;
        this.level = level;
        this.time = time;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDimenstionID() {
        return dimenstionID;
    }

    public void setDimenstionID(int dimenstionID) {
        this.dimenstionID = dimenstionID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
