import common.IRunnable;
import common.InputValidator;
import lab1.Lab1;
import lab2.Lab2;
import lab3.Lab3;
import lab4.Lab4;
import lab5.Lab5;

public class App {
    public static void main(String[] args) throws Exception {
         while (true) { // Infinite loop until exit condition is met
            // Display the menu to the user
            System.out.println("Choose a lab to run:");
            System.out.println("1. Lab 1");
            System.out.println("2. Lab 2");
            System.out.println("3. Lab 3");
            System.out.println("4. Lab 4");
            System.out.println("5. Lab 5");
            System.out.println("0. Exit");

            // Read the user's choice (validation already handled by InputValidator)
            int choice = InputValidator.readInt(true);

            // Exit condition
            if (choice == 0) {
                System.out.println("Exiting program.");
                break; // Exit the loop and terminate the program
            }

            // Declare a variable for the lab that will be run
            IRunnable lab = null;

            // Instantiate the selected lab
            switch (choice) {
                case 1:
                    lab = new Lab1();
                    break;
                case 2:
                    lab = new Lab2();
                    break;
                case 3:
                    lab = new Lab3();
                    break;
                case 4:
                    lab = new Lab4();
                    break;
                case 5:
                    lab = new Lab5();
                    break;
                default:
                    // Invalid choice: Retry
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Go back to the start of the loop to prompt for a valid choice
            }

            // Run the selected lab
            lab.run();
        }
    }
}

