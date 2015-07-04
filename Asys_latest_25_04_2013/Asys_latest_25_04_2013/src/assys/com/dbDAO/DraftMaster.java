package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.Address;

import assys.com.DAO.DBConnection;


import assys.com.dbBean.DraftMasterBean;



/**
 * @author Slesha
 *
 */

public class DraftMaster {
	
	
		
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(DraftMasterBean drtMstBean)
	{
		DraftMasterBean drftMstBean=(DraftMasterBean) drtMstBean;
		String draftId=drftMstBean.getDraftId();
		String empUserId=drftMstBean.getEmpUserId();
		String emailId=drftMstBean.getEmailId();
		String draftSubject=drftMstBean.getDraftSubject();
		String draftBody=drftMstBean.getDraftBody();
		Date draftSaveDateTime=drftMstBean.getDraftSaveDateTime();
		
		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into draft_master(draft_id,emp_user_id";
			String value1=" values('"+draftId+"','"+empUserId+"',";
			
			if(emailId==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",email_id";
				value1+="'"+emailId+"',";
				System.out.println("line 2 if " );
			}
			
			if(draftSubject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",draft_subject";
				value1+="'"+draftSubject+"',";
				System.out.println("line 2 if " );
			}
			if(draftBody==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",draft_body";
				value1+="'"+draftBody+"',";
				System.out.println("line 2 if " );
			}
			
			if(draftSaveDateTime==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",draft_save_date_time";
				value1+="'"+dateFormat.format(draftSaveDateTime)+"',";
				System.out.println("line 2 if " );
			}
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
	
	public String delete(DraftMasterBean drtMstBean)
	{
		DraftMasterBean drftMstBean=(DraftMasterBean) drtMstBean;
		String draftId=drftMstBean.getDraftId();
		String empUserId=drftMstBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update draft_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"' AND draft_id='"+draftId+"'";
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
		String selectAllQuery="select * from draft_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(DraftMasterBean drtMstBean)
	{
		DraftMasterBean drftMstBean=(DraftMasterBean) drtMstBean;
		String draftId=drftMstBean.getDraftId();
		String empUserId=drftMstBean.getEmpUserId();
		String emailId=drftMstBean.getEmailId();
		String draftSubject=drftMstBean.getDraftSubject();
		String draftBody=drftMstBean.getDraftBody();
		Date draftSaveDateTime=drftMstBean.getDraftSaveDateTime();

		String selectQuery="select * from draft_master where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(draftId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND draft_id='"+draftId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(emailId==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND email_id='"+emailId+"'";
			System.out.println("line 4 if");
		}
		if(draftSubject==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND draft_subject='"+draftSubject+"'";
			System.out.println("line 4 if");
		}		
		if(draftBody==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND draft_body='"+draftBody+"'";
			System.out.println("line 4 if");
		}
		if(draftSaveDateTime==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND draft_save_date_time='"+draftSaveDateTime+"'";
			System.out.println("line 4 if");
		}
		selectQuery+=" AND isDeleted=0 ORDER BY draft_save_date_time DESC;;";
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
