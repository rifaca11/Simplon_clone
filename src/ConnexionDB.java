import java.sql.*;


// Infos BD
public class ConnexionDB {
    final String url = "jdbc:mysql://localhost:3306/simplon_clone";
    final String username = "root";
    final String password = "";
    protected Connection conn;
    protected PreparedStatement stmt;

// Connect BD a MYSQL
    public ConnexionDB()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, username, password);
            // System.out.println("conn true");
        }catch(Exception e)
        {
            System.out.println("error => " + e);
        }
    }
}