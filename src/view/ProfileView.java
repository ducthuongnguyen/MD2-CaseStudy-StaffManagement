package view;

import model.Role;
import model.RoleName;
import model.User;
import model.UserPrincipal;
import service.user_principal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ProfileView {
    Scanner scanner = new Scanner(System.in);
    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalsList;
    static UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();
    Set<String> roleSet =userPrincipalList.get(0).getRoleSet();
    List<String> roleList =new ArrayList<>(roleSet);
boolean checkPermission = (roleList.get(0).toUpperCase()).equals(RoleName.MANAGER);
    public ProfileView() {
        if (userPrincipalList.size() != 0) {
            System.out.println("Welcome Profile: " + userPrincipalList.get(0).getName());
            System.out.println("Please choose any options: ");
            System.out.println(roleList.get(0));
            System.out.println(RoleName.MANAGER);
            System.out.println(checkPermission);
            if (!checkPermission){
                new ManagerView();
            }else {
                new StaffView();
            }
        } else {
            System.out.println("Please Login!");
        }
        System.out.println("2. Back Menu");
        int chooseProfile = scanner.nextInt();
        switch (chooseProfile) {
            case 1:
                logOut();
                new Main();
            case 2:
                new Main();
        }
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }

    public static void logOut() {
        UserPrincipalServiceIMPL.userPrincipalsList.clear();
        userPrincipalServiceIMPL.findAll();
    }
}
