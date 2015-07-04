<!-- <title>Register</title> -->
<%@ include file="Header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script src="../jquery.js" type="text/javascript"></script>
<script src="../jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").validate({
                rules: {
                    "empBean.firstName": "required",
                    "empBean.lastName": "required",
                    "authBean.userName": "required",
                    "authBean.password": "required",
                    "empBean.gender": "required",
                    "empBean.phoneNo": "required",
                    "empBean.empUserId": "required"
                },
                messages: {
                    "empBean.firstName": "Please enter your First Name",
                    "empBean.lastName": "Please enter your Last Name",
                    "authBean.userName": "Please enter your User Name",
                    "authBean.password": "Please enter your Password",
                    "empBean.gender": "Please select Gender",
                    "empBean.phoneNo": "Please enter your Phone No",
                    "empBean.empUserId": "You must have to enter your EmployeeID"
                }/* ,
                 submitHandler: function(form) {
                    form.submit();
                } */
            });
	});


</script>


<div class="container_12">
       
       
    
            <div class="box round first fullpage">
                <h2>
                    Sign Up</h2>
                <div class="block ">
                    <!-- <form> -->
                    <s:form cssClass="form" action="register_click.action" id="login_frm">
                   <!--  <table class="form"> -->
                        <!-- <tr>
                            <td class="col1">
                                <label>
                                  UserName</label>
                            </td>
                            <td class="col2">
                         -->        <!-- <input type="text" id="grumble" /> -->
                         <tr><td></td><td></td><td><b>Step 1/2</b></td></tr>
                                <s:textfield label="First Name" name="empBean.firstName" value="%{empBean.firstName}"></s:textfield>
                           <!--  </td>
                        </tr>
                        <tr> -->
                            <!-- <td class="col1">
                                <label>
                                    Password:</label>
                            </td> -->
                            <!-- <td class="col2"> -->
                            
                            
                                <s:textfield label="Last Name" name="empBean.lastName" value="%{empBean.lastName}"></s:textfield>
                            <!-- </td> -->
                        <!-- </tr> -->
                           		<s:textfield label="User Name" name="authBean.userName" value="%{authBean.userName}"></s:textfield>
                           		<s:password label="Password" name="authBean.password"  value="%{authBean.password}"></s:password>
                           		<%-- <s:div  class="fancy-radio" cssStyle="position: relative; display: inline-block; padding-left: 2px; padding-right: 2px; z-index: 1000;"></s:div> --%>
                           		
                           		
                           		<s:radio list="#{'Male':'Male', 'Female':'Female'}" label="Gender" cssClass="fancy-radio"  name="empBean.gender" value="%{empBean.gender}"></s:radio>
                           		<s:textfield label="Phone No" name="empBean.phoneNo" value="%{empBean.phoneNo}"></s:textfield>
                            	<s:textfield id="grumble" label="Employee ID" name="empBean.empUserId" value="%{empBean.empUserId}"></s:textfield>
                            
                                <!-- <button class="btn btn-black">Login</button> -->
                                <tr>
                                <td></td>
                                <td>
                                <s:submit cssClass="btn btn-black" value="next" theme="simple"></s:submit>
                                </td>
                                </tr>
                                <%-- <tr>
                                <td></td>
                                <td>
                                Forgot Password 
                               <s:a href="/Thanks.jsp">click here</s:a>
                                </td>
                                </tr>
                                <tr>
                                <td></td>
                                <td>
                                Create new Account 
                               <s:a href="">click here</s:a>
                                </td>
                                </tr>
                             --%>
                        
                        
                                 <!--  </table> -->
                                  </s:form>
                                  
                    <!-- </form> -->
                </div>
            </div>
        </div>
        <div style="height: 30px;">
			
        </div>
        
        <div class="clear">
        </div>
    <!-- </div>
    <div class="clear">
    </div> -->
    
    <%@ include file="Footer.jsp" %>