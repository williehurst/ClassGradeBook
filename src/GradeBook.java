import java.util.ArrayList;
import java.util.Collections;

public class GradeBook {
    ArrayList<Student> gradeBook = new ArrayList<>();
    ArrayList<Integer> listOfStudentsPIDs = new ArrayList<>();


    // Constructor
    // GradeBook will use the default Constructor.

    // Method adds student to grade book after checking that PID doesn't already exist
    public void addStudent(Student student) {
        boolean pIDAlreadyUsed = false; // PID already used flag
        for (int pID : listOfStudentsPIDs) {
            if (student.getPID() == pID){ // compare PID with list of existing PIDs in gradebook
                System.out.println("Sorry nothing was added; the PID you typed was already in grade book. Try Again\n");
                pIDAlreadyUsed = true;
                break;
            }
        }
        if (!pIDAlreadyUsed) {
            gradeBook.add(student);
            listOfStudentsPIDs.add(student.getPID());
        }
    }

    // This method will find student by PID and change their grade
    public void changeGrade(String pID, String gradeNum) {
        boolean pIDIsFound = false;
        for (Student student : gradeBook){
            if (student.getPID() == Integer.parseInt(pID)){
                student.setGrade(Integer.parseInt(gradeNum));
                System.out.println(pID + "'s grade has been changed to " + gradeNum);
                pIDIsFound = true;
                break;
            }
        }
        if (!pIDIsFound) {
            System.out.println("Please try again, that PID couldn't be found."); // if we can't find PID then return this message
        }
    }

    // This method will find student by PID and Delete their entire entry.
    public void removeStudent(String pID) {
        Student studentToRemove = null;
        for (Student student : gradeBook){
            if (student.getPID() == Integer.parseInt(pID)){
                studentToRemove = student;
                System.out.println(pID + "'s grade book entry has been deleted."); // let user delete was successful
            } else {
                System.out.println("Please try again, that PID couldn't be found."); // if we can't find PID then return this message
            }
        }
        gradeBook.remove(studentToRemove); // Remove the student from grade book.
    }

    // This method will find the lowest score in class
    public int minScore(){
        int lowestGrade = 0;
        for (Student student : gradeBook){
            if (student.getNumberGrade() < lowestGrade) {
                lowestGrade = student.getNumberGrade();
            }
        }
        return lowestGrade;
    }

    // This method will find the lowest letter score in class
    public String minLetter(){
        int lowestGrade = 0;
        String lowestLetter = "A";
        for (Student student : gradeBook){
            if (student.getLetterGrade().equals("F")) // Stop loop once someone has an F.
                return "F";
            if (student.getNumberGrade() < lowestGrade) { // Check for lowest grade
                lowestGrade = student.getNumberGrade();
                lowestLetter = student.getLetterGrade();
            }
        }
        return lowestLetter;
    }

    // This method will find the highest score in class
    public int maxScore(){
        int highestGrade = 0;
        for (Student student : gradeBook){
            if (student.getNumberGrade() > highestGrade) {
                highestGrade = student.getNumberGrade();
            }
        }
        return highestGrade;
    }

    // This method will find the highest letter score in class
    public String maxLetter() {
        int highestGrade = 0;
        String highestLetter = "D";
        for (Student student : gradeBook) {
            if (student.getLetterGrade().equals("A")) // Stop loop once someone has an A.
                return "A";
            if (student.getNumberGrade() > highestGrade) { // Check for lowest grade
                highestGrade = student.getNumberGrade();
                highestLetter = student.getLetterGrade();
            }
        }
        return highestLetter;
    }

    // This method will get the letter grade by looking up PID
    public String getLetterGrade(int pID) {
        String letter = null;
        for (Student student : gradeBook){
            if (student.getPID() == pID){
                letter = student.getLetterGrade();
            } else {
                letter = "PID not found in grade book"; // if we can't find PID then return this message
            }
        }
        return letter;
    }

