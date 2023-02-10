/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author TRAN DUC HIEU
 */
public class Customer {
    private int id;
    private String username;
    private String password;
    private int RoleID;
    private String Full_Name;
    private String Address;
    private String About_Me;
    private Date Birthday;
    private boolean Gender;
    private String Education;
    private String img;
    private String Email;

    public Customer() {
    }

    public Customer(int id, String username, String password, int RoleID, String Full_Name, String Address, String About_Me, Date Birthday, boolean Gender, String Education, String img, String Email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.RoleID = RoleID;
        this.Full_Name = Full_Name;
        this.Address = Address;
        this.About_Me = About_Me;
        this.Birthday = Birthday;
        this.Gender = Gender;
        this.Education = Education;
        this.img = img;
        this.Email = Email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String Full_Name) {
        this.Full_Name = Full_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAbout_Me() {
        return About_Me;
    }

    public void setAbout_Me(String About_Me) {
        this.About_Me = About_Me;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        String Gender = this.Gender==true?"Mail":"Femail";
        return "Customer [ID: "+this.id+
                " UserName: "+this.username+
                " Password: "+ this.password +
                " RoleID: "+this.RoleID+
                " FullName: "+this.Full_Name+
                " Address: "+this.Address+
                " Birthday: "+this.Birthday+
                " Gender: "+Gender+
                " Education: "+this.Education+
                " img: "+this.img+
                " Email: "+this.Email+"]";
    }
    
}
