<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Web Mail Setting</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="add_user_click" cssClass="form" method="post">
                    	
                    	<s:radio list="#{'1':'ON','2':'OFF'}" name="notification" label="Login Page"></s:radio>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the timeout in minutes for a Webmail session to expire due to inactivity</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	<s:radio list="#{'1':'ON','2':'OFF'}" name="notification" label="Sign up Page"></s:radio>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the timeout in minutes for a Webmail session to expire due to inactivity</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	
                    	
                    	
                    	<s:textfield name="addUser.name" label="User Quota" value="%{addUser.name}" size="5"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the default User Quota in MB when creating a local user account</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	
                    	<s:radio list="#{'1':'ON','2':'OFF'}" name="notification" label="SMS Notification"></s:radio>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the timeout in minutes for a Webmail session to expire due to inactivity</s:label>
                    			<td>
                    		</tr>
                    		
                    	<s:radio list="#{'1':'ON','2':'OFF'}" name="notification" label="Email Notification"></s:radio>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the timeout in minutes for a Webmail session to expire due to inactivity</s:label>
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

