package Controls;

import models.Employee;
import models.EmployeeType;
import models.Experience;
import utils.IOFileUtils;

import javax.swing.*;
import java.util.*;

public class ExperienceServices extends  EmployeeServices implements IExperienceServices {
    //sử dụng extends  EmployeeServices để sử dụng super lớp cha, ghi song song vào file employee.csv
    private final String pathExperience = "ManageEmploee/datas/experience.csv";
    private static ExperienceServices instance;
    public ExperienceServices(){}
    public static ExperienceServices getInstance(){
        if (instance == null){
            instance = new ExperienceServices();
        }
        return instance;
    }
    public List<Experience> experienceList() {
        List<Experience> experienceList = new ArrayList<>();
        List<String> lineExperienceList = IOFileUtils.readFile(pathExperience);
        for (String lineExperience : lineExperienceList){
            experienceList.add(Experience.parseExperience(lineExperience));
        }
        return experienceList;
    }
    public  boolean isExistExperienceID(long idExperience){
        List<Experience> experienceList = experienceList();
        for (Experience experience : experienceList){
            if (experience.getIdEmployee() == idExperience)
                return true;
        }
        return false;
    }

    public Experience findExperienceByID(long idExperience) {
        List<Experience> experienceList = experienceList();
        for (Experience experience : experienceList){
            if (experience.getIdEmployee() == idExperience){
                return experience;
            }
        }
        return null;
    }
    public void addExperience(Experience experience) {
        List<Experience> experienceList = experienceList();
        Employee employee = new Employee(experience.getIdEmployee(),experience.getFullName(),experience.getBrithDay(),
                experience.getPhoneNumbers(),experience.getEmail(),experience.getEmployeeTypes(),experience.getAtCreated(),experience.getAtUpdated());
        super.addEmployee(employee);
        experienceList.add(experience);
        IOFileUtils.writeFile(experienceList,pathExperience);
//
    }

    public void editExperience(Experience newExperience) {
        List<Experience> experienceList = experienceList();
        Employee employeee = new Employee(newExperience.getIdEmployee(),newExperience.getFullName(),newExperience.getBrithDay(),
                newExperience.getPhoneNumbers(),newExperience.getEmail(),EmployeeType.EXPERIENCE,newExperience.getAtCreated(),newExperience.getAtUpdated());
        super.editEmployee(employeee);
        for (Experience experience : experienceList){
            if (experience.getIdEmployee() == newExperience.getIdEmployee()){
                Date atUpdated = new Date();
                String fullName = newExperience.getFullName();
                if (fullName != null && !fullName.isEmpty()){
                    experience.setFullName(fullName);
                    experience.setAtUpdated(atUpdated);
                }
                String birthDay = newExperience.getBrithDay();
                if (birthDay!=null&& !birthDay.isEmpty()){
                    experience.setBrithDay(birthDay);
                    experience.setAtUpdated(atUpdated);
                }
                String phoneNumber = newExperience.getPhoneNumbers();
                if (phoneNumber!=null && !phoneNumber.isEmpty()){
                    experience.setPhoneNumbers(phoneNumber);
                    experience.setAtUpdated(atUpdated);
                }
                String email = newExperience.getEmail();
                if (email!=null && !email.isEmpty()){
                    experience.setEmail(email);
                    experience.setAtUpdated(atUpdated);
                }
                float exYears = newExperience.getExYears();
                if (exYears != 0 && exYears < 0 && exYears > experience.getExYears()){
                    experience.setExYears(exYears);
                    experience.setAtUpdated(atUpdated);
                }
                String skills = newExperience.getSkills();
                if (skills != null && !skills.isEmpty()){
                    experience.setSkills(skills);
                    experience.setAtUpdated(atUpdated);
                }
                IOFileUtils.writeFile(experienceList,pathExperience);
                break;
            }
        }
    }
    public void removeExperience(long idExperience) {
        List<Experience> experienceList = experienceList();
        for (Experience experience : experienceList){
            if (experience.getIdEmployee() == idExperience){
                experienceList.remove(experience);
                super.removeEmployee(idExperience);
                break;
            }
        }
        IOFileUtils.writeFile(experienceList,pathExperience);
    }
    public List<Experience> sortExperienceByNameAToZ() {
        List<Experience> experienceList = experienceList();
        Collections.sort(experienceList,new Comparator<Experience>(){
            @Override
            public int compare(Experience experience1, Experience experience2) {
                if (experience1.getFullName().compareTo(experience2.getFullName()) > 0)
                    return 1;
                else if (experience1.getFullName().compareTo(experience2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        IOFileUtils.writeFile(experienceList,pathExperience);
        return experienceList;
    }
    public List<Experience> sortExperienceByNameZToA() {
        List<Experience> experienceList = experienceList();
        Collections.sort(experienceList,new Comparator<Experience>(){
            @Override
            public int compare(Experience experience1, Experience experience2) {
                if (experience1.getFullName().compareTo(experience2.getFullName()) < 0)
                    return 1;
                else if (experience1.getFullName().compareTo(experience2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        return experienceList;
    }

}
