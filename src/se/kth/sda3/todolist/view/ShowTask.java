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
public class ShowTask implements ToDoList {

    private int sortValue = 1;

    @Override
    public void showDisplay(ArrayList<Task> tasks) {
        System.out.println();
        if (sortValue == 1){
            System.out.println("DUE DATE\tTASK\tPROJECT\tSTATUS");
            tasks.stream()
                .sorted((a,b) -> a.getDueDate().compareTo(b.getDueDate()))
                .forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                        ViewHelper.parseDateToString(t.getDueDate()),
                        t.getName(), t.getProject(), t.getStatus()));
        } else { //project
            System.out.println("PROJECT\tTASK\tDUE DATE\tSTATUS");
            tasks.stream()
                .sorted((a,b) -> a.getProject().compareTo(b.getProject()))
                .forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                        t.getProject(), t.getName(),
                        ViewHelper.parseDateToString(t.getDueDate()),
                        t.getStatus()));
        }
        System.out.println();
    }

    @Override
    public Task showDisplay() {
        System.out.println();
        System.out.println("#####################################");
        System.out.println("#####       MY TO-DO LIST       #####");
        System.out.println("#####       Show tasks by:      #####");
        System.out.println("#####################################");
        System.out.println();
        System.out.println();
        return null;
    }

    @Override
    public int showMenu() {
        int retVal = 0;
        boolean flag = true;
        do{
            System.out.println("1. Due Date");
            System.out.println("2. Project");
            System.out.println();
            System.out.println();
            System.out.print("Please choose a number: ");

            retVal = ViewHelper.getIntegerInput();
            if (retVal > 0 && retVal <= 2) {
                flag = false;
            } else {
                System.out.println("Please select a number from 1 to 2.");
            }
        } while(flag);
        sortValue = retVal;
        return retVal;
    }

}
