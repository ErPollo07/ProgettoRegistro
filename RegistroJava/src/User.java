import javax.swing.*;

public class User {
    private String username;
    private String password;

    /* CONSTRUCTOR */
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /* GETTER AND SETTER FOR USERNAME */
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    /* END GETTER AND SETTER FOR USERNAME */


    /* GETTER AND SETTER FOR PASSWORD */
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    /* END GETTER AND SETTER FOR PASSWORD */


    public String getAccountSettings() {
        String accountSettings = "Username = " + getUsername() + "\nPassword = " + getPassword();

        return accountSettings;
    }
}
