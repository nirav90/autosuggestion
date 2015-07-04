<%@ include file="Header.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="container_12">
       
       
    
            <div class="box round first fullpage">
                <h2>
                    Sign Up</h2>
                <div class="block ">
                    <!-- <form> -->
                    <s:form cssClass="form" action="register2_click">
                   <!--  <table class="form"> -->
                        <!-- <tr>
                            <td class="col1">
                                <label>
                                  UserName</label>
                            </td>
                            <td class="col2">
                         -->        <!-- <input type="text" id="grumble" /> -->
                         <tr><td></td><td></td><td><b>step 2/2</b></td></tr>
                                <s:textfield id="grumble"  label="Gmail ID" name="gmailAuthBean.gmailEmailId" value="%{gmailAuthBean.gmailEmailId}"></s:textfield>
                           <!--  </td>
                        </tr>
                        <tr> -->
                            <!-- <td class="col1">
                                <label>
                                    Password:</label>
                            </td> -->
                            <!-- <td class="col2"> -->
                            
                            
                                
                            <!-- </td> -->
                        <!-- </tr> -->
                           		
                           		<s:password id="grumble" label=" Gmail Password" name="gmailAuthBean.gmailPassword" value="%{gmailAuthBean.gmailPassword}"></s:password>
                           		<%-- <s:div  class="fancy-radio" cssStyle="position: relative; display: inline-block; padding-left: 2px; padding-right: 2px; z-index: 1000;"></s:div> --%>
                           		
                           		
                           		    <tr>
                                <td></td>
                                <td>
                                <s:submit cssClass="btn btn-black" value="Register" theme="simple"></s:submit>
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
        <div style="height: 300px;">
			
        </div>
        
        <div class="clear">
        </div>
    <!-- </div>
    <div class="clear">
    </div> -->
    
    <%@ include file="Footer.jsp" %>