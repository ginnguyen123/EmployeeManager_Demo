package models;

import utils.DateUtils;

import java.time.Instant;
import java.util.Date;

public  class  Experience extends Employee {
    private float exYears;
    private String skills;

    public Experience(){}
    public Experience(float exYears, String skills){
        this.exYears = exYears;
        this.skills = skills;
    }

    public Experience(long idEmployee, String fullName, String brithDay, String phoneNumbers,
                      String email, EmployeeType employeeType, float exYears, String skills,
                      Date atCreated, Date atUpdate) {
        super(idEmployee, fullName, brithDay, phoneNumbers, email,employeeType,atCreated, atUpdate);
        this.exYears = exYears;
        this.skills = skills;
    }
    public static Experience parseExperience(String experienceLine){
        String[] fields = experienceLine.split(",");
        //long idEmployee, String fullName, String brithDay, String phoneNumbers,
        //                      String email, EmployeeType employeeType, float exYears, String skills,
        //                      Date atCreated, Date atUpdate
        long idExperience = Long.parseLong(fields[0]);
        String fullName = fields[1];
        String brithDay = fields[2];
        String phoneNumbers = fields[3];
        String email = fields[4];
        EmployeeType employeeType = EmployeeType.getEmplyeeType(Integer.parseInt(fields[5]));
        Date atCreated = DateUtils.stringToDate(fields[6]);
        Date atUpdate = DateUtils.stringToDate(fields[7]);
        String skills = fields[8];
        float exYears = Float.parseFloat(fields[9]);
        Experience experience = new Experience(idExperience, fullName,brithDay,phoneNumbers,email,
                employeeType,exYears, skills,atCreated,atUpdate);
        return experience;
    }

    public float getExYears() {
        return exYears;
    }

    public void setExYears(float exYears) {
        this.exYears = exYears;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String toString(){
        return  super.toString() +
                "," + skills +
                "," + exYears;
    }

}
