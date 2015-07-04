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
						ContactDetailMasterBean contactDetailMasterBean = new ContactDetailMasterBean();
						ContactEmailDetailBean contactEmailDetailBean = new ContactEmailDetailBean();
						ContactPhoneNoDetailBean contactPhoneNoDetailBean = new ContactPhoneNoDetailBean();
						/* 
						ShowContacts showContacts=new ShowContacts(); 
						
						
						 */
						//String contactId12=contactDetailMasterBean.getContactId();
						ContactDetailMaster contactDetailMaster = new ContactDetailMaster();
						ContactEmailDetail contactEmailDetail = new ContactEmailDetail();
						ContactPhoneNoDetail contactPhoneNoDetail = new ContactPhoneNoDetail();
						String contactID=(String) request.getAttribute("contactId1");
						//out.print(contactID);
						contactDetailMasterBean.setContactId(contactID);
						contactEmailDetailBean.setContactId(contactID);
						contactPhoneNoDetailBean.setContactId(contactID);
						ResultSet rs=contactDetailMaster.select(contactDetailMasterBean);
						ResultSet rs1=contactEmailDetail.select(contactEmailDetailBean);
						ResultSet rs2=contactPhoneNoDetail.select(contactPhoneNoDetailBean);
						request.setAttribute("contactId1", contactID);
						while(rs.next() && rs1.next() && rs2.next())
						{
							String firstName=rs.getString("contact_first_name");
							String lastName=rs.getString("contact_last_name");
							String gender=rs.getString("gender");
							String address=rs.getString("contact_address");
							String emailId=rs1.getString("contact_email_id");
							String phoneNo=rs2.getString("contact_phone_no");
							String landLineNo=rs2.getString("contact_land_line_no");
							request.setAttribute("firstName", firstName);
							request.setAttribute("lastName", lastName);
							request.setAttribute("gender", gender);
							request.setAttribute("address", address);
							request.setAttribute("emailId", emailId);
							request.setAttribute("phoneNo", phoneNo);
							request.setAttribute("landLineNo", landLineNo);
					%>	
					<s:form action="employee_Edit_Contact_detail_click" cssClass="form" method="post">
					<s:hidden name="contactDetailMasterBean.contactId" value="%{#request.contactId1}"/>
					
					<s:textfield label="Firstname" name="contactDetailMasterBean.contactFirstName" value="%{#request.firstName}" disabled="true" id="Firstname"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the First name of  contacts</s:label>
                    			<td>
                    		</tr>
                    		
					<s:textfield name="contactDetailMasterBean.contactLastName" value="%{#request.lastName}" label="Lastname" disabled="true" id="Lastname"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Last name of  contacts</s:label>
                    			<td>
                    		</tr>	
                    <s:radio list="#{'Male':'Male', 'Female':'Female'}" label="Gender" cssClass="fancy-radio"  name="contactDetailMasterBean.gender" value="%{#request.gender}"/>
					
					
					<s:textarea name="contactDetailMasterBean.contactAddress" label="Address" value="%{#request.address}" disabled="true" rows="4" id="Address"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Home Address</s:label>
                    			<td>
                    		</tr>
                    		
					<s:textfield name="contactEmailDetailBean.contactEmailId" label="Email Address" value="%{#request.emailId}" disabled="true" id="EmailAddress"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the email Address</s:label>
                    			<td>
                    		</tr>
                    		
					<s:textfield name="contactPhoneNoDetailBean.contactPhoneNo" label="Mobile No" value="%{#request.phoneNo}" disabled="true" id="MobileNo"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Phone number</s:label>
                    			<td>
                    		</tr>
                    		
					<s:textfield name="contactPhoneNoDetailBean.contactLandLineNo" label="Land-Line No" value="%{#request.landLineNo}" disabled="true" id="LandLineNo"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Land Line  number</s:label>
                    			<td>
                    		</tr>
					<tr>
						<td></td>
						<td><s:submit value="Update" cssClass=" btn-grey btn-person" theme="simple" id="update"></s:submit></td>
					</tr>
					<tr>
						<td></td>
						<td><s:submit value="Edit" cssClass=" btn-grey btn-person" theme="simple" onclick="return edit_block()" id="edit"></s:submit></td>
					</tr>
					</s:form>
					<%	
						}
					%>
					
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

