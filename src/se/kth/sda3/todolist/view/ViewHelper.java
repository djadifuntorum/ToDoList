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
import se.kth.sda3.todolist.model.Status;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ViewHelper {

    public static String getInput(){

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

    public static Date getDateInput(){

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

    public static int getIntegerInput(){

        try {
            return Integer.parseInt(getInput());
        } catch(NumberFormatException e){
            System.out.println("Invalid input2 " + e.getMessage());
            return -1;
        }
    }

    public static Status getStatusInput(){
        Status status = Status.NEW;
        boolean flag = true;
        do{
            String inputStatus = ViewHelper.getInput();
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
}
