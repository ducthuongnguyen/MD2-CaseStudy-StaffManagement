package service.salary_calculation;

import model.Salary;
import model.Staff;
import service.IServiceGeneric;

public interface ISalaryCalculation extends IServiceGeneric<Salary> {
    int calculateSalary(String position, String workingType);

}