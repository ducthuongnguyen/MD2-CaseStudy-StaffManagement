package model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    private int id;
    private String displayName;
    private String userName;
    private String password;
    private String email;
    private String avatar;
    private Set<String> roleSet;

    public User() {
    }

    public User(int id, String displayName, String userName, String password, String email, String avatar, Set<String> roleSet) {
        this.id = id;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.roleSet = roleSet;
    }

    public User(int id, String displayName, String userName, String password, Set<String> roleSet) {
        this.id = id;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.roleSet = roleSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<String> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<String> roleSet) {
        this.roleSet = roleSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleSet=" + roleSet +
                "}\n";
    }
}
