package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;


import assys.com.dbBean.SmsNotificationBean;


/**
 * @author Slesha
 *
 */

public class SmsNotification {
	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(SmsNotificationBean smsNtfBean)
	{
		SmsNotificationBean smsNtfcBean=(SmsNotificationBean) smsNtfBean;
		String empUserId=smsNtfcBean.getEmpUserId();
		String smsNotificationId=smsNtfcBean.getSmsNotificationId();
		String phoneNo=smsNtfcBean.getPhoneNo();
		String smsNotificationMessage=smsNtfcBean.getSmsNotificationMessage();
		Date smsNotificationDateTime=smsNtfcBean.getSmsNotificationDateTime();
		
		try{
			ip=InetAddress.getLocalHost();

			String str1 ="insert into sms_notification(sms_notification_id,emp_user_id";
			String value1=" values('"+smsNotificationId+"','"+empUserId+"',";
			
			if(phoneNo==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",phone_no";
				value1+="'"+phoneNo+"',";
				System.out.println("line 2 if " );
			}
			
			if(smsNotificationMessage==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",sms_notification_message";
				value1+="'"+smsNotificationMessage+"',";
				System.out.println("line 2 if " );
			}
			
			/*if(smsNotificationDateTime==null)
			{
					
			}else{*/
				System.out.println("line 1 if");
				str1+=",sms_notification_date_time";
				value1+="'"+dateFormat.format(date)+"',";
				System.out.println("line 2 if " );
			/*}*/
			
			str1+=",ip,isDeleted,isPublished,createdDate,modifyDate)";
			value1+="'"+ ip.getHostAddress() +"',0,0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
			String insertQuery=str1+value1;
			int lineInserted=executeQueries(insertQuery);
			System.out.println("line affected"+lineInserted);
			
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String delete(SmsNotificationBean smsNtfBean)
	{
		SmsNotificationBean smsNtfcBean=(SmsNotificationBean) smsNtfBean;
		String empUserId=smsNtfcBean.getEmpUserId();
		String smsNotificationId=smsNtfcBean.getSmsNotificationId();
		
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update sms_notification set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND sms_notification_id='"+smsNotificationId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	public ResultSet selectAll()
	{		
		String selectAllQuery="select * from sms_notification;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(SmsNotificationBean smsNtfBean)
	{
		SmsNotificationBean smsNtfcBean=(SmsNotificationBean) smsNtfBean;
		String empUserId=smsNtfcBean.getEmpUserId();
		String smsNotificationId=smsNtfcBean.getSmsNotificationId();
		String phoneNo=smsNtfcBean.getPhoneNo();
		String smsNotificationMessage=smsNtfcBean.getSmsNotificationMessage();
		Date smsNotificationDateTime=smsNtfcBean.getSmsNotificationDateTime();

		String selectQuery="select * from sms_notification where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(smsNotificationId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND sms_notification_id='"+smsNotificationId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(phoneNo==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND phone_no='"+phoneNo+"'";
			System.out.println("line 4 if");
		}
		if(smsNotificationMessage==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND sms_notification_message='"+smsNotificationMessage+"'";
			System.out.println("line 4 if");
		}		
		if(smsNotificationDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND sms_notification_date_time='"+smsNotificationDateTime+"'";
			System.out.println("line 4 if");
		}
		selectQuery+=" AND isDeleted=0;";
		rs=executeSelect(selectQuery);
		return rs;
	}

	
	public ResultSet executeSelect(String str)
	{
		try
		{
		 conn=con.getConnection();
		 System.out.println("line 1");
		 stm= (Statement) conn.createStatement();
		 System.out.println("line 1");
		 System.out.println(str);
		 rs =stm.executeQuery(str);
		 System.out.println("line affected succefully");
		 
		 /*while(rs.next())
		 {
			 String name= rs.getString(1);
			 String phone = rs.getString(2);
			 System.out.println(name+phone);
		 } */
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return rs;
	}
	
	public int executeQueries(String str)
	{
		int line=0;
		try
		{
			conn=con.getConnection();
			System.out.println("line 1");
			stm= (Statement) conn.createStatement();
			System.out.println("line 1");
			System.out.println(str);
			line =stm.executeUpdate(str);
			flag="true";
	 	}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return line;
	}
}
