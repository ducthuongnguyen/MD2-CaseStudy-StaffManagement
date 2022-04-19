package service.staff;

import model.Staff;
import service.IServiceGeneric;

import java.util.List;

public interface IStaffService extends IServiceGeneric<Staff> {
    void checkStatusByName(String name);
    void editStaff(int id, String newName, String newWorkingType);
    List<Staff> findByName(String name);
    void updateStatus(int id);
    int calculateSalary(String workingType, int workingDays);
    List<Staff> filterByWorkingType(String workingType);
    List<Staff> filterByStatus(boolean status);
    List<Staff> filterByWorkingPlace(String place);
}
