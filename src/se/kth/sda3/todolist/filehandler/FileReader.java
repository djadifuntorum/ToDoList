/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.util.ArrayList;
import java.util.Date;
import se.kth.sda3.todolist.model.Status;
import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class FileReader {

    private String filename;

    public FileReader(String filename){
        this.filename = filename;
    }

    public ArrayList<Task> readFile(){
        ArrayList<Task> tasks = new ArrayList<>();
        //open file

        //read file
//      Sample data for testing
        tasks.add(new Task("read", "JAVA", new Date(119, 01, 01), Status.NEW));
        tasks.add(new Task("read", "JAVA", new Date(119, 02, 01), Status.NEW));
        tasks.add(new Task("read", "JAVA", new Date(118, 03, 01), Status.NEW));
        tasks.add(new Task("read", "JAVA", new Date(118, 04, 01), Status.NEW));
        tasks.add(new Task("read", "C", new Date(119, 02, 01), Status.NEW));
        tasks.add(new Task("read", "D", new Date(118, 02, 01), Status.NEW));
        return tasks;
    }
}
