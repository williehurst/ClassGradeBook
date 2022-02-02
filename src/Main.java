import java.util.Scanner;

public class Main {

    // Method to clear screen
    static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



    public static void main(String[] Args){

        final String TRY_AGAIN_MESSAGE = "Please try again using correct format"; // Try Again Message
        Scanner keyboard = new Scanner(System.in); // Scanner to capture user's keyboard
        String userInput; // Store user input for Algo's.

        // Before we give user any other option we need students input
        do {
            System.out.println("""
                            Welcome to my grade book!
                            Please enter the information of the first student using the following format: "firstName lastName PID grade".
                            Press Enter when you are done
                            """);

            userInput = keyboard.nextLine();
            String[] usersInputSplit = userInput.split(" ");// Split up user input for testing

            // make sure input is in correct format
            if (!(TestUserInputs.checkNameEntry(usersInputSplit[0])))// First name format check
                System.out.println(TRY_AGAIN_MESSAGE);
            if (!(TestUserInputs.checkNameEntry(usersInputSplit[1])))// Last name format check
                System.out.println(TRY_AGAIN_MESSAGE);
            if (!(TestUserInputs.checkPIDEntry(usersInputSplit[2])))// PID format check
                System.out.println(TRY_AGAIN_MESSAGE);


            // Developer's printout test for user inputs (Comment out before final build)
            //TestUserInputs.showPrintOut(usersInputSplit);
            //TestUserInputs.showPrintOut(userInput);

        } while (!userInput.equals("Done"));

        boolean quitProgramFlag = false; // if the phrase "quit" is input, program will end
        do {
            // Ask for next students until we see the word done
            boolean endLoopFlag = false; // Flag that will wait for user input "DONE".
            while (!endLoopFlag) {
                System.out.println("""
                                Welcome to my grade book!
                                Please enter the information of the first student using the following format: "firstName lastName PID grade".
                                Press Enter when you are done""");
            }
        } while (!userInput.equals("Quit"));
    }
}
