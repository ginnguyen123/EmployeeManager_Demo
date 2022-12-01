import Controls.EmployeeServices;
import Controls.ExperienceServices;
import models.*;
import utils.DateUtils;
import views.EmployeeViews;
import views.ExperienceViews;
import views.FresherViews;
import views.InternViews;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int i = Integer.parseInt(scanner.nextLine());
//        if (EmployeeType.getEmplyeeType(i).equals(EmployeeType.EXPERIENCE)){
//            System.out.println("EXPERIENCE");
//        }
//        if (EmployeeType.getEmplyeeType(i).equals(EmployeeType.FRESHER)){
//            System.out.println("FRESHER");
//        }
//        if (EmployeeType.getEmplyeeType(i).equals(EmployeeType.INTERN)){
//            System.out.println("INTERN");
//        }
//        Date date = new Date();
//        System.out.println(DateUtils.dateToString(date));
//        Instant instant = Instant.now();
//        System.out.println(DateUtils.instantToString(instant));
//        Experience experience = new Experience();
//        experience.showInfo();
        ExperienceViews experienceViews = new ExperienceViews();
        experienceViews.addExperienceViews();

        FresherViews fresherViews = new FresherViews();



    }
}