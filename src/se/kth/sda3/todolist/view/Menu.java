/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a selection of options to choose from.
 */
public class Menu {

    private Map<Integer, String> options;

    /**
     * Creates an instance.
     */
    public Menu() {
        options = new HashMap<>();
    }

    /**
     * Adds a new menu option.
     *
     * @param optionNumber The number of the option.
     * @param label The description of the option.
     */
    public void addOption(Integer optionNumber, String label) {
        options.put(optionNumber, label);
    }

    /**
     * Checks if the option is valid.
     *
     * @param optionNumber The number to be checked for validity.
     * @return <code>true</code> if number is valid.
     *         <code>false</code> if no such number was found.
     */
    public boolean isValidOption(Integer optionNumber){
        return options.containsKey(optionNumber);
    }

    /**
     * @return The option numbers and option descriptions.
     */
    public Map<Integer, String> getOptions() {
        return options;
    }

}
