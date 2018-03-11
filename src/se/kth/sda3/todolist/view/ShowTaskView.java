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
public class ShowTaskView implements ToDoListView {

    public int sortValue = 1;

    public ShowTaskView() {
    }

    @Override
    public void showDisplay(ArrayList<Task> tasks) {
        if (sortValue == 1){ //duedate
            System.out.println("DUE DATE\t\t\tTASK\tPROJECT\tSTATUS");
            tasks.sort((a,b) -> a.getDueDate().compareTo(b.getDueDate()));
            tasks.stream().forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                    t.getDueDate(), t.getName(), t.getProject(), t.getStatus()));
        } else { //project
            System.out.println("PROJECT\tTASK\tDUE DATE\t\t\tSTATUS");
            tasks.sort((a,b) -> a.getProject().compareTo(b.getProject()));
            tasks.stream().forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                    t.getProject(), t.getName(), t.getDueDate(), t.getStatus()));
        }
    }

    @Override
    public Task showDisplay() {
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
        sortValue = retVal;
        return retVal;
    }

}
