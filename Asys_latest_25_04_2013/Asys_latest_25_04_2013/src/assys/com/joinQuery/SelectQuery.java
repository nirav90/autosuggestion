package assys.com.joinQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import assys.com.DAO.DBConnection;

public class SelectQuery {
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
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
