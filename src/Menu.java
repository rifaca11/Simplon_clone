import java.util.Arrays;
import java.util.Scanner;

public class Menu extends ConnexionDB{
    public Menu(int choice, Scanner sc)
    {

        System.out.println("------------------------ WELCOME TO SIMPLON ------------------------");
        System.out.println("-------------------------collaborative learning platform in active pedagogy------------------------");
        System.out.print("----------------- Enter your username : ----------------- ");
        String username = s1.next();
        System.out.print("Enter password : |--> ");
        String password = s1.next();

        Sys systemApp = new Sys();
// switch about choice
        switch (choice)
        {
            case 1:
            {
                if(systemApp.login(username, password, "admin"))
                {
                    // Declaration
                    Admin admin = new Admin();

                    System.out.println("------------------------ Welcome " + username + " to your space account ------------------------");
                    System.out.println("1 => - Create account's teacher");
                    System.out.println("2 => - Create account's trainer");
                    System.out.println("3 => - Create a Promo");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println("4 => - See list of promos");
                    System.out.println("5 => - See list of accounts");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println("6 => - Add teacher in his promo");
                    System.out.println("7 => - Update account's infos");
                    System.out.println("8 => - Delete account");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println("9 => - Logout");

                    Scanner scanner = new Scanner(System.in);
                    System.out.print("--------- ");
                    String ifChoiceAdmin = scanner.nextLine();

                    if(ifChoiceAdmin == "1" || ifChoiceAdmin == "2")
                    {
                        String type = ifChoiceAdmin == "1" ? "teacher" : "Student";
                        String table = type == "teacher" ? "formateur" : "apprenant";

                        System.out.println("Create a "+ type +" account -------- |");
                        System.out.print("fullName : ");
                        String fullNameInput = scanner.nextLine();
                        System.out.print("username : ");
                        String usernameInput = scanner.nextLine();
                        System.out.print("password : ");
                        String passwordInput = scanner.nextLine();
                        scanner.close();

                        admin.createAccount(table, fullNameInput, usernameInput, passwordInput);
                    }else if (ifChoiceAdmin == "3")
                    {
                        System.out.println("Create a Promo -------- |");
                        String promoName = scanner.nextLine();
                        System.out.println("Promo Name : ");

                        admin.createPromo("promoName");
                    }else if (ifChoiceAdmin == "4")
                    {
                        System.out.println("-----------------------------------------------------------");
                        String[][] arr = admin.selectAllPromos();

                        for(int i = 0; i < arr.length; i++)
                        {
                            for(int j = 0; j < 1; j++)
                            {
                                // Show All promo names
                                System.out.println((i+1)+" ) - "+arr[i][1]);
                            }
                        }
                        System.out.println("choose a promo : ");
                        String choixPromo = scanner.nextLine();

                        String promo = arr[Integer.parseInt(choixPromo)-1][1];
                        String idPromo = admin.getIdPromo(promo);

                        String[][] arr1 = admin.selectAllAccounts("formateur");

                        for(int i = 0; i < arr1.length; i++)
                        {
                            for(int j = 0; j < 1; j++)
                            {
                                // Show All promo names
                                System.out.println((i+1)+" ) - "+arr1[i][1]);
                            }
                        }

                        System.out.println("choose a teacher to add it in promo "+promo);
                        String choiceATeacher = scanner.nextLine();

                        String teacher = arr1[Integer.parseInt(choiceATeacher)-1][1];
                        String idTeacher = admin.getIdTeacher(teacher);

                        // assign former to promotion
                        admin.AddFormateurPromo(Integer.parseInt(idTeacher), Integer.parseInt(idPromo));

                        System.out.println("-----------------------------------------------------------");
                    }
                }else{
                    System.out.println("filed to connect in your admin's account");
                }
                break;
            }
            case 2:
            {
                if(systemApp.login(username, password, "formateur"))
                {
                    // Declaration
                    Formateur former = new Formateur();

                    System.out.println("------------------------ Welcome " + username + " to your space account ------------------------");
                    System.out.println("1 => - Add Trainer to Promo");
                    System.out.println("2 => - Create a Brief");
                    System.out.println("3 => - List of students promo");
                    System.out.println("4 => - Logout");

                }else{
                    System.out.println("filed to connect in your teacher's account");
                }
                break;
            }
            case 3:
            {
                if(systemApp.login(username, password, "apprenant"))
                {
                    // Declaration
                    Apprenant apprenant = new Apprenant();

                    System.out.println("-------------| Welcome " + username + " |-------------");
                    System.out.println("1 => - Briefs");
                    System.out.println("2 => - Logout");


                }else{
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