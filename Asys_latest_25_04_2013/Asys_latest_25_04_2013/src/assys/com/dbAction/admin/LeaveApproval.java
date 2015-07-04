package assys.com.dbAction.admin;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import assys.com.dbBean.EmailNotificationBean;
import assys.com.dbBean.EmpDetailBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.LeaveCounterBean;
import assys.com.dbBean.LeaveMasterBean;
import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbDAO.EmailNotification;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.LeaveCounter;
import assys.com.dbDAO.LeaveMaster;
import assys.com.dbDAO.SentMailMaster;
import assys.com.gmail.gmail;

public class LeaveApproval {

	
	
	LeaveMasterBean leaveMasterBean = new LeaveMasterBean();
	LeaveMaster leaveMaster = new LeaveMaster();
	
	GmailAuthentication gmailAuthentication=new GmailAuthentication();
	GmailAuthenticationBean gmailAuthenticationBean=new GmailAuthenticationBean();
	
	SentMailMaster sentMailMaster=new SentMailMaster();
	SentMailMasterBean sentMailMasterBean=new SentMailMasterBean();
	
	EmailNotification emailNotification=new EmailNotification();
	EmailNotificationBean emailNotificationBean=new EmailNotificationBean();
	
	LeaveCounterBean leaveCounterBean=new LeaveCounterBean();
	LeaveCounter leaveCounter=new LeaveCounter();
	
	EmpDetailBean empDetailBean=new EmpDetailBean();
	
	gmail gmail = new gmail();
	
	
	
	
	
	public String execute() throws ParseException, SQLException, IOException
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		
		String flag = request.getParameter("submit");
		System.out.println(flag);
		if(flag.equals("Approve"))
		{	
			String leaveId=leaveMasterBean.getLeaveId();
			
			String fromDate=leaveMasterBean.getLeaveFromDate();
			String toDate=leaveMasterBean.getLeaveToDate();
			System.out.println(fromDate+toDate);
			
			/*
			 * Convert String into Date into formate yyyy-MM-dd
			 * */
			
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date fromDates=dateFormat.parse(fromDate);
			Date toDates=dateFormat.parse(toDate);
			
			/*
			 * Convert Date format into Calendar format
			 * */
			
			Calendar fromDateCalendar = new GregorianCalendar();
			Calendar toDateCalendar = new GregorianCalendar();
			fromDateCalendar.setTime(fromDates);
			toDateCalendar.setTime(toDates);
			
			/*
			 * Get Year, Month & Day from the toDate and fromDate
			 * */
			
			int fromDateYear=fromDateCalendar.get(Calendar.YEAR);
			int fromDateMonth=fromDateCalendar.get(Calendar.MONTH);
			int fromDateDay=fromDateCalendar.get(Calendar.DATE);
			
			int toDateYear=toDateCalendar.get(Calendar.YEAR);
			int toDateMonth=toDateCalendar.get(Calendar.MONTH);
			int toDateDay=toDateCalendar.get(Calendar.DATE);
			
			System.out.println("From Year"+fromDateYear+"To Year"+toDateYear);
			System.out.println("From Month"+(fromDateMonth+1)+"To MOnth"+(toDateMonth+1));
			System.out.println("From Day"+fromDateDay+"To Day"+toDateDay);
			
			/*
			 * Get a differance of two dates by year, month & day
			 * */
			
			int differanceYear=toDateYear-fromDateYear;
			int differanceMonth=toDateMonth-fromDateMonth;
			
			System.out.println("differances: "+differanceYear+" :"+differanceMonth);
			
			
			
			/*
			 * check whether two dates are of same month or year or not...
			 * */
			
			if(differanceYear!=0 || differanceMonth!=0){
				
				/*
				 * to set data for table leave counter
				 * */
				int fromMonthDay=fromDateCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				int differanceFromDay=fromMonthDay-fromDateDay;
				leaveCounting(differanceFromDay, fromDateMonth, fromDateYear);
				
				/*
				 * to set data for table leave counter
				 * */
				int diffrenceToDate=toDateDay-1;
				leaveCounting(diffrenceToDate, toDateMonth, toDateYear);
				sendingMailSetting("true",sd);
			}
			
			
			else{
				
				System.out.println("in same");
				int differanceDay=toDateDay-fromDateDay;
				
				/*
				 * to set data for table leave counter
				 * */
				
				leaveCounting(differanceDay, fromDateMonth, fromDateYear);
				sendingMailSetting("true",sd);
				
			}
		}
		else if(flag.equals("DisApprove")){
			leaveMasterBean.setLeaveApprove(false);
			leaveMaster.update(leaveMasterBean);
			sendingMailSetting("false",sd);
		}
			
