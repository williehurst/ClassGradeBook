public class Grade {
    private int grade;

    // constructor for int grade
    public Grade(int grade){
        this.grade = grade;
    }

    // overloaded constructor for string type
    public Grade(String grade){
        this.grade = Integer.parseInt(grade);
    }

    // set grade method
    public void setGrade(int grade){
        this.grade = grade;
    }

    // method to return grade number
    public int getGrade(){
        return grade;}

    // Method to return grade letter
    public String getLetterGrade() {
        String letterGrade;
        if (grade >= 90) {
            letterGrade = "A";
        } else if ((grade < 90) && (grade >= 85)) {
            letterGrade = "A-";
        } else if ((grade < 85) && (grade >= 80)) {
            letterGrade = "B+";
        } else if ((grade < 80) && (grade >= 75)) {
            letterGrade = "B";
        } else if ((grade < 75) && (grade >= 70)) {
            letterGrade = "B-";
        } else if ((grade < 70) && (grade >= 65)) {
            letterGrade = "C+";
        } else if ((grade < 65) && (grade >= 60)) {
            letterGrade = "C";
        } else if ((grade < 60) && (grade >= 50)) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }
}
