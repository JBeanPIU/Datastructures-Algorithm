/*
 By: Cameron Beanland
 Date: February 27th, 2025
 */

package org.example;

// An extension of Main, find User-related data here!
public class User {
    private String name;
    private TaskList tasklist; // represents user to-do list

    public User(String name) {
        this.name = name;
        this.tasklist = new TaskList(); // initialize as a new TaskList object
    }

    public String getName() {
        return name;
    }

    /* ================= */
    public void addTask(String taskDesc) {
        tasklist.addTask(taskDesc); // Fixed this line
    }

    public boolean completeTask(String taskDesc) {
        return tasklist.markTaskCompleted(taskDesc);
    }

    public void viewTasks() {
        System.out.println(name + "'s list of tasks:");
        tasklist.printTasks(); // call the TaskList's method to print all tasks
    }
}

