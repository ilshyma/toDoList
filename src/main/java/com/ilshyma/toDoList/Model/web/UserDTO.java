package com.ilshyma.toDoList.Model.web;

/**
 * Created by star on 07.02.2016.
 */
public class UserDTO {
    private String userName;
    private String password;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String userName) {
        this.userName = userName;
    }


    public UserDTO(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
