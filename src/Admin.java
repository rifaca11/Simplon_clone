import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Admin extends ConnexionDB {

    private String username;
    private String password;
    private String email;
    protected String[][] arrayVide = new String[0][0];
    protected ArrayList<String> arr = new ArrayList<String>();

    public Admin() {
        //Construct
    }

    //creation of any account ( formateur / apprenant )
    public boolean createAccount(String table, String fullName, String username, String password) {
        try {
            stmt = conn.prepareStatement("insert into " + table + " (fullName, username, password) values (?, ?, ?)");
            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, password);
            int rs = stmt.executeUpdate();
            return rs == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // Display All accounts
    public String[][] selectAllAccounts(String table) {
        try {
            stmt = conn.prepareStatement("select * from " + table);
            ResultSet rs = stmt.executeQuery();
            int a = getNumberRows(table);
            int b = getNumberColumn(table);
            String[][] arr2 = new String[a][b];

            int i = 0;
            while (rs.next()) {
                for (int j = 0; j < b; j++) {
                    arr2[i][j] = rs.getString(j + 1);
                }
                i++;
            }
            rs.close();
            return arr2;
        } catch (Exception e) {
            System.out.println("error => " + e);
            return arrayVide;
        }
    }

    // Display account by id
    public ArrayList<String> selectOneAccount(String table, int id) {
        try {
            stmt = conn.prepareStatement("select * from " + table + " where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // next() - 1 - 2 - 3 - 4 - 5

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    arr.add(rs.getString(i));
                }
            }
            return arr;
        } catch (Exception e) {
            System.out.println("error => " + e);
            return arr;
        }
    }

    public int getNumberRows(String table) {
        try {
            stmt = conn.prepareStatement("select * from " + table, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            if (rs.last()) {
                return rs.getRow();
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return 0;
    }

    public int getNumberColumn(String table) {
        try {
            stmt = conn.prepareStatement("select * from " + table, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData count = rs.getMetaData();
            int numOfCols = count.getColumnCount();
            return numOfCols;

        } catch (Exception e) {
            System.out.println(e);
            return 0;

        }
    }


    // Update account infos
    public boolean updateAccount(String table, String fullName, String username, String password) {
        try {
            stmt = conn.prepareStatement("update " + table + " set fullName = ?, username = ?, password = ?");
            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, password);
            int rs = stmt.executeUpdate();
            return rs == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // Delete account
    public boolean deleteAccount(String table, int id) {
        try {
            stmt = conn.prepareStatement("delete from " + table + " where id = ?");
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            return rs == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //    create promo
    public boolean createPromo(String name) {
        try {
            stmt = conn.prepareStatement("insert into promotion (name) values (?)");
            stmt.setString(1, name);
            int rs = stmt.executeUpdate();
            return rs == 1;
        } catch (Exception e) {
            System.out.println("error => " + e);
            return false;
        }
    }

    //    Display Promos by id
    public ArrayList<String> selectPromo(int id) {
        try {
            stmt = conn.prepareStatement("select * from promotion where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // next() - 1 - 2 - 3 - 4 - 5

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    arr.add(rs.getString(i));
                }
            }
            return arr;
        } catch (Exception e) {
            System.out.println("error => " + e);
            return arr;
        }
    }

    //    Display All promo
    public String[][] selectAllPromos() {
        try {
            stmt = conn.prepareStatement("select * from promotion");
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            int a = getNumberRows("promotion");
            int b = getNumberColumn("promotion");
            String[][] arr2 = new String[a][b];
            while (rs.next()) {
                for (int j = 0; j < b; j++) {
                    arr2[i][j] = rs.getString(j + 1);
                }
                i++;
            }
            rs.close();
            return arr2;
        } catch (Exception e) {
            System.out.println("error => " + e);
            return arrayVide;
        }
    }

    //    add teacher to promo
    public boolean AddFormateurPromo(int idF, int id) {
        try {
            stmt = conn.prepareStatement("update promotion set idF = ? where id = ?");
            stmt.setInt(1, idF);
            stmt.setInt(2, id);
            int rs = stmt.executeUpdate();
            return rs == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String getIdPromo(String name) {
        try {
            String id = "0";
            stmt = conn.prepareStatement("select id from promotion where name = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                id = rs.getString("id");
            }
            return id;
        } catch (Exception e)
        {
            System.out.println("error => "+e);
            return "0";
        }
    }

    public String getIdTeacher(String name) {
        try {
            String id = "0";
            stmt = conn.prepareStatement("select id from formateur where name = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                id = rs.getString("id");
            }
            return id;
        } catch (Exception e)
        {
            System.out.println("error => "+e);
            return "0";
        }
    }

    public String countPromosNot()
    {
        try{
            stmt = conn.prepareStatement("select count(*) from promotion where status = 0");
            ResultSet rs = stmt.executeQuery();
            String count = "0";
            while(rs.next())
            {
                count = rs.getString(1);
            }
            return count;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return "false";
        }
    }


    public boolean updateStatusteacher(int idF)
    {
        try{
            stmt = conn.prepareStatement("update formateur set status = 1 where id = ?");
            stmt.setInt(1, idF);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }


}