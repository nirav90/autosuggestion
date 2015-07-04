package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class EmailNotificationBean {

	private String empUserId,emailNotificationMessage,emailNotificationId,emailNfcSenderId,emailNfcReceiverId,emailNfcSubject; 
	private Date emailNotificationDateTime;
	
	
	/**
	 * @return the empUserId
	 */
	public String getEmpUserId() {
		return empUserId;
	}
	/**
	 * @param empUserId the empUserId to set
	 */
	public void setEmpUserId(String empUserId) {
		this.empUserId = empUserId;
	}
	/**
	 * @return the emailNotificationMessage
	 */
	public String getEmailNotificationMessage() {
		return emailNotificationMessage;
	}
	/**
	 * @param emailNotificationMessage the emailNotificationMessage to set
	 */
	public void setEmailNotificationMessage(String emailNotificationMessage) {
		this.emailNotificationMessage = emailNotificationMessage;
	}
	/**
	 * @return the emailNotificationId
	 */
	public String getEmailNotificationId() {
		return emailNotificationId;
	}
	/**
	 * @param emailNotificationId the emailNotificationId to set
	 */
	public void setEmailNotificationId(String emailNotificationId) {
		this.emailNotificationId = emailNotificationId;
	}
	/**
	 * @return the emailNotificationDateTime
	 */
	public Date getEmailNotificationDateTime() {
		return emailNotificationDateTime;
	}
	/**
	 * @param emailNotificationDateTime the emailNotificationDateTime to set
	 */
	public void setEmailNotificationDateTime(Date emailNotificationDateTime) {
		this.emailNotificationDateTime = emailNotificationDateTime;
	}
	/**
	 * @return the emailNfcSenderId
	 */
	public String getEmailNfcSenderId() {
		return emailNfcSenderId;
	}
	/**
	 * @param emailNfcSenderId the emailNfcSenderId to set
	 */
	public void setEmailNfcSenderId(String emailNfcSenderId) {
		this.emailNfcSenderId = emailNfcSenderId;
	}
	/**
	 * @return the emailNfcReceiverId
	 */
	public String getEmailNfcReceiverId() {
		return emailNfcReceiverId;
	}
	/**
	 * @param emailNfcReceiverId the emailNfcReceiverId to set
	 */
	public void setEmailNfcReceiverId(String emailNfcReceiverId) {
		this.emailNfcReceiverId = emailNfcReceiverId;
	}
	/**
	 * @return the emailNfcSubject
	 */
	public String getEmailNfcSubject() {
		return emailNfcSubject;
	}
	/**
	 * @param emailNfcSubject the emailNfcSubject to set
	 */
	public void setEmailNfcSubject(String emailNfcSubject) {
		this.emailNfcSubject = emailNfcSubject;
	}
	
	
	
}
