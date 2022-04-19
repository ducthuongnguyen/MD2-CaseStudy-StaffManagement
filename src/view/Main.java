package view;

import java.util.Scanner;

public class Main {
    public Main() {
        Scanner scanner = new Scanner(System.in);
        int choice_1;
        System.out.println("====================== MY NAVBAR =====================");
        System.out.println("1.REGISTER");
        System.out.println("2.LOGIN");
        System.out.println("3.SHOW LIST ROLE");
            System.out.println("Please choose menu: ");
            choice_1 = scanner.nextInt();
            scanner.nextLine();
            switch (choice_1) {
                case 1:
                    new RegisterView();
                    break;
                case 2:
                    new LoginView();
                    break;
                case 3:
                    new RoleView().showListRole();
                    break;
            }



//        menuForManager();
//        System.out.println("Choose any option: ");
//        int choice_2 = scanner.nextInt();
//        switch (choice_2) {
//            case 1:
//                new StaffView().formCreateStaff();
//                break;
//            case 2:
//                new StaffView().search();
//                break;
//            case 3:
//                new StaffView().checkStatus();
//                break;
//            case 4:
//                new StaffView().editStaff();
//                break;
//            case 5:
//                new StaffView().changeStatus();
//                break;
//            case 6:
//                new StaffView().deleteStaff();
//                break;
//            case 7:
//                new StaffView().showListStaff();
//                break;
//        }
    }



    public static void main(String[] args) {
        new Main();
    }




}
