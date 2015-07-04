package assys.com.dbAction.admin;

import java.util.Random;

import assys.com.dbBean.ClientIdGeneratorBean;
import assys.com.dbDAO.ClientIdGenerator;

public class GenerateClientId {

	ClientIdGeneratorBean clientIdGeneratorBean=new ClientIdGeneratorBean();
	ClientIdGenerator clientIdGenerator=new ClientIdGenerator();
	Random rnd=new Random();
	int empId=rnd.nextInt(Integer.MAX_VALUE)+1;
	
	public String execute(){
		
		
		String clientId="cln"+empId;
		System.out.println(clientIdGeneratorBean.getClientCompanyName());
		
		clientIdGeneratorBean.setClientId(clientId);
		clientIdGeneratorBean.setIdGenerated(true);
		clientIdGenerator.update(clientIdGeneratorBean);
		return "SUCCESS";
	}

	public ClientIdGeneratorBean getClientIdGeneratorBean() {
		return clientIdGeneratorBean;
	}

	public void setClientIdGeneratorBean(ClientIdGeneratorBean clientIdGeneratorBean) {
		this.clientIdGeneratorBean = clientIdGeneratorBean;
	}

	
	
	
}
