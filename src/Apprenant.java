import java.sql.*;

public class Apprenant extends ConnexionDB {

    private String fullName;
    private String username;
    private String password;

    public Apprenant()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select * from formateur");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                System.out.println(rs);
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}