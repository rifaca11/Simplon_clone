
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ChoiceMenu extends ConnexionDB{
    public Promotion promotion = new Promotion();
    public Apprenant apprenant = new Apprenant();
    public Scanner scanner = new Scanner(System.in);
    public Sys systemApp = new Sys();
    public Formateur teacher = new Formateur();
    public Admin admin = new Admin();

    ArrayList<String> checkCountarr1 = new ArrayList<>();
    ArrayList<String> formateurStatus0 = new ArrayList<>();

    ArrayList<String> checkCountarr = new ArrayList<>();

    String count = admin.countPromosNot();


    // --- declaration ---
    boolean a = true;
    boolean b = true;

    boolean choiceCase = true;

    public ChoiceMenu(int choice, Scanner s1)
    {
        System.out.println("------------------------ WELCOME TO SIMPLON ------------------------");
        System.out.println("-------------------------collaborative learning platform in active pedagogy------------------------");
        System.out.print("----------------- Enter your username : ----------------- ");
        String username = s1.next();
        System.out.print("Enter password : |--> ");
        String password = s1.next();
//        Apprenant apprenant = new Apprenant();
        Sys systemApp = new Sys();
        boolean param = true;


// switch about choice


        switch (choice)
        {
            case 1: {
                if (systemApp.login(username, password, "admin")) {
                    while (param) {
                        // Declaration
                        System.out.println("------------------------ Welcome " + username + " to your space account ------------------------");
                        System.out.println("1 => - Create account's teacher");
                        System.out.println("2 => - Create account's trainer");
                        System.out.println("3 => - Create a Promo");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println("4 => - See list of promos");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println("5 => - Add teacher in his promo");
//                    System.out.println("6 => - Update teacher account ");
//                    System.out.println("7 => - Update trainer account ");
//                    System.out.println("8 => - Delete account");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println("6 => - Logout");

                        System.out.print("Choice a number ");
                        String ifChoiceAdmin = scanner.nextLine();

                        switch (Integer.parseInt(ifChoiceAdmin)) {
                            case 1, 2: {

                                String type = ifChoiceAdmin.equals("1") ? "teacher" : "Student";
                                String table = type.equals("teacher") ? "formateur" : "apprenant";
                                System.out.println("Create a " + type + " account -------- |");
                                System.out.print("fullName : ");
                                String fullNameInput = scanner.nextLine();
                                System.out.print("username : ");
                                String usernameInput = scanner.nextLine();
                                System.out.print("password : ");
                                String passwordInput = scanner.nextLine();
                                System.out.print("email : ");
                                String emailInput = scanner.nextLine();
                                //scanner.close();
                                admin.createAccount(table, fullNameInput, usernameInput, passwordInput, emailInput);

                                break;
                            }
                            case 3: {

                                System.out.println("Create a Promo -------- |");
                                System.out.println("Promo Name : ");
                                String promoName = scanner.nextLine();
                                admin.createPromo(promoName);

                                break;
                            }
                            case 4: {

                                System.out.println("-----------------------------------------------------------");

                                // -------------------

                                if (Integer.parseInt(count) != 0) {
                                    String[][] arr = admin.selectAllPromos();
                                    for (int i = 0; i < arr.length; i++) {
                                        for (int j = 0; j < 1; j++) {
                                            // check if status == 0
                                            if (arr[i][2].equals("0")) {
                                                // Show All promo names | status == 0
                                                System.out.println((i + 1) + " ) - " + arr[i][1]);
                                                //promosStatus0.add(arr[i][1]);
                                            } else {
                                                checkCountarr.add(String.valueOf(i + 1));
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No Promo ...");
                                }
                                System.out.println("-----------------------------------------------------------");

                                // End case

                                break;
                            }

                            case 5: {
                                System.out.println("-----------------------------------------------------------");
                                String count = admin.countPromosNot();

                                // --- declaration ---
                                ArrayList<String> checkCountarr = new ArrayList<>();
                                ArrayList<String> checkCountarr1 = new ArrayList<>();
                                ArrayList<String> formateurStatus0 = new ArrayList<>();
                                boolean b1 = true;
                                boolean b2 = true;
                                // -------------------

                                if (Integer.parseInt(count) != 0) {
                                    String[][] arr = admin.selectAllPromos();
                                    for (int i = 0; i < arr.length; i++) {
                                        for (int j = 0; j < 1; j++) {
                                            // check if status == 0
                                            if (arr[i][2].equals("0")) {
                                                // Show All promo names | status == 0
                                                System.out.println((i + 1) + " ) - " + arr[i][1]);
                                                //promosStatus0.add(arr[i][1]);
                                            } else {
                                                checkCountarr.add(String.valueOf(i + 1));
                                            }
                                        }
                                    }

                                    if (count.length() != 0) {
                                        System.out.println("choose a promo : ");
                                        String choixPromo = scanner.nextLine();

                                        for (String check : checkCountarr) {
                                            if (Objects.equals(check, choixPromo)) {
                                                b1 = false;
                                                break;
                                            }
                                        }
                                        if (b1) {
                                            String promo = arr[Integer.parseInt(choixPromo) - 1][1];
                                            String idPromo = promotion.getPromoId(promo);

                                            String[][] arr1 = admin.selectAllAccounts("formateur");
                                            for (int i = 0; i < arr1.length; i++) {
                                                for (int j = 0; j < 1; j++) {
                                                    // check if status == 0
                                                    if (arr1[i][4].equals("0")) {
                                                        // Show All former names (status = 0)
                                                        System.out.println((i + 1) + " ) - " + arr1[i][1]);
                                                        formateurStatus0.add(arr1[i][1]);
                                                    } else {
                                                        checkCountarr1.add(String.valueOf(i + 1));
                                                    }
                                                }
                                            }
                                            if (formateurStatus0.size() != 0) {
                                                System.out.println("choose Teacher to asign it to promo " + promo);
                                                String choixFormer = scanner.nextLine();

                                                for (String check1 : checkCountarr1) {
                                                    if (Objects.equals(check1, choixFormer)) {
                                                        b2 = false;
                                                        break;
                                                    }
                                                }

                                                if (b2) {
                                                    String formateur = arr1[Integer.parseInt(choixFormer) - 1][1];
                                                    String idFormer = admin.getIdTeacher(formateur);
                                                    // assign former to promotion
                                                    admin.AddFormateurPromo(Integer.parseInt(idFormer), Integer.parseInt(idPromo));
                                                    admin.updateStatusteacher(Integer.parseInt(idFormer));

                                                } else {
                                                    System.out.println("pleaaase choose correct number");
                                                }
                                            } else {
                                                System.out.println("--> No teacher to assign ...");
                                            }
                                        } else {
                                            System.out.println("Pleaaaase choose a correct number");
                                        }
                                    } else {
                                        System.out.println("--> No promo found ...");
                                    }
                                } else {
                                    System.out.println("Ops");
                                }
                                System.out.println("-----------------------------------------------------------");
                                break;
                            }

                            case 6: {
                                param = false;
                                break;
                            }
                            default: {
                                System.out.println("you don't have any access to this platform");
                                break;
                            }
//                        End switch
                        }

                    }
                }
                break;
            }

//           ---------------------------------------------- TEACHER ----------------------------------------------
            case 2: {
                if (systemApp.login(username, password, "formateur")) {
                    String promo = promotion.getPromoName(Integer.parseInt(promotion.getTeacherId(username)));
                    //String ifPromoExist = promo.length() > 0 ? promo : "";
                    // Declaration
                    while (param) {
                    System.out.println("------------------------ Welcome " + username + " to your space account ------------------------");
                    System.out.println("1 => - Add Trainer to Promo");
                    System.out.println("2 => - Create a Brief");
                    System.out.println("3 => - List of students promo");
                    System.out.println("4 => - Logout");

                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Choice a number ");
                        String ifChoiceTeacher = scanner.nextLine();

                        ArrayList<String> arr = teacher.selectAllEmailsInPromo(Integer.parseInt(promotion.getTeacherId(username)));

                        switch (ifChoiceTeacher) {
                            case "1": {
                                    ArrayList<String> getTrainerNameStatus0 = apprenant.getTrainerNameStatus0();
                                    for (int i = 0; i < getTrainerNameStatus0.size(); i++) {
                                        System.out.println((i + 1) + " ) - " + getTrainerNameStatus0.get(i));
                                    }
                                    System.out.println("choose a Student to be assigned to promo | " + promo + " |");
                                    String teacherChoice = scanner.nextLine();
                                    String getIdTrainer = apprenant.getIdTrainer(getTrainerNameStatus0.get(Integer.parseInt(teacherChoice) - 1));

                                    teacher.AddApprenantPromo(Integer.parseInt(promotion.getPromoId(promo)), Integer.parseInt(getIdTrainer));

                                break;
                            }
                            case "2": {
                                    System.out.println("Create a Brief -------- |");
                                    System.out.print("Context : ");
                                    String context = scanner.nextLine();
                                    System.out.print("Deadline : ");
                                    String deadline = scanner.nextLine();
                                    scanner.close();

                                    if (!context.isEmpty() && !deadline.isEmpty()) {
                                        // teacher.createBrief(context, Integer.parseInt(deadline), Integer.parseInt(promotion.getPromoId(promo)));
                                        teacher.createBrief(context, Integer.parseInt(deadline), Integer.parseInt(promotion.getPromoId(promo)));
                                        for (String s : arr) {
                                            Email.sendEmail(s, "Simplon :New Brief has been added ");
                                        }
                                    } else {
                                        System.out.println("pleaaaase enter correct fields");
                                    }

                                break;
                            }
                            case "3": {
                                ArrayList<String> trainers = apprenant.getTrainersName(Integer.parseInt(promotion.getPromoId(promo)));
                                System.out.println("Students --------> |  ");
                                for (String trainer : trainers) {
                                    System.out.println("- " + trainer);
                                }
                                break;
                            }
                            case "4": {
                                param=false;
                                break;
                            }
                            default: {
                                System.out.println("you don't have any access to this platform");
                                break;
                            }
                        }
                    }
                }else{
                        System.out.println("filed to connect in your teacher's account");
                    }
                    break;
                }

            case 3: {
                if (systemApp.login(username, password, "apprenant")) {
                    while (param) {
                        System.out.println("-------------| Welcome " + username + " |-------------");
                        System.out.println("1 => - Briefs");
                        System.out.println("2 => - Logout");
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Choice a number ");
                        String ifChoiceApprenant = scanner.nextLine();

                        switch (ifChoiceApprenant) {
                            case "1": {
                                String studentId = apprenant.studentId(username);
                                    if (studentId != null) {
                                        String[][] getBriefs = apprenant.getBriefs(Integer.parseInt(studentId)); // if null
                                        System.out.println("Briefs --------> |  ");
//
                                        for (int i = 0; i < getBriefs.length-1; i++) {
                                            for (int j = 0; j < 1; j++){
                                                    System.out.println((i + 1) + " - " + getBriefs[i][1]);

                                            }
                                        }

                                    }

                                break;
                            }
                            case "2":
                                param = false;
                                break;
                            default:
                                System.out.println("you don't have any access to this platform");
                                break;
                        }
                    }

                    } else{
                        System.out.println("filed to connect in your Apprenant's account");
                    }

                    break;

            }
            default:
            {
                System.out.println("you don't have any access to this platform");
                break;
            }
        }
    }
}

