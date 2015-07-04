package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;

import assys.com.dbBean.WorkSubmitMasterBean;



/**
 * @author Slesha
 *
 */

public class WorkSubmitMaster {
	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(WorkSubmitMasterBean wrkSubMstBean)
	{
		WorkSubmitMasterBean wrkSubBean=(WorkSubmitMasterBean) wrkSubMstBean;
		String empUserId=wrkSubBean.getEmpUserId();
		String workId=wrkSubBean.getWorkId();
		String senderEmailId=wrkSubBean.getSenderEmailId();
		String reciptanceEmailId=wrkSubBean.getReciptanceEmailId();
		String workMsgSubject=wrkSubBean.getWorkMsgSubject();
		String workMsgBody=wrkSubBean.getWorkMsgBody();
		
		
		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into work_submit_master(emp_user_id,work_id";
			String value1=" values('"+empUserId+"','"+workId+"',";
			
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
			
			if(workMsgSubject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",work_msg_subject";
				value1+="'"+workMsgSubject+"',";
				System.out.println("line 2 if " );
			}
			
			if(workMsgBody==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",work_msg_body";
				value1+="'"+workMsgBody+"',";
				System.out.println("line 2 if " );
			}
			
			/*if(workMsgSendingDateTime==null)
			{
					
			}else{*/
				System.out.println("line 1 if");
				str1+=",work_msg_sending_date_time";
				value1+="'"+dateFormat.format(date)+"',";
				System.out.println("line 2 if " );
			//}
			
			str1+=",work_approve,isSeen,ip,isDeleted,isPublished,createdDate,modifyDate)";
			value1+="0,0,'"+ ip.getHostAddress() +"',0,0,'"+ dateFormat.format(date) +"','"+dateFormat.format(date)+"')";
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
	
	public String delete(WorkSubmitMasterBean wrkSubMstBean)
	{
		WorkSubmitMasterBean wrkSubBean=(WorkSubmitMasterBean) wrkSubMstBean;
		String empUserId=wrkSubBean.getEmpUserId();
		String workId=wrkSubBean.getWorkId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update work_submit_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND work_id='"+workId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String update(WorkSubmitMasterBean wrkSubMstBean)
	{
		WorkSubmitMasterBean wrkSubBean=(WorkSubmitMasterBean) wrkSubMstBean;
		String empUserId=wrkSubBean.getEmpUserId();
		String workId=wrkSubBean.getWorkId();
		
		boolean workApprove=wrkSubBean.isWorkApprove();
		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery = "";
			updateQuery+="update work_submit_master set ";
			
			
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
			updateQuery+="isSeen=1,ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where work_id='"+workId+"' AND isSeen=0;";
		
		
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
		String selectAllQuery="select * from work_submit_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(WorkSubmitMasterBean wrkSubMstBean)
	{
		WorkSubmitMasterBean wrkSubBean=(WorkSubmitMasterBean) wrkSubMstBean;
		String empUserId=wrkSubBean.getEmpUserId();
		String workId=wrkSubBean.getWorkId();
		String senderEmailId=wrkSubBean.getSenderEmailId();
		String reciptanceEmailId=wrkSubBean.getReciptanceEmailId();
		String workMsgSubject=wrkSubBean.getWorkMsgSubject();
		String workMsgBody=wrkSubBean.getWorkMsgBody();
		Date workMsgSendingDateTime=wrkSubBean.getWorkMsgSendingDateTime();
		boolean workApprove=wrkSubBean.isWorkApprove();
		boolean isSeen=wrkSubBean.isSeen();
		String selectQuery="select * from work_submit_master where 1";
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
		if(workMsgSendingDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND work_msg_sending_date_time='"+workMsgSendingDateTime+"'";
			System.out.println("line 4 if");
		}
		if(workApprove==true)
		{
			System.out.println("line 1 if");
			selectQuery+=" AND work_approve=1";
			
			System.out.println("line 2 if " );
		}else if(workApprove==false){
			System.out.println("line 1 if");
			selectQuery+=" AND work_approve=0";
			
			System.out.println("line 2 if " );
		}
		/*if(isSeen==true)
		{
			System.out.println("line 1 if");
			selectQuery+=" AND isSeen=1";
			
			System.out.println("line 2 if " );
		}else if(workApprove==false){
			System.out.println("line 1 if");
			selectQuery+=" AND isSeen=0";
			
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
