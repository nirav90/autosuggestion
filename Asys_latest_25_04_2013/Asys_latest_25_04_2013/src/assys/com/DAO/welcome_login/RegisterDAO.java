package assys.com.DAO.welcome_login;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import assys.com.DAO.DBConnection;
import assys.com.bean.welcome_login.Registration;

/**
 * @author Nirav
 *
 */
public class RegisterDAO {
	//Boolean value 0=false 1=true
	ResultSet rs=null;
	boolean flag=false;
	public boolean Register(Registration reg)
	{
		
		
		Registration register=(Registration) reg;
		Connection conn = null;
		Statement stmt = null;
		
	
		
		String firstName=register.getFirstName();
		String lastName=register.getLastName();
		/*String email=register.getEmail();*/
		String username=register.getUsername();
		String gender =register.getGender();
		String password=register.getPassword();
		String phone=register.getPhone();
		String EmployeeID=register.getEmployeeID();
		InetAddress ip;
		
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try
		{
			ip=InetAddress.getLocalHost();
			conn = (Connection) DBConnection.getConnection();
			if(conn!=null){
			stmt = conn.createStatement();
			StringBuffer selectSQL = new  StringBuffer("SELECT * FROM emp_user_id_generator WHERE emp_user_id='"+ EmployeeID +"' AND emp_id_used='0'");
			rs = stmt.executeQuery(selectSQL.toString());
			System.out.println(selectSQL.toString());
			while(rs.next())
				{
					System.out.println("In while loop:");	
					StringBuffer insert1 = new  StringBuffer("insert into emp_detail(emp_user_id,first_name,last_name,gender,phone_no,ip,isDeleted,createdDate,modifyDate) values('"+EmployeeID+"','"+firstName+"','"+lastName+"','"+gender+"','"+phone+"','"+ ip.getHostAddress() +"','0','" + dateFormat.format(date) + "','" + dateFormat.format(date) + "')");
					StringBuffer insert2 = new  StringBuffer("insert into authentication_detail(emp_user_id,user_name,password,ip,isDeleted,createdDate,modifyDate) values('"+EmployeeID+"','"+username+"','"+password+"','"+ ip.getHostAddress() +"','0','" + dateFormat.format(date) + "','" + dateFormat.format(date) + "')");
					StringBuffer insert3 = new  StringBuffer("update emp_user_id_generator set emp_id_used = '1' where emp_user_id='"+EmployeeID+"'");
					stmt.executeUpdate(insert1.toString());
					stmt.executeUpdate(insert2.toString());
					stmt.executeUpdate(insert3.toString());
					flag=true;
				}			
			}
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
			
		}
		
		
		return flag;
		
	}

}
