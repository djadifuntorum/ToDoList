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
public class SelectTaskToEditView extends Screen{

    private static final int REMOVE = 5;
    private static final int CANCEL = 6;
    private final ToDoListController toDoListCtrl;

    public SelectTaskToEditView(ToDoListController toDoListCtrl) {
        super(new Menu(), "         Edit Task.        ");
        this.toDoListCtrl = toDoListCtrl;
        Integer index = 1;
        for (Task task : toDoListCtrl.getTasks()){
            menu.addOption(index++,
                String.format("%s\t\t%s\t%s\t%s",
                    task.getProject(), task.getName(),
                    ViewHelper.parseDateToString(task.getDueDate()),
                    task.getStatus()));
        }
    }

    @Override
    protected void content() {
        System.out.println("   PROJECT\tTASK\tDUE DATE\tSTATUS");
    }

    @Override
    public void processSelectedMenuOption(Integer option) {
        Integer index = option - 1;
        boolean flag = true;
        Screen editScreen = new EditView(toDoListCtrl, index);
        do{
            editScreen.showScreen();
            option = editScreen.getSelectedMenuOption();
            switch(option){
                case CANCEL:
                    flag = false;
                    break;
                case REMOVE:
                    toDoListCtrl.removeTask(index);
                    flag = false;
                    break;
                default:
                    editScreen.processSelectedMenuOption(option);
            }
        } while(flag);
    }
}
