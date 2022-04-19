package model;

import java.io.Serializable;

public class Salary implements Serializable {
public static final int WORKING_HOURS_PARTTIME = 4;
public static final int WORKING_HOURS_FULLTIME = 8;
public static final int WAGE_PER_HOUR = 73000;
private static int workingDays;
private static Staff staff;
private static int salaryPerMonth;

    public Salary() {
    }

    public Salary(int workingDays, Staff staff, int salaryPerMonth) {
        this.workingDays = workingDays;
        this.staff = staff;
        this.salaryPerMonth = salaryPerMonth;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public static void setSalaryPerMonth() {

        if (staff.getWorkingType().equalsIgnoreCase("parttime")){
            salaryPerMonth = WAGE_PER_HOUR*WORKING_HOURS_PARTTIME*workingDays;
        }else if (staff.getWorkingType().equalsIgnoreCase("fulltime")){
            salaryPerMonth = WAGE_PER_HOUR*WORKING_HOURS_FULLTIME*workingDays;
        }
    }

    @Override
    public String toString() {
        return "Salary{" +
                "workingDays=" + workingDays +
                ", staff=" + staff +
                ", salaryPerMonth=" + salaryPerMonth +
                '}';
    }
}
