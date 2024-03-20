import java.util.List;
import java.util.Map;

public class Parent extends User {

    private String childId;
    public String getChildId() {
        return childId;
    }
    public void setChildId(String childId) {
        this.childId = childId;
    }

    private List<Map<String, String>> interviews;
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
