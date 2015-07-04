package assys.com.dbAction.welcome_login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.gmail.gmail;

public class ForgotPassword extends ActionSupport implements ServletRequestAware {

	
	private HttpServletRequest servletRequest;
	
	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
	GmailAuthentication  gmailAuthentication = new GmailAuthentication();
	
	AuthenticationDetailBean authenticationDetailBean = new AuthenticationDetailBean();
	AuthenticationDetail authenticationDetail = new AuthenticationDetail();
	
	
	
	
	
	public String execute() throws SQLException, IOException
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String flag="true";
		String emp_id=null;
		String email = null;
		
		Random rnd=new Random();
		int leaveId1=rnd.nextInt(Integer.MAX_VALUE)+1;
		String ss = "s"+leaveId1; 
		 String username =authenticationDetailBean.getUserName();
		
		 
		 System.out.println("username"+username);
	
		 ResultSet rs =	authenticationDetail.select(authenticationDetailBean);
		
		 while(rs.next())
		 {
			 emp_id = rs.getString("emp_user_id");
			 System.out.println(emp_id);
			 
		 } 
		 
		 gmailAuthenticationBean.setEmpUserId(emp_id);
		 ResultSet rs1 = gmailAuthentication.select(gmailAuthenticationBean);
		 
		while(rs1.next())
		{
			email  = rs1.getString("gmail_email_id");
		}	
		 
		 
		 authenticationDetailBean.setEmpUserId(emp_id);
		 authenticationDetailBean.setPassword(ss);
		 
		 
		 authenticationDetail.update(authenticationDetailBean);
		 
		 gmail g = new gmail();
		 g.setAccountDetails("atworkwebsolution@gmail.com", "hesoyamaspirine");
		 g.sendGmail("atworkwebsolution@gmail.com", email, "Password Reset","your new password is:"+ss);
		  
		 
		 request.setAttribute("forgot", "forgot");
		 request.setAttribute("email", email);
		 
		 	return flag;
		
		
	}

	public GmailAuthenticationBean getGmailAuthenticationBean() {
		return gmailAuthenticationBean;
	}

	public void setGmailAuthenticationBean(
			GmailAuthenticationBean gmailAuthenticationBean) {
		this.gmailAuthenticationBean = gmailAuthenticationBean;
	}

	public AuthenticationDetailBean getAuthenticationDetailBean() {
		return authenticationDetailBean;
	}

	public void setAuthenticationDetailBean(
			AuthenticationDetailBean authenticationDetailBean) {
		this.authenticationDetailBean = authenticationDetailBean;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	
	
}
