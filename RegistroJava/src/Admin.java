import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Admin {

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
    static public JSONObject setNewStudent(String id, String password, String name, String surname, String[] address, String classroom, String parentId) {
        JSONObject jsonObj = new JSONObject();
        JSONArray jsonAddressArray = new JSONArray();
        JSONArray jsonGradesArray = new JSONArray();
        JSONArray jsonNotesArray = new JSONArray();

        jsonObj.put("id", id);
        jsonObj.put("password", password);
        jsonObj.put("name", name);
        jsonObj.put("surname", surname);
        jsonAddressArray.addLast(address[0]);
        jsonAddressArray.addLast(address[1]);
        jsonAddressArray.addLast(address[2]);
        jsonObj.put("address", jsonAddressArray);
        jsonObj.put("parentId", parentId);
        jsonObj.put("classroom", classroom);
        jsonObj.put("grades", jsonGradesArray);
        jsonObj.put("notes", jsonNotesArray);


        return jsonObj;
    }

    /**
     * The method creates a new Parent
     */
    static public JSONObject setNewParent(String id, String password, String name, String surname,
                                          String[] address, String childId) {
        JSONObject jsonObj = new JSONObject();
        JSONObject jsonAddress = new JSONObject();
        JSONArray jsonInterviews = new JSONArray();

        jsonObj.put("id", id);
        jsonObj.put("password", password);
        jsonObj.put("name", name);
        jsonObj.put("surname", surname);
        jsonAddress.put("street", address[0]);
        jsonAddress.put("city", address[1]);
        jsonAddress.put("cap", address[2]);
        jsonObj.put("address", jsonAddress);
        jsonObj.put("childId", childId);
        jsonObj.put("interviews", jsonInterviews);

        return jsonObj;
    }

    /**
     * The method creates a new Teacher
     */
    static public JSONObject setNewTeacher(String id, String password, String name, String surname, String[] address, String subject,
                           String[] classrooms) {


        JSONObject jsonObj = new JSONObject();
        return jsonObj;
    }

    /**
     * The method creates a new Admin
     */
    static public JSONObject setNewAdmin(String id, String password, String name, String surname,
                                         String[] address) {
        JSONObject jsonObj = new JSONObject();
        return jsonObj;
    }
}


