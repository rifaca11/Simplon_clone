import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void mainMenu(){

        System.out.println("######| Login |######\n");
        System.out.println("1 ) - Admin");
        System.out.println("2 ) - Teacher");
        System.out.println("3 ) - Student");
//

        Scanner s1 = new Scanner(System.in);
        System.out.print("|--> ");
        int choice = s1.nextInt();
        ChoiceMenu ChoiceMenu = new ChoiceMenu(choice, s1);
    }
    public static void main(String[] args) {

        mainMenu();



//        Apprenant apprenant = new Apprenant();
//        String studentId = apprenant.studentId("abdelhaq");
//        System.out.println(studentId);

//        display all promo
//        Admin admin = new Admin();
//        String[][] countTable = admin.selectAllPromos();
//        System.out.println(Arrays.deepToString(countTable));


//        Insertion des briefs
//        Formateur formateur = new Formateur();
//        boolean rs = formateur.createBrief("margaret hamilton",5,3);
//        System.out.println(rs);

       // Display all briefs
//        Apprenant apprenant = new Apprenant();
//        String[][] rs = apprenant.selectAllBriefs();
//        System.out.println(Arrays.deepToString(rs));

//        Add student in promo by formateur
//          Formateur formateur = new Formateur();
//          boolean rs = formateur.AddApprenantPromo(3,5);
//          System.out.println(rs);

//          Add student in promo by formateur
//          Admin admin = new Admin();
//          boolean rs = admin.AddFormateurPromo(4,3);
//          System.out.println(rs);
//
//            Apprenant apprenant = new Apprenant();
//
//            String a = apprenant.studentId("abdelhaq");
//            System.out.println(Integer.parseInt(a));







    }


}
