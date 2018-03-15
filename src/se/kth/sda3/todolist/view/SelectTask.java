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
public class SelectTask implements ToDoList{
    private int index;

    @Override
    public void showDisplay(ArrayList<Task> tasks) {

        if (tasks.size() != 0){
            System.out.println("######################################");
            System.out.println("###          MY TO-DO LIST         ###");
            System.out.println("###  Please select a task to edit. ###");
            System.out.println("######################################");
            System.out.println();
            System.out.println();
            System.out.println("PROJECT\tTASK\tDUE DATE\t\t\tSTATUS");
            index = 1;
            tasks.stream().forEach(t -> System.out.format("%d) %s\t%s\t%s\t%s\n", index++,
                        t.getProject(), t.getName(), t.getDueDate(), t.getStatus()));
        } else {
            System.out.println("######################################");
            System.out.println("###          MY TO-DO LIST         ###");
            System.out.println("###   You have no tasks to edit.   ###");
            System.out.println("######################################");
        }
    }

    @Override
    public Task showDisplay() {
        return null;
    }

    @Override
    public int showMenu() {

        int retVal = 0;
        boolean flag = true;
        do{
            System.out.println("Please choose a number: ");

            retVal = ViewHelper.getIntegerInput();
            if(retVal > 0 && retVal <= index){
                flag = false;
            } else {
                System.out.format("Please enter a number from 1 to %d. \n", index);
            }
        } while(flag);
        return retVal - 1;
    }
}
