import java.util.List;
import java.util.Map;

public class Student {

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

    protected String classroom;
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    protected String[] notes;
    public String[] getNotes() {
        return notes;
    }
    public void setNotes(String[] notes) {
        this.notes = notes;
    }

    protected String parentId;
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    protected Map<String, List<Integer>> grades;
    public Map<String, List<Integer>> getGrades() {
        return grades;
    }
    public void setGrades(Map<String, List<Integer>> grades) {
        this.grades = grades;
    }

    /**
     * If I put the studentId = "S000001" and subject = "math"
     * the method returns all the grades of the student, with the id = studentId, in the specified subject
     *
     * @param studentId the ID of the student whose grades you want to see
     * @param subject   the subject from which the votes are to be obtained
     * @return the grades of the specified student in the specified subject
     */
    public int[] getGrades(String studentId, String subject) {
        return new int[1];
    }

    /**
     * If I put the classroom = "3E" e date = "20/2/2024" the method return all the lessons of the 3E in date 20/2/2024
     *
     * @param classroom the student's class
     * @param date      the date you want to know the lessons
     * @return all the lessons in a certain classroom in the specified date
     */
    public String[][] getLesson(String classroom, String date) {
        return new String[1][1];
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
    public String[][] getAgendaNote(String classroom, String date, int mode) {
        return new String[1][1];
    }

    /**
     * If I put the studentId = "S000001",
     * the method returns the array with all the notes of the student with id = studentId
     *
     * @param studentId the ID of the student whose notes you want to know
     * @return the notes' array of the student
     */
    public String[] getNote(String studentId) {
        return new String[1];
    }

    public void loadInfo(String id, String password, String name, String surname, String[] address, String classroom,
                         Map<String, List<Integer>> grades, String[] notes) {
        setUserId(id);
        setPassword(password);
        setName(name);
        setName(surname);
        setAddress(address);
        setClassroom(classroom);
        setGrades(grades);
        setNotes(notes);
    }
}

/* CHANGELOG
DATE       BRANCH                 AUTHOR     COMMENT
24/03/2024 DeleteRegisterMethod   Nicola     Move from User to this file all the attribute specified for the student
*/
