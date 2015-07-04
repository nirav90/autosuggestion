package assys.com.DAO.welcome_login;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import assys.com.DAO.DBConnection;
import assys.com.bean.welcome_login.Login;





/**
 * @author Slesha at 30-11-12
 *
 */
public class LoginDAO {
	
	public String login_select(Login lgn) throws UnknownHostException, SQLException
	{
		Login login=(Login) lgn;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String flag="false";
		Savepoint savePoint=null;
		Random rnd=new Random();
		
		int login_ids=rnd.nextInt(Integer.MAX_VALUE)+1;
		String login_id="lgn"+login_ids;
		conn = (Connection) DBConnection.getConnection();
		String loginUserName=login.getLoginUserName();
		String loginPassWord=login.getLoginPassWord();
		InetAddress ip;
		
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		if(conn != null){
		   
			try {
				conn.setAutoCommit(false);
				savePoint=conn.setSavepoint("before insert");
				ip=InetAddress.getLocalHost();
				stmt = conn.createStatement();
				//StringBuffer selectSQL = new  StringBuffer("SELECT * FROM AUTHENTICATION_DETAIL WHERE USER_NAME='"+ loginUserName +"' AND PASSWORD='"+ loginPassWord +"'");
				StringBuffer selectSQL = new  StringBuffer("SELECT emp_category FROM authentication_detail ad,emp_user_id_generator eg WHERE ad.emp_user_id=eg.emp_user_id AND USER_NAME='"+ loginUserName +"' AND PASSWORD='"+ loginPassWord +"'");
				StringBuffer insertSQL= new StringBuffer("INSERT INTO login_history(login_id,user_name,login_date_time,ip,isDeleted,createdDate) values('"+login_id+"','"+ loginUserName +"','"+ dateFormat.format(date) +"','"+ip.getHostAddress()+"','0','"+ dateFormat.format(date) +"')");
				System.out.println("line1"+loginUserName);
				/*stmt.executeUpdate(insertSQL.toString());*/
				rs = stmt.executeQuery(selectSQL.toString());
				/*while(rs.next())
				{
					System.out.println("line1"+rs.getString("user_name"));
					flag=true;
				}*/
				if(rs.next())
				{
					String category=rs.getString("emp_category");
					if(category.equals("Admin"))
					{
						flag="admin";
					}
					if(category.equals("Client"))
					{
						flag="client";
					}
					if(category.equals("Manager"))
					{
						flag="manager";
					}
					if(category.equals("Project Manager"))
					{
						flag="pmanager";
					}
					if(category.equals("Employee"))
					{
						flag="employee";
					}
//					flag=true;
				}
				else
				{
					flag="false";
				}
				if(flag.equals("false"))
				{
					conn.rollback(savePoint);
				}
				else
				{ 
					conn.commit();
				}
				
			} 
		
			catch (SQLException e) {
				conn.rollback(savePoint);
				e.printStackTrace();
			}
		
		}
		
		else	{
			flag="false";
		}
		System.out.println(flag);
		return flag;
	}
}
