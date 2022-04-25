package view;

import java.util.Scanner;

public class Main {
    public Main() {
        Scanner scanner = new Scanner(System.in);
        String choice_1;
        System.out.println("====================== MY NAVBAR =====================");
        System.out.println("1.REGISTER");
        System.out.println("2.LOGIN");
        System.out.println("3.SHOW LIST ROLE");
        System.out.println("Please choose menu: ");
        choice_1 = scanner.nextLine();

        switch (choice_1) {
            case "1":
                new RegisterView();
                break;
            case "2":
                new LoginView();
                break;
            case "3":
                new RoleView().showListRole();
                break;
            default:
                System.err.println("Please choose any option!");
                new Main();
        }
    }

    public static void main(String[] args) {
        new Main();
    }


}
