package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class LeaveMasterBean {

	private String empUserId,senderEmailId, reciptanceEmailId,leaveSubject, leaveBody,leaveId,leaveFromDate,leaveToDate; 
	private Date leaveSendingDateTime; 
	private boolean leaveApprove,isSeen;
	
	
	/**
	 * @return the leaveFromDate
	 */
	public String getLeaveFromDate() {
		return leaveFromDate;
	}
	/**
	 * @param leaveFromDate the leaveFromDate to set
	 */
	public void setLeaveFromDate(String leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}
	/**
	 * @return the leaveToDate
	 */
	public String getLeaveToDate() {
		return leaveToDate;
	}
	/**
	 * @param leaveToDate the leaveToDate to set
	 */
	public void setLeaveToDate(String leaveToDate) {
		this.leaveToDate = leaveToDate;
	}
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
	 * @return the leaveSubject
	 */
	public String getLeaveSubject() {
		return leaveSubject;
	}
	/**
	 * @param leaveSubject the leaveSubject to set
	 */
	public void setLeaveSubject(String leaveSubject) {
		this.leaveSubject = leaveSubject;
	}
	/**
	 * @return the leaveBody
	 */
	public String getLeaveBody() {
		return leaveBody;
	}
	/**
	 * @param leaveBody the leaveBody to set
	 */
	public void setLeaveBody(String leaveBody) {
		this.leaveBody = leaveBody;
	}
	/**
	 * @return the leaveId
	 */
	public String getLeaveId() {
		return leaveId;
	}
	/**
	 * @param leaveId the leaveId to set
	 */
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	
	
	/**
	 * @return the leaveSendingDateTime
	 */
	public Date getLeaveSendingDateTime() {
		return leaveSendingDateTime;
	}
	/**
	 * @param leaveSendingDateTime the leaveSendingDateTime to set
	 */
	public void setLeaveSendingDateTime(Date leaveSendingDateTime) {
		this.leaveSendingDateTime = leaveSendingDateTime;
	}
	/**
	 * @return the leaveApprove
	 */
	public boolean isLeaveApprove() {
		return leaveApprove;
	}
	/**
	 * @param leaveApprove the leaveApprove to set
	 */
	public void setLeaveApprove(boolean leaveApprove) {
		this.leaveApprove = leaveApprove;
	}
	/**
	 * @return the isSeen
	 */
	public boolean isSeen() {
		return isSeen;
	}
	/**
	 * @param isSeen the isSeen to set
	 */
	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}
	
	
	 
}
