<!-- <head><title>Login Here</title></head> -->
<%@ include file="Header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<script src="../jquery.js" type="text/javascript"></script>
<script src="../jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").validate({
                rules: {
                    "authenticationDetailBean.userName":{
                    	required : true
                    	
                    }
                    	
                    
                },
                messages: {
                	"authenticationDetailBean.userName":{
                    	required : "Please provide email address"
                    }
                    
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
                    Forgot Password</h2>
                <div class="block ">
                    <!-- <form> -->
                    
                    <s:form cssClass="form" action="forgot_click.action" id="login_frm">
                                <s:textfield size="32" id="grumble1"  label="Username" name="authenticationDetailBean.userName" value="%{authenticationDetailBean.userName}"/>
                        
                   
                            <!-- </td> -->
                        <!-- </tr> -->
                           
                            
                            
                                <!-- <button class="btn btn-black">Login</button> -->
                                <tr>
                                <td></td>
                                <td>
                                <s:submit cssClass="btn btn-black" value="Send" theme="simple"></s:submit>
                                </td>
                                </tr>
                                <tr>
                                <td></td>
                                <td>
                                
                                </td>
                                </tr>
                                <tr>
                                <td></td>
                                <td>
                                </td>
                                </tr>
                            
                            
                            
                        
                        
                                 <!--  </table> -->
                                  </s:form>
                                  
                    <!-- </form> -->
                </div>
            </div>
        </div>
        <div style="height: 290px;">
			
        </div>
        
        <div class="clear">
        </div>
       
    <!-- </div>
    <div class="clear">
    </div> -->
    
    <%@ include file="Footer.jsp" %>