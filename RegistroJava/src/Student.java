public class Student extends User {

    /**
     * If I put the studentId = "S000001" and subject = "math"
     * the method returns all the grades of the student, with the id = studentId, in the specified subject
     * @param studentId the ID of the student whose grades you want to see
     * @param subject the subject from which the votes are to be obtained
     * @return the grades of the specified student in the specified subject
     */
    public int[] getGrades(String studentId, String subject) {
        return new int[1];
    }

    /**
     * If I put the classroom = "3E" e date = "20/2/2024" the method return all the lessons of the 3E in date 20/2/2024
     *
     * @param classroom the student's class
     * @param date the date you want to know the lessons
     * @return all the lessons in a certain classroom in the specified date
     */
    public String[][] getLesson(String classroom, String date) {
        return new String[1][1];
    }
}
