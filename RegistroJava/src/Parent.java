import java.util.List;
import java.util.Map;

public class Parent {

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

    protected String childId;
    public String getChildId() {
        return childId;
    }
    public void setChildId(String childId) {
        this.childId = childId;
    }

    protected List<Map<String, String>> interviews;
    public List<Map<String, String>> getInterviews() {
        return interviews;
    }
    public void setInterviews(List<Map<String, String>> interviews) {
        this.interviews = interviews;
    }

    /**
     *  method that allows you to view the absence and the presence of the student.
     */
    public String[] Administration() {
        return new String[1];
    }

    /**
     * allows the parent to justify the absence of the student.
     */
    public String[] justifyAbsences() {
        return new String[1];
    }

    public void loadInfo(String id, String password, String name, String surname, String[] address, String childId,
                         List<Map<String, String>> interviews) {
        setUserId(id);
        setPassword(password);
        setName(name);
        setName(surname);
        setAddress(address);
        setInterviews(interviews);
    }
}
