package assys.com.dbDAO;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import assys.com.DAO.DBConnection;


import assys.com.dbBean.ProjectDetailBean;



/**
 * @author Slesha
 *
 */

public class ProjectDetail {
	
	public Statement stm = null;
	public Connection conn = null;
	DBConnection con = new DBConnection();
	public ResultSet rs=null;
	
	Date date = new Date();
	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DateFormat dateFormate=new SimpleDateFormat("yyyy-MM-dd");
	InetAddress ip;
	String flag="false";
	
	public String insert(ProjectDetailBean prjDetBean)
	{
		ProjectDetailBean projDetBean=(ProjectDetailBean) prjDetBean;
		String clientEmpUserId=projDetBean.getClientEmpUserId();
		String projectManagerEmpUserId=projDetBean.getProjectManagerEmpUserId();
		String projectId=projDetBean.getProjectId();
		String projectName=projDetBean.getProjectName();
		String clientName=projDetBean.getClientName();
		String projectDesc=projDetBean.getProjectDesc();
		String startingDateOfProject=projDetBean.getStartingDateOfProject();
		String endDateOfProject=projDetBean.getEndDateOfProject();
		

		try{
			ip=InetAddress.getLocalHost();

			
			String str1 ="insert into project_detail(client_emp_user_id,project_manager_emp_user_id,project_id";
			String value1=" values('"+clientEmpUserId+"','"+projectManagerEmpUserId+"','"+projectId+"',";
			
			if(projectName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",project_name";
				value1+="'"+projectName+"',";
				System.out.println("line 2 if " );
			}
			
			if(clientName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",client_name";
				value1+="'"+clientName+"',";
				System.out.println("line 2 if " );
			}

			if(projectDesc==null)
			{
					
			}else{
				System.out.println("line 1 if");
				str1+=",project_desc";
				value1+="'"+projectDesc+"',";
				System.out.println("line 2 if " );
			}

			if(startingDateOfProject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				Date startingDateOfProject1 = dateFormate.parse(startingDateOfProject);
				str1+=",starting_date_of_project";
				value1+="'"+dateFormate.format(startingDateOfProject1)+"',";
				System.out.println("line 2 if " );
			}

			if(endDateOfProject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				Date endDateOfProject1 = dateFormate.parse(endDateOfProject);
				str1+=",end_date_of_project";
				value1+="'"+dateFormate.format(endDateOfProject1)+"',";
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
	
	public String delete(ProjectDetailBean prjDetBean)
	{
		ProjectDetailBean projDetBean=(ProjectDetailBean) prjDetBean;
		String projectId=projDetBean.getProjectId();
		try{
			ip=InetAddress.getLocalHost();
			String deleteQuery="update project_detail set isDeleted=1,modifyDate='"+ dateFormat.format(date)+"',ip='"+ ip.getHostAddress() +"' where project_id='"+projectId+"'";
			int lineDeleted=executeQueries(deleteQuery);
			System.out.println("line affected"+lineDeleted);
		}
		catch(Exception e)
		{
				
			System.out.println(e.toString());
		}
		
		return flag;
	}
	
	public String update(ProjectDetailBean prjDetBean)
	{
		ProjectDetailBean projDetBean=(ProjectDetailBean) prjDetBean;
		String projectId=projDetBean.getProjectId();
		String projectName=projDetBean.getProjectName();
		String clientName=projDetBean.getClientName();
		String projectDesc=projDetBean.getProjectDesc();
		String startingDateOfProject=projDetBean.getStartingDateOfProject();
		String endDateOfProject=projDetBean.getEndDateOfProject();
		

		try{
			ip=InetAddress.getLocalHost();

			
			String updateQuery ="update project_detail set ";
			
			if(projectName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="project_name='"+projectName+"',";
				System.out.println("line 2 if " );
			}
			
			if(clientName==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="client_name='"+clientName+"',";
				System.out.println("line 2 if " );
			}

			if(projectDesc==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="project_desc='"+projectDesc+"',";
				System.out.println("line 2 if " );
			}

			if(startingDateOfProject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="starting_date_of_project='"+dateFormate.format(startingDateOfProject)+"',";
				System.out.println("line 2 if " );
			}

			if(endDateOfProject==null)
			{
					
			}else{
				System.out.println("line 1 if");
				updateQuery+="end_date_of_project='"+endDateOfProject+"',";
				System.out.println("line 2 if " );
			}
			
			updateQuery+="ip='"+ ip.getHostAddress() +"',modifyDate='"+ dateFormat.format(date) +"' where project_id='"+projectId+"'";
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
		String selectAllQuery="select * from project_detail;";
		rs=executeSelect(selectAllQuery);
		return rs;
	}

	public ResultSet select(ProjectDetailBean prjDetBean)
	{
		ProjectDetailBean projDetBean=(ProjectDetailBean) prjDetBean;
		String clientEmpUserId=projDetBean.getClientEmpUserId();
		String projectManagerEmpUserId=projDetBean.getProjectManagerEmpUserId();
		String projectId=projDetBean.getProjectId();
		String projectName=projDetBean.getProjectName();
		String clientName=projDetBean.getClientName();
		String projectDesc=projDetBean.getProjectDesc();
		String startingDateOfProject=projDetBean.getStartingDateOfProject();
		String endDateOfProject=projDetBean.getEndDateOfProject();

		String selectQuery="select * from project_detail where 1";
		if(clientEmpUserId==null)
		{
			System.out.println("emp_no:ja ja");
		}
		else
		{
			selectQuery+=" AND client_emp_user_id='"+clientEmpUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(projectManagerEmpUserId==null)
		{
			System.out.println("name:ja ja");
		}
		else
		{
			selectQuery+=" AND project_manager_emp_user_id='"+projectManagerEmpUserId+"'";
			System.out.println("inside if 1"+selectQuery);
		}
		if(projectId==null)
		{
			System.out.println("phone:ja ja");;				
		}
		else{			
			System.out.println("line 3 if");
			selectQuery+=" AND project_id='"+projectId+"'";
			System.out.println("line 4 if");
		}
		if(projectName==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND project_name='"+projectName+"'";
			System.out.println("line 4 if");
		}		
		if(clientName==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND client_name='"+clientName+"'";
			System.out.println("line 4 if");
		}
		if(projectDesc==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND project_desc='"+projectDesc+"'";
			System.out.println("line 4 if");
		}
		if(startingDateOfProject==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND starting_date_of_project='"+startingDateOfProject+"'";
			System.out.println("line 4 if");
		}
		if(endDateOfProject==null)
		{
			System.out.println("address:ja ja");
		}
		else{				
			System.out.println("line 3 if");
			selectQuery+=" AND end_date_of_project='"+endDateOfProject+"'";
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
