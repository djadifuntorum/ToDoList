/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.controller;

import java.util.ArrayList;

import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.AddTaskView;
import se.kth.sda3.todolist.view.HomePageView;
import se.kth.sda3.todolist.view.ShowTaskView;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ToDoListController {

    private ArrayList<Task> tasks;
    private AddTaskView addTask;
    private HomePageView homePage;
    private ShowTaskView showTask;

    public ToDoListController() {

        tasks = new ArrayList<>();
        homePage = new HomePageView();
        addTask = new AddTaskView();
        showTask = new ShowTaskView();
//        Sample data for testing
//        tasks.add(new Task("read", "JAVA", new Date(119, 01, 01), Status.NEW));
//        tasks.add(new Task("read", "JAVA", new Date(119, 02, 01), Status.NEW));
//        tasks.add(new Task("read", "JAVA", new Date(118, 03, 01), Status.NEW));
//        tasks.add(new Task("read", "JAVA", new Date(118, 04, 01), Status.NEW));
//        tasks.add(new Task("read", "C", new Date(119, 02, 01), Status.NEW));
//        tasks.add(new Task("read", "D", new Date(118, 02, 01), Status.NEW));

    }

    public void showView(){

        Task newTask;

        boolean flag = true;
        do{
            int retVal = 0;
            homePage.showDisplay(tasks);
            retVal = homePage.showMenu();
            switch(retVal){
                case 1:     showTask.showDisplay();
                            showTask.showMenu();
                            showTask.showDisplay(tasks);
                            break;
                case 2:     newTask = addTask.showDisplay();
                            if (addTask.showMenu() == 1){
                                tasks.add(newTask);
                            }
                            break;
                case 3:     System.out.println("Edit Show Task");
                            break;
                case 4:     flag = false;
                            break;
            }
        } while(flag);
    }
}
