package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;
import assys.com.dbBean.ClientDetailsBean;



/**
 * @author Slesha
 *
 */

public class ClientDetails {

	

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	String flag="false";

	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	InetAddress ip;
	
	public String insert(ClientDetailsBean clnDetBean)
	{
		ClientDetailsBean clntDetBean=(ClientDetailsBean) clnDetBean;
		String empUserId=clntDetBean.getEmpUserId();
		String clientFirstName=clntDetBean.getClientFirstName();
		String clientLastName=clntDetBean.getClientLastName();
		String phoneNo=clntDetBean.getPhoneNo();
		String companyName=clntDetBean.getCompanyName();
		String companyAddress=clntDetBean.getCompanyAddress();
		String clientEmailId=clntDetBean.getClientEmailId();
		try{
			ip=InetAddress.getLocalHost();

			String str1 ="insert into client_details(client_id";
			String value1=" values('"+empUserId+"',";
			
			if(clientFirstName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",client_first_name";
				value1+="'"+clientFirstName+"',";
				System.out.println("line 2 if " );
			}
			
			if(clientLastName==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",client_last_name";
				value1+="'"+clientLastName+"',";
				System.out.println("line 4 if");
			}
			if(phoneNo==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",phone_no";
				value1+="'"+phoneNo+"',";
				System.out.println("line 4 if");
			}
			if(companyName==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",company_name";
				value1+="'"+companyName+"',";
				System.out.println("line 4 if");
			}
			if(companyAddress==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",company_address";
				value1+="'"+companyAddress+"',";
				System.out.println("line 4 if");
			}
			if(clientEmailId==null)
			{
				
			}else{
				System.out.println("line 3 if");
				str1+=",client_email_id";
				value1+="'"+clientEmailId+"',";
				System.out.println("line 4 if");
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
	
	public String delete(ClientDetailsBean clnDetBean)
	{
		ClientDetailsBean clntDetBean=(ClientDetailsBean) clnDetBean;
		String empUserId=clntDetBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update client_details set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where client_id='"+empUserId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String update(ClientDetailsBean clnDetBean)
	{
		ClientDetailsBean clntDetBean=(ClientDetailsBean) clnDetBean;
		String empUserId=clntDetBean.getEmpUserId();
		String clientFirstName=clntDetBean.getClientFirstName();
		String clientLastName=clntDetBean.getClientLastName();
		String phoneNo=clntDetBean.getPhoneNo();
		String companyName=clntDetBean.getCompanyName();
		String companyAddress=clntDetBean.getCompanyAddress();
		String clientEmailId=clntDetBean.getClientEmailId();
		try{
			ip=InetAddress.getLocalHost();

			String updateQuery ="update client_details set ";
						
			if(clientFirstName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="client_first_name='"+clientFirstName+"',";
				System.out.println("line 2 if " );
			}
			
			if(clientLastName==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="client_last_name='"+clientLastName+"',";
				System.out.println("line 4 if");
			}
			if(phoneNo==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="phone_no='"+phoneNo+"',";
				System.out.println("line 4 if");
			}
			if(companyName==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="company_name='"+companyName+"',";
				System.out.println("line 4 if");
			}
			if(companyAddress==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="company_address='"+companyAddress+"',";
				System.out.println("line 4 if");
			}
			if(clientEmailId==null)
			{
				
			}else{
				System.out.println("line 3 if");
				updateQuery+="client_email_id='"+clientEmailId+"',";
				System.out.println("line 4 if");
			}
			
			
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where client_id='"+empUserId+"'";
			
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
		String selectAllQuery="select * from client_details;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(ClientDetailsBean clnDetBean)
	{
		ClientDetailsBean clntDetBean=(ClientDetailsBean) clnDetBean;
		String empUserId=clntDetBean.getEmpUserId();
		String clientFirstName=clntDetBean.getClientFirstName();
		String clientLastName=clntDetBean.getClientLastName();
		String phoneNo=clntDetBean.getPhoneNo();
		String companyName=clntDetBean.getCompanyName();
		String companyAddress=clntDetBean.getCompanyAddress();
		String clientEmailId=clntDetBean.getClientEmailId();
		String selectQuery="select * from client_details where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND client_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(clientFirstName==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND client_first_name='"+clientFirstName+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(clientLastName==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND client_last_name='"+clientLastName+"'";
			System.out.println("line 4 if");
		}
		if(phoneNo==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND phone_no='"+phoneNo+"'";
			System.out.println("line 4 if");
		}		
		if(companyName==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND company_name='"+companyName+"'";
			System.out.println("line 4 if");
		}
		if(companyAddress==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND company_address='"+companyAddress+"'";
			System.out.println("line 4 if");
		}
		if(clientEmailId==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND client_email_id='"+clientEmailId+"'";
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
