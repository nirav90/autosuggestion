package assys.com.dbAction.admin;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.mysql.jdbc.EscapeTokenizer;
import com.opensymphony.xwork2.ActionSupport;

import assys.com.dbBean.DraftMasterBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbDAO.DraftMaster;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.SentMailMaster;
import assys.com.gmail.gmail;

public class Sendmail extends ActionSupport implements ServletRequestAware  {
	
	
	
	
	 	private File userImage;
	    private String userImageContentType;
	    private String userImageFileName;
	
	
	
	    private HttpServletRequest servletRequest;
	
	
	    
	    Random rnd=new Random();
	    
	    
	    	SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
	
	    	SentMailMaster sentMailMaster = new SentMailMaster();
	
	    	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
	
	    	GmailAuthentication gmailAuthentication = new GmailAuthentication();
	
	    	gmail gmail = new gmail();
	
	
	
	
	public String execute() throws SQLException, IOException
	{
		
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		String flag = request.getParameter("submit");
		
		System.out.println(flag);
		if(flag.equals("Send"))
		
		{
		
		sentMailMasterBean.setEmpUserId(sd);
		
		gmailAuthenticationBean.setEmpUserId(sd);
		 
		
		
		 ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
		 
		 
		 while(rs.next())
		 {
			 
			sentMailMasterBean.setSenderEmailId( rs.getString(3));
			String userName =rs.getString(3);
			String password = rs.getString(4);
			
			System.out.println(password);
		
			
			gmail.setAccountDetails(userName, password);
		 }	 
		
		 
		 System.out.println(sentMailMasterBean.getSenderEmailId());
			System.out.println(sentMailMasterBean.getEmailSubject());
			System.out.println(sentMailMasterBean.getEmailBody());
			System.out.println(sentMailMasterBean.getReciptanceEmailId());
			
			Random rnd=new Random();
			int sntId=rnd.nextInt(Integer.MAX_VALUE)+1;
			String sentId="snt"+sntId;
			sentMailMasterBean.setSentId(sentId);
			String msgBody=sentMailMasterBean.getEmailBody();
			
			String msgsubject=sentMailMasterBean.getEmailSubject();
			sentMailMasterBean.setEmailSubject(msgsubject.replace("'", "\\'"));
			sentMailMasterBean.setEmailBody(msgBody.replace("'", "\\'"));
			sentMailMaster.insert(sentMailMasterBean);
		
		
			System.out.println(sentMailMasterBean.getAttachFileFileName());
		
			
			
			
			
			System.out.println(userImageFileName);
		if(userImageFileName==null)
		{
			System.out.println("inside if");
			gmail.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
			request.setAttribute("name", "name");
		}
		else
		{
			
			
			
			/*code for upload */

			
			
			try {

				String filePath = "E:/";
						//servletRequest.getRealPath("/");
				System.out.println("Server path:" + filePath);
				System.out.println(this.userImageFileName);
				 File fileToCreate = new File(filePath, this.userImageFileName);
				System.out.println(this.userImage);
				FileUtils.copyFile(this.userImage, fileToCreate);
			} catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());

				return INPUT;
			}
		
		
			System.out.println("in attachment");
			System.out.println(sentMailMasterBean.getAttachFileFileName());
			
			/*code for attachment mail submit*/
			gmail.attachFile(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody() ,userImageFileName);
			request.setAttribute("name", "name");
		}	
		

		
		}
		else
		{
			
			
			int draft_Id=rnd.nextInt(Integer.MAX_VALUE)+1;
			String draftId="draft"+draft_Id;
			System.out.println(" u r in else");
			
			DraftMasterBean draftMasterBean = new DraftMasterBean();
			draftMasterBean.setEmpUserId(sd);
			draftMasterBean.setEmailId(sentMailMasterBean.getReciptanceEmailId());
			draftMasterBean.setDraftSubject(sentMailMasterBean.getEmailSubject());
			draftMasterBean.setDraftBody(sentMailMasterBean.getEmailBody());
			draftMasterBean.setDraftId(draftId);
			
			
			DraftMaster draftMaster = new DraftMaster();
			draftMaster.insert(draftMasterBean);
		}	

		
		
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



	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}







	public SentMailMasterBean getSentMailMasterBean() {
		return sentMailMasterBean;
	}







	public void setSentMailMasterBean(SentMailMasterBean sentMailMasterBean) {
		this.sentMailMasterBean = sentMailMasterBean;
	}







	public GmailAuthenticationBean getGmailAuthenticationBean() {
		return gmailAuthenticationBean;
	}







	public void setGmailAuthenticationBean(
			GmailAuthenticationBean gmailAuthenticationBean) {
		this.gmailAuthenticationBean = gmailAuthenticationBean;
	}





	

	

	
	
	
	
	

}
