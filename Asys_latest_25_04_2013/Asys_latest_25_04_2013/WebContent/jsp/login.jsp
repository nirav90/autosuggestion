<!-- <head><title>Login Here</title></head> -->
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
                
                 <%

			String s = (String)request.getAttribute("forgot");
			

			if(s==null)
			{
			}
			else{
				
				String email = (String)request.getAttribute("email");
%>

<!-- <div style="color: blue;font-size: 20px;text-align: center;">Mail Sent Successfully..</div> -->

<div id="mydiv" class="message success"><center><b>New password sent on <%= email %>.please check it</b></center></div>

<%} %>
                
                
                    <!-- <form> -->
                    
                    <s:form cssClass="form" action="loginClick.action" id="login_frm">
                   <!--  <table class="form"> -->
                        <!-- <tr>
                            <td class="col1">
                                <label>
                                  UserName</label>
                            </td>
                            <td class="col2">
                         -->        <!-- <input type="text" id="grumble" /> -->
                                <s:textfield id="grumble1"  label="Username" name="authBean.userName" value="%{authBean.userName}"/>
                        
                                <%-- <s:textfield id="grumble"  label="Username1" name="loginUserName"/> --%>
                           <!--  </td>
                        </tr>
                        <tr> -->
                            <!-- <td class="col1">
                                <label>
                                    Password:</label>
                            </td> -->
                            <!-- <td class="col2"> -->
                                <s:password id="grumble2" label="Password" name="authBean.password" value="%{authBean.password}"/>
                            <!-- </td> -->
                        <!-- </tr> -->
                           
                            
                            
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