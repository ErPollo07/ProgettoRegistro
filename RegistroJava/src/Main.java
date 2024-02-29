import org.json.simple.JSONObject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int scelta=0;
        boolean verify=false;
        System.out.println("Buongiorno\n" +
                "Cosa vuoi fare?\n" +
                "[1] - Accedi\n" +
                "[2] - Registrati\n");

        System.out.println("Inserisci scelta: \n");
        scelta= scanner.nextInt();

        do {
            switch (scelta) {
                case 1:
                    access();
                    verify=true;
                    break;


                case 2:
                    register();
                    verify=true;
                    break;

                default:
                    System.out.println("inserimento non valido!\n");
            }
        }while(verify);


    }

    /**
     *
     */
    private static void access(Scanner scanner){

        String id;
        System.out.println("Inserisci id: \n");
        id=scanner.next();


    }

    private static void register(){

    }
}
