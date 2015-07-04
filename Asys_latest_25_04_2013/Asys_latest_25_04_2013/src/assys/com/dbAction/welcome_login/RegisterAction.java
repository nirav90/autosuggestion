package assys.com.dbAction.welcome_login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import assys.com.DAO.welcome_login.RegisterDAO;
import assys.com.bean.welcome_login.Registration;
import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.EmpDetailBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.EmpDetail;
import assys.com.dbDAO.EmpUserIdGenerator;

/**
 * @author Nirav
 *
 */
public class RegisterAction extends ActionSupport implements SessionAware {
	
	
	
	/*Registration register = new Registration();
	RegisterDAO  registerDAO = new RegisterDAO();
	boolean flag=false;
	
	public String register_success()
	{
		System.out.println("in Register_success");
		flag = registerDAO.Register(register);
		
		if(flag==true)
		{
			return "true";
		}
		else
		{
			return "false";
		}
		
		
		
	}

	public Registration getRegister() {
		return register;
	}

	public void setRegister(Registration register) {
		this.register = register;
	}
	*/
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @return the session
	 */
	
	
	
	String flag ="false";
	public Map<String, Object> getSession() {
		return session;
	}

	EmpDetail empDetDAO = new EmpDetail();
	EmpDetailBean empBean = new EmpDetailBean();
	
	
	EmpUserIdGenerator  empUserIdGenDAO = new EmpUserIdGenerator();
	EmpUserIdGeneratorBean empUserIdBean = new EmpUserIdGeneratorBean();
	

	AuthenticationDetail authDetDAO = new AuthenticationDetail();
	AuthenticationDetailBean authBean = new AuthenticationDetailBean();
	
	
	
	
	
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
	 * @return the empIdGenBean
	 *//*
	public EmpUserIdGeneratorBean getEmpIdGenBean() {
		return empIdGenBean;
	}

	*//**
	 * @param empIdGenBean the empIdGenBean to set
	 *//*
	public void setEmpIdGenBean(EmpUserIdGeneratorBean empIdGenBean) {
		this.empIdGenBean = empIdGenBean;
	}

	*//**
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
	

	
	
	

	
	*//**
	 * @return the abean
	 *//*
	public AuthenticationDetailBean getAbean() {
		return abean;
	}*/
	
	

	Map<String, Object> session = ActionContext.getContext().getSession();  
	
	public String register_success() throws SQLException

	{
		
		//abean.setEmp_user_id(embean.getEmp_user_id());
		/*emdbdao.insert(embean);
		adbdao.insert(abean);*/
		
		
		String pwd=authBean.getPassword();
		authBean.setPassword(null);
		ResultSet rs1 =authDetDAO.select(authBean);
		
		try
		{
			if(rs1.next())
			{
					flag="false";	
					/*System.exit(1);*/
			}	
			else
			{	
				authBean.setPassword(pwd);
				empUserIdBean.setEmpUserId(empBean.getEmpUserId());
				empUserIdBean.setEmpIdUsed(false);
				ResultSet rs= empUserIdGenDAO.select(empUserIdBean);
				System.out.println("before while of registerAction");
			/*empIdGenBean.setEmp_user_id(embean.getEmp_user_id());
			ResultSet rs= empIdGenDAO.select(empIdGenBean);*/
			
				while(rs.next())
				{
						session.put("authDetDAO", authDetDAO);
						session.put("empDetDAO", empDetDAO);
						session.put("empBean", empBean);
						session.put("authBean", authBean);
						session.put("empUserIdGenDAO", empUserIdGenDAO);
						session.put("empUserIdBean", empUserIdBean);
						System.out.println("end of register step1");
						flag="true";
				}	
		
			
			}
		}
		catch (Exception e) {
			
			// TODO: handle exception
			
			flag="false";
		}
		
		return flag;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	
	
	
	
	

}
