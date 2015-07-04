<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.joinQuery.showEmployeeDetail"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Assign Work to Employee As per their Skills</h2>
                <s:div cssClass="block">
                <h6 style="color:green"><b>Select an employee whom you want to assign a work as per their skills</b></h6>
                
                    <s:div id="chart1">
                    	
                    <%-- <jsp:useBean id="Contact_detail_master_bean"  class="assys.com.dbBean.Contact_detail_master_bean" />
							
							<jsp:setProperty name="Contact_detail_master_bean" property="contactId" value="nirav" /> --%>
					<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    	
						String sd = (String)session.getAttribute("employee_ID");
						
						showEmployeeDetail showContacts=new showEmployeeDetail();
						//out.print(sd);
						ResultSet rs3=showContacts.selectEmployee("Employee");
						
					%>
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>Name</th>
							<th>Email ID</th>
							<th>User Name</th>
							<th>Skills</th>
							<th></th>
							
					</tr>
					</thead>
					<tbody>
					<%
						int i=1;
						
						
					/*
						while(rs.next() && rs1.next() && rs2.next()) 
						{
							String contactIdRs=rs.getString("contact_id");
							String contactIdRs1=rs1.getString("contact_id");
							String contactIdRs2=rs2.getString("contact_id");
							if(contactIdRs.equals(contactIdRs1) && contactIdRs.equals(contactIdRs2) && contactIdRs1.equals(contactIdRs2))
							{
								request.setAttribute("contactId", contactIdRs);
								*/
								while(rs3.next())
								{	
									
									String contactIdRs=rs3.getString("emp_user_id");
									String contactFirstName=rs3.getString("first_name");
									//out.print(contactIdRs);
									request.setAttribute("contactId1", contactIdRs);
									request.setAttribute("contactFirstName",contactFirstName);
					%>
					
					<tr class="gradeA">
					<%-- <td><%=(i++) %>
					<input type="checkbox" name="<%=i %>" id="<%=i %>" value="<%=i %>" onclick="return chkDemo()"/>
					</td> --%>
					<td><%=i++ %></td>
					<%--<td><%= rs3.getString("first_name") %></td>--%>
					
					<td><s:url action="manager_give_work_jsp" var="urlTag" >
    							<s:param name="emailId"><%= rs3.getString("gmail_email_id") %></s:param>
						</s:url>
						<a href="<s:property value="#urlTag" />" ><%= rs3.getString("first_name")+" "+rs3.getString("last_name") %></a>
					</td>
					<%--<td><%= rs3.getString("last_name") %></td>--%>
					<td><%= rs3.getString("gmail_email_id") %></td>
					<td><%= rs3.getString("user_name") %></td>
					<td><%= rs3.getString("skill") %></td>
					<td>
					<s:form action="employee_contact_detail_click">
					<%-- <s:hidden value="%{#request.contactId1}" name="contact_detail_master_bean.contactId"></s:hidden>
					<s:submit value="Show" name="Show" ></s:submit> --%>
					</s:form>
					</td>
					<%-- <td><img src="${pageContext.request.contextPath}/img/delete-button.png"></img></td> --%>
					<!-- <td></td><td></td> -->
					</tr>
					
					
					<%
							
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

