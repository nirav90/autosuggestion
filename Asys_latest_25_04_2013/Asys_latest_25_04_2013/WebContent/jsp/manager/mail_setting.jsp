<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#chngPasswordFrm").validate({
                rules: {
                    "gmailAuthenticationBean.gmailPassword": "required",
                    	cnfmPwd:{
                        	required:true,
                        	equalTo: "#pwd"
                        }
                },
                messages: {
                    "gmailAuthenticationBean.gmailPassword": "Please Enter your Password",
                    
                    cnfmPwd:{
                    	required:"Please Enter Confirm Password",
                    	equalTo: "Please match both Password"
                    }
                }/* ,
                 submitHandler: function(form) {
                    form.submit();
                } */
            });
		
    });		
	
	
	setTimeout(function() {
		
		
	    $('#mydiv').fadeOut('slow');
	}, 3000);


</script>  
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Mail Settings</h2>
                
                
                <s:div cssClass="block">
                <h6 style="color: green">Whenever you changed your password in Gmail Please at the same time change it here...</h6>
                    <s:div id="chart1">
                    <%
                    String false1=(String) request.getAttribute("false1");
                    if(false1!=null){
                    	%>
                    	<div id="mydiv" class="message success" style="color:red"><b>Enter Correct Password</b></div>
                    	<% 
                    }
                    String success=(String) request.getAttribute("success");
                    if(success!=null){
                    	%>
                    	<div id="mydiv" class="message success"><b>Password has been changed successfully</b></div>
                    	<% 
                    }
                    
                    %>
                    <s:form action="change_mail_password" cssClass="form" method="post" id="chngPasswordFrm">
                    	
                    	
                    	
						
						<s:password name="gmailAuthenticationBean.gmailPassword" label="Change Gmail Password" value="%{gmailAuthenticationBean.gmailPassword}"  id="pwd"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the default User Quota in MB when creating a local user account</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:password name="cnfmPwd" label="Confirm Password"  id="cpwd"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the default User Quota in MB when creating a local user account</s:label>
                    			<td>
                    		</tr>
						
						
						
						                    	
                    	
                    	
							
						<tr>
						<td></td>
						<td><s:submit value="Save Settings" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
						</tr>
						
					</s:form>
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

