package assys.com.dbAction.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.gmail.gmail;

public class ReadMail {

	
	GmailAuthentication gmailAuthentication = new GmailAuthentication();
	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
	
	
	
	 public String execute() throws SQLException
	{
		
		 HttpSession session = ServletActionContext.getRequest().getSession();
			
			String sd = (String)session.getAttribute("employee_ID");
		
		 gmailAuthenticationBean.setEmpUserId(sd);
		 ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
		 
		 System.out.println();
		 while(rs.next())
		 {
			 gmailAuthenticationBean.setGmailEmailId(rs.getString(3));
			 gmailAuthenticationBean.setGmailPassword(rs.getString(4));
			 
			 System.out.println(rs.getString(3)+rs.getString(4));
		 } 
		 
		 gmail gmail = new gmail();
		 gmail.setAccountDetails(gmailAuthenticationBean.getGmailEmailId(), gmailAuthenticationBean.getGmailPassword());
		
		 System.out.println(gmailAuthenticationBean.getGmailEmailId());
		 gmail.readAllGmail();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 return "SUCCESS";
	}



	public GmailAuthenticationBean getGmailAuthenticationBean() {
		return gmailAuthenticationBean;
	}



	public void setGmailAuthenticationBean(
			GmailAuthenticationBean gmailAuthenticationBean) {
		this.gmailAuthenticationBean = gmailAuthenticationBean;
	}
	

	
	
	
	
	
	
	
}
