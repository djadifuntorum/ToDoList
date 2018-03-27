/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class Menu {

    private Map<Integer, String> options;

    public Menu() {
        options = new HashMap<>();
    }

    public void addOption(Integer optionNumber, String label) {
        options.put(optionNumber, label);
    }

    public boolean isValidOption(Integer optionNumber){
        return options.containsKey(optionNumber);
    }

    public Map<Integer, String> getOptions() {
        return options;
    }

}
