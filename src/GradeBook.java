import java.util.ArrayList;
import java.util.Collections;

public class GradeBook {
    ArrayList<Student> gradebook = new ArrayList<>();
    .ge;

    // Constructor
    public void addStudent(Student student) {
        gradebook.add(student);
    }

    // This method will find student by PID and change their grade
    public void changeGrade(int pID, int gradeNum) {
        for (Student student : gradebook){
            if (student.getPID() == pID){
                student.setGrade(gradeNum);
            } else {
                System.out.println("Please try again, that PID couldn't be found."); // if we can't find PID then return this message
            }
        }
    }

    // This method will find the lowest score in class
    public int minScore(){
        int lowestGrade = 0;
        for (Student student : gradebook){
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
        for (Student student : gradebook){
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
        for (Student student : gradebook){
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
        for (Student student : gradebook) {
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
        for (Student student : gradebook){
            if (student.getPID() == pID){
                letter = student.getLetterGrade();
            } else {
                letter = "PID not found in grade book"; // if we can't find PID then return this message
            }
        }
        return letter;
    }

    // This method will get the name by looking up PID
    public String getName(int pID) {
        String name = null;
        for (Student student : gradebook){
            if (student.getPID() == pID){
                name = student.getFirstName() + " " + student.getLastName();
            } else {
                name = "PID not found in grade book"; // if we can't find PID then return this message
            }
        }
        return name;
    }

    // This method will get the average score of class
    public double average(){
        double totalOfGrades = 0;
        double averageOfGrades = 0;
        for (Student student : gradebook) {
            totalOfGrades =+ student.getNumberGrade(); // add up all Student's grade
        }
        averageOfGrades = totalOfGrades / gradebook.size(); //calc average
        return averageOfGrades;
    }

   // This method will find the median score
    public double median() {
        double medianGrade;
        ArrayList<Integer> classGrades = new ArrayList<>();// list to hold class grades
        for (Student student : gradebook){ // add class grades to list
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
        for (Student student : gradebook){ // add class grades to list
            classGrades.add(student.getLetterGrade());
        }
        Collections.sort(classGrades); // sort class grades in order
        medianLetter = classGrades.get((classGrades.size()/2)); //Return middle grade

        return medianLetter;
    }

    // This method will print out a table of students with last column showing grade number
    public void tabScores() {
        for (Student student : gradebook) {
            System.out.println(student.getFirstName() + "\t"
                            + student.getLastName() + "\t"
                            + student.getPID() + "\t"
                            + student.getNumberGrade());
        }
    }

    // This method will print out a table of students with last column showing letter grade
    public void tabLetters() {
        for (Student student : gradebook) {
            System.out.println(student.getFirstName() + "\t"
                            + student.getLastName() + "\t"
                            + student.getPID() + "\t"
                            + student.getLetterGrade());
        }
    }
}


