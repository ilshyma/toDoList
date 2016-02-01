package com.ilshyma.toDoList.Model.Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "USER")
@NamedQueries({
        @NamedQuery(name = User.FIND_BY_USERNAME, query = "select a from User a where a.userName = :userName")
})
public class User implements java.io.Serializable {

    public static final String FIND_BY_USERNAME = "User.findByUserName";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userName;
    private String password;
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Task> tasks;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }


    public User(String userName, String password, String role) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}