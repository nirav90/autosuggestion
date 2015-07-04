<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Change Password</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
<%-- <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script> --%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#chngPasswordFrm").validate({
                rules: {
                    "authBean.password": "required",
                    
                    cnfmPwd:{
                    	required:true,
                    	equalTo: "#pwd"
                    }
                },
                messages: {
                    "authBean.password": "Please enter your Password",
                    
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
                    
                    <s:form action="change_password.action" cssClass="form" method="post" id="chngPasswordFrm">
                    	<s:password name="authBean.password" label="New Password" value="%{authBean.password}" id="pwd"/>
                    	<s:password name="cnfmPwd" label="Confirm Password" id="cpwd"/>
                    	
						
						<tr>
						<td></td>
						<td><s:submit value="Submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
						</tr>
						<%-- <s:submit value="Add User" cssClass="btn-icon btn-grey btn-person"/>
						<button class="btn-icon btn-grey btn-person"><span></span>Add User</button> --%>
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

