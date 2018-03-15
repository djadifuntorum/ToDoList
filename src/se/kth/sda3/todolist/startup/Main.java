/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.startup;

import se.kth.sda3.todolist.controller.ToDoListController;
import se.kth.sda3.todolist.filehandler.FileReader;
import se.kth.sda3.todolist.filehandler.FileWriter;
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
        FileReader reader = new FileReader("Tasks.txt");
        FileWriter writer = new FileWriter("Tasks.txt");
        ToDoListController toDoListCtrl = new ToDoListController();
        ViewController mainView = new ViewController(toDoListCtrl);
        toDoListCtrl.loadFile(reader);
        mainView.showView();
        toDoListCtrl.writeFile(writer);
    }

}
