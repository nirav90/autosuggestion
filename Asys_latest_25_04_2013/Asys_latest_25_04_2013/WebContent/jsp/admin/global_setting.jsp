<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Global Settings</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="add_user_click" cssClass="form" method="post">
                    	
                    	
                    	<s:textfield name="addUser.name" label="Admin Email" value="%{addUser.name}" size="30"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the administrator email that maintains the AtWork system</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	
                    	<s:textfield name="addUser.phone" label="Session time out" value="%{addUser.phone}" size="5"></s:textfield>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the timeout in minutes for a Webmail session to expire due to inactivity</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textfield name="addUser.phone" label="SQL HostName" value="%{addUser.phone}" size="30"></s:textfield>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the hostname to the MySQL server.</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textfield name="addUser.phone" label="SQL UserName" value="%{addUser.phone}" size="30"></s:textfield>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the username to the MySQL server</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textfield name="addUser.phone" label="SQL Password" value="%{addUser.phone}" size="30"></s:textfield>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the username to the MySQL server</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textfield name="addUser.phone" label="Database Name" value="%{addUser.phone}" size="30" ></s:textfield>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Name of Database</s:label>
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

