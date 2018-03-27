/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.sda3.todolist.filehandler.TaskReader;
import se.kth.sda3.todolist.filehandler.TaskWriter;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 * @param <T>
 */
public class DataController<T> {

    private final List<T> data;

    public DataController() {
        data = new ArrayList<>();
    }

    public void loadFile(TaskReader reader) {
        data.addAll((List<T>)reader.readFile());
    }

    public void writeFile(TaskWriter writer) {
        writer.writeFile(data);
    }

    public List<T> getData() {
        return data;
    }

    public void addData(T t) {
        data.add(t);
    }

    public int getDataSize() {
        return data.size();
    }

    public T getDataByIndex (int index) {
        return data.get(index);
    }

    public void updateData(T t, int index) {
        data.set(index, t);
    }

    public void removeData(int index){
        data.remove(index);
    }
}
