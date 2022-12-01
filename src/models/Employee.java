package models;

import utils.DateUtils;
import utils.IOFileUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    public static long employeeCounts = 0;
    private long idEmployee;
    private String fullName;
    private String brithDay;
    private String phoneNumbers;
    private String email;
    private Date atCreated;
    private Date atUpdated;
    private List<Certificates> certificates = new ArrayList<>();
    private EmployeeType employeeType; // 1 - 2 -3

    public Employee(){}

    public Employee(long idEmployee, String fullName, String brithDay, String phoneNumbers,
                    String email,EmployeeType employeeType, Date atCreated, Date atUpdated) {//List<Certificates> certificates,
        this.idEmployee = idEmployee;
        this.fullName = fullName;
        this.brithDay = brithDay;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.atCreated = atCreated;
        this.atUpdated = atUpdated;
        this.employeeType = employeeType;
        employeeCounts++;
    }
    public static Employee parseEmployee(String employeeLine){
        String[] fields = employeeLine.split(",");
        //idEmployee, String fullName, String brithDay, String phoneNumbers,
        //                    String email,EmployeeType employeeType, Date atCreated, Date atUpdated)
        long idEmployee = Long.parseLong(fields[0]);
        String fullName = fields[1];
        String brithDay = fields[2];
        String phoneNumbers = fields[3];
        String email = fields[4];
        EmployeeType employeeType = EmployeeType.getEmplyeeType(Integer.parseInt(fields[5]));
        Date atCreated = DateUtils.stringToDate(fields[6]);
        Date atUpdated = DateUtils.stringToDate(fields[7]);
        Employee employee = new Employee(idEmployee,fullName,brithDay,phoneNumbers,email,employeeType,atCreated,atUpdated);
        return employee;
    }
//    Employee getEmployee();
    public Date getAtUpdated() {
        return atUpdated;
    }

    public void setAtUpdated(Date atUpdated) {
        this.atUpdated = atUpdated;
    }

    public EmployeeType getEmployeeTypes() {
        return employeeType;
    }

    public void setEmployeeTypes(EmployeeType employeeTypes) {
        this.employeeType = employeeTypes;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBrithDay() {
        return brithDay;
    }

    public void setBrithDay(String brithDay) {
        this.brithDay = brithDay;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static long getEmployeeCounts() {
        return employeeCounts;
    }

    public static void setEmployeeCounts(long employeeCounts) {
        Employee.employeeCounts = employeeCounts;
    }

    public Date getAtCreated() {
        return atCreated;
    }

    public void setAtCreated(Date atCreated) {
        this.atCreated = atCreated;
    }

    public List<Certificates> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificates> certificates) {
        this.certificates = certificates;
    }
    public String toString(){
        String formatAtCreated = DateUtils.dateToString(atCreated);
        String formatAtUpdated = DateUtils.dateToString(atUpdated);
        //long idEmployee, String fullName, Date brithDay, String phoneNumbers, String email
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s",
                this.idEmployee, this.fullName, brithDay, this.phoneNumbers, this.email,this.employeeType.getType(),
                formatAtCreated, formatAtUpdated);
    }
}
