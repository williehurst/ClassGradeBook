import java.util.ArrayList;
import java.lang.Character;
import java.util.Scanner;

public class TestUserInputs {

    // method to make sure user input is correct format
    public static Student testInputs(String userInput) {
        final String TRY_AGAIN_MESSAGE = "Please try again using correct format\n\"firstName lastName PID grade\":"; // Try Again Message
        Scanner keyboard = new Scanner(System.in); // Scanner fo user input in loop.
        boolean isCorrectFormat = true; // boolean to store bool if user used correct format
        String[] usersInputSplit = userInput.split(" ");// Split up user input for testing
        String strFirstName = usersInputSplit[0];
        String strLastName = usersInputSplit[1];
        String strPID = usersInputSplit[2]; // PID
        String strGrade = usersInputSplit[3];

        // This is the beginning of the input validation loop.
        do {// This loop will continue until correct input format is entered
            if ((!(isCorrectFormat))) { // after loop this message will show if incorrect input detected
                System.out.println(TRY_AGAIN_MESSAGE);
                userInput = keyboard.nextLine();
                usersInputSplit = userInput.split(" ");// Split up user input for testing

                // Store the first four words/number again combos from user's input into Str Variables for readability
                strFirstName = usersInputSplit[0];
                strLastName = usersInputSplit[1];
                strPID = usersInputSplit[2]; // PID
                strGrade = usersInputSplit[3];
            }

            // Several tests on the different words and numbers input by the user to ensure they're valid.
            if (!(TestUserInputs.checkNameEntry(strFirstName))) {// First name format check
                isCorrectFormat = false;
            } else if(!(TestUserInputs.checkNameEntry(strLastName, 'l'))) {// Last name format check
                isCorrectFormat = false;
            } else if (!(TestUserInputs.checkPIDEntry(strPID))) {// PID format check
                isCorrectFormat = false;
            } else if (!(TestUserInputs.checkGradeEntry(strGrade))) {// PID format check
                isCorrectFormat = false;
            } else {
                isCorrectFormat = true; // if all checks passed then flag changed to true to exit loop
            }
        } while (!(isCorrectFormat));

        // create and return student object
        Grade grade = new Grade(Integer.parseInt(strGrade)); // turn String grade into Grade Obj.
        return new Student(
                strFirstName,
                strLastName,
                Integer.parseInt(strPID),
                grade
        );
    }

    // Method to verify Name input is correct
    private static boolean checkNameEntry(String userInput) {
        char[] chars = userInput.toCharArray();
        if (!(Character.isUpperCase(chars[0]))) { // Make sure first letter is upper case
            return false;
        }
        for (char nextChar : chars) {
            if (!(Character.isLetter(nextChar))) { // Make sure name is only letters
                return false;
            }
        }
        return true;
    }

    // Overloaded method to verify Last Name input is correct
    private static boolean checkNameEntry(String userInput, char lastNameFlag) {
        char[] chars = userInput.toCharArray();
        boolean hasPeriod = false;
        if (!(Character.isUpperCase(chars[0]))) {
            return false;
        }
        for (char nextChar : chars) {
            if (nextChar == '.') { // check and allow one period
                hasPeriod = true;
            }else if (hasPeriod) {
                return false;
            }
        }
        return true;
    }

    // Method to verify PID input is correct
    public static boolean checkPIDEntry(String userInput){
        char[] chars = userInput.toCharArray();
        if (Character.compare(chars[0], '0') == 0) { // Make sure PID is 7 digits
            return false;
        }
        if (!(chars.length == 7)) { // Make sure PID is 7 digits
            return false;
        }
        for (char nextChar : chars) {
            if (!(Character.isDigit(nextChar))) { // Make sure PID doesn't have non-number characters
                return false;
            }
        }
        return true;
    }

    // Method to verify Grade input is correct
    private static boolean checkGradeEntry(String userInput) {
        if (!(userInput.matches("[0-9]+"))){ // Make sure user input is a number
            return false;
        }
        int userInputAsInt = Integer.parseInt(userInput); // switch input from String to Integer
        return (userInputAsInt >= 0) && (userInputAsInt <= 100);// make sure Grade is not negative & <= 100
    }



}
