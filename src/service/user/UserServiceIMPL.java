package service.user;

import config.ConfigReadAndWriteFile;
import model.Staff;
import model.User;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    public final static String PATH_USER = ConfigReadAndWriteFile.PATH + "user.txt";
    public static List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(PATH_USER);

    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_USER, userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }


    public void deleteById(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (id == userList.get(i).getId()) {
                userList.remove(i);
            }
        }
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
