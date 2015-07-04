package assys.com.action.welcome_login;




import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import assys.com.DAO.welcome_login.LoginDAO;
import assys.com.bean.welcome_login.Login;

/**
 * @author Slesha at 30-11-12
 *
 */
public class LoginAction extends ActionSupport /*implements SessionAware*/{
	private Login login;
	/*private Map<String,Object> loginSession;*/
	LoginDAO loginDAO=new LoginDAO();
	String flag="false";
	public String login_success() throws SQLException
	{
		
		try {
			flag=loginDAO.login_select(login);
			System.out.println("flag value:"+ flag );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	/*public void setSession(Map<String,Object> session)
	{
		loginSession=session;
	}*/
}
