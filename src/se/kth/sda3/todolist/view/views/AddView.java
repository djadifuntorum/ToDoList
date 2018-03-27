/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view.views;

import se.kth.sda3.todolist.controller.ToDoListController;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.ViewHelper;
import se.kth.sda3.todolist.view.Menu;
import se.kth.sda3.todolist.view.Screen;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class AddView extends Screen{

    private static final int ADD = 1;
    private static final int CANCEL = 2;
    private final Task newTask;
    private final ToDoListController toDoListCtrl;

    public AddView(ToDoListController toDoListCtrl) {
        super(new Menu(), "          Add Task.        ");
        this.toDoListCtrl = toDoListCtrl;
        newTask = new Task();
        menu.addOption(ADD, "Add");
        menu.addOption(CANCEL, "Cancel");
    }

    @Override
    protected void content() {
        System.out.print("Enter Task: ");
        newTask.setName(ViewHelper.getInput());
        System.out.print("Enter Project: ");
        newTask.setProject(ViewHelper.getInput());
        System.out.print("Enter Due date <ddmmyyyy>: ");
        newTask.setDueDate(ViewHelper.getDateInput());
        System.out.print("Enter Status: ");
        newTask.setStatus(ViewHelper.getStatusInput());
        System.out.println();
        System.out.println();
    }

    @Override
    public void processSelectedMenuOption(Integer option) {
        if (option == ADD){
            toDoListCtrl.addTask(newTask); // should call controller where task is not a parameter. this code is for model.
        }
    }

}
