package com.epam.tc.gdi.hw1.site.entities;

public class User  {

    private String name;
    private String password;
    private String fullName;

    public User(String username, String fullName, String password) {
        this.name = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
