import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        display all promo
//        Admin admin = new Admin();
//        String[][] countTable = admin.selectAllPromos();
//        System.out.println(Arrays.deepToString(countTable));

//        Insertion des briefs
//        Formateur formateur = new Formateur();
//        boolean rs = formateur.createBrief("margaret hamilton",5,3);
//        System.out.println(rs);

//        Display all briefs
        Apprenant apprenant = new Apprenant();
        String[][] rs = apprenant.selectAllBriefs();
        System.out.println(Arrays.deepToString(rs));


    }
}