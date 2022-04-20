package model;

import java.io.Serializable;

public class Salary implements Serializable {
    public static final int WORKING_HOURS_PARTTIME = 4;
    public static final int WORKING_HOURS_FULLTIME = 8;
    public static final int WAGE_PER_HOUR_JUNIOR = 38000;
    public static final int WAGE_PER_HOUR_SENIOR = 58000;
    public static final int WAGE_PER_HOUR_MANAGER = 140000;
    public static int DEFAULT_WORKING_DAYS = 26;
    private int workingDays;
    private int salaryPerMonth;
    private int id;
    private String name;
    private String workingType;
    private String position;

    public Salary() {
    }

    public Salary(int workingDays, int salaryPerMonth) {
        this.workingDays = workingDays;
        this.salaryPerMonth = salaryPerMonth;
    }

    public Salary(int id, String name, String workingType, String position, int defaultWorkingDays, int calculateSlSalary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.workingType = workingType;
        this.salaryPerMonth = calculateSlSalary;
        this.workingDays = defaultWorkingDays;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(int salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public String toString() {
        return "Salary{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", workingType='" + workingType + '\'' +
                ", position='" + position + '\'' +
                ", workingDays=" + workingDays +
                ", salaryPerMonth=" + salaryPerMonth +
                "}\n";
    }
}
