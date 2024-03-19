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
    public String[] getClassrooms() {
        return classrooms;
    }
    public void setClassrooms(String[] classrooms) {
        this.classrooms = classrooms;
    }

    private String grades;
    public String getGrades() {
        return grades;
    }
    public void setGrades(String grades) {
        this.grades = grades;
    }

    private String notes;
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
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

    /**
     * Set a new name for the user with id equals to the first param
     * Es - My name is "nicola" in file User.json, if I call the function
     * and I put the parameter "giancarlo", my name now will be "giancarlo"
     *
     * @param name new name for the user
     */
    public void setName(String name, String id) {
    }

    /**
     * The method gives the name of the user with id equals to the first param.
     * Check if the userId is an id of an admin,
     * because only the admin can view all the information about all the users
     *
     * @param id     The of the user who we want to get the name
     * @param userId The id of the current user
     * @return returns the name of the user with id equals to the first param
     */
    public String getName(String id, String userId) {
        return "";
    }

    /**
     * Set pw as new password to the user with the id equals to the first param
     *
     * @param pw new password
     */
    public void setPassword(String pw, String id) {
    }

    /**
     * Get the password of the user with the id equals to first param
     * Check if the id correspond to userId because a user can't view the password of another user
     *
     * @param id     the id of the user who we want to get the password
     * @param userId the id of the current user
     * @return retun the password if
     */
    public String getPassword(String id, String userId) {
        return "";
    }
}

/* CHANGELOG
DATE       BRANCH                 AUTHOR     COMMENT
19/03/2024 DeleteRegisterMethod   Nicola     Generate all the getters and setters for all the variable
*/