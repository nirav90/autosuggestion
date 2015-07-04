<%@page import="assys.com.dbDAO.LeaveMaster"%>
<%@page import="assys.com.dbBean.LeaveMasterBean"%>
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



<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> leaves</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    	
                    <%-- <jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean" />
							
							<jsp:setProperty name="ContactDetailMasterBean" property="contactId" value="nirav" /> --%>
					<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    String sd = (String)session.getAttribute("employee_ID");
                    
                    
                    LeaveMasterBean leaveMasterBean = new LeaveMasterBean();
                    
                    LeaveMaster leaveMaster = new LeaveMaster();
                    
                    
                    /* leaveMasterBean.setLeaveApprove(false); */
                    ResultSet rs  =   leaveMaster.selectAll();
                    
                     
                    int i = 0;
                    
                    
                    %>
                    <table class="data display datatable" >
					<thead>
					<tr>
							<th>No</th>
							<th>From</th>
							<th>subject</th>
							<th>From Date</th>
							<th>To Date</th>
							<th>Status</th>
							
							
					
							 
					</tr>
					</thead>
					<tbody>
					
					<% 
                    while(rs.next())
                    {
                    	
                    	i++;
                    
					%>
					<% 

						if(rs.getString(5).equals("Emergency Leave"))
							
						{
					
					%>
					
					<tr >
					<td><%= i %></td>
					<%
							if(rs.getBoolean("leave_approve") && rs.getBoolean("isSeen"))					
							{
					%>
					<td><s:url action="leaveApproveDetail_jsp" var="urlTag" >
    							<s:param name="empID"><%=rs.getString(2)+"-"+rs.getString(1) %></s:param>
    							<s:param name="leaveID"><%=rs.getString(2) %></s:param>
    					</s:url>
						<a href="<s:property value="#urlTag" />" ><%=rs.getString(3)%></a></td>
					
					
					<td style="background-color: #FF9999;"><%= rs.getString(5) %></td>
					<td ><%= rs.getDate(7) %></td>
					<td><%= rs.getDate(8) %></td>
					
					
					
					<td  style="background-color:#66FF99; text-align: center;">Approved</td>
					
					<%
							}
						
							else if(!rs.getBoolean("leave_approve") && rs.getBoolean("isSeen"))
							{	
					%>
					<td><s:url action="leaveApproveDetail_jsp" var="urlTag" >
    							<s:param name="empID"><%=rs.getString(2)+"-"+rs.getString(1) %></s:param>
    							<s:param name="leaveID"><%=rs.getString(2) %></s:param>
    					</s:url>
						<a href="<s:property value="#urlTag" />" ><%=rs.getString(3)%></a></td>
					
					
					<td style="background-color: #FF9999;"><%= rs.getString(5) %></td>
					<td ><%= rs.getDate(7) %></td>
					<td><%= rs.getDate(8) %></td>
					<td  style="background-color:red; text-align: center;">Disapproved</td>
					
					<% 		}
							else if(!rs.getBoolean("isSeen"))
							{	
					%>
					<td><s:url action="leaveDetail_jsp" var="urlTag" >
    							<s:param name="empID"><%=rs.getString(2)+"-"+rs.getString(1) %></s:param>
    							<s:param name="leaveID"><%=rs.getString(2) %></s:param>
    					</s:url>
						<a href="<s:property value="#urlTag" />" ><%=rs.getString(3)%></a></td>
					
					
					<td style="background-color: #FF9999;"><%= rs.getString(5) %></td>
					<td ><%= rs.getDate(7) %></td>
					<td><%= rs.getDate(8) %></td>
					<td  style="background-color:#c0c0c0; text-align: center;">Pending</td>
					</tr>
					<%
							}
						}
						else
						{	
					
					%>
					<tr >
					<td><%= i %></td>
					<%
							if(rs.getBoolean("leave_approve") && rs.getBoolean("isSeen"))					
							{
					%>
					
					<td><s:url action="leaveApproveDetail_jsp" var="urlTag" >
    									<s:param name="empID"><%=rs.getString(2)+"-"+rs.getString(1) %></s:param>
    									<s:param name="leaveID"><%=rs.getString(2) %></s:param>
    									
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString(3)%></a></td>
					
					<td><%= rs.getString(5) %></td>
					<td><%= rs.getDate(7) %></td>
					<td><%= rs.getDate(8) %></td>
					
					
					
					
					<td  style="background-color:#66FF99; text-align: center;border-color: black; border-style: solid;">Approved</td>
					
					<%
							}
							else if(!rs.getBoolean("leave_approve") && rs.getBoolean("isSeen"))
							{	
					%>
					<td><s:url action="leaveApproveDetail_jsp" var="urlTag" >
    									<s:param name="empID"><%=rs.getString(2)+"-"+rs.getString(1) %></s:param>
    									<s:param name="leaveID"><%=rs.getString(2) %></s:param>
    									
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString(3)%></a></td>
					
					<td><%= rs.getString(5) %></td>
					<td><%= rs.getDate(7) %></td>
					<td><%= rs.getDate(8) %></td>
					<td  style="background-color:red; text-align: center;">Disapproved</td>
					
					<%  	}
							else if(!rs.getBoolean("isSeen"))
							{
						%>
						<td><s:url action="leaveDetail_jsp" var="urlTag" >
    									<s:param name="empID"><%=rs.getString(2)+"-"+rs.getString(1) %></s:param>
    									<s:param name="leaveID"><%=rs.getString(2) %></s:param>
    									
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString(3)%></a></td>
					
					<td><%= rs.getString(5) %></td>
					<td><%= rs.getDate(7) %></td>
					<td><%= rs.getDate(8) %></td>
					<td  style="background-color:#c0c0c0; text-align: center;">Pending</td>
					</tr>
					
					<%
							}
						}	
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

