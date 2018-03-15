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
public class HomePage implements ToDoList {


    @Override
    public void showDisplay(ArrayList<Task> tasks) {

        System.out.println("#####################################");
        System.out.println("#####       MY TO-DO LIST       #####");
        System.out.format("#####  Currently have %d Tasks!  ##### \n", tasks.size());
        System.out.println("#####################################");
        System.out.println();
        System.out.println();

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
            System.out.println("1. Show Task");
            System.out.println("2. Add Task");
            System.out.println("3. Edit Task");
            System.out.println("4. Save and Exit");
            System.out.println();
            System.out.println();
            System.out.print("Please choose a number: ");

            switch(ViewHelper.getIntegerInput()){
                case 1:     retVal = 1;
                            flag = false;
                            break;
                case 2:     retVal = 2;
                            flag = false;
                            break;
                case 3:     retVal = 3;
                            flag = false;
                            break;
                case 4:     retVal = 4;
                            flag = false;
                            break;
                default:
                        System.out.println("Please enter numbers from 1 - 4");
            }
        } while(flag);
        return retVal;
    }

}
