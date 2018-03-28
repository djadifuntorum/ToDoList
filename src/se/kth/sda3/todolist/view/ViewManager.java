/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import se.kth.sda3.todolist.controller.DataController;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.views.HomePageView;

/**
 * Manages the views of the application.
 */
public class ViewManager {

    private final DataController<Task> taskDataCtrl;

    /**
     * Creates an instance of the ViewManger.
     *
     * @param taskDataCtrl Contains access to the <code>Task</code> data that the view will use.
     */
    public ViewManager(DataController<Task> taskDataCtrl){
        this.taskDataCtrl = taskDataCtrl;
    }

    /**
     * Runs the application views.
     */
    public void run() {
        Integer option;
        do{
            Screen homePageView = new HomePageView(taskDataCtrl);
            homePageView.setLabel(String.format("  Currently have %d Tasks!  ", taskDataCtrl.getDataSize()));
            homePageView.showScreen();
            option = homePageView.getSelectedMenuOption();
            if (option == HomePageView.SAVE) {
                break;
            } else {
                homePageView.processSelectedMenuOption(option);
            }
        } while(true);
    }
}
