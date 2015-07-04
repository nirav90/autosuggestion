package assys.com.dbAction.employee;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

//import assys.com.dbBean.Authentication_detail_bean;
import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.LeaveMasterBean;
//import assys.com.dbDAO.Authentication_detail;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.LeaveMaster;
import assys.com.gmail.gmail;


public class emergencyLeave {
	
	
	LeaveMasterBean leaveMasterBean = new LeaveMasterBean();
	LeaveMaster leaveMaster = new LeaveMaster();
	
	
	
	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
	GmailAuthentication gmailAuthentication = new GmailAuthentication();
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	
	
	Calendar calender = Calendar.getInstance();
	
	
	public String result;
	
	public String execute() throws SQLException, IOException, ParseException

	{
		
		
		 System.out.println("Year : " 

		+ calender.get(Calendar.YEAR));
		  System.out.println("Month  : " 

		+ calender.get(Calendar.MONTH));
		  System.out.println("Day of Month  : " 

		+ calender.get(Calendar.DAY_OF_MONTH));
		  System.out.println("Day of Week  : " 

		+ calender.get(Calendar.DAY_OF_WEEK));
		  System.out.println("Day of Year  : " 

		+ calender.get(Calendar.DAY_OF_YEAR));
		  System.out.println("Week of Year  : " 

		+ calender.get(Calendar.WEEK_OF_YEAR));
		  System.out.println("Week of Month  : " 

		+ calender.get(Calendar.WEEK_OF_MONTH));
		  System.out.println
		   ("Day of the Week in Month : " 

		+ calender.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		  System.out.println("Hour  	 : " + calender.get(Calendar.HOUR));
		  System.out.println("AM PM : " + calender.get(Calendar.AM_PM));
		  System.out.println("Hour of the Day : " + calender.get(Calendar.HOUR_OF_DAY));
		  System.out.println("Minute : " + calender.get(Calendar.MINUTE));
		  System.out.println("Second  : " + calender.get(Calendar.SECOND));
		  System.out.println();
		
		
		
		
		
		
		
		
		
		String userName = null;
		String password= null;
		 
		 
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date dd = sdf.parse(leaveMasterBean.getLeaveFromDate());
		Date dd1 = sdf.parse(leaveMasterBean.getLeaveToDate());
		sdf.applyPattern("yyyy-MM-dd");
		String LeaveFromDate = sdf.format(dd);
		String LeaveToDate = sdf.format(dd1);
		leaveMasterBean.setLeaveFromDate(LeaveFromDate);
		leaveMasterBean.setLeaveToDate(LeaveToDate);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
				
		leaveMasterBean.setEmpUserId(sd);
		
		gmailAuthenticationBean.setEmpUserId(sd);

		ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
		
		while(rs.next())
		{
			
			userName = rs.getString(3);
			password = rs.getString(4);
			System.out.println(userName);
			System.out.println(password);
			
		}	
		System.out.println("leave master reciptance id"+leaveMasterBean.getReciptanceEmailId());
		System.out.println("From date of leave master"+leaveMasterBean.getLeaveFromDate());
		System.out.println("leave date of leave master"+leaveMasterBean.getLeaveToDate());
		
		empUserIdBean.setEmpUserId(sd);
		empUserIdBean.setEmpIdUsed(true);
		ResultSet rs1=empUserIdGen.select(empUserIdBean);
		String empCategory = null;
		while(rs1.next()){
			empCategory=rs1.getString("emp_category");
		}
		/*leaveMasterBean.setLeaveSubject("Emergency Leave");*/
		if(empCategory.equals("Employee")){
			result="employee";
		}
		else if(empCategory.equals("Project Manager")){
			result="pmanager";
		}
		String s = leaveMasterBean.getLeaveSubject();
		if(s.equals("Emergency Leave"))
		{	
		
			
			/*SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.S");
			Date dd = sdf.parse(d);
			sdf.applyPattern("yyyy-MM-ddHH:mm");
			createdDate12 = sdf.format(dd);*/
			
			
			
			
			
			leaveMasterBean.setSenderEmailId(userName);
			leaveMaster.insert(leaveMasterBean);
		
			gmail  g = new gmail();
			g.setAccountDetails(userName, password);
		
		
		
		
			System.out.println("authentication done");
			System.out.println(userName);
			System.out.println(leaveMasterBean.getReciptanceEmailId());
			System.out.println(leaveMasterBean.getLeaveBody());
		
			g.sendGmail(userName, leaveMasterBean.getReciptanceEmailId(),"Emergency Leave",leaveMasterBean.getLeaveBody());
		
			return result;
		}
		else
		{
			
			leaveMasterBean.setSenderEmailId(userName);
			leaveMaster.insert(leaveMasterBean);
		
			gmail  g = new gmail();
			g.setAccountDetails(userName, password);
		
		
		
		
			System.out.println("authentication done");
			System.out.println(userName);
			System.out.println(leaveMasterBean.getReciptanceEmailId());
			System.out.println(leaveMasterBean.getLeaveBody());
		
			g.sendGmail(userName, leaveMasterBean.getReciptanceEmailId(),"Multiday Leave",leaveMasterBean.getLeaveBody());
		
			return result;
			
		}	
		
	}




	public LeaveMasterBean getLeaveMasterBean() {
		return leaveMasterBean;
	}




	public void setLeaveMasterBean(LeaveMasterBean leaveMasterBean) {
		this.leaveMasterBean = leaveMasterBean;
	}




	public LeaveMaster getLeaveMaster() {
		return leaveMaster;
	}




	public void setLeaveMaster(LeaveMaster leaveMaster) {
		this.leaveMaster = leaveMaster;
	}




	public GmailAuthenticationBean getGmailAuthenticationBean() {
		return gmailAuthenticationBean;
	}




	public void setGmailAuthenticationBean(
			GmailAuthenticationBean gmailAuthenticationBean) {
		this.gmailAuthenticationBean = gmailAuthenticationBean;
	}




	public GmailAuthentication getGmailAuthentication() {
		return gmailAuthentication;
	}




	public void setGmailAuthentication(GmailAuthentication gmailAuthentication) {
		this.gmailAuthentication = gmailAuthentication;
	}





	
	

}
