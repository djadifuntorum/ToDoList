/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.util.List;

/**
 * Interface class for reading data from file.
 */
public interface Reader<T> {
    public List<T> readFile();
}
