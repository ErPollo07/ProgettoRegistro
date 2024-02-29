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
     * This method inserts an argument of a lesson in the specified subject,
     * in the specified date, in the specified classroom in the file Lessons.json
     *
     * @param classroom the classroom that we want to access
     * @param date      the date where we want to write the lessons
     * @param subject   The subject of the lessons
     * @param arg       the argument of the lesson
     */
    public void setLesson(String classroom, String date, String subject, String arg) {

    }

    /**
     *
     * @param classroom
     * @param date
     * @param subject
     * @return
     */
    public String[] getLesson(String classroom, String date, String subject) {
        return new String[1];
    }

    /**
     *
     * @param classroom
     * @param date
     * @return
     */
    public String[][] getLesson(String classroom, String date) {
        return new String[1][1];
    }
}
