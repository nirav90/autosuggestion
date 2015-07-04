package assys.com.dbAction.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.WorkProfileDetailBean;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.WorkProfileDetail;

public class Work_profile {
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	WorkProfileDetailBean workProfileDetailBean = new WorkProfileDetailBean();
	WorkProfileDetail workProfileDetail = new WorkProfileDetail(); 
  	
	public String execute()
	{
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
				workProfileDetailBean.setEmpUserId(sd);
				workProfileDetail.update(workProfileDetailBean);
				if(empCategory.equals("Employee")){
					result="employee";
				}
				else if(empCategory.equals("Project Manager")){
					result="pmanager";
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	  	  
	}
	
	public String add()
	{
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
				workProfileDetailBean.setEmpUserId(sd);
				workProfileDetail.insert(workProfileDetailBean);
				if(empCategory.equals("Employee")){
					result="employee";
				}
				else if(empCategory.equals("Project Manager")){
					result="pmanager";
				}

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

	/**
	 * @return the workProfileDetailBean
	 */
	public WorkProfileDetailBean getWorkProfileDetailBean() {
		return workProfileDetailBean;
	}

	/**
	 * @param workProfileDetailBean the workProfileDetailBean to set
	 */
	public void setWorkProfileDetailBean(WorkProfileDetailBean workProfileDetailBean) {
		this.workProfileDetailBean = workProfileDetailBean;
	}

}
