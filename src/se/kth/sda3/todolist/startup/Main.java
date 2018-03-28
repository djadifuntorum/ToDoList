/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.startup;

import se.kth.sda3.todolist.controller.DataController;
import se.kth.sda3.todolist.filehandler.TaskReader;
import se.kth.sda3.todolist.filehandler.TaskWriter;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.ViewController;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskReader reader = new TaskReader("Tasks.csv");
        TaskWriter<Task> writer = new TaskWriter("Tasks.csv");
        DataController<Task> toDoListCtrl = new DataController<>();
        ViewController view = new ViewController(toDoListCtrl);
        toDoListCtrl.loadFile(reader);
        view.run();
        toDoListCtrl.writeFile(writer);
    }

}
