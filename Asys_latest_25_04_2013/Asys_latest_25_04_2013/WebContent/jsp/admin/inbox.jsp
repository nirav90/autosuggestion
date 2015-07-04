

<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.InboxMaster"%>
<%@page import="assys.com.dbBean.InboxMasterBean"%>
<%@ page language="java" import="demo.MessageInfo" %>
<%@ page errorPage="errorpage.jsp" %>

<%@ taglib uri="/WEB-INF/lib/taglib.jar"
    prefix="javamail" %>
<jsp:useBean id="mailuser" scope="session" class="assys.com.gmail.MailUserBean" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="grid_10">
            <div class="box round first1 ">
                <h2>
                    Inbox</h2>
                <div class="block">
                    
                    
                    
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>No.</th>
							<th>From</th>
							<th>Subject</th>
							<th>Date</th>
							
						</tr>
					</thead>
					<tbody>
						<%
						
						 
		                    
		                    
		                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
		            		
		            		String sd = (String)session.getAttribute("employee_ID");
		            		
		                    
		                    
		                    
		                    
		     			 
		     			InboxMasterBean inboxMasterBean = new InboxMasterBean();
		     			
		     			inboxMasterBean.setEmpUserId(sd);
		     			
		     			InboxMaster inboxMaster = new InboxMaster();
		     			
		     			
		     		ResultSet rs = inboxMaster.select(inboxMasterBean);
		     			
		            
		     		
		     		int i= 1;
		     		
		     		while(rs.next())
		     		{	
		                    
		     		
		     			
		                %>
						
					
						
						<tr class="gradeA">
						
							<td><%=(i++) %></td>
							<td><%=rs.getString("sender_email_id") %></td>	
								
							<td><s:url action="admin_content_jsp" var="urlTag" >
    									<s:param name="mailNo"><%=rs.getString(6) %></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString(4)%></a></td>
									
							<td><%=rs.getString(5) %></td>
							
						</tr>
						
						<%
						}
						%>
					</tbody>
				</table>
                    
                    
                    
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="clear">
    </div>
