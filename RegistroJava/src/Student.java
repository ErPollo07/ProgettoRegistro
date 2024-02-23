public class Student extends User {

    /*
        This class is for handle all the function that a student can do
        */
    int[] marks;

    /* CONSTRUCTOR */
    Student(String username, String password) {
        super(username, password);
    }

    /* GETTERS AND SETTERS FOR MARKS */
    public int[] getMarks() {
        return marks;
    }
    /**
     * Set the pointer of the student's marks equal to new marks
     * @param newMarks array of new marks
     */
    public void setMarks(int[] newMarks) {
        this.marks = newMarks;
    }
    /* END GETTERS AND SETTERS FOR MARKS */
}
