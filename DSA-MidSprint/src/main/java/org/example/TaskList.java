/*
 By: Cameron Beanland
 Date: February 27th, 2025
 */

package org.example;

// TaskList represents the to-do list for a user, and includes methods from the Task class to add tasks,
// mark as completed, and print all tasks
public class TaskList {
    private static class TaskNode {
        Task task; // task stored in node
        TaskNode next; // points to next node in list

        public TaskNode(Task task) {
            this.task = task;
            this.next = null; // next node is initially null
        }
    }

    private TaskNode head; // head of the linked list

    // add task to linked list
    public void addTask(String description) {
        Task newTask = new Task(description); // creates new task
        if (head == null) { // 'head == null' refers to if the list is empty
            head = new TaskNode(newTask); // if setup properly, sets new task as the head
        } else {
            TaskNode temp = head;
            while (temp.next != null) { // traverses to last node
                temp = temp.next;
            }
            temp.next = new TaskNode(newTask); // append new task node at the end
        }
    }

    // mark task as completed by description
    public boolean markTaskCompleted(String description) {
        TaskNode temp = head; // start from the head
        while (temp != null) {
            if (temp.task.getTaskDesc().equals(description)) {
                temp.task.taskCompletion(); // if task description matches, mark as completed
                return true;
            }
            temp = temp.next;
        }
        return false; // if no task was found, return false
    }

    // prints all tasks
    public void printTasks() {
        TaskNode temp = head;
        while (temp != null) {
            System.out.println(temp.task); // print task using the toString method
            temp = temp.next;
        }
    }
}
