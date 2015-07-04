<%@page import="assys.com.dbDAO.ClientDetails"%>
<%@page import="assys.com.dbBean.ClientDetailsBean"%>
<%@page import="assys.com.dbBean.ProjectDetailBean"%>
<%@page import="assys.com.dbDAO.ProjectDetail"%>
<%@page import="java.util.Random"%>
<%@page import="java.sql.ResultSet"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Project Information </h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    	
                    
					
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>Client Name</th>
							<th>Project Name</th>
							<th>Starting Date of Project</th>
							<th>Ending Date of Project</th>
							
							
					</tr>
					</thead>
					<tbody>
					
						
						<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    
                    ProjectDetailBean projectDetailBean=new ProjectDetailBean();
					ProjectDetail projectDetail=new ProjectDetail();


					ResultSet rs1=projectDetail.select(projectDetailBean);
                    ClientDetailsBean clientDetailsBean = new ClientDetailsBean();
                    ClientDetails clientDetails = new ClientDetails();
                    
                    //ResultSet rs =clientDetails.select(clientDetailsBean);
                    
                    int i = 1;
                    while(rs1.next())
                    { 	
                    
					%>
					
									
				
					
					<tr class="gradeA">
						<td><%= i++ %></td>
						<td><%= rs1.getString("client_name") %></td>
						<td><%= rs1.getString("project_name") %></td>
						<td><%= rs1.getString("starting_date_of_project") %></td>
						<td><%= rs1.getString("end_date_of_project") %></td>
					</tr>
					
					<%
					
                    }
					%>
					
					
					</tbody>
					
				</table>
				<s:div name="div_content">
		
					</s:div>
					<script>
					function load_content()
            			{
                			$("#div_content").css('background-color', 'black');
                		}	
					</script>

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

