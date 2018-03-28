/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view.views;

import se.kth.sda3.todolist.controller.DataController;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.ViewHelper;
import se.kth.sda3.todolist.view.Menu;
import se.kth.sda3.todolist.view.Screen;

/**
 * The view for adding a task.
 */
public class AddView extends Screen{

    private static final int ADD = 1;
    private static final int CANCEL = 2;
    private final Task newTask;
    private final DataController<Task> taskDataCtrl;

    /**
     * Creates an instance of the AddView.
     *
     * @param taskDataCtrl Contains access to the <code>Task</code> data that the view will use.
     */
    public AddView(DataController<Task> taskDataCtrl) {
        super(new Menu(), "          Add Task.        ");
        this.taskDataCtrl = taskDataCtrl;
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
            taskDataCtrl.addData(newTask);
        }
    }

}
