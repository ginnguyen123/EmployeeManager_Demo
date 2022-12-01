package views;

import Controls.EmployeeServices;
import Controls.FresherServicers;
import models.EmployeeType;
import models.Fresher;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FresherViews {
    private FresherServicers fresherServicers;
    private EmployeeServices employeeServices;
    public FresherViews(){
        this.fresherServicers = FresherServicers.getInstance();
        this.employeeServices = FresherServicers.getInstance();
    }
    public static Scanner scanner = new Scanner(System.in);
    public void showFresherViews(){
        System.out.println(">Hiển thị danh sách nhân viên Freshers.");
        List<Fresher> fresherList = fresherServicers.fresherList();
        System.out.printf("%s %s %s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                "Employee type", "Education","GraduationRank", "GraduationDate", "Date created", "Date updated");
        System.out.println("---------------------------------------------------");
        for (Fresher fresher : fresherList){
            System.out.printf("%s %s %s %s %s %s %s %s %s %s %s\n",
                    fresher.getIdEmployee(), fresher.getFullName(),
                    fresher.getBrithDay(), fresher.getPhoneNumbers(), fresher.getEmail(), fresher.getEmployeeTypes(),
                    fresher.getEducation(), fresher.getGraduationRank(), fresher.getGraduationDate(),fresher.getAtCreated(), fresher.getAtUpdated());
            System.out.println("---------------------------------------------------");
        }
    }
    public void sortByNameAToZFresherViews(){
        System.out.println(">Sắp xếp danh sách nhân viên Freshers (A -> Z).");
        List<Fresher> fresherList = fresherServicers.sortFresherByNameAToZ();
        System.out.printf("%s %s %s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                "Employee type", "Education","GraduationRank", "GraduationDate", "Date created", "Date updated");
        System.out.println("---------------------------------------------------");
        for (Fresher fresher : fresherList){
            System.out.printf("%s %s %s %s %s %s %s %s %s %s %s\n",
                    fresher.getIdEmployee(), fresher.getFullName(),
                    fresher.getBrithDay(), fresher.getPhoneNumbers(), fresher.getEmail(), fresher.getEmployeeTypes(),
                    fresher.getEducation(), fresher.getGraduationRank(), fresher.getGraduationDate(),fresher.getAtCreated(), fresher.getAtUpdated());
            System.out.println("---------------------------------------------------");
        }
    }
    public void sortByNameZToAFresherViews(){
        System.out.println(">Sắp xếp danh sách nhân viên Freshers (Z -> A).");
        List<Fresher> fresherList = fresherServicers.sortFresherByNameZToA();
        System.out.printf("%s %s %s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                "Employee type", "Education","GraduationRank", "GraduationDate", "Date created", "Date updated");
        System.out.println("---------------------------------------------------");
        for (Fresher fresher : fresherList){
            System.out.printf("%s %s %s %s %s %s %s %s %s %s %s\n",
                    fresher.getIdEmployee(), fresher.getFullName(),
                    fresher.getBrithDay(), fresher.getPhoneNumbers(), fresher.getEmail(), fresher.getEmployeeTypes(),
                    fresher.getEducation(), fresher.getGraduationRank(), fresher.getGraduationDate(),fresher.getAtCreated(), fresher.getAtUpdated());
            System.out.println("---------------------------------------------------");
        }
    }
    public void addFresherViews(){
        System.out.println(">Thêm nhân viên Fresher");
//        (long idEmployee, String fullName, String brithDay, String phoneNumbers, String email, EmployeeType employeeType,
//                Date atCreated, Date atUpdate, String graduationDate, String graduationRank, String education)
//        employeeServices.addEmployee();
        List<Fresher> fresherList = fresherServicers.fresherList();
        long idFresher = System.currentTimeMillis()%100000000;
        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập ngày tháng năm sinh: ");
        String brithDay = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");


    }
    public void findFresherViews(){
        System.out.println(">Tìm thông tin nhân viên Fresher.");
        List<Fresher> fresherList = fresherServicers.fresherList();
        System.out.print("Nhập ID nhân viên: ");
        long idFresher = scanner.nextLong();
        for (Fresher fresher : fresherList){
            if (fresher.getIdEmployee() == idFresher){
                System.out.printf("%s %s %s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                        "Employee type", "Education","GraduationRank", "GraduationDate", "Date created", "Date updated");
                System.out.println("---------------------------------------------------");
                System.out.printf("%s %s %s %s %s %s %s %s %s %s %s\n",
                        fresher.getIdEmployee(), fresher.getFullName(),
                        fresher.getBrithDay(), fresher.getPhoneNumbers(), fresher.getEmail(), fresher.getEmployeeTypes(),
                        fresher.getEducation(), fresher.getGraduationRank(), fresher.getGraduationDate(),fresher.getAtCreated(), fresher.getAtUpdated());
                System.out.println("---------------------------------------------------");
                break;
            }
        }
    }
    public void removeFresherViews(){
        System.out.println(">Xóa nhân viên Fresher.");
        List<Fresher> fresherList = fresherServicers.fresherList();
        System.out.println("Nhập ID nhân viên: ");
    }
}
