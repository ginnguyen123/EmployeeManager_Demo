package Controls;

import models.Employee;
import models.EmployeeType;
import utils.IOFileUtils;
import java.util.*;

public class EmployeeServices implements IEmployServices{
    private String pathEmployees = "ManageEmploee/datas/employees.csv";
    private static EmployeeServices instance;
    public EmployeeServices(){}
    public static EmployeeServices getInstance(){
        if (instance == null){
            instance = new EmployeeServices();
        }
        return instance;
    }
    @Override
    public List<Employee> employeesList() {
        //đọc file lên rồi trả về collection để xử lý
        List<Employee> employeesList = new ArrayList<>();
        //khởi tạo collection kiểu List
        List<String> linesEmployeesList = IOFileUtils.readFile(pathEmployees);
        //đọc file lên đặt vào collection kiểu List để xử lý dữ liệu đọc từ file về
        for (String employeeLine : linesEmployeesList){
            employeesList.add(Employee.parseEmployee(employeeLine));
        }
        return employeesList;
    }
    @Override
    public boolean isExistID(long idEmployee) {
        List<Employee> employeeList = employeesList();
        for (Employee employee : employeeList){
            if (employee.getIdEmployee()==idEmployee)
                return true;
        }
        return false;
    }
    @Override
    public Employee findEmployeeByID(long idEmployee) {
        List<Employee> employeeList = employeesList();
        for (Employee employee : employeeList){
            if (employee.getIdEmployee()==idEmployee)
                return employee;
        }
        return null;
    }
    @Override
    public void addEmployee(Employee employee) {
        List<Employee> employeeList = employeesList();
        employeeList.add(employee);
        IOFileUtils.writeFile(employeeList, pathEmployees);
    }
    @Override
    public void removeEmployee(long idEmployee) {
        List<Employee> employeeList = employeesList();
        for (Employee employee : employeeList){
            if (employee.getIdEmployee() == idEmployee){
                employeeList.remove(employee);
                break;
            }
        }
        IOFileUtils.writeFile(employeeList,pathEmployees);
    }
    @Override
    public void editEmployee(Employee employee) {
        List<Employee> employeeList = employeesList();
        for (Employee e : employeeList){
            if (e.getIdEmployee() == employee.getIdEmployee()){
                Date atUpdated = new Date();
                //tạo lại thời gian cập nhật thông tin
                String fullName = employee.getFullName();
                if (fullName != null && !fullName.isEmpty()){
                    e.setFullName(fullName);
                    e.setAtUpdated(atUpdated);
                }
                String birthDay = employee.getBrithDay();
                if (birthDay!=null&& !birthDay.isEmpty()){
                    e.setBrithDay(birthDay);
                    e.setAtUpdated(atUpdated);
                }
                String phoneNumber = employee.getPhoneNumbers();
                if (phoneNumber!=null && !phoneNumber.isEmpty()){
                    e.setPhoneNumbers(phoneNumber);
                    e.setAtUpdated(atUpdated);
                }
                String email = employee.getEmail();
                if (email!=null && !email.isEmpty()){
                    e.setEmail(email);
                    e.setAtUpdated(atUpdated);
                }
                EmployeeType employeeType = employee.getEmployeeTypes();
                if (employeeType.getType() < e.getEmployeeTypes().getType()){
                    e.setEmployeeTypes(employeeType);
                    e.setAtUpdated(atUpdated);
                }
                IOFileUtils.writeFile(employeeList,pathEmployees);
                break;
            }
        }
    }
    @Override
    public List<Employee> sortByNameAToZ() {
        List<Employee> employeeList = employeesList();
        Collections.sort(employeeList,new Comparator<Employee>(){
            @Override
            public int compare(Employee employee1, Employee employee2) {
                if (employee1.getFullName().compareTo(employee2.getFullName()) > 0)
                    return 1;
                else if (employee1.getFullName().compareTo(employee2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        IOFileUtils.writeFile(employeeList,pathEmployees);
        return employeeList;
    }
    @Override
    public List<Employee> sortByNameZToA() {
        List<Employee> employeeList = employeesList();
        Collections.sort(employeeList,new Comparator<Employee>(){
            @Override
            public int compare(Employee employee1, Employee employee2) {
                if (employee1.getFullName().compareTo(employee2.getFullName()) < 0)
                    return 1;
                else if (employee1.getFullName().compareTo(employee2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        return employeeList;
    }
}
