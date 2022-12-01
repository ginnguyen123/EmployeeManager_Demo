package views;

import Controls.EmployeeServices;
import Controls.ExperienceServices;
import models.Employee;
import models.EmployeeType;
import models.Experience;
import utils.IOFileUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExperienceViews extends EmployeeViews {
    private ExperienceServices experienceServices;
    private EmployeeServices employeeServices;
    public ExperienceViews(){
        this.experienceServices = ExperienceServices.getInstance();
        this.employeeServices = EmployeeServices.getInstance();
    }
    public static Scanner scanner = new Scanner(System.in);
    public void menuExperience(){
        System.out.print("\t\t\tQUẢN LÝ THÔNG TIN NHÂN VIÊN");
        System.out.println("\t>Lv: Experience");
        System.out.println("\t1.Hiển thị danh sách nhân viên .");
        System.out.println("\t2.Sắp thêm danh sách theo tên từ A -> Z.");
        System.out.println("\t3.Sắp thêm danh sách theo tên từ Z -> A.");
        System.out.println("\t4.Thêm thông tin nhân viên.");
        System.out.println("\t5.Sửa thông tin nhân viên.");
        System.out.println("\t6.Xóa thông tin nhân viên.");
        System.out.println("\t7.Tìm thông tin nhân viên.");
        System.out.println("\t0.Thoát chương trình.");
        System.out.print("\n>Chọn chức năng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                showExperienceViews();
                break;
            case 2:
                sortByNameAToZExperienceViews();
                break;
            case 3:
                sortByNameZToAExperienceViews();
                break;
            case 4:
                addExperienceViews();
                break;
            case 5:
                //editExperienceViews();
                break;
            case 6:
                removeExperienceViews();
                break;
            case 7:
                findExperienceViews();
                break;
            case 0:
                break;
            default:
                break;

        }
    }
    public void showExperienceViews() {
        List<Experience> experienceList = experienceServices.experienceList();
        System.out.printf("%s %s %s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                "Employee type", "Ex.Years","Skills", "Date created", "Date updated");
        System.out.println("---------------------------------------------------");
        for (Experience experience : experienceList){
            System.out.printf("%s %s %s %s %s %s %f %s %s %s\n",
                    experience.getIdEmployee(),experience.getBrithDay(),
                    experience.getFullName(),experience.getPhoneNumbers(),experience.getEmail(),experience.getEmployeeTypes(),
                     experience.getExYears(), experience.getSkills(),experience.getAtCreated(), experience.getAtUpdated());
            System.out.println("---------------------------------------------------");
        }
    }
    public void sortByNameAToZExperienceViews(){
        System.out.println(">Sắp xếp danh sách theo họ tên đầy đủ (A -> Z): ");
        List<Experience> experienceList = experienceServices.sortExperienceByNameAToZ();
        System.out.printf("%s %s %s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                "Employee type" , "Date created", "Date updated", "Ex.Years","Skills");
        System.out.println("---------------------------------------------------");
        for (Experience experience : experienceList){
            System.out.printf("%s %s %s %s %s %s %s %s %f %s\n",
                    experience.getIdEmployee(),experience.getBrithDay(),
                    experience.getFullName(),experience.getPhoneNumbers(),experience.getEmail(),experience.getEmployeeTypes(),
                    experience.getAtCreated(), experience.getAtUpdated(), experience.getExYears(), experience.getSkills());
            System.out.println("---------------------------------------------------");
        }
    }
    public void sortByNameZToAExperienceViews(){
        System.out.println(">Sắp xếp danh sách theo họ tên đầy đủ (Z -> A): ");
        List<Experience> experienceList = experienceServices.sortExperienceByNameZToA();
        System.out.printf("%s %s %s %s %s %s %s %s %s %s\n","ID Employee","Full name","Birthday","Phone numbers","Email",
                "Employee type" , "Date created", "Date updated", "Ex.Years","Skills");
        System.out.println("---------------------------------------------------");
        for (Experience experience : experienceList){
            System.out.printf("%s %s %s %s %s %s %s %s %f %s\n",
                    experience.getIdEmployee(),experience.getBrithDay(),
                    experience.getFullName(),experience.getPhoneNumbers(),experience.getEmail(),experience.getEmployeeTypes(),
                    experience.getAtCreated(), experience.getAtUpdated(), experience.getExYears(), experience.getSkills());
            System.out.println("---------------------------------------------------");
        }
    }
    public void addExperienceViews() {
        System.out.println(">Thêm thông tin nhân viên Experience.");
        long idExperience = System.currentTimeMillis()%100000000;
        //Experience(long idEmployee, String fullName, String brithDay, String phoneNumbers,
        //                      String email, EmployeeType employeeType, float exYears, String skills,
        //                      Date atCreated, Date atUpdate)
        System.out.println("Nhập họ và tên nhân viên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập ngày tháng năm sinh (dd-mm-yyyy, ví dụ: 12-05-2022): ");
        String birthday = scanner.nextLine();
        System.out.print("Nhập số điện thoại ((84 hoặc 0)987654321): ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập Email nhân viên: ");
        String email = scanner.nextLine();
        float exYears = Float.parseFloat(scanner.nextLine());
        String skills = scanner.nextLine();
        Date atCreated = new Date();
        Date atUpdate = new Date();
        Experience experience = new Experience(idExperience, fullName, birthday, phoneNumber, email,
                EmployeeType.EXPERIENCE, exYears,skills, atCreated, atUpdate);
        experienceServices.addExperience(experience);
    }
    public void findExperienceViews() {
//        boolean checkID = false;
        System.out.print(">Nhập ID nhân viên: ");
        long idExperience = Long.parseLong(scanner.nextLine());
        List<Experience> experienceList = experienceServices.experienceList();
        for (Experience experience : experienceList) {
            if (experience.getIdEmployee() == idExperience) {
                System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "ID Employee", "Full name", "Birthday", "Phone numbers", "Email",
                        "Employee type", "Date created", "Date updated", "Ex.Years", "Skills");
                System.out.println("---------------------------------------------------");
                System.out.printf("%s %s %s %s %s %s %s %s %f %s\n",
                        experience.getIdEmployee(), experience.getBrithDay(),
                        experience.getFullName(), experience.getPhoneNumbers(), experience.getEmail(), experience.getEmployeeTypes(),
                        experience.getAtCreated(), experience.getAtUpdated(), experience.getExYears(), experience.getSkills());
                System.out.println("---------------------------------------------------");
                break;
            }
        }
    }
    public void removeExperienceViews() {
        System.out.println(">Xóa thông tin nhân viên Experience.");
        System.out.print(">Nhập ID nhân viên: ");
        long idExperience = Long.parseLong(scanner.nextLine());
        List<Experience> experienceList = experienceServices.experienceList();
        for (Experience experience : experienceList) {
            if (experience.getIdEmployee() == idExperience) {
                System.out.printf("%s %s %s %s %s %s %s %s %s %s\n", "ID Employee", "Full name", "Birthday", "Phone numbers", "Email",
                        "Employee type", "Date created", "Date updated", "Ex.Years", "Skills");
                System.out.println("---------------------------------------------------");
                System.out.printf("%s %s %s %s %s %s %s %s %f %s\n",
                        experience.getIdEmployee(), experience.getBrithDay(),
                        experience.getFullName(), experience.getPhoneNumbers(), experience.getEmail(), experience.getEmployeeTypes(),
                        experience.getAtCreated(), experience.getAtUpdated(), experience.getExYears(), experience.getSkills());
                System.out.println("---------------------------------------------------");
                System.out.printf("Bạn muốn xóa thông tin nhân viên mã ID %d\n", idExperience);
                System.out.println("1. Đồng ý.");
                System.out.println("2. Quay lại.");
                boolean checkChoice = false;
                do {
                    System.out.print(">Chọn chức năng: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            experienceServices.removeExperience(idExperience);
                            System.out.println("Đã xóa thành công!");
                            break;
                        case 2:
                            menuExperience();
                            break;
                        default:
                            System.out.println("Chọn sai chức năng! Kiểm tra lại!");
                            checkChoice = true;
                    }
                }while (checkChoice);
            }
        }
    }
}
