package controller;

import dto.SignInDTO;
import dto.SignUpDTO;
import model.Role;
import model.RoleName;
import model.User;
import model.UserPrincipal;
import service.role.RoleServiceIMPL;
import service.user.UserServiceIMPL;
import service.user_principal.UserPrincipalServiceIMPL;

public class UserController {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
//    RoleServiceIMPL roleServiceIMPL = new RoleServiceIMPL();
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();

    public void register(SignUpDTO signUpDTO) {
        int id;
        if (UserServiceIMPL.userList.size() == 0) {
            id = 1;
        } else {
            id = UserServiceIMPL.userList.get(UserServiceIMPL.userList.size() - 1).getId() + 1;
        }
//        Set<String> strRole = signUpDTO.getStrRole();
//        Set<Role> roleSet = new HashSet<>();
//        strRole.forEach(role -> {
//            switch (role) {
//                case "staff":
//                    Role staffRole = roleServiceIMPL.findByName(RoleName.STAFF);
//                    roleSet.add(staffRole);
//                    break;
//                case "manager":
//                    Role managerRole = roleServiceIMPL.findByName(RoleName.MANAGER);
//                    roleSet.add(managerRole);
//                    break;
//            }
//        });
        User user = new User(id, signUpDTO.getDisplayName(), signUpDTO.getUserName(), signUpDTO.getPassword(), signUpDTO.getStrRole());
        userServiceIMPL.save(user);
        userServiceIMPL.findAll();
    }

    public boolean login(SignInDTO signInDTO) {
        if (userServiceIMPL.checkLogin(signInDTO.getUserName(), signInDTO.getPassword())) {
            User user = userServiceIMPL.findByUserName(signInDTO.getUserName());
            UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getDisplayName(), user.getUserName(), user.getPassword(), user.getRoleSet());
            userPrincipalServiceIMPL.save(userPrincipal);
            userPrincipalServiceIMPL.findAll();
            return true;
        } else {
            return false;
        }
    }

    public void deleteAccount(String userName) {
        userServiceIMPL.deleteByUserName(userName);
    }
}
