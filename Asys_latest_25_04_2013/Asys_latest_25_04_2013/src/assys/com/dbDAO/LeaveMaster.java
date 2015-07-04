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

//import assys.com.dbBean.Emp_user_id_generator_bean;
import assys.com.dbBean.LeaveMasterBean;



/**
 * @author Slesha
 *
 */

public class LeaveMaster {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
	InetAddress ip;
	String flag="false";
	public String insert(LeaveMasterBean levMstBean)
	{
		LeaveMasterBean leaveMstBean=(LeaveMasterBean) levMstBean;
		String empUserId=leaveMstBean.getEmpUserId();
		String leaveId=leaveMstBean.getLeaveId();
		String senderEmailId=leaveMstBean.getSenderEmailId();
		String reciptanceEmailId=leaveMstBean.getReciptanceEmailId();
		String leaveSubject=leaveMstBean.getLeaveSubject();
		String leaveBody=leaveMstBean.getLeaveBody();
		
		Date leaveSendingDateTime=leaveMstBean.getLeaveSendingDateTime();
		String leaveFromDate=leaveMstBean.getLeaveFromDate();
		String leaveToDate=leaveMstBean.getLeaveToDate();
		Random rnd=new Random();
		int leaveId1=rnd.nextInt(Integer.MAX_VALUE)+1;
		String WorkId ="leave"+leaveId1;

		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into leave_master(leave_id,emp_user_id";
			String value1=" values('"+WorkId+"','"+empUserId+"',";
			
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
			
			if(leaveSubject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",leave_subject";
				value1+="'"+leaveSubject+"',";
				System.out.println("line 2 if " );
			}
			
			if(leaveBody==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",leave_body";
				value1+="'"+leaveBody+"',";
				System.out.println("line 2 if " );
			}
			
			if(leaveFromDate==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",leave_from_date";
				Date leaveFromDate1 = dateformate.parse(leaveFromDate);
				value1+="'"+dateformate.format(leaveFromDate1)+"',";
				System.out.println("line 2 if " );
			}
			
			if(leaveToDate==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",leave_to_date";
				Date leaveToDate1 = dateformate.parse(leaveToDate);
				value1+="'"+dateformate.format(leaveToDate1)+"',";
				System.out.println("line 2 if " );
			}
			
			/*if(leaveSendingDateTime==null)
			{
					
			}else{*/
				System.out.println("line 1 if stop here nw");
				str1+=",leave_sending_date_time";
				value1+="'"+dateFormat.format(date)+"',";
				System.out.println("line 2 if or here" );
			/*}*/
					
			str1+=",leave_approve,isSeen,ip,isDeleted,isPublished,createdDate,modifyDate)";
			value1+="0,0,'"+ ip.getHostAddress() +"',0,0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
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

	public String update(LeaveMasterBean levMstBean)
	{
		LeaveMasterBean leaveMstBean=(LeaveMasterBean) levMstBean;
		String empUserId=leaveMstBean.getEmpUserId();
		String leaveId=leaveMstBean.getLeaveId();
		boolean leaveApprove=leaveMstBean.isLeaveApprove();
		try{
			ip=InetAddress.getLocalHost();
			
			String updateQuery="update leave_master set ";
			if(leaveApprove==false)
			{
				System.out.println("line 1 if");
				updateQuery+="leave_approve=0,";
				
				System.out.println("line 2 if " );
			}else{
				System.out.println("line 1 if");
				updateQuery+="leave_approve=1,";
				
				System.out.println("line 2 if " );
			}
			updateQuery+="isSeen=1,ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where leave_id='"+leaveId+"'";
			int lineUpdated=executeQueries(updateQuery);
			System.out.println("line affected"+lineUpdated);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String delete(LeaveMasterBean levMstBean)
	{
		LeaveMasterBean leaveMstBean=(LeaveMasterBean) levMstBean;
		String empUserId=leaveMstBean.getEmpUserId();
		String leaveId=leaveMstBean.getLeaveId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update leave_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND leave_id='"+leaveId+"'";
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
		String selectAllQuery="select * from leave_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(LeaveMasterBean levMstBean)
	{
		LeaveMasterBean leaveMstBean=(LeaveMasterBean) levMstBean;
		String empUserId=leaveMstBean.getEmpUserId();
		String leaveId=leaveMstBean.getLeaveId();
		String senderEmailId=leaveMstBean.getSenderEmailId();
		String reciptanceEmailId=leaveMstBean.getReciptanceEmailId();
		String leaveSubject=leaveMstBean.getLeaveSubject();
		String leaveBody=leaveMstBean.getLeaveBody();
		String leaveFromDate=leaveMstBean.getLeaveFromDate();
		String leaveToDate=leaveMstBean.getLeaveToDate();
		Date leaveSendingDateTime=leaveMstBean.getLeaveSendingDateTime();
		

		String selectQuery="select * from leave_master where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(leaveId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND leave_id='"+leaveId+"'";
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
		if(leaveSubject==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND leave_subject='"+leaveSubject+"'";
			System.out.println("line 4 if");
		}
		if(leaveBody==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND leave_body='"+leaveBody+"'";
			System.out.println("line 4 if");
		}
		if(leaveFromDate==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			
			System.out.println("line 3 if");
			selectQuery+=" AND leave_from_date='"+leaveFromDate+"'";
			System.out.println("line 4 if");
		}
		if(leaveToDate==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND leave_to_date='"+leaveToDate+"'";
			System.out.println("line 4 if");
		}
		if(leaveSendingDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND leave_sending_date_time='"+leaveSendingDateTime+"'";
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
