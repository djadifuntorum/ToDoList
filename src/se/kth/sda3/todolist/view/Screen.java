/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.util.Map;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public abstract class Screen{

    protected Menu menu;
    private String label;

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

    public void setLabel(String label) {
        this.label = label;
    }

    protected abstract void content();

    private void menuOptions() {
        for (Map.Entry<Integer, String> entry: menu.getOptions().entrySet()) {
            System.out.println(entry.getKey()+ ". " + entry.getValue());
        }
    }

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

    public abstract void processSelectedMenuOption(Integer option);

    public void showScreen() {
        setLabel(label);
        banner();
        content();
        menuOptions();
    }
}
