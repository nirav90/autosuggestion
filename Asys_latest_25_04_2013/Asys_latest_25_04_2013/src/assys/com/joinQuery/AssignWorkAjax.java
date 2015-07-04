package assys.com.joinQuery;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import assys.com.DAO.DBConnection;
import assys.com.dbBean.EmailNotificationBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbDAO.EmailNotification;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.SentMailMaster;
import assys.com.gmail.gmail;



public class AssignWorkAjax {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
	
	GmailAuthentication gmailAuthentication = new GmailAuthentication();

	gmail gmail = new gmail();

	SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
	
	SentMailMaster sentMailMaster = new SentMailMaster();

	EmailNotificationBean emailNotificationBean=new EmailNotificationBean();
	
	EmailNotification emailNotification=new EmailNotification();
	
    
	public void selectMail(String sd) throws SQLException, IOException
	{		
		
		String selectAllQuery="SELECT * FROM assign_work_master WHERE ending_date_time<='"+ dateFormat.format(date)+"' AND work_approve=0;";
		rs=executeSelect(selectAllQuery);
		while(rs.next()){
			String reciptanceId=rs.getString("reciptance_email_id");
			String workId=rs.getString("work_id");	
			sendMail(reciptanceId, workId,sd);
		}
		
		
		
	}
	public void sendMail(String reciptanceId,String workId,String sd) throws SQLException, IOException{
		/*HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");*/
		
		String msgBody="Your time is Completed for the WorkId:"+workId;
		sentMailMasterBean.setEmailBody(msgBody);
		ResultSet rs1=sentMailMaster.select(sentMailMasterBean);
		if(rs1.next()){
			System.out.println("in if");
		}
		else{
			sentMailMasterBean.setEmpUserId(sd);
			
			gmailAuthenticationBean.setEmpUserId(sd);
			 
			
			
			 ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
			 
			 
			 while(rs.next())
			 {
				 
				sentMailMasterBean.setSenderEmailId( rs.getString(3));
				emailNotificationBean.setEmailNfcSenderId(rs.getString(3));
				String userName =rs.getString(3);
				String password = rs.getString(4);
				
				System.out.println(password);
			
				
				gmail.setAccountDetails(userName, password);
			}	 
			Random rnd=new Random();
			int sntId=rnd.nextInt(Integer.MAX_VALUE)+1;
			String sentId="snt"+sntId;
			String nfcId="enfc"+sntId;
			sentMailMasterBean.setSentId(sentId);
			String msgSubject="Notification For Your Work";
			
			sentMailMasterBean.setEmailBody(msgBody);
			sentMailMasterBean.setEmailSubject(msgSubject);
			sentMailMasterBean.setReciptanceEmailId(reciptanceId);
			sentMailMaster.insert(sentMailMasterBean);
			System.out.println("after insert of sent mail master*****************");
			emailNotificationBean.setEmailNotificationId(nfcId);
			emailNotificationBean.setEmpUserId(sd);
			emailNotificationBean.setEmailNfcSubject(msgSubject);
			System.out.println("in beteen  of mail nfc master*****************");
			emailNotificationBean.setEmailNotificationMessage(msgBody);
			emailNotificationBean.setEmailNfcReceiverId(reciptanceId);
			emailNotification.insert(emailNotificationBean);
			System.out.println("after insert of email nfc mail master*****************");
			gmail.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
			System.out.println("after sending mail master*****************");
			sentMailMasterBean.setEmailBody(null);
			sentMailMasterBean.setEmailSubject(null);
			sentMailMasterBean.setEmpUserId(null);
			sentMailMasterBean.setReciptanceEmailId(null);
			sentMailMasterBean.setSenderEmailId(null);
			sentMailMasterBean.setSentId(null);
			
			
		}

	}
	public ResultSet executeSelect(String str)
	{
		try
		{
		 conn=con.getConnection();
		 System.out.println("line 1");
		 stm= (Statement) conn.createStatement();
		 System.out.println("line 1");
		 System.out.println(str);
		 rs =stm.executeQuery(str);
		 System.out.println("line affected succefully");
		 
		 /*while(rs.next())
		 {
			 String name= rs.getString(1);
			 String phone = rs.getString(2);
			 System.out.println(name+phone);
		 } */
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return rs;
	}
	public GmailAuthenticationBean getGmail_authentication_bean() {
		return gmailAuthenticationBean;
	}
	public void setGmail_authentication_bean(
			GmailAuthenticationBean gmailAuthenticationBean) {
		this.gmailAuthenticationBean = gmailAuthenticationBean;
	}
	public SentMailMasterBean getSent_mail_master_bean() {
		return sentMailMasterBean;
	}
	public void setSent_mail_master_bean(SentMailMasterBean sentMailMasterBean) {
		this.sentMailMasterBean = sentMailMasterBean;
	}
	/**
	 * @return the emailNotificationBean
	 */
	public EmailNotificationBean getEmailNotificationBean() {
		return emailNotificationBean;
	}
	/**
	 * @param emailNotificationBean the emailNotificationBean to set
	 */
	public void setEmailNotificationBean(EmailNotificationBean emailNotificationBean) {
		this.emailNotificationBean = emailNotificationBean;
	}
	
}
