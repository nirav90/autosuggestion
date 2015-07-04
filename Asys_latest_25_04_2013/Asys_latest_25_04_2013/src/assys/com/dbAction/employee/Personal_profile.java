package assys.com.dbAction.employee;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.EmpDetailBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbDAO.EmpDetail;
import assys.com.dbDAO.EmpUserIdGenerator;

public class Personal_profile {
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
			
	EmpDetailBean empDetailBean = new EmpDetailBean();
	EmpDetail empDetail = new EmpDetail();
		
			
			
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
						empDetailBean.setEmpUserId(sd);
						System.out.println(empDetailBean.getBirthdate());
						empDetail.update(empDetailBean);
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




			public EmpDetailBean getEmpDetailBean() {
				return empDetailBean;
			}




			public void setEmpDetailBean(EmpDetailBean empDetailBean) {
				this.empDetailBean = empDetailBean;
			}

			
			
			/**
			 * @return the session
			 */
		/*	public HttpSession getSession() {
				return session;
			}


			*//**
			 * @param session the session to set
			 *//*
			public void setSession(HttpSession session) {
				this.session = session;
			}*/
			
			
	

}
