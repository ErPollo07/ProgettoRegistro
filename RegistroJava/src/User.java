import java.util.List;
import java.util.Map;

public class User {

    private String userId;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String surname;
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private String parentId;
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    private String childId;
    public String getChildId() {
        return childId;
    }
    public void setChildId(String childId) {
        this.childId = childId;
    }

    private String[] address;
    public String[] getAddress() {
        return address;
    }
    public void setAddress(String[] address) {
        this.address = address;
    }

    private String classroom;
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    private Map<String, List<Integer>> grades;
    public Map<String, List<Integer>> getGrades() {
        return grades;
    }
    public void setGrades(Map<String, List<Integer>> grades) {
        this.grades = grades;
    }

    private String[] notes;
    public String[] getNotes() {
        return notes;
    }
    public void setNotes(String[] notes) {
        this.notes = notes;
    }

    private String[][] interviews;
    public String[][] getInterviews() {
        return interviews;
    }
    public void setInterviews(String[][] interviews) {
        this.interviews = interviews;
    }

    private String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String[] classrooms;
    public String[] getClassrooms() {
        return classrooms;
    }
    public void setClassrooms(String[] classrooms) {
        this.classrooms = classrooms;
    }

}

/* CHANGELOG
DATE       BRANCH                 AUTHOR     COMMENT
19/03/2024 DeleteRegisterMethod   Nicola     Generate all the getters and setters for all the variable
*/