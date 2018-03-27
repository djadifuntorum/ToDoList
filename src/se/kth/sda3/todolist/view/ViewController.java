/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import se.kth.sda3.todolist.controller.ToDoListController;
import se.kth.sda3.todolist.view.views.HomePageView;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ViewController {

    private final ToDoListController toDoListCtrl;

    public ViewController(ToDoListController toDoListCtrl){
        this.toDoListCtrl = toDoListCtrl;
    }

    public void run() {
        Integer option;
        do{
            Screen homePageView = new HomePageView(toDoListCtrl);
            homePageView.setLabel(String.format("  Currently have %d Tasks!  ", toDoListCtrl.getTaskSize()));
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
