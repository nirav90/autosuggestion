package assys.com.action.welcome_login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import assys.com.DAO.welcome_login.RegisterDAO;
import assys.com.bean.welcome_login.Registration;
import assys.com.dbBean.Authentication_detail_bean;
import assys.com.dbBean.Emp_detail_bean;
import assys.com.dbBean.Emp_user_id_generator_bean;
import assys.com.dbDAO.Authentication_detail;
import assys.com.dbDAO.Emp_detail;
import assys.com.dbDAO.Emp_user_id_generator;

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

	Emp_detail empDetDAO = new Emp_detail();
	Emp_detail_bean empBean = new Emp_detail_bean();
	
	
	Emp_user_id_generator  empUserIdGenDAO = new Emp_user_id_generator();
	Emp_user_id_generator_bean empUserIdBean = new Emp_user_id_generator_bean();
	

	Authentication_detail authDetDAO = new Authentication_detail();
	Authentication_detail_bean authBean = new Authentication_detail_bean();
	
	
	
	
	
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
	 * @return the empIdGenBean
	 *//*
	public Emp_user_id_generator_bean getEmpIdGenBean() {
		return empIdGenBean;
	}

	*//**
	 * @param empIdGenBean the empIdGenBean to set
	 *//*
	public void setEmpIdGenBean(Emp_user_id_generator_bean empIdGenBean) {
		this.empIdGenBean = empIdGenBean;
	}

	*//**
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
	

	
	
	

	
	*//**
	 * @return the abean
	 *//*
	public Authentication_detail_bean getAbean() {
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
				ResultSet rs= empUserIdGenDAO.select(empUserIdBean);
			
			/*empIdGenBean.setEmp_user_id(embean.getEmp_user_id());
			ResultSet rs= empIdGenDAO.select(empIdGenBean);*/
			
				while(rs.next())
				{
						session.put("authDetDAO", authDetDAO);
						session.put("empDetDAO", empDetDAO);
						session.put("empBean", empBean);
						session.put("authBean", authBean);
						
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
