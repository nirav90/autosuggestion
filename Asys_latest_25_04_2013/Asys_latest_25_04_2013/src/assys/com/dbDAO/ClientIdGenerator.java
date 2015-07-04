package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;

import assys.com.dbBean.ClientIdGeneratorBean;

public class ClientIdGenerator {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(ClientIdGeneratorBean clnIdBean)
	{
		
		ClientIdGeneratorBean clnIdGenBean=(ClientIdGeneratorBean) clnIdBean;
		String clientId=clnIdGenBean.getClientId();
		String clientName=clnIdGenBean.getClientName();
		String clientCompanyName=clnIdGenBean.getClientCompanyName();
		String projectManagerId=clnIdGenBean.getProjectManagerId();
		

		try{
			ip=InetAddress.getLocalHost();
			String str1 ="insert into client_id_generator(isIdGenerated,isProjectCompleted";
			String value1="values (0,0,";
				if(clientId==null)
				{	}
				else{
					System.out.println("line 1 if");
					str1+=",client_id";
					value1+="'"+clientId+"',";
					System.out.println("line 2 if " );
				}
				
				if(clientName==null)	
				{   }
				else{
					System.out.println("line 3 if");
					str1+=",client_name";
					value1+="'"+clientName+"',";
					System.out.println("line 4 if");
				}
				
				if(clientCompanyName==null)
				{   }
				else{
					System.out.println("line 3 if");
					str1+=",client_company_name";
					value1+="'"+clientCompanyName+"',";
					System.out.println("line 4 if");
				}
				if(projectManagerId==null)
				{	}
				else{
					System.out.println("line 3 if");
					str1+=",project_manager_id";
					value1+="'"+projectManagerId+"',";
					System.out.println("line 4 if");
				}
				
				
				str1+=",ip,isDeleted,createdDate,modifyDate) ";
				value1+="'"+ ip.getHostAddress() +"',0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
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
		
	public String update(ClientIdGeneratorBean clnIdBean)
	{
		
		ClientIdGeneratorBean clnIdGenBean=(ClientIdGeneratorBean) clnIdBean;
		String clientId=clnIdGenBean.getClientId();
		String clientName=clnIdGenBean.getClientName();
		String clientCompanyName=clnIdGenBean.getClientCompanyName();
		String projectManagerId=clnIdGenBean.getProjectManagerId();
		
		boolean isIdGenerated=clnIdGenBean.isIdGenerated();
		boolean isProjectCompleted=clnIdGenBean.isProjectCompleted();
		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery ="update client_id_generator set ";
			
				if(clientId==null)
				{
					
				}else{
					System.out.println("line 1 if");
					updateQuery+="client_id='"+clientId+"',";
					
					System.out.println("line 2 if " );
				}
				
				if(clientName==null)
				{
					
				}else{
					System.out.println("line 3 if");
					updateQuery+="client_name='"+clientName+"',";
					
					System.out.println("line 4 if");
				}
				
				if(clientCompanyName==null)
				{
					
				}else{
					System.out.println("line 3 if");
					updateQuery+="client_company_name='"+clientCompanyName+"',";
					
					System.out.println("line 4 if");
				}
				
				if(projectManagerId==null)
				{
					
				}else{
					System.out.println("line 3 if");
					updateQuery+="project_manager_id='"+projectManagerId+"',";
					
					System.out.println("line 4 if");
				}
				
				
				if(isIdGenerated==false)
				{
					System.out.println("line 1 if");
					updateQuery+="isIdGenerated=0,";
					
					System.out.println("line 2 if " );
				}else{
					System.out.println("line 1 if");
					updateQuery+="isIdGenerated=1,";
					
					System.out.println("line 2 if " );
				}
				
				if(isProjectCompleted==false)
				{
					System.out.println("line 1 if");
					updateQuery+="isProjectCompleted=0,";
					
					System.out.println("line 2 if " );
				}else{
					System.out.println("line 1 if");
					updateQuery+="isProjectCompleted=1,";
					
					System.out.println("line 2 if " );
				}
				
				updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where 1";
			
				if(clientName==null)
				{
					
				}else{
					System.out.println("line 3 if");
					updateQuery+=" AND client_name='"+clientName+"'";
					
					System.out.println("line 4 if");
				}
				
				if(clientCompanyName==null)
				{
					
				}else{
					System.out.println("line 3 if");
					updateQuery+=" AND client_company_name='"+clientCompanyName+"'";
					
					System.out.println("line 4 if");
				}
				
				if(projectManagerId==null)
				{
					
				}else{
					System.out.println("line 3 if");
					updateQuery+=" AND project_manager_id='"+projectManagerId+"'";
					
					System.out.println("line 4 if");
				}
				
				updateQuery+=";";
			int lineUpdated=executeQueries(updateQuery);
			System.out.println("line affected"+lineUpdated);
			
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		return flag;
	}
	
	public String delete(ClientIdGeneratorBean clnIdBean)
	{
		
		ClientIdGeneratorBean clnIdGenBean=(ClientIdGeneratorBean) clnIdBean;
		String clientId=clnIdGenBean.getClientId();
		
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update client_id_generator set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where client_id='"+clientId+"';";
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
		String selectAllQuery="select * from client_id_generator;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(ClientIdGeneratorBean clnIdBean)
	{
		
		ClientIdGeneratorBean clnIdGenBean=(ClientIdGeneratorBean) clnIdBean;
		String clientId=clnIdGenBean.getClientId();
		String clientName=clnIdGenBean.getClientName();
		String clientCompanyName=clnIdGenBean.getClientCompanyName();
		String projectManagerId=clnIdGenBean.getProjectManagerId();
		
		boolean isIdGenerated=clnIdGenBean.isIdGenerated();
		boolean isProjectCompleted=clnIdGenBean.isProjectCompleted();
		
		String selectQuery="select * from client_id_generator where 1";
		if(clientId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND client_id='"+clientId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(clientName==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND client_name='"+clientName+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(clientCompanyName==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND client_company_name='"+clientCompanyName+"'";
			System.out.println("line 4 if");
		}
		if(projectManagerId==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND project_manager_id='"+projectManagerId+"'";
			System.out.println("line 4 if");
		}		
		
		if(isIdGenerated==false)
		{
			System.out.println("line 1 if");
			selectQuery+=" AND isIdGenerated=0";
			
			System.out.println("line 2 if " );
		}else{
			System.out.println("line 1 if");
			selectQuery+=" AND isIdGenerated=1";
			
			System.out.println("line 2 if " );
		}
		
		if(isProjectCompleted==false)
		{
			System.out.println("line 1 if");
			selectQuery+=" AND isProjectCompleted=0";
			
			System.out.println("line 2 if " );
		}else{
			System.out.println("line 1 if");
			selectQuery+=" AND isProjectCompleted=1";
			
			System.out.println("line 2 if " );
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
