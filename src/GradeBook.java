import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
    ArrayList<Student> gradebook = new ArrayList<>();

    // Constructor
    public void addStudent(Student student) {
        gradebook.add(student);
    }

    // This method will find student by PID and change their grade
    public void changeGrade(int pID, int gradeNum) {
        for (Student student : gradebook){
            if (student.getPID() == pID){
                student.setGrade(gradeNum);
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



    /*Method To Do List.....	Yay :'-(
    done changeGrade(int pID, int gradeNum)
	done minScore()
	done minLetter()
	done maxScore()
	done maxLetter()
	getLetterGradeByPID()
	getNameByPID()
	averageScore()
	averageLetter()
	medianScore()
	medianLetter()
	tabScores()
    tabLetters()
    */
}


