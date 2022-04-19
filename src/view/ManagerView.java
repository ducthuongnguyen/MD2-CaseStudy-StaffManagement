package view;

import controller.StaffController;
import model.Staff;
import service.staff.StaffServiceIMPL;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagerView {
    Scanner scanner = new Scanner(System.in);
    List<Staff> staffList = StaffServiceIMPL.staffList;
    StaffController staffController = new StaffController();

    public ManagerView() {
        System.out.println("==================== MENU FOR MANAGER ====================");
        System.out.println("1.CREATE STAFF");
        System.out.println("2.SEARCH INFORMATION OF STAFF");
        System.out.println("3.CHECK STATUS OF STAFF");
        System.out.println("4.EDIT STAFF");
        System.out.println("5.UPDATE STATUS");
        System.out.println("6.DELETE STAFF");
        System.out.println("7.SHOW LIST OF STAFF");
        System.out.println("8.SHOW SALARY");
        System.out.println("9.DELETE LOGIN ACCOUNT");
        System.out.println("10. LOG OUT");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                formCreateStaff();
                break;
            case 2:
                search();
                break;
            case 3:
                checkStatus();
                break;
            case 4:
                editStaff();
                break;
            case 5:
                changeStatus();
                break;
            case 6:
                deleteStaff();
                break;
            case 7:
                showListStaff();
                break;
            case 8:
                break;
            case 10:
                ProfileView.logOut();
                new Main();
        }

    }

    private void backMenu() {
        System.out.println("Enter quit comeback to MENU");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ManagerView();
        }
    }

    public void formCreateStaff() {
        while (true) {
            int id;
            if (staffList.size() == 0) {
                id = 1;
            } else {
                id = staffList.get(staffList.size() - 1).getId() + 1;
            }

            System.out.println("Enter of staff's name, blanks are not allowed: ");
            String name;
            boolean checkName;
            while (true) {
                name = scanner.nextLine();
                checkName = Pattern.matches("(.|\\s)*\\S(.|\\s)*", name);
                if (!checkName) {
                    System.err.println("The name failed! Please enter again!");
                } else {
                    break;
                }
            }

            System.out.println("Enter staff's gender (M/F), blanks are not allowed: ");
            String gender;
            while (true) {
                gender = scanner.nextLine();
                boolean checkGender;
                checkGender = Pattern.matches("M|F", gender);
                if (!checkGender) {
                    System.err.println("The gender failed! Please enter again!");
                } else {
                    break;
                }
            }

//            System.out.println("Enter staff's status (true - working or false - retired): ");
//            boolean status;
//            status = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Enter staff's type of working (PT represent Part-time or FT represents Full-time: ");
            String workingType;
            String typeOfWorking;
            while (true) {
                workingType = scanner.nextLine();
                boolean checkWorkingType;
                checkWorkingType = Pattern.matches("PT|FT", workingType);
                if (!checkWorkingType) {
                    System.err.println("The working type failed! Please enter again!");
                } else {
                    if (workingType.equalsIgnoreCase("PT")) {
                        typeOfWorking = "Part-time";
                    } else {
                        typeOfWorking = "Full-time";
                    }
                    break;
                }
            }

            System.out.println("Enter staff's working place, press Enter to skip: ");
            String workingPlace = scanner.nextLine();

            System.out.println("Enter staff's position, press Enter to skip: ");
            String position = scanner.nextLine();

            System.out.println("Enter staff's department, press Enter to skip: ");
            String department = scanner.nextLine();
            System.out.println("Create staff successful!");

            Staff staff = new Staff(id, name, gender, true, typeOfWorking, workingPlace, position, department);
            staffController.createStaff(staff);
            backMenu();
        }
    }


    public void showListStaff() {
        System.out.println(staffController.showListStaff());
        backMenu();
    }

    public void checkStatus() {
        System.out.println("Enter the staff's name to check status: ");
        String name = scanner.nextLine();
        staffController.checkStatusByName(name);
        backMenu();
    }

    public void deleteStaff() {
        System.out.println("Enter the staff's ID you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.deleteStaff(id);
        backMenu();
    }

    public void editStaff() {
        System.out.println("Enter the staff's ID you want to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new working type (PT/FT): ");
        String newWorkingType = scanner.nextLine();
        String typeOfWorking = null;
        if (newWorkingType.equalsIgnoreCase("pt") || newWorkingType.equalsIgnoreCase("ft")) {
            System.out.println("Edit successful!");
            if (newWorkingType.equalsIgnoreCase("PT")) {
                typeOfWorking = "Part-time";
            } else {
                typeOfWorking = "Full-time";
            }
        } else {
            System.err.println("The working type failed! Please try again!");
        }
        staffController.editStaff(id, newName, typeOfWorking);
        backMenu();
    }

    public void changeStatus() {
        System.out.println("Enter the staff's ID you want to update status: ");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.updateStatus(id);
        backMenu();
    }

    public void search() {
        System.out.println("==================== SEARCH BY ====================");
        System.out.println("1.STAFF'S NAME");
        System.out.println("2.WORKING TYPE");
        System.out.println("3.STATUS");
        System.out.println("4.PLACE OF WORKING");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Enter staff's name you want to filter: ");
                String name = scanner.nextLine();
                System.out.println(staffController.filterByName(name));
                System.out.println(name);
                backMenu();
                break;
            case 2:
                System.out.println("Enter staff's working type you want to filter (PT/FT): ");
                String workingType = scanner.nextLine();
                String typeToSearch = null;
                if (workingType.equalsIgnoreCase("pt")) {
                    typeToSearch = "Part-time";
                } else if (workingType.equalsIgnoreCase("ft")) {
                    typeToSearch = "Full-time";
                } else {
                    System.err.println("Invalid!");
                    new ManagerView();
                }
                System.out.println(staffController.filterByWorkingType(typeToSearch));
                backMenu();
                break;
            case 3:
                System.out.println("Enter staff's working status you want to filter(true - working/false - retired): ");
                boolean status = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println(staffController.filterByStatus(status));
               backMenu();
                break;
            case 4:
                System.out.println("Enter staff's working place you want to filter: ");
                String place = scanner.nextLine();
                System.out.println(staffController.filterByWorkingPlace(place));
                System.out.println("Enter quit comeback to MENU");
                backMenu();
                break;
        }
    }
}

