/*
 By: Cameron Beanland
 Date: February 27th, 2025
 */

package org.example; // takes all from this folder specifically instead of drawing from each class individually
import java.util.Scanner;

// A slightly complex (to me) to-do list manager to let users add tasks, mark tasks as completed, and view lists of tasks.
// each user has their own to-do list, represented through a single linked list.
public class Main {
    public static void main(String[] args) {
        User[] users = new User[5]; // limit of 5 users
        int userNum = 0;
        Scanner scanner = new Scanner(System.in); // scanner used to read user input

        /* ========================= */
        // pre-made users + basic tasks for testing purposes
        User user1 = new User("jbean");
        User user2 = new User("icecold");

        user1.addTask("clean");
        user1.addTask("homework");
        user1.addTask("dishes");

        user2.addTask("monster hunter");
        user2.addTask("sweeping");
        user2.addTask("laundry");

        users[userNum++] = user1; // adds jbean
        users[userNum++] = user2; // adds icecold

        /* ========================= */
        while (true) { // creates an infinite loop, showing the user six options to choose from in a menu
            System.out.println("\n1. Create user!\n2. Add task\n3. Mark task completed\n4. View all tasks\n5. Exit");
            System.out.print("Choose the following: ");

            // handling user validation here; any non-integer output will be rejected, unless specified
            int choice;
            try {
                choice = scanner.nextInt();  // read user choice (if 1 is chosen, select create user)
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();  // anytime this is used it's to clear the buffer
                continue;
            }
            scanner.nextLine(); // like so LOL

            /* =============================================================== */
            switch (choice) {                case 1: // Create user
                if (userNum >= users.length) { // checking space for new user in the array above! if full, then breaks
                    System.out.println("User limit has been reached!");
                    break;
                }
                System.out.print("Enter username: ");
                String username = scanner.nextLine();

                if (username.trim().isEmpty()) {
                    System.out.println("Username cannot be empty."); // added validation to prevent empty users
                    break;
                }

                if (userExists(users, username, userNum)) {
                    System.out.println("Username already exists. Please choose a different username."); // prevents duplicate usernames
                    break;
                }

                users[userNum++] = new User(username);
                System.out.println("User added!"); // creates new User object to be added into array
                break;

                /* ========================= */
                case 2: // add task
                    System.out.print("Enter username: ");
                    String addUser = scanner.nextLine();
                    User userAddTask = findUser(users, addUser, userNum); // searches for user in the array, if not found, break
                    if (userAddTask == null) {
                        System.out.println("User not found! Make sure the username is spelled correctly.");
                        break;
                    }
                    System.out.print("What's the task description? Keep short if possible: ");
                    String taskDesc = scanner.nextLine();
                    userAddTask.addTask(taskDesc); // add task to a given user's list
                    System.out.println("Added task!");
                    break;

                /* ========================= */
                case 3: // mark task as completed
                    System.out.print("Enter username: ");
                    String compUser = scanner.nextLine();
                    User userTaskComplete = findUser(users, compUser, userNum);
                    if (userTaskComplete == null) {
                        System.out.println("User not found! Make sure the username is spelled correctly.");
                        break;
                    }
                    System.out.print("Enter task description to mark completion: ");
                    String compTask = scanner.nextLine();
                    boolean taskCompleted = userTaskComplete.completeTask(compTask); // true if task is found and marked as completed
                    if (taskCompleted) {
                        System.out.println("Task completed! Good job.");
                    } else {
                        System.out.println("Task not found or already completed! Make sure task description is correct.");
                    }
                    break;

                /* ========================= */
                case 4: // view tasks
                    System.out.print("Enter username: ");
                    String viewUser = scanner.nextLine();
                    User userToView = findUser(users, viewUser, userNum);
                    if (userToView == null) {
                        System.out.println("User not found! Make sure the username is spelled correctly.");
                        break;
                    }
                    userToView.viewTasks();
                    break;

                /* ========================= */
                case 5: // exit
                    System.out.println("Thanks for trying out the program! Goodbye.");
                    scanner.close();  // closes scanner before program finishes
                    return;

                default:
                    System.out.println("Invalid choice. Please try again."); // happens when inputting wrong option select
            }
        }
    }

    // bonus method to check if the username already exists
    private static boolean userExists(User[] users, String name, int userCount) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // bonus method #2 to help find user by username
    private static User findUser(User[] users, String name, int userCount) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }
}
