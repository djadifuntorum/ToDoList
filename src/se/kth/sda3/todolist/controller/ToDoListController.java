/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.controller;

import java.util.ArrayList;
import se.kth.sda3.todolist.filehandler.TaskReader;
import se.kth.sda3.todolist.filehandler.TaskWriter;

import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ToDoListController {

    private ArrayList<Task> tasks;

    public ToDoListController() {
        tasks = new ArrayList<>();
    }

    public void loadFile(TaskReader reader) {
        tasks.addAll(reader.readFile());
    }

    public void writeFile(TaskWriter writer) {
        writer.writeFile(tasks);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getTaskSize() {
        return tasks.size();
    }

    public Task getTaskByIndex (int index) {
        return tasks.get(index);
    }

    public void updateTask(Task task, int taskIndex) {
        tasks.set(taskIndex, task);
    }

    public void removeTask(int taskIndex){
        tasks.remove(taskIndex);
    }
}
