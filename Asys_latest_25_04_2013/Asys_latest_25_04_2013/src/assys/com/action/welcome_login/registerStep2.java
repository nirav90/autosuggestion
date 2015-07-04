package assys.com.action.welcome_login;

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
import assys.com.dbBean.Authentication_detail_bean;
import assys.com.dbBean.Emp_detail_bean;
import assys.com.dbBean.Emp_user_id_generator_bean;
import assys.com.dbBean.Gmail_authentication_bean;
import assys.com.dbDAO.Authentication_detail;
import assys.com.dbDAO.Emp_detail;
import assys.com.dbDAO.Emp_user_id_generator;
import assys.com.dbDAO.Gmail_authentication;
import assys.com.gmail.MailUserBean;

public class registerStep2 extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session = ActionContext.getContext().getSession(); 
	
	Emp_detail empDetDAO = new Emp_detail();
	Emp_detail_bean empBean = new Emp_detail_bean();
	
	
	Gmail_authentication_bean gmailAuthBean = new Gmail_authentication_bean();
	Gmail_authentication gmailAuthDAO = new Gmail_authentication();
	
	
	Authentication_detail authDetDAO = new Authentication_detail();
	Authentication_detail_bean authBean = new Authentication_detail_bean();

	Emp_user_id_generator empUserIdGenDAO = new Emp_user_id_generator();
	Emp_user_id_generator_bean empUserIdBean = new Emp_user_id_generator_bean();
	
	
	
	
	
	
	/**
	 * @return the empBean
	 */
	public Emp_detail_bean getEmpBean() {
		return empBean;
	}
	/**
	 * @param empBean the empBean to set
	 */
	public void setEmpBean(Emp_detail_bean empBean) {
		this.empBean = empBean;
	}
	/**
	 * @return the gmailAuthBean
	 */
	public Gmail_authentication_bean getGmailAuthBean() {
		return gmailAuthBean;
	}
	/**
	 * @param gmailAuthBean the gmailAuthBean to set
	 */
	public void setGmailAuthBean(Gmail_authentication_bean gmailAuthBean) {
		this.gmailAuthBean = gmailAuthBean;
	}
	/**
	 * @return the authBean
	 */
	public Authentication_detail_bean getAuthBean() {
		return authBean;
	}
	/**
	 * @param authBean the authBean to set
	 */
	public void setAuthBean(Authentication_detail_bean authBean) {
		this.authBean = authBean;
	}
	/**
	 * @return the empUserIdBean
	 */
	public Emp_user_id_generator_bean getEmpUserIdBean() {
		return empUserIdBean;
	}
	/**
	 * @param empUserIdBean the empUserIdBean to set
	 */
	public void setEmpUserIdBean(Emp_user_id_generator_bean empUserIdBean) {
		this.empUserIdBean = empUserIdBean;
	}
	
	
	
	LoginDAO loginDAO=new LoginDAO();
	
	private Login login;
	
	public String execute() throws Exception
	{
		Connection conn = null;
		conn = (Connection) DBConnection.getConnection();
		
		Savepoint savePoint=null;
		Savepoint savePoint1=null;
		String flag = "false";
		
		
		
		try
		{
			conn.setAutoCommit(false);
			
			MailUserBean mb = new MailUserBean();
			mb.login("imap.gmail.com",gmailAuthBean.getGmailEmailId(),gmailAuthBean.getGmailPassword());
			
			System.out.println("line 1");
			
			
			Emp_detail empDetDAO1 = (Emp_detail) session.get("empDetDAO");
			Emp_detail_bean empBean1 = (Emp_detail_bean) session.get("empBean");
			
			Authentication_detail_bean authBean1 = (Authentication_detail_bean) session.get("authBean");
			Authentication_detail authDetDAO1= (Authentication_detail) session.get("authDetDAO");
			
			Emp_user_id_generator empUserIdGenDAO1=(Emp_user_id_generator) session.get("empUserIdGenDAO1");
			Emp_user_id_generator_bean empUserIdBean1 = (Emp_user_id_generator_bean) session.get("empUserIdBean");
			savePoint=conn.setSavepoint("before insert");
			
			authBean1.setEmpUserId(empBean1.getEmpUserId());
			
			
			empUserIdBean.setEmpUserId(empBean1.getEmpUserId());
			empUserIdBean.setEmpIdUsed(true);
			empUserIdBean1.setEmpUserId(empBean1.getEmpUserId());
			
			ResultSet rs2=empUserIdGenDAO.select(empUserIdBean);
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

				flag1=empDetDAO1.insert(empBean1);
				flag2=authDetDAO1.insert(authBean1);
				gmailAuthBean.setGmailPassword(pwd);
				gmailAuthBean.setUserName(authBean1.getUserName());
				gmailAuthBean.setEmpUserId(empBean1.getEmpUserId());
				flag3=gmailAuthDAO.insert(gmailAuthBean);
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
	public Emp_detail getEmdbdao() {
		return emdbdao;
	}
	*//**
	 * @param emdbdao the emdbdao to set
	 *//*
	public void setEmdbdao(Emp_detail emdbdao) {
		this.emdbdao = emdbdao;
	}
	*//**
	 * @return the embean
	 *//*
	public Emp_detail_bean getEmbean() {
		return embean;
	}
	*//**
	 * @param embean the embean to set
	 *//*
	public void setEmbean(Emp_detail_bean embean) {
		this.embean = embean;
	}
	*//**
	 * @return the adbdao
	 *//*
	public Authentication_detail getAdbdao() {
		return adbdao;
	}
	*//**
	 * @param adbdao the adbdao to set
	 *//*
	public void setAdbdao(Authentication_detail adbdao) {
		this.adbdao = adbdao;
	}
	*//**
	 * @return the abean
	 *//*
	public Authentication_detail_bean getAbean() {
		return abean;
	}
	*//**
	 * @param abean the abean to set
	 *//*
	public void setAbean(Authentication_detail_bean abean) {
		this.abean = abean;
	}
	*//**
	 * @return the gmailAuthBean
	 *//*
	public Gmail_authentication_bean getGmailAuthBean() {
		return gmailAuthBean;
	}
	*//**
	 * @param gmailAuthBean the gmailAuthBean to set
	 *//*
	public void setGmailAuthBean(Gmail_authentication_bean gmailAuthBean) {
		this.gmailAuthBean = gmailAuthBean;
	}
	*//**
	 * @return the eidGen
	 *//*
	public Emp_user_id_generator getEidGen() {
		return eidGen;
	}
	*//**
	 * @param eidGen the eidGen to set
	 *//*
	public void setEidGen(Emp_user_id_generator eidGen) {
		this.eidGen = eidGen;
	}
	*//**
	 * @return the eidGenBean
	 *//*
	public Emp_user_id_generator_bean getEidGenBean() {
		return eidGenBean;
	}
	*//**
	 * @param eidGenBean the eidGenBean to set
	 *//*
	public void setEidGenBean(Emp_user_id_generator_bean eidGenBean) {
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
	
	
}
