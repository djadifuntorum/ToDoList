/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.filehandler;

import java.util.List;

/**
 * Interface class for writing data to file.
 */
public interface Writer<T> {
        public void writeFile(List<T> t);
}
