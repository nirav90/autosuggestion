package assys.com.dbBean;

import java.util.Date;



/**
 * @author Slesha
 *
 */

public class SentMailMasterBean {

	private String empUserId,senderEmailId, reciptanceEmailId,emailSubject, emailBody,sentId;
	
	private Date emailSentDateTime;
	
	private String attachFileFileName;
	
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
	 * @return the reciptanceEmailId
	 */
	public String getReciptanceEmailId() {
		return reciptanceEmailId;
	}
	/**
	 * @param reciptanceEmailId the reciptanceEmailId to set
	 */
	public void setReciptanceEmailId(String reciptanceEmailId) {
		this.reciptanceEmailId = reciptanceEmailId;
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
	 * @return the emailBody
	 */
	public String getEmailBody() {
		return emailBody;
	}
	/**
	 * @param emailBody the emailBody to set
	 */
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	/**
	 * @return the sentId
	 */
	public String getSentId() {
		return sentId;
	}
	/**
	 * @param sentId the sentId to set
	 */
	public void setSentId(String sentId) {
		this.sentId = sentId;
	}
	/**
	 * @return the emailSentDateTime
	 */
	public Date getEmailSentDateTime() {
		return emailSentDateTime;
	}
	/**
	 * @param emailSentDateTime the emailSentDateTime to set
	 */
	public void setEmailSentDateTime(Date emailSentDateTime) {
		this.emailSentDateTime = emailSentDateTime;
	}
	
	
	
	public String getAttachFileFileName() {
		return attachFileFileName;
	}
	public void setAttachFileFileName(String attachFileFileName) {
		this.attachFileFileName = attachFileFileName;
	}
	
	
	
}
