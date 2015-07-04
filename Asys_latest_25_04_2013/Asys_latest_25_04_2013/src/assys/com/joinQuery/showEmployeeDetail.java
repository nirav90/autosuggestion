package assys.com.joinQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import assys.com.DAO.DBConnection;

public class showEmployeeDetail {
		
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	public ResultSet selectProjectManager(String empCategory1)
	{		
		System.out.println(empCategory1);
		String selectAllQuery="select * from emp_detail cm,emp_user_id_generator ce,authentication_detail cp where cm.emp_user_id=ce.emp_user_id AND cm.emp_user_id=cp.emp_user_id AND cp.emp_user_id=ce.emp_user_id AND ce.emp_category!='Client' AND ce.emp_category!='Admin';";
		rs=executeSelect(selectAllQuery);
		return rs;
	}
	public ResultSet selectEmployee(String empCategory1)
	{		
		System.out.println(empCategory1);
		String selectAllQuery="select * from emp_detail cm,emp_user_id_generator ce,authentication_detail cp,work_profile_detail wp,gmail_authentication ga where cm.emp_user_id=ga.emp_user_id AND cp.emp_user_id=ga.emp_user_id AND ce.emp_user_id=ga.emp_user_id AND cm.emp_user_id=wp.emp_user_id AND ce.emp_user_id=wp.emp_user_id AND cp.emp_user_id=wp.emp_user_id AND cm.emp_user_id=ce.emp_user_id AND cm.emp_user_id=cp.emp_user_id AND cp.emp_user_id=ce.emp_user_id AND ce.emp_category='"+empCategory1+"';";
		rs=executeSelect(selectAllQuery);
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
}
