package assys.com.dbAction.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

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

public class Delete_contact {

	String flag="false";
	ContactDetailMaster contactDetailMaster=new ContactDetailMaster();
	ContactDetailMasterBean contactDetailMasterBean=new ContactDetailMasterBean();
	ContactEmailDetail contactEmailDetail=new ContactEmailDetail();
	ContactEmailDetailBean contactEmailDetailBean=new ContactEmailDetailBean();
	ContactPhoneNoDetail contactPhoneNoDetail=new ContactPhoneNoDetail();
	ContactPhoneNoDetailBean contactPhoneNoDetailBean=new ContactPhoneNoDetailBean();
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	public String execute(){
		
		
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
				String contactId=contactDetailMasterBean.getContactId();
				System.out.println(contactId);
				
				if(empCategory.equals("Employee")){
					flag="employee";
				}
				else if(empCategory.equals("Project Manager")){
					flag="pmanager";
				}
				else if(empCategory.equals("Admin")){
					flag="admin";
				}
				request.setAttribute("deleteSuccess", "deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contactEmailDetailBean.setContactId(contactDetailMasterBean.getContactId());
		contactPhoneNoDetailBean.setContactId(contactDetailMasterBean.getContactId());
		contactDetailMaster.delete(contactDetailMasterBean);
		contactEmailDetail.delete(contactEmailDetailBean);
		contactPhoneNoDetail.delete(contactPhoneNoDetailBean);
		
		return flag;
	}
	
	
	/**
	 * @return the contactEmailDetailBean
	 */
	public ContactEmailDetailBean getContactEmailDetailBean() {
		return contactEmailDetailBean;
	}

	/**
	 * @param contactEmailDetailBean the contactEmailDetailBean to set
	 */
	public void setContactEmailDetailBean(
			ContactEmailDetailBean contactEmailDetailBean) {
		this.contactEmailDetailBean = contactEmailDetailBean;
	}

	/**
	 * @return the contactPhoneNoDetailBean
	 */
	public ContactPhoneNoDetailBean getContactPhoneNoDetailBean() {
		return contactPhoneNoDetailBean;
	}

	/**
	 * @param contactPhoneNoDetailBean the contactPhoneNoDetailBean to set
	 */
	public void setContactPhoneNoDetailBean(
			ContactPhoneNoDetailBean contactPhoneNoDetailBean) {
		this.contactPhoneNoDetailBean = contactPhoneNoDetailBean;
	}


	/**
	 * @return the contactDetailMasterBean
	 */
	public ContactDetailMasterBean getContactDetailMasterBean() {
		return contactDetailMasterBean;
	}


	/**
	 * @param contactDetailMasterBean the contactDetailMasterBean to set
	 */
	public void setContactDetailMasterBean(
			ContactDetailMasterBean contactDetailMasterBean) {
		this.contactDetailMasterBean = contactDetailMasterBean;
	}
	
}
