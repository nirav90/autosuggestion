<head><title>Login Here</title></head>
<%@ include file="Header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<script src="../jquery.js" type="text/javascript"></script>
<script src="../jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").validate({
                rules: {
                    "authBean.userName": "required",
                    "authBean.password": "required"
                },
                messages: {
                    "authBean.userName": "Please enter your UserName",
                    "authBean.password": "Please enter your Password"
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


<div class="container_12">
       
       
    
            <div class="box round first fullpage">
            
            
                <h2>
                    Sign In</h2>
                <div class="block ">
                    <!-- <form> -->
                    <div id="mydiv" class="message error"><center><b>Please Enter Correct username or password</b></center></div>
                    <!-- <div  id="mydiv" style="color: red;text-align: center; text-shadow: black; border: 1px; border-color: red;  border:solid ; " ><b>Please Enter correct Username or Password</b></div> -->
                    <s:form cssClass="form" action="loginClick.action" id="login_frm">
                                <s:textfield id="grumble1"  label="Username" name="authBean.userName" value="%{authBean.userName}"/>
                        
                                <s:password id="grumble2" label="Password" name="authBean.password" value="%{authBean.password}"/>
                           
                            
                            
                                <!-- <button class="btn btn-black">Login</button> -->
                                <tr>
                                <td></td>
                                <td>
                                <s:submit cssClass="btn btn-black" value="Login" theme="simple"></s:submit>
                                </td>
                                </tr>
                                <tr>
                                <td></td>
                                <td>
                                Forgot Password 
                               <s:a href="forgotpass.jsp">click here</s:a>
                                </td>
                                </tr>
                                <tr>
                                <td></td>
                                <td>
                                Create new Account 
                               <s:a href="register.jsp">click here</s:a>
                                </td>
                                </tr>
                            
                        
                        
                                 <!--  </table> -->
                                  </s:form>
                                  
                    <!-- </form> -->
                </div>
            </div>
        </div>
        <div style="height: 190px;">
			
        </div>
        
        <div class="clear">
        </div>
       
    <!-- </div>
    <div class="clear">
    </div> -->
    
    <%@ include file="Footer.jsp" %>