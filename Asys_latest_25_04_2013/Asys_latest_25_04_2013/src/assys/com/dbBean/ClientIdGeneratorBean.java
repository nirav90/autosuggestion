package assys.com.dbBean;

public class ClientIdGeneratorBean {
	
	
	private String clientName,clientId,clientCompanyName,projectManagerId;
	private boolean isIdGenerated,isProjectCompleted;
	
	
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientCompanyName() {
		return clientCompanyName;
	}
	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyName = clientCompanyName;
	}
	public String getProjectManagerId() {
		return projectManagerId;
	}
	public void setProjectManagerId(String projectManagerId) {
		this.projectManagerId = projectManagerId;
	}
	public boolean isIdGenerated() {
		return isIdGenerated;
	}
	public void setIdGenerated(boolean isIdGenerated) {
		this.isIdGenerated = isIdGenerated;
	}
	public boolean isProjectCompleted() {
		return isProjectCompleted;
	}
	public void setProjectCompleted(boolean isProjectCompleted) {
		this.isProjectCompleted = isProjectCompleted;
	}
	
	
	
}
