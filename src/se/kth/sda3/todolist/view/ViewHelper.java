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
import java.util.Date;
import java.util.Locale;
import se.kth.sda3.todolist.model.Status;

/**
 * Helper for the View Controller.
 * Contains utility methods that the views can use.
 */
public class ViewHelper {

    /**
     * @return The inputted string value by the user.
     */
    public static String getInput() {
        String inputValue = "";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            inputValue = br.readLine();
            return inputValue;
        } catch (IOException e){
            System.out.println("Invalid input: " + e.getMessage());
            return inputValue;
        }
    }

    /**
     * @return The date inputted by the user.
     */
    public static Date getDateInput() {
        Date date = new Date();

        try {
            String inputDate = getInput();
            DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            return dateFormat.parse(inputDate);
        } catch(ParseException e){
            System.out.println("Invalid input: " + e.getMessage());
            return date;
        }

    }

    /**
     * @return The number inputted by the user.
     */
    public static int getIntegerInput() {
        try {
            return Integer.parseInt(getInput());
        } catch(NumberFormatException e) {
            System.out.println("Invalid input2 " + e.getMessage());
            return -1;
        }
    }

    /**
     * @return The status inputted by the user.
     */
    public static Status getStatusInput() {
        Status status = Status.NEW;
        boolean flag = true;
        do {
            String inputStatus = getInput();
            switch(inputStatus.toUpperCase()){
                case "NEW":
                    status = Status.NEW;
                    flag = false;
                    break;
                case "WORKING":
                    status = Status.WORKING;
                    flag = false;
                    break;
                case "DONE":
                    status = Status.DONE;
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter either NEW, WORKING or DONE.");
            }
        } while(flag);
        return status;
    }

    /**
     * Converts the inputted string value by the user.
     *
     * @param inputStatus The value the user inputted.
     * @return The Status equivalent to the inputted by the user.
     */
    public static Status parseStringToStatus(String inputStatus){
        Status status = Status.NEW;

        if(inputStatus.equals("NEW")){
            status = Status.NEW;
        } else if (inputStatus.equals("WORKING")){
            status = Status.WORKING;
        } else if (inputStatus.equals("DONE")){
            status = Status.DONE;
        } else {}
        return status;
    }

    /**
     * Converts the Date to string.
     *
     * @param dateFormat The Date format which the program recognizes.
     * @return The string equivalent.
     */
    public static String parseDateToString(Date dateFormat){
        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date date = dateFormat;
        String stringDate = df.format(date);

        return stringDate;
    }

    /**
     * Converts the string to Date.
     *
     * @param stringDate The date to be converted to Date format.
     * @return The Date format equivalent.
     */
    public static Date parseStringToDate(String stringDate){
        Date date = new Date();
        try{
            DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            date = format.parse(stringDate);
        }catch (ParseException e){
            System.out.println("Error " + e.getMessage());
        }
        return date;
    }

}
