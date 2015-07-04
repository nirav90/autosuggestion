package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import assys.com.DAO.DBConnection;
import assys.com.dbBean.LeaveCounterBean;


public class LeaveCounter {
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
	InetAddress ip;
	String flag="false";
	
	public String insert(LeaveCounterBean levCntMstBean)
	{
		LeaveCounterBean leaveCounterBean=(LeaveCounterBean) levCntMstBean;
		String empUserId=leaveCounterBean.getEmpUserId();

		int leaveMonth=leaveCounterBean.getLeaveMonth();
		int leaveYear=leaveCounterBean.getLeaveYear();
		int leaveCount=leaveCounterBean.getLeaveCount();
		
		

		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into leave_counter(emp_user_id,leave_month,leave_year,leave_count";
			String value1=" values('"+empUserId+"','"+leaveMonth+"','"+leaveYear+"','"+leaveCount+"',";
			
					
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

	public String update(LeaveCounterBean levCntMstBean)
	{
		LeaveCounterBean leaveCounterBean=(LeaveCounterBean) levCntMstBean;
		
		String empUserId=leaveCounterBean.getEmpUserId();
		int leaveMonth=leaveCounterBean.getLeaveMonth();
		int leaveYear=leaveCounterBean.getLeaveYear();
		int leaveCount=leaveCounterBean.getLeaveCount();
		try{
			ip=InetAddress.getLocalHost();
			String updateQuery="update leave_counter set leave_count='"+leaveCount+"',ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where emp_user_id='"+empUserId+"' AND leave_month='"+leaveMonth+"' AND leave_year='"+leaveYear+"'";
			int lineUpdated=executeQueries(updateQuery);
			System.out.println("line affected"+lineUpdated);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String delete(LeaveCounterBean levCntMstBean)
	{
		LeaveCounterBean leaveCounterBean=(LeaveCounterBean) levCntMstBean;
		
		String empUserId=leaveCounterBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update leave_counter set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"'";
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
		String selectAllQuery="select * from leave_counter;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}
	
	public ResultSet select(LeaveCounterBean levCntMstBean)
	{
		LeaveCounterBean leaveCounterBean=(LeaveCounterBean) levCntMstBean;
		String empUserId=leaveCounterBean.getEmpUserId();
		
		int leaveMonth=leaveCounterBean.getLeaveMonth();
		int leaveYear=leaveCounterBean.getLeaveYear();
		//int leaveCount=leaveCounterBean.getLeaveCount();
		

		String selectQuery="select * from leave_counter where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		
		if(leaveMonth==0)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND leave_month='"+leaveMonth+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(leaveYear==0)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND leave_year='"+leaveYear+"'";
			System.out.println("inside if 1"+selectQuery);
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
			System.out.println("line 1 stop here");
			stm= (Statement) conn.createStatement();
			System.out.println("line 1 or here");
			System.out.println("inserted query"+str);
			line =stm.executeUpdate(str);
			flag="true";
	 	}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return line;
	}
}