			return "SUCCESS";
	}
	

	public void leaveCounting(int dateOfDay,int dateOfMonth,int dateOfYear) throws SQLException{
		
				leaveCounterBean.setEmpUserId(leaveMasterBean.getEmpUserId());
				//leaveCounterBean.setLeaveId(leaveMasterBean.getLeaveId());
				leaveCounterBean.setLeaveMonth((dateOfMonth+1));
				leaveCounterBean.setLeaveYear(dateOfYear);
				ResultSet rs2=leaveCounter.select(leaveCounterBean);
				int counter=0;
				if(rs2.next()){
					counter=rs2.getInt("leave_count");
					int leaveCounters=dateOfDay+counter;
					leaveCounterBean.setLeaveCount((leaveCounters+1));
					leaveCounter.update(leaveCounterBean);
				}
				else{
					leaveCounterBean.setLeaveCount((dateOfDay+1));
					leaveCounter.insert(leaveCounterBean);
				}
				/*
				 * update leave master table as approve leave
				 * */
				leaveMasterBean.setLeaveApprove(true);
				leaveMaster.update(leaveMasterBean);
	}


	public void sendingMailSetting(String leaveApproval,String sd) throws SQLException, IOException{
		
			/*
			 * to set data for email notification & sent mail master
			 * */
			
			
			//get sender's email id...
			gmailAuthenticationBean.setEmpUserId(sd);
			ResultSet rs=gmailAuthentication.select(gmailAuthenticationBean);
			String senderIds = null;
			while(rs.next()){
				senderIds=rs.getString("gmail_email_id");
				String userName =rs.getString(3);
				String password = rs.getString(4);
				System.out.println(password);
				gmail.setAccountDetails(userName, password);
			}
			
			//get receiver's email id...
			gmailAuthenticationBean.setEmpUserId(leaveMasterBean.getEmpUserId());
			ResultSet rs1=gmailAuthentication.select(gmailAuthenticationBean);
			String receiversIds = null;
			while(rs1.next()){
				receiversIds=rs1.getString("gmail_email_id");
			}
			
			//get send id and email notification id for recepective tables...
			Random rnd=new Random();
			int sntId=rnd.nextInt(Integer.MAX_VALUE)+1;
			String sentId="snt"+sntId;
			String emailNfcId="enfc"+sntId;
			
			//set email subject & body...			
			String msgSubject="Leave Notification Mail";
			String msgBody;
			if(leaveApproval.equals("true")){
				msgBody="Your Leave has been Approved. From Date: "+leaveMasterBean.getLeaveFromDate()+" To Date: "+leaveMasterBean.getLeaveToDate();
			}
			else{
				msgBody="Your Leave has been Disapproved.";
			}
			
			
			
			/*
			 * set data in sent mail master and insert in it...
			 * */
			
			sentMailMasterBean.setSentId(sentId);
			sentMailMasterBean.setEmpUserId(sd);
			sentMailMasterBean.setSenderEmailId(senderIds);
			sentMailMasterBean.setReciptanceEmailId(receiversIds);
			sentMailMasterBean.setEmailSubject(msgSubject);
			sentMailMasterBean.setEmailBody(msgBody);
			sentMailMaster.insert(sentMailMasterBean);
			
			/*
			 * set data in email notification and also insert in it
			 * */
			emailNotificationBean.setEmailNotificationId(emailNfcId);
			emailNotificationBean.setEmpUserId(sd);
			emailNotificationBean.setEmailNfcSenderId(senderIds);
			emailNotificationBean.setEmailNfcReceiverId(receiversIds);
			emailNotificationBean.setEmailNfcSubject(msgSubject);
			emailNotificationBean.setEmailNotificationMessage(msgBody);
			emailNotification.insert(emailNotificationBean);
			
			//send mail of notification to the employee
			gmail.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
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





	/**
	 * @return the gmailAuthenticationBean
	 */
	public GmailAuthenticationBean getGmailAuthenticationBean() {
		return gmailAuthenticationBean;
	}





	/**
	 * @param gmailAuthenticationBean the gmailAuthenticationBean to set
	 */
	public void setGmailAuthenticationBean(
			GmailAuthenticationBean gmailAuthenticationBean) {
		this.gmailAuthenticationBean = gmailAuthenticationBean;
	}





	/**
	 * @return the sentMailMasterBean
	 */
	public SentMailMasterBean getSentMailMasterBean() {
		return sentMailMasterBean;
	}





	/**
	 * @param sentMailMasterBean the sentMailMasterBean to set
	 */
	public void setSentMailMasterBean(SentMailMasterBean sentMailMasterBean) {
		this.sentMailMasterBean = sentMailMasterBean;
	}





	/**
	 * @return the emailNotificationBean
	 */
	public EmailNotificationBean getEmailNotificationBean() {
		return emailNotificationBean;
	}





	/**
	 * @param emailNotificationBean the emailNotificationBean to set
	 */
	public void setEmailNotificationBean(EmailNotificationBean emailNotificationBean) {
		this.emailNotificationBean = emailNotificationBean;
	}





	/**
	 * @return the empDetailBean
	 */
	public EmpDetailBean getEmpDetailBean() {
		return empDetailBean;
	}





	/**
	 * @param empDetailBean the empDetailBean to set
	 */
	public void setEmpDetailBean(EmpDetailBean empDetailBean) {
		this.empDetailBean = empDetailBean;
	}





	/**
	 * @return the leaveCounterBean
	 */
	public LeaveCounterBean getLeaveCounterBean() {
		return leaveCounterBean;
	}





	/**
	 * @param leaveCounterBean the leaveCounterBean to set
	 */
	public void setLeaveCounterBean(LeaveCounterBean leaveCounterBean) {
		this.leaveCounterBean = leaveCounterBean;
	}
	
	
	
	
}