    // This method will get the grade by looking up PID in int format
    public String getGrade(int pID) {
        String grade = null;
        for (Student student : gradeBook){
            if (student.getPID() == pID){
                grade = student.getLetterGrade();
            } else {
                grade = "Not found in grade book with PID you entered"; // if we can't find PID then return this message
            }
        }
        return grade;
    }

    // This method will get the grade by looking up PID in String format
    public String getGrade(String pID) {
        String grade = null;
        for (Student student : gradeBook){
            if (student.getPID() == Integer.parseInt(pID)){
                grade = student.getLetterGrade();
            } else {
                grade = "Not found in grade book with PID you entered"; // if we can't find PID then return this message
            }
        }
        return grade;
    }

    // This method will get the name by looking up PID
    public String getName(String pID) {
        String name = null;
        for (Student student : gradeBook){
            if (student.getPID() == Integer.parseInt(pID)){
                name = student.getFirstName() + " " + student.getLastName();
            } else {
                name = "Not found in grade book with PID you entered"; // if we can't find PID then return this message
            }
        }
        return name;
    }

    // This method will get the average score of class
    public double average(){
        double totalOfGrades = 0;
        double averageOfGrades = 0;
        for (Student student : gradeBook) {
            totalOfGrades += student.getNumberGrade(); // add up all Student's grade
        }
        averageOfGrades = totalOfGrades / gradeBook.size(); //calc average
        return averageOfGrades;
    }

    // This method will get the average letter grade of class
    public String averageLetter() {
        double totalOfGrades = 0;
        double averageOfGrades = 0;
        for (Student student : gradeBook) {
            totalOfGrades += student.getNumberGrade(); // add up all Student's grade
        }
        averageOfGrades = totalOfGrades / gradeBook.size(); //calc average
        return Grade.gradeScoreToLetter(averageOfGrades); // convert average grade to letter grade and return.
    }

   // This method will find the median score
    public double median() {
        double medianGrade;
        ArrayList<Integer> classGrades = new ArrayList<>();// list to hold class grades
        for (Student student : gradeBook){ // add class grades to list
            classGrades.add(student.getNumberGrade());
        }
        Collections.sort(classGrades); // sort class grades in order

        if ((classGrades.size() % 2) == 0) { // If there are even amount of grades use this algo
            int medianGrade1 = classGrades.get((classGrades.size()/2)-1);
            int medianGrade2 = classGrades.get(classGrades.size()/2);
            medianGrade = (double)(medianGrade1 + medianGrade2) / 2;
        } else { // if odd number of grades use this algo
            medianGrade = classGrades.get((classGrades.size()/2));
        }
        return medianGrade;
    }

    // This method will find the median letter grade
    public String medianLetter() {
        String medianLetter;
        ArrayList<String> classGrades = new ArrayList<>();// list to hold class grades
        for (Student student : gradeBook){ // add class grades to list
            classGrades.add(student.getLetterGrade());
        }
        Collections.sort(classGrades); // sort class grades in order
        medianLetter = classGrades.get((classGrades.size()/2)); //Return middle grade

        return medianLetter;
    }

    // This method will print out a table of students with last column showing grade number
    public void tabScores() {
        if (gradeBook.size() == 0) {
            System.out.println("There are no students in the grade book.");
        } else {
            for (Student student : gradeBook) {
                System.out.println(student.getFirstName() + "\t"
                        + student.getLastName() + "\t"
                        + student.getPID() + "\t"
                        + student.getNumberGrade());
            }
        }
    }

    // This method will print out a table of students with last column showing letter grade
    public void tabLetters() {
        if (gradeBook.size() == 0) {
            System.out.println("There are no students in the grade book.");
        } else {
            for (Student student : gradeBook) {
                System.out.println(student.getFirstName() + "\t"
                        + student.getLastName() + "\t"
                        + student.getPID() + "\t"
                        + student.getLetterGrade());
            }
        }
    }
}


