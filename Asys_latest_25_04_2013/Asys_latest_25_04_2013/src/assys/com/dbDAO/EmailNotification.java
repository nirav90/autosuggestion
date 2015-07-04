package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;


import assys.com.dbBean.EmailNotificationBean;



/**
 * @author Slesha
 *
 */

public class EmailNotification {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(EmailNotificationBean emailNtfBean)
	{
		EmailNotificationBean emailNtfcBean=(EmailNotificationBean) emailNtfBean;
		String empUserId=emailNtfcBean.getEmpUserId();
		String emailNotificationId=emailNtfcBean.getEmailNotificationId();
		String emailNotificationMessage=emailNtfcBean.getEmailNotificationMessage();
		Date emailNotificationDateTime=emailNtfcBean.getEmailNotificationDateTime();
		String emailNfcSenderId=emailNtfcBean.getEmailNfcSenderId();
		String emailNfcReceiverId=emailNtfcBean.getEmailNfcReceiverId();
		String emailNfcSubject=emailNtfcBean.getEmailNfcSubject();
		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into email_notification(email_notification_id,emp_user_id";
			String value1=" values('"+emailNotificationId+"','"+empUserId+"',";
			
			if(emailNotificationMessage==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",email_notification_message";
				value1+="'"+emailNotificationMessage+"',";
				System.out.println("line 2 if " );
			}
			
			/*if(emailNotificationDateTime==null)
			{
					
			}else{*/
				System.out.println("line 1 if");
				str1+=",email_notification_date_time";
				value1+="'"+dateFormat.format(date)+"',";
				System.out.println("line 2 if " );
			/*}*/
			
			if(emailNfcSenderId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",email_nfc_sender_id";
				value1+="'"+emailNfcSenderId+"',";
				System.out.println("line 2 if " );
			}
			
			if(emailNfcReceiverId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",email_nfc_receiver_id";
				value1+="'"+emailNfcReceiverId+"',";
				System.out.println("line 2 if " );
			}
			
			if(emailNfcSubject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",email_nfc_subject";
				value1+="'"+emailNfcSubject+"',";
				System.out.println("line 2 if " );
			}
			
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
	
	public String delete(EmailNotificationBean emailNtfBean)
	{
		EmailNotificationBean emailNtfcBean=(EmailNotificationBean) emailNtfBean;
		String empUserId=emailNtfcBean.getEmpUserId();
		String emailNotificationId=emailNtfcBean.getEmailNotificationId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update email_notification set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND email_notification_id='"+emailNotificationId+"'";
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
		String selectAllQuery="select * from email_notification;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(EmailNotificationBean emailNtfBean)
	{
		EmailNotificationBean emailNtfcBean=(EmailNotificationBean) emailNtfBean;
		String empUserId=emailNtfcBean.getEmpUserId();
		String emailNotificationId=emailNtfcBean.getEmailNotificationId();
		String emailNotificationMessage=emailNtfcBean.getEmailNotificationMessage();
		Date emailNotificationDateTime=emailNtfcBean.getEmailNotificationDateTime();
		String emailNfcSenderId=emailNtfcBean.getEmailNfcSenderId();
		String emailNfcReceiverId=emailNtfcBean.getEmailNfcReceiverId();
		String emailNfcSubject=emailNtfcBean.getEmailNfcSubject();
		
		String selectQuery="select * from email_notification where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(emailNotificationMessage==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND email_notification_message='"+emailNotificationMessage+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(emailNotificationId==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND email_notification_id='"+emailNotificationId+"'";
			System.out.println("line 4 if");
		}
		if(emailNotificationDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_notification_date_time='"+emailNotificationDateTime+"'";
			System.out.println("line 4 if");
		}
		if(emailNfcSenderId==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_nfc_sender_id='"+emailNfcSenderId+"'";
			System.out.println("line 4 if");
		}
		if(emailNfcReceiverId==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_nfc_receiver_id='"+emailNfcReceiverId+"'";
			System.out.println("line 4 if");
		}
		if(emailNfcSubject==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_nfc_subject='"+emailNfcSubject+"'";
			System.out.println("line 4 if");
		}
		
		
		selectQuery+=" AND isDeleted=0 ORDER BY email_notification_date_time DESC;";
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
