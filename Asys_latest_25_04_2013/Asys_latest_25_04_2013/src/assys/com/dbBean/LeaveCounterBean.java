package assys.com.dbBean;

public class LeaveCounterBean {
	private String empUserId;
	private int leaveMonth,leaveYear,leaveCount;
	
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
	 * @return the leaveMonth
	 */
	public int getLeaveMonth() {
		return leaveMonth;
	}
	/**
	 * @param leaveMonth the leaveMonth to set
	 */
	public void setLeaveMonth(int leaveMonth) {
		this.leaveMonth = leaveMonth;
	}
	/**
	 * @return the leaveYear
	 */
	public int getLeaveYear() {
		return leaveYear;
	}
	/**
	 * @param leaveYear the leaveYear to set
	 */
	public void setLeaveYear(int leaveYear) {
		this.leaveYear = leaveYear;
	}
	/**
	 * @return the leaveCount
	 */
	public int getLeaveCount() {
		return leaveCount;
	}
	/**
	 * @param leaveCount the leaveCount to set
	 */
	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}
		
}
