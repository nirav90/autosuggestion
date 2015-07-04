

<%@page import="assys.com.dbDAO.WorkSubmitMaster"%>
<%@page import="assys.com.dbBean.WorkSubmitMasterBean"%>
<%@page import="assys.com.dbDAO.AssignWorkMaster"%>
<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="assys.com.dbDAO.SentMailMaster"%>
<%@page import="assys.com.dbBean.SentMailMasterBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.InboxMaster"%>
<%@page import="assys.com.dbBean.InboxMasterBean"%>
<%@ page language="java" import="demo.MessageInfo" %>
<%@ page errorPage="errorpage.jsp" %>


<%@ taglib prefix="s" uri="/struts-tags" %>


<div class="grid_10">
            <div class="box round first1 ">
                <h2>
                  Show Status of Submitted Work</h2>
                <div class="block">
                    
                    <div id="chart1"> 
                    
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>No.</th>
							<th>Work Id</th>
							<th>To</th>
							<th>Work Subject</th>
							<th>Work Send Date Time</th>
							<!-- <th>Duration</th>
							<th>Time</th>
							 -->
							 <th>Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						
						 
		                    
		                    
		                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
		            		
		            		String sd = (String)session.getAttribute("employee_ID");
		            		
		     			 
		     	
		                    WorkSubmitMasterBean workSubmitMasterBean = new WorkSubmitMasterBean();
		                    
		                    workSubmitMasterBean.setEmpUserId(sd);
		                    workSubmitMasterBean.setWorkApprove(true);
		                    WorkSubmitMaster workSubmitMaster = new WorkSubmitMaster();
		                    
		                   
		          
		                     ResultSet rs = workSubmitMaster.select(workSubmitMasterBean);
		     			
		                    
		     			
		     		int i= 1;
	
		     		while(rs.next())
		     		{	
		                    
		                
		                %>
						
						
						<tr class="gradeA">
						
							<td><%=(i++) %></td>
							<td><s:url action="employee_show_submit_work_detail_jsp" var="urlTag" >
    									<s:param name="WorkId"><%= rs.getString("work_id")+"-"+rs.getString("work_approve") %>
    									</s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString(2) %></a>
							</td>
							<td><%=rs.getString(4) %></td>
							<td><%=rs.getString(5) %></td>
							<td><%=rs.getString("work_msg_sending_date_time") %></td>
							<td  style="background-color:#66FF99; text-align: center;">Approved</td>
						
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
