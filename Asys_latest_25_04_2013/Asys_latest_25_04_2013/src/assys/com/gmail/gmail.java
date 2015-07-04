package assys.com.gmail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.ParseException;
import javax.mail.search.FlagTerm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.mail.handlers.multipart_mixed;

import assys.com.dbBean.InboxMasterBean;
import assys.com.dbDAO.InboxMaster;
import assys.com.gmail.SendMailUsage.HTMLDataSource;

/**
 *
 * @author Nirav
 */

public class gmail {

    private String userName;
    private String password;
    private String sendingHost;
    private int sendingPort;
    private String from;
    private String to;
    private String subject;
    private String text;
    private String receivingHost;
    private File fileName;
    private File uploadFile;
    static int level = 0;
    static String ct = null;
    static boolean showStructure = false;
    static boolean showMessage = false;
    static boolean showAlert = false;
    static boolean saveAttachments = false;
    static int attnum = 1;

//    private int receivingPort;

    public void setAccountDetails(String userName,String password){

        this.userName=userName;//sender's email can also use as User Name
        this.password=password;

    }

    public void sendGmail(String from, String to, String subject, String text) throws IOException{

         // This will send mail from -->sender@gmail.com to -->receiver@gmail.com

        this.from=from;
        this.to=to;
        this.subject=subject;
        this.text=text;

        // For a Gmail account--sending mails-- host and port shold be as follows

        this.sendingHost="smtp.gmail.com";
        this.sendingPort=465;

        Properties props = new Properties();

        props.put("mail.smtp.host", this.sendingHost);
        props.put("mail.smtp.port", String.valueOf(this.sendingPort));
        props.put("mail.smtp.user", this.userName);
        props.put("mail.smtp.password", this.password);

        props.put("mail.smtp.auth", "true");

	     Session session1 = Session.getDefaultInstance(props);

	     Message simpleMessage = new MimeMessage(session1);

        //MIME stands for Multipurpose Internet Mail Extensions

		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;

		try {

			fromAddress = new InternetAddress(this.from);
			toAddress = new InternetAddress(this.to);

		} catch (AddressException e) {

			e.printStackTrace();

                       

		}

		try {

			simpleMessage.setFrom(fromAddress);

			simpleMessage.setRecipient(RecipientType.TO, toAddress);

                        // to add CC or BCC use
                        // simpleMessage.setRecipient(RecipientType.CC, new InternetAddress("CC_Recipient@any_mail.com"));
                        // simpleMessage.setRecipient(RecipientType.BCC, new InternetAddress("CBC_Recipient@any_mail.com"));

			simpleMessage.setSubject(this.subject);

			simpleMessage.setText(this.text);

        //sometimes Transport.send(simpleMessage); is used, but for gmail it's different
			
			
			setHTMLContent(simpleMessage);
			

            Transport transport = session1.getTransport("smtps");

            transport.connect (this.sendingHost,sendingPort, this.userName, this.password);

            transport.sendMessage(simpleMessage, simpleMessage.getAllRecipients());

            transport.close();

            /*JOptionPane.showMessageDialog(null, "Mail sent successfully ...","Mail sent",JOptionPane.PLAIN_MESSAGE);*/

		} catch (MessagingException e) {

			e.printStackTrace();

                       /*JOptionPane.showMessageDialog(null, "Sending email to: " + to + " failed !!!", "Falied to Send!!!", JOptionPane.ERROR_MESSAGE);*/

		}

    }
    
    
    
