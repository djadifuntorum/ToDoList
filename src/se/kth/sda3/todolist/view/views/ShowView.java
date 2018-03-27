/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view.views;

import se.kth.sda3.todolist.controller.ToDoListController;
import se.kth.sda3.todolist.view.ViewHelper;
import se.kth.sda3.todolist.view.Menu;
import se.kth.sda3.todolist.view.Screen;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ShowView extends Screen{

    private static final int DUE_DATE = 1;
    private static final int PROJECT = 2;
    private final ToDoListController toDoListCtrl;

    public ShowView(ToDoListController toDoListCtrl) {
        super(new Menu(), "       Show tasks by:      ");
        this.toDoListCtrl = toDoListCtrl;
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
        toDoListCtrl.getTasks().stream()
                .sorted((a,b) -> a.getDueDate().compareTo(b.getDueDate()))
                .forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                        ViewHelper.parseDateToString(t.getDueDate()),
                        t.getName(), t.getProject(), t.getStatus()));
    }

    private void showListByProject() {
        System.out.println("PROJECT\tTASK\tDUE DATE\tSTATUS");
        toDoListCtrl.getTasks().stream()
                .sorted((a,b) -> a.getProject().compareTo(b.getProject()))
                .forEach(t -> System.out.format("%s\t%s\t%s\t%s\n",
                        t.getProject(), t.getName(),
                        ViewHelper.parseDateToString(t.getDueDate()),
                        t.getStatus()));
    }

}
