/**
 * The Student Class holds information about the individual students.
 * Each student has a first, last name, Panther ID and grade
 */
public class Student {
    private String firstName;
	private String lastName;
	private int pID;
    private Grade grade;

    // constructor
    public Student(String firstName, String lastName, int pID, Grade grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pID = pID;
        this.grade = grade;
    }

    // Method gets letter grade
    public String getLetterGrade(){
        return grade.getLetterGrade();
    }

    // this method get number grade as an integer
    public int getNumberGrade(){
        return grade.getGrade();
    }

    // Get student's first name
    public String getFirstName(){
        return firstName;
    }

    // Get Students last name
    public String getLastName(){
        return lastName;
    }

    // Get Students Panther ID
    public int getPID(){
        return pID;
    }

    // Change number grade
    public void setGrade(int newGrade){
        grade.setGrade(newGrade);
    }
}
