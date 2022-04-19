package model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String name;
    private String gender;
    private boolean status;
    private String workingType;
    private Salary salary;
    private String workingPlace;
    private String position;
    private String department;


    public Staff() {
    }


    public Staff(int id, String name, String gender, boolean status, String workingType, Salary salary, String workingPlace, String position, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.workingType = workingType;
        this.salary = salary;
        this.workingPlace = workingPlace;
        this.position = position;
        this.department = department;
    }

    public Staff(int id, String name, String gender, boolean status, String workingPlace, String position, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.workingPlace = workingPlace;
        this.position = position;
        this.department = department;
    }

    public Staff(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public Staff(int id, String name, String gender, boolean status, String workingType, String workingPlace, String position, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.workingPlace = workingPlace;
        this.workingType = workingType;
        this.position = position;
        this.department = department;
    }

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
        Salary.setSalaryPerMonth();
    }

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        if (isStatus()){
            return "Staff{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", status= Working" +
                    ", salary=" + salary +
                    ", working type=" + workingType +
                    ", workingPlace='" + workingPlace + '\'' +
                    ", position='" + position + '\'' +
                    ", department='" + department + '\'' +
                    "}\n";
        }else {
            return "Staff{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", status= Retired"  +
                    ", salary=" + salary +
                    ", working type=" + workingType +
                    ", workingPlace='" + workingPlace + '\'' +
                    ", position='" + position + '\'' +
                    ", department='" + department + '\'' +
                    "} \n";
        }

    }

    public String toStringStatus() {
        if (isStatus()){
            return "Staff{" +
                    " name='" + name + '\'' +
                    ", status= Working" +
                    "}\n";
        }else {
            return "Staff{" +
                    " name='" + name + '\'' +
                    ", status= Retired" +
                    "}\n";
        }

    }
}
