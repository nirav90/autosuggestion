<%@page import="java.sql.ResultSet"%>
<%-- <%@page import="assys.com.dbDAO.Contact_detail_master"%>
<%@page import="assys.com.dbDAO.Contact_email_detail"%>
<%@page import="assys.com.dbDAO.Contact_phone_no_detail"%>
<%@page import="assys.com.dbBean.Contact_detail_master_bean"%>
<%@page import="assys.com.dbBean.Contact_email_detail_bean"%>
<%@page import="assys.com.dbBean.Contact_phone_no_detail_bean"%> --%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="assys.com.joinQuery.ShowContacts"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Client Register</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <%
                    String clientID=(String) request.getAttribute("clientID1");
                    request.setAttribute("clientID",clientID);
                    String clientName=(String)request.getAttribute("clientName");
                    request.setAttribute("clientName", clientName);
                    String clientCompanyName=(String)request.getAttribute("clientCompanyName");
                    request.setAttribute("clientCompanyName", clientCompanyName);
                    %>
                    
                    
                    <s:form action="manager_add_client_id_mail_click" cssClass="form" method="post">
					<s:textfield label="Client ID" name="clientIdGeneratorBean.clientId" value="%{#request.clientID}" readonly="true" id="clientID"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Shows generated Client ID</s:label>
                    			<td>
                    		</tr>
                    		
					<s:textfield name="sentMailMasterBean.reciptanceEmailId" value="%{sentMailMasterBean.reciptanceEmailId}" label="Client Email ID" id="clnEmailId"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Email ID of client on which ClientID be send</s:label>
                    			<td>
                    		</tr>
                    		
                    <s:textfield name="clientDetailsBean.clientFirstName" value="%{#request.clientName}" label="Client Name" id="clnEmailId" readonly="true"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Shows the Client Name</s:label>
                    			<td>
                    </tr>
                    		
                    <s:textfield name="clientDetailsBean.companyName" value="%{#request.clientCompanyName}" label="Client Company Name" id="clnEmailId" readonly="true"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Shows the Company Name of the Client</s:label>
                    			<td>
                    </tr>
                    
                    <s:textfield name="clientDetailsBean.phoneNo" value="%{clientDetailsBean.phoneNo}" label="Client PhoneNo" id="clnEmailId"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Add Phone Number of the Client</s:label>
                    			<td>
                    </tr>	
                    	<td></td>
						
						<td><s:submit value="Register" cssClass=" btn-grey btn-person" theme="simple" id="update"></s:submit></td>
					
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

                    