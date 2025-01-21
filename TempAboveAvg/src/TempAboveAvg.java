// Project: A simple Java class that when ran, can be used to calculate average temp and give how many days are above the average temp
// Date:    Jan 20th, 2025
// By:      Cameron Beanland

/* ================================================================================ */

import java.util.Scanner;
import java.util.InputMismatchException;

public class TempAboveAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // Start off by getting user input! (asking for amount of temps to a max of 5, otherwise keeps looping)
        while (true) {
            System.out.print("Enter the number of temps (5 max): ");
            try {
                n = scanner.nextInt();

                // Check if input is within valid range
                if (n >= 1 && n <= 5) {
                    break; // Exit loop if input = valid
                } else {
                    System.out.println("Please enter a valid number from 1 to 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid inputt
            }
        }

        // Array to store up to 'n' temperatures, where 'n' is the number of inputs the user specified.
        double[] temperatures = new double[n];

        /* ======================================= */

        // Continue user input; user will now enter all temp values
        System.out.println("Please enter temps: ");
        double total = 0;

        for (int i = 0; i < n; i++) {
            while (true) { // Loop until a valid temperature is entered
                System.out.print("Temp " + (i + 1) + ": ");
                try {
                    temperatures[i] = scanner.nextDouble();
                    total += temperatures[i];
                    break; // Exit the loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric temperature.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }

        // Calculate average temp
        double average = total / n;
        System.out.println("\nAverage Temp: " + average); // This line helps with clarity

        // How many temps are above average? This method keeps track of that
        int countAboveAvg = 0;
        System.out.println("\nTemperatures above average:");
        for (double temp : temperatures) {
            if (temp > average) {
                countAboveAvg++;
                System.out.println(temp);
            }
        }

        System.out.println("\nNumber of days above average: " + countAboveAvg);

        // Close the Scanner object to prevent resource leaks
        scanner.close();
    }
}

// extra notes down here for myself

/* In terms of array creation, [n] and [i] have different uses, both of which are shown in this assignment!

    - [n] is used to determine size of array, which is dynamic (because it's usually decided by user,
      in this case that's the temperature).
    - [i] is an index that starts from 0, and allows access to specific positions in an array, so
      as the loop runs, [i] can change, which allows us to assign values to each position in the array.

      Example of [i] because I'm terrible at explaining LOL:

      - When i = 0: The first user input is stored in temperatures[0].
      - When i = 1: The second user input is stored in temperatures[1].

      This pretty much keeps going until i = n - 1, for example.
 */
