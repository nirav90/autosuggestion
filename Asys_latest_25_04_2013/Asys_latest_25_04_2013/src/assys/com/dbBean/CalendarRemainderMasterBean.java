package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class CalendarRemainderMasterBean {

	
	private String empUserId,remainderTaskName,remainderId;
	private Date remaiderTaskDateTime;
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
	 * @return the remainderTaskName
	 */
	public String getRemainderTaskName() {
		return remainderTaskName;
	}
	/**
	 * @param remainderTaskName the remainderTaskName to set
	 */
	public void setRemainderTaskName(String remainderTaskName) {
		this.remainderTaskName = remainderTaskName;
	}
	/**
	 * @return the remainderId
	 */
	public String getRemainderId() {
		return remainderId;
	}
	/**
	 * @param remainderId the remainderId to set
	 */
	public void setRemainderId(String remainderId) {
		this.remainderId = remainderId;
	}
	/**
	 * @return the remaiderTaskDateTime
	 */
	public Date getRemaiderTaskDateTime() {
		return remaiderTaskDateTime;
	}
	/**
	 * @param remaiderTaskDateTime the remaiderTaskDateTime to set
	 */
	public void setRemaiderTaskDateTime(Date remaiderTaskDateTime) {
		this.remaiderTaskDateTime = remaiderTaskDateTime;
	}
	
	
	
}
