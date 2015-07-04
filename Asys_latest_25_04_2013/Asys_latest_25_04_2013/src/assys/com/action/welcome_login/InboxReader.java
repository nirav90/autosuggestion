package assys.com.action.welcome_login;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
 
@SuppressWarnings("all")
public class InboxReader {
 
 public void inbox() {
 
	 
	 
	 Properties props = System.getProperties();
 
// Uncomment if you are <span id="IL_AD7" class="IL_AD">using proxy server</span> to access Internet
/*   props.setProperty("http.proxyHost", "192.168.0.1");
props.setProperty("http.proxyPort", "8080"); */
 
	 	props.setProperty("mail.store.protocol", "imaps");
	 		try {
	 				Session session = Session.getDefaultInstance(props, null);
	 				session.setDebug(true);
	 				Store store = session.getStore("imaps");
	 				store.connect("imap.gmail.com", "nirav90up@gmail.com", "s1s2s3svnitgecgddit");
	 				System.out.println(store);
 
	 				Folder inbox = store.getFolder("Inbox");
	 				inbox.open(Folder.READ_ONLY);
	 				FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
	 				javax.mail.Message[] messages = inbox.search(ft);
	 				for (javax.mail.Message message : messages) {
	 					// 	message.setFlag(Flags.Flag.ANSWERED, true);
	 					// message.setFlag(Flags.Flag.SEEN, true);
	 				String subject = message.getSubject();
	 				String content = message.getContentType();
	 				MimeMultipart part = (MimeMultipart) message.getContent();
 
	 				BodyPart bodyPart = part.getBodyPart(0);
	 				part.getContentType();
	 				part.getCount();
	 				part.getPreamble();
 
	 					try {
	 							printParts(message);
	 					} catch (Exception e) {
	 						// 	TODO Auto-generated catch <span id="IL_AD4" class="IL_AD">block

	 					}
 
	 				Flags flags = message.getFlags();
	 				Address[] form = message.getFrom();
 
	 					}
	 					} catch (NoSuchProviderException e) {
	 						e.printStackTrace();
	 						System.exit(1);
	 						} catch (MessagingException e) {
	 							e.printStackTrace();
	 							System.exit(2);
	 						} catch (IOException e) {
	 							e.printStackTrace();
	 						}
 
 						}
 	
 				public static void printParts(Part p) throws Exception {
 					Object o = p.getContent();
 					if (o instanceof String) {
 						System.out.println("This is a String");
 						System.out.println((String) o);
 					} else if (o instanceof Multipart) {
 						System.out.println("This is a Multipart");
 						Multipart mp = (Multipart) o;
 						int count = mp.getCount();
 						for (int i = 0; i < count; i++) {
 							printParts(mp.getBodyPart(i));
 						}
 					} else if (o instanceof InputStream) {
 						System.out.println("This is just an input stream");
 						InputStream is = (InputStream) o;
 						int c;
//            	while ((c = is.read()) != -1)
//                System.out.write(c);
 					}
 				}
 				
	}
