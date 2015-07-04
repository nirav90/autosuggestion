package assys.com.bean.welcome_login;

import java.io.Serializable;

/**
 * @author Slesha at 30-11-12
 *
 */
public class Login implements Serializable{
	
	private String loginUserName;
	private String loginPassWord;
	public Login()
	{
		this.loginUserName=null;
		this.loginPassWord=null;
	}
	public String getLoginUserName() {
		return loginUserName;
	}
	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
	public String getLoginPassWord() {
		return loginPassWord;
	}
	public void setLoginPassWord(String loginPassWord) {
		this.loginPassWord = loginPassWord;
	}
	
}
