package assys.com.dbAction.manager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.AuthenticationDetailBean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.SmsAuthenticationBean;
import assys.com.dbDAO.AuthenticationDetail;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.SmsAuthentication;

public class SMSRegisterNumber {
	

	

	
		EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
		EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
		
		SmsAuthenticationBean smsAuthBean=new SmsAuthenticationBean();
		SmsAuthentication smsDAO=new SmsAuthentication();
		
		AuthenticationDetail authenticationDetail=new AuthenticationDetail();
		AuthenticationDetailBean authenticationDetailBean=new AuthenticationDetailBean();
		
		
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



		public String execute() throws SQLException
		{
			String result="success";
			HttpSession session = ServletActionContext.getRequest().getSession();
			
			String sd = (String)session.getAttribute("employee_ID");
			empUserIdBean.setEmpUserId(sd);
			empUserIdBean.setEmpIdUsed(true);
			authenticationDetailBean.setEmpUserId(sd);
			ResultSet rs1=authenticationDetail.select(authenticationDetailBean);
			String userName=null;
			while(rs1.next()){
				userName=rs1.getString("user_name");
			}
			smsAuthBean.setUserName(userName);
			ResultSet rs=empUserIdGen.select(empUserIdBean);
			String empCategory;
			try {
				while(rs.next()){
					empCategory=rs.getString("emp_category");
					smsAuthBean.setEmpUserId(sd);
					smsDAO.insert(smsAuthBean);
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
		 * @return the authenticationDetailBean
		 */
		public AuthenticationDetailBean getAuthenticationDetailBean() {
			return authenticationDetailBean;
		}



		/**
		 * @param authenticationDetailBean the authenticationDetailBean to set
		 */
		public void setAuthenticationDetailBean(
				AuthenticationDetailBean authenticationDetailBean) {
			this.authenticationDetailBean = authenticationDetailBean;
		}
	}

