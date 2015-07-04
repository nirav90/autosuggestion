<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.joinQuery.showEmployeeDetail"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@page import="assys.com.dbBean.ClientIdGeneratorBean"%>
<%@page import="assys.com.dbDAO.ClientIdGenerator"%>
<%@page import="assys.com.dbBean.AuthenticationDetailBean"%>
<%@page import="assys.com.dbDAO.AuthenticationDetail"%>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Status:Client ID Generated</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    	
                    <%-- <jsp:useBean id="Contact_detail_master_bean"  class="assys.com.dbBean.Contact_detail_master_bean" />
							
							<jsp:setProperty name="Contact_detail_master_bean" property="contactId" value="nirav" /> --%>
					<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    	
						String sd = (String)session.getAttribute("employee_ID");
						
						ClientIdGeneratorBean clientIdGeneratorBean = new ClientIdGeneratorBean();
						ClientIdGenerator  clientIdGenerator = new ClientIdGenerator();
						AuthenticationDetail authenticationDetail=new AuthenticationDetail();
						AuthenticationDetailBean authenticationDetailBean=new AuthenticationDetailBean();
						clientIdGeneratorBean.setIdGenerated(true);
						clientIdGeneratorBean.setProjectCompleted(false);
						clientIdGeneratorBean.setProjectManagerId(sd);
						ResultSet rs3=clientIdGenerator.select(clientIdGeneratorBean);
						
					%>
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>Client Name</th>
							<th>Project Manager UserName</th>
							<th>Client Company</th>
							<th></th>
							
							
					</tr>
					</thead>
					<tbody>
					<%
						int i=1;
	
								while(rs3.next())
								{	
									
									String projectMngId=rs3.getString("project_manager_id");
									String clnName=rs3.getString("client_name");
									String clnCompanyName=rs3.getString("client_company_name");
									String clnId=rs3.getString("client_id");
									authenticationDetailBean.setEmpUserId(projectMngId);
									ResultSet rs2=authenticationDetail.select(authenticationDetailBean);
									request.setAttribute("clnId",clnId);
									request.setAttribute("clientName1",clnName);
									request.setAttribute("clientCompanyName1",clnCompanyName);
									request.setAttribute("projectManagerId1",projectMngId);
									while(rs2.next()){
										String username=rs2.getString("user_name");
										request.setAttribute("username1",username);
					%>
					
					<tr class="gradeA">
					
					<td><%=i++ %></td>
					<td><%= rs3.getString("client_name") %></td>
					<td><%= rs2.getString("user_name") %></td>
					<td><%= rs3.getString("client_company_name") %></td>
					<%-- <td><s:form><s:label value="%{#request.clientName}" name=""></s:label></s:form></td>
					<td><s:form><s:label value="%{#request.username}" name=""></s:label></s:form></td>
					<td><s:form><s:label value="%{#request.clientCompanyName}" name=""></s:label></s:form></td> --%>
					<td>
					
					<s:form action="manager_client_id_show_click">
					<s:hidden value="%{#request.clientName1}" name="clientIdGeneratorBean.clientName"></s:hidden>
					<s:hidden value="%{#request.clnId}" name="clientIdGeneratorBean.clientId"></s:hidden>
					<s:hidden value="%{#request.clientCompanyName1}" name="clientIdGeneratorBean.clientCompanyName"></s:hidden>
					<s:hidden value="%{#request.projectManagerId1}" name="clientIdGeneratorBean.projectManagerId"></s:hidden>
					<s:submit value="Show" name="Show" ></s:submit>
					</s:form>
					</td>
					
					</tr>
					
					
					<%
									}		
						}
					%>
					
					</tbody>
					<!-- <tr>
					<td><input type="hidden" value="%{#request.contactId}"  name="contact_detail_master_bean.contactId" /></td><td></td><td></td>
					</tr> -->
					<tr><input type="hidden" value="<%=i-1 %>" name="hiddenI" id="hiddenI"/></tr>
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





<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Status:Waiting</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    	
                    <%-- <jsp:useBean id="Contact_detail_master_bean"  class="assys.com.dbBean.Contact_detail_master_bean" />
							
							<jsp:setProperty name="Contact_detail_master_bean" property="contactId" value="nirav" /> --%>
					<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    	
						String sd = (String)session.getAttribute("employee_ID");
						
						ClientIdGeneratorBean clientIdGeneratorBean = new ClientIdGeneratorBean();
						ClientIdGenerator  clientIdGenerator = new ClientIdGenerator();
						AuthenticationDetail authenticationDetail=new AuthenticationDetail();
						AuthenticationDetailBean authenticationDetailBean=new AuthenticationDetailBean();
						clientIdGeneratorBean.setIdGenerated(false);
						clientIdGeneratorBean.setProjectCompleted(false);
						clientIdGeneratorBean.setProjectManagerId(sd);
						ResultSet rs3=clientIdGenerator.select(clientIdGeneratorBean);
						
					%>
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>Client Name</th>
							<th>Project Manager UserName</th>
							<th>Client Company</th>
							
							
							
					</tr>
					</thead>
					<tbody>
					<%
						int i=1;
	
								while(rs3.next())
								{	
									
									String projectMngId=rs3.getString("project_manager_id");
									String clnName=rs3.getString("client_name");
									String clnCompanyName=rs3.getString("client_company_name");
									authenticationDetailBean.setEmpUserId(projectMngId);
									ResultSet rs2=authenticationDetail.select(authenticationDetailBean);
									request.setAttribute("clientName1",clnName);
									request.setAttribute("clientCompanyName1",clnCompanyName);
									request.setAttribute("projectManagerId1",projectMngId);
									while(rs2.next()){
										String username=rs2.getString("user_name");
										request.setAttribute("username1",username);
					%>
					
					<tr class="gradeA">
					
					<td><%=i++ %></td>
					<td><%= rs3.getString("client_name") %></td>
					<td><%= rs2.getString("user_name") %></td>
					<td><%= rs3.getString("client_company_name") %></td>
					<%-- <td><s:form><s:label value="%{#request.clientName}" name=""></s:label></s:form></td>
					<td><s:form><s:label value="%{#request.username}" name=""></s:label></s:form></td>
					<td><s:form><s:label value="%{#request.clientCompanyName}" name=""></s:label></s:form></td> --%>
					</tr>
					
					
					<%
									}		
						}
					%>
					
					</tbody>
					<!-- <tr>
					<td><input type="hidden" value="%{#request.contactId}"  name="contact_detail_master_bean.contactId" /></td><td></td><td></td>
					</tr> -->
					<tr><input type="hidden" value="<%=i-1 %>" name="hiddenI" id="hiddenI"/></tr>
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

