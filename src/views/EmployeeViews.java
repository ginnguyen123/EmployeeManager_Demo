package views;

import Controls.EmployeeServices;
import Controls.*;
import models.Employee;
import models.EmployeeType;
import models.Experience;
import models.Fresher;
import utils.DateUtils;
import utils.IOFileUtils;
import utils.ValidateUtils;

import java.sql.Struct;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeViews {
    public Scanner scanner = new Scanner(System.in);
    private final EmployeeServices employeeServices;
    private final ExperienceServices experienceServices;
    private final FresherServicers fresherServicers;
    private final InternServicers internServicers;
    public EmployeeViews(){
        this.employeeServices = EmployeeServices.getInstance();
        this.experienceServices = ExperienceServices.getInstance();
        this.fresherServicers = FresherServicers.getInstance();
        this.internServicers = InternServicers.getInstance();
    }
//    (long idEmployee, String fullName, String brithDay, String phoneNumbers,
//    String email,EmployeeType employeeType, Date atCreated, Date atUpdated)

    public EmployeeType inputEmployeeType(){
        boolean flag = true;
        do {
            EmployeeType employeeType;
            System.out.println(">Kiểu nhân viên");
            System.out.println("1. Experience.");
            System.out.println("2. Fresher.");
            System.out.println("3. Intern.");
            System.out.println("0. Quay lại.");
            System.out.print(">Chọn kiểu nhân viên: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    return employeeType = EmployeeType.getEmplyeeType(choice);
                case 2:
                    return employeeType = EmployeeType.getEmplyeeType(choice);
                case 3:
                    return employeeType = EmployeeType.getEmplyeeType(choice);
                case 0:
                    menuEmployee();
                    break;
                default:
                    System.out.println(">Chọn sai chức năng. Kiểm tra lại.");
                    flag = true;
                    break;
            }
        }while (flag);
        return null;
    }
    public void menuEmployee(){
        boolean flag = false;
        int choice;
        System.out.print("\t\t\tQUẢN LÝ THÔNG TIN NHÂN VIÊN");
        System.out.print("\n\t1.Hiển thị danh sách nhân viên.");
        System.out.print("\n\t2.Sắp thêm danh sách theo tên từ A -> Z.");
        System.out.print("\n\t3.Sắp thêm danh sách theo tên từ Z -> A.");
        System.out.print("\n\t4.Thêm thông tin nhân viên."); // phân quyền nhân viên EX,FR,INTER
        System.out.print("\n\t5.Sửa thông tin nhân viên."); // phân quyền nhân viên EX,FR,INTER
        System.out.print("\n\t6.Xóa thông tin nhân viên."); //Hỏi YES NO
        System.out.print("\n\t7.Tìm thông tin nhân viên.");
//        TK chức năng ADMIN cần có chức năng nâng cấp phân quyền nhân viên theo ID
//        nhân viên phân quyền theo cấp bậc: INTERN > Fresher > EX
        System.out.print("\n\t0.Thoát chương trình.");
        System.out.print("\n>Chọn chức năng: ");
        choice = scanner.nextInt();
        do {
            switch (choice){
                case 1:
                    showEmployeesViews();
                    break;
                case 2:
                    sortByNameAToZViews();
                    break;
                case 3:
                    sortByNameZToAViews();
                    break;
                case 4:
                    inputEmployeeType();
                    break;
                case 5:
                    editEmployeeViews();
                    break;
                case 6:
                    removeEmployeeViews();
                    break;
                case 7:
                    findEmployeeByIDViews();
                    break;
                case 0:
                    System.exit(5);
                    break;
                default:
                    System.out.println("Nhập sai chức năng! Kiểm tra lại!");
//                flag = true;
                    break;
            }
        }while (flag);
    }
    public void showEmployeesViews(){
        List<Employee> list = employeeServices.employeesList(); // lấy danh sách đọc lên từ file
        //idEmployee, String fullName, String brithDay, String phoneNumbers,
        //                    String email,EmployeeType employeeType, Date atCreated, Date atUpdated)
        System.out.printf("%s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                "Employee type" , "Date created", "Date updated");
        System.out.println("---------------------------------------------------");
        for (Employee employee : employeeServices.employeesList()){
            System.out.printf("%s %s %s %s %s %s %s %s\n",
                    employee.getIdEmployee(),employee.getBrithDay(),
                    employee.getFullName(),employee.getPhoneNumbers(),employee.getEmail(),employee.getEmployeeTypes(),
                    employee.getAtCreated(), employee.getAtUpdated());
            System.out.println("---------------------------------------------------");
        }
    }
    public void sortByNameAToZViews(){
        System.out.printf("%s %s %s %s %s %s\n","ID Employee","Birthday","Full name","Phone numbers","Email","Date created");
        System.out.println("---------------------------------------------------");
        for (Employee employee : employeeServices.sortByNameAToZ()){
            System.out.printf("%s %s %s %s %s %s\n",
                    employee.getIdEmployee(),employee.getBrithDay(),
                    employee.getFullName(),employee.getPhoneNumbers(),
                    employee.getEmail(), employee.getAtCreated());
            System.out.println("---------------------------------------------------");
        }
    }
    public void sortByNameZToAViews(){
        System.out.printf("%s %s %s %s %s %s\n","ID Employee","Birthday","Full name","Phone numbers","Email", "Date created");
        System.out.println("---------------------------------------------------");
        for (Employee employee : employeeServices.sortByNameZToA()){
            System.out.printf("%s %s %s %s %s %s\n",
                    employee.getIdEmployee(),employee.getBrithDay(),
                    employee.getFullName(),employee.getPhoneNumbers(),
                    employee.getEmail(), employee.getAtCreated());
            System.out.println("---------------------------------------------------");
        }
    }
    public void addEmployeeViews() {
        System.out.println(">Thêm thông tin nhân viên.");
        List<Employee> list = employeeServices.employeesList();
        long idEmployee = System.currentTimeMillis()%100000000;
        System.out.println("Nhập họ và tên nhân viên.");
        String fullName = scanner.nextLine();
        System.out.print("\nNhập ngày tháng năm sinh (dd-mm-yyyy, ví dụ: 12-05-2022).");
        String birthday = scanner.nextLine();
        System.out.print("\nNhập số điện thoại ((84 hoặc 0)987654321).");
        String phoneNumber = scanner.nextLine();
        System.out.print("\nNhập Email nhân viên");
        String email = scanner.nextLine();
        EmployeeType employeeType = inputEmployeeType();
        Date atCreated = new Date();
        Date atUpdated = new Date();
        //long idEmployee, String fullName, String brithDay, String phoneNumbers,
        // String email,EmployeeType employeeType, Date atCreated, Date atUpdated)
//        Employee employee = new Employee(idEmployee, fullNameTrue, birthdayTrue,
//                phoneNumberTrue, emailTrue, employeeType,atCreated,atUpdated);
//        employeeServices.addEmployee(employee);

    }
    public void editEmployeeViews(){
       long id;
        System.out.println(">Sửa thông tin nhân viên.");
       do {
           System.out.print("Nhập ID nhân viên: ");
           id = Long.parseLong(scanner.nextLine());
           if (employeeServices.isExistID(id)){
               System.out.println("\t\t\tSỬA THÔNG TIN NHÂN VIÊN.");
               System.out.println("\t1.Sửa họ và tên.");
               System.out.println("\t2.Sửa ngày tháng năm sinh.");
               System.out.println("\t3.Sửa số điện thoại.");
               System.out.println("\t4.Sửa thông tin email.");
               System.out.println("\t5.Sửa kiểu nhân viên.");
               System.out.println("\t6.Quay lại.");
               System.out.println("\t0.Thoát chương trình.");
               System.out.print("\t>Chọn chức năng: ");
               int choice = Integer.parseInt(scanner.nextLine());
               Employee employee = new Employee();
               employee.setIdEmployee(id);
               boolean checkChoice = false;
               do {
                   switch (choice){
                       case 1:
                           System.out.print("Nhập họ và tên mới: ");
                           String newFullName = scanner.nextLine();
                           employee.setFullName(newFullName);
                           break;
                       case 2:
                           System.out.print("Nhập ngày tháng năm sinh mới: ");
                           String newBirthday = scanner.nextLine();
                           employee.setBrithDay(newBirthday);
                           break;
                       case 3:
                           System.out.print("Nhập số điện thoại mới: ");
                           String newPhoneNumber = scanner.nextLine();
                           employee.setPhoneNumbers(newPhoneNumber);
                           break;
                       case 4:
                           System.out.println("Nhập Email mới:");
                           String newEmail = scanner.nextLine();
                           employee.setEmail(newEmail);
                           break;
                       case 5:
                           EmployeeType employeeType = inputEmployeeType();
                           employee.setEmployeeTypes(employeeType);
                           break;
                       case 6:
                           checkChoice = false;
                           menuEmployee();
                           break;
                       case 0:
                           System.exit(5);
                           break;
                   }
                   employeeServices.editEmployee(employee);
               }while (checkChoice);

           } else
               System.out.println("ID không tồn tại! Hãy kiểm tra lại ID nhân viên.");
       }while (!employeeServices.isExistID(id));

    }
    public void removeEmployeeViews() {
        long id;
        boolean checkID = false;
        System.out.println(">Xóa thông tin nhân viên.");
        do {
            System.out.print("Nhập ID nhân viên: ");
            id = Long.parseLong(scanner.nextLine());
            if (employeeServices.isExistID(id)) {
                boolean flag = false;
//                employeeServices.removeEmployee(employeeServices.findEmployeeByID(id));
                do {
                    Employee employeeShow = employeeServices.findEmployeeByID(id);
                    System.out.printf("%s %s %s %s %s %s %s\n", "ID Employee", "Birthday", "Full name",
                            "Phone numbers", "Email", "Date created", "Date updated");
                    System.out.println("---------------------------------------------------");
                    System.out.printf("%s %s %s %s %s %s %s\n",
                            employeeShow.getIdEmployee(), employeeShow.getFullName(),
                            employeeShow.getBrithDay(), employeeShow.getPhoneNumbers(),
                            employeeShow.getEmail(), employeeShow.getAtCreated(),employeeShow.getAtUpdated());
                    System.out.println("---------------------------------------------------");
                    System.out.printf(">Bạn muốn xóa thông tin nhân viên có ID: %d", id);
                    System.out.println("\n1. Đồng ý.");
                    System.out.println("2. Quay lại.");
                    System.out.print(">Chọn chức năng: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            employeeServices.removeEmployee(id);
                            System.out.println("Đã xóa thông tin nhân viên thành công!");
                            flag = false;
                            break;
                        case 2:
                            menuEmployee();
                            break;
                        default:
                            System.out.println("Nhập sai chức năng! Kiểm tra lại!");
                            flag = true;
                            break;
                    }
                } while (flag);
            }else{
                System.out.println(">ID không tồn tại. Kiểm tra lại");
                boolean checkIDNotExist = false;
                do {
                    System.out.println("1. Tiếp tục.");
                    System.out.println("2. Quay lại.");
                    System.out.print(">Chọn chức năng: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            checkID = true;
                            break;
                        case 2:
                            menuEmployee();
                            break;
                        default:
                            System.out.println("Nhập sai chức năng! Kiểm tra lại!");
                            checkIDNotExist = true;
                            break;
                    }
                }while (checkIDNotExist);
        }
    }while (checkID);
    }
    public void findEmployeeByIDViews(){
        boolean checkID = false;
        long id;
        System.out.println(">Tìm thông tin nhân viên.");
        do {
            System.out.println("Nhập ID nhân viên: ");
            id = Long.parseLong(scanner.nextLine());
            if (employeeServices.isExistID(id)){
                Employee employee = employeeServices.findEmployeeByID(id);
                System.out.printf("%s %s %s %s %s %s\n","ID Employee","Birthday","Full name","Phone numbers","Email", "Date created");
                System.out.println("---------------------------------------------------");
                System.out.printf("%s %s %s %s %s %s\n",
                        employee.getIdEmployee(),employee.getFullName(),
                        employee.getBrithDay(),employee.getPhoneNumbers(),
                        employee.getEmail(),employee.getAtCreated());
                System.out.println("---------------------------------------------------");
            }else {
                System.out.println("ID không tồn tại. Kiểm tra lại");
                //nên hiển thị quay lại menu hoặc thoát chương trình
                checkID = true;
            }
        }while (checkID);
    }
}
