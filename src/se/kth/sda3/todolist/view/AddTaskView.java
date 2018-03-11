/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;


import java.util.ArrayList;
import se.kth.sda3.todolist.model.Status;
import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class AddTaskView implements ToDoListView {

    public AddTaskView() {
    }

    @Override
    public void showDisplay(ArrayList<Task> tasks) {

    }

    @Override
    public Task showDisplay() {
        Task newTask = new Task();
        System.out.print("Enter Task: ");
        newTask.setName(ViewHelper.getInput());
        System.out.print("Enter Project: ");
        newTask.setProject(ViewHelper.getInput());
        System.out.print("Enter Due date <ddmmyyyy>: ");
        newTask.setDueDate(ViewHelper.getDateInput());
        boolean flag = true;
        do{
            System.out.print("Enter Status: ");
            String status = ViewHelper.getInput();
            switch(status.toUpperCase()){
                case "NEW": newTask.setStatus(Status.NEW);
                            flag = false;
                            break;
                case "WORKING": newTask.setStatus(Status.WORKING);
                                flag = false;
                                break;
                case "DONE":    newTask.setStatus(Status.DONE);
                                flag = false;
                                break;
                default:
                    System.out.println("Please enter either NEW, WORKING or DONE.");

            }
        } while(flag);
        return newTask;
    }

    @Override
    public int showMenu() {
        int retVal = 0;
        boolean flag = true;
        do{
            System.out.println("1. Add");
            System.out.println("2. Cancel");
            System.out.println();
            System.out.println();
            System.out.print("Please choose a number: ");

            switch(ViewHelper.getIntegerInput()){
                case 1: retVal = 1;
                        flag = false;
                        break;
                case 2: retVal = 2;
                        flag = false;
                        break;
                default:
                        System.out.println("Please enter numbers from 1 or 2.");
            }
        } while(flag);
        return retVal;
    }


}
