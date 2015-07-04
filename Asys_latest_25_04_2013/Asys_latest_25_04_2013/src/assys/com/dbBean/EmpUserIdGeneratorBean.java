package assys.com.dbBean;

/**
 * @author Slesha
 *
 */

public class EmpUserIdGeneratorBean {

	private String empUserId,empCategory;
	private boolean empIdUsed;
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
	 * @return the empCategory
	 */
	public String getEmpCategory() {
		return empCategory;
	}
	/**
	 * @param empCategory the empCategory to set
	 */
	public void setEmpCategory(String empCategory) {
		this.empCategory = empCategory;
	}
	/**
	 * @return the empIdUsed
	 */
	public boolean isEmpIdUsed() {
		return empIdUsed;
	}
	/**
	 * @param empIdUsed the empIdUsed to set
	 */
	public void setEmpIdUsed(boolean empIdUsed) {
		this.empIdUsed = empIdUsed;
	}
	
	
	
}
