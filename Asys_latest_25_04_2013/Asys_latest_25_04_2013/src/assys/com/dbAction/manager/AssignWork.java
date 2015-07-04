package assys.com.dbAction.manager;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AssignWorkMasterBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbDAO.AssignWorkMaster;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.SentMailMaster;
import assys.com.gmail.gmail;

public class AssignWork {
	
	
	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
	
	GmailAuthentication gmailAuthentication = new GmailAuthentication();
	
	AssignWorkMasterBean assignWorkMasterBean = new AssignWorkMasterBean();
	
	AssignWorkMaster assignWorkMaster = new AssignWorkMaster();
	
	SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
	
	SentMailMaster sentMailMaster = new SentMailMaster();
	
	private File userImage;
    private String userImageContentType;
    private String userImageFileName;
    
	public String execute() throws SQLException, IOException
	{
		
		String userName = null;
		String password= null;
		
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		
		String WorkId =(String) session.getAttribute("WorkId");
		
		
		assignWorkMasterBean.setEmpUserId(sd);
		
			
		Date date = new Date();
		Calendar endingDate = new GregorianCalendar();
		endingDate.setTime(date);
		Date endingDateTime;
		
		int day = assignWorkMasterBean.getDay();
		int hours= assignWorkMasterBean.getHour();
		int minute = assignWorkMasterBean.getMinute();

		if(day!=0){
			endingDate.add(Calendar.DATE,day);
			endingDateTime=endingDate.getTime();
			System.out.println(endingDateTime);
			assignWorkMasterBean.setEndingDateTime(endingDateTime);
			}
		
			
			if(hours!=0){
				endingDate.add(Calendar.HOUR,hours);
				endingDateTime=endingDate.getTime();
				System.out.println(endingDateTime);
				assignWorkMasterBean.setEndingDateTime(endingDateTime);
			}
			
			
			if(minute!=0){
				endingDate.add(Calendar.MINUTE,minute);
				endingDateTime=endingDate.getTime();
				System.out.println(endingDateTime);
				assignWorkMasterBean.setEndingDateTime(endingDateTime);
			}
			if(day==0 && hours==0 && minute==0){
				assignWorkMasterBean.setEndingDateTime(date);
			}
		
		double duration = (day*60*24)+(hours*60)+(minute);
		
		
		assignWorkMasterBean.setDuration(duration);
		assignWorkMasterBean.setWorkId(WorkId);
		System.out.println(userName);
		System.out.println(password);
		
		
		//from here code for sending mail and save in sentMailMaster table
		gmailAuthenticationBean.setEmpUserId(sd);
		sentMailMasterBean.setEmpUserId(sd);
		gmail  g = new gmail();
		ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
		
		while(rs.next())
		{
			sentMailMasterBean.setSenderEmailId( rs.getString(3));
			userName = rs.getString(3);
			password = rs.getString(4);
			System.out.println(userName);
			System.out.println(password);
			g.setAccountDetails(userName, password);
		}
		assignWorkMasterBean.setSenderEmailId(userName);
		
		
		Random rnd=new Random();
		int sntId=rnd.nextInt(Integer.MAX_VALUE)+1;
		String sentId="snt"+sntId;
		sentMailMasterBean.setSentId(sentId);
		if(assignWorkMasterBean.getWorkMsgSubject().equals("")){
			assignWorkMasterBean.setWorkMsgSubject("(no subject)");
		}
		sentMailMasterBean.setEmailSubject(assignWorkMasterBean.getWorkMsgSubject());
		
		String msgBody="Your work id is: "+assignWorkMasterBean.getWorkId()+" Your work description: "+assignWorkMasterBean.getWorkMsgBody()+" .Your completion time is: "+assignWorkMasterBean.getEndingDateTime();
		
		
		sentMailMasterBean.setReciptanceEmailId(assignWorkMasterBean.getReciptanceEmailId());
		System.out.println(userImageFileName);
		try {
			System.out.println("in try block of attach file");
			String filePath = "E:/";
					//servletRequest.getRealPath("/");
			System.out.println("Server path:" + filePath);
			System.out.println(this.userImageFileName);
			 File fileToCreate = new File(filePath, this.userImageFileName);
			System.out.println(this.userImage);
			FileUtils.copyFile(this.userImage, fileToCreate);
		} catch (Exception e) {
			System.out.println("in catch block of attach file");
			e.printStackTrace();
			//addActionError(e.getMessage());

			//return INPUT;
		}
	
		
		if(userImageFileName==null)
		{
			assignWorkMaster.insert(assignWorkMasterBean);
			sentMailMasterBean.setEmailBody(msgBody);
			System.out.println("in attach file null");
			sentMailMaster.insert(sentMailMasterBean);
			g.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
		}
		else
		{
			String msgBdy=assignWorkMasterBean.getWorkMsgBody();
			msgBdy+=". Also Find Attachment With the mail...";
			assignWorkMasterBean.setWorkMsgBody(msgBdy+". Also Find Attachment With the mail...");
			sentMailMasterBean.setEmailBody(msgBody);
			System.out.println("in attach file code");
			
			
			/*code for upload */

			
			
			
		
			System.out.println("in attachment");
			System.out.println(sentMailMasterBean.getAttachFileFileName());
			assignWorkMaster.insert(assignWorkMasterBean);
			sentMailMaster.insert(sentMailMasterBean);
			/*code for attachment mail submit*/
			g.attachFile(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody() ,userImageFileName);
		}
		/*
		try {
			gmail.sendGmail(assignWorkMasterBean.getSenderEmailId(), assignWorkMasterBean.getReciptanceEmailId(), assignWorkMasterBean.getEmailSubject(), assignWorkMasterBean.getEmailBody());
			g.attachFile(userName, assignWorkMasterBean.getReciptanceEmailId(), assignWorkMasterBean.getWorkMsgSubject(), assignWorkMasterBean.getWorkMsgBody(), assignWorkMasterBean.getFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		return "SUCCESS";
	}

	

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
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
	

}
