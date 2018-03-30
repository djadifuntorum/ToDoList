To-Do List Application User Guide
===

What is To-Do List Application?
---

To-Do List Application is a text based user interface that uses the command line to input and show data.
It has four functionalities. **Add**, **Show**, **Edit** and **Save** tasks. A task contains a task name, a project name 
which the task belongs to, a due date when the task should be finished and lastly, a status which tells the state of the class. 


Application Requirements
---

- Java 8 Runtime Environment
- Command Line Terminal
- Application JAR file


Using To-Do List Application
---

### Start the application
1. Download the latest released JAR file from the project's github
[Release](https://github.com/djadifuntorum/ToDoList/releases) page.
2. Open command line terminal.
3. Change directory where the JAR file was downloaded.
4. Input the following command in the command line ``java -jar To-Do_List_v1.0.jar``. 

### Add a task
1. Select **option 1** in home page.
2. Input the name of the task.
3. Input the project the task belongs to.
4. Input the date the task needs to be finished.
5. Input the status of the task. 
6. Select 1 to **Add a task**.

### Show a task
1. Select **option 2** in home page.
2. Select which option you want to proceed.
	- Select 1 to **Show by Due Date**
	- Select 2 to **Show by Project**

### Edit a task
1. Select **option 3** in home page.
2. Select the task you want to edit.
3. Select field you want to update.
4. Input new data.

### Remove a task
1. Select **option 3** in home page.
2. Select the task you want to remove.
3. Select **option 5**.

### Save task
1. Select **option 4** in home page.

Limitations
---
- The status of the task is only limited to *NEW*, *WORKING* and *DONE*.
- The show functionality can only show two options, *BY PROJECT* and *BY DUE DATE*. 
