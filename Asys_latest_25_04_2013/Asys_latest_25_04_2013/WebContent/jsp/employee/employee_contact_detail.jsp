<%@page import="assys.com.dbBean.ContactEmailDetailBean"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">

			
			<%
			
			String ss = (String)request.getAttribute("cntId");
			
			ContactEmailDetailBean contactEmailDetailBean  = new ContactEmailDetailBean();
			String s = contactEmailDetailBean.getContactId();
			out.print(contactEmailDetailBean.getContactId());
			
			System.out.print(ss);
			%>
			
			<jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean"></jsp:useBean>
							
				 Now the message is:			<jsp:getProperty name="ContactDetailMasterBean" property="contactId" />
			
			
            <s:div cssClass="box round first1 ">
                <h2>Add Contacts</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="employee_add_contact_click" cssClass="form" method="post">
                    	
                    	
                    	<s:textfield name="contactDetailMasterBean.contactFirstName" label="Firstname" value="%{#request.s}" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the First name of  contacts</s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    	<s:textfield name="contactDetailMasterBean.contactLastName" label="Lastname" value="%{contactDetailMasterBean.contactLastName}" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Last name of  contacts</s:label>
                    			<td>
                    		</tr>	
                    		
                    	
                    	<s:textfield name="contactEmailDetailBean.contactEmailId" label="Email Address" value="%{contactEmailDetailBean.contactEmailId}" size="25"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the email Address</s:label>
                    			<td>
                    		</tr>
                    		
                   <s:radio list="#{'Male':'Male', 'Female':'Female'}" label="gender" cssClass="fancy-radio"  name="contactDetailMasterBean.gender" value="%{contactDetailMasterBean.gender}"></s:radio>
                    		
                    		<s:textarea name="contactDetailMasterBean.contactAddress" label="Address" value="%{contactDetailMasterBean.contactAddress}" rows="7"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Home Address</s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		
                    		
                    	<s:textfield name="contactPhoneNoDetailBean.contactPhoneNo" label="Mobile No" value="%{contactPhoneNoDetailBean.contactPhoneNo}" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Phone number</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textfield name="contactPhoneNoDetailBean.contactLandLineNo" label="Land-Line No" value="%{contactPhoneNoDetailBean.contactLandLineNo}" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Land Line  number</s:label>
                    			<td>
                    		</tr>
                    	
                                        	
                    	
                    	
                    	
							
						<tr>
						<td></td>
						<td><s:submit value=" Add " cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
						</tr>
						
					</s:form>
					<s:div name="div_content">
					</s:div>
					<script>
					function load_content()
            			{
                			$("#div_content").html("<h3>Loading.......</h3>");
                		}	
					</script>

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

