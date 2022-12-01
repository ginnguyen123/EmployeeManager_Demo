package Controls;

import models.Employee;

import java.util.List;

public interface IEmployServices {
    List<Employee> employeesList();
    boolean isExistID(long idEmployee);
    Employee findEmployeeByID(long idEmployee);
    void addEmployee(Employee employee);
    void editEmployee(Employee employee);
    void removeEmployee(long idEmployee);
    List<Employee> sortByNameAToZ();
    List<Employee> sortByNameZToA();
}
