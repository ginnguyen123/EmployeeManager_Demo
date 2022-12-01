package models;
import utils.DateUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Fresher extends Employee{
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(){}

    public Fresher(String graduationDate, String graduationRank, String education){
        this.education = education;
        this.graduationRank = graduationRank;
        this.graduationDate = graduationDate;
    }

    public Fresher(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,EmployeeType employeeType,
                   Date atCreated, Date atUpdate, String graduationDate, String graduationRank, String education) {
        super(idEmployee, fullName, brithDay, phoneNumbers, email,employeeType,atCreated,atUpdate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    public static Fresher parseFresher(String fresherLine){
        String[] stringFresherList = fresherLine.split(",");
//        (long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,EmployeeType employeeType,
//                Date atCreated, Date atUpdate, Date graduationDate, String graduationRank, String education)
        long idFresher = Long.parseLong(stringFresherList[0]);
        String fullName = stringFresherList[1];
        String brithDay = stringFresherList[2];
        String phoneNumbers = stringFresherList[3];
        String email = stringFresherList[4];
        EmployeeType employeeType = EmployeeType.getEmplyeeType(Integer.parseInt(stringFresherList[5]));
        Date atCreated = DateUtils.stringToDate(stringFresherList[6]);
        Date atUpdate = DateUtils.stringToDate(stringFresherList[7]);
        String graduationDate = stringFresherList[8];
        String graduationRank = stringFresherList[9];
        String education = stringFresherList[10];
        Fresher fresher = new Fresher(idFresher, fullName, brithDay, phoneNumbers, email, employeeType, atCreated, atUpdate,
                graduationDate, graduationRank, education);
        return fresher;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {this.graduationDate = graduationDate;}

    public String toString(){
        return super.toString() +
                "," + this.graduationDate +
                "," + this.graduationRank;
    }
}
