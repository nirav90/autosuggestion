<%@page import="assys.com.dbDAO.ClientDetails"%>
<%@page import="assys.com.dbBean.ClientDetailsBean"%>

<%@page import="java.util.Random"%>
<%@page import="java.sql.ResultSet"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> client </h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    	
                    
                    <s:div cssClass="message info">
                             
                             
                            <b>Add new client click here</b> 
                            <s:form cssClass="form" action="manager_add_client_jsp" method="post">
							<tr>
							<td>
							<s:submit  value=" Add client" cssClass=" btn-grey btn-person" theme="simple"></s:submit>
							</td>
							</tr>
							</s:form>
							
							<b>Show Status of Requested ClientID Generated or not</b> 
							<s:form cssClass="form" action="manager_add_client_status_jsp" method="post">
							<tr>
							<td>
							<s:submit  value="Show Requested ClientID" cssClass=" btn-grey btn-person" theme="simple"></s:submit>
							</td>
							</tr>
							</s:form>
							
                            </s:div>	
                    	
                    	
					
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>Client Name</th>
							<th>Company Name</th>
							<th>Phone</th>
							<th>Company Address</th>
							
							
					</tr>
					</thead>
					<tbody>
					
						
						<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    
                    
                    ClientDetailsBean clientDetailsBean = new ClientDetailsBean();
                    ClientDetails clientDetails = new ClientDetails();
                    
                    ResultSet rs =clientDetails.select(clientDetailsBean);
                    
                    int i = 1;
                    while(rs.next())
                    { 	
                    
					%>
					
									
				
					
					<tr class="gradeA">
						<td><%= i++ %></td>
						<td><%= rs.getString(2) %></td>
						<td><%= rs.getString(5) %></td>
						<td><%= rs.getString(4) %></td>
						<td><%= rs.getString(6) %></td>
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

