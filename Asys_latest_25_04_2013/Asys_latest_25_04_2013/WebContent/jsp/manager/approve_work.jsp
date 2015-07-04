

<%@page import="assys.com.dbDAO.WorkSubmitMaster"%>
<%@page import="assys.com.dbBean.WorkSubmitMasterBean"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
<%@page import="assys.com.dbDAO.AssignWorkMaster"%>
<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="assys.com.dbDAO.SentMailMaster"%>
<%@page import="assys.com.dbBean.SentMailMasterBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.InboxMaster"%>
<%@page import="assys.com.dbBean.InboxMasterBean"%>
<%@page import="assys.com.joinQuery.SelectQuery"%>
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
                    Assigned Work</h2>
                <div class="block">
                    
                    <div id="chart1"> 
                    <%

			String s = (String)request.getAttribute("name");
			

			if(s==null)
			{
			}
			else{
%>

<!-- <div style="color: blue;font-size: 20px;text-align: center;">Mail Sent Successfully..</div> -->

<div id="mydiv" class="message success"><center><b>Work Successfully Approved</b></center></div>

<%} %>
<%

			String s1 = (String)request.getAttribute("name1");
			

			if(s1==null)
			{
			}
			else{
%>

<!-- <div style="color: blue;font-size: 20px;text-align: center;">Mail Sent Successfully..</div> -->

<div id="mydiv" class="message success"><center><b>Work has been Disapproved</b></center></div>

<%} %>
                    
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>No.</th>
							<th>Work Id</th>
							<th>From</th>
							<th>Work Subject</th>
							<th>Send Date</th>
							<!-- <th>Approve</th>
							<th>Disapprove</th> -->
							
						</tr>
					</thead>
					<tbody>
						<%
						
						 
		                    
		                    
		                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
		            		
		            		String sd = (String)session.getAttribute("employee_ID");
		            		
		     			 
		                    String userName=null;
		     	
		            		GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
		            		
		            		GmailAuthentication gmailAuthentication = new GmailAuthentication();
		            		
		                    
		            		gmailAuthenticationBean.setEmpUserId(sd);
		            		
		            		
		            	ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
		            		
		            		while(rs.next())
		            		{
		            			userName= rs.getString(3);
		            			
		            		}
		            		
		            		
		                    
		            		WorkSubmitMasterBean workSubmitMasterBean = new WorkSubmitMasterBean();
		            		
		            		workSubmitMasterBean.setReciptanceEmailId(userName);
		            		
		                    WorkSubmitMaster workSubmitMaster = new WorkSubmitMaster();
		                    
		                    
		                    String query="select * from work_submit_master where 1 AND reciptance_email_id='"+userName+"' AND work_approve=0 AND isSeen=0 AND isDeleted=0;";
		                    SelectQuery selectQuery=new SelectQuery();
		                     ResultSet rs1 = selectQuery.executeSelect(query);
		     			
		                    
		     			
		     		int i= 1;
	
		     		while(rs1.next())
		     		{	
		                    
		                
		                %>
						
						
						<tr >
							<td><%=(i++) %></td>
							
								<td><s:url action="manager_approve_work_detail_jsp" var="urlTag" >
    									<s:param name="WorkId"><%= rs1.getString(2) %>
    									</s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs1.getString(2) %></a></td>
							
							<td><%=rs1.getString(3) %></td>
							<td><%=rs1.getString(5) %></td>
							<td><%=rs1.getString("work_msg_sending_date_time") %></td>
							<%-- <td><a  href=""><img src="${pageContext.request.contextPath}/img/approve.png"></a></td>
							<td><a  href=""><img src="${pageContext.request.contextPath}/img/disapprove.jpg"></a></td> --%>
							
							
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
