import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Admin extends ConnexionDB{
    private String username;
    private String password;
    private String email;
    protected String arrayVide[][] = new String[0][0];
    protected ArrayList<String> arr = new ArrayList<String>();

    public Admin()
    {
        //Construct
    }
//creation of any account ( formateur / apprenant )
    public boolean createAccount(String table, String fullName, String username, String password)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into "+table+" (fullName, username, password) values (?, ?, ?)");
            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, password);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

// Display All accounts
    public String[][] selectAllAccounts(String table)
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from " + table);
            ResultSet rs = stmt.executeQuery();
            int a = getNumberRows(table);
            int b = getNumberColumn(table);
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

 // Display account by id
//    public ArrayList<String> selectAllAccount(String table)
//    {
//        try{
//            this.stmt = this.conn.prepareStatement("select * from " + table);
//            ResultSet rsCount = stmt.executeQuery();
//
//
//        }catch (Exception e)
//        {
//            System.out.println("error => " + e);
//            return arr;
//        }
//    }

    public int getNumberRows(String table){
        try{
            stmt = conn.prepareStatement("select * from " + table,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            if(rs.last()){
                return rs.getRow();
            } else {
                return 0;
            }
        } catch (Exception e){
            System.out.println(e);

        }
        return 0;
    }
    public int getNumberColumn(String table) {
        try {
            this.stmt = this.conn.prepareStatement("select * from " + table, ResultSet.TYPE_SCROLL_INSENSITIVE,
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
    public boolean updateAccount(String table, String fullName, String username, String password)
    {
        try {
            this.stmt = this.conn.prepareStatement("update "+ table +" set fullName = ?, username = ?, password = ?");
            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, password);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

// Delete account
    public boolean deleteAccount(String table, int id)
    {
        try {
            this.stmt = this.conn.prepareStatement("delete from "+ table +" where id = ?");
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

//    create promo
    public boolean createPromo(String name)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into promotion (name) values (?)");
            stmt.setString(1, name);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }

//    Display all Promos
    public ArrayList<String> selectPromo(int id)
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from promotion where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // next() - 1 - 2 - 3 - 4 - 5

            while(rs.next())
            {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    arr.add(rs.getString(i));
                }
            }
            return arr;
        }catch (Exception e)
        {
            System.out.println("error => " + e);
            return arr;
        }
    }

//    Display promo by id
    public String[][] selectAllPromos()
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from promotion");
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            int a = getNumberRows("promotion");
            int b = getNumberColumn("promotion");
            String[][] arr2 = new String[a][b];
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