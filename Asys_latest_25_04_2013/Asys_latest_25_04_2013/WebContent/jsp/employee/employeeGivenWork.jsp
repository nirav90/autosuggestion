

<%@page import="assys.com.dbDAO.WorkSubmitMaster"%>
<%@page import="assys.com.dbBean.WorkSubmitMasterBean"%>
<%@page import="assys.com.dbDAO.AssignWorkMaster"%>
<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="assys.com.dbDAO.SentMailMaster"%>
<%@page import="assys.com.dbBean.SentMailMasterBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.InboxMaster"%>
<%@page import="assys.com.dbBean.InboxMasterBean"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
<%@ page language="java" import="demo.MessageInfo" %>
<%@ page errorPage="errorpage.jsp" %>


<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">


setTimeout(function() {
	
	
    $('#mydiv').fadeOut('slow');
}, 3000);



</script>

<div class="grid_10">
            <div class="box round first1 ">
                <h2>
                    Submit Work</h2>
                   
                <div class="block">
                   <h6><font color="green"><b> You can submit your work by just clicking on WORK ID</b></font></h6> 
                    <div id="chart1"> 
                    <%

			String s = (String)request.getAttribute("workSubmit");
			

			if(s==null)
			{
			}
			else{
%>
<div id="mydiv" class="message success"><center><b>Your Work has been Sent Successfully</b></center></div>
<%} %>
                    
						<%
						
						 
		                    
		                    
		                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
		            		
		            		String sd = (String)session.getAttribute("employee_ID");
		                    		                    
		            		GmailAuthentication gmailAuthentication=new GmailAuthentication();
		            		
		            		GmailAuthenticationBean gmailAuthenticationBean=new GmailAuthenticationBean();
		            		
		            		gmailAuthenticationBean.setEmpUserId(sd);
		            		
		            		ResultSet rs=gmailAuthentication.select(gmailAuthenticationBean);
		            		String email_id=null;
		            		while(rs.next()){
		            			email_id=rs.getString("gmail_email_id");
		            		}
		            		
		            		AssignWorkMasterBean assignWorkMasterBean = new AssignWorkMasterBean();
		            		AssignWorkMaster assignWorkMaster = new AssignWorkMaster();
		            		WorkSubmitMaster workSubmitMaster=new WorkSubmitMaster();
		            		WorkSubmitMasterBean workSubmitMasterBean=new WorkSubmitMasterBean();
		            		assignWorkMasterBean.setWorkApprove(false);             
		                    assignWorkMasterBean.setReciptanceEmailId(email_id);
		                    ResultSet rs1 = assignWorkMaster.select(assignWorkMasterBean);
		     			
		                    
		     			
		     		
	%>
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>Work Id</th>
							<th>From</th>
							<th>Subject</th>
							<th>Work Starting Time</th>
							<th>Duration</th>
							
							
					</tr>
					</thead>
					<tbody>
					<%     		
					int i= 1;
					while(rs1.next())
					{	
						String workId=rs1.getString("work_id");
						workSubmitMasterBean.setWorkId(workId);
						ResultSet rs2=workSubmitMaster.select(workSubmitMasterBean);
						if(rs2.next()){
							
						}
						else{
							
						
					 %>
						
						
						<tr >
							<td><%=(i++) %></td>
							<%-- <td><%=rs1.getString("work_id") %></td> --%>
							<td><s:url action="employee_work_submit_jsp" var="urlTag" >
    							<s:param name="workID"><%=rs1.getString("work_id")+"-"+rs1.getString("sender_email_id") %></s:param>
    							</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs1.getString("work_id")%></a>
							</td>
							<td><%=rs1.getString("sender_email_id") %></td>
							<td><%=rs1.getString("work_msg_subject") %></td>
							<td><%=rs1.getString("starting_date_time") %></td>
							<td><%=rs1.getString("duration") %></td>
							
							
						</tr>
						
						<%
							}
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
