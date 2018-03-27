/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view.views;

import java.util.HashMap;
import java.util.Map;
import se.kth.sda3.todolist.controller.ToDoListController;
import se.kth.sda3.todolist.view.Menu;
import se.kth.sda3.todolist.view.Screen;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class HomePageView extends Screen{

    private static final int ADD = 1;
    private static final int SHOW = 2;
    private static final int EDIT = 3;
    private static final int SAVE = 4;
    private final Map<Integer, Screen> screens;

    public HomePageView(ToDoListController toDoListCtrl) {
        super(new Menu(), "");
        screens = new HashMap<>();
        menu.addOption(ADD, "Add Task");
        if(toDoListCtrl.getTaskSize() > 0) {
            menu.addOption(SHOW, "Show Task");
            menu.addOption(EDIT, "Edit Task");
        }
        menu.addOption(SAVE, "Save and Exit");
        screens.put(ADD, new AddView(toDoListCtrl));
        screens.put(SHOW, new ShowView(toDoListCtrl));
        screens.put(EDIT, new SelectTaskToEditView(toDoListCtrl));
    }

    @Override
    public void content() {
        System.out.println();
    }

    @Override
    public void processSelectedMenuOption(Integer option) {
        Screen screen = screens.get(option);
        if (screen != null) {
            screen.showScreen();
            option = screen.getSelectedMenuOption();
            screen.processSelectedMenuOption(option);
        }
    }

}
