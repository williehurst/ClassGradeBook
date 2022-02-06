import java.util.Scanner;

public class Main {
    public static void main(String[] Args) {
        Scanner keyboard = new Scanner(System.in); // Scanner to capture user's keyboard
        String userInput; // Variable to store user input.

        // Before we give user any other option we need students input
        System.out.println("""
                Welcome to my grade book!
                Please enter the information of the first student using the following format: "firstName lastName PID grade".
                Press Enter when you are done:
                """);
        userInput = keyboard.nextLine();
        isQuit(userInput); // check if user wants to quit. if userInput is true, app closes.

        // Test user input and then add first student object into grade book.
        GradeBook gradeBook = new GradeBook(); // Grade book created to store students
        gradeBook.addStudent(TestUserInputs.testInputs(userInput)); // validate user input and add 1st student

        // Use method that gets more students and adds them to gradebook
        addStudentToGradeBook(gradeBook);

        // Ask user what would they like to do next and present options
        do {
            menu(); // Uses the method that displays the menu of options to user
            userInput = keyboard.nextLine();

            // start menu selection logic
            menuSelection(userInput, gradeBook);

            // After user leaves the menu ask if they want to leave or start menu method again.
            System.out.println("\nType quit and hit enter to quit. Or just press enter to go back to menu.");
            userInput = keyboard.nextLine();

        } while (!userInput.equalsIgnoreCase("quit")); // keep presenting menu until user types quit.
        isQuit(userInput); // if user types quit then end app.
    }

    //// Main class' methods////

    // Method to quit app
    static void isQuit(String userInput) {
        if (userInput.equalsIgnoreCase("Quit")) {// If user enters quit then exit app.
            System.exit(0);
        }

    }

    // Method to get additional students
    public static void addStudentToGradeBook(GradeBook gradeBook) {
        Scanner keyboard = new Scanner(System.in);
        String userInput;
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
    }

    // Method to display menu
    public static void menu(){
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
                11. Class median letter grade
                12. Table of students scores
                13. Table of students letter grades
                15. Add more students
                16. Quit
                """);
    }

    // Method to let use select an option
    public static void menuSelection(String userInput, GradeBook gradeBook) {
        Scanner keyboard = new Scanner(System.in);
        switch (userInput) {
            case "1":
                System.out.println("The lowest class grade: " + gradeBook.minScore());
                break;
            case "2":
                System.out.println("The lowest class letter grade: " + gradeBook.minLetter());
                break;
            case "3":
                System.out.println("The highest class grade: " + gradeBook.maxScore());
                break;
            case "4":
                System.out.println("The highest letter class grade: " + gradeBook.maxLetter());
                break;
            case "5":
                System.out.print("Please enter a PID: ");
                userInput = keyboard.nextLine(); // get PID
                String validPID = TestUserInputs.checkAndReturnPID(userInput);
                System.out.println(validPID + "'s grade is: " + gradeBook.getGrade(validPID)); // display grade
                break;
            case "6":
                System.out.print("Please enter a PID: ");
                userInput = keyboard.nextLine(); // get PID
                String validPIDForName = TestUserInputs.checkAndReturnPID(userInput);
                System.out.println(validPIDForName + "'s name is: " + gradeBook.getName(validPIDForName)); // display grade
                break;
            case "7":
                System.out.print("""
                            Please enter a PID and then grade in this format.
                            XXXXXXX YY
                            X's are the PID and Y's are new grade:\s""");
                userInput = keyboard.nextLine(); // get PID
                String validPIDAndGrade = TestUserInputs.checkAndReturnPIDGrade(userInput); // String that contains PID and grade
                gradeBook.changeGrade(validPIDAndGrade.split(" ")[0], validPIDAndGrade.split(" ")[1]);
                System.out.println(validPIDAndGrade.split(" ")[0] + "'s grade has been changed to " + validPIDAndGrade.split(" ")[1]);
                break;
            case "8":
                System.out.println("The class average grade is: " + gradeBook.average());
                break;
            case "9":
                System.out.println("The class average grade is: " + gradeBook.averageLetter());
                break;
            case "10":
                System.out.println("The class median grade is: " + gradeBook.median());
                break;
            case "11":
                System.out.println("The class median grade is: " + gradeBook.medianLetter());
                break;
            case "12":
                gradeBook.tabScores();
                break;
            case "13":
                gradeBook.tabLetters();
                break;
            case "14":
                System.exit(0);
                break;
            case "15":
                addStudentToGradeBook(gradeBook);
                break;
            case "16":
                System.exit(0);
            case "Quit":
                System.exit(0);
            default:
                System.out.println("Invalid choice, try again.");
                break;
        }
    }
}


