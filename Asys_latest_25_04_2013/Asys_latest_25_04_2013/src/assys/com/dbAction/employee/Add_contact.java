package assys.com.dbAction.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.ContactDetailMasterBean;
import assys.com.dbBean.ContactEmailDetailBean;
import assys.com.dbBean.ContactPhoneNoDetailBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbDAO.ContactDetailMaster;
import assys.com.dbDAO.ContactEmailDetail;
import assys.com.dbDAO.ContactPhoneNoDetail;
import assys.com.dbDAO.EmpUserIdGenerator;

public class Add_contact {
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	ContactDetailMasterBean contactDetailMasterBean = new ContactDetailMasterBean();
	ContactDetailMaster  contactDetailMaster = new ContactDetailMaster();
	
	ContactEmailDetailBean contactEmailDetailBean = new ContactEmailDetailBean();
	ContactEmailDetail contactEmailDetail = new ContactEmailDetail();
	
	
	ContactPhoneNoDetailBean contactPhoneNoDetailBean = new ContactPhoneNoDetailBean();
	ContactPhoneNoDetail contactPhoneNoDetail = new ContactPhoneNoDetail();
	
	Random rnd=new Random();
	
	
	
	
	public String execute()
	{
		String result="success";
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		String sd = (String)session.getAttribute("employee_ID");
		empUserIdBean.setEmpUserId(sd);
		empUserIdBean.setEmpIdUsed(true);
		ResultSet rs=empUserIdGen.select(empUserIdBean);
		String empCategory;
		try {
			while(rs.next()){
				empCategory=rs.getString("emp_category");
			contactDetailMasterBean.setEmpUserId(sd);
			contactEmailDetailBean.setEmpUserId(sd);
			contactPhoneNoDetailBean.setEmpUserId(sd);
			
			int contact_ids=rnd.nextInt(Integer.MAX_VALUE)+1;
			String contactId ="cnt"+contact_ids;
			
			contactDetailMasterBean.setContactId(contactId);
			contactEmailDetailBean.setContactId(contactId);
			contactPhoneNoDetailBean.setContactId(contactId);
			
			
			contactDetailMaster.insert(contactDetailMasterBean);
			String emailId=contactEmailDetailBean.getContactEmailId();
			String phoneNo=contactPhoneNoDetailBean.getContactPhoneNo();
			String landLineNo=contactPhoneNoDetailBean.getContactLandLineNo();
			if(emailId=="")
			{}else{
				contactEmailDetail.insert(contactEmailDetailBean);
			}
			if(phoneNo=="" && landLineNo==""){}
			else{
				contactPhoneNoDetail.insert(contactPhoneNoDetailBean);
			}
				
			if(empCategory.equals("Employee")){
				result="employee";
			}
			else if(empCategory.equals("Project Manager")){
				result="pmanager";
			}
			else if(empCategory.equals("Admin")){
				result="admin";
			}
			request.setAttribute("success", "success");
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}



	



	/**
	 * @return the empUserIdBean
	 */
	public EmpUserIdGeneratorBean getEmpUserIdBean() {
		return empUserIdBean;
	}



	/**
	 * @param empUserIdBean the empUserIdBean to set
	 */
	public void setEmpUserIdBean(EmpUserIdGeneratorBean empUserIdBean) {
		this.empUserIdBean = empUserIdBean;
	}







	public ContactDetailMasterBean getContactDetailMasterBean() {
		return contactDetailMasterBean;
	}







	public void setContactDetailMasterBean(
			ContactDetailMasterBean contactDetailMasterBean) {
		this.contactDetailMasterBean = contactDetailMasterBean;
	}







	public ContactEmailDetailBean getContactEmailDetailBean() {
		return contactEmailDetailBean;
	}







	public void setContactEmailDetailBean(
			ContactEmailDetailBean contactEmailDetailBean) {
		this.contactEmailDetailBean = contactEmailDetailBean;
	}







	public ContactPhoneNoDetailBean getContactPhoneNoDetailBean() {
		return contactPhoneNoDetailBean;
	}







	public void setContactPhoneNoDetailBean(
			ContactPhoneNoDetailBean contactPhoneNoDetailBean) {
		this.contactPhoneNoDetailBean = contactPhoneNoDetailBean;
	}
	
	

}
