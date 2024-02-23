public class Teacher extends User {
    /*
    This class is for handle all the function that a teacher can do
    */

    private String subject;

    Teacher(String username, String password, String subject) {
        super(username, password);
        this.subject = subject;
    }

    /* GETTERS AND SETTERS FOR SUBJECT */
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /* END GETTERS AND SETTERS FOR SUBJECT */
}
