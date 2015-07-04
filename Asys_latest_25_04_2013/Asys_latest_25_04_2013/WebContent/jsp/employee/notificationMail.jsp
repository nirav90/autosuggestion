<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.joinQuery.showEmployeeDetail"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.EmailNotificationBean"%>
<%@page import="assys.com.dbDAO.EmailNotification"%>
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
						
						EmailNotificationBean emailNotificationBean=new EmailNotificationBean();
						
						EmailNotification emailNotification=new EmailNotification();
						
						GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
						
						GmailAuthentication gmailAuthentication = new GmailAuthentication();

						gmailAuthenticationBean.setEmpUserId(sd);
						ResultSet rs=gmailAuthentication.select(gmailAuthenticationBean);
						String receiptanceID=null;
						while(rs.next()){
							receiptanceID=rs.getString("gmail_email_id");
						}
						emailNotificationBean.setEmailNfcReceiverId(receiptanceID);
						ResultSet rs1=emailNotification.select(emailNotificationBean);
						
						 
					%>
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>From</th>
							<th>Subject</th>
							<th>Body</th>
							
							
							
					</tr>
					</thead>
					<tbody>
					<%
						int i=1;
						while(rs1.next()){
											
					%>
					
					<tr class="gradeA">
					
					<td><%=i++ %></td>
					<td><%= rs1.getString("email_nfc_sender_id") %></td>
					<td><%= rs1.getString("email_nfc_subject") %></td>
					<td><%= rs1.getString("email_notification_message") %></td>
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


