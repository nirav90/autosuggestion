package assys.com.action.employee;

import java.util.Map;

import javax.mail.Folder;
import javax.mail.Part;

import assys.com.gmail.MailUserBean;
import assys.com.gmail.MessageInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class Inbox extends ActionSupport {


	 
	Map<String, Object> session = ActionContext.getContext().getSession(); 
	
	Folder folder;
	
	javax.mail.Message messages;
	public String execute()
	{
		
		folder=	(Folder) session.get("folder");
		
		
		Message[] messages = (Message[]) folder.getMessages();
		   for (int i = 0; i < messages.length; i++) {
			Message message = messages[i];
			System.out.println("---------------------------------");
			System.out.println("Email Number " + (i + 1));
			System.out.println("Subject: " + ((MessageInfo) message).getSubject());
			System.out.println("From: " + ((javax.mail.Message) message).getFrom()[0]);
			System.out.println("Text: " + ((Part) message).getContent().toString());
		   }
		return "success";

	}


	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}


	/**
	 * @param session the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	/**
	 * @return the folder
	 */
	public Folder getFolder() {
		return folder;
	}


	/**
	 * @param folder the folder to set
	 */
	public void setFolder(Folder folder) {
		this.folder = folder;
	}


	/**
	 * @return the messages
	 */
	public javax.mail.Message getMessages() {
		return messages;
	}


	/**
	 * @param messages the messages to set
	 */
	public void setMessages(javax.mail.Message messages) {
		this.messages = messages;
	}
	
	
	
}
