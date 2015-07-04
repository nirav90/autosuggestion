package assys.com.dbAction.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.SmsAuthenticationBean;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.SmsAuthentication;

public class SMSChangeNumber {
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	SmsAuthenticationBean smsAuthBean=new SmsAuthenticationBean();
	SmsAuthentication smsDAO=new SmsAuthentication();
	
	
	
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



	/**
	 * @return the smsAuthBean
	 */
	public SmsAuthenticationBean getSmsAuthBean() {
		return smsAuthBean;
	}



	/**
	 * @param smsAuthBean the smsAuthBean to set
	 */
	public void setSmsAuthBean(SmsAuthenticationBean smsAuthBean) {
		this.smsAuthBean = smsAuthBean;
	}



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
				smsAuthBean.setEmpUserId(sd);
				smsDAO.update(smsAuthBean);
				if(empCategory.equals("Employee")){
					result="employee";
				}
				else if(empCategory.equals("Project Manager")){
					result="pmanager";
				}
				request.setAttribute("success", "success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
