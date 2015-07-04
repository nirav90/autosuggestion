package assys.com.dbAction.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.EmpUserIdGenerator;

public class ChangePassword {
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	AuthenticationDetail authDetDAO = new AuthenticationDetail();
	AuthenticationDetailBean authBean = new AuthenticationDetailBean();
	
	
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
	 * @return the authBean
	 */
	public AuthenticationDetailBean getAuthBean() {
		return authBean;
	}
	/**
	 * @param authBean the authBean to set
	 */
	public void setAuthBean(AuthenticationDetailBean authBean) {
		this.authBean = authBean;
	}
	
	public String execute()
	{
		String result="success";
		String password=authBean.getPassword();
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
				authBean.setEmpUserId(sd);
				authDetDAO.update(authBean);
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
			//e.printStackTrace();
			
			
		}
		return result;
	}
}
