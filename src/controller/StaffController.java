package controller;

import model.Staff;
import service.staff.StaffServiceIMPL;

import java.util.List;

public class StaffController {
    StaffServiceIMPL staffServiceIMPL = new StaffServiceIMPL();

    public void createStaff(Staff staff) {
        staffServiceIMPL.save(staff);
        staffServiceIMPL.findAll();
    }

    public List<Staff> showListStaff() {
        return staffServiceIMPL.findAll();
    }

    public void checkStatusByName(String name) {
        staffServiceIMPL.checkStatusByName(name);
    }


    public void deleteStaff(int id) {
        staffServiceIMPL.deleteById(id);
    }

    public void editStaff(int id, String newName, String newWorkingType){
        staffServiceIMPL.editStaff(id,newName,newWorkingType);
    }

    public void updateStatus(int id){
        staffServiceIMPL.updateStatus(id);
    }


    public List<Staff> filterByName(String name){
        return staffServiceIMPL.findByName(name);
    }

    public List<Staff> filterByWorkingPlace(String place){
        return staffServiceIMPL.filterByWorkingPlace(place);
    }

    public List<Staff> filterByStatus(boolean status){
       return staffServiceIMPL.filterByStatus(status);
    }

    public List<Staff> filterByWorkingType(String workingType){
        return staffServiceIMPL.filterByWorkingType(workingType);
    }
}

