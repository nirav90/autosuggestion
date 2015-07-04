package assys.com.dbAction.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import assys.com.dbBean.ContactDetailMasterBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbDAO.EmpUserIdGenerator;

public class ContactDetail extends ActionSupport{
	



	ContactDetailMasterBean contactDetailMasterBean = new ContactDetailMasterBean();
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	public ContactDetailMasterBean getContactDetailMasterBean() {
		return contactDetailMasterBean;
	}

	public void setContactDetailMasterBean(
			ContactDetailMasterBean contactDetailMasterBean) {
		this.contactDetailMasterBean = contactDetailMasterBean;
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

	
	
	public String execute(){
	
		String result="success";
		HttpSession session = ServletActionContext.getRequest().getSession();
		
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
}
