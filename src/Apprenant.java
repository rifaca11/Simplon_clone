import java.sql.*;
import java.util.ArrayList;

public class Apprenant extends ConnexionDB {

    private String fullName;
    private String username;
    private String password;
    public Admin admin = new Admin();
    protected String[][] arrayVide = new String[0][0];
    protected ArrayList<String> arrayVidee = new ArrayList<>();

    public Apprenant()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select * from formateur");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                //System.out.println(rs);
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

//   Display briefs to students
    public String[][] selectAllBriefs()
    {
        try{
            stmt = conn.prepareStatement("select DISTINCT B.context,B.idP,P.id,P.name,P.status,P.idF,A.idP from brief B, promotion P,apprenant A where B.idP = P.id and A.idP = P.id");
            ResultSet rs = stmt.executeQuery();

            int a = admin.getNumberRowsNotNull("brief");

            String[][] arr2 = new String[a-1][7];

            int i = 0;
            while(rs.next())
            {
                for(int j = 0; j < 7; j++)
                {
                    arr2[i][j] = (rs.getString(j+1));
                }
                i++;
            }
            rs.close();
            return arr2;
        }catch (Exception e)
        {
            System.out.println("error => " + e);
            return arrayVide;
        }
    }

}