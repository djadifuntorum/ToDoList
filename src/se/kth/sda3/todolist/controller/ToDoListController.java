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
    }

    public void showView(){
        boolean flag = true;
        do{
            int retVal = 0;
            retVal = homePage.homePage();
            System.out.println("RETVAL:ToDoListController.showView" + retVal);
            switch(retVal){
                case 1:     showTask.showDisplay(tasks);
                            flag = true;
                            break;
                case 2:     addTask.showDisplay(tasks);
                            flag = true;
                            break;
                case 3:     System.out.println("Edit Show Task");
                            flag = true;
                            break;
                default:    flag = false;
                            break;
            }
        } while(flag);
    }
}
