import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        display all promo
//        Admin admin = new Admin();
//        String[][] countTable = admin.selectAllPromos();
//        System.out.println(Arrays.deepToString(countTable));

//        insertion des briefs
        Formateur formateur = new Formateur();
        boolean rs = formateur.createBrief("margaret hamilton",5,3);
        System.out.println(rs);

//

    }
}