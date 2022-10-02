import java.sql.ResultSet;
public class Sys extends ConnexionDB{

    public boolean login(String username, String password, String table)
    {
        try{
            stmt = conn.prepareStatement("select * from "+table+" where username = ? and password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            boolean a = false;
            while(rs.next()) // 1
            {
                if(rs.getString(2).equals(username) && rs.getString(3).equals(password))
                {
                    a = true;
                }else{
                    System.out.println("username | password not found !");
                    a = false;
                }
            }
            return a;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }
}