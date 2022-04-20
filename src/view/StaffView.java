package view;

import controller.StaffController;

import java.util.Scanner;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    StaffController staffController = new StaffController();
    public StaffView(){
        System.out.println("==================== MENU FOR STAFF ====================");
        System.out.println("Please choose any options: ");
        System.out.println("1.SEARCH STAFF'S INFORMATION");
        System.out.println("2.LOG OUT");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                search();
                break;
            case 2:
                ProfileView.logOut();
                new Main();
        }

    }

    public void backMenuForStaff(){
        System.out.println("Enter quit comeback to MENU");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new StaffView();
        }
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
                backMenuForStaff();
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
                backMenuForStaff();
                break;
            case 3:
                System.out.println("Enter staff's working status you want to filter(true - working/false - retired): ");
                boolean status = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println(staffController.filterByStatus(status));
                backMenuForStaff();
                break;
            case 4:
                System.out.println("Enter staff's working place you want to filter: ");
                String place = scanner.nextLine();
                System.out.println(staffController.filterByWorkingPlace(place));
                System.out.println("Enter quit comeback to MENU");
                backMenuForStaff();
                break;
        }
    }

}
