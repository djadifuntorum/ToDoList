/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.util.ArrayList;
import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class EditTask implements ToDoList{

    private Task task = null;
    private int fieldToEdit = 0;

    @Override
    public void showDisplay(ArrayList<Task> tasks) {
        task = tasks.get(0);
        System.out.println("#####   Edit a task: ######");
        System.out.format("Task name: %s\n", task.getName());
        System.out.format("Project: %s\n", task.getProject());
        System.out.format("Due date: %s\n", task.getDueDate());
        System.out.format("Status: %s\n", task.getStatus());
    }

    @Override
    public Task showDisplay() {
        switch(fieldToEdit){
            case 1: System.out.format("Current Task name: %s\n", task.getName());
                    System.out.print("New Task name: ");
                    task.setName(ViewHelper.getInput());
                    break;
            case 2: System.out.format("Current Project: %s\n", task.getProject());
                    System.out.print("New Project: ");
                    task.setProject(ViewHelper.getInput());
                    break;
            case 3: System.out.format("Current Due date: %s\n", task.getDueDate());
                    System.out.print("New Due date: ");
                    task.setDueDate(ViewHelper.getDateInput());
                    break;
            case 4: System.out.format("Current Status: %s\n", task.getStatus());
                    System.out.print("New Status: ");
                    task.setStatus(ViewHelper.getStatusInput());
                    break;
        }
        return task;
    }

    @Override
    public int showMenu() {
        int retVal = 0;
        boolean flag = true;
        do{
            System.out.println("1. Update Task name");
            System.out.println("2. Update Project");
            System.out.println("3. Update Due date");
            System.out.println("4. Update Status");
            System.out.println("5. Remove");
            System.out.println("6. Cancel");
            System.out.println();
            System.out.println();
            System.out.print("Please choose a number: ");

            retVal = ViewHelper.getIntegerInput();
            if(retVal > 0 && retVal <= 6){
                flag = false;
            } else {
                System.out.println("Please select a number from 1 to 6.");
            }
        } while(flag);
        fieldToEdit = retVal;
        return retVal;
    }

}
