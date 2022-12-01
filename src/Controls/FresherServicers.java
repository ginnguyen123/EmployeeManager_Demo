package Controls;

import models.Employee;
import models.EmployeeType;
import models.Fresher;
import models.Intern;
import utils.IOFileUtils;

import java.util.*;

public class FresherServicers extends EmployeeServices implements IFresherServicers {
    private final String pathFresher = "ManageEmploee/datas/fresher.csv";
    private static FresherServicers instance;
    public FresherServicers(){}
    public static FresherServicers getInstance(){
        if (instance == null){
            instance = new FresherServicers();
        }
        return instance;
    }
    @Override
    public List<Fresher> fresherList() {
        List<Fresher> fresherList = new ArrayList<>();
        List<String> stringFresherList = IOFileUtils.readFile(pathFresher);
        for (String stringFresher : stringFresherList){
            fresherList.add(Fresher.parseFresher(stringFresher));
        }
        return fresherList;
    }

    @Override
    public Fresher findFresherByID(long idFresher) {
        List<Fresher> fresherList = fresherList();
        for (Fresher fresher : fresherList){
            if (fresher.getIdEmployee() == idFresher)
                return fresher;
        }
        return null;
    }

    @Override
    public void addFresher(Fresher fresher){
        List<Fresher> fresherList = fresherList();
        fresherList.add(fresher);
        Employee employee = new Employee(fresher.getIdEmployee(), fresher.getFullName(), fresher.getBrithDay(),
                fresher.getPhoneNumbers(), fresher.getEmail(), EmployeeType.FRESHER, fresher.getAtCreated(), fresher.getAtUpdated());
        super.addEmployee(employee);
        IOFileUtils.writeFile(fresherList,pathFresher);
    }

    @Override
    public void removeFresher(long idFresher) {
        List<Fresher> fresherList = fresherList();
        for (Fresher fresher : fresherList){
            if (fresher.getIdEmployee() == idFresher){
                fresherList.remove(fresher);
                super.removeEmployee(idFresher);
                break;
            }
        }
        IOFileUtils.writeFile(fresherList,pathFresher);
    }

    @Override
    public void editFresher(Fresher newFresher) {
        List<Fresher> fresherList = fresherList();
        Employee employeee = new Employee(newFresher.getIdEmployee(),newFresher.getFullName(),newFresher.getBrithDay(),
                newFresher.getPhoneNumbers(),newFresher.getEmail(),EmployeeType.EXPERIENCE,newFresher.getAtCreated(),newFresher.getAtUpdated());
        super.editEmployee(employeee);
        for (Fresher fresher : fresherList){
            if (fresher.getIdEmployee() == newFresher.getIdEmployee()){
                Date atUpdated = new Date();
//                (long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,EmployeeType employeeType,
//                        Date atCreated, Date atUpdate, String graduationDate, String graduationRank, String education)
                String fullName = newFresher.getFullName();
                if (fullName!=null && !fullName.isEmpty()){
                    fresher.setFullName(fullName);
                    fresher.setAtUpdated(atUpdated);
                }
                String brithDay = newFresher.getBrithDay();
                if (brithDay!=null && !brithDay.isEmpty()){
                    fresher.setBrithDay(brithDay);
                    fresher.setAtUpdated(atUpdated);
                }
                String phoneNumbers = newFresher.getPhoneNumbers();
                if (phoneNumbers!=null && !phoneNumbers.isEmpty()){
                    fresher.setPhoneNumbers(phoneNumbers);
                    fresher.setAtUpdated(atUpdated);
                }
                String email = newFresher.getEmail();
                if (email!=null && !email.isEmpty()){
                    fresher.setEmail(email);
                    fresher.setAtUpdated(atUpdated);
                }
                String graduationDate = newFresher.getGraduationDate();
                if (graduationDate!=null && !graduationDate.isEmpty()){
                    fresher.setGraduationDate(graduationDate);
                    fresher.setAtUpdated(atUpdated);
                }
                String graduationRank = newFresher.getGraduationRank();
                if (graduationRank!=null && !graduationRank.isEmpty()){
                    fresher.setGraduationRank(graduationRank);
                    fresher.setAtUpdated(atUpdated);
                }
                String education = newFresher.getEducation();
                if (education!=null && !education.isEmpty()){
                    fresher.setEducation(graduationRank);
                    fresher.setAtUpdated(atUpdated);
                }
                IOFileUtils.writeFile(fresherList,pathFresher);
                break;
            }
        }
    }

    @Override
    public List<Fresher> sortFresherByNameAToZ() {
        List<Fresher> fresherList = fresherList();
        Collections.sort(fresherList, new Comparator<Fresher>() {
            @Override
            public int compare(Fresher fresher1, Fresher fresher2) {
                if (fresher1.getFullName().compareTo(fresher2.getFullName()) > 0)
                    return 1;
                else if (fresher1.getFullName().compareTo(fresher2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        IOFileUtils.writeFile(fresherList, pathFresher);
        return fresherList;
    }

    @Override
    public List<Fresher> sortFresherByNameZToA() {
        List<Fresher> fresherList = fresherList();
        Collections.sort(fresherList, new Comparator<Fresher>() {
            @Override
            public int compare(Fresher fresher1, Fresher fresher2) {
                if (fresher1.getFullName().compareTo(fresher2.getFullName()) < 0)
                    return 1;
                else if (fresher1.getFullName().compareTo(fresher2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        return fresherList;
    }
}
