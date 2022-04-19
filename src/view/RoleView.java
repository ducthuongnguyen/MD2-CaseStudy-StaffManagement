package view;

import controller.RoleController;

import java.util.Scanner;

public class RoleView {
    public void showListRole(){
        Scanner scanner = new Scanner(System.in);
        RoleController roleController = new RoleController();
        System.out.println(roleController.showListRole());
        System.out.println("Enter quit back to Menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
}
