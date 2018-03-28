/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.startup;

import se.kth.sda3.todolist.controller.DataController;
import se.kth.sda3.todolist.filehandler.Reader;
import se.kth.sda3.todolist.filehandler.Writer;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.ViewManager;

/**
 * Contains the <code>main</code> method.
 * Starts the application.
 */
public class Main {

    /**
     * The applications main method.
     *
     * @param args The application does not have command line arguments.
     */
    public static void main(String[] args) {
        Reader<Task> reader = new Reader("Tasks.csv");
        Writer<Task> writer = new Writer("Tasks.csv");
        DataController<Task> taskDataCtrl = new DataController<>();
        ViewManager view = new ViewManager(taskDataCtrl);

        taskDataCtrl.loadFile(reader);
        view.run();
        taskDataCtrl.writeFile(writer);
    }

}
