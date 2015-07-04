package assys.com.dbBean;

import java.util.Date;

/**
 * @author Slesha
 *
 */

public class ProjectDetailBean {

	private String clientEmpUserId,projectManagerEmpUserId, projectName,clientName, projectDesc,projectId,startingDateOfProject,endDateOfProject; 
	
	
	/**
	 * @return the clientEmpUserId
	 */
	public String getClientEmpUserId() {
		return clientEmpUserId;
	}
	/**
	 * @param clientEmpUserId the clientEmpUserId to set
	 */
	public void setClientEmpUserId(String clientEmpUserId) {
		this.clientEmpUserId = clientEmpUserId;
	}
	/**
	 * @return the projectManagerEmpUserId
	 */
	public String getProjectManagerEmpUserId() {
		return projectManagerEmpUserId;
	}
	/**
	 * @param projectManagerEmpUserId the projectManagerEmpUserId to set
	 */
	public void setProjectManagerEmpUserId(String projectManagerEmpUserId) {
		this.projectManagerEmpUserId = projectManagerEmpUserId;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the projectDesc
	 */
	public String getProjectDesc() {
		return projectDesc;
	}
	/**
	 * @param projectDesc the projectDesc to set
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getStartingDateOfProject() {
		return startingDateOfProject;
	}
	public void setStartingDateOfProject(String startingDateOfProject) {
		this.startingDateOfProject = startingDateOfProject;
	}
	public String getEndDateOfProject() {
		return endDateOfProject;
	}
	public void setEndDateOfProject(String endDateOfProject) {
		this.endDateOfProject = endDateOfProject;
	}
	
	
	
	
}
