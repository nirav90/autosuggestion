package assys.com.dbAction.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.ClientIdGeneratorBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.ClientIdGenerator;

public class ShowClientId {
	
	ClientIdGeneratorBean clientIdGeneratorBean=new ClientIdGeneratorBean();
	ClientIdGenerator clientIdGenerator=new ClientIdGenerator();
	AuthenticationDetail authenticationDetail=new AuthenticationDetail();
	AuthenticationDetailBean authenticationDetailBean=new AuthenticationDetailBean();
	public String execute() throws SQLException
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String clientID=clientIdGeneratorBean.getClientId();
		authenticationDetailBean.setEmpUserId(clientID);
		ResultSet rs=authenticationDetail.select(authenticationDetailBean);
		if(rs.next()){
			request.setAttribute("clientID1", clientID);
			return "Register";
		
		}
		else{
			String clientName=clientIdGeneratorBean.getClientName();
			String clientCompanyName=clientIdGeneratorBean.getClientCompanyName();
			
			request.setAttribute("clientID1", clientID);
			request.setAttribute("clientName", clientName);
			request.setAttribute("clientCompanyName", clientCompanyName);
			return "SUCCESS";	 
		}
	
	}
	/**
	 * @return the clientIdGeneratorBean
	 */
	public ClientIdGeneratorBean getClientIdGeneratorBean() {
		return clientIdGeneratorBean;
	}
	/**
	 * @param clientIdGeneratorBean the clientIdGeneratorBean to set
	 */
	public void setClientIdGeneratorBean(ClientIdGeneratorBean clientIdGeneratorBean) {
		this.clientIdGeneratorBean = clientIdGeneratorBean;
	}
	/**
	 * @return the authenticationDetailBean
	 */
	public AuthenticationDetailBean getAuthenticationDetailBean() {
		return authenticationDetailBean;
	}
	/**
	 * @param authenticationDetailBean the authenticationDetailBean to set
	 */
	public void setAuthenticationDetailBean(
			AuthenticationDetailBean authenticationDetailBean) {
		this.authenticationDetailBean = authenticationDetailBean;
	}
	
	
	
}
