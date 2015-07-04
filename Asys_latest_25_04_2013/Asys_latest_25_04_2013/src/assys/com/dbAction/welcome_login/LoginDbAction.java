package assys.com.dbAction.welcome_login;

import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.InboxMasterBean;
import assys.com.dbBean.LoginHistoryBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.InboxMaster;
import assys.com.dbDAO.LoginHistory;
import assys.com.gmail.gmail;

import com.opensymphony.xwork2.ActionSupport;

public class LoginDbAction extends ActionSupport{
	
 
    
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	AuthenticationDetailBean authBean=new AuthenticationDetailBean();
	AuthenticationDetail authDet=new AuthenticationDetail();
	
	LoginHistoryBean lgnHistBean=new LoginHistoryBean();
	LoginHistory lgnHist=new LoginHistory();
	
	
	GmailAuthentication gmailAuthentication = new GmailAuthentication();
	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();

	InboxMasterBean inboxMasterBean = new InboxMasterBean();
	InboxMaster inboxMaster = new InboxMaster();
	
	
	String flag="false";
	public String execute() throws Exception
	{
		lgnHistBean.setUserName(authBean.getUserName());
		System.out.println("in login suucess");
		String empUserId=null;
		System.out.println("usrnam we get:"+authBean.getUserName());
		ResultSet rs=authDet.select(authBean);
		while(rs.next()){
			empUserId=rs.getString("emp_user_id");
		}
		if(empUserId==null)
		{
			flag="false";
		}
		else{
		empUserIdBean.setEmpUserId(empUserId);
		empUserIdBean.setEmpIdUsed(true);
		String empCategory=null;
		ResultSet rs1=empUserIdGen.select(empUserIdBean);
		System.out.println("in rs1 while before");
		while(rs1.next())
		{
			System.out.println("in rs1 while");
			empCategory=rs1.getString("emp_category");
		}
		System.out.println("in rs1 while after");
		if(empCategory.equals("Admin"))
		{
			flag="admin";
		}
		else if(empCategory.equals("Client")){
			flag="client";
		}
		else if(empCategory.equals("Employee")){
			flag="employee";
		}
		else if(empCategory.equals("Project Manager")){
			flag="pmanager";
		}
		else
		{
			flag="false";
		}
		lgnHist.insert(lgnHistBean);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("employee_ID", empUserId);
		session.setAttribute("userName",authBean.getUserName());
		
		
		 gmailAuthenticationBean.setEmpUserId(empUserId);
		 ResultSet rs3 = gmailAuthentication.select(gmailAuthenticationBean);
		 
		 System.out.println(rs3);
		 while(rs3.next())
		 {
			 gmailAuthenticationBean.setGmailEmailId(rs3.getString(3));
			 gmailAuthenticationBean.setGmailPassword(rs3.getString(4));
			 
			 System.out.println(rs3.getString(3)+rs3.getString(4));
		 } 
		 
		 gmail gmail = new gmail();
		 gmail.setAccountDetails(gmailAuthenticationBean.getGmailEmailId(), gmailAuthenticationBean.getGmailPassword());
		
		 System.out.println(gmailAuthenticationBean.getGmailEmailId());
		 
		 inboxMasterBean.setEmpUserId(empUserId);
		 
		 
		 /*check read unread mail and than call approprite method*/
		 
		 
		 ResultSet rs4 =inboxMaster.select(inboxMasterBean);
		 
		 if(rs4.next())
		 {
			 gmail.unreadAllGmail();
		 }	
		 else
		 {
			 gmail.readAllGmail();
			 
		 }	 
			 
		
		}
		
		return flag;
	}
	/**
	 * @return the empUserIdBean
	 */
	public EmpUserIdGeneratorBean getEmpUserIdBean() {
		return empUserIdBean;
	}
	/**
	 * @param empUserIdBean the empUserIdBean to set
	 */
	public void setEmpUserIdBean(EmpUserIdGeneratorBean empUserIdBean) {
		this.empUserIdBean = empUserIdBean;
	}
	/**
	 * @return the authBean
	 */
	public AuthenticationDetailBean getAuthBean() {
		return authBean;
	}
	/**
	 * @param authBean the authBean to set
	 */
	public void setAuthBean(AuthenticationDetailBean authBean) {
		this.authBean = authBean;
	}
	/**
	 * @return the lgnHistBean
	 */
	public LoginHistoryBean getLgnHistBean() {
		return lgnHistBean;
	}
	/**
	 * @param lgnHistBean the lgnHistBean to set
	 */
	public void setLgnHistBean(LoginHistoryBean lgnHistBean) {
		this.lgnHistBean = lgnHistBean;
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
	 * @return the inboxMasterBean
	 */
	public InboxMasterBean getInboxMasterBean() {
		return inboxMasterBean;
	}
	/**
	 * @param inboxMasterBean the inboxMasterBean to set
	 */
	public void setInboxMasterBean(InboxMasterBean inboxMasterBean) {
		this.inboxMasterBean = inboxMasterBean;
	}
	
	
	
}
