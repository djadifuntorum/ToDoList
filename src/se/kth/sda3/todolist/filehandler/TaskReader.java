/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import se.kth.sda3.todolist.model.Task;
import se.kth.sda3.todolist.view.ViewHelper;

/**
 * The class responsible for reading data from a file.
 */
public class TaskReader implements Reader<Task> {

    private final String filename;

    /**
     * Creates a new instance.
     *
     * @param filename The filename of the file to be read.
     */
    public TaskReader(String filename) {
        this.filename = filename;
    }

    /**
     * @return The data collection read from file.
     */
    public List<Task> readFile() {
        List<Task> tasks = new ArrayList<>();
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
