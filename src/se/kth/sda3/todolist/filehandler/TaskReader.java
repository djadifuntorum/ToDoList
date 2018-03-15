/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    public TaskReader(String filename){
        this.filename = filename;
    }

    public ArrayList<Task> readFile(){
        ArrayList<Task> tasks = new ArrayList<>();

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                Task task = new Task();
                // use comma as separator
                String[] arrayTask = line.split(cvsSplitBy);
                task.setName(arrayTask[0]);
                task.setProject(arrayTask[1]);
                task.setDueDate(ViewHelper.parseStringToDate(arrayTask[2]));
                task.setStatus(ViewHelper.setStatus(arrayTask[3]));
                tasks.add(task);
            }


        } catch (FileNotFoundException e) {
            System.out.println("Message: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Message: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Message: " + e.getMessage());
                }
            }
        }
        //read file
//      Sample data for testing
//        tasks.add(new Task("read", "JAVA", new Date(119, 01, 01), Status.NEW));
//        tasks.add(new Task("read", "JAVA", new Date(119, 02, 01), Status.NEW));
//        tasks.add(new Task("read", "JAVA", new Date(118, 03, 01), Status.NEW));
//        tasks.add(new Task("read", "JAVA", new Date(118, 04, 01), Status.NEW));
//        tasks.add(new Task("read", "C", new Date(119, 02, 01), Status.NEW));
//        tasks.add(new Task("read", "D", new Date(118, 02, 01), Status.NEW));
        return tasks;
    }
}
