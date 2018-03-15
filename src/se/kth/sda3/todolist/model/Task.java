/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.model;

import java.util.Date;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class Task {

    private String name;
    private String project;
    private Date dueDate;
    private Status status;

    public Task(String name, String project, Date dueDate, Status status) {
        this.name = name;
        this.project = project;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
