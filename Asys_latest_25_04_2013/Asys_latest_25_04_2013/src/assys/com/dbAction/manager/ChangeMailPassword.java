package assys.com.dbAction.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.gmail.MailUserBean;

public class ChangeMailPassword {

	GmailAuthentication gmailAuthentication=new GmailAuthentication();
	GmailAuthenticationBean gmailAuthenticationBean=new GmailAuthenticationBean();
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	public String execute() throws SQLException {
		String result="false";
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		String sd = (String)session.getAttribute("employee_ID");
		gmailAuthenticationBean.setEmpUserId(sd);
		String gmailPassword=gmailAuthenticationBean.getGmailPassword();
		gmailAuthenticationBean.setGmailPassword(null);
		ResultSet rs=gmailAuthentication.select(gmailAuthenticationBean);
		
		while(rs.next()){
			gmailAuthenticationBean.setGmailEmailId(rs.getString("gmail_email_id"));
		}
		System.out.println(gmailAuthenticationBean.getGmailEmailId()+gmailAuthenticationBean.getGmailPassword());
		MailUserBean mb = new MailUserBean();
		
		try {
			mb.login("imap.gmail.com",gmailAuthenticationBean.getGmailEmailId(),gmailPassword);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			request.setAttribute("false1", "false1");
			return result;
		}
		gmailAuthenticationBean.setEmpUserId(sd);
		gmailAuthenticationBean.setGmailPassword(gmailPassword);
		gmailAuthentication.update(gmailAuthenticationBean);
		empUserIdBean.setEmpUserId(sd);
		empUserIdBean.setEmpIdUsed(true);
		ResultSet rs1=empUserIdGen.select(empUserIdBean);
		String empCategory;
		try {
			while(rs1.next()){
				empCategory=rs1.getString("emp_category");
				
				if(empCategory.equals("Employee")){
					result="employee";
				}
				else if(empCategory.equals("Project Manager")){
					result="pmanager";
				}
				request.setAttribute("success", "success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return result;
		
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
	
}
