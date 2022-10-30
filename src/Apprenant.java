import java.sql.*;
import java.util.ArrayList;

public class Apprenant extends ConnexionDB {

    private String fullName;
    public String username;
    private String password;
    public String id;
    public Admin admin = new Admin();
    protected String[][] arrayVide = new String[0][0];
    protected ArrayList<String> arrayVidee = new ArrayList<>();
    public ArrayList<String> arr = new ArrayList<>();

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

    // 1 - method :  select * from brief where idP = ?
    // 2 - method :  select id from apprenant where username = ? (usernameApprenant)
    // 3 - method :  joins promo | apprenant = ? and id

    public ArrayList<String> studentName(){
        try{
            stmt = conn.prepareStatement("select fullName from apprenant where status = 0");
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                {
                    arr.add(rs.getString(i+1));
                }
            }
            return arr;

        }catch (Exception e)
        {
            System.out.println("error => "+e);
            return arrayVidee;
        }
    }

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

    public ArrayList<String> getTrainerNameStatus0()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select fullName from apprenant where status = 0");
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> arr = new ArrayList<>();
            while (rs.next())
            {
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                {
                    arr.add(rs.getString(i+1));
                }
            }
            return arr;

        }catch (Exception e)
        {
            System.out.println("error => "+e);
            return arrayVidee;
        }
    }
    public ArrayList<String> getTrainersName(int idP)
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select fullName from apprenant where idP = ? ");
            stmt.setInt(1, idP);
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> arr = new ArrayList<>();
            while (rs.next())
            {
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                {
                    arr.add(rs.getString(i+1));
                }
            }
            return arr;

        }catch (Exception e)
        {
            System.out.println("error => "+e);
            return arrayVidee;
        }
    }

    public String getIdTrainer(String fullName)
    {
        try{
            stmt = conn.prepareStatement("select id from apprenant where fullName = ?");
            stmt.setString(1, fullName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                id = rs.getString("id");
            }
            return id;
        }catch(Exception e)
        {
            System.out.println("error => "+e);
            return "0";
        }
    }

    public ArrayList<String> getBriefs(int idP)
    {
        try{
            stmt = conn.prepareStatement("select * from brief where idP = ? ");
            stmt.setInt(1, idP);
            ResultSet rs = stmt.executeQuery();
//            int a = admin.getNumberRows("brief");
//            int b = admin.getNumberColumn("brief");
//            int b = admin.getNumberColumn("brief");

//            String[][] briefs = new String[a][b];
            ArrayList<String> briefs = new ArrayList<>();

            while(rs.next())
            {
                briefs.add(rs.getString("context"));
            }
            rs.close();
            return briefs;
        }catch(Exception e)
        {
            System.out.println("error => "+e);
            return arrayVidee;
        }
    }

    public String studentId(String username)
    {
        try {
            stmt = conn.prepareStatement("select idP from apprenant where username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                this.id = rs.getString("idP");
            }
            return this.id;
        }catch (Exception e)
        {
            System.out.println("Error => "+e);
            return "0";
        }
    }



}