import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        String[][] countTable = admin.selectAllPromos();
        System.out.println(Arrays.deepToString(countTable));

    }
}