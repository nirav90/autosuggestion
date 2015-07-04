package assys.com.dbAction.welcome_login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import assys.com.DAO.DBConnection;
import assys.com.DAO.welcome_login.LoginDAO;
import assys.com.bean.welcome_login.Login;
import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.EmpDetailBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.InboxMasterBean;
import assys.com.dbBean.LoginHistoryBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.EmpDetail;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.InboxMaster;
import assys.com.dbDAO.LoginHistory;
import assys.com.gmail.MailUserBean;
import assys.com.gmail.gmail;

public class registerStep2 extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session = ActionContext.getContext().getSession(); 
	
	EmpDetail empDetDAO = new EmpDetail();
	EmpDetailBean empBean = new EmpDetailBean();
	
	
	GmailAuthenticationBean gmailAuthBean = new GmailAuthenticationBean();
	GmailAuthentication gmailAuthDAO = new GmailAuthentication();
	
	
	AuthenticationDetail authDetDAO = new AuthenticationDetail();
	AuthenticationDetailBean authBean = new AuthenticationDetailBean();

	EmpUserIdGenerator empUserIdGenDAO = new EmpUserIdGenerator();
	EmpUserIdGeneratorBean empUserIdBean = new EmpUserIdGeneratorBean();
	
	
	
	LoginHistoryBean lgnHistBean=new LoginHistoryBean();
	LoginHistory lgnHist=new LoginHistory();
	
	InboxMasterBean inboxMasterBean = new InboxMasterBean();
	InboxMaster inboxMaster = new InboxMaster();
	
	/**
	 * @return the empBean
	 */
	public EmpDetailBean getEmpBean() {
		return empBean;
	}
	/**
	 * @param empBean the empBean to set
	 */
	public void setEmpBean(EmpDetailBean empBean) {
		this.empBean = empBean;
	}
	/**
	 * @return the gmailAuthBean
	 */
	public GmailAuthenticationBean getGmailAuthBean() {
		return gmailAuthBean;
	}
	/**
	 * @param gmailAuthBean the gmailAuthBean to set
	 */
	public void setGmailAuthBean(GmailAuthenticationBean gmailAuthBean) {
		this.gmailAuthBean = gmailAuthBean;
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
	
	
	
	LoginDAO loginDAO=new LoginDAO();
	
	private Login login;
	
	public String execute() throws Exception
	{
		System.out.println("before connection");
		Connection conn = null;
		conn = (Connection) DBConnection.getConnection();
		System.out.println("after connection");
		Savepoint savePoint=null;
		Savepoint savePoint1=null;
		String flag = "false";
		System.out.println(gmailAuthBean.getGmailEmailId());
		
		
		try
		{
			System.out.println("in try block");
			conn.setAutoCommit(false);
			
			MailUserBean mb = new MailUserBean();
			mb.login("imap.gmail.com",gmailAuthBean.getGmailEmailId(),gmailAuthBean.getGmailPassword());
			
			System.out.println("registre step 2 line 1");
			
			
			EmpDetail empDetDAO1 = (EmpDetail) session.get("empDetDAO");
			EmpDetailBean empBean1 = (EmpDetailBean) session.get("empBean");
			
			AuthenticationDetailBean authBean1 = (AuthenticationDetailBean) session.get("authBean");
			AuthenticationDetail authDetDAO1= (AuthenticationDetail) session.get("authDetDAO");
			
			EmpUserIdGenerator empUserIdGenDAO1=(EmpUserIdGenerator) session.get("empUserIdGenDAO1");
			EmpUserIdGeneratorBean empUserIdBean1 = (EmpUserIdGeneratorBean) session.get("empUserIdBean");
			savePoint=conn.setSavepoint("before insert");
			
			authBean1.setEmpUserId(empBean1.getEmpUserId());
			
			
			empUserIdBean.setEmpUserId(empBean1.getEmpUserId());
			
			System.out.println("eid used");
			String pwd=gmailAuthBean.getGmailPassword();
			gmailAuthBean.setGmailPassword(null);
			ResultSet rs5=gmailAuthDAO.select(gmailAuthBean);
			String flag1="false",flag2="false",flag3="false";
			System.out.println("you are above rs5");
			while(rs5.next()){
				System.out.println(rs5.getString("gmail_email_id"));
			}
			rs5.beforeFirst();
			if(rs5.next())
			{
				System.out.println("in if of rs5");	
				flag="false";
			}
			else{
				System.out.println("you are in else of rs5");
				empUserIdGenDAO.update(empUserIdBean);
				empUserIdBean.setEmpIdUsed(true);
				empUserIdBean1.setEmpUserId(empBean1.getEmpUserId());
				
				ResultSet rs2=empUserIdGenDAO.select(empUserIdBean);
				flag1=empDetDAO1.insert(empBean1);
				flag2=authDetDAO1.insert(authBean1);
				lgnHistBean.setUserName(authBean1.getUserName());
				lgnHist.insert(lgnHistBean);
				gmailAuthBean.setGmailPassword(pwd);
				gmailAuthBean.setUserName(authBean1.getUserName());
				gmailAuthBean.setEmpUserId(empBean1.getEmpUserId());
				
				flag3=gmailAuthDAO.insert(gmailAuthBean);
				ResultSet rs3 = gmailAuthDAO.select(gmailAuthBean);
				 
				 System.out.println(rs3);
				 while(rs3.next())
				 {
					 gmailAuthBean.setGmailEmailId(rs3.getString(3));
					 gmailAuthBean.setGmailPassword(rs3.getString(4));
					 
					 System.out.println(rs3.getString(3)+rs3.getString(4));
				 }
				 gmail gmail = new gmail();
				 gmail.setAccountDetails(gmailAuthBean.getGmailEmailId(), gmailAuthBean.getGmailPassword());
				 inboxMasterBean.setEmpUserId(empBean1.getEmpUserId());
				 ResultSet rs4 =inboxMaster.select(inboxMasterBean);
				 
				 if(rs4.next())
				 {
					 gmail.unreadAllGmail();
				 }	
				 else
				 {
					 gmail.readAllGmail();
					 
				 }
				System.out.println("eid used");
				if(rs2.next())
				{
					String category=rs2.getString("emp_category");
					System.out.println(category);
					if(category.equals("Admin"))
					{
						flag="admin";
						System.out.println(flag);
					}
					if(category.equals("Client"))
					{
						flag="client";
						System.out.println(flag);
					}	
					if(category.equals("Project Manager"))
					{
						flag="pmanager";
						System.out.println(flag);
					}	
					if(category.equals("Employee"))
					{
						flag="employee";
						System.out.println(flag);
					}
				}
				session.put("employee_ID",empBean1.getEmpUserId());	
				
				session.put("firstName", empBean1.getFirstName());
				session.put("mailuser",mb);
				session.put("folder",mb.getFolder());
				
				HttpSession session = ServletActionContext.getRequest().getSession();
				
				session.setAttribute("employee_ID", empBean1.getEmpUserId());
				session.setAttribute("userName",authBean1.getUserName());
			}
			if(flag1=="true" && flag2=="true" && flag3=="true")
			{
				System.out.println("in if of conn commit");
				conn.commit();
			}
			else{
				System.out.println("in if of conn rollback");
				flag="false";
				conn.rollback(savePoint1);
				conn.rollback(savePoint);
			}
			
			
					
			
						/*
						eidGenBean.setEmp_user_id(embean1.getEmp_user_id());
						eidGenBean.setEmp_id_used(true);
					
						*/
						/*LoginAction loginAction = new LoginAction();
						 flag1=loginAction.login_success();
						*/
			
			
		}
		catch (Exception e) {
			System.out.println(e.toString());
			flag="false";
			conn.rollback(savePoint);
		}
		
		return flag;	
		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session =session;
		
	}
	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	
	
	
	/**
	 * @return the emdbdao
	 *//*
	public EmpDetail getEmdbdao() {
		return emdbdao;
	}
	*//**
	 * @param emdbdao the emdbdao to set
	 *//*
	public void setEmdbdao(EmpDetail emdbdao) {
		this.emdbdao = emdbdao;
	}
	*//**
	 * @return the embean
	 *//*
	public EmpDetailBean getEmbean() {
		return embean;
	}
	*//**
	 * @param embean the embean to set
	 *//*
	public void setEmbean(EmpDetailBean embean) {
		this.embean = embean;
	}
	*//**
	 * @return the adbdao
	 *//*
	public AuthenticationDetail getAdbdao() {
		return adbdao;
	}
	*//**
	 * @param adbdao the adbdao to set
	 *//*
	public void setAdbdao(AuthenticationDetail adbdao) {
		this.adbdao = adbdao;
	}
	*//**
	 * @return the abean
	 *//*
	public AuthenticationDetailBean getAbean() {
		return abean;
	}
	*//**
	 * @param abean the abean to set
	 *//*
	public void setAbean(AuthenticationDetailBean abean) {
		this.abean = abean;
	}
	*//**
	 * @return the gmailAuthBean
	 *//*
	public GmailAuthenticationBean getGmailAuthBean() {
		return gmailAuthBean;
	}
	*//**
	 * @param gmailAuthBean the gmailAuthBean to set
	 *//*
	public void setGmailAuthBean(GmailAuthenticationBean gmailAuthBean) {
		this.gmailAuthBean = gmailAuthBean;
	}
	*//**
	 * @return the eidGen
	 *//*
	public EmpUserIdGenerator getEidGen() {
		return eidGen;
	}
	*//**
	 * @param eidGen the eidGen to set
	 *//*
	public void setEidGen(EmpUserIdGenerator eidGen) {
		this.eidGen = eidGen;
	}
	*//**
	 * @return the eidGenBean
	 *//*
	public EmpUserIdGeneratorBean getEidGenBean() {
		return eidGenBean;
	}
	*//**
	 * @param eidGenBean the eidGenBean to set
	 *//*
	public void setEidGenBean(EmpUserIdGeneratorBean eidGenBean) {
		this.eidGenBean = eidGenBean;
	}*/
	
	
	
	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
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
