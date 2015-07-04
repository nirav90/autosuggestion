<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="assys.com.dbDAO.AssignWorkMaster"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.ContactDetailMaster"%>
<%@page import="assys.com.dbDAO.ContactEmailDetail"%>
<%@page import="assys.com.dbDAO.ContactPhoneNoDetail"%>
<%@page import="assys.com.dbBean.ContactDetailMasterBean"%>
<%@page import="assys.com.dbBean.ContactEmailDetailBean"%>
<%@page import="assys.com.dbBean.ContactPhoneNoDetailBean"%>
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

<script type="text/javascript" language="javascript">
	
	
	
	function edit_block()
		{
			
			var label1=document.getElementById("Firstname");
  			var label2=document.getElementById("Lastname");
		  	var label5=document.getElementById("Address");
  			var label6=document.getElementById("EmailAddress");
  			var label7=document.getElementById("MobileNo");
  			var label8=document.getElementById("LandLineNo");
  			label1.disabled=!label1.disabled;
  			
  			label2.disabled=!label2.disabled;
  			
  			label5.disabled=!label5.disabled;
  	
  			label6.disabled=!label6.disabled;
  	
  			label7.disabled=!label7.disabled;
  	
  			label8.disabled=!label8.disabled;
  			
  			update.style.display="block";
  			
  			edit.style.display="none";
		
  		
		
  	return false;
		
		}
	
	
	
</script>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Contacts</h2>
                <s:div cssClass="block">
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
					
					<s:hidden name="contactDetailMasterBean.contactId" value="%{#request.contactId1}"/>
					
					<s:textfield label="To" name="" value="%{#request.To}" readonly="true" id="Firstname" size="40"/>
					
							
					<s:textfield name="" value="%{#request.workId}" label="Work Id" readonly="true" id="Lastname" size="40"/>
					
					<s:textfield name="" label="Work Subject" value="%{#request.worksubject}" readonly="true" id="EmailAddress" size="40"/>
					
					<s:textarea name="" label="Work Description" value="%{#request.workdescription}" readonly="true" rows="4" id="Address" cols="32"/>
							
					
							
					<s:textfield name="contactPhoneNoDetailBean.contactPhoneNo" label="Duration" value="%{#request.Duration}" readonly="true" id="MobileNo" size="40"/>
							
					
					</s:form>
					<%	
						}
					%>
					
				
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

