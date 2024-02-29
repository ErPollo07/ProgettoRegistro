public class User {

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