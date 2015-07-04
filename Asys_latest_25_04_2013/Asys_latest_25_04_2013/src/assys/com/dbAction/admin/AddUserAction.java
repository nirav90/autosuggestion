package assys.com.dbAction.admin;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import assys.com.dbBean.EmpUserIdGeneratorBean;
import assys.com.dbBean.GmailAuthenticationBean;
import assys.com.dbBean.SentMailMasterBean;
import assys.com.dbBean.SmsAuthenticationBean;
import assys.com.dbBean.SmsNotificationBean;
import assys.com.dbDAO.EmpUserIdGenerator;
import assys.com.dbDAO.GmailAuthentication;
import assys.com.dbDAO.SentMailMaster;
import assys.com.dbDAO.SmsAuthentication;
import assys.com.dbDAO.SmsNotification;
import assys.com.gmail.gmail;
import assys.com.sms.Way2Sms;

/**
 * @author slesha
 *
 */
public class AddUserAction {
	
	EmpUserIdGeneratorBean empUserIdBean=new EmpUserIdGeneratorBean();
	EmpUserIdGenerator empUserIdGen=new EmpUserIdGenerator();
	
	SmsAuthenticationBean smsAuthBean=new SmsAuthenticationBean();
	SmsAuthentication smsAuth=new SmsAuthentication();
	
	SmsNotificationBean smsNtfcBean=new SmsNotificationBean();
	SmsNotification smsNtfc=new SmsNotification();

	
	
	SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
	
	SentMailMaster sentMailMaster = new SentMailMaster();

	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();

	GmailAuthentication gmailAuthentication = new GmailAuthentication();

	gmail gmail = new gmail();
	
	String flag="false";
	String way2smsUserName;
	String way2smsPassword;
	Way2Sms way2Sms=new Way2Sms();
	String empCategoryId = null;
	String empUserId=null;
	//String empUserId=Session.get("empUserId");
	Random rnd=new Random();
	int empId=rnd.nextInt(Integer.MAX_VALUE)+1;
	String smsNotificationId="sms"+empId;
	String smsNotificationMessage="Your employee Id is:";
	
	
	public String add_user_success() throws IOException
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		String sd = (String)session.getAttribute("employee_ID");
		System.out.println("admin id"+sd);
		empUserId=sd;
		String empCategory=empUserIdBean.getEmpCategory();
		if(empCategory.equals("Client"))
		{
			empCategoryId="cln" + empId;
			
		}
		else if(empCategory.equals("Employee"))
		{
			empCategoryId="emp" + empId;
			
		}
		else if(empCategory.equals("Project Manager"))
		{
			empCategoryId="pmng" + empId;
			
		}
		
		try {
			empUserIdBean.setEmpUserId(empCategoryId);
			System.out.println("in login_success");
			flag=empUserIdGen.insert(empUserIdBean);
			gmailAuthenticationBean.setEmpUserId(empUserId);
			ResultSet rs1=gmailAuthentication.select(gmailAuthenticationBean);
			
			while(rs1.next()){
				sentMailMasterBean.setSenderEmailId(rs1.getString(3));
				String userName =rs1.getString(3);
				String password = rs1.getString(4);
				gmail.setAccountDetails(userName, password);
			}
			int sntId=rnd.nextInt(Integer.MAX_VALUE)+1;
			String sentId="snt"+sntId;
			sentMailMasterBean.setSentId(sentId);
			String msgBody="Your Employee ID is:"+empUserIdBean.getEmpUserId()+".  Please Register using this ID..";
			
			String msgsubject="Register Detail of Employee ID";
			sentMailMasterBean.setEmailBody(msgBody);
			sentMailMasterBean.setEmailSubject(msgsubject);
			sentMailMasterBean.setEmailSubject(msgsubject.replace("'", "\\'"));
			sentMailMasterBean.setEmailBody(msgBody.replace("'", "\\'"));
			sentMailMaster.insert(sentMailMasterBean);
			gmail.sendGmail(sentMailMasterBean.getSenderEmailId(), sentMailMasterBean.getReciptanceEmailId(), sentMailMasterBean.getEmailSubject(), sentMailMasterBean.getEmailBody());
			
			/*smsAuthBean.setUserName("Admin");
			smsAuthBean.setEmpUserId(empUserId);
			ResultSet rs=smsAuth.select(smsAuthBean);
			smsNotificationMessage=smsNotificationMessage+empCategoryId;
			String phone=smsNtfcBean.getPhoneNo();
			System.out.println(phone);
			//String phone="8905221921";
			while(rs.next())
			{
				way2smsUserName=rs.getString("way2sms_user_name");
				System.out.println(way2smsUserName);
				way2smsPassword=rs.getString("way2sms_password");
				System.out.println(way2smsPassword);
				way2Sms.test("site",phone,smsNotificationMessage,way2smsUserName,way2smsPassword);
			}
			smsNtfcBean.setEmpUserId(empUserId);
			smsNtfcBean.setSmsNotificationId(smsNotificationId);
			smsNtfcBean.setSmsNotificationMessage(smsNotificationMessage);
			smsNtfc.insert(smsNtfcBean);*/
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
		
	}
	
	
	
	
	/**
	 * @return the smsNtfcBean
	 */
	public SmsNotificationBean getSmsNtfcBean() {
		return smsNtfcBean;
	}

	/**
	 * @param smsNtfcBean the smsNtfcBean to set
	 */
	public void setSmsNtfcBean(SmsNotificationBean smsNtfcBean) {
		this.smsNtfcBean = smsNtfcBean;
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
}
