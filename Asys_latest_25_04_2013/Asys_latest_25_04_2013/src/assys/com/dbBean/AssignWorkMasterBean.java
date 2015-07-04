package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class AssignWorkMasterBean {

	private String empUserId,workId, senderEmailId,reciptanceEmailId, workMsgSubject,workMsgBody,fileName; 
	private Date startingDateTime,workMsgSendingDateTime,endingDateTime; 
	private Double duration;
	private int day,hour,minute;
	private boolean workApprove,isSeen;
	
	
	
	/**
	 * @return the workApprove
	 */
	public boolean isWorkApprove() {
		return workApprove;
	}
	/**
	 * @param workApprove the workApprove to set
	 */
	public void setWorkApprove(boolean workApprove) {
		this.workApprove = workApprove;
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
	 * @return the workId
	 */
	public String getWorkId() {
		return workId;
	}
	/**
	 * @param workId the workId to set
	 */
	public void setWorkId(String workId) {
		this.workId = workId;
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
	 * @return the workMsgSubject
	 */
	public String getWorkMsgSubject() {
		return workMsgSubject;
	}
	/**
	 * @param workMsgSubject the workMsgSubject to set
	 */
	public void setWorkMsgSubject(String workMsgSubject) {
		this.workMsgSubject = workMsgSubject;
	}
	/**
	 * @return the workMsgBody
	 */
	public String getWorkMsgBody() {
		return workMsgBody;
	}
	/**
	 * @param workMsgBody the workMsgBody to set
	 */
	public void setWorkMsgBody(String workMsgBody) {
		this.workMsgBody = workMsgBody;
	}
	/**
	 * @return the startingDateTime
	 */
	public Date getStartingDateTime() {
		return startingDateTime;
	}
	/**
	 * @param startingDateTime the startingDateTime to set
	 */
	public void setStartingDateTime(Date startingDateTime) {
		this.startingDateTime = startingDateTime;
	}
	/**
	 * @return the workMsgSendingDateTime
	 */
	public Date getWorkMsgSendingDateTime() {
		return workMsgSendingDateTime;
	}
	/**
	 * @param workMsgSendingDateTime the workMsgSendingDateTime to set
	 */
	public void setWorkMsgSendingDateTime(Date workMsgSendingDateTime) {
		this.workMsgSendingDateTime = workMsgSendingDateTime;
	}
	/**
	 * @return the duration
	 */
	public Double getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getEndingDateTime() {
		return endingDateTime;
	}
	public void setEndingDateTime(Date endingDateTime) {
		this.endingDateTime = endingDateTime;
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