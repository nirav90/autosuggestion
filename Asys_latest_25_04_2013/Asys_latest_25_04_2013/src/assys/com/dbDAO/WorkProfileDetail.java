package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;


import assys.com.dbBean.WorkProfileDetailBean;



/**
 * @author Slesha
 *
 */

public class WorkProfileDetail {

	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String flag="false";
	InetAddress ip;
	
	public String insert(WorkProfileDetailBean wrkProfDetBean)
	{
		WorkProfileDetailBean wrkProfBean=(WorkProfileDetailBean) wrkProfDetBean;
		String empUserId=wrkProfBean.getEmpUserId();
		String experience=wrkProfBean.getExperience();
		String designation=wrkProfBean.getDesignation();
		String skill=wrkProfBean.getSkill();
		String qualification=wrkProfBean.getQualification();
		
		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into work_profile_detail(emp_user_id";
			String value1=" values('"+empUserId+"',";
			
			if(experience==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",experience";
				value1+="'"+experience+"',";
				System.out.println("line 2 if " );
			}
			
			if(designation==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",designation";
				value1+="'"+designation+"',";
				System.out.println("line 2 if " );
			}
			
			if(skill==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",skill";
				value1+="'"+skill+"',";
				System.out.println("line 2 if " );
			}
			
			if(qualification==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",qualification";
				value1+="'"+qualification+"',";
				System.out.println("line 2 if " );
			}
			
			str1+=",ip,isDeleted,isPublished,createdDate,modifyDate)";
			value1+="'"+ ip.getHostAddress() +"',0,0,'"+ dateFormat.format(date) +"','"+ dateFormat.format(date) +"')";
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
	
	public String delete(WorkProfileDetailBean wrkProfDetBean)
	{
		WorkProfileDetailBean wrkProfBean=(WorkProfileDetailBean) wrkProfDetBean;
		String empUserId=wrkProfBean.getEmpUserId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update work_profile_detail set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where emp_user_id='"+empUserId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String update(WorkProfileDetailBean wrkProfDetBean)
	{
		WorkProfileDetailBean wrkProfBean=(WorkProfileDetailBean) wrkProfDetBean;
		String empUserId=wrkProfBean.getEmpUserId();
		String experience=wrkProfBean.getExperience();
		String designation=wrkProfBean.getDesignation();
		String skill=wrkProfBean.getSkill();
		String qualification=wrkProfBean.getQualification();
		
		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery ="update work_profile_detail set ";
			
			if(experience==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="experience='"+experience+"',";
				System.out.println("line 2 if " );
			}
			
			if(designation==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="designation='"+designation+"',";
				System.out.println("line 2 if " );
			}
			
			if(skill==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="skill='"+skill+"',";
				System.out.println("line 2 if " );
			}
			
			if(qualification==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="qualification='"+qualification+"',";
				System.out.println("line 2 if " );
			}
			
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where emp_user_id='"+empUserId+"'";
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
		String selectAllQuery="select * from work_profile_detail;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(WorkProfileDetailBean wrkProfDetBean)
	{
		WorkProfileDetailBean wrkProfBean=(WorkProfileDetailBean) wrkProfDetBean;
		String empUserId=wrkProfBean.getEmpUserId();
		String experience=wrkProfBean.getExperience();
		String designation=wrkProfBean.getDesignation();
		String skill=wrkProfBean.getSkill();
		String qualification=wrkProfBean.getQualification();

		String selectQuery="select * from work_profile_detail where 1";
		if(empUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND emp_user_id='"+empUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(experience==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND experience='"+experience+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(designation==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND designation='"+designation+"'";
			System.out.println("line 4 if");
		}
		if(skill==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND skill='"+skill+"'";
			System.out.println("line 4 if");
		}		
		if(qualification==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND qualification='"+qualification+"'";
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
