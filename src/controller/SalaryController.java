package controller;

import model.Salary;
import service.salary_calculation.SalaryCalculationIMPL;

import java.util.List;


public class SalaryController {
    static SalaryCalculationIMPL salaryCalculationIMPL = new SalaryCalculationIMPL();

    public static int calculateSlSalary(String position, String workingType) {
        return salaryCalculationIMPL.calculateSalary(position, workingType);
    }

    public void createSalary(Salary salary){
        salaryCalculationIMPL.save(salary);
        salaryCalculationIMPL.findAll();
    }

    public List<Salary> showPayroll(){
       return salaryCalculationIMPL.findAll();
    }

}
