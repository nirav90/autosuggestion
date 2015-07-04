package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;

import assys.com.dbBean.GmailAuthenticationBean;



/**
 * @author Slesha
 *
 */

public class GmailAuthentication {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(GmailAuthenticationBean mailAuthBean)
	{
		GmailAuthenticationBean gmailAuthBean=(GmailAuthenticationBean) mailAuthBean;
		String empUserId=gmailAuthBean.getEmpUserId();
		String userName=gmailAuthBean.getUserName();
		String gmailEmailId=gmailAuthBean.getGmailEmailId();
		String gmailPassword=gmailAuthBean.getGmailPassword();
		

		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into gmail_authentication(emp_user_id";
			String value1=" values('"+empUserId+"',";
			
			if(userName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",user_name";
				value1+="'"+userName+"',";
				System.out.println("line 2 if " );
			}
			
			if(gmailEmailId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",gmail_email_id";
				value1+="'"+gmailEmailId+"',";
				System.out.println("line 2 if " );
			}
			
			if(gmailPassword==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",gmail_password";
				value1+="'"+gmailPassword+"',";
				System.out.println("line 2 if " );
			}
			str1+=",ip,isDeleted,createdDate,modifyDate)";
			value1+="'"+ ip.getHostAddress() +"',0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
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
	
	public String delete(GmailAuthenticationBean mailAuthBean)
	{
		GmailAuthenticationBean gmailAuthBean=(GmailAuthenticationBean) mailAuthBean;
		String empUserId=gmailAuthBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update gmail_authentication set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String update(GmailAuthenticationBean mailAuthBean)
	{
		GmailAuthenticationBean gmailAuthBean=(GmailAuthenticationBean) mailAuthBean;
		String empUserId=gmailAuthBean.getEmpUserId();
		String userName=gmailAuthBean.getUserName();
		String gmailEmailId=gmailAuthBean.getGmailEmailId();
		String gmailPassword=gmailAuthBean.getGmailPassword();
		

		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery ="update gmail_authentication set ";
			
			if(userName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="user_name='"+userName+"',";
				System.out.println("line 2 if " );
			}
			
			if(gmailEmailId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="gmail_email_id='"+gmailEmailId+"',";
				System.out.println("line 2 if " );
			}
			
			if(gmailPassword==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="gmail_password='"+gmailPassword+"',";
				System.out.println("line 2 if " );
			}
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where emp_user_id='"+empUserId+"'";
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
		String selectAllQuery="select * from gmail_authentication;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(GmailAuthenticationBean mailAuthBean)
	{
		GmailAuthenticationBean gmailAuthBean=(GmailAuthenticationBean) mailAuthBean;
		String empUserId=gmailAuthBean.getEmpUserId();
		String userName=gmailAuthBean.getUserName();
		String gmailEmailId=gmailAuthBean.getGmailEmailId();
		String gmailPassword=gmailAuthBean.getGmailPassword();

		String selectQuery="select * from gmail_authentication where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(userName==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND user_name='"+userName+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(gmailEmailId==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND gmail_email_id='"+gmailEmailId+"'";
			System.out.println("line 4 if");
		}
		if(gmailPassword==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND gmail_password='"+gmailPassword+"'";
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