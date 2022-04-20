package service.salary_calculation;

import config.ConfigReadAndWriteFile;
import controller.SalaryController;
import model.Salary;
import model.Staff;
import service.staff.StaffServiceIMPL;

import java.util.List;

public class SalaryCalculationIMPL implements ISalaryCalculation {
    public final static String PATH_SALARY = ConfigReadAndWriteFile.PATH + "salary.txt";
    public static List<Salary> salaryList = new ConfigReadAndWriteFile<Salary>().readFromFile(PATH_SALARY);
    List<Staff> staffList = StaffServiceIMPL.staffList;
//    SalaryController salaryController = new SalaryController();

    @Override
    public List<Salary> findAll() {

        return salaryList;
    }

    @Override
    public void save(Salary salary) {
        salaryList.add(salary);
        new ConfigReadAndWriteFile<Salary>().writeToFile(PATH_SALARY, salaryList);
    }


    @Override
    public int calculateSalary(String position, String workingType) {
        int baseSalary;
        if (position.equals("Junior")) {
            if (workingType.equalsIgnoreCase("parttime")) {
                baseSalary = Salary.WORKING_HOURS_PARTTIME * Salary.WAGE_PER_HOUR_JUNIOR * Salary.DEFAULT_WORKING_DAYS;
            } else {
                baseSalary = Salary.WAGE_PER_HOUR_JUNIOR * Salary.WORKING_HOURS_FULLTIME * Salary.DEFAULT_WORKING_DAYS;
            }
        } else if (position.equals("Senior")) {
            baseSalary = Salary.WAGE_PER_HOUR_SENIOR * Salary.WORKING_HOURS_FULLTIME * Salary.DEFAULT_WORKING_DAYS;
        } else {
            baseSalary = Salary.WAGE_PER_HOUR_MANAGER * Salary.WORKING_HOURS_FULLTIME * Salary.DEFAULT_WORKING_DAYS;
        }
        return baseSalary;
    }

}
