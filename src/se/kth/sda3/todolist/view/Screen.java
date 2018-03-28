/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.util.Map;

/**
 * Constructs the screen of the application.
 */
public abstract class Screen {

    protected Menu menu;
    private String label;

    /**
     * Creates an instance.
     *
     * @param menu The menu that the screen will have.
     * @param label The label a particular screen will have.
     */
    public Screen(Menu menu, String label) {
        this.menu = menu;
        this.label = label;
    }

    private void banner() {
        System.out.println();
        System.out.println("#####################################");
        System.out.println("#####       MY TO-DO LIST       #####");
        System.out.println("#####" + label + "#####");
        System.out.println("#####################################");
        System.out.println();
    }

    /**
     * @param label The description of the screen.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Additional information to show for each <code>Screen</code> implementation.
     */
    protected abstract void content();

    private void menuOptions() {
        for (Map.Entry<Integer, String> entry: menu.getOptions().entrySet()) {
            System.out.println(entry.getKey()+ ". " + entry.getValue());
        }
    }

    /**
     * @return The option selected by the user.
     */
    public Integer getSelectedMenuOption() {
        Integer input = 0;
        do{
            System.out.println();
            System.out.print("Please choose a number: ");
            input = ViewHelper.getIntegerInput();
            if (menu.isValidOption(input)) {
                break;
            } else {
                System.out.println();
                System.out.print("Please input number within range.");
            }
        } while(true);
        return input;
    }

    /**
     * Performs the next step based on the given option.
     *
     * @param option The menu option the user selected.
     */
    public abstract void processSelectedMenuOption(Integer option);

    /**
     * Displays the constructed screen.
     */
    public void showScreen() {
        setLabel(label);
        banner();
        content();
        menuOptions();
    }
}
