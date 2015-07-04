package demo;

	import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/*import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

*/	/**
	 * @author kartik
	 *
	 */
	public class SendEmail
	{
		
		public static void sendMail(String to, String subject, String content)
		{
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
//			props.put("mail.smtp.port", "465");
			
			final String userName="nirav.nirav90up@gmail.com";
			final String password="09111991";
			
		/*	org.hibernate.Session dataSession = GetSession.getSession();
			Transaction transaction=dataSession.beginTransaction();
			transaction.begin();
			Query query;
		*/	
//			password=(String) query.list().get(0);
			props.put("mail.from", userName);
			System.out.println(userName);
//			System.out.println(password);
			javax.mail.Session session = javax.mail.Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, password);
				}
			  });
	 
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(userName));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
				message.setSubject(subject);
				message.setContent(content, "text/html; charset=utf-8");
				Transport.send(message);
	 
				System.out.println("Done");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
		}
		public static void main(String args[])
		{
			System.out.println(System.getProperty("user.dir"));
				try {
					SendEmail.sendMail("nirav90up@gmail.com", "hello", "hi");
				} catch (Exception e) {
					e.printStackTrace();
				}
		

			}

		}

