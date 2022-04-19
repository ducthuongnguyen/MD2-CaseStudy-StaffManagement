package view;

import java.util.Scanner;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    public StaffView(){
        System.out.println("==================== MENU FOR STAFF ====================");
        System.out.println("1.SEARCH STAFF'S INFORMATION");
        System.out.println("2.LOG OUT");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                new ManagerView().search();
                break;
            case 2:
                ProfileView.logOut();
                new Main();
        }
    }

}
