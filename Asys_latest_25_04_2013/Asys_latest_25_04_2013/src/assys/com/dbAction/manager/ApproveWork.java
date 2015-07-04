package assys.com.dbAction.manager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AssignWorkMasterBean;
import assys.com.dbBean.EmailNotificationBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbBean.WorkSubmitMasterBean;
import assys.com.dbDAO.AssignWorkMaster;
import assys.com.dbDAO.EmailNotification;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.SentMailMaster;
import assys.com.dbDAO.WorkSubmitMaster;
import assys.com.gmail.gmail;

public class ApproveWork {

	GmailAuthentication gmailAuthentication=new GmailAuthentication();
	GmailAuthenticationBean gmailAuthenticationBean=new GmailAuthenticationBean();
	
	SentMailMaster sentMailMaster=new SentMailMaster();
	SentMailMasterBean sentMailMasterBean=new SentMailMasterBean();
	
	EmailNotification emailNotification=new EmailNotification();
	EmailNotificationBean emailNotificationBean=new EmailNotificationBean();
	
	AssignWorkMaster assignWorkMaster=new AssignWorkMaster();
	AssignWorkMasterBean assignWorkMasterBean=new AssignWorkMasterBean();
	
	WorkSubmitMaster workSubmitMaster=new WorkSubmitMaster();
	WorkSubmitMasterBean workSubmitMasterBean=new WorkSubmitMasterBean();
	
	gmail gmail = new gmail();
	
	public String execute() throws SQLException, IOException{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		String flag = request.getParameter("submit");
		System.out.println(flag);
		assignWorkMasterBean.setWorkId(workSubmitMasterBean.getWorkId());
		if(flag.equals("Approve"))
		{
			
			assignWorkMasterBean.setWorkApprove(true);
			
			workSubmitMasterBean.setWorkApprove(true);
			
			assignWorkMaster.update(assignWorkMasterBean);
			workSubmitMaster.update(workSubmitMasterBean);
			sendingMailSetting("true",sd);
			request.setAttribute("name", "name");
		}
		else{
			assignWorkMasterBean.setWorkApprove(false);
			
			workSubmitMasterBean.setWorkApprove(false);
			
			assignWorkMaster.update(assignWorkMasterBean);
			workSubmitMaster.update(workSubmitMasterBean);
			sendingMailSetting("false",sd);
			request.setAttribute("name1", "name");
		}
		
		return "SUCCESS";
	}
	
	public void sendingMailSetting(String leaveApproval,String sd) throws SQLException, IOException{
		
		/*
		 * to set data for email notification & sent mail master
		 * */
		
		
		//get sender's email id...
		gmailAuthenticationBean.setEmpUserId(sd);
		ResultSet rs=gmailAuthentication.select(gmailAuthenticationBean);
		String senderIds = null;
		while(rs.next()){
			senderIds=rs.getString("gmail_email_id");
			String userName =rs.getString(3);
			String password = rs.getString(4);
			System.out.println(password);
			gmail.setAccountDetails(userName, password);
		}
		
		//get receiver's email id...
		
		String receiversIds = null;
		
		receiversIds=workSubmitMasterBean.getSenderEmailId();
		
		
		//get send id and email notification id for recepective tables...
		Random rnd=new Random();
		int sntId=rnd.nextInt(Integer.MAX_VALUE)+1;
		String sentId="snt"+sntId;
		String emailNfcId="enfc"+sntId;
		
		//set email subject & body...			
		String msgSubject="Work Status Notification";
		String msgBody;
		if(leaveApproval.equals("true")){
			msgBody="Your Work has been Approved. For the WorkID : "+workSubmitMasterBean.getWorkId()+"...";
		}
		else{
			msgBody="Your Work has been Disapproved.";
		}
		
		
		
		/*
		 * set data in sent mail master and insert in it...
		 * */
		
		sentMailMasterBean.setSentId(sentId);
		sentMailMasterBean.setEmpUserId(sd);
		sentMailMasterBean.setSenderEmailId(senderIds);
		sentMailMasterBean.setReciptanceEmailId(receiversIds);
		sentMailMasterBean.setEmailSubject(msgSubject);
		sentMailMasterBean.setEmailBody(msgBody);
		sentMailMaster.insert(sentMailMasterBean);
		
		/*
		 * set data in email notification and also insert in it
		 * */
		emailNotificationBean.setEmailNotificationId(emailNfcId);
		emailNotificationBean.setEmpUserId(sd);
		emailNotificationBean.setEmailNfcSenderId(senderIds);
		emailNotificationBean.setEmailNfcReceiverId(receiversIds);
		emailNotificationBean.setEmailNfcSubject(msgSubject);
		emailNotificationBean.setEmailNotificationMessage(msgBody);
		emailNotification.insert(emailNotificationBean);
		
		//send mail of notification to the employee
		gmail.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
}

	/**
	 * @return the gmailAuthenticationBean
	 */
	public GmailAuthenticationBean getGmailAuthenticationBean() {
		return gmailAuthenticationBean;
	}

	/**
	 * @param gmailAuthenticationBean the gmailAuthenticationBean to set
	 */
	public void setGmailAuthenticationBean(
			GmailAuthenticationBean gmailAuthenticationBean) {
		this.gmailAuthenticationBean = gmailAuthenticationBean;
	}

	/**
	 * @return the sentMailMasterBean
	 */
	public SentMailMasterBean getSentMailMasterBean() {
		return sentMailMasterBean;
	}

	/**
	 * @param sentMailMasterBean the sentMailMasterBean to set
	 */
	public void setSentMailMasterBean(SentMailMasterBean sentMailMasterBean) {
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

	/**
	 * @return the assignWorkMasterBean
	 */
	public AssignWorkMasterBean getAssignWorkMasterBean() {
		return assignWorkMasterBean;
	}

	/**
	 * @param assignWorkMasterBean the assignWorkMasterBean to set
	 */
	public void setAssignWorkMasterBean(AssignWorkMasterBean assignWorkMasterBean) {
		this.assignWorkMasterBean = assignWorkMasterBean;
	}

	/**
	 * @return the workSubmitMasterBean
	 */
	public WorkSubmitMasterBean getWorkSubmitMasterBean() {
		return workSubmitMasterBean;
	}

	/**
	 * @param workSubmitMasterBean the workSubmitMasterBean to set
	 */
	public void setWorkSubmitMasterBean(WorkSubmitMasterBean workSubmitMasterBean) {
		this.workSubmitMasterBean = workSubmitMasterBean;
	}
	
	
}
