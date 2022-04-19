package service.user_principal;

import config.ConfigReadAndWriteFile;
import model.UserPrincipal;

import java.util.List;

public class UserPrincipalServiceIMPL implements IUserPrincipalService {
    public static String PATH_USER_PRINCIPAL = ConfigReadAndWriteFile.PATH + "user_principal.txt";
    public static List<UserPrincipal> userPrincipalsList = new ConfigReadAndWriteFile<UserPrincipal>().readFromFile(PATH_USER_PRINCIPAL);

    @Override
    public List<UserPrincipal> findAll() {
        new ConfigReadAndWriteFile<UserPrincipal>().writeToFile(PATH_USER_PRINCIPAL, userPrincipalsList);
        return userPrincipalsList;
    }


    @Override
    public void save(UserPrincipal userPrincipal) {
        userPrincipalsList.clear();
        userPrincipalsList.add(userPrincipal);
    }
}
