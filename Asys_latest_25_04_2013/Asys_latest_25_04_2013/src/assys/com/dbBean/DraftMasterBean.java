package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class DraftMasterBean {
	
	private String empUserId,emailId, draftSubject,draftBody,draftId;
	private Date draftSaveDateTime;
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the draftSubject
	 */
	public String getDraftSubject() {
		return draftSubject;
	}
	/**
	 * @param draftSubject the draftSubject to set
	 */
	public void setDraftSubject(String draftSubject) {
		this.draftSubject = draftSubject;
	}
	/**
	 * @return the draftBody
	 */
	public String getDraftBody() {
		return draftBody;
	}
	/**
	 * @param draftBody the draftBody to set
	 */
	public void setDraftBody(String draftBody) {
		this.draftBody = draftBody;
	}
	/**
	 * @return the draftId
	 */
	public String getDraftId() {
		return draftId;
	}
	/**
	 * @param draftId the draftId to set
	 */
	public void setDraftId(String draftId) {
		this.draftId = draftId;
	}
	/**
	 * @return the draftSaveDateTime
	 */
	public Date getDraftSaveDateTime() {
		return draftSaveDateTime;
	}
	/**
	 * @param draftSaveDateTime the draftSaveDateTime to set
	 */
	public void setDraftSaveDateTime(Date draftSaveDateTime) {
		this.draftSaveDateTime = draftSaveDateTime;
	}
	
	
	
}
