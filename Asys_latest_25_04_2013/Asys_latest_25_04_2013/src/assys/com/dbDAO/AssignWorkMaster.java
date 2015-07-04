
package assys.com.dbDAO;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



import assys.com.DAO.*;
import assys.com.dbBean.AssignWorkMasterBean;
//import assys.com.dbBean.Authentication_detail_bean;

/**
 * @author Slesha
 *
 */
public class AssignWorkMaster {

	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(AssignWorkMasterBean assBean)
	{
		
		AssignWorkMasterBean assignBean=(AssignWorkMasterBean) assBean;
		String empUserId=assignBean.getEmpUserId();
		String workId=assignBean.getWorkId();
		String senderEmailId=assignBean.getSenderEmailId();
		String reciptanceEmailId=assignBean.getReciptanceEmailId();
		String workMsgSubject=assignBean.getWorkMsgSubject();
		String workMsgBody=assignBean.getWorkMsgBody();
		//Date starting_date_time=assignBean.getStarting_date_time();
		//Date work_msg_sending_date_time=assignBean.getWork_msg_sending_date_time();
		Double duration=assignBean.getDuration();
		Date endingDateTime=assignBean.getEndingDateTime();
		try{
			ip=InetAddress.getLocalHost();
			String str1 ="insert into assign_work_master(emp_user_id,work_id";
			String value1="values ('"+empUserId+"','"+workId+"',";
				if(senderEmailId==null)
				{	}
				else{
					System.out.println("line 1 if");
					str1+=",sender_email_id";
					value1+="'"+senderEmailId+"',";
					System.out.println("line 2 if " );
				}
				
				if(reciptanceEmailId==null)	
				{   }
				else{
					System.out.println("line 3 if");
					str1+=",reciptance_email_id";
					value1+="'"+reciptanceEmailId+"',";
					System.out.println("line 4 if");
				}
				
				if(workMsgSubject==null)
				{   }
				else{
					System.out.println("line 3 if");
					str1+=",work_msg_subject";
					value1+="'"+workMsgSubject+"',";
					System.out.println("line 4 if");
				}
				if(workMsgBody==null)
				{	}
				else{
					System.out.println("line 3 if");
					str1+=",work_msg_body";
					value1+="'"+workMsgBody+"',";
					System.out.println("line 4 if");
				}
				/*if(starting_date_time==null)
				{}
				else{*/
					System.out.println("line 3 if");
					str1+=",starting_date_time";
					value1+="'"+ dateFormat.format(date) +"',";
					System.out.println("line 4 if");
					
					System.out.println("line 3 if");
					str1+=",ending_date_time";
					value1+="'"+ dateFormat.format(endingDateTime) +"',";
					System.out.println("line 4 if");
				/*}
				if(work_msg_sending_date_time==null)
				{}else{*/
					System.out.println("line 3 if");
					str1+=",work_msg_sending_date_time";
					value1+="'"+ dateFormat.format(date) +"',";
					System.out.println("line 4 if");
				/*}*/
				if(duration==null)
				{}else{
					System.out.println("line 3 if");
					str1+=",duration";
					value1+="'"+duration+"',";
					System.out.println("line 4 if");
				}
				str1+=",work_approve,isSeen,ip,isDeleted,isPublished,createdDate,modifyDate) ";
				value1+="0,0,'"+ ip.getHostAddress() +"',0,0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
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
		
	public String update(AssignWorkMasterBean assBean)
	{
		
		AssignWorkMasterBean assignBean=(AssignWorkMasterBean) assBean;
		String empUserId=assignBean.getEmpUserId();
		String workId=assignBean.getWorkId();
		
		boolean workApprove=assignBean.isWorkApprove();
		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery ="update assign_work_master set ";
			
				
				if(workApprove==false)
				{
					System.out.println("line 1 if");
					updateQuery+="work_approve=0,";
					
					System.out.println("line 2 if " );
				}else{
					System.out.println("line 1 if");
					updateQuery+="work_approve=1,";
					
					System.out.println("line 2 if " );
				}
				updateQuery+="isSeen=1,ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where work_id='"+workId+"';";
			
			
			int lineUpdated=executeQueries(updateQuery);
			System.out.println("line affected"+lineUpdated);
			
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		return flag;
	}
	
	public String delete(AssignWorkMasterBean assBean)
	{
		AssignWorkMasterBean assignBean=(AssignWorkMasterBean) assBean;
		String empUserId=assignBean.getEmpUserId();
		String workId=assignBean.getWorkId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update assign_work_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND work_id='"+workId+"';";
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
		String selectAllQuery="select * from assign_work_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(AssignWorkMasterBean assBean)
	{
		AssignWorkMasterBean assignBean=(AssignWorkMasterBean) assBean;
		String empUserId=assignBean.getEmpUserId();
		String workId=assignBean.getWorkId();
		String senderEmailId=assignBean.getSenderEmailId();
		String reciptanceEmailId=assignBean.getReciptanceEmailId();
		String workMsgSubject=assignBean.getWorkMsgSubject();
		String workMsgBody=assignBean.getWorkMsgBody();

		Date startingDateTime=assignBean.getStartingDateTime();
		Date workMsgSendingDateTime=assignBean.getWorkMsgSendingDateTime();
		Double duration=assignBean.getDuration();
		boolean workApprove=assignBean.isWorkApprove();
		boolean isSeen=assignBean.isSeen();
		
		
		String selectQuery="select * from assign_work_master where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(workId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND work_id='"+workId+"'";
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
		if(workMsgSubject==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND work_msg_subject='"+workMsgSubject+"'";
			System.out.println("line 4 if");
		}
		if(workMsgBody==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND work_msg_body='"+workMsgBody+"'";
			System.out.println("line 4 if");
		}
		if(startingDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND starting_date='"+startingDateTime+"'";
			System.out.println("line 4 if");
		}
		if(workMsgSendingDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND work_msg_sending_date_time='"+workMsgSendingDateTime+"'";
			System.out.println("line 4 if");
		}
		if(duration==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND duration='"+duration+"'";
			System.out.println("line 4 if");
		}
		if(workApprove==false)
		{
			System.out.println("line 1 if");
			selectQuery+=" AND work_approve=0";
			
			System.out.println("line 2 if " );
		}else{
			System.out.println("line 1 if");
			selectQuery+=" AND work_approve=1";
			
			System.out.println("line 2 if " );
		}
		/*if(isSeen==false)
		{
			System.out.println("line 1 if");
			selectQuery+=" AND isSeen=0";
			
			System.out.println("line 2 if " );
		}else{
			System.out.println("line 1 if");
			selectQuery+=" AND isSeen=1";
			
			System.out.println("line 2 if " );
		}*/
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
