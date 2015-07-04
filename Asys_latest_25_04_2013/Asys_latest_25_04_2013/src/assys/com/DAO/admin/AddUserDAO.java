package assys.com.DAO.admin;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



import assys.com.DAO.DBConnection;
import assys.com.bean.admin.AddUser;
import assys.com.sms.Way2Sms;



/**
 * @author slesha
 *
 */
public class AddUserDAO {
	
	public boolean add_user_insert(AddUser addUsers)
	{
		//Boolean Value 0=false 1=true
		AddUser addUser=(AddUser) addUsers;
		boolean flag=false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		conn = (Connection) DBConnection.getConnection();
		String emp_category_id = null;
		String emp_category=addUser.getEmpCategory();
		InetAddress ip;
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Random rnd=new Random();
		int emp_id=rnd.nextInt(Integer.MAX_VALUE)+1;
		String way2sms_username,way2sms_password;
		Way2Sms way2Sms=new Way2Sms();
		String phone=addUser.getPhone();
		if(conn != null){
			   
			try {
				ip=InetAddress.getLocalHost();
				
				
				if(emp_category.equals("Client"))
				{
					emp_category_id="cln" + emp_id;
					
				}
				else if(emp_category.equals("Employee"))
				{
					emp_category_id="emp" + emp_id;
					
				}
				else if(emp_category.equals("Manager"))
				{
					emp_category_id="mng" + emp_id;
					
				}
				else if(emp_category.equals("Project Manager"))
				{
					emp_category_id="pmng" + emp_id;
					
				}
				
				stmt = conn.createStatement();
				StringBuffer insertSQL = new  StringBuffer("insert into emp_user_id_generator values('"+ emp_category_id +"','"+emp_category+"','0','"+ ip.getHostAddress() +"','"+ dateFormat.format(date) +"')");
				StringBuffer selectSQL= new StringBuffer("select way2sms_user_name,way2sms_password from sms_authentication where user_name='Admin'");
				stmt.executeUpdate(insertSQL.toString());
				rs=stmt.executeQuery(selectSQL.toString());
				while(rs.next())
				{
					way2sms_username=rs.getString("way2sms_user_name");
					way2sms_password=rs.getString("way2sms_password");
					way2Sms.test("site",phone,"Your Employee ID is:"+emp_category_id,way2sms_username,way2sms_password);
				}
				flag=true;
				
				
			} 
		
			catch (SQLException e) {
				
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		else	{
			flag=false;
		}
		
	
		return flag;
	}
}
