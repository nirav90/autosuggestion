package assys.com.gmail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.*;

class ReceiveMail{
  public static void main(String [] args)throws Exception{
   
   String host="pop3.gmail.com";
   final String user="nirav.nirav90up@gmail.com";
   final String password="09111991";//change accordingly

   Properties properties = System.getProperties();
   properties.setProperty("mail.smtp.host",host );
   properties.put("mail.smtp.auth", "true");

   Session session = Session.getDefaultInstance(properties,
    new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
     return new PasswordAuthentication(user,password);
    }
   });
      
     Store store = session.getStore("pop3");
     store.connect(host,user,password);

     Folder folder = store.getFolder("inbox");
     folder.open(Folder.READ_WRITE);

     Message[] message = folder.getMessages();


  for (int a = 0; a < message.length; a++) {
    System.out.println("-------------" + (a + 1) + "-----------");
    System.out.println(message[a].getSentDate());

    Multipart multipart = (Multipart) message[a].getContent();
 
    for (int i = 0; i < multipart.getCount(); i++) {
     BodyPart bodyPart = multipart.getBodyPart(i);
     InputStream stream = bodyPart.getInputStream();
     BufferedReader br = new BufferedReader(new InputStreamReader(stream));

      while (br.ready()) {
       System.out.println(br.readLine());
      }
     System.out.println();
    }
   System.out.println();
  }

  folder.close(true);
  store.close();
  }
}
