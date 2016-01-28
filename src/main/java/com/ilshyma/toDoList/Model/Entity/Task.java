package com.ilshyma.toDoList.Model.Entity;

import com.ilshyma.toDoList.Model.Entity.enums.Priority;
import com.ilshyma.toDoList.Model.Entity.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by star on 18.01.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "getAllTasks", query = "SELECT t FROM Task t order by t.dueDate"),
        @NamedQuery(name = "getTaskByUser", query = "SELECT t FROM Task t where t.userId = ?1 order by t.dueDate"),
        @NamedQuery(name = "getTaskByTitle", query = "SELECT t FROM Task t where upper(t.title) like ?1 order by t.dueDate")
})
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private long userId;

    @Column(length = 512)
    private String title;

    @Enumerated(value = EnumType.ORDINAL)
    private Priority priority;

    @Enumerated(value = EnumType.ORDINAL)
    private Status status;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public Task() {
        priority = Priority.LOW;
        status = Status.IN_PROGRESS;
    }

    public Task( String title, Status status, Priority priority, Date dueDate) {

        this.title = title;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task {");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", done=").append(status);
        sb.append(", priority=").append(priority);
        sb.append(", dueDate=").append(dueDate);
        sb.append('}');
        return sb.toString();
    }
}
