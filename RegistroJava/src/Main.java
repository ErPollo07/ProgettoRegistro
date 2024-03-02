import org.json.simple.JSONObject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JSONObject userJson = new JSONObject();
        JSONObject agendaJson = new JSONObject();

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
        System.out.println("access");
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
