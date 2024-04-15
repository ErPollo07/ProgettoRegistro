import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.List;
import java.util.Map;

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
     * This method allows you to view the list of the teachers in the school
     *
     * @return return the list of name and surname of all the teacher
     */
    public String[] getTeachers(JSONArray teachersJson) {
        String[] teachersList = new String[teachersJson.size()*4];
        int indexTeachers = 0;

        for (Object teacherObj : teachersJson) {
            JSONObject teacherJson = (JSONObject) teacherObj;

            teachersList[indexTeachers] = (String) teacherJson.get("id");
            teachersList[indexTeachers+1] = (String) teacherJson.get("name");
            teachersList[indexTeachers+2] = (String) teacherJson.get("surname");
            teachersList[indexTeachers+3] = (String) teacherJson.get("subject");

            indexTeachers += 4;
        }

        return teachersList;
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


