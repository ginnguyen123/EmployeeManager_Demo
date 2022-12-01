package views;

import Controls.EmployeeServices;
import Controls.InternServicers;

import java.util.Scanner;

public class InternViews {
    private InternServicers internServicers;
    private EmployeeServices employeeServices;
    public InternViews(){
        this.internServicers = InternServicers.getInstance();
        this.employeeServices = EmployeeServices.getInstance();
    }
    public static Scanner scanner = new Scanner(System.in);
    public void showInternViews(){}
    public void sortByNameAToZInternViews(){}
    public void sortByNameZToAInternViews(){}
    public void addInternViews(){}
    public void findInternViews(){}
    public void removeInternViews(){}
}
