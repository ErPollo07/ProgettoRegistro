import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static JSONArray usersJsonArray = new JSONArray(); // the file os users. Es: Students, Teachers, ...
    static JSONObject agendaJson = new JSONObject(); // the file of the agenda
    static JSONObject classroomsJson = new JSONObject(); // the file of the classroom with all the students
    static JSONObject stuffJson = new JSONObject(); // the file which contains the stuff

    enum UserType {student, parent, teacher, admin};
    static UserType userType;

    static Student student;
    static Teacher teacher;
    static Parent parent;
    static Admin admin;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] accessMenu = {
                "Cosa vuoi fare?",
                "[1] - Accedi",
                "[2] - Registrati"
        };

        String[] studentPrincipalMenu = {

        };

        String[] parentPrincipalMenu = {

        };

        String[] teacherPrincipalMenu = {

        };

        String[] adminPrincipalMenu = {
                "MENU PRINCIPALE",
                "[1] - Visualizza gli studenti di una classe",
                "[2] - Visualizza elenco insegnanti",
                "[3] - Crea nuovo utente",
                "[4] - Esci"
        };

        String[] typeOfCreateableUser = {
                "Che tipo di studente vuoi creare?",
                "[1] - Studente",
                "[2] - Genitore",
                "[3] - Insegnante",
                "[4] - Amministratore"
        };

        // Variable for login
        String i_id, i_password;
        boolean invalidLogin = false;

        boolean continueToUse = true;

        // Variable for creating new user
        JSONArray jsonToModify = new JSONArray();
        JSONObject user; // the obj of the user which we want to create
        String typeOfUser = "";
        String new_name = "";
        String new_surname = "";
        String[] address = new String[3];
        String new_id = "";
        String new_password = "";

        do {
            do {
                System.out.println("inserisci il tuo username o id : ");
                i_id = scanner.next().toLowerCase();

                if (i_id.charAt(0) != 's' && i_id.charAt(0) != 't' &&
                        i_id.charAt(0) != 'p' && i_id.charAt(0) != 'a') {
                    System.out.println("L'id che hai inserito non e' valido. Riprova.");
                }
            } while (i_id.charAt(0) != 's' && i_id.charAt(0) != 't' &&
                    i_id.charAt(0) != 'p' && i_id.charAt(0) != 'a');

            System.out.println("inserisci la tua password : ");
            i_password = scanner.next();

            invalidLogin = access(i_id, i_password);

            // If the user inserts an incorrect id or password, tell him.
            if (!invalidLogin) {
                System.out.println("You insert an incorrect id or password");
            }
        } while (!invalidLogin);

        System.out.println("Accesso eseguito!");

        // evaluate what type of user is the one who logged in, and instantiate the correct object
        switch (i_id.charAt(0)) {
            case 's':
                userType = UserType.student;
                student = new Student();
                break;
            case 'p':
                userType = UserType.parent;
                teacher = new Teacher();
                break;
            case 't':
                userType = UserType.teacher;
                parent = new Parent();
                break;
            case 'a':
                userType = UserType.admin;
                admin = new Admin();
                break;
        }

        loadUserInfo(i_id);

        switch (userType) {
            case UserType.student:

                do {
                    // Do stuff of the student
                } while(continueToUse);
                break;
            case UserType.parent:

                do {
                    // Do stuff of the parent
                } while(continueToUse);
                break;
            case UserType.teacher:


                do {
                    // Do stuff of the teacher
                } while(continueToUse);
                break;
            case UserType.admin:

                do {
                    switch (printMenu(adminPrincipalMenu)) {
                        case 1:
                            // View the student of a classroom
                            break;
                        case 2:
                            // View the list of teachers
                            break;
                        case 3:
                            // Create new user
                            String parentId = "";

                            // Ask what type of user he wants to create
                            typeOfUser = switch (printMenu(typeOfCreateableUser)) {
                                case 1 -> "s";
                                case 2 -> "t";
                                case 3 -> "p";
                                case 4 -> "a";
                                default -> "None";
                            };

                            // Ask the name
                            System.out.println("Inserisci il nome del nuovo utente: ");
                            new_name = scanner.next();

                            // Ask the surname
                            System.out.println("Inserisci il cognome del nuovo utente: ");
                            new_surname = scanner.next();

                            // Ask address
                            // - streetName
                            System.out.println("inserisci la via in cui abita in nuovo utente: ");
                            address[0] = scanner.next();
                            // - cityName
                            System.out.println("inserisci la citta' in cui abita: ");
                            address[1] = scanner.next();
                            // - cap
                            System.out.println("inserisci il cap della citta' in cui abita: ");
                            address[2] = (String) scanner.next();

                            // if is a student ask all the info of the parent to create the account for it
                            if (typeOfUser.equals("s")) {
                                // create the parent account
                            }

                            // Create a id
                            // read the stuff json file
                            stuffJson = readJsonObjectFile("JSON/JsonFile/stuff.json");

                            // Get the counter of the id
                            long counterId = (long) stuffJson.get("countIdNumber");

                            // create the id based on the type of user
                            new_id = switch (typeOfUser) {
                                case "s" -> "s" + counterId;
                                case "p" -> "p" + counterId;
                                case "t" -> "t" + counterId;
                                case "a" -> "a" + counterId;
                                default -> "";
                            };

                            // upgrade the counter
                            stuffJson.replace("countIdNumber", counterId+1);

                            // Create a password
                            new_password = crateNewPassword(new_name, new_surname, new_id);

                            // read the json file like Students.json, Teachers.json, ...
                            jsonToModify = readJsonArrayFile("JSON/JsonFile/User/Students.json");

                            // Call the method to create an account
                            user = Admin.setNewStudent(new_id, new_password, new_name, new_surname, address, parentId);

                            jsonToModify.addLast(user);

                            break;
                        case 4:
                            continueToUse = false;
                            break;
                        default:
                            System.out.println("NOT VALID OPTION");
                    }
                } while(continueToUse);


                break;
            default:
                System.out.println("NON VALID USER TYPE");
        }

        jsonArrayToFile("JSON/JsonFile/User/Students.json", jsonToModify);
    }

    private static void loadUserInfo(String userId) {
        JSONArray usersJson = new JSONArray();

        // Read the correct file where extract all the user of the same type of the user which we want to search
        usersJson = switch (userType) {
            case UserType.student -> readJsonArrayFile("JSON/JsonFile/User/Students.json");
            case UserType.parent -> readJsonArrayFile("JSON/JsonFile/User/Parents.json");
            case UserType.teacher -> readJsonArrayFile("JSON/JsonFile/User/Teachers.json");
            case UserType.admin -> readJsonArrayFile("JSON/JsonFile/User/Administrators.json");
        };

        // Search for the correct user
        for (Object user : usersJson) {
            JSONObject jsonUser = (JSONObject) user;

            if (jsonUser.get("id").equals(userId)) {
                // Switch the type of
                switch (userType) {
                    case UserType.student:
                        // get the jsonArray from the object of the user
                        JSONObject addressObj = (JSONObject) jsonUser.get("address");
                        // cast all the information to string
                        // and pass it all into the array of string that contains the address information
                        String[] address = {(String) addressObj.get("street"), (String) addressObj.get("city"), (String) addressObj.get("cap")};

                        // Get the jsonArray of notes from the user object
                        JSONArray notesArray = (JSONArray) jsonUser.get("notes");
                        // Create the note array with length equals to notesArray
                        String[] notes = new String[notesArray.size()];
                        // pass all the item of notesArray (JSONArray) into notes (String[])
                        for (int i = 0; i < notesArray.size(); i++) {
                            notes[i] = (String) notesArray.get(i);
                        }

                        // Create the object
                        JSONObject gradesObj = (JSONObject) jsonUser.get("grades");
                        // Create the HashMap which stores the grades
                        // Like this:
                        // "NameOfTheSubject1": ListIntOfGrade1,
                        // "NameOfTheSubject2": ListIntOfGrade2
                        // ...
                        Map<String, List<Integer>> gradesMap = new HashMap<>();
                        // Cycle through all the subject which has grades
                        for (Object key : gradesObj.keySet()) {
                            // get the array of the grades
                            JSONArray gradesArray = (JSONArray) gradesObj.get(key);
                            // Create the list of grades (es: [1,2,3,4,5])
                            List<Integer> gradesList = new ArrayList<>();
                            // Cycle through all the grades of a subject
                            for (Object o : gradesArray) {
                                // Add a grade into the array of grades of a subject
                                gradesList.add(((Long) o).intValue());
                            }
                            // Insert the array of grades of a subject into the hashMap
                            gradesMap.put((String) key, gradesList);
                        }

                        // load all the info of the user
                        student.loadInfo(userId, (String)jsonUser.get("password"), (String)jsonUser.get("name"),
                                (String)jsonUser.get("surname"), address, (String)jsonUser.get("classroom"), gradesMap, notes);

                        break;
                    case UserType.parent:
                        break;
                    case UserType.teacher:
                        break;
                    case UserType.admin:
                        break;

                }

                break;
            }
        }
    }



    private static void jsonArrayToFile(String fileName, JSONArray jsonArr) {
        // Write the jsonArray into the file
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(JSONValue.toJSONString(jsonArr));
            System.out.println("Oggetto JSON aggiornato e scritto su '" + fileName + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the new password for a new user.
     * <br>
     * Examples:
     * <pre>
     *     name: "Mario", surname: "Sturniolo", id: "S827362"
     *     => password: "MARSTU827362"
     *
     *     name: "Sofia", surname: "Baggio", id: "P74638294"
     *     => password: "SOFBAG74638294"
     * </pre>
     *
     *  But If you have a name or surname minor than 3 letters.
     *  <br>
     *  Examples:
     *  <pre>
     *      name: "Ya", surname: "Carim", id: "S745839
     *      => password: "YACAR745839"
     *
     *      name: "Giorgio", surname: "Ba", id: "S4839334"
     *      => password: "GIOBA4839334"
     *  </pre>
     *
     * @param name the name of a user
     * @param surname the surname of a user
     * @param id the id of a user
     * @return the password of the specified user
     */
    private static String crateNewPassword(String name, String surname, String id) {
        int minLength = 3;

        // If the name or surname has a length minor than 3,
        // then call the min method to get the minimum length.
        if (name.length() < 3 || surname.length() < 3) {
            //
            minLength = Math.min(name.length(), surname.length());
        }

        // Return the password with <first 3 characters of name><first 3 characters of surname><the id of the user>
        return name.substring(0, minLength - 1).toUpperCase() + surname.substring(0, minLength - 1).toUpperCase() + id.substring(1);
    }

    /**
     * Method to login in the register
     *
     * @param i_id
     * @param i_password
     */
    private static boolean access(String i_id, String i_password) {
        String filePath = "";

        switch (i_id.charAt(0)) {
            case 's':
                filePath = "JSON/JsonFile/User/Students.json";
                usersJsonArray = readJsonArrayFile(filePath);
                break;
            case 't':
                filePath = "JSON/JsonFile/User/Teachers.json";
                usersJsonArray = readJsonArrayFile(filePath);
                break;
            case 'p':
                filePath = "JSON/JsonFile/User/Parents.json";
                usersJsonArray = readJsonArrayFile(filePath);
                break;
            case 'a':
                filePath = "JSON/JsonFile/User/Administrators.json";
                usersJsonArray = readJsonArrayFile(filePath);
                break;
        }

        // Search in the file of the user type
        // if there is a user with id equal to what the user putted and the password equal to what the user putted
        return verifyAccess(i_id, i_password);
    }

    /**
     * Search in the file of the user type
     * if there is a user with id equal to what the user putted and the password equal to what the user putted.
     */
    private static boolean verifyAccess(String i_id, String i_password) {
        // Search for every user id in file userJson
        // if there is one user that has the same id as i_id then check it's password
        // if the password doesn't match continue to search, else stop the search
        JSONObject singleUser;

        // Cycle for every user saved in the file usersJsonArray
        for (Object o : usersJsonArray) {
            // get the user obj
            singleUser = (JSONObject) o;
            System.out.println(singleUser.get("id"));
            System.out.println(singleUser.get("password"));

            // Check if there is a user with id equal to i_id and password equal to i_password
            if (Objects.equals((String) singleUser.get("id"), i_id) &&
                    Objects.equals((String) singleUser.get("password"), i_password)) {
                return true;
            }
        }

        // If there isn't a user with the id == i_id and password == i_password return false
        return false;
    }

    private static JSONObject readJsonObjectFile(String fileName) {
        // Create the json parser
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        // Read and save the Agenda.json content in jsonObj
        try (FileReader fileReader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(fileReader);
            // assign to the JSONObject (global variable)
            // the file which we want ot extract information from
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            System.out.println("C'e' stato un problema con i file di accesso. Ci scusiamo per il disagio");
        }

        return jsonObject;
    }

    /**
     *
     * @param fileName
     * @return
     */
    private static JSONArray readJsonArrayFile(String fileName) {
        // Create the json parser
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();

        // Read and save the Agenda.json content in jsonObj
        try (FileReader fileReader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(fileReader);
            // assign to the JSONObject (global variable)
            // the file which we want ot extract information from
            jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            System.out.println("C'e' stato un problema con i file di accesso. Ci scusiamo per il disagio");
        }

        return jsonArray;
    }

    /**
     * This method permits the new user to create an account.
     *
     * @param typeOfUser
     * @param name
     * @param surname
     */
    private static void register(String typeOfUser,String name, String surname) {
        System.out.println("register");
    }

    /**
     * Print the menu and take the choice of the user.
     *
     * @param option The menu is ["title", "firstChoice", ...]
     * @return the number of the choice who user chooses.
     */
    private static int printMenu(String[] option) {
        Scanner scanner = new Scanner(System.in);

        int choiceMenu;

        do {
            for (int i = 0; i < option[0].length(); i++) {
                System.out.print("=");
            }

            System.out.println(); // go on next line

            System.out.println(option[0]); // print the title

            for (int i = 0; i < option[0].length(); i++) {
                System.out.print("=");
            }

            System.out.println(); // go on the next line

            for (int i = 1; i < option.length; i++) {
                System.out.println(option[i]);
            }

            System.out.println("\nInserisci la scelta: ");
            choiceMenu = scanner.nextInt();

            if (choiceMenu < 1 || choiceMenu > option.length - 1) {
                System.out.println("\nScelta errata");
            }
        } while (choiceMenu < 1 || choiceMenu > option.length - 1);

        return choiceMenu;
    }
}


/* CHANGE LOG
DATE       BRANCH                 AUTHOR     COMMENT
14/3/2024  main                   Nicola     Done access method, which use verifyAccess to verify if the user exists.
15/03/2024 DeleteRegisterMethod   Nicola     Add all the input for register a new user
16/03/2024 DeleteRegisterMethod   Nicola     Done the part of the registration of a new user.
19/03/2024 DeleteRegisterMethod   Nicola     Add a do-while to repeat the main cycle of all the user,
                                             Done loadInfo method
                                             which loads the info of the user from the json file to the User class variable
*/