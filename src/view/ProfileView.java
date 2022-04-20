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
//    Scanner scanner = new Scanner(System.in);
    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalsList;
    static UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();
    Set<String> roleSet =userPrincipalList.get(0).getRoleSet();
    List<String> roleList =new ArrayList<>(roleSet);
boolean checkPermission = roleList.get(0).equals("MANAGER");
    public ProfileView() {
//        if (userPrincipalList.size() != 0) {
            System.out.println("Welcome Profile: " + userPrincipalList.get(0).getName());
            if (checkPermission){
                new ManagerView();
            }else {
                new StaffView();
            }
//        } else {
//            System.out.println("Please Login!");
//        }
//        String backMenu = scanner.nextLine();
//        if (backMenu.equalsIgnoreCase("quit")){
//            new Main();
//        }
    }

    public static void logOut() {
        UserPrincipalServiceIMPL.userPrincipalsList.clear();
        userPrincipalServiceIMPL.findAll();
    }
}
