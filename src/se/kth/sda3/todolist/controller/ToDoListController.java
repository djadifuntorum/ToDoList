/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import se.kth.sda3.todolist.model.Status;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.AddTask;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ToDoListController {

    private ArrayList<Task> tasks;
    private AddTask addTask;

    public ToDoListController() {

        tasks = new ArrayList<>();
        addTask = new AddTask();
        addTask.showDisplay(tasks);
        try {
            String inputDate = "07/03/2018";
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tasks.add(new Task("Read chapter 1", "JavaLecture", dateFormat.parse(inputDate) ,Status.WORKING));
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }


        System.out.println(tasks.get(0).getName());
        System.out.println(tasks.get(0).getProject());
        System.out.println(tasks.get(0).getDueDate());
        System.out.println(tasks.get(0).getStatus());

    }





}
