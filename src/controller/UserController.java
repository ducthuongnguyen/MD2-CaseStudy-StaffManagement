package controller;

import dto.SignInDTO;
import dto.SignUpDTO;
import model.User;
import model.UserPrincipal;
import service.user.UserServiceIMPL;
import service.user_principal.UserPrincipalServiceIMPL;

public class UserController {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
    UserPrincipalServiceIMPL userPrincipalServiceIMPL = new UserPrincipalServiceIMPL();

    public void register(SignUpDTO signUpDTO) {
        int id;
        if (UserServiceIMPL.userList.size() == 0) {
            id = 1;
        } else {
            id = UserServiceIMPL.userList.get(UserServiceIMPL.userList.size() - 1).getId() + 1;
        }
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
