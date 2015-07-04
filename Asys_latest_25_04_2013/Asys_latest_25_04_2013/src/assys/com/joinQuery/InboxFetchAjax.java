package assys.com.joinQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.InboxMasterBean;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.InboxMaster;
import assys.com.gmail.gmail;

public class InboxFetchAjax extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//HttpSession session1 = ServletActionContext.getRequest().getSession();
	GmailAuthentication gmailAuthentication = new GmailAuthentication();
	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();

	InboxMasterBean inboxMasterBean = new InboxMasterBean();
	InboxMaster inboxMaster = new InboxMaster();
	/*HttpSession session = ServletActionContext.getRequest().getSession();
	
	String sd1 = (String)session.getAttribute("employee_ID");
	*/
	public void AjaxInbox(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd1 = (String)session.getAttribute("employee_ID");
		InboxFetch(sd1);
		//return Action.NONE;
	}
	
	public void InboxFetch(String sd){
		
		System.out.println(sd);
		gmailAuthenticationBean.setEmpUserId(sd);
		ResultSet rs3 = gmailAuthentication.select(gmailAuthenticationBean);
		
		
		try {
			while(rs3.next())
			 {
				 gmailAuthenticationBean.setGmailEmailId(rs3.getString(3));
				 gmailAuthenticationBean.setGmailPassword(rs3.getString(4));
				 
				 System.out.println(rs3.getString(3)+rs3.getString(4));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		 gmail gmail = new gmail();
		 gmail.setAccountDetails(gmailAuthenticationBean.getGmailEmailId(), gmailAuthenticationBean.getGmailPassword());
		
		 System.out.println(gmailAuthenticationBean.getGmailEmailId());
		 
		 inboxMasterBean.setEmpUserId(sd);
		 
		 
		 /*check read unread mail and than call approprite method*/
		 
		
		 //session.setAttribute("employee_ID", sd);
		 ResultSet rs4 =inboxMaster.select(inboxMasterBean);
		 
		 try {
			if(rs4.next())
			 {
				 gmail.unreadAllGmail();
			 }	
			 else
			 {
				 gmail.readAllGmail();
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
			 
		
	
		
		
		
		
		
		
		
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
