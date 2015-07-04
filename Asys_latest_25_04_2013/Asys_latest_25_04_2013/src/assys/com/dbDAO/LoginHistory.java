package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import assys.com.DAO.DBConnection;

import assys.com.dbBean.LoginHistoryBean;



/**
 * @author Slesha
 *
 */

public class LoginHistory {

	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";

	InetAddress ip;
	Random rnd=new Random();
	
	
	
	public String insert(LoginHistoryBean lgnHisBean)
	{
		LoginHistoryBean lgnHistBean=(LoginHistoryBean) lgnHisBean;
		int login_ids=rnd.nextInt(Integer.MAX_VALUE)+1;
		String loginId="lgn"+login_ids;
		String userName=lgnHistBean.getUserName();
		//Date loginDateTime=lgnHistBean.getLoginDateTime();
		
		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into login_history(login_id";
			String value1=" values('"+loginId+"',";
			
			if(userName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",user_name";
				value1+="'"+userName+"',";
				System.out.println("line 2 if " );
			}
			/*
			if(loginDateTime==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",login_date_time";
				value1+="'"+dateFormat.format(loginDateTime)+"',";
				System.out.println("line 2 if " );
			}*/
			str1+=",login_date_time,ip,isDeleted,createdDate)";
			value1+="'"+dateFormat.format(date)+"','"+ ip.getHostAddress() +"',0,'"+ dateFormat.format(date) +"');";
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
	
	public String delete(LoginHistoryBean lgnHisBean)
	{
		LoginHistoryBean lgnHistBean=(LoginHistoryBean) lgnHisBean;
		String loginId=lgnHistBean.getLoginId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update login_history set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where login_id='"+loginId+"'";
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
		String selectAllQuery="select * from login_history;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(LoginHistoryBean lgnHisBean)
	{
		LoginHistoryBean lgnHistBean=(LoginHistoryBean) lgnHisBean;
		String loginId=lgnHistBean.getLoginId();
		String userName=lgnHistBean.getUserName();
		Date loginDateTime=lgnHistBean.getLoginDateTime();

		String selectQuery="select * from login_history where 1";
		if(loginId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND login_id='"+loginId+"'";
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
		if(loginDateTime==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND login_date_time='"+loginDateTime+"'";
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
