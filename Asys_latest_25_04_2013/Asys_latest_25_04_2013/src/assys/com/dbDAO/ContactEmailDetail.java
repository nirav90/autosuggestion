package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;

import assys.com.dbBean.ContactEmailDetailBean;



/**
 * @author Slesha
 *
 */

public class ContactEmailDetail {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(ContactEmailDetailBean cntMailDetBean)
	{
		ContactEmailDetailBean cntMailBean=(ContactEmailDetailBean) cntMailDetBean;
		String empUserId=cntMailBean.getEmpUserId();
		String contactId=cntMailBean.getContactId();
		String contactEmailId=cntMailBean.getContactEmailId();
		
		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into contact_email_detail(contact_id,emp_user_id";
			String value1=" values('"+contactId+"','"+empUserId+"',";
			
			if(contactEmailId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",contact_email_id";
				value1+="'"+contactEmailId+"',";
				System.out.println("line 2 if " );
			}
			
			str1+=",ip,isDeleted,isPublished,createdDate,modifyDate)";
			value1+="'"+ ip.getHostAddress() +"',0,0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
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
	
	public String delete(ContactEmailDetailBean cntMailDetBean)
	{
		ContactEmailDetailBean cntMailBean=(ContactEmailDetailBean) cntMailDetBean;
		String empUserId=cntMailBean.getEmpUserId();
		String contactId=cntMailBean.getContactId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update contact_email_detail set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where contact_id='"+contactId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}

	public String update(ContactEmailDetailBean cntMailDetBean)
	{
		ContactEmailDetailBean cntMailBean=(ContactEmailDetailBean) cntMailDetBean;
		String empUserId=cntMailBean.getEmpUserId();
		String contactId=cntMailBean.getContactId();
		String contactEmailId=cntMailBean.getContactEmailId();
		
		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery ="update contact_email_detail set ";
			
			if(contactEmailId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="contact_email_id='"+contactEmailId+"',";
				System.out.println("line 2 if " );
			}
			
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where contact_id='"+contactId+"' AND emp_user_id='"+empUserId+"'";
			int lineInserted=executeQueries(updateQuery);
			System.out.println("line affected"+lineInserted);
			
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		return flag;
	}
	
	
	public ResultSet selectAll()
	{		
		String selectAllQuery="select * from contact_email_detail;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(ContactEmailDetailBean cntMailDetBean)
	{
		ContactEmailDetailBean cntMailBean=(ContactEmailDetailBean) cntMailDetBean;
		String empUserId=cntMailBean.getEmpUserId();
		String contactId=cntMailBean.getContactId();
		String contactEmailId=cntMailBean.getContactEmailId();
		
		String selectQuery="select * from contact_email_detail where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(contactId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND contact_id='"+contactId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(contactEmailId==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND contact_email_id='"+contactEmailId+"'";
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
