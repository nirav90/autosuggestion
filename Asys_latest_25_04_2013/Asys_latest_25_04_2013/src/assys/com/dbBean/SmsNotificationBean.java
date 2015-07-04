package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class SmsNotificationBean {

	
	
	private String empUserId,phoneNo, smsNotificationMessage,smsNotificationId;
	private Date smsNotificationDateTime;
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
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the smsNotificationMessage
	 */
	public String getSmsNotificationMessage() {
		return smsNotificationMessage;
	}
	/**
	 * @param smsNotificationMessage the smsNotificationMessage to set
	 */
	public void setSmsNotificationMessage(String smsNotificationMessage) {
		this.smsNotificationMessage = smsNotificationMessage;
	}
	/**
	 * @return the smsNotificationId
	 */
	public String getSmsNotificationId() {
		return smsNotificationId;
	}
	/**
	 * @param smsNotificationId the smsNotificationId to set
	 */
	public void setSmsNotificationId(String smsNotificationId) {
		this.smsNotificationId = smsNotificationId;
	}
	/**
	 * @return the smsNotificationDateTime
	 */
	public Date getSmsNotificationDateTime() {
		return smsNotificationDateTime;
	}
	/**
	 * @param smsNotificationDateTime the smsNotificationDateTime to set
	 */
	public void setSmsNotificationDateTime(Date smsNotificationDateTime) {
		this.smsNotificationDateTime = smsNotificationDateTime;
	}
	
	
}
