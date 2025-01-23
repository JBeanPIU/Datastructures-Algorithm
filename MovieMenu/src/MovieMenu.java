// Program: A movie theatre menu that allows you to reserve seats, cancel seats, and retrieve initial seating changing
// Date: Jan 23rd, 2025
// By: Cameron Beanland

import java.util.Scanner;

public class MovieMenu {
    /* -- Using this space to insert the rows & columns for seat reservation -- */
    private static final int ROWS = 5; // gives space for the number of rows in the theatre
    private static final int COLUMNS = 5; // shows the number of seats per row, so 25 seats total
    private static char[][] seats = new char[ROWS][COLUMNS]; // seating chart

    /* -- MENU SECTION; basic menu setup & validation -- */
    public static void main(String[] args) {
        createSeats(); // use this to help make all seats available
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View seating arrangements");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel reservation");
            System.out.println("4. Suggest an available seat!");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (!scanner.hasNextInt()) { // validation to ensure program runs as intended
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // if an invalid input occurs, it gets cleared by scanner.next
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeat();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelSeat(scanner);
                    break;
                case 4:
                    suggestSeat();
                    break;
                case 5:
                    System.out.println("Thank you for using our movie services! We hope you enjoy the film.");
                    scanner.close();
                    return;
                default:
                    System.out.println("You can only input numbers between 1 and 4.");
            }
        }
    }

    /* -- METHODS SECTION; most methods from the menu can be found here, in order by which they're seen -- */
    private static void createSeats() { // fills the seats array with default values of 'A', meaning available
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = 'A'; // if 'A', seat is available
            }
        }
    }

    /* ======================================= */
    private static void displaySeat() { // used to see the current seating arrangement
        System.out.println("\nSeating arrangement:");
        System.out.print("  ");
        for (int i = 0; i < COLUMNS; i++) {
            System.out.print((i + 1) + " "); // sets up column labels
        }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print((char) ('A' + i) + " "); // rows in alphabetical order, from A to E using this
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* ======================================= */
    private static void reserveSeat(Scanner scanner) { // this method allows you to reserve seats
        System.out.print("Enter the row (A-E): ");
        String rowInput = scanner.next().toUpperCase();

        if (rowInput.length() != 1 || rowInput.charAt(0) < 'A' || rowInput.charAt(0) > 'E') {
            System.out.println("You may only enter A, B, C, D, or E.");
            return;
        }

        char rowChar = rowInput.charAt(0);
        int row = rowChar - 'A';

        System.out.print("Enter the seat number (1-5): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid. Please enter a number between 1 and 5.");
            scanner.next();
            return;
        }

        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'A') {
                seats[row][col] = 'R'; // if 'R', seat is reserved
                System.out.println("Seat " + rowChar + (col + 1) + " has been reserved.");
            } else {
                System.out.println("Seat " + rowChar + (col + 1) + " is already reserved.");
                suggestSeat();
            }
        } else {
            System.out.println("Invalid. Please try again.");
        }
    }

    /* ======================================= */
    private static void cancelSeat(Scanner scanner) { // not satisfied, or just want to cancel seating? no problem
        System.out.print("Enter the row (A-E): ");
        String rowInput = scanner.next().toUpperCase();

        if (rowInput.length() != 1 || rowInput.charAt(0) < 'A' || rowInput.charAt(0) > 'E') {
            System.out.println("You may only enter A, B, C, D, or E.");
            return;
        }

        char rowChar = rowInput.charAt(0);
        int row = rowChar - 'A';

        System.out.print("Enter the seat number (1-5): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid. Please enter a number between 1 and 5.");
            scanner.next();
            return;
        }

        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'R') {
                seats[row][col] = 'A'; // marks seat as available
                System.out.println("Reservation for seat " + rowChar + (col + 1) + " has been canceled.");
            } else {
                System.out.println("Seat " + rowChar + (col + 1) + " is not reserved.");
            }
        } else {
            System.out.println("Invalid seat. Please try again.");
        }
    }

    /* ======================================= */
    private static void suggestSeat() { // silly feature that suggests available seats to choose from
        System.out.println("Here are some available seats:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (seats[i][j] == 'A') {
                    System.out.println("Row " + (char) ('A' + i) + " Seat " + (j + 1));
                    return; // suggests first available seat
                }
            }
        }
        System.out.println("Sorry! No seats available, must be a good movie.");
    }

    private static boolean isValidSeat(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLUMNS;
    }
}
