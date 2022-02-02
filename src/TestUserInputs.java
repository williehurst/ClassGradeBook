import java.util.ArrayList;
import java.lang.Character;

public class TestUserInputs {

    public static void showPrintOut(String userInput) {
        System.out.println();
        System.out.println("*Testing String Output*\nUser input is as follows: " + userInput);
        System.out.println("\n");
    }

    public static void showPrintOut(String[] userInput) {
        int indexPlace = 0;
        System.out.println();
        System.out.println("*Testing String[] Output*\nUser input is as follows:");
        for (String words : userInput) {
            System.out.println("Index [" + indexPlace + "]: " + words);
            indexPlace++;
        }
        System.out.println();
    }

    public static boolean checkNameEntry(String userInput) {
        char[] chars = userInput.toCharArray();
        if (!(Character.isUpperCase(chars[0]))) {
            return false;
        }
        for (char nextChar : chars) {
          if (Character.isWhitespace(nextChar)){
              return false;
          } else if (!(Character.isLetter(nextChar))) {
                return false;
            }
        }
        return true;
    }

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

}
