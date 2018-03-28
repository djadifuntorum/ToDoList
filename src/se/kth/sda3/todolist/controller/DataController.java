/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.sda3.todolist.filehandler.Reader;
import se.kth.sda3.todolist.filehandler.Writer;

/**
 * The class to handle a collection of data.
 *
 * @param <T> The data that the class will handle.
 */
public class DataController<T> {

    private final List<T> data;

    /**
     * Creates a new instance.
     */
    public DataController() {
        data = new ArrayList<>();
    }

    /**
     * Loads the data from the file reader.
     *
     * @param reader The data reader object.
     */
    public void loadFile(Reader<T> reader) {
        data.addAll(reader.readFile());
    }

    /**
     * Writes the data to the file writer.
     *
     * @param writer The file writer object.
     */
    public void writeFile(Writer<T> writer) {
        writer.writeFile(data);
    }

    /**
     * @return The list of data.
     */
    public List<T> getData() {
        return data;
    }

    /**
     * @param data The data to be added.
     */
    public void addData(T data) {
        this.data.add(data);
    }

    /**
     * @return The size of data in the collection.
     */
    public int getDataSize() {
        return data.size();
    }

    /**
     * @param index The value used to get the data needed.
     * @return The data that is contained from the given index value.
     */
    public T getDataByIndex (int index) {
        return data.get(index);
    }

    /**
     * @param data The data to be updated.
     * @param index The value used to determine which data to be updated.
     */
    public void updateData(T data, int index) {
        this.data.set(index, data);
    }

    /**
     * @param index The value used to determine which data to be removed.
     */
    public void removeData(int index){
        data.remove(index);
    }
}
