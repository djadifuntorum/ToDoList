/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view.views;

import java.util.List;
import se.kth.sda3.todolist.controller.DataController;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.Menu;
import se.kth.sda3.todolist.view.Screen;
import se.kth.sda3.todolist.view.ViewHelper;

/**
 * The view for editing a task.
 */
public class EditView extends Screen{

    private static final int TASK_NAME = 1;
    private static final int PROJECT = 2;
    private static final int DUE_DATE = 3;
    private static final int STATUS = 4;
    private static final int REMOVE = 5;
    private static final int CANCEL = 6;
    private final DataController<Task> taskDataCtrl;
    private final Integer index;

    /**
     * Creates an instance of the EditView.
     *
     * @param taskDataCtrl Contains access to the <code>Task</code> data that the view will use.
     * @param index The index of the data to be edited.
     */
    public EditView(DataController<Task> taskDataCtrl, Integer index) {
        super(new Menu(), "         Edit Task.        ");
        this.taskDataCtrl = taskDataCtrl;
        this.index = index;
        menu.addOption(TASK_NAME, "Update Task name");
        menu.addOption(PROJECT, "Update Project");
        menu.addOption(DUE_DATE, "Update Due Date");
        menu.addOption(STATUS, "Update Status");
        menu.addOption(REMOVE, "Remove");
        menu.addOption(CANCEL, "Go back to Home Page");
    }

    @Override
    protected void content() {
        List<Task> tasks = taskDataCtrl.getData();
        System.out.println();
        System.out.format("Task name: %s\n", tasks.get(index).getName());
        System.out.format("Project: %s\n", tasks.get(index).getProject());
        System.out.format("Due date: %s\n", ViewHelper.parseDateToString(tasks.get(index).getDueDate()));
        System.out.format("Status: %s\n", tasks.get(index).getStatus());
        System.out.println();
    }

    @Override
    public void processSelectedMenuOption(Integer option) {
        List<Task> tasks = taskDataCtrl.getData();
        System.out.println();
        switch(option){
            case TASK_NAME:
                System.out.format("Current Task name: %s\n", tasks.get(index).getName());
                System.out.print("New Task name: ");
                tasks.get(index).setName(ViewHelper.getInput());
                break;
            case PROJECT:
                System.out.format("Current Project: %s\n", tasks.get(index).getProject());
                System.out.print("New Project: ");
                tasks.get(index).setProject(ViewHelper.getInput());
                break;
            case DUE_DATE:
                System.out.format("Current Due date: %s\n", ViewHelper.parseDateToString(tasks.get(index).getDueDate()));
                System.out.print("New Due date: ");
                tasks.get(index).setDueDate(ViewHelper.getDateInput());
                break;
            case STATUS:
                System.out.format("Current Status: %s\n", tasks.get(index).getStatus());
                System.out.print("New Status: ");
                tasks.get(index).setStatus(ViewHelper.getStatusInput());
                break;
        }
    }

}
