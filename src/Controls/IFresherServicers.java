package Controls;

import models.Fresher;
import models.Intern;

import java.util.List;

public interface IFresherServicers {
    List<Fresher> fresherList();
    boolean isExistID(long idFresher);
    Fresher findFresherByID(long idFresher);
    void addFresher(Fresher fresher);
    void removeFresher(long idFresher);
    void editFresher(Fresher Fresher);
    List<Fresher> sortFresherByNameAToZ();
    List<Fresher> sortFresherByNameZToA();
}
