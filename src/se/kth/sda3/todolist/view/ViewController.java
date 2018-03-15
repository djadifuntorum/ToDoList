/*
 * To-Do List Application
 * Copyright (C) 2018, Debby Jane Azarcon
 */
package se.kth.sda3.todolist.view;

import java.util.ArrayList;
import se.kth.sda3.todolist.controller.ToDoListController;
import se.kth.sda3.todolist.model.Task;

/**
 *
 * @author Debby Jane Azarcon <dja.difuntorum@gmail.com>
 */
public class ViewController {

    private ToDoListController toDoListCtrl;
    private HomePage homePage;
    private ShowTask showTask;
    private AddTask addTask;
    private SelectTask selectTask;
    private EditTask editTask;

    public ViewController(ToDoListController toDoListCtrl){
        this.toDoListCtrl = toDoListCtrl;
        homePage = new HomePage();
        showTask = new ShowTask();
        addTask = new AddTask();
        selectTask = new SelectTask();
        editTask = new EditTask();
    }

    public void showView(){

        Task task;

        boolean flag = true;
        do{
            int retVal = 0;
            homePage.showDisplay(toDoListCtrl.getTasks());
            retVal = homePage.showMenu();
            switch(retVal){
                case 1:     showTask.showDisplay();
                            showTask.showMenu();
                            showTask.showDisplay(toDoListCtrl.getTasks());
                            break;
                case 2:     task = addTask.showDisplay();
                            if (addTask.showMenu() == 1){
                                toDoListCtrl.addTask(task);
                            }
                            break;
                case 3:     selectTask.showDisplay(toDoListCtrl.getTasks());
                            if(toDoListCtrl.getTaskSize() > 0){
                                int taskIndex = selectTask.showMenu();
                                ArrayList<Task> tasks = new ArrayList<>();
                                tasks.add(toDoListCtrl.getTaskByIndex(taskIndex));
                                do{
                                    editTask.showDisplay(tasks);
                                    int fieldToEdit = editTask.showMenu();
                                    if(fieldToEdit > 0 && fieldToEdit <= 4){
                                        task = editTask.showDisplay();
                                        toDoListCtrl.updateTask(task, taskIndex);
                                    } else if (fieldToEdit == 5){
                                        toDoListCtrl.removeTask(taskIndex);
                                        System.out.println("Tasked removed!!!");
                                        break;
                                    } else {
                                        break;
                                    }
                                }while(true);
                                //call another view
                            } else {
                                System.out.println("Press Enter to continue.");
                                ViewHelper.getInput();
                            }

                            break;
                case 4:     flag = false;
                            break;
            }
        } while(flag);
    }
}
