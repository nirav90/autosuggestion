package assys.com.gmail;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailTest 
{

    public static void send(String[] args) {
    
/*  if (args.length != 5) 
  {
      System.out.println("usage: java sendfile <to> <from> <smtp> <file>");
      System.exit(1);
  }*/

  String to = "nirav.nirav90up@gmail.com";
  String from = "nirav90up@gmail.com";
  String host = "smtp.gmail.com";
  String filename = "c:/user.txt";
  String msgText1 = "Sending a file.\n";
  String subject = "Sending a file";
  
  // create some properties and get the default Session
  Properties props = System.getProperties();
  props.put("mail.smtp.host", host);
  
  Session session1 = Session.getInstance(props, null);
  
  
  session1 = Session.getInstance(props,
          new javax.mail.Authenticator() {

              protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication("nirav90up@gmail.com", "s1s2s3svnitgecgddit");
              }
          });

  session1.setDebug(true);
  

  try 
  {
      // create a message
	  System.out.println("line 1");
      MimeMessage msg = new MimeMessage(session1);
      System.out.println("line 1");
      msg.setFrom(new InternetAddress(from));
      System.out.println("line 1");
      InternetAddress[] address = {new InternetAddress(to)};
      System.out.println("line 1");
      msg.setRecipients(Message.RecipientType.TO, address);
      msg.setSubject(subject);

      // create and fill the first message part
      MimeBodyPart mbp1 = new MimeBodyPart();
      mbp1.setText(msgText1);

      // create the second message part
      MimeBodyPart mbp2 = new MimeBodyPart();

            // attach the file to the message
         FileDataSource fds = new FileDataSource(filename);
      mbp2.setDataHandler(new DataHandler(fds));
      mbp2.setFileName(fds.getName());

      // create the Multipart and add its parts to it
      Multipart mp = new MimeMultipart();
      mp.addBodyPart(mbp1);
      mp.addBodyPart(mbp2);

      // add the Multipart to the message
      msg.setContent(mp);

      // set the Date: header
      msg.setSentDate(new Date());
      
      // send the message
      Transport transport = session1.getTransport("smtp");  
      
       

          transport.connect("nirav90up@gmail.com", "s1s2s3svnitgecgddit");  
          transport.sendMessage(msg, msg.getAllRecipients());  

      Transport.send(msg);
      
  } 
  catch (MessagingException mex) 
  {
      mex.printStackTrace();
      Exception ex = null;
      if ((ex = mex.getNextException()) != null) {
    ex.printStackTrace();
      }
  }

    }
}
