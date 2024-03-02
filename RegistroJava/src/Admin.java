public class Admin extends User {

    /**
     * If I pass classroom = "3E", the method will return the list of name and surname of the students of the class 3E
     *
     * @return return the list of name and surname of the specified class
     */
    public String[] getClassStudents(String classroom) {
        return new String[1];
    }

    /**
     * This method allows you to view the list of the teachers in the school
     *
     * @return return the list of name and surname of all the teacher
     */
    public String[] getTeachers() {
        return new String[1];
    }

    /**
     * This method allows the teacher to enter a grade for a single student.
     * If I pass studentId = "S000001" and grade = 6,
     * the student with the id = studentId will find the grade passed
     * as a parameter in the grades' list of the subject passed as a parameter
     *
     * @param studentId id of the student we want to add the grade
     * @param subject   the subject where the teacher wants to save the grade
     * @param grade     the grade which we want to add
     */
    public void setGrade(String studentId, String subject, int grade) {

    }

    /**
     * Allow the teacher to view the grades of a student in a subject
     * If I pass studentId = "S000001", subject = "math",
     * the method will return the array of student grades, with id = studentId, in math
     *
     * @param studentId the id of the student whose grades the teacher wants
     * @param subject   the subject in which we are interested in
     * @return the student grades in the specified subject
     */
    public double[] getGrade(String studentId, String subject) {
        return new double[1];
    }

    /**
     * method that allows us to insert lessons
     */
    public String[] setLessons() {
        return new String[1];
    }

    /**
     * allows you to view the lessons completed.
     */
    public String[] getLessons() {
        return new String[1];
    }

    /**
     * method that allows you to view the notice board.
     */
    public String[] getNoticeBoard() {
        return new String[1];
    }

    /**
     * method that allows you to view scheduled events.
     */
    public String[] getEvents() {
        return new String[1];
    }

    /**
     * setAgendaNote: allows you to insert tasks and checks.
     */
    public String[] setAgenda() {
        return new String[1];
    }

    /**
     * allows you to view the contents of the agenda
     */
    public String[] getAgenda() {
        return new String[1];
    }

    /**
     * method that allows you to view documents.
     */
    public String[] getDocuments() {
        return new String[1];
    }

    /**
     * allows you to view report cards
     */
    public String[] getSchoolReport() {
        return new String[1];
    }

    /**
     * View files within the board.
     */
    public String[] getFiles() {
        return new String[1];
    }


    /**
     * The method creates a new Student
     */
    public void setNewUser(String id, String password, String name, String surname, String address, String parentId,
                           String classroom, String[][] grades, String[] notes) {
        // Implementazione per lo Student
    }

    /**
     * The method creates a new Parent
     */
    public void setNewUser(String id, String password, String name, String surname, String address, String childId,
                           String[][] interviews) {

    }

    /**
     * The method creates a new Teacher
     */
    public void setNewUser(String id, String password, String name, String surname, String address, String subject,
                           String[] classrooms) {
        // Implementazione per un utente con un parametro subject
    }

    /**
     * The method creates a new Admin
     */
    public void setNewUser(String id, String password, String name, String surname, String address, String userType) {
        // Implementazione per un utente con un parametro userType
    }
}

