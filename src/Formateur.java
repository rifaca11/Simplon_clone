import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Formateur extends ConnexionDB {
    private String username;
    private String fullName;
    private String password;
    protected ArrayList<String> arrayVidee = new ArrayList<>();



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
            System.out.println("error =>" + e);
            return false;
        }
    }

    public boolean AddApprenantPromo(int idP, int id)
    {
        try{
            stmt = conn.prepareStatement("update apprenant set idP = ?,status = 1 where id = ?");
            stmt.setInt(1, idP);
            stmt.setInt(2, id);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println( "error =>" +e);
            return false;
        }
    }











}