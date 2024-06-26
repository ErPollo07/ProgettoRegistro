public class Teacher {

    protected String userId;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    protected String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    protected String surname;
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    protected String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    protected String[] address;
    public String[] getAddress() {
        return address;
    }
    public void setAddress(String[] address) {
        this.address = address;
    }

    protected String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    protected String[] classrooms;
    public String[] getClassrooms() {
        return classrooms;
    }
    public void setClassrooms(String[] classrooms) {
        this.classrooms = classrooms;
    }

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
     * @return all the lessons in a certain classroom in the speciied date
     */
    public String[][] getLesson(String classroom, String date) {
        return new String[1][1];
    }

    /**
     * Set in a specific date an argument
     *
     * @param classroom the classroom where we want to put the argument
     * @param date      the date where we want to add the argument
     */
    public void setAgendaNote(String classroom, String date) {

    }

    /**
     * if I put mode = 0 and date = "22/02/2024" the method will return all the argument for the month of the date
     * if I put mode = 1 and date = "22/02/2024" the method will return all the argument for the specified date
     *
     * @param classroom the classroom where we want to add the argument
     * @param date      the date where we want to add the argumnet
     * @param mode      what we want to visualize
     * @return in base off the mode passed return the arguments of the month or the day
     */
    public String getAgendaNote(String classroom, String date, int mode) {
        return "";
    }

    /**
     * Add a school report to the student with the id equals to studentId
     * If I put classroom = "3E", studentId = "S000001" and the arg "arg",
     * the student with the id equals to studentId will get a note.
     *
     * @param classroom the classroom of the student
     * @param studentId the id of the student to whom you want to send the note
     * @param arg       the note
     */
    public void setNoteToStudent(String classroom, String studentId, String arg) {

    }
}

/* CHANGELOG
DATE       BRANCH                 AUTHOR     COMMENT
24/03/2024 DeleteRegisterMethod   Nicola     Move from User to this file all the attribute specified for the teacher
*/