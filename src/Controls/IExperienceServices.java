package Controls;

import models.Employee;
import models.Experience;

import java.util.List;

public interface IExperienceServices {
    List<Experience> experienceList();
    boolean isExistExperienceID(long idExperience);
    Experience findExperienceByID(long idExperience);
    void addExperience(Experience experience);
    void editExperience(Experience experience);
    void removeExperience(long idExperience);
    List<Experience> sortExperienceByNameAToZ();
    List<Experience> sortExperienceByNameZToA();
}
