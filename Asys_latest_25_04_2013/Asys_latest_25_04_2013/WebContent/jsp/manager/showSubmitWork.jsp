

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
                    Assigned Work</h2>
                <div class="block">
                    
                    <div id="chart1"> 
                    
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>No.</th>
							<th>Work Id</th>
							<th>To</th>
							<th>Work Subject</th>
							<!-- <th>Duration</th>
							<th>Time</th>
							 -->
						</tr>
					</thead>
					<tbody>
						<%
						
						 
		                    
		                    
		                    /* HttpSession session1 = (HttpSession)ServletActionContext.getRequest().getSession(); */
		            		
		            		String sd = (String)session.getAttribute("employee_ID");
		            		
		     			 
		     	
		                    AssignWorkMasterBean assignWorkMasterBean = new AssignWorkMasterBean();
		                    
		                    assignWorkMasterBean.setEmpUserId(sd);
		                    
		                    AssignWorkMaster assignWorkMaster = new AssignWorkMaster();
		                   
		          
		                     ResultSet rs =assignWorkMaster.select(assignWorkMasterBean);
		     			
		                    
		     			
		     		int i= 1;
	
		     		while(rs.next())
		     		{	
		                    
		                
		                %>
						
						
						<tr class="gradeA">
							<td><%=(i++) %></td>
							
								<td><s:url action="manager_show_assign_work_detail_jsp" var="urlTag" >
    									<s:param name="WorkId"><%= rs.getString(2) %>
    									</s:param>
								</s:url>
								<a href="<s:property value="#urlTag" />" ><%=rs.getString(2) %></a></td>
							
							<td><%=rs.getString(4) %></td>
							<td><%=rs.getString(5) %></td>
							<%-- <td><%=rs.getString(7) %></td>
							<td><%=rs.getString(8) %></td>
							<td><%=rs.getString(9) %></td> --%>
							
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