    public void attachFile(String from, String to, String subject, String text,String fileName) throws IOException
    {
    	
    	// SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!
    	this.from=from;
        this.to=to;
        this.subject=subject;
        this.text=text;
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        String host = "smtp.gmail.com";

        // Create properties for the Session
        Properties props = new Properties();

        // If using static Transport.send(),
        // need to specify the mail server here
        props.put("mail.smtp.host", host);
        // To see what is going on behind the scene
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true"); // added this line  
	       
        props.put("mail.smtp.port",587);  
	     props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.required", "true");
        // Get a session
        Session session = Session.getInstance(props);

        try {
            // Get a Transport object to send e-mail
            Transport bus = session.getTransport("smtp");

            // Connect only once here
            // Transport.send() disconnects after each send
            // Usually, no username and password is required for SMTP
            //bus.connect();
            System.out.println(this.userName);
            System.out.println(this.password);
            bus.connect(host, this.userName, this.password);

            // Instantiate a message
            Message msg = new MimeMessage(session);

            // Set message attributes
            msg.setFrom(new InternetAddress(this.from));
            InternetAddress[] address = {new InternetAddress(this.to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            // Parse a comma-separated list of email addresses. Be strict.
            msg.setRecipients(Message.RecipientType.CC,
                                InternetAddress.parse(to, true));
            // Parse comma/space-separated list. Cut some slack.
            msg.setRecipients(Message.RecipientType.BCC,
                                InternetAddress.parse(to, false));

            msg.setSubject(this.subject);
            msg.setSentDate(new Date());

            // Set message content and send
            setTextContent(msg);
            msg.saveChanges();
           // bus.sendMessage(msg, address);

            setMultipartContent(msg);
            msg.saveChanges();
           // bus.sendMessage(msg, address);
            System.out.println("about to attach");
            System.out.println(fileName);
            setFileAsAttachment(msg, "E:\\"+fileName ,this.text);
           //msg.saveChanges();
            //bus.sendMessage(msg, address);

           //setHTMLContent(msg);
           msg.saveChanges();
           bus.sendMessage(msg, address);

            bus.close();

        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
            // How to access nested exceptions
            while (mex.getNextException() != null) {
                // Get next exception in chain
                Exception ex = mex.getNextException();
                ex.printStackTrace();
                if (!(ex instanceof MessagingException)) break;
                else mex = (MessagingException)ex;
            }
        }
    	
    	
    	 
    	  
    }
    

    public void readAllGmail(){
    	
  
    	HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		
		InboxMasterBean inboxMasterBean = new InboxMasterBean();
		
		InboxMaster inboxMaster = new InboxMaster();
		
		
		

        /*this will print subject of all messages in the inbox of sender@gmail.com*/

        this.receivingHost="imap.gmail.com";//for imap protocol

        Properties props2=System.getProperties();

        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here

        Session session2=Session.getDefaultInstance(props2, null);

            try {

                    Store store=session2.getStore("imaps");

                    store.connect(this.receivingHost,this.userName, this.password);
                    
                    System.out.println(this.userName);
                    
                    System.out.println(this.password);

                    Folder folder=store.getFolder("INBOX");//get inbox

                    folder.open(Folder.READ_ONLY);//open folder only to read

                    System.out.println("after folder open");
                    /*Message message[] = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));*/ 

                    /*System.out.println(unreadMessages);*/
                    
                    Message message[]=folder.getMessages();
                    
                    session.setAttribute("msgcount", message.length);

                    
                    System.out.println("message get");
                    for(int i=0;i<message.length;i++){

                        //print subjects of all mails in the inbox

                    	
                    
                    	
                    	System.out.println("message number"+message[i].getMessageNumber());
                    	inboxMasterBean.setMailNo(message[i].getMessageNumber());
                    	
                    	inboxMasterBean.setEmpUserId(sd);
                    	

                    	
                    	inboxMasterBean.setEmailSendDateTime(message[i].getReceivedDate());
                    	String msgSubject=message[i].getSubject();
                    	inboxMasterBean.setEmailSubject(msgSubject.replace("'", "\\'"));
                    	inboxMasterBean.setEmailSubject(message[i].getSubject());
                    	
                    	
                    	
                    	Address[] addressTo = new javax.mail.internet.InternetAddress[100];
                    	addressTo = message[i].getFrom();
                    	System.out.print("address we gets"+addressTo[0].toString());
                    	inboxMasterBean.setSenderEmailId(addressTo[0].toString());
                    	inboxMaster.insert(inboxMasterBean);
                    	
                        //anything else you want

                    }

                    //close connections

                    folder.close(true);

                    store.close();

            } catch (Exception e) {

                    System.out.println(e.toString());

            }

    }

   
    public Message readContent( int mailNo)
    {
    	
    	 
    	Message flag = null;
    	
 
    	HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		
		InboxMasterBean inboxMasterBean = new InboxMasterBean();
		
		InboxMaster inboxMaster = new InboxMaster();
		
		
		

        /*this will print subject of all messages in the inbox of sender@gmail.com*/

        this.receivingHost="imap.gmail.com";//for imap protocol

        Properties props2=System.getProperties();

        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here

        Session session2=Session.getDefaultInstance(props2, null);

            try {

                    Store store=session2.getStore("imaps");

                    store.connect(this.receivingHost,this.userName, this.password);

                    System.out.println(this.userName);
                    
                    System.out.println(this.password);
                    
                    
                    Folder folder=store.getFolder("INBOX");//get inbox

                    folder.open(Folder.READ_WRITE);//open folder only to read
                    
                    
                    Message message=folder.getMessage(mailNo);
                    
                   //dumpPart(message);
                    
                    /*String mimeType = message.getContentType();
                    
                    Object o = message.getContent();
                    
                    message.setFlag(Flags.Flag.SEEN, true);
                    
                    */         
                    /*folder.close(false);

                    store.close();
*/                    
                    flag=message;

                }
            
                    
            
            

             catch (Exception e) {

                    System.out.println(e.toString());

            }
           /* return flag;*/
			return flag;

    	
    	
    }
    
    
    
    
    public void unreadAllGmail() throws SQLException
    {
    	
    	System.out.println("in unreadallgmail");
    	
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	
		String sd = (String)session.getAttribute("employee_ID");
    	 
		
		InboxMasterBean inboxMasterBean = new InboxMasterBean();
		
		
		InboxMaster inboxMaster = new InboxMaster();
		
		inboxMasterBean.setEmpUserId(sd);
		
		ResultSet rs =  inboxMaster.select(inboxMasterBean);
		
		 
		 int j = 0;
		 while(rs.next())
		 {
			 j++;
		 } 
		
		 System.out.println("message count in inboxMaster"+j);

        /*this will print subject of all messages in the inbox of sender@gmail.com*/

        this.receivingHost="imap.gmail.com";//for imap protocol

        Properties props2=System.getProperties();

        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here

        Session session2=Session.getDefaultInstance(props2, null);

            try {

                    Store store=session2.getStore("imaps");

                    store.connect(this.receivingHost,this.userName, this.password);

                    Folder folder=store.getFolder("INBOX");//get inbox

                    folder.open(Folder.READ_WRITE);//open folder only to read

                    
                    Message message[]=folder.getMessages();

                    /*System.out.println(unreadMessages);*/
                    
             /*       Message message[]=folder.getMessages();*/
                    
                    session.setAttribute("msgcount", message.length);
                    
                    int msgcount = message.length;
                    
                    System.out.println("message count in gmail :"+msgcount);
                    
                    if(j<msgcount)
                   
                    {	
                  
                    	
                    	int unread = msgcount-j;
                    	
                    	session.setAttribute("unread", unread);
                  /* Message message1[] = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));*/	
                    	
                    for(int i=(j+1);i<=message.length;i++){

                        //print subjects of all mails in the inbox

                    	
                    	
                    	System.out.println(j+1);
                    	

                    	
                    	inboxMasterBean.setEmailSendDateTime(message[i].getReceivedDate());
                    	
                    	String msgSubject=message[i].getSubject();
                    	
                    	if(msgSubject==null){
                    		inboxMasterBean.setEmailSubject("(no subject)");
                    	}else{
                    	inboxMasterBean.setEmailSubject(msgSubject.replace("'", "\\'"));
                    	}
                    	
                    	inboxMasterBean.setMailNo(message[i].getMessageNumber());
                    	
                    	Address[] addressTo = new javax.mail.internet.InternetAddress[100];
                    	addressTo = message[i].getFrom();
                    	System.out.print("address we gets"+addressTo[0].toString());
                    	inboxMasterBean.setSenderEmailId(addressTo[0].toString());
                    	inboxMaster.insert(inboxMasterBean);
                    	
                        //anything else you want

                    }
                    
                    }
                    

                    //close connections

                    folder.close(true);

                    store.close();

            } catch (Exception e) {

                    System.out.println(e.toString());

            }
    	
    	
    	
    	
    }
    
    public static void setHTMLContent(Message msg) throws MessagingException, IOException {

    	
    	EmailTemplate e = new EmailTemplate();
    	
    	
    	
        String html = e.headerHtml()+msg.getContent()+e.footerHtml();
        // HTMLDataSource is an inner class
        msg.setDataHandler(new DataHandler(new HTMLDataSource(html)));
    }



    /*
     * Inner class to act as a JAF datasource to send HTML e-mail content
     */
    static class HTMLDataSource implements DataSource {
        private String html;

        public HTMLDataSource(String htmlString) {
            html = htmlString;
        }

        // Return html string in an InputStream.
        // A new stream must be returned each time.
        public InputStream getInputStream() throws IOException {
            if (html == null) throw new IOException("Null HTML");
            return new ByteArrayInputStream(html.getBytes());
        }

        public OutputStream getOutputStream() throws IOException {
            throw new IOException("This DataHandler cannot write HTML");
        }

        public String getContentType() {
            return "text/html";
        }

        public String getName() {
            return "JAF text/html dataSource to send e-mail only";
        }
    }
    
    
    
    
    // A simple, single-part text/plain e-mail.
    public static void setTextContent(Message msg) throws MessagingException {
            // Set message content
            String mytxt = "This is a test of sending a " +
                            "plain text e-mail through Java.\n" +
                            "Here is line 2.";
            msg.setText(mytxt);

            // Alternate form
            msg.setContent(mytxt, "text/plain");

    }



    // A simple multipart/mixed e-mail. Both body parts are text/plain.
    public static void setMultipartContent(Message msg) throws MessagingException {
        // Create and fill first part
        MimeBodyPart p1 = new MimeBodyPart();
        p1.setText("This is part one of a test multipart e-mail.");

        // Create and fill second part
        MimeBodyPart p2 = new MimeBodyPart();
        // Here is how to set a charset on textual content
        p2.setText("This is the second part", "us-ascii");

        // Create the Multipart.  Add BodyParts to it.
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p1);
        mp.addBodyPart(p2);

        // Set Multipart as the message's content
        msg.setContent(mp);
    }



    // Set a file as an attachment.  Uses JAF FileDataSource.
    public static void setFileAsAttachment(Message msg, String filename,String text)
             throws MessagingException {

    	
    	String td = text;
    	 
        // Create and fill first part
        MimeBodyPart p1 = new MimeBodyPart();
        p1.setText(td);
        // Create second part
        MimeBodyPart p2 = new MimeBodyPart();

        // Put a file in the second part
        FileDataSource fds = new FileDataSource(filename);
        p2.setDataHandler(new DataHandler(fds));
        p2.setFileName(fds.getName());

        // Create the Multipart.  Add BodyParts to it.
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p1);
        mp.addBodyPart(p2);

        // Set Multipart as the message's content
        msg.setContent(mp);
        System.out.println("last line of setFileAsAttachment");
        //msg.saveChanges();
    }



