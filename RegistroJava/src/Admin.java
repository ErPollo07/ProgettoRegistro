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
     * The method creates a new Student
     */
    public void setNewUser(String id, String password, String name, String surname, String address, String parentId,
                           String classroom, String[][] grades, String[] notes) {
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
    }
}

