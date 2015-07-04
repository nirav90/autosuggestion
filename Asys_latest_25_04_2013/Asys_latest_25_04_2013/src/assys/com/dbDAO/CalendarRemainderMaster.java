package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;
import assys.com.dbBean.CalendarRemainderMasterBean;



/**
 * @author Slesha
 *
 */

public class CalendarRemainderMaster {
	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(CalendarRemainderMasterBean calRemMstBean)
	{
		CalendarRemainderMasterBean calRemBean=(CalendarRemainderMasterBean) calRemMstBean;
		String remainderId=calRemBean.getRemainderId();
		String empUserId=calRemBean.getEmpUserId();
		String remainderTaskName=calRemBean.getRemainderTaskName();
		Date remaiderTaskDateTime=calRemBean.getRemaiderTaskDateTime();
		
		try{
			ip=InetAddress.getLocalHost();

			String str1 ="insert into calendar_remainder_master(remainder_id,emp_user_id";
			String value1=" values('"+remainderId+"','"+empUserId+"',";
			
			if(remainderTaskName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",remainder_task_name";
				value1+="'"+remainderTaskName+"',";
				System.out.println("line 2 if " );
			}
			
			if(remaiderTaskDateTime==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",remaider_task_date_time";
				value1+="'"+dateFormat.format(remaiderTaskDateTime)+"',";
				System.out.println("line 4 if");
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
	
	public String delete(CalendarRemainderMasterBean calRemMstBean)
	{
		CalendarRemainderMasterBean calRemBean=(CalendarRemainderMasterBean) calRemMstBean;
		String remainderId=calRemBean.getRemainderId();
		String empUserId=calRemBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update calendar_remainder_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND remainder_id='"+remainderId+"';";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String update(CalendarRemainderMasterBean calRemMstBean)
	{
		CalendarRemainderMasterBean calRemBean=(CalendarRemainderMasterBean) calRemMstBean;
		String remainderId=calRemBean.getRemainderId();
		String empUserId=calRemBean.getEmpUserId();
		String remainderTaskName=calRemBean.getRemainderTaskName();
		Date remaiderTaskDateTime=calRemBean.getRemaiderTaskDateTime();
		
		try{
			ip=InetAddress.getLocalHost();

			String updateQuery ="update calendar_remainder_master set ";
					
			if(remainderTaskName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="remainder_task_name='"+remainderTaskName+"',";
				System.out.println("line 2 if " );
			}
			
			if(remaiderTaskDateTime==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="remaider_task_date_time='"+dateFormat.format(remaiderTaskDateTime)+"',";
				System.out.println("line 4 if");
			}
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where remainder_id='"+remainderId+"' AND emp_user_id='"+empUserId+"';";
			
			int lineUpdated=executeQueries(updateQuery);
			System.out.println("line affected"+lineUpdated);
			
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public ResultSet selectAll()
	{		
		String selectAllQuery="select * from calendar_remainder_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(CalendarRemainderMasterBean calRemMstBean)
	{
		CalendarRemainderMasterBean calRemBean=(CalendarRemainderMasterBean) calRemMstBean;
		String remainderId=calRemBean.getRemainderId();
		String empUserId=calRemBean.getEmpUserId();
		String remainderTaskName=calRemBean.getRemainderTaskName();
		Date remaiderTaskDateTime=calRemBean.getRemaiderTaskDateTime();
		
		String selectQuery="select * from calendar_remainder_master where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(remainderId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND remainder_id='"+remainderId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(remainderTaskName==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND remainder_task_name='"+remainderTaskName+"'";
			System.out.println("line 4 if");
		}
		if(remaiderTaskDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND remaider_task_date_time='"+remaiderTaskDateTime+"'";
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
