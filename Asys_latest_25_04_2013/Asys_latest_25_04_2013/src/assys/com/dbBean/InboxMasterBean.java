package assys.com.dbBean;

import java.util.Date;

public class InboxMasterBean {
	private String empUserId,senderEmailId,receiverEmailId,emailSubject;
	int mailNo;
	private Date emailSendDateTime;
	
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
	 * @return the senderEmailId
	 */
	public String getSenderEmailId() {
		return senderEmailId;
	}
	/**
	 * @param senderEmailId the senderEmailId to set
	 */
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	/**
	 * @return the receiverEmailId
	 */
	public String getReceiverEmailId() {
		return receiverEmailId;
	}
	/**
	 * @param receiverEmailId the receiverEmailId to set
	 */
	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}
	/**
	 * @return the emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}
	/**
	 * @param emailSubject the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	/**
	 * @return the emailSendDateTime
	 */
	public Date getEmailSendDateTime() {
		return emailSendDateTime;
	}
	/**
	 * @param emailSendDateTime the emailSendDateTime to set
	 */
	public void setEmailSendDateTime(Date emailSendDateTime) {
		this.emailSendDateTime = emailSendDateTime;
	}
	public int getMailNo() {
		return mailNo;
	}
	public void setMailNo(int i) {
		this.mailNo = i;
	}
	
}
