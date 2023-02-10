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
public class Dimenstion {

    private int dimenstionID;
    private String dimenstionName;
    private int dimenstionTypeID;
    private String dimenstionDescription;

    public Dimenstion() {
    }

    public Dimenstion(int dimenstionID, String dimenstionName, int dimenstionTypeID, String dimenstionDescription) {
        this.dimenstionID = dimenstionID;
        this.dimenstionName = dimenstionName;
        this.dimenstionTypeID = dimenstionTypeID;
        this.dimenstionDescription = dimenstionDescription;
    }

    public int getDimenstionID() {
        return dimenstionID;
    }

    public void setDimenstionID(int dimenstionID) {
        this.dimenstionID = dimenstionID;
    }

    public int getDimenstionTypeID() {
        return dimenstionTypeID;
    }

    public void setDimenstionTypeID(int dimenstionTypeID) {
        this.dimenstionTypeID = dimenstionTypeID;
    }

    public String getDimenstionName() {
        return dimenstionName;
    }

    public void setDimenstionName(String dimenstionName) {
        this.dimenstionName = dimenstionName;
    }

    public String getDimenstionDescription() {
        return dimenstionDescription;
    }

    public void setDimenstionDescription(String dimenstionDescription) {
        this.dimenstionDescription = dimenstionDescription;
    }

    @Override
    public String toString() {
        return "Dimenstion{" + "dimenstionID=" + dimenstionID + ", dimenstionName=" + dimenstionName + ", dimenstionTypeID=" + dimenstionTypeID + ", dimenstionDescription=" + dimenstionDescription + '}';
    }

}
