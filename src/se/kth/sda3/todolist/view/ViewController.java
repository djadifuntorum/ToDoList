/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import se.kth.sda3.todolist.controller.DataController;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.views.HomePageView;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ViewController {

    private final DataController<Task> toDoListCtrl;

    public ViewController(DataController<Task> toDoListCtrl){
        this.toDoListCtrl = toDoListCtrl;
    }

    public void run() {
        Integer option;
        do{
            Screen homePageView = new HomePageView(toDoListCtrl);
            homePageView.setLabel(String.format("  Currently have %d Tasks!  ", toDoListCtrl.getDataSize()));
            homePageView.showScreen();
            option = homePageView.getSelectedMenuOption();
            if (option == 4) {
                break;
            } else {
                homePageView.processSelectedMenuOption(option);
            }
        } while(true);
    }
}
