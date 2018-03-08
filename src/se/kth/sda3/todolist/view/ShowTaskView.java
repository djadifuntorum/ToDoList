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

    public ShowTaskView() {
    }

    @Override
    public void showDisplay(ArrayList<Task> tasks) {
        System.out.println("SHOW TASK VIEW");
        for (Task task: tasks){
            System.out.println(task.getName());
            System.out.println(task.getProject());
            System.out.println(task.getDueDate());
            System.out.println(task.getStatus());
        }

    }

    @Override
    public void showMenu() {

    }



}
