package Controls;

import models.Employee;
import models.EmployeeType;
import models.Intern;
import utils.IOFileUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InternServicers extends EmployeeServices implements IInternServicers {
    private final String pathIntern = "ManageEmploee/datas/intern.csv";
    private static InternServicers instance;
    public InternServicers(){}
    public static InternServicers getInstance(){
        if (instance == null){
            instance = new InternServicers();
        }
        return instance;
    }
    @Override
    public List<Intern> internList() {
        List<Intern> internList = new ArrayList<>();
        List<String> stringsInternList = IOFileUtils.readFile(pathIntern);
        for (String stringsIntern : stringsInternList){
            internList.add(Intern.parseIntern(stringsIntern));
        }
        return internList;
    }

    @Override
    public Intern findInternByID(long idEmployee) {
        List<Intern> internList = internList();
        for (Intern intern : internList){
            if (intern.getIdEmployee() == idEmployee){
                return intern;
            }
        }
        return null;
    }

    @Override
    public void addIntern(Intern newIntern) {
        List<Intern> internList = internList();
        Employee employee = new Employee(newIntern.getIdEmployee(), newIntern.getFullName(), newIntern.getBrithDay(),
                newIntern.getPhoneNumbers(), newIntern.getEmail(), EmployeeType.INTERN, newIntern.getAtCreated(), newIntern.getAtUpdated());
        super.editEmployee(employee);
        for (Intern intern : internList){
            if (intern.getIdEmployee() == newIntern.getIdEmployee()){
                Date atUpdated = new Date();
//                (long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,EmployeeType employeeType,
//                        Date atCreated , Date atUpdate, String majors, String semester, String universityName)
                String fullName = newIntern.getFullName();
                if (fullName!=null && !fullName.isEmpty()){
                    intern.setFullName(fullName);
                    intern.setAtUpdated(atUpdated);
                }
                String brithDay = newIntern.getBrithDay();
                if (brithDay!=null && !brithDay.isEmpty()){
                    intern.setBrithDay(brithDay);
                    intern.setAtUpdated(atUpdated);
                }
                String phoneNumbers = newIntern.getPhoneNumbers();
                if (phoneNumbers!=null && !phoneNumbers.isEmpty()){
                    intern.setPhoneNumbers(phoneNumbers);
                    intern.setAtUpdated(atUpdated);
                }
                String email = newIntern.getEmail();
                if (email!=null && !email.isEmpty()){
                    intern.setEmail(email);
                    intern.setAtUpdated(atUpdated);
                }
                String majors = newIntern.getMajors();
                if (majors!=null && !majors.isEmpty()){
                    intern.setMajors(majors);
                    intern.setAtUpdated(atUpdated);
                }
                String semester = newIntern.getMajors();
                if (semester!=null && !semester.isEmpty()){
                    intern.setSemester(semester);
                    intern.setAtUpdated(atUpdated);
                }
                String universityName = newIntern.getUniversityName();
                if (universityName!=null && !universityName.isEmpty()){
                    intern.setUniversityName(universityName);
                    intern.setAtUpdated(atUpdated);
                }
                IOFileUtils.writeFile(internList,pathIntern);
                break;
            }
        }

    }

    @Override
    public void removeIntern(long idIntern) {
        List<Intern> internList = internList();
        for (Intern intern : internList){
            if (intern.getIdEmployee() == idIntern){
                super.removeEmployee(idIntern);
                internList.remove(intern);
                break;
            }
        }
        IOFileUtils.writeFile(internList, pathIntern);
    }

    @Override
    public void editIntern(Intern Intern) {

    }
    @Override
    public List<Intern> sortInternByNameAToZ() {
        return null;
    }

    @Override
    public List<Intern> sortInternByNameZToA() {
        return null;
    }
}
