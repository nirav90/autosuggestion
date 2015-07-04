package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;


import assys.com.dbBean.SentMailMasterBean;



/**
 * @author Slesha
 *
 */

public class SentMailMaster {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	InetAddress ip;
	String flag="false";
	public String insert(SentMailMasterBean sntMailMstBean)
	{
		SentMailMasterBean sentMailMstBean=(SentMailMasterBean) sntMailMstBean;
		String empUserId=sentMailMstBean.getEmpUserId();
		String sentId=sentMailMstBean.getSentId();
		String senderEmailId=sentMailMstBean.getSenderEmailId();
		String reciptanceEmailId=sentMailMstBean.getReciptanceEmailId();
		String emailSubject=sentMailMstBean.getEmailSubject();
		String emailBody=sentMailMstBean.getEmailBody();
		
		Date emailSentDateTime=sentMailMstBean.getEmailSentDateTime();
		

		try{
			ip=InetAddress.getLocalHost();

			String str1 ="insert into sent_mail_master(sent_id,emp_user_id";
			String value1=" values('"+sentId+"','"+empUserId+"',";
			
			if(senderEmailId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",sender_email_id";
				value1+="'"+senderEmailId+"',";
				System.out.println("line 2 if " );
			}
			
			if(reciptanceEmailId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",reciptance_email_id";
				value1+="'"+reciptanceEmailId+"',";
				System.out.println("line 2 if " );
			}
			
			if(emailSubject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",email_subject";
				value1+="'"+emailSubject+"',";
				System.out.println("line 2 if " );
			}
			
			if(emailBody==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",email_body";
				value1+="'"+emailBody+"',";
				System.out.println("line 2 if " );
			}
			/*
			if(emailSentDateTime==null)
			{
					
			}else{*/
				System.out.println("line 1 if");
				str1+=",email_sent_date_time";
				value1+="'"+dateFormat.format(date)+"',";
				System.out.println("line 2 if " );
		/*	}*/
			
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
	
	public String delete(SentMailMasterBean sntMailMstBean)
	{
		SentMailMasterBean sentMailMstBean=(SentMailMasterBean) sntMailMstBean;
		String empUserId=sentMailMstBean.getEmpUserId();
		String sentId=sentMailMstBean.getSentId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update sent_mail_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND sent_id='"+sentId+"'";
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
		String selectAllQuery="select * from sent_mail_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(SentMailMasterBean sntMailMstBean)
	{
		SentMailMasterBean sentMailMstBean=(SentMailMasterBean) sntMailMstBean;
		String empUserId=sentMailMstBean.getEmpUserId();
		String sentId=sentMailMstBean.getSentId();
		String senderEmailId=sentMailMstBean.getSenderEmailId();
		String reciptanceEmailId=sentMailMstBean.getReciptanceEmailId();
		String emailSubject=sentMailMstBean.getEmailSubject();
		String emailBody=sentMailMstBean.getEmailBody();
		
		Date emailSentDateTime=sentMailMstBean.getEmailSentDateTime();

		String selectQuery="select * from sent_mail_master where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(sentId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND sent_id='"+sentId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(senderEmailId==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND sender_email_id='"+senderEmailId+"'";
			System.out.println("line 4 if");
		}
		if(reciptanceEmailId==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND reciptance_email_id='"+reciptanceEmailId+"'";
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
		if(emailBody==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_body='"+emailBody+"'";
			System.out.println("line 4 if");
		}
		if(emailSentDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND email_sent_date_time='"+emailSentDateTime+"'";
			System.out.println("line 4 if");
		}
		selectQuery+=" AND isDeleted=0 ORDER BY email_sent_date_time DESC;;";
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
