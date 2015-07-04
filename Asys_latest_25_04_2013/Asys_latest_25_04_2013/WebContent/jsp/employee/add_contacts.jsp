<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").validate({
                rules: {
                    "contactDetailMasterBean.contactFirstName": "required",
                    "contactDetailMasterBean.contactLastName": "required",
                    "contactEmailDetailBean.contactEmailId":  {
                    	required:true,
                    	email:true
                    },
                    "contactDetailMasterBean.contactAddress": "required",
                    
                    "contactPhoneNoDetailBean.contactLandLineNo": {
                    	required:true,
                    	number:true,
                    	minlength:10
                    },
                    "contactDetailMasterBean.gender":"required",
                    "contactPhoneNoDetailBean.contactPhoneNo": {
                    	required:true,
                    	number:true,
                    	minlength:10
                    	
                    }
                    
                    
                },
                messages: {
                	 "contactDetailMasterBean.contactFirstName": "Please Enter firstname",
                     "contactDetailMasterBean.contactLastName": "Please Enter lastname",
                     "contactEmailDetailBean.contactEmailId": {
                    	required:"Please Enter emailID",
                    	email:"Please Enter Correct emailID"
                    },
                     "contactDetailMasterBean.contactAddress": "Please Enter Address",
                    
                     "contactPhoneNoDetailBean.contactLandLineNo": 
                     {
                      	required:"Please Enter Land Line Number",
                      	number:"Enter Number only",
                      	minlength:"Length should be 10"
                      	
                      },
                      
                    "contactDetailMasterBean.gender":"Please enter gender",
                    "contactPhoneNoDetailBean.contactPhoneNo": {
                       	required:"Please Enter Mobile Number",
                       	number:"Enter Number only",
                       	minlength:"Length should be 10"
                      	
                    }
                }/* ,
                 submitHandler: function(form) {
                    form.submit();
                } */
            });
		
    });		
	

</script>





<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Add Contacts</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="employee_add_contact_click" cssClass="form" method="post" id="login_frm" name="login_frm">
                    	
                    	
                    	<s:textfield name="contactDetailMasterBean.contactFirstName" label="Firstname" value="%{contactDetailMasterBean.contactFirstName}" />
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
                    		
                   <s:radio list="#{'Male':'Male', 'Female':'Female'}" label="Gender" cssClass="fancy-radio"  name="contactDetailMasterBean.gender" value="%{contactDetailMasterBean.gender}"></s:radio>
                    		
                    		<s:textarea name="contactDetailMasterBean.contactAddress" label="Address" value="%{contactDetailMasterBean.contactAddress}" rows="4" cols="20"/>
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
					<%-- <script>
					function load_content()
            			{
                			$("#div_content").html("<h3>Loading.......</h3>");
                		}	
					</script>
 --%>
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

