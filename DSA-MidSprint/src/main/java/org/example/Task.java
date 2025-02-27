/*
 By: Cameron Beanland
 Date: February 27th, 2025
 */

package org.example;

// Task class stores the description & completion of a task, alongside a method marking tests as completed
public class Task {
    private String taskDesc; // task description
    private boolean isComplete; // tracks if a task is done

    public Task(String taskDesc) {
        this.taskDesc = taskDesc;
        this.isComplete = false;
    }

    public void taskCompletion() { // method to mark task as completed
        isComplete = true;
    }

    public String getTaskDesc() {
        return taskDesc; // used for external purpoes outside of Task class
    }

    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public String toString() { // customizing how the Task object will be represented when converted to string format
        return taskDesc + " [" + (isComplete ? "Completed ✔\uFE0F" : "Pending \uD83D\uDCAD") + "]";
    } // the expected output: "Finish homework [Completed ✔️]", or "Finish homework [Pending 💭]"
}

