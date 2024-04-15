import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static JSONArray usersJsonArray = new JSONArray(); // the file os users. Es: Students, Teachers, ...
    static JSONObject agendaJson = new JSONObject(); // the file of the agenda
    static JSONObject stuffJson = new JSONObject(); // the file which contains the stuff

    enum UserType {student, parent, teacher, admin}
    static UserType userType;

    // These classes are used when a user log-in and all the attribute
    // of one class, it depends on the type of user the user is, will fill up
    static Student student;
    static Teacher teacher;
    static Parent parent;
    static Admin admin;

    static boolean incorrectValue; // Bool to verify the validity of an inserction
    static boolean continueToInsert; // Bool to verify if the user wants to continue a cycle

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] studentPrincipalMenu = {
                "MENU PRINCIPALE",
                "Visualizza voti",
                "Visuializza agenda",
                "Visualizza lezioni",
                "Visualizza informazioni account",
                "Esci"
        };

        String[] parentPrincipalMenu = {

        };

        String[] teacherPrincipalMenu = {

        };

        String[] adminPrincipalMenu = {
                "MENU PRINCIPALE",
                "Visualizza gli studenti di una classe",
                "Visualizza elenco insegnanti",
                "Crea nuovo utente",
                "Esci"
        };

        String[] typeOfCreateableUserMenu = {
                "Che tipo di studente vuoi creare?",
                "Studente",
                "Genitore",
                "Insegnante",
                "Amministratore"
        };

        // Variable for login
        String currentUserId, courrentUserPw;

        boolean continueToUse = true;

        // Variable for creating new user
        JSONArray jsonToModify;
        JSONObject user; // the obj of the user which we want to create
        String typeOfUser = "";
        String new_name = "";
        String new_surname = "";
        String[] address = new String[3];
        String new_id = "";
        String new_password = "";
        String subject = "";

        // Variable view the list of teachers
        String[] teachersList;

        // Variable to view the list of students of a classroom
        List<List<Map<String, String>>> classroomsList;
        String selectedClassroom;
        JSONObject classroomsArray;
        JSONArray studentsArray;


        // Cycle until the user insert the correct id and the password.
        do {
            incorrectValue = false;
            // Cycle until the user insert a correct id
            do {
                System.out.println("Inserisci il tuo username o id : ");
                currentUserId = scanner.next().toLowerCase();

                if (currentUserId.charAt(0) != 's' && currentUserId.charAt(0) != 't' &&
                        currentUserId.charAt(0) != 'p' && currentUserId.charAt(0) != 'a') {
                    System.out.println("L'id che hai inserito non e' valido. Riprova.");
                }
            } while (currentUserId.charAt(0) != 's' && currentUserId.charAt(0) != 't' &&
                    currentUserId.charAt(0) != 'p' && currentUserId.charAt(0) != 'a');

            System.out.println("Inserisci la tua password : ");
            courrentUserPw = scanner.next();

            // Check if the id and password matches with access method
            incorrectValue = access(currentUserId, courrentUserPw);

            // If the user inserts an incorrect id or password, tell him.
            if (!incorrectValue) {
                System.out.println("Hai inserito la password o l'username incorretti\nRiprova");
            }
        } while (!incorrectValue);

        System.out.println("Accesso eseguito!");

        // evaluate what type of user is the one who logged in, and instantiate the correct object
        switch (currentUserId.charAt(0)) {
            case 's':
                userType = UserType.student;
                student = new Student();
                break;
            case 'p':
                userType = UserType.parent;
                parent = new Parent();
                break;
            case 't':
                userType = UserType.teacher;
                teacher = new Teacher();
                break;
            case 'a':
                userType = UserType.admin;
                admin = new Admin();
                break;
        }

        // load all user info
        loadUserInfo(currentUserId);


        switch (userType) {
            case UserType.student:
                do {
                    switch (printMenu(studentPrincipalMenu)) {
                        case 1:
                            System.out.println("Visualizza voti");
                            break;
                        case 2:
                            System.out.println("Visuializza agenda");
                            break;
                        case 3:
                            System.out.println("Visualizza lezioni");
                            break;
                        case 4:
                            System.out.println("Visualizza informazioni account");
                            break;
                        case 5:
                            System.out.println("Esci");
                            continueToUse = false;
                            break;
                    }
                } while (continueToUse);
                break;
            case UserType.parent:
                do {
                    // Do stuff of the parent
                } while (continueToUse);
                break;
            case UserType.teacher:
                // If the user is an teacher

                do {
                    // Do stuff of the teacher
                } while (continueToUse);
                break;
            case UserType.admin:
                // If the user is an admin

                // Cycle until the user wants to exit
                do {
                    switch (printMenu(adminPrincipalMenu)) {
                        // View the student of a classroom
                        case 1:
                            classroomsArray = readJsonObjectFile("JSON/JsonFile/Classrooms.json");

                            do {
                                System.out.println("Inserisci quale classe vuoi vedere l'elenco studenti: ");
                                selectedClassroom = scanner.next();

                                studentsArray = (JSONArray) classroomsArray.get(selectedClassroom);

                                if (studentsArray == null)
                                    System.out.println("ATTENZIONE: La classe non e' presente. Riprova");
                            } while (studentsArray == null);

                            System.out.println("Ecco l'elenco degli studenti in " + selectedClassroom);
                            for (Object s : studentsArray) {
                                JSONObject student = (JSONObject) s;

                                System.out.printf(" Id: %s | Nome: %s | Cognome: %s\n",
                                        student.get("id"), student.get("name"), student.get("surname"));
                            }

                            System.out.println();

                            break;
                        // View list of the teachers
                        case 2:

                            teachersList = admin.getTeachers(readJsonArrayFile("JSON/JsonFile/User/Teachers.json"));

                            System.out.println("Ecco la lista degli insegnanti registrati: ");

                            for (int i = 0; i < teachersList.length; i += 4) {
                                System.out.println("Info dell'insegnante " + (i+1));
                                System.out.println("\tId: " + teachersList[i]);
                                System.out.println("\tNome: " + teachersList[i+1]);
                                System.out.println("\tCognome: " + teachersList[i+2]);
                                System.out.println("\tMateria: " + teachersList[i+3]);
                            }

                            break;
                        // Create a new user
                        case 3:
                            // Read the stuff json file
                            stuffJson = readJsonObjectFile("JSON/JsonFile/stuff.json");

                            // Create new user
                            // Variable for create the parent
                            String parentId = "";
                            String parentPw = "";
                            String parentName = "";
                            String parentSurname = "";
                            String[] parentAddress = new String[3];
                            List<Map<String, String>> parentInterviews = new ArrayList<>();
                            // -----
                            String studentClassroom = "";
                            String childId = "";
                            String[] classrooms = new String[1];
                            int indexClassrooms = 0;

                            // Ask what type of user he wants to create
                            typeOfUser = switch (printMenu(typeOfCreateableUserMenu)) {
                                case 1 -> "s";
                                case 2 -> "p";
                                case 3 -> "t";
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
                            System.out.println("Inserisci la citta' in cui abita: ");
                            address[1] = scanner.next();
                            // - cap
                            System.out.println("Inserisci il cap della citta' in cui abita: ");
                            address[2] = scanner.next();

                            if (typeOfUser.equals("s")) {
                                do {
                                    System.out.println("Inserisci la classe dello studente: ");
                                    studentClassroom = scanner.next();
                                } while (verifyClassroom(studentClassroom));
                            }

                            // If the type of user to create is a teacher,
                            // the admin have to insert the subject and the classroom
                            if (typeOfUser.equals("t")) {
                                // insertion of the subject
                                do {
                                    incorrectValue = false;

                                    // Get the subject from the user
                                    subject = getString("Inserisci la materia del professore di cui stai creando l'account.");

                                    if (!verifySubject(subject)) {
                                        System.out.println("La materia che hai inserito non e' valida");
                                        incorrectValue = true;
                                    }
                                } while (incorrectValue);

                                // Insertion of the classrooms
                                do {
                                    continueToInsert = true;
                                    // this cycle is to check if the value, that the admin inserts, is correct.
                                    do {
                                        incorrectValue = false;

                                        System.out.println("Inserisci la classe che ha questo/a professore/ssa: ");
                                        classrooms[indexClassrooms] = scanner.next();

                                        if (classrooms[indexClassrooms].equals("q")) {
                                            continueToInsert = false;
                                            classrooms[indexClassrooms] = "";
                                        } else if (classrooms[indexClassrooms].length() < 2) {
                                            System.out.println("Devi inserire la classe in questo formato <numero><sezione>.");
                                            incorrectValue = true;
                                        } else if (!verifyClassroom(classrooms[indexClassrooms]) &&
                                                !classrooms[indexClassrooms].equals("q")) {
                                            System.out.println("Devi inserire la classe in questo formato <numero><sezione>.");
                                            incorrectValue = true;
                                        } else {
                                            indexClassrooms++; // Update the index of the classrooms array

                                            // If the classrooms array is full add another space
                                            if (classrooms.length == indexClassrooms) {
                                                String[] arr = new String[classrooms.length + 1];

                                                for (int i = 0; i < classrooms.length; i++) {
                                                    arr[i] = classrooms[i];
                                                }

                                                classrooms = arr;
                                            }
                                        }
                                    } while (incorrectValue);

                                    // If the admin wants to finish inserting the teacher's classrooms
                                    // but has not inserted even one
                                    // then tell him that he must insert at least one classroom.
                                    if (!continueToInsert && indexClassrooms < 1) {
                                        System.out.println("Devi inserire almento una materia");
                                        continueToInsert = true;
                                    }
                                } while (continueToInsert);
                            }

                            // if is a student ask all the info of the parent to create the account for it
                            if (typeOfUser.equals("s")) {
                                System.out.println("Studente registrato correttamente.");
                                System.out.println("Registra anche il suo genitore: ");

                                System.out.println("Inserisci il nome del genitore: ");
                                parentName = scanner.next();

                                System.out.println("Inserisci in cognome del genitore: ");
                                parentSurname = scanner.next();
                                // street
                                System.out.println("Inserisci la via in cui abita il genitore: ");
                                parentAddress[0] = scanner.next();
                                // city
                                System.out.println("Inserisci la citta' in cui abita: ");
                                parentAddress[1] = scanner.next();
                                // - cap
                                System.out.println("Inserisci il cap della citta' in cui abita: ");
                                parentAddress[2] = scanner.next();
                            }

                            // Get the counter of the id from stuff.json
                            long counterId = (long) stuffJson.get("countIdNumber");

                            // create the id based on the type of user
                            new_id = typeOfUser + counterId;

                            // upgrade the counter
                            stuffJson.replace("countIdNumber", counterId + 1);

                            // create the parent Id if the type of user is a student
                            if (typeOfUser.equals("s")) {
                                // Get the counter of the id from stuff.json
                                counterId = (long) stuffJson.get("countIdNumber");

                                // Create the parentId
                                parentId = "p" + counterId;

                                // Upgrade the counter
                                stuffJson.replace("countIdNumber", counterId + 1);
                            }

                            // Create a password
                            new_password = createNewPassword(new_name, new_surname, new_id);

                            // read the json file (Students.json, Teachers.json, ...)
                            jsonToModify = switch (typeOfUser) {
                                case "s" -> readJsonArrayFile("JSON/JsonFile/User/Students.json");
                                case "p" -> readJsonArrayFile("JSON/JsonFile/User/Parents.json");
                                case "t" -> readJsonArrayFile("JSON/JsonFile/User/Teachers.json");
                                case "a" -> readJsonArrayFile("JSON/JsonFile/User/Administrators.json");
                                default -> new JSONArray();
                            };

                            // Call a specific method to create a specific type of user
                            user = switch (typeOfUser) {
                                case "s" ->
                                        Admin.setNewStudent(new_id, new_password, new_name, new_surname, address, studentClassroom, parentId);
                                case "p" ->
                                        Admin.setNewParent(new_id, new_password, new_name, new_surname, address, childId);
                                case "t" ->
                                        Admin.setNewTeacher(new_id, new_password, new_name, new_surname, address, subject, classrooms);
                                case "a" -> Admin.setNewAdmin(new_id, new_password, new_name, new_surname, address);
                                default -> new JSONObject();
                            };

                            // add the user created to the file
                            jsonToModify.addLast(user);

                            // Write all changes to the file
                            switch (typeOfUser) {
                                case "s" -> jsonArrayToFile("JSON/JsonFile/User/Students.json", jsonToModify);
                                case "p" -> jsonArrayToFile("JSON/JsonFile/User/Parents.json", jsonToModify);
                                case "t" -> jsonArrayToFile("JSON/JsonFile/User/Teachers.json", jsonToModify);
                                case "a" -> jsonArrayToFile("JSON/JsonFile/User/Administrators.json", jsonToModify);
                            }

                            if (typeOfUser.equals("s")) {
                                jsonToModify = readJsonArrayFile("JSON/JsonFile/User/Parents.json");

                                // Create a password for the parent
                                parentPw = createNewPassword(parentName, parentSurname, parentId);

                                user = Admin.setNewParent(parentId, parentPw, parentName, parentSurname, parentAddress, new_id);
                                jsonToModify.addLast(user);
                                jsonArrayToFile("JSON/JsonFile/User/Parents.json", jsonToModify);
                            }

                            System.out.println("Account registrato correttamente.");

                            // Update stuff file
                            jsonObjectToFile("JSON/JsonFile/stuff.json", stuffJson);

                            break;
                        case 4:
                            continueToUse = false;
                            break;
                        default:
                            System.out.println("NOT VALID OPTION");
                    }
                } while (continueToUse);


                break;
            default:
                System.out.println("NON VALID USER TYPE");
        }
    }

    private static boolean verifyClassroom(String classroom) {
        String classroomNumber = String.valueOf(classroom.charAt(0));
        char section = classroom.charAt(1);

        try {
            Integer.parseInt(classroomNumber);
            if (section <= 'A' || section >= 'Z') {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static boolean verifySubject(String sub) {
        JSONArray subjects = (JSONArray) stuffJson.get("subject");

        // Cycle through all the possible subjects
        for (Object subject : subjects) {
            String strSubject = (String) subject;

            // If the name a subject in the array of subjects is equal to the one which the user inserts,
            // return true because it means that the subject is correct
            if (sub.toLowerCase().equals(subject)) {
                return true;
            }
        }

        // If the user inserts a non-valid subject,
        // return false
        return false;
    }

    private static String getString(String message) {
        String output = "";

        do {
            incorrectValue = false;
            try {
                System.out.println(message);
                output = scanner.next();
            } catch (Exception e) {
                System.out.println("Hai inserito un valore non valido. Riprova.");
                incorrectValue = true;
            }
        } while (incorrectValue);

        return output;
    }

    /**
     * This method load the info of the user with id equals to {@code userId} param,
     * and load it in a global class student, teacher, parent, admin depends on the user type. <br>
     * For Example: if the user with id equals to userId is a student the method loads all the information on
     * the global class student.
     * @param userId the id of the user which we want load the info.
     * */
    private static void loadUserInfo(String userId) {
        // Read the correct file where extract all the user of the same type of the user which we want to search
        usersJsonArray = switch (userType) {
            case UserType.student -> readJsonArrayFile("JSON/JsonFile/User/Students.json");
            case UserType.parent -> readJsonArrayFile("JSON/JsonFile/User/Parents.json");
            case UserType.teacher -> readJsonArrayFile("JSON/JsonFile/User/Teachers.json");
            case UserType.admin -> readJsonArrayFile("JSON/JsonFile/User/Administrators.json");
        };

        // Search for the correct user
        for (Object user : usersJsonArray) {
            JSONObject jsonUser = (JSONObject) user;

            if (jsonUser.get("id").equals(userId)) {
                // Switch the type of student logged in
                switch (userType) {
                    case UserType.student:
                        loadStudentInfo(jsonUser, userId);
                        break;
                    case UserType.parent:
                        loadParentInfo(jsonUser, userId);
                        break;
                    case UserType.teacher:
                        loadTeacherInfo(jsonUser, userId);
                        break;
                    case UserType.admin:
                        loadAdminInfo(jsonUser, userId);
                        break;
                }

                break;
            }
        }
    }


    private static void loadStudentInfo(JSONObject jsonUser, String userId) {
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
        student.loadInfo(userId, (String) jsonUser.get("password"), (String) jsonUser.get("name"),
                (String) jsonUser.get("surname"), address, (String) jsonUser.get("classroom"), gradesMap, notes);
    }

    private static void loadParentInfo(JSONObject jsonUser, String userId) {
        String pw = (String) jsonUser.get("password");
        String name = (String) jsonUser.get("name");
        String surname = (String) jsonUser.get("surname");
        String childId = (String) jsonUser.get("childId");

        JSONObject jsonAddress = (JSONObject) jsonUser.get("address");
        String[] address = {(String) jsonAddress.get("streetName"), (String) jsonAddress.get("city"),
                (String) jsonAddress.get("cap")};

        JSONArray jsonInterviews = (JSONArray) jsonUser.get("interviews");
        List<Map<String, String>> interviews = new ArrayList<>();

        // Cycle through all the interviews
        for (Object interview : jsonInterviews) {
            // parse the object interview in a JSONObject
            JSONObject jsonInterview = (JSONObject) interview;

            // get the prof name and the subject
            String profName = (String) jsonInterview.get("profName");
            String subject = (String) jsonInterview.get("subject");

            // Create a map for store profName value and the subject value
            Map<String, String> interviewMap = new HashMap<>();
            interviewMap.put("profName", profName);
            interviewMap.put("subject", subject);

            // Put the interview
            interviews.add(interviewMap);
        }

        parent.loadInfo(userId, pw, name, surname, address, childId, interviews);
    }

    private static void loadTeacherInfo(JSONObject jsonUser, String userId) {
        String classroom = (String) jsonUser.get("classroom");

    }

    private static void loadAdminInfo(JSONObject jsonUser, String userId) {

    }

    /**
     * Write a JSONArray in a file.
     * @param fileName path of the file which we want to write on the JSONArray
     * @param jsonArr the JSONArray which we want to write on the file
     */
    private static void jsonArrayToFile(String fileName, JSONArray jsonArr) {
        // Write the jsonArray into the file
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(JSONValue.toJSONString(jsonArr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write a JSONObject in a file.
     * @param fileName path of the file which we want to write on the JSONObject
     * @param jsonObj the JSONObject which we want to write on the file
     */
    private static void jsonObjectToFile(String fileName, JSONObject jsonObj) {
        // Write the jsonArray into the file
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(JSONValue.toJSONString(jsonObj));
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
     * <p>
     * But If you have a name or surname minor than 3 letters.
     * <br>
     * Examples:
     * <pre>
     *      name: "Ya", surname: "Carim", id: "S745839
     *      => password: "YACAR745839"
     *
     *      name: "Giorgio", surname: "Ba", id: "S4839334"
     *      => password: "GIOBA4839334"
     *  </pre>
     *
     * @param name    the name of a user
     * @param surname the surname of a user
     * @param id      the id of a user
     * @return the password of the specified user
     */
    private static String createNewPassword(String name, String surname, String id) {
        int minLength = 3;

        // If the name or surname has a length minor than 3,
        // then call the min method to get the minimum length.
        if (name.length() < 3 || surname.length() < 3) {
            // Get the min length between the name and surname
            minLength = Math.min(name.length(), surname.length());
        }

        String namePart = name.substring(0, minLength).toUpperCase();
        String surnamePart = surname.substring(0, minLength).toUpperCase();
        String idPart = id.substring(1);


        // Return the password with <first 3 characters of name><first 3 characters of surname><the id of the user>
        return namePart + surnamePart + idPart;
    }

    /**
     * Method to read all the json file where all the info of
     * one type of user is stored.
     * @param id the id which the user type to log-in
     * @param pw the password which the user type to log-in
     * @return true if the access is correct, false if it is incorrect
     */
    private static boolean access(String id, String pw) {
        // open the file where is the user based on the first letter of the id
        usersJsonArray = switch (id.charAt(0)) {
            case 's' -> readJsonArrayFile("JSON/JsonFile/User/Students.json");
            case 't' -> readJsonArrayFile("JSON/JsonFile/User/Teachers.json");
            case 'p' -> readJsonArrayFile("JSON/JsonFile/User/Parents.json");
            default  -> readJsonArrayFile("JSON/JsonFile/User/Administrators.json");
        };

        // Search in the file of the user type
        // if there is a user with id equal to what the user putted and the password equal to what the user putted
        return verifyAccess(id, pw);
    }

    /**
     * Search in the file of the user type
     * if there is a user with id equal to what the user putted and the password equal to what the user putted.
     */
    private static boolean verifyAccess(String id, String pw) {
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
            if (Objects.equals((String) singleUser.get("id"), id) &&
                    Objects.equals((String) singleUser.get("password"), pw)) {
                return true;
            }
        }

        // If there isn't a user with the id == i_id and password == i_password return false
        return false;
    }

    /**
     * Read a file and parse it into json object.
     *
     * @param fileName
     * @return the json object with the information of the file
     */
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
                System.out.println("[" + i + "] - " + option[i]);
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
21/03/2024 DeleteRegisterMethod   Nicola     Add jsonObjectToFile, now all the file will be written.
                                             Now all the user can be created.
22/03/2024 DeleteRegisterMethod   Nicola     Added the constraint to the admin that when he creates a teacher
                                             he must insert the subject and the class in which he teaches.
*/