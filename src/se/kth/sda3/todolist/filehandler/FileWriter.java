/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.util.ArrayList;
import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class FileWriter {

    private String filename;

    public FileWriter(String filename){
        this.filename = filename;
    }

    public void writeFile(ArrayList<Task> tasks){
        System.out.println("Writing to file....");
    }
}
