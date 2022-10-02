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
            stmt = conn.prepareStatement("insert into brief (context, deadline, idP) values (?, ?, ?)");
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

    public boolean AddApprenantPromo(int idP,int id)
    {
        try{
            stmt = conn.prepareStatement("update apprenant set idP = ? where id = ?");
            stmt.setInt(1, idP);
            stmt.setInt(2, id);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }







}