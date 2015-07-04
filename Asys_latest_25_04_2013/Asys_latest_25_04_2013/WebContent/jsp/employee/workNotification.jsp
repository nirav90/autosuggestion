<%@page import="java.sql.ResultSet"%>

<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
<%@page import="assys.com.joinQuery.SelectQuery"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<script language="javascript" type="text/javascript">
					

</script>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Contacts</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    	
                    <%-- <jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean" />
							
							<jsp:setProperty name="ContactDetailMasterBean" property="contactId" value="nirav" /> --%>
					<%        
                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
                    	
						String sd = (String)session.getAttribute("employee_ID");
						
                    	GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
						
				    	GmailAuthentication gmailAuthentication = new GmailAuthentication();
				    	gmailAuthenticationBean.setEmpUserId(sd);
						 
						
						
						ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
						 
						String mailId=null;
						while(rs.next())
						{
							 mailId=rs.getString(3);
						}	 
						String query="SELECT * FROM email_notification WHERE email_nfc_subject IN('Notification For Your Work','Work Status Notification') AND email_nfc_receiver_id='"+mailId+"' ORDER BY email_notification_date_time desc;";
						
						SelectQuery selectQuery=new SelectQuery();
						//out.print(sd);
						ResultSet rs3=selectQuery.executeSelect(query);
						
						
						
					%>
					<table class="data display datatable" id="example">
					<thead>
					<tr>
							<th>No</th>
							<th>From</th>
							<th>Subject</th>
							<th>Message</th>
							<th>Sending Date</th>
							
					</tr>
					</thead>
					<tbody>
					<%
						int i=1;
						
						
					
								while(rs3.next())
								{	
									
									
					%>
					
					<tr class="gradeA">
					<td><%=(i++) %>
					
					</td>
					
					<td><%= rs3.getString("email_nfc_sender_id") %></td>
					<td><%= rs3.getString("email_nfc_subject") %></td>
					<td><%= rs3.getString("email_notification_message") %></td>
					<td><%= rs3.getString("email_notification_date_time") %></td>
					
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

