/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import se.kth.sda3.todolist.model.Status;
import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class AddTask implements ToDoListView {

    public AddTask() {
    }

    @Override
    public void showDisplay(ArrayList<Task> tasks) {

        Task newTask = new Task();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Task: ");
            newTask.setName(br.readLine());
            System.out.print("Enter Project: ");
            newTask.setProject(br.readLine());
            System.out.print("Enter Due date <ddmmyyyy>: ");
            String inputDate = br.readLine();
            DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            newTask.setDueDate(dateFormat.parse(inputDate));
            boolean flag = true;
            do{
                System.out.print("Enter Status: ");
                String status = br.readLine();
                switch(status.toUpperCase()){
                    case "NEW": newTask.setStatus(Status.NEW);
                                flag = false;
                                break;
                    case "WORKING": newTask.setStatus(Status.WORKING);
                                    flag = false;
                                    break;
                    case "DONE":    newTask.setStatus(Status.DONE);
                                    flag = false;
                                    break;
                    default:
                        System.out.println("Please enter either NEW, WORKING or DONE.");

                }
            } while(flag);
            tasks.add(newTask);
        } catch (ParseException|IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showMenu() {

    }



}
