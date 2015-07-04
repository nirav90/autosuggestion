<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>




<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Client Detail</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="manager_add_client_click" cssClass="form" method="post">
                    	
                    	
                    	<s:textfield name="clientIdGeneratorBean.clientName" label="Name" value="%{clientIdGeneratorBean.clientName}" size="30" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the name of Client</s:label>
                    			<td>
                    		</tr>
              
                    	
                    	<s:textfield name="clientIdGeneratorBean.clientCompanyName" label="Company Name" value="%{clientIdGeneratorBean.clientCompanyName}" size="30"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the name of company</s:label>
                    			<td>
                    		</tr>
                    	
                    	                    		
						<tr>
						<td></td>
						<td><s:submit value="Request For Client Id" cssClass=" btn-grey btn-person" theme="simple" id="submit" name="submit" onclick="load_content()"></s:submit></td>
						<td>
						
						</td>
						
						</tr>
						
					</s:form>
					 <s:div cssClass="message info"  cssStyle="display:none" name="div_content" id="div_content">
                            
                            <p><b>Client Added Successfully... </b></p>    
							
                            </s:div>	
                    	
					



 <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

