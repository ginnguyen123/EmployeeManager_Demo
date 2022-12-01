package models;
import utils.DateUtils;

import java.util.Date;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String universityName;
    public Intern(){}
    public Intern(String majors, String semester, String universityName){
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,EmployeeType employeeType,
                  Date atCreated , Date atUpdate, String majors, String semester, String universityName) {
        super(idEmployee, fullName, brithDay, phoneNumbers, email,employeeType,atCreated,atUpdate);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
    public static Intern parseIntern(String internLine){
//        (long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,EmployeeType employeeType,
//                Date atCreated , Date atUpdate, String majors, String semester, String universityName)
        String[] stringInternList = internLine.split(",");
        long idIntern = Long.parseLong(stringInternList[0]);
        String fullName = stringInternList[1];
        String brithDay = stringInternList[2];
        String phoneNumbers = stringInternList[3];
        String email = stringInternList[4];
        EmployeeType employeeType = EmployeeType.getEmplyeeType(Integer.parseInt(stringInternList[5]));
        Date atCreated = DateUtils.stringToDate(stringInternList[6]);
        Date atUpdate = DateUtils.stringToDate(stringInternList[7]);
        String majors = stringInternList[8];
        String semester = stringInternList[9];
        String universityName = stringInternList[10];
        Intern intern = new Intern(idIntern, fullName, brithDay, phoneNumbers, email, employeeType, atCreated, atUpdate,
                majors, semester, universityName);
        return intern;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String toString(){
        return super.toString() +
                " Majors: " + majors +
                " Semester: " + semester +
                " University Name: " + universityName;
    }
}
