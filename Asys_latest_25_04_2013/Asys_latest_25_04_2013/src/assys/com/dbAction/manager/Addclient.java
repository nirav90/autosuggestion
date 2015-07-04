package assys.com.dbAction.manager;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.ClientIdGeneratorBean;

import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.ClientIdGenerator;


public class Addclient {

    
	ClientIdGeneratorBean clientIdGeneratorBean = new ClientIdGeneratorBean();
	ClientIdGenerator  clientIdGenerator = new ClientIdGenerator();
	AuthenticationDetail authenticationDetail=new AuthenticationDetail();
	AuthenticationDetailBean authenticationDetailBean=new AuthenticationDetailBean();
	
	
	public String execute()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		clientIdGeneratorBean.setProjectManagerId(sd);
		
		clientIdGenerator.insert(clientIdGeneratorBean);
		
		return "SUCCESS";
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

	

	

	
	
	
	
}
