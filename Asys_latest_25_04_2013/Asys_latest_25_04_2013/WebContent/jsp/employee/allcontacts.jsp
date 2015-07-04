<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.ContactDetailMaster"%>
<%@page import="assys.com.dbDAO.ContactEmailDetail"%>
<%@page import="assys.com.dbDAO.ContactPhoneNoDetail"%>
<%@page import="assys.com.dbBean.ContactDetailMasterBean"%>
<%@page import="assys.com.dbBean.ContactEmailDetailBean"%>
<%@page import="assys.com.dbBean.ContactPhoneNoDetailBean"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="assys.com.joinQuery.ShowContacts"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%! public int i; %>
<script language="javascript" type="text/javascript">
	
					</script>
<script>
setTimeout(function() {
	
	
    $('#mydiv').fadeOut('slow');
}, 3000);

</script>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Contacts</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <% 
                    
                    String success=(String) request.getAttribute("success");
                    if(success!=null){
                    	%>
                    	<div id="mydiv" class="message success"><b>Contact Added Successfully</b></div>
                    	<% 
                    }
                    
                    String deleted=(String) request.getAttribute("deleteSuccess");
                    if(deleted!=null){
                    	%>
                    	<div id="mydiv" class="message success"><b>Contact Deleted Successfully</b></div>
                    	<% 
                    }
                    %>
                    <%-- <jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean" />
							
							<jsp:setProperty name="ContactDetailMasterBean" property="contactId" value="nirav" /> --%>
					<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    	
                    	
						String sd = (String)session.getAttribute("employee_ID");
						
						ShowContacts showContacts=new ShowContacts();
						//out.print(sd);
						ResultSet rs3=showContacts.selectContacts(sd);
						
						
					%>
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Phone</th>
							<th>EmailID</th>
							<th></th>
							
					</tr>
					</thead>
					<tbody>
					<%
						i=1;
						
						
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
									
									String contactIdRs=rs3.getString("contact_id");
									String contactFirstName=rs3.getString("contact_first_name");
									//out.print(contactIdRs);
									request.setAttribute("contactId1", contactIdRs);
									request.setAttribute("contactFirstName",contactFirstName);
					%>
					
					<tr class="gradeA">
					<td><%=(i++) %>
					<%-- <input type="checkbox" name="<%=i %>" id="<%=i %>" value="<%=i %>" onclick="return chkDemo()"/> --%>
					</td>
					
					<td><%= rs3.getString("contact_first_name") %></td>
					<td><%= rs3.getString("contact_last_name") %></td>
					<td><%= rs3.getString("contact_phone_no") %></td>
					<td><%= rs3.getString("contact_email_id") %></td>
					<td>
					<s:form action="employee_contact_detail_click">
					<s:hidden value="%{#request.contactId1}" name="contactDetailMasterBean.contactId"></s:hidden>
					<s:submit value="Show" name="Show" ></s:submit>
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
					<td><input type="hidden" value="%{#request.contactId}"  name="contactDetailMasterBean.contactId" /></td><td></td><td></td>
					</tr> -->
					<tr><%-- <input type="hidden" value="<%=i-1 %>" name="hiddenI" id="hiddenI"/> --%></tr>
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

