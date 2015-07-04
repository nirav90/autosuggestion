package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class LoginHistoryBean {

	private String userName,loginId;
	private Date loginDateTime;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the loginDateTime
	 */
	public Date getLoginDateTime() {
		return loginDateTime;
	}
	/**
	 * @param loginDateTime the loginDateTime to set
	 */
	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	
	
	
}
