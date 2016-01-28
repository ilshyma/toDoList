package com.ilshyma.toDoList.Model.Entity;

import com.ilshyma.toDoList.Model.Entity.enums.UserRole;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 16.01.2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "getUserByLogin", query = "SELECT u FROM User u where u.login = :p_login"),
        @NamedQuery(name = "getUserByLoginAndPassword", query = "SELECT u FROM User u where u.login = :p_login and u.password = :p_password")
})
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    private String password;

    private UserRole userRole;

    public User() {
    }

    public User(String login, String password, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;

    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login; return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public User setUserRole(UserRole userRole) {
        this.userRole = userRole; return  this;
    }

    @Override
    public String toString() {
        return "User[" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ']';
    }
}

