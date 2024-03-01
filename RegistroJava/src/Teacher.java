public class Teacher extends User {

    /**
     * This method put the grade on the array of grades of
     * the specified subject of the user with id equals to studentId.
     *
     * @param grade     the grade we want to insert
     * @param studentId The id of the studend who vwe want to put the grade
     * @param subject   The subject of where to put the grade
     */
    public void setGrade(int grade, String studentId, String subject) {
    }

    /**
     * This method return the grades of the subject of
     * the user who has the id equals to studentId.
     *
     * @param studentId the studentId
     * @param subject   the subject which we are interested
     * @return all the grade of the subject of the user.
     */
    public int[] getGrades(String studentId, String subject) {
        return new int[1];
    }

    /**
     * If I put the classroom = "3E", the date = "20/2/2024" the hour = "3".
     * If in the Lessons.json there is:
     *
     *
     * @param classroom
     * @param date
     */
    public void setLessons(String classroom, String date, String hour) {
    }

    /**
     * If I put the classroom = "3E" e date = "20/2/2024" the method return all the lessons of the 3E in date 20/2/2024
     *
     * @param classroom
     * @param date
     * @return all the lessons in a centain classroom in the speciied date
     */
    public String[][] getLesson(String classroom, String date) {
        return new String[1][1];
    }
}