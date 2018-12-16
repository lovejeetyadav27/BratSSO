package com.brat.sso.model;

import java.util.List;

public class DBUser {
    private String name;
    private String userName;
    private String password;
    private List<String> roles;

    public DBUser(String name, String userName, String password, List<String> roles) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
