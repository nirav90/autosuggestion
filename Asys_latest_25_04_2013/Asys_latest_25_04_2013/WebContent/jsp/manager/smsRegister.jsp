<%@page import="assys.com.dbBean.SmsAuthenticationBean"%>
<%@page import="assys.com.dbDAO.SmsAuthentication"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Register your Way2sms userID to get SMS notifications</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <%
                    String sd = (String)session.getAttribute("employee_ID");
                    
                    SmsAuthenticationBean smsAuthBean=new SmsAuthenticationBean();
            		SmsAuthentication smsDAO=new SmsAuthentication();
                    smsAuthBean.setEmpUserId(sd);
                    ResultSet rs=smsDAO.select(smsAuthBean);
                    if(rs.next()){
                    	%>
                    	<h5 style="color:green">Already Register...</h5>
                    	<%
                    }
                    else{
                    	
                    
                    %>
                    <s:form action="SMS_register_number" cssClass="form" method="post" id="chngPasswordFrm">
                    	
                    	
                    	<s:textfield name="smsAuthBean.way2smsUserName" label="Enter Number" value="%{smsAuthBean.way2smsUserName}" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the number to be changed</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:password name="smsAuthBean.way2smsPassword" label="Enter Password" value="%{smsAuthBean.way2smsPassword}" id="pwd"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the default User Quota in MB when creating a local user account</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:password name="cnfmPwd" label="Confirm Password" id="cpwd"/>
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
					<%} %>
					<s:div name="div_content">
					</s:div>
					<script>
					function load_content()
            			{
                			$("#div_content").css('background-color', 'black');
                		}	
					</script>
<%-- <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script> --%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#chngPasswordFrm").validate({
                rules: {
                	"smsAuthBean.way2smsUserName": "required",
                    "smsAuthBean.way2smsPassword": "required",
                    
                    cnfmPwd:{
                    	required:true,
                    	equalTo: "#pwd"
                    }
                },
                messages: {
                	"smsAuthBean.way2smsUserName": "Please enter your number",
                    "smsAuthBean.way2smsPassword": "Please enter your Password",
                    
                    cnfmPwd:{
                    	required:"Please enter Confirm Password",
                    	equalTo: "Please match both Password"
                    }
                }/* ,
                 submitHandler: function(form) {
                    form.submit();
                } */
            });
	});


</script>

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

