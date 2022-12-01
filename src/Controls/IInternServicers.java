package Controls;

import models.Employee;
import models.EmployeeType;
import models.Intern;
import utils.IOFileUtils;

import java.util.*;

public interface IInternServicers {
    List<Intern> internList();
    boolean isExistID(long idIntern);
    Intern findInternByID(long idIntern);
    void addIntern(Intern intern);
    void removeIntern(long idIntern);
    void editIntern(Intern intern);
    List<Intern> sortInternByNameAToZ();
    List<Intern> sortInternByNameZToA();
}
