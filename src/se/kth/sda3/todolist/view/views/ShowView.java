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
 * The view for showing the tasks.
 */
public class ShowView extends Screen{

    private static final int DUE_DATE = 1;
    private static final int PROJECT = 2;
    private final DataController<Task> taskDataCtrl;

    /**
     * Creates an instance of the ShowView.
     *
     * @param taskDataCtrl Contains access to the <code>Task</code> data that the view will use.
     */
    public ShowView(DataController<Task> taskDataCtrl) {
        super(new Menu(), "       Show tasks by:      ");
        this.taskDataCtrl = taskDataCtrl;
        menu.addOption(DUE_DATE, "Due Date");
        menu.addOption(PROJECT, "Project");
    }

    @Override
    protected void content() {
        System.out.println();
    }

    @Override
    public void processSelectedMenuOption(Integer option) {
        System.out.println();
        if (option == DUE_DATE) {
            showListByDueDate();
        } else {
            showListByProject();
        }
        System.out.println();
        System.out.println("Press enter to continue.");
        ViewHelper.getInput();
    }

    private void showListByDueDate() {
        System.out.println("DUE DATE\tTASK\tPROJECT\tSTATUS");
        taskDataCtrl.getData().stream()
                .sorted((a,b) -> a.getDueDate().compareTo(b.getDueDate()))
                .forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                        ViewHelper.parseDateToString(t.getDueDate()),
                        t.getName(), t.getProject(), t.getStatus()));
    }

    private void showListByProject() {
        System.out.println("PROJECT\tTASK\tDUE DATE\tSTATUS");
        taskDataCtrl.getData().stream()
                .sorted((a,b) -> a.getProject().compareTo(b.getProject()))
                .forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                        t.getProject(), t.getName(),
                        ViewHelper.parseDateToString(t.getDueDate()),
                        t.getStatus()));
    }

}
