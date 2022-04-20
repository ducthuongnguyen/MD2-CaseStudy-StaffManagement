package dto;

import model.Salary;

public class SalaryDTO {
    int id;
    String staffName;
    String position;
    Salary salary;

    public SalaryDTO() {
    }

    public SalaryDTO(int id, String staffName, Salary salary) {
        this.id = id;
        this.staffName = staffName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
