package com.ilshyma.toDoList.Model.web;

import com.ilshyma.toDoList.Model.Priority;

import java.util.Date;

/**
 * Created by user on 23.01.2016.
 */
public class TaskDTO{

    private long userId;
    private String title;
    private boolean done;
    private Priority priority;
    private Date dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }







}
