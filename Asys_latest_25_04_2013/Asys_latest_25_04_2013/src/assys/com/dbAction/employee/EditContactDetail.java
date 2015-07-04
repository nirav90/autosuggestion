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

public class EditContactDetail {
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	ContactDetailMasterBean contactDetailMasterBean = new ContactDetailMasterBean();
	ContactDetailMaster  contactDetailMaster = new ContactDetailMaster();
	
	ContactEmailDetailBean contactEmailDetailBean = new ContactEmailDetailBean();
	ContactEmailDetail contactEmailDetail = new ContactEmailDetail();
	
	
	ContactPhoneNoDetailBean contactPhoneNoDetailBean = new ContactPhoneNoDetailBean();
	ContactPhoneNoDetail contactPhoneNoDetail = new ContactPhoneNoDetail();
	
	
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
	
	
	
	public String execute()
	{
		String result="success";
		String contactId=contactDetailMasterBean.getContactId();
		contactEmailDetailBean.setContactId(contactId);
		contactPhoneNoDetailBean.setContactId(contactId);
		HttpSession session = ServletActionContext.getRequest().getSession();
		
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
				/*Date datetyep=(Date) emp_detail_bean.getBirthdate();
				emp_detail_bean.setBirthdate(datetyep);*/
				contactDetailMaster.update(contactDetailMasterBean);
				contactEmailDetail.update(contactEmailDetailBean);
				contactPhoneNoDetail.update(contactPhoneNoDetailBean);
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("contactId1", contactId);
				if(empCategory.equals("Employee")){
					result="employee";
				}
				else if(empCategory.equals("Project Manager")){
					result="pmanager";
				}
				else if(empCategory.equals("Admin")){
					result="admin";
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
