import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static JSONArray userJsonArray = new JSONArray();
    static JSONObject agendaJson = new JSONObject();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] accessMenu = {
                "Cosa vuoi fare?",
                "[1] - Accedi",
                "[2] - Registrati"
        };

        String[] principalMenu = {

        };

        String i_id, i_password;
        boolean invalidLogin = false;

        // Switch the integer returned by printMenu method
        switch (printMenu(accessMenu)) {
            case 1:
                do {
                    System.out.println("inserisci il tuo username o id : ");
                    i_id = scanner.nextLine();

                    System.out.println("inserisci la tua password : ");
                    i_password = scanner.nextLine();

                    // If the user inserts an incorrect id or password, tell him.
                    if (!(invalidLogin = access(i_id, i_password))) {
                        System.out.println("You insert an incorrect id or password");
                    }
                } while (!invalidLogin);

                break;
            case 2:
                register(scanner);
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

        // Check what type of user is and read the correct file
        if (i_id.charAt(0) == 's') {
            filePath = "JSON/JsonFile/User/Students.json";
            readJsonFile(filePath);
        }
        else if (i_id.charAt(0) == 't') {
            filePath = "JSON/JsonFile/User/Teachers.json";
            readJsonFile(filePath);
        }
        else if (i_id.charAt(0) == 'p') {
            filePath = "JSON/JsonFile/User/Parents.json";
            readJsonFile(filePath);
        }
        else if (i_id.charAt(0) == 'a') {
            filePath = "JSON/JsonFile/User/Administrators.json";
            readJsonFile(filePath);
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

        for (Object o : userJsonArray) {
            // get the user obj
            singleUser = (JSONObject) o;
            System.out.println(singleUser.get("id"));
            System.out.println(singleUser.get("password"));

            // Check if there is a user with id equal to i_id and password equal to i_password
            if (Objects.equals((String) singleUser.get("id"), i_id) &&
                    Objects.equals((String) singleUser.get("password"), i_password)) {
                System.out.println("giusto");
                return true;
            }
        }

        return false;
    }

    private static void readJsonFile(String fileName) {
        // Create the json parser
        JSONParser jsonParser = new JSONParser();

        // Read and save the Agenda.json content in jsonObj
        try (FileReader fileReader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(fileReader);
            // assign to the JSONObject (global variable)
            // the file which we want ot extract information from
            userJsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            System.out.println("C'e' stato un problema con i file di accesso. Ci scusiamo per il disagio");
        }
    }

    /**
     * This method permits the new user to create an account.
     *
     * @param scanner scanner
     */
    private static void register(Scanner scanner) {
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
