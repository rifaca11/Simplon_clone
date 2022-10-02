import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import services.Courier;
import services.SendService;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;

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



    public static void sendEmail(String mailMessage, String mail){
            Courier.init("pk_prod_PSBPTP5CBFMT1GQ1MZSAK1SRPXKC");

        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", mail);
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "Simplonline : Nouveau Brief");
        content.put("body", " Bonjour\n" +
                "\n" +
                "Votre formateur a assigné nouveau brief à votre promo.\n" +
                "\n" +
                "Merci et à très vite sur la plateforme d’apprentissage made in Simplon ! ");
        sendRequestMessage.setContent(content);

        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
