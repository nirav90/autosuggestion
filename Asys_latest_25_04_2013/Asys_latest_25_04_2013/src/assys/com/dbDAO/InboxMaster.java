package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;
//import assys.com.dbBean.Assign_work_master_bean;
import assys.com.dbBean.InboxMasterBean;

public class InboxMaster {
	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(InboxMasterBean inbBean)
	{
		
		InboxMasterBean inboxBean=(InboxMasterBean) inbBean;
		String empUserId=inboxBean.getEmpUserId();
		String senderEmailId=inboxBean.getSenderEmailId();
		String receiverEmailId=inboxBean.getReceiverEmailId();
		String emailSubject=inboxBean.getEmailSubject();
		int mailNo = inboxBean.getMailNo();
		Date emailSendDateTime=inboxBean.getEmailSendDateTime();
		//Date work_msg_sending_date_time=assignBean.getWork_msg_sending_date_time();
		

		try{
			ip=InetAddress.getLocalHost();
			String str1 ="insert into inbox_master(emp_user_id";
			String value1="values ('"+empUserId+"',";
				if(senderEmailId==null)
				{	}
				else{
					System.out.println("line 1 if");
					str1+=",sender_email_id";
					value1+="'"+senderEmailId+"',";
					System.out.println("line 2 if " );
				}
				
				if(receiverEmailId==null)	
				{   }
				else{
					System.out.println("line 3 if");
					str1+=",receiver_email_id";
					value1+="'"+receiverEmailId+"',";
					System.out.println("line 4 if");
				}
				
				if(emailSubject==null)
				{   }
				else{
					System.out.println("line 3 if");
					str1+=",email_subject";
					value1+="'"+emailSubject+"',";
					System.out.println("line 4 if");
				}
				if(emailSendDateTime==null)
				{	}
				else{
					System.out.println("line 3 if");
					str1+=",email_send_date_time";
					value1+="'"+dateFormat.format(emailSendDateTime)+"',";
					System.out.println("line 4 if");
				}
				if(mailNo==0)
				{	}
				else{
					System.out.println("line 3 if");
					str1+=",mail_no";
					value1+="'"+mailNo+"',";
					System.out.println("line 4 if");
				}
				str1+=",ip,isDeleted,createdDate,modifyDate) ";
				value1+="'"+ ip.getHostAddress() +"',0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
				String insertQuery=str1+value1+";";
				int lineInserted=executeQueries(insertQuery);
				System.out.println("line affected"+lineInserted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		
		return flag;
	}
	
	public String delete(InboxMasterBean inbBean)
	{
		
		InboxMasterBean inboxBean=(InboxMasterBean) inbBean;
		String empUserId=inboxBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update inbox_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"';";
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
		String selectAllQuery="select * from inbox_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(InboxMasterBean inbBean)
	{
		
		InboxMasterBean inboxBean=(InboxMasterBean) inbBean;
		String empUserId=inboxBean.getEmpUserId();
		String senderEmailId=inboxBean.getSenderEmailId();
		String receiverEmailId=inboxBean.getReceiverEmailId();
		String emailSubject=inboxBean.getEmailSubject();
		int mailNo = inboxBean.getMailNo();
		
		Date emailSendDateTime=inboxBean.getEmailSendDateTime();
		
		String selectQuery="select * from inbox_master where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(senderEmailId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND sender_email_id='"+senderEmailId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(receiverEmailId==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND receiver_email_id='"+receiverEmailId+"'";
			System.out.println("line 4 if");
		}
		if(emailSubject==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_subject='"+emailSubject+"'";
			System.out.println("line 4 if");
		}		
		if(emailSendDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_send_date_time='"+emailSendDateTime+"'";
			System.out.println("line 4 if");
		}
		if(mailNo==0)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND mail_no='"+mailNo+"'";
			System.out.println("line 4 if");
		}
		
		selectQuery+=" AND isDeleted=0 ORDER BY email_send_date_time DESC;";
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
