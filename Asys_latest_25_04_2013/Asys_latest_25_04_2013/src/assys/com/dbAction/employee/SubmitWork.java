package assys.com.dbAction.employee;


	

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

	import com.mysql.jdbc.EscapeTokenizer;

import freemarker.ext.servlet.HttpRequestHashModel;

	import assys.com.dbBean.GmailAuthenticationBean;
	import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbBean.WorkSubmitMasterBean;
	import assys.com.dbDAO.GmailAuthentication;
	import assys.com.dbDAO.SentMailMaster;
import assys.com.dbDAO.WorkSubmitMaster;
import assys.com.gmail.gmail;

	public class SubmitWork {
		
		
        
		SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
		
		SentMailMaster sentMailMaster = new SentMailMaster();
		
		GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
		
		GmailAuthentication gmailAuthentication = new GmailAuthentication();
		
		WorkSubmitMasterBean workSubmitMasterBean = new WorkSubmitMasterBean();
		
		WorkSubmitMaster  workSubmitMaster = new WorkSubmitMaster();
		
		gmail gmail = new gmail();
		
		private File userImage;
	    private String userImageContentType;
	    private String userImageFileName;
		
		
		public String execute() throws SQLException, IOException
		{
			
			
			String userName=null;
			String password=null;
			
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			HttpServletRequest request=ServletActionContext.getRequest();
			
			String sd = (String)session.getAttribute("employee_ID");
			
			sentMailMasterBean.setEmpUserId(sd);
			
			gmailAuthenticationBean.setEmpUserId(sd);
			 
			
			 ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
			 
			 
			 while(rs.next())
			 {
				 
				sentMailMasterBean.setSenderEmailId( rs.getString(3));
				 userName =rs.getString(3);
				password = rs.getString(4);
				
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
				if(sentMailMasterBean.getEmailSubject().equals("")){
					sentMailMasterBean.setEmailSubject("(no subject)");
				}
				String msgBody=sentMailMasterBean.getEmailBody();
			
				String msgsubject=sentMailMasterBean.getEmailSubject();
				sentMailMasterBean.setEmailSubject(msgsubject.replace("'", "\\'"));
				sentMailMasterBean.setEmailBody(msgBody.replace("'", "\\'"));
				
			
				workSubmitMasterBean.setEmpUserId(sd);
				workSubmitMasterBean.setSenderEmailId(userName);
				workSubmitMasterBean.setReciptanceEmailId(sentMailMasterBean.getReciptanceEmailId());
				workSubmitMasterBean.setWorkMsgSubject(sentMailMasterBean.getEmailSubject());
				
				
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
				System.out.println("inside if");
				sentMailMaster.insert(sentMailMasterBean);
				workSubmitMasterBean.setWorkMsgBody(sentMailMasterBean.getEmailBody());
				
				workSubmitMaster.insert(workSubmitMasterBean);
				gmail.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
			}
			else
			{
				String msgBdy=sentMailMasterBean.getEmailBody();
				msgBdy+=". Also Find Attachment With the mail...";
				sentMailMasterBean.setEmailBody(msgBdy);
				sentMailMaster.insert(sentMailMasterBean);
				workSubmitMasterBean.setWorkMsgBody(sentMailMasterBean.getEmailBody());
				
				workSubmitMaster.insert(workSubmitMasterBean);
				System.out.println(sentMailMasterBean.getAttachFileFileName());
				gmail.attachFile(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody() ,userImageFileName);
			}	
			
		

			
			request.setAttribute("workSubmit", "workSubmit");
			return "SUCCESS";
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




		/**
		 * @return the userImage
		 */
		public File getUserImage() {
			return userImage;
		}




		/**
		 * @param userImage the userImage to set
		 */
		public void setUserImage(File userImage) {
			this.userImage = userImage;
		}




		/**
		 * @return the userImageContentType
		 */
		public String getUserImageContentType() {
			return userImageContentType;
		}




		/**
		 * @param userImageContentType the userImageContentType to set
		 */
		public void setUserImageContentType(String userImageContentType) {
			this.userImageContentType = userImageContentType;
		}




		/**
		 * @return the userImageFileName
		 */
		public String getUserImageFileName() {
			return userImageFileName;
		}




		/**
		 * @param userImageFileName the userImageFileName to set
		 */
		public void setUserImageFileName(String userImageFileName) {
			this.userImageFileName = userImageFileName;
		}



		
		

	}


