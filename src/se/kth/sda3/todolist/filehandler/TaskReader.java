/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.ViewHelper;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class TaskReader {

    private String filename;

    public TaskReader(String filename) {
        this.filename = filename;
    }

    public ArrayList<Task> readFile() {
        ArrayList<Task> tasks = new ArrayList<>();
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                Task task = new Task();
                String[] arrayTask = line.split(",");

                task.setName(arrayTask[0]);
                task.setProject(arrayTask[1]);
                task.setDueDate(ViewHelper.parseStringToDate(arrayTask[2]));
                task.setStatus(ViewHelper.parseStringToStatus(arrayTask[3]));
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("IO Error: " + e.getMessage());
                }
            }
        }
        return tasks;
    }
}
