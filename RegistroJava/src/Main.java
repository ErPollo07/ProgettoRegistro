import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static JSONArray usersJsonArray = new JSONArray(); // the file os users. Es: Students, Teachers, ...
    static JSONObject agendaJson = new JSONObject(); // the file of the agenda
    static JSONObject classroomsJson = new JSONObject(); // the file of the classroom with all the students
    static JSONObject stuffJson = new JSONObject(); // the file which contains the stuff

    static enum UserType {student, parent, teacher, admin};
    static UserType userType;

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
                "[3] - Crea nuovo utente"
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

        // Variable for creating new user
        String typeOfUser = "";
        String i_name = "";
        String i_surname = "";
        String[] address = new String[3];
        String new_id = "";

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

            // If the user inserts an incorrect id or password, tell him.
            if (!(invalidLogin = access(i_id, i_password))) {
                System.out.println("You insert an incorrect id or password");
            }
        } while (!invalidLogin);

        System.out.println("Accesso eseguito!");

        // evaluate what type of user is the one who logged in
        switch (i_id.charAt(0)) {
            case 's' -> userType = UserType.student;
            case 'p' -> userType = UserType.parent;
            case 't' -> userType = UserType.teacher;
            case 'a' -> userType = UserType.admin;
        }

        switch (userType) {
            case UserType.student:
                // Do stuff of the student
                break;
            case UserType.parent:
                // Do stuff of the parent
                break;
            case UserType.teacher:
                // Do stuff of the teacher
                break;
            case UserType.admin:

                switch (printMenu(adminPrincipalMenu)) {
                    case 1:
                        // View the student of a classroom
                        break;
                    case 2:
                        // View the list of teachers
                        break;
                    case 3:
                        // Create new user

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
                        i_name = scanner.next();

                        // Ask the surname
                        System.out.println("Inserisci il cognome del nuovo utente: ");
                        i_surname = scanner.next();

                        // Ask address
                        // - streetName
                        System.out.println("inserisci la via in cui abita in nuovo utente: ");
                        address[0] = scanner.next();
                        // - cityName
                        System.out.println("inserisci la citta' in cui abita: ");
                        address[1] = scanner.next();
                        // - cap
                        System.out.println("inserisci il cap della citta' in cui abita: ");
                        address[2] = scanner.next();

                        // if is a student ask all the info of the parent to create the account for it
                        if (typeOfUser.equals("s")) {
                            // create the parent account
                        }

                        // Create a id
                        // read the stuff json file
                        readStuffJsonFile("JSON/JsonFile/stuff.json");

                        // Get the counter of the id
                        int counterId = (int)stuffJson.get("countIdNumber");

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

                        // Call the method to create an account


                        break;
                    default:
                        System.out.println("NOT VALID OPTION");
                }

                break;
        }
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
                readJsonFile(filePath);
                break;
            case 't':
                filePath = "JSON/JsonFile/User/Teachers.json";
                readJsonFile(filePath);
                break;
            case 'p':
                filePath = "JSON/JsonFile/User/Parents.json";
                readJsonFile(filePath);
                break;
            case 'a':
                filePath = "JSON/JsonFile/User/Administrators.json";
                readJsonFile(filePath);
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

    /* TODO do an overload of this method with all the JSON file possibility
    * */
    private static void readJsonFile(String fileName) {
        // Create the json parser
        JSONParser jsonParser = new JSONParser();

        // Read and save the Agenda.json content in jsonObj
        try (FileReader fileReader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(fileReader);
            // assign to the JSONObject (global variable)
            // the file which we want ot extract information from
            usersJsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            System.out.println("C'e' stato un problema con i file di accesso. Ci scusiamo per il disagio");
        }
    }

    private static void readStuffJsonFile(String fileName) {
        // Create the json parser
        JSONParser jsonParser = new JSONParser();

        // Read and save the Agenda.json content in jsonObj
        try (FileReader fileReader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(fileReader);
            // assign to the JSONObject (global variable)
            // the file which we want ot extract information from
            stuffJson = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            System.out.println("C'e' stato un problema con i file di accesso. Ci scusiamo per il disagio");
        }
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
*/