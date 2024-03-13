import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static JSONObject userJson = new JSONObject();
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

        // Switch the integer returned by printMenu method
        switch (printMenu(accessMenu)) {
            case 1:
                access(scanner);
                break;
            case 2:
                register(scanner);
                break;
        }


    }

    /**
     * Method to login in the register
     *
     * @param scanner scanner
     */
    private static void access(Scanner scanner) {
        String id;
        String password;
        String filePath = "";

        System.out.println("===Accedi===");
        System.out.println("Inserisci il codice personale o l'username della scuola: ");
        System.out.println("-> ");

        id = scanner.nextLine();

        System.out.println("Inserisci la password:\n ");

        password = scanner.nextLine();

        // Check what type of user is
        if (id.charAt(0) == 'S') {
            filePath = "JSON/JsonFile/User/Students.json";
            readJsonFile(filePath);
        }

        // Search in the file of the user type
        // if there is a user with id equal to what the user putted and the password equal to what the user putted
        verifyAccess();


        // if there isn't a user with the id or password equal to what the user putted
    }

    /**
     * Search in the file of the user type
     * if there is a user with id equal to what the user putted and the password equal to what the user putted.
     */
    private static void verifyAccess() {

    }

    private static void readJsonFile(String fileName) {
        // Create the json parser
        JSONParser jsonParser = new JSONParser();

        // Read and save the Agenda.json content in jsonObj
        try (FileReader fileReader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(fileReader);
            // assign to the JSONObject (global variable)
            // the file which we want ot extract information from
            userJson = (JSONObject) obj;
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
