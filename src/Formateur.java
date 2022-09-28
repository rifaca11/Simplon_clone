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



}