<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="assys.com.dbDAO.AssignWorkMaster"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.WorkSubmitMaster"%>
<%@page import="assys.com.dbBean.WorkSubmitMasterBean"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="assys.com.joinQuery.ShowContacts"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<style type="text/css">  
 #update
{
	display:none;
}
#edit
{
	display:block;
}

</style>


<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Appove Work</h2>
                <s:div cssClass="block">
                 <h6><font color="green">Assigned Work Detail</font></h6>
                    <s:div id="chart1">
                    
                    <%-- <jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean" />
							
							<jsp:setProperty name="ContactDetailMasterBean" property="contactId" value="nirav" /> --%>
					<%        
            
						String sd = (String)session.getAttribute("employee_ID");
					
						String workid = request.getParameter("WorkId");
						
						AssignWorkMasterBean assignWorkMasterBean = new   AssignWorkMasterBean();
						
						assignWorkMasterBean.setEmpUserId(sd);
						
						assignWorkMasterBean.setWorkId(workid);
						
						
						
						AssignWorkMaster assignWorkMaster = new AssignWorkMaster();
						
						ResultSet rs =  assignWorkMaster.select(assignWorkMasterBean);
						
						while(rs.next())
						{
							
							String To = rs.getString(4);
							String workId = rs.getString(2);
							String worksubject = rs.getString(5);
							String workdescription = rs.getString(6);
							String Duration = rs.getString(8);
							
							request.setAttribute("To", To);
							request.setAttribute("workId", workId);
							request.setAttribute("worksubject", worksubject);
							request.setAttribute("workdescription", workdescription);
							request.setAttribute("Duration", Duration);
							
							
						
						
						
						%>	
					<s:form action="employee_Edit_Contact_detail_click" cssClass="form" method="post">
					
					
					<s:textfield label="To" name="assignWorkMasterBean.reciptanceEmailId" value="%{#request.To}" readonly="true" id="Firstname" size="40"/>
					
							
					<s:textfield name="assignWorkMasterBean.workId" value="%{#request.workId}" label="Work Id" readonly="true" id="Lastname" size="40"/>
					
					<s:textfield name="assignWorkMasterBean.workMsgSubject" label="Work Subject" value="%{#request.worksubject}" readonly="true" id="EmailAddress" size="40"/>
					
					<s:textarea name="assignWorkMasterBean.workMsgBody" label="Work Description" value="%{#request.workdescription}" readonly="true" rows="4" id="Address" cols="32"/>
							
					
							
					<s:textfield name="assignWorkMasterBean.duration" label="Duration" value="%{#request.Duration}" readonly="true" id="MobileNo" size="40"/>
							
					
					</s:form>
					<%	
						}
					%>
					
				
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>








<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Contacts</h2>
                <s:div cssClass="block">
                 <h6><font color="green">Submitted Work Detail</font></h6>
                    <s:div id="chart1">
                    
                    <%-- <jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean" />
							
							<jsp:setProperty name="ContactDetailMasterBean" property="contactId" value="nirav" /> --%>
					<%        
            
						String sd = (String)session.getAttribute("employee_ID");
					
						String workid = request.getParameter("WorkId");
						
						WorkSubmitMasterBean workSubmitMasterBean = new WorkSubmitMasterBean();
						WorkSubmitMaster workSubmitMaster=new WorkSubmitMaster();
						
						
						
						workSubmitMasterBean.setWorkId(workid);
						
						workSubmitMasterBean.setSeen(false);
						
						
						
						ResultSet rs =  workSubmitMaster.select(workSubmitMasterBean);
						
						while(rs.next())
						{
							String from=rs.getString(3);
							String To = rs.getString(4);
							String workId = rs.getString(2);
							String worksubject = rs.getString(5);
							String workdescription = rs.getString(6);
							
							request.setAttribute("from", from);
							request.setAttribute("To", To);
							request.setAttribute("workId", workId);
							request.setAttribute("worksubject", worksubject);
							request.setAttribute("workdescription", workdescription);
							
							
							
						
						
						
						%>	
					<s:form action="manager_approve_work_click" cssClass="form" method="post">
					
					<s:hidden  name="workSubmitMasterBean.senderEmailId" value="%{#request.from}"/>
					<s:textfield label="To" name="workSubmitMasterBean.reciptanceEmailId" value="%{#request.To}" readonly="true" id="Firstname" size="40"/>
					
							
					<s:textfield name="workSubmitMasterBean.workId" value="%{#request.workId}" label="Work Id" readonly="true" id="Lastname" size="40"/>
					
					<s:textfield name="workSubmitMasterBean.workMsgSubject" label="Work Subject" value="%{#request.worksubject}" readonly="true" id="EmailAddress" size="40"/>
					
					<s:textarea name="workSubmitMasterBean.workMsgBody" label="Work Description" value="%{#request.workdescription}" readonly="true" rows="4" id="Address" cols="32"/>
							
					<tr>
						<td></td>
						<td><s:submit value="Approve" name="submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"/>
						<s:submit value="DisApprove" name="submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()" />
					</tr>
							
					
							
					
					</s:form>
					<%	
						}
					%>
					
				
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

