/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class TaskWriter {

    private String filename = "";

    public TaskWriter(String filename) {
        this.filename = filename;
    }

    public void writeFile(ArrayList<Task> tasks) {

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileWriter(filename));

            for (Task task:tasks) {
                outputStream.format("%s,%s,%s,%s\n",
                                    task.getName(), task.getProject(),
                                    task.getDueDate(), task.getStatus());
            }

        } catch(IOException e) {
            System.out.println("Message: " + e.getMessage());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
