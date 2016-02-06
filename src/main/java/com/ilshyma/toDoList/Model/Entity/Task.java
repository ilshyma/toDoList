package com.ilshyma.toDoList.Model.Entity;

import com.ilshyma.toDoList.Model.Entity.enums.Priority;
import com.ilshyma.toDoList.Model.Entity.enums.Status;
import com.ilshyma.toDoList.Model.Entity.User;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by star on 18.01.2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllTasks", query = "SELECT t FROM Task t order by t.dueDate"),
        @NamedQuery(name = "getTaskByUser", query = "SELECT t FROM Task t where t.user = :user order by t.dueDate"),
        @NamedQuery(name = "getTaskByTitle", query = "SELECT t FROM Task t where upper(t.title) like ?1 order by t.dueDate")
})
public class Task implements Serializable {

    public static final String TASKALL = "getAllTasks";
    public static final String TASKBYUSER = "getTaskByUser";
    public static final String TASKBYTITLE = "getTaskByTitle";


    @Id
    @GeneratedValue
    private long id;

    @Column(length = 100)
    private String title;

    @Enumerated(value = EnumType.ORDINAL)
    private Priority priority;

    @Enumerated(value = EnumType.ORDINAL)
    private Status status;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @ManyToOne
    private User user;


    public Task() {
        priority = Priority.LOW;
        status = Status.IN_PROGRESS;    }

    public Task( String title, Status status, Priority priority, Date dueDate, User user) {

        this.title = title;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }
    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Task setStatus( Status status ) {
        this.status = status;
        return this;

    }

    public Priority getPriority() {
        return priority;
    }
    public Task setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }
    public Task setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }
    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user; return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task {");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", done=").append(status);
        sb.append(", priority=").append(priority);
        sb.append(", dueDate=").append(dueDate);
        sb.append('}');
        return sb.toString();
    }


}
