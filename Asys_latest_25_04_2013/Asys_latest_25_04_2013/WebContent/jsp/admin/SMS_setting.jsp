<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Global Settings</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="add_user_click" cssClass="form" method="post">
                    	
                    	
                    	<s:textfield name="addUser.name" label="change Number" value="%{addUser.name}" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the default User Quota in MB when creating a local user account</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textfield name="addUser.name" label="Confirm  Number" value="%{addUser.name}" />
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

