package views;

import utils.ValidateUtils;

import java.util.Scanner;

public class CheckInputViews {
    public Scanner scanner = new Scanner(System.in);
    public String inputFullNameCheck(String fullName){
        boolean flag = true;
        String newFullName;
        if (ValidateUtils.isFullNameValidate(fullName)){
            return fullName;
        }else{
            System.out.println("Nhập sai! Kiểm tra lại!");
            int choice;
            do {
                System.out.println("1. Nhập lại.");
                System.out.println("2. Quay lại.");
//                    System.out.println("0. Thoát chương trình.");
                System.out.print(">Chọn chức năng: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập lại họ tên nhân viên.");
                        newFullName =  scanner.nextLine();
                        if (ValidateUtils.isFullNameValidate(newFullName))
                            return newFullName;
                        else {
                            System.out.println("Nhập sai! Kiểm tra lại!");
                            flag = true;
                        }
                        break;
                    case 2:
                        menuEmployee();
                        break;
//                        case 3:
//                            System.exit(5);
//                            flag = false;
//                            break;
                    default:
                        System.out.println("Chọn sai chức năng. Kiểm tra lại.");
                        flag = true;
                }
            }while (flag);
        }
        return null;
    }
    public String inputPhoneNumeberCheck(String phoneNumber){
        boolean flag = true;
        String newPhoneNumber;
        if (ValidateUtils.isPhoneNumberValidate(phoneNumber)){
            return phoneNumber;
        }else{
            System.out.println("Nhập sai! Kiểm tra lại!");
            int choice;
            do {
                System.out.println("1. Nhập lại.");
                System.out.println("2. Quay lại.");
//                    System.out.println("0. Thoát chương trình.");
                System.out.print(">Chọn chức năng: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập lại số điện thoại.");
                        newPhoneNumber =  scanner.nextLine();
                        if (ValidateUtils.isPhoneNumberValidate(newPhoneNumber))
                            return newPhoneNumber;
                        else {
                            System.out.println("Nhập sai! Kiểm tra lại!");
                            flag = true;
                        }
                        break;
                    case 2:
                        menuEmployee();
                        break;
//                        case 3:
//                            System.exit(5);
//                            flag = false;
//                            break;
                    default:
                        System.out.println("Chọn sai chức năng. Kiểm tra lại.");
                        flag = true;
                }
            }while (flag);

        }
        return null;
    }
    public String inputBirthdayCheck(String birthday){
        boolean flag = true;
        String newBirthday;
        if (ValidateUtils.isBirthDay(birthday)){
            return birthday;
        }else{
            System.out.println("Nhập sai! Kiểm tra lại!");
            int choice;
            do {
                System.out.println("1. Nhập lại.");
                System.out.println("2. Quay lại.");
//                    System.out.println("0. Thoát chương trình.");
                System.out.print(">Chọn chức năng: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập lại ngày tháng năm sinh.");
                        newBirthday =  scanner.nextLine();
                        if (ValidateUtils.isBirthDay(newBirthday))
                            return newBirthday;
                        else {
                            System.out.println("Nhập sai! Kiểm tra lại!");
                            flag = true;
                        }
                        break;
                    case 2:
                        menuEmployee();
                        break;
//                        case 3:
//                            System.exit(5);
//                            flag = false;
//                            break;
                    default:
                        System.out.println("Chọn sai chức năng. Kiểm tra lại.");
                        flag = true;
                }
            }while (flag);

        }
        return null;
    }
    public String inputEmailCheck(String email){
        boolean flag = true;
        String newEmail;
        if (ValidateUtils.isEmail(email)){
            return email;
        }else{
            System.out.println("Nhập sai! Kiểm tra lại!");
            int choice;
            do {
                System.out.println("1. Nhập lại.");
                System.out.println("2. Quay lại.");
//                    System.out.println("0. Thoát chương trình.");
                System.out.print(">Chọn chức năng: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập lại Email.");
                        newEmail =  scanner.nextLine();
                        if (ValidateUtils.isEmail(newEmail))
                            return newEmail;
                        else {
                            System.out.println("Nhập sai! Kiểm tra lại!");
                            flag = true;
                        }
                        break;
                    case 2:
                        menuEmployee();
                        break;
//                        case 3:
//                            System.exit(5);
//                            flag = false;
//                            break;
                    default:
                        System.out.println("Chọn sai chức năng. Kiểm tra lại.");
                        flag = true;
                }
            }while (flag);

        }
        return null;
    }
}
