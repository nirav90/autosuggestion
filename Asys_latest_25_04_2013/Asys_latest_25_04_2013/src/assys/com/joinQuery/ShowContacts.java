package assys.com.joinQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import assys.com.DAO.DBConnection;

public class ShowContacts {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	public ResultSet selectContacts(String empUserId)
	{		
		
		String selectAllQuery="select * from contact_detail_master cm,contact_email_detail ce,contact_phone_no_detail cp where cm.contact_id=ce.contact_id AND cm.contact_id=cp.contact_id AND cp.contact_id=ce.contact_id AND cm.emp_user_id='"+empUserId+"' AND ce.emp_user_id='"+empUserId+"' AND cp.emp_user_id='"+empUserId+"' AND cm.isDeleted=0 AND cp.isDeleted=0 AND ce.isDeleted=0;";
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
