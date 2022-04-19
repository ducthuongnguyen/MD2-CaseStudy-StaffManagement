package service.staff;

import com.sun.xml.internal.txw2.output.DumpSerializer;
import config.ConfigReadAndWriteFile;
import model.Staff;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class StaffServiceIMPL implements IStaffService {
    public final static String PATH_STAFF = ConfigReadAndWriteFile.PATH + "staff.txt";
    public static List<Staff> staffList = new ConfigReadAndWriteFile<Staff>().readFromFile(PATH_STAFF);

    @Override
    public List<Staff> findAll() {
        new ConfigReadAndWriteFile<Staff>().writeToFile(PATH_STAFF, staffList);
        return staffList;
    }

    @Override
    public void save(Staff staff) {
        staffList.add(staff);
    }

    public void deleteById(int id) {
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                staffList.remove(i);
                System.out.println("Delete successful!");
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Not found!");
        }
    }

    @Override
    public void checkStatusByName(String name) {
        List<Staff> resultList = new ArrayList<>();
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (name.equalsIgnoreCase(staffList.get(i).getName())) {
                Staff staff = new Staff(name, staffList.get(i).isStatus());
                resultList.add(staff);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Not found!");
        }
        for (Staff staff : resultList) {
            System.out.println(staff.toStringStatus());
        }
    }

    @Override
    public void editStaff(int id, String newName, String newWorkingType) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                staffList.get(i).setName(newName);
                staffList.get(i).setWorkingType(newWorkingType);
            }
        }
    }

    @Override
    public List<Staff> findByName(String name) {
        List<Staff> resultList = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            if (name.equalsIgnoreCase(staffList.get(i).getName())) {
                resultList.add(staffList.get(i));
            }
        }
        return resultList;
    }

    @Override
    public void updateStatus(int id) {
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                staffList.get(i).setStatus(!staffList.get(i).isStatus());
                System.out.println("Update status for staff ID " + staffList.get(i).getId() + " successful!");
                check = true;
            }
        }
        if (!check) {
            System.err.println("Not found!");
        }
    }

    @Override
    public int calculateSalary(String workingType, int workingDays) {

        return 0;
    }

    @Override
    public List<Staff> filterByWorkingType(String workingType) {
        List<Staff> resultList = new ArrayList<>();
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (workingType.equalsIgnoreCase(staffList.get(i).getWorkingType())) {
                resultList.add(staffList.get(i));
                check = true;
            }
        }
        if (!check){
            System.err.println("Not found!");
        }
        return resultList;
    }

    @Override
    public List<Staff> filterByStatus(boolean status) {
        boolean check = false;
        List<Staff> resultList = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            if (status == staffList.get(i).isStatus()) {
                resultList.add(staffList.get(i));
                check = true;
            }
        }
        if (!check) {
            System.err.println("Not found!");
        }
        return resultList;
    }

    @Override
    public List<Staff> filterByWorkingPlace(String place) {
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (place.equalsIgnoreCase(staffList.get(i).getWorkingPlace())) {
                staffList.add(staffList.get(i));
                check = true;
            }
        }
        if (!check) {
            System.err.println("Not found!");
        }
        return staffList;
    }
}
