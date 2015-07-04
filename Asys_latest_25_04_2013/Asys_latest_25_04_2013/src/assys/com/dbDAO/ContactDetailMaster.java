package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;

import assys.com.dbBean.ContactDetailMasterBean;



/**
 * @author Slesha
 *
 */

public class ContactDetailMaster {
	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(ContactDetailMasterBean cntDetMstBean)
	{
		ContactDetailMasterBean cntDetBean=(ContactDetailMasterBean) cntDetMstBean;
		String contactId=cntDetBean.getContactId();
		String empUserId=cntDetBean.getEmpUserId();
		String contactFirstName=cntDetBean.getContactFirstName();
		String contactLastName=cntDetBean.getContactLastName();
		String gender=cntDetBean.getGender();
		String contactAddress=cntDetBean.getContactAddress();
		

		try{
			ip=InetAddress.getLocalHost();

			String str1 ="insert into contact_detail_master(contact_id,emp_user_id";
			String value1=" values('"+contactId+"','"+empUserId+"',";
			
			if(contactFirstName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",contact_first_name";
				value1+="'"+contactFirstName+"',";
				System.out.println("line 2 if " );
			}
			
			if(contactLastName==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",contact_last_name";
				value1+="'"+contactLastName+"',";
				System.out.println("line 4 if");
			}
			if(gender==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",gender";
				value1+="'"+gender+"',";
				System.out.println("line 4 if");
			}
			if(contactAddress==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",contact_address";
				value1+="'"+contactAddress+"',";
				System.out.println("line 4 if");
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
	
	public String delete(ContactDetailMasterBean cntDetMstBean)
	{
		ContactDetailMasterBean cntDetBean=(ContactDetailMasterBean) cntDetMstBean;
		String contactId=cntDetBean.getContactId();
		String empUserId=cntDetBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update contact_detail_master set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where contact_id='"+contactId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}

	public String update(ContactDetailMasterBean cntDetMstBean)
	{
		ContactDetailMasterBean cntDetBean=(ContactDetailMasterBean) cntDetMstBean;
		String contactId=cntDetBean.getContactId();
		String empUserId=cntDetBean.getEmpUserId();
		String contactFirstName=cntDetBean.getContactFirstName();
		String contactLastName=cntDetBean.getContactLastName();
		String gender=cntDetBean.getGender();
		String contactAddress=cntDetBean.getContactAddress();
		

		try{
			ip=InetAddress.getLocalHost();

			String updateQuery ="update contact_detail_master set ";
			
			if(contactFirstName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="contact_first_name='"+contactFirstName+"',";
				System.out.println("line 2 if " );
			}
			
			if(contactLastName==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="contact_last_name='"+contactLastName+"',";
				System.out.println("line 4 if");
			}
			if(gender==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="gender='"+gender+"',";
				System.out.println("line 4 if");
			}
			if(contactAddress==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="contact_address='"+contactAddress+"',";
				System.out.println("line 4 if");
			}
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where contact_id='"+contactId+"' AND emp_user_id='"+empUserId+"'";
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
		String selectAllQuery="select * from contact_detail_master;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(ContactDetailMasterBean cntDetMstBean)
	{
		ContactDetailMasterBean cntDetBean=(ContactDetailMasterBean) cntDetMstBean;
		String contactId=cntDetBean.getContactId();
		String empUserId=cntDetBean.getEmpUserId();
		String contactFirstName=cntDetBean.getContactFirstName();
		String contactLastName=cntDetBean.getContactLastName();
		String gender=cntDetBean.getGender();
		String contactAddress=cntDetBean.getContactAddress();

		String selectQuery="select * from contact_detail_master where 1";
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
		if(contactFirstName==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND contact_first_name='"+contactFirstName+"'";
			System.out.println("line 4 if");
		}
		if(contactLastName==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND contact_last_name='"+contactLastName+"'";
			System.out.println("line 4 if");
		}		
		if(gender==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND gender='"+gender+"'";
			System.out.println("line 4 if");
		}
		if(contactAddress==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND contact_address='"+contactAddress+"'";
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
