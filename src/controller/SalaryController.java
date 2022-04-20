package controller;

import model.Salary;
import service.salary_calculation.SalaryCalculationIMPL;
import view.ManagerView;

import java.util.List;
import java.util.Scanner;

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


    public void backMenuForManager() {
        System.out.println("Enter quit comeback to MENU");
        Scanner scanner = new Scanner(System.in);
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ManagerView();
        }
    }
}
