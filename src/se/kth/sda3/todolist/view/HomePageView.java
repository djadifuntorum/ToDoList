/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class HomePageView {

    public HomePageView() {
    }

    public int homePage(){

        int retVal = 0;
        System.out.println("#####################################");
        System.out.println("#####       MY TO-DO LIST       #####");
        System.out.println("#####  Currently have n Tasks!  #####");
        System.out.println("#####################################");
        System.out.println();
        System.out.println();

        retVal = homeMenu();
        System.out.println("RETVAL:HomePageView.homePage" + retVal);
        return retVal;
    }

    public int homeMenu(){

        int retVal = 0;
        String status = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("1. Show Task");
                System.out.println("2. Add Task");
                System.out.println("3. Edit Task");
                System.out.println("4. Exit");
                System.out.println();
                System.out.println();
                status = br.readLine();
                System.out.println("!!!!!!!!!!HomePageView: " + status);


                switch(status){
                    case "1":   retVal = 1;
                                break;
                    case "2":   retVal = 2;
                                break;
                    case "3":   retVal = 3;
                                break;
                    case "4":   retVal = 4;
                                break;
                    default:
                            System.out.println("Please enter numbers from 1 - 4");
                }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("RETVAL:HomePageView.homeMenu" + retVal);
        return retVal;
    }

}
