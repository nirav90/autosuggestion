

<%@page import="assys.com.dbDAO.DraftMaster"%>
<%@page import="assys.com.dbBean.DraftMasterBean"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
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
                    DraftBox</h2>
                <div class="block">
                    
                    <div id="chart1"> 
                    
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>No.</th>
							<th>To</th>
							<th>Subject</th>
							<th>Date</th>
							
						</tr>
					</thead>
					<tbody>
						<%
						
						 
		                    
		                    
		                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
		            		
		            		String sd = (String)session.getAttribute("employee_ID");
		            		
		                    
		                    
		                    
		                    
		     			 
		     			DraftMasterBean  draftMasterBean= new DraftMasterBean();
		     			
		     			draftMasterBean.setEmpUserId(sd);
		     			
		     			DraftMaster draftMaster =new DraftMaster();
		     			
		     		ResultSet rs = draftMaster.select(draftMasterBean);
		     			
		            
		     		
		     		int i= 1;
		     		
		     		while(rs.next())
		     		{	
		                    
		     		
		     			
		                %>
						
					
						
						<tr class="gradeA">
						
							<td><%=(i++) %></td>
								
							<td><%=rs.getString("email_id") %></td>
								
							<td><s:url action="manager_draft_detail_jsp" var="urlTag" >
    									<s:param name="draftId"><%=rs.getString("draft_id") %></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString("draft_subject")%></a></td>
									
							<td><%=rs.getString("createdDate") %></td>
							
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
