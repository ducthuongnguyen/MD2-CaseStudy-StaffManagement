package service.user;

import config.ConfigReadAndWriteFile;
import model.Staff;
import model.User;
import model.UserPrincipal;
import service.user_principal.UserPrincipalServiceIMPL;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    public final static String PATH_USER = ConfigReadAndWriteFile.PATH + "user.txt";
    public static List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(PATH_USER);
    List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalsList;

    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_USER, userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public void deleteByUserName(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            if (userPrincipalList.get(0).getUsername().equals(userName)) {
                System.err.println("This user is active. It cannot be deleted!");
                break;
            } else {
                if (userName.equals(userList.get(i).getUserName())) {
                    userList.remove(i);
                    System.out.println("Deleted username " + userName + " successful.");
                    break;
                }
            }
            if (!existedByUserName(userName)) {
                System.err.println("User is not exit!");
            }
        }
        findAll();
    }

    @Override
    public boolean existedByUserName(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUserName(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {
                return userList.get(i);
            }
        }
        return null;
    }
}
