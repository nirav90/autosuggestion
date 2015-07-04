package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;


import assys.com.dbBean.EmpUserIdGeneratorBean;



/**
 * @author Slesha
 *
 */

public class EmpUserIdGenerator {

	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(EmpUserIdGeneratorBean empUserIdGenBean)
	{
		EmpUserIdGeneratorBean empUserIdBean=(EmpUserIdGeneratorBean) empUserIdGenBean;
		String empUserId=empUserIdBean.getEmpUserId();
		String empCategory=empUserIdBean.getEmpCategory();
		
		try{
			ip=InetAddress.getLocalHost();
			
			String str1 ="insert into emp_user_id_generator(emp_user_id";
			String value1=" values('"+empUserId+"',";
			
			if(empCategory==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",emp_category";
				value1+="'"+empCategory+"',";
				System.out.println("line 2 if " );
			}
			
			str1+=",emp_id_used,ip,createdDate,modifyDate)";
			value1+="0,'"+ ip.getHostAddress() +"','"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
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


	public String update(EmpUserIdGeneratorBean empUserIdGenBean)
	{
		EmpUserIdGeneratorBean empUserIdBean=(EmpUserIdGeneratorBean) empUserIdGenBean;
		String empUserId=empUserIdBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String updateQuery="update emp_user_id_generator set emp_id_used=1,ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where emp_user_id='"+empUserId+"'";
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
		String selectAllQuery="select * from emp_user_id_generator;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(EmpUserIdGeneratorBean empUserIdGenBean)
	{
		EmpUserIdGeneratorBean empUserIdBean=(EmpUserIdGeneratorBean) empUserIdGenBean;
		String empUserId=empUserIdBean.getEmpUserId();
		String empCategory=empUserIdBean.getEmpCategory();
		boolean empIdUsed=empUserIdBean.isEmpIdUsed();
		String selectQuery="select * from emp_user_id_generator where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(empCategory==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_category='"+empCategory+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(empIdUsed==true){
			selectQuery+=" AND emp_id_used=1;";
		}
		else{
			selectQuery+=" AND emp_id_used=0;";
		}
		
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
