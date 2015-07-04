package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;
import assys.com.dbBean.EmpDetailBean;



/**
 * @author Slesha
 *
 */

public class EmpDetail {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	public String flag="false";
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DateFormat dateFormatBday=new SimpleDateFormat("yyyy-MM-dd");
	DateFormat dateFormate=new SimpleDateFormat("MM/dd/yy");
	InetAddress ip;
	
	
	public String insert(EmpDetailBean empDetBean)
	{
		EmpDetailBean empBean=(EmpDetailBean) empDetBean;
		String empUserId=empBean.getEmpUserId();
		String firstName=empBean.getFirstName();
		String lastName=empBean.getLastName();
		String gender=empBean.getGender();
		String phoneNo=empBean.getPhoneNo();
		String address=empBean.getAddress();
		String addCity=empBean.getAddCity();
		String addState=empBean.getAddState();
		String addCountry=empBean.getAddCountry();
		String birthdate=empBean.getBirthdate();
		/*work_id="wrk"+rnd.nextInt(Integer.MAX_VALUE)+1;*/
		
		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into emp_detail(emp_user_id,";
			String value1 =" values ('"+empUserId+"',";
				
				if(firstName==null)
				{}
				else{
					System.out.println("first_name:line 1 if");
					str1+="first_name,";
					value1+="'"+firstName+"',";
					System.out.println("first_name:line 2 if " );
				}
				if(lastName==null)
				{}
				else{
					System.out.println("last_name:line 3 if");
					str1+="last_name,";
					value1+="'"+lastName+"',";
					System.out.println("last_name:line 4 if");
				}
				if(birthdate==null)
				{}else{
					System.out.println("birthdate:line 3 if");
					str1+="birthdate,";
					Date birthdate1 = dateFormate.parse(birthdate);
					value1+="'"+dateFormatBday.format(birthdate1)+"',";
					System.out.println("birthdate:line 4 if");
				}
				if(gender==null)
				{}else{
					System.out.println("line 3 if");
					str1+="gender,";
					value1+="'"+gender+"',";
					System.out.println("line 4 if");
				}
				if(phoneNo==null)
				{}else{
					System.out.println("phone_no:line 3 if");
					str1+="phone_no,";
					value1+="'"+phoneNo+"',";
					System.out.println("phone_no:line 4 if");
				}
				if(address==null)
				{}else{
					System.out.println("line 3 if");
					str1+="address,";
					value1+="'"+address+"',";
					System.out.println("line 4 if");
				}
				if(addCity==null)
				{}else{
					System.out.println("line 3 if");
					str1+="add_city,";
					value1+="'"+addCity+"',";
					System.out.println("line 4 if");
				}
				if(addState==null)
				{}else{
					System.out.println("line 3 if");
					str1+="add_state,";
					value1+="'"+addState+"',";
					System.out.println("line 4 if");
				}
				if(addCountry==null)
				{}else{
					System.out.println("line 3 if");
					str1+="add_country,";
					value1+="'"+addCountry+"',";
					System.out.println("line 4 if");
				}
				
				System.out.println(ip.getHostName());
			str1+="ip,isDeleted,createdDate,modifyDate)";
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
	
	public String delete(EmpDetailBean empDetBean)
	{
		EmpDetailBean empBean=(EmpDetailBean) empDetBean;
		String empUserId=empBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update emp_detail set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String update(EmpDetailBean empDetBean)
	{
		EmpDetailBean empBean=(EmpDetailBean) empDetBean;
		String empUserId=empBean.getEmpUserId();
		String firstName=empBean.getFirstName();
		String lastName=empBean.getLastName();
		String gender=empBean.getGender();
		String phoneNo=empBean.getPhoneNo();
		String address=empBean.getAddress();
		String addCity=empBean.getAddCity();
		String addState=empBean.getAddState();
		String addCountry=empBean.getAddCountry();
		String birthdate=empBean.getBirthdate();
		/*work_id="wrk"+rnd.nextInt(Integer.MAX_VALUE)+1;*/
		
		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery ="update emp_detail set ";
							
				if(firstName==null)
				{}
				else{
					System.out.println("first_name:line 1 if");
					updateQuery+="first_name='"+firstName+"',";
					System.out.println("first_name:line 2 if " );
				}
				if(lastName==null)
				{}
				else{
					System.out.println("last_name:line 3 if");
					updateQuery+="last_name='"+lastName+"',";
					System.out.println("last_name:line 4 if");
				}
				if(birthdate==null)
				{}else{
					System.out.println("birthdate:line 3 if");
					Date birthdate1 = dateFormate.parse(birthdate);
					
					updateQuery+="birthdate='"+dateFormatBday.format(birthdate1)+"',";
					System.out.println("birthdate:line 4 if");
				}
				if(gender==null)
				{}else{
					System.out.println("line 3 if");
					updateQuery+="gender='"+gender+"',";
					System.out.println("line 4 if");
				}
				if(phoneNo==null)
				{}else{
					System.out.println("phone_no:line 3 if");
					updateQuery+="phone_no='"+phoneNo+"',";
					System.out.println("phone_no:line 4 if");
				}
				if(address==null)
				{}else{
					System.out.println("line 3 if");
					updateQuery+="address='"+address+"',";
					System.out.println("line 4 if");
				}
				if(addCity==null)
				{}else{
					System.out.println("line 3 if");
					updateQuery+="add_city='"+addCity+"',";
					System.out.println("line 4 if");
				}
				if(addState==null)
				{}else{
					System.out.println("line 3 if");
					updateQuery+="add_state='"+addState+"',";
					System.out.println("line 4 if");
				}
				if(addCountry==null)
				{}else{
					System.out.println("line 3 if");
					updateQuery+="add_country='"+addCountry+"',";
					System.out.println("line 4 if");
				}
				
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where emp_user_id='"+empUserId+"';";
			int lineInserted=executeQueries(updateQuery);
			System.out.println("line affected"+lineInserted);
			
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		return flag;
	}
	
	public ResultSet selectAll()
	{		
		String selectAllQuery="select * from emp_detail;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(EmpDetailBean empDetBean) throws ParseException
	{
		EmpDetailBean empBean=(EmpDetailBean) empDetBean;
		String empUserId=empBean.getEmpUserId();
		String firstName=empBean.getFirstName();
		String lastName=empBean.getLastName();
		String gender=empBean.getGender();
		String phoneNo=empBean.getPhoneNo();
		String address=empBean.getAddress();
		String addCity=empBean.getAddCity();
		String addState=empBean.getAddState();
		String addCountry=empBean.getAddCountry();
		String birthdate=empBean.getBirthdate();
		
		String selectQuery="select * from emp_detail where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(firstName==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{ 
			selectQuery+=" AND first_name='"+firstName+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(lastName==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND last_name='"+lastName+"'";
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
		if(phoneNo==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND phone_no='"+phoneNo+"'";
			System.out.println("line 4 if");
		}
		if(address==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND address='"+address+"'";
			System.out.println("line 4 if");
		}
		if(addCity==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND add_city='"+addCity+"'";
			System.out.println("line 4 if");
		}
		if(addState==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND add_state='"+addState+"'";
			System.out.println("line 4 if");
		}
		if(addCountry==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND add_country='"+addCountry+"'";
			System.out.println("line 4 if");
		}
		if(birthdate==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			Date birthdate1 = dateFormatBday.parse(birthdate);
			
			selectQuery+=" AND birthdate='"+dateFormatBday.format(birthdate1)+"'";
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
