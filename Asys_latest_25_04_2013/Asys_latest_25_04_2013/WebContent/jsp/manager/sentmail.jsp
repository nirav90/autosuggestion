

<%@page import="assys.com.dbDAO.SentMailMaster"%>
<%@page import="assys.com.dbBean.SentMailMasterBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.InboxMaster"%>
<%@page import="assys.com.dbBean.InboxMasterBean"%>
<%@ page language="java" import="demo.MessageInfo" %>
<%@ page errorPage="errorpage.jsp" %>

<%@ taglib uri="/WEB-INF/lib/taglib.jar"
    prefix="javamail" %>
    
 <%@ taglib prefix="s" uri="/struts-tags" %>   
<jsp:useBean id="mailuser" scope="session" class="assys.com.gmail.MailUserBean" />



<div class="grid_10">
            <div class="box round first1 ">
                <h2>
                    Inbox</h2>
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
		            		
		     			 
		     			SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
		     			
		     			
		     			sentMailMasterBean.setEmpUserId(sd);
		     			
		     			
		     			SentMailMaster sentMailMaster = new SentMailMaster();
		     			
		     			
		     		ResultSet rs = sentMailMaster.select(sentMailMasterBean);
		     			
		            
		     		
		     		int i= 1;
		     		
		     		while(rs.next())
		     		{	
		                    
		                
		                %>
						
						
						<tr class="gradeA">
							<td><%=(i++) %></td>
								
								
							<td><%=rs.getString(4) %></td>
									
									
									
									
							<td><s:url action="manager_sent_detail_jsp" var="urlTag" >
    									<s:param name="sentId"><%=rs.getString("sent_id") %></s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString("email_subject")%></a></td>
							
							<td><%=rs.getString(6) %></td>
							
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
