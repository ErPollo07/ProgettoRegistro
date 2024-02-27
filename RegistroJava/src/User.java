public class User {

    /**
     * Set a new name for the user
     * Es - My name is "nicola" in file User.json, if I call the function
     * and I put the parameter "giancarlo", my name now will be "giancarlo"
     * @param name new name for the user
     */
    public void setName(String name) {
    }

    /**
     * The method gives the name of the user with id equals to the first param.
     * Because a user doesn't have the permission to look at the settings of another account
     * @param id The of the user who we want to get the name
     * @param userId The id of the current user
     * @return returns the name of the user with id equals to the first param
     */
    public String getName(String id, String userId) {
        return "";
    }


}
