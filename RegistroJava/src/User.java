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

    private String[] address;
    public String[] getAddress() {
        return address;
    }
    public void setAddress(String[] address) {
        this.address = address;
    }
}

/* CHANGELOG
DATE       BRANCH                 AUTHOR     COMMENT
19/03/2024 DeleteRegisterMethod   Nicola     Generate all the getters and setters for all the variable
24/03/2024 DeleteRegisterMethod   Nicola     Move all the attributes which are specified for a user in the correct class
*/