package view;

import controller.UserController;
import dto.SignUpDTO;
import model.User;
import service.user.UserServiceIMPL;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class RegisterView {
    UserController userController = new UserController();
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
     public RegisterView() {
         System.out.println(UserServiceIMPL.userList);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your display name, no blank: ");
        String displayName;
        boolean checkDisplayName;
        while (true) {
            displayName = scanner.nextLine();
            checkDisplayName = Pattern.matches("(.|\\s)*\\S(.|\\s)*", displayName);
            if (!checkDisplayName) {
                System.err.println("The display name failed! Please enter again!");
            } else {
                break;
            }
        }
        System.out.println("Enter your username which is required to lowercase letters or numbers, at least 6 characters, no whitespace: ");
        String userName;
        boolean checkUserName;
        while (true) {
            userName = scanner.nextLine();
            checkUserName = Pattern.matches("[a-z0-9_-]{6,}", userName);
            if (!checkUserName) {
                System.err.println("Username failed! Please try again!");
            } else if (userServiceIMPL.existedByUserName(userName)) {
                System.err.println("Username is existed! Please try again!");
            } else {
                break;
            }
        }
        System.out.println("Enter your password which is required at least 8 characters, contain at least one digit, one lowercase & uppercase letter, one special character and no whitespace:");
        String password;
        boolean checkPassword;
        while (true) {
            password = scanner.nextLine();
            checkPassword = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*=])(?=\\S+$).{8,}$", password);
            if (!checkPassword) {
                System.err.println("Password failed! Please try again!");
            } else {
                break;
            }
        }
        System.out.println("Enter your role (staff/manager): ");
        String role;
        boolean checkRole;
        Set<String> strRole = new HashSet<>();
        while (true) {
            role = scanner.nextLine();
            checkRole = Pattern.matches("staff|manager", role.toLowerCase(Locale.ROOT));
            if (!checkRole) {
                System.err.println("The role is not valid! Please try again!");
            } else {
                strRole.add(role.toUpperCase());
                System.out.println("Registered successful!");
                break;
            }
        }
        SignUpDTO signUpDTO = new SignUpDTO(displayName, userName, password, strRole);
        userController.register(signUpDTO);
        System.out.println("Enter quit back to Menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }

    }
}
