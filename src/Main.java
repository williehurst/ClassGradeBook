import java.util.Scanner;

public class Main {
    public static void main(String[] Args) {
        Scanner keyboard = new Scanner(System.in); // Scanner to capture user's keyboard
        String userInput; // Store user input for Algo's.

        // Before we give user any other option we need students input

        System.out.println("""
                Welcome to my grade book!
                Please enter the information of the first student using the following format: "firstName lastName PID grade".
                Press Enter when you are done:
                """);
        userInput = keyboard.nextLine();
        isQuit(userInput); // check if user wants to quit

        // Test user input and then add first student object into grade book.
        GradeBook gradeBook = new GradeBook(); // Grade book created to store students
        gradeBook.addStudent(TestUserInputs.testInputs(userInput)); // validate user input and add 1st student

        do {
            System.out.println("""
                    Please enter the information of the next student using the same format.
                    If there is no more students, please enter the keyword “DONE”.
                    Press Enter when you are done.
                    """);
            userInput = keyboard.nextLine();
            isQuit(userInput); // check if user wants to quit
            if (userInput.toUpperCase().equals("DONE")) {// If user enters done then exit loop.
                break;
            }
            gradeBook.addStudent(TestUserInputs.testInputs(userInput));
        } while (!(userInput.equalsIgnoreCase("DONE"))); // Check if user says done

        // Ask user what would they like to do next and present options
        System.out.println("""
                Please choose a command by entering menu number and pressing enter.
                1. Minimum score of class
                2. Minimum letter grade of class
                3. Max score of class
                4. Max letter grade of class
                5. Look up student letter grade by PID
                6. Look up student name by PID
                7. Look up by PID and change student grade
                8. Class average Score
                9. Class average letter grade
                10. Class median grade
                11. Table of students
                12. Quit
                """);

        userInput = keyboard.nextLine();

    }

    // Option menu method
    static void menu(String userInput){
        switch (userInput) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            case "9":
                break;
            case "10":
                break;
            case "11":
                break;
            case "12":
                System.exit(0);
                break;
            case "Quit":
                System.exit(0);
            default:
                System.out.println("Invalid choice, try again.");
                break;
        }
    }

    // Method to quit app
    static void isQuit(String userInput) {
        if (userInput.equalsIgnoreCase("Quit")) {// If user enters quit then exit app.
            System.exit(0);
        }

    }

    // Method is the logic to change grade
    /*boolean isValidInput = true; // flag to see if input is valid PID
        String userInput; // to hold user's response for validation
        Scanner keyboard = new Scanner(System.in);
        userInput = keyboard.nextLine();
        do {
            if (!(TestUserInputs.checkPIDEntry(pID))){
                isValidInput = false;
                System.out.println("Please enter 7 digit PID.");
            }
        } while (!(isValidInput)); // If isValid flag is false keep looping
        */// <---- I need to remove this logic from Gradbook method to Main.

}


