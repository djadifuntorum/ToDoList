/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view.views;

import java.util.HashMap;
import java.util.Map;
import se.kth.sda3.todolist.controller.DataController;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.Menu;
import se.kth.sda3.todolist.view.Screen;

/**
 * The view for the applications home page.
 */
public class HomePageView extends Screen{

    private static final int ADD = 1;
    private static final int SHOW = 2;
    private static final int EDIT = 3;
    public static final int SAVE = 4;
    private final Map<Integer, Screen> screens;

    /**
     * Creates an instance of the HomePageView.
     *
     * @param taskDataCtrl Contains access to the <code>Task</code> data that the view will use.
     */
    public HomePageView(DataController<Task> taskDataCtrl) {
        super(new Menu(), "");
        screens = new HashMap<>();
        menu.addOption(ADD, "Add Task");
        if(taskDataCtrl.getDataSize() > 0) {
            menu.addOption(SHOW, "Show Task");
            menu.addOption(EDIT, "Edit Task");
        }
        menu.addOption(SAVE, "Save and Exit");
        screens.put(ADD, new AddView(taskDataCtrl));
        screens.put(SHOW, new ShowView(taskDataCtrl));
        screens.put(EDIT, new SelectTaskToEditView(taskDataCtrl));
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
