package com.ilshyma.toDoList.Model.web;

import com.ilshyma.toDoList.Model.Entity.User;
import com.ilshyma.toDoList.Model.Entity.enums.Priority;
import com.ilshyma.toDoList.Model.Entity.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by user on 23.01.2016.
 */
public class TaskDTO{

    private User userId;
    private String title;
    private Status status;
    private Priority priority;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;
    private int countHours;
    private String dueDate1;

    public String getDueDate1() {
        return dueDate1;
    }

    public void setDueDate1(String dueDate1) {
        this.dueDate1 = dueDate1;
    }





    public int getCountHours() {
        return countHours;
    }

    public void setCountHours(int countHours) {
        this.countHours = countHours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
