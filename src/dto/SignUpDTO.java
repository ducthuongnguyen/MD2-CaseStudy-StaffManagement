package dto;

import java.util.Set;

public class SignUpDTO {
    private String displayName;
    private String userName;
    private String password;
    private Set<String> strRole;

    public SignUpDTO() {
    }

    public SignUpDTO(String displayName, String userName, String password, Set<String> strRole) {
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.strRole = strRole;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getStrRole() {
        return strRole;
    }

    public void setStrRole(Set<String> strRole) {
        this.strRole = strRole;
    }
}