    public  ArrayList<String> dumpPart(Part p) throws Exception {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	
    	ArrayList<String> s = new ArrayList<String>(); 
    	ArrayList<Part>mpart = new ArrayList<Part>();
    	
    	
    	if (p instanceof Message)
    	    /*dumpEnvelope((Message)p);*/

    	/** Dump input stream .. 

    	InputStream is = p.getInputStream();
    	// If "is" is not already buffered, wrap a BufferedInputStream
    	// around it.
    	if (!(is instanceof BufferedInputStream))
    	    is = new BufferedInputStream(is);
    	int c;
    	while ((c = is.read()) != -1)
    	    System.out.write(c);

    	**/

    	 ct = p.getContentType();
    	try {
    		System.out.println("CONTENT-TYPE: " + (new ContentType(ct)).toString());
    	} catch (ParseException pex) {
    		System.out.println("BAD CONTENT-TYPE: " + ct);
    		
    	}
    	String filename = p.getFileName();
    	if (filename != null)
    		System.out.println("FILENAME: " + filename);
    		s.add(filename);
    		
    	/*
    	 * Using isMimeType to determine the content type avoids
    	 * fetching the actual content data until we need it.
    	 */
    	if (p.isMimeType("text/plain")) {
    		System.out.println("This is plain text");
    		System.out.println("---------------------------");
    	    if (!showStructure && !saveAttachments){
    		System.out.println((String)p.getContent());
    	    s.add((String)p.getContent());
    	    }
    	} else if (p.isMimeType("multipart/*")) {
    		 System.out.println("This is a Multipart");
    		 System.out.println("---------------------------");
    	    Multipart mp = (Multipart)p.getContent();
    	    level++;
    	    int count = mp.getCount();
    	    System.out.println("Count is:"+count);
    	    for (int i = 0; i < count; i++){
    		dumpPart(mp.getBodyPart(i));
    		mpart.add(mp.getBodyPart(i));
    	    System.out.println("I IS:"+i);
    	    }
    	    level--;
    	} else if (p.isMimeType("message/rfc822")) {
    		System.out.println("This is a Nested Message");
    		System.out.println("---------------------------");
    	    level++;
    	    dumpPart((Part)p.getContent());
    	    level--;
    	} else {
    	    if (!showStructure && !saveAttachments) {
    		/*
    		 * If we actually want to see the data, and it's not a
    		 * MIME type we know, fetch it and check its Java type.
    		 */
    		Object o = p.getContent();
    		if (o instanceof String) {
    			System.out.println("This is a string");
    			System.out.println("---------------------------");
    		    System.out.println((String)o);
    		  s.add((String)o);
    		} else if (o instanceof InputStream) {
    			System.out.println("This is just an input stream");
    			System.out.println("---------------------------");
    		    InputStream is = (InputStream)o;
    		    int c;
    		    while ((c = is.read()) != -1)
    			{System.out.println(String.valueOf(c));
    		    s.add(String.valueOf(c));
    			}
    		} else {
    			System.out.println("This is an unknown type");
    			System.out.println("---------------------------");
    			System.out.println(o.toString());
    			s.add(o.toString());
    		}
    	    } else {
    		// just a separator
    	    	System.out.println("---------------------------");
    	    }
    	}

    	/*
    	 * If we're saving attachments, write out anything that
    	 * looks like an attachment into an appropriately named
    	 * file.  Don't overwrite existing files to prevent
    	 * mistakes.
    	 */
    	if (saveAttachments && level != 0 && p instanceof MimeBodyPart &&
    		!p.isMimeType("multipart/*")) {
    	    String disp = p.getDisposition();
    	    // many mailers don't include a Content-Disposition
    	    if (disp == null || disp.equalsIgnoreCase(Part.ATTACHMENT)) {
    		if (filename == null)
    		    filename = "Attachment" + attnum++;
    		System.out.println("Saving attachment to file " + filename);
    		s.add(filename);
    		try {
    		    File f = new File(filename);
    		    if (f.exists())
    			// XXX - could try a series of names
    			throw new IOException("file exists");
    		    ((MimeBodyPart)p).saveFile(f);
    		} catch (IOException ex) {
    			System.out.println("Failed to save attachment: " + ex);
    		}
    		System.out.println("---------------------------");
    	    }
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	 for(int i =0;i<mpart.size();i++){

		       Part obj=mpart.get(i);
		       
		       
		       if (obj instanceof Message)
		    	    /*dumpEnvelope((Message)p);*/

		    	/** Dump input stream .. 

		    	InputStream is = p.getInputStream();
		    	// If "is" is not already buffered, wrap a BufferedInputStream
		    	// around it.
		    	if (!(is instanceof BufferedInputStream))
		    	    is = new BufferedInputStream(is);
		    	int c;
		    	while ((c = is.read()) != -1)
		    	    System.out.write(c);

		    	**/

		    	 ct = obj.getContentType();
		    	try {
		    		System.out.println("CONTENT-TYPE: " + (new ContentType(ct)).toString());
		    	} catch (ParseException pex) {
		    		System.out.println("BAD CONTENT-TYPE: " + ct);
		    		
		    	}
		    	String filenamea = obj.getFileName();
		    	if (filename != null)
		    		System.out.println("FILENAME: " + filename);
		    		s.add(filename);
		    		
		    	/*
		    	 * Using isMimeType to determine the content type avoids
		    	 * fetching the actual content data until we need it.
		    	 */
		    	if (obj.isMimeType("text/plain")) {
		    		System.out.println("This is plain text");
		    		System.out.println("---------------------------");
		    	    if (!showStructure && !saveAttachments){
		    		System.out.println((String)obj.getContent());
		    	    s.add((String)obj.getContent());
		    	    }
		    	} else if (obj.isMimeType("multipart/*")) {
		    		 System.out.println("This is a Multipart");
		    		 System.out.println("---------------------------");
		    	    Multipart mp = (Multipart)obj.getContent();
		    	    level++;
		    	    int count = mp.getCount();
		    	    System.out.println("Count is:"+count);
		    	    for (int j = 0; j < count; j++){
		    		dumpPart(mp.getBodyPart(i));
		    		mpart.add(mp.getBodyPart(i));
		    	    System.out.println("I IS:"+i);
		    	    }
		    	    level--;
		    	} else if (obj.isMimeType("message/rfc822")) {
		    		System.out.println("This is a Nested Message");
		    		System.out.println("---------------------------");
		    	    level++;
		    	    dumpPart((Part)obj.getContent());
		    	    level--;
		    	} else {
		    	    if (!showStructure && !saveAttachments) {
		    		/*
		    		 * If we actually want to see the data, and it's not a
		    		 * MIME type we know, fetch it and check its Java type.
		    		 */
		    		Object o = obj.getContent();
		    		if (o instanceof String) {
		    			System.out.println("This is a string");
		    			System.out.println("---------------------------");
		    		    System.out.println((String)o);
		    		   s.add((String)o);
		    		} else if (o instanceof InputStream) {
		    			System.out.println("This is just an input stream");
		    			System.out.println("---------------------------");
		    		    InputStream is = (InputStream)o;
		    		    int c;
		    		    while ((c = is.read()) != -1)
		    			{System.out.println(String.valueOf(c));
		    		    s.add(String.valueOf(c));
		    			}
		    		} else {
		    			System.out.println("This is an unknown type");
		    			System.out.println("---------------------------");
		    			System.out.println(o.toString());
		    			s.add(o.toString());
		    		}
		    	    } else {
		    		// just a separator
		    	    	System.out.println("---------------------------");
		    	    }
		    	}

		    	/*
		    	 * If we're saving attachments, write out anything that
		    	 * looks like an attachment into an appropriately named
		    	 * file.  Don't overwrite existing files to prevent
		    	 * mistakes.
		    	 */
		    	if (saveAttachments && level != 0 && obj instanceof MimeBodyPart &&
		    		!obj.isMimeType("multipart/*")) {
		    	    String disp = obj.getDisposition();
		    	    // many mailers don't include a Content-Disposition
		    	    if (disp == null || disp.equalsIgnoreCase(Part.ATTACHMENT)) {
		    		if (filename == null)
		    		    filename = "Attachment" + attnum++;
		    		System.out.println("Saving attachment to file " + filename);
		    		s.add(filename);
		    		try {
		    		    File f = new File(filename);
		    		    if (f.exists())
		    			// XXX - could try a series of names
		    			throw new IOException("file exists");
		    		    ((MimeBodyPart)obj).saveFile(f);
		    		} catch (IOException ex) {
		    			System.out.println("Failed to save attachment: " + ex);
		    		}
		    		System.out.println("---------------------------");
		    	    }
		    	}
		        
		    
		    	
    }
		return s;
}
}