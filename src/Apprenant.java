import java.sql.*;

public class Apprenant extends ConnexionDB {

    private String fullName;
    private String username;
    private String password;
    public Admin admin = new Admin();
    protected String arrayVide[][] = new String[0][0];

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

    public String[][] selectAllBriefs()
    {
        try{
            this.stmt = this.conn.prepareStatement("select B.id,B.context,B.deadline,B.idP,P.id,P.name,P.idF from brief B, promotion P where B.id = P.id");
            ResultSet rs = stmt.executeQuery();

            int a = admin.getNumberRows("brief");

            int c = admin.getNumberColumn("brief");
            int d = admin.getNumberColumn("promotion");

            String[][] arr2 = new String[a][c+d];

            int i = 0;
            while(rs.next())
            {
                for(int j = 0; j < c+d; j++)
                {
                    arr2[i][j] = rs.getString(j+1);
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