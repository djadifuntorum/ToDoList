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
 * The view for selecting a task.
 */
public class SelectTaskToEditView extends Screen{

    private static final int REMOVE = 5;
    private static final int CANCEL = 6;
    private final DataController<Task> taskDataCtrl;

    /**
     * Creates an instance of the SelectTaskToEditView.
     *
     * @param taskDataCtrl Contains access to the <code>Task</code> data that the view will use.
     */
    public SelectTaskToEditView(DataController<Task> taskDataCtrl) {
        super(new Menu(), "         Edit Task.        ");
        this.taskDataCtrl = taskDataCtrl;
        Integer index = 1;
        for (Task task : taskDataCtrl.getData()){
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
        Screen editScreen = new EditView(taskDataCtrl, index);
        do{
            editScreen.showScreen();
            option = editScreen.getSelectedMenuOption();
            switch(option){
                case CANCEL:
                    flag = false;
                    break;
                case REMOVE:
                    taskDataCtrl.removeData(index);
                    flag = false;
                    break;
                default:
                    editScreen.processSelectedMenuOption(option);
            }
        } while(flag);
    }
}
