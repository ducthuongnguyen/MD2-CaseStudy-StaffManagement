package view;

import model.UserPrincipal;
import service.user_principal.UserPrincipalServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ProfileView {
    static UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();
    public ProfileView() {
        List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalsList;
        Set<String> roleSet = userPrincipalList.get(0).getRoleSet();
        List<String> roleList = new ArrayList<>(roleSet);
        boolean checkPermission = roleList.get(0).equals("MANAGER");
        System.out.println("Welcome User: " + userPrincipalList.get(0).getName());
        if (checkPermission) {
            new ManagerView();
        } else {
            new StaffView();
        }
    }

    public static void logOut() {
        UserPrincipalServiceIMPL.userPrincipalsList.clear();
        userPrincipalServiceIMPL.findAll();
    }
}
