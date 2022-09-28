import java.sql.ResultSet;

public class Formateur extends ConnexionDB {
    private String username;
    private String fullName;
    private String password;

    public Formateur()
    {
        //
    }

//    creation des briefs
    public boolean createBrief(String context, int deadline, int idP)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into brief (context, deadline, idP) values (?, ?, ?)");
            stmt.setString(1, context);
            stmt.setInt(2, deadline);
            stmt.setInt(3, idP);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public String[][] selectAllBriefs()
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from brief");
            ResultSet rs = stmt.executeQuery();
            int a = getNumberRows("brief");
            int b = getNumberColumn("brief");
            String[][] arr2 = new String[a][b];

            int i = 0;
            while(rs.next())
            {
                for(int j = 0; j < b; j++)
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