package com.twu.biblioteca.model;

public class User {
    private String userId;
    private String userName;
    private String password;
    private Role role;
    private String email;
    private String phone;

    public User(String userId, String userName, String password, Role role, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(String userId, String userName, String password, Role role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return userId + "  ||  " + userName + "  ||  " + email + "  ||  " + phone;
    }
}
