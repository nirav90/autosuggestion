package assys.com.dbAction.manager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.ClientDetailsBean;
import assys.com.dbBean.ClientIdGeneratorBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.ClientDetails;
import assys.com.dbDAO.ClientIdGenerator;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.SentMailMaster;
import assys.com.gmail.gmail;
 
public class SendClientIdMail {

	Random rnd=new Random();
	
	SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
	
	SentMailMaster sentMailMaster = new SentMailMaster();

	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();

	GmailAuthentication gmailAuthentication = new GmailAuthentication();
	
	ClientIdGenerator clientIdGenerator=new ClientIdGenerator();
	
	ClientIdGeneratorBean clientIdGeneratorBean=new ClientIdGeneratorBean();
	
	ClientDetails clientDetails=new ClientDetails();
	
	ClientDetailsBean clientDetailsBean=new ClientDetailsBean();

	AuthenticationDetailBean authenticationDetailBean=new AuthenticationDetailBean();
	
	AuthenticationDetail authenticationDetail=new AuthenticationDetail();
	
	gmail gmail = new gmail();

	
	
	


	public String execute() throws IOException, SQLException{
		
		System.out.println(clientDetailsBean.getClientFirstName());
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		authenticationDetailBean.setEmpUserId(clientIdGeneratorBean.getClientId());
		
		
		
		clientDetailsBean.setClientEmailId(sentMailMasterBean.getReciptanceEmailId());
		sentMailMasterBean.setEmpUserId(sd);
		
		gmailAuthenticationBean.setEmpUserId(sd);
		
		ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
		 
		while(rs.next())
		{
			
			sentMailMasterBean.setSenderEmailId(rs.getString(3));
			String userName =rs.getString(3);
			String password = rs.getString(4);
			gmail.setAccountDetails(userName, password);
		 }	 
		
		 	System.out.println(clientIdGeneratorBean.getClientId());
		 	System.out.println(sentMailMasterBean.getSenderEmailId());
			System.out.println(sentMailMasterBean.getEmailSubject());
			System.out.println(sentMailMasterBean.getEmailBody());
			System.out.println(sentMailMasterBean.getReciptanceEmailId());
			
			clientDetailsBean.setEmpUserId(clientIdGeneratorBean.getClientId());
			
			clientDetails.insert(clientDetailsBean);
			Random rnd=new Random();
			int sntId=rnd.nextInt(Integer.MAX_VALUE)+1;
			int usrId=rnd.nextInt(Integer.MAX_VALUE)+1;
			int pwdId=rnd.nextInt(Integer.MAX_VALUE)+1;
			String sentId="snt"+sntId;
			String userId="usr"+usrId;
			String pwdID="pw"+pwdId+"d";
			authenticationDetailBean.setUserName(sentMailMasterBean.getReciptanceEmailId());
			authenticationDetailBean.setPassword(pwdID);
			
			authenticationDetail.insert(authenticationDetailBean);
			sentMailMasterBean.setSentId(sentId);
			String msgBody="Your UserName is:"+authenticationDetailBean.getUserName()+"& Password is:"+authenticationDetailBean.getPassword()+".  Please Login using this ID For further contact with our Company..";
			
			String msgsubject="Login Detail";
			sentMailMasterBean.setEmailBody(msgBody);
			sentMailMasterBean.setEmailSubject(msgsubject);
			sentMailMasterBean.setEmailSubject(msgsubject.replace("'", "\\'"));
			sentMailMasterBean.setEmailBody(msgBody.replace("'", "\\'"));
			sentMailMaster.insert(sentMailMasterBean);
			gmail.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
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
	 * @return the clientIdGeneratorBean
	 */
	public ClientIdGeneratorBean getClientIdGeneratorBean() {
		return clientIdGeneratorBean;
	}






	/**
	 * @param clientIdGeneratorBean the clientIdGeneratorBean to set
	 */
	public void setClientIdGeneratorBean(ClientIdGeneratorBean clientIdGeneratorBean) {
		this.clientIdGeneratorBean = clientIdGeneratorBean;
	}






	/**
	 * @return the clientDetailsBean
	 */
	public ClientDetailsBean getClientDetailsBean() {
		return clientDetailsBean;
	}






	/**
	 * @param clientDetailsBean the clientDetailsBean to set
	 */
	public void setClientDetailsBean(ClientDetailsBean clientDetailsBean) {
		this.clientDetailsBean = clientDetailsBean;
	}






	/**
	 * @return the authenticationDetailBean
	 */
	public AuthenticationDetailBean getAuthenticationDetailBean() {
		return authenticationDetailBean;
	}






	/**
	 * @param authenticationDetailBean the authenticationDetailBean to set
	 */
	public void setAuthenticationDetailBean(
			AuthenticationDetailBean authenticationDetailBean) {
		this.authenticationDetailBean = authenticationDetailBean;
	}
	
}
