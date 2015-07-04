<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
bkLib.onDomLoaded(function() {
    new nicEditor().panelInstance('area1');
    new nicEditor({fullPanel : true}).panelInstance('area2');
    new nicEditor({iconsPath : '../nicEditorIcons.gif'}).panelInstance('area3');
    new nicEditor({buttonList : ['fontSize','bold','italic','underline','strikeThrough','subscript','superscript','html','image']}).panelInstance('area4');
    new nicEditor({maxHeight : 100}).panelInstance('area5');
});

setTimeout(function() {
	
	
    $('#mydiv').fadeOut('slow');
}, 3000);



</script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").validate({
                rules: {
                    "sentMailMasterBean.reciptanceEmailId": "required",
                    "authBean.password": "required"
                },
                messages: {
                    "sentMailMasterBean.reciptanceEmailId": "Please enter reciptance Email id",
                    "authBean.password": "Please enter your Password"
                }/* ,
                 submitHandler: function(form) {
                    form.submit();
                } */
            });
		
    });		
	

</script>
  

<style  type="text/css">

.upload-btn
{
	background-image: ${pageContext.request.contextPath}/img/attach.jpg;
}

</style>


<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Compose Mail</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    
                    <%

			String s = (String)request.getAttribute("name");
			

			if(s==null)
			{
			}
			else{
%>

<!-- <div style="color: blue;font-size: 20px;text-align: center;">Mail Sent Successfully..</div> -->

<div id="mydiv" class="message success"><center><b>Mail Sent Successfully</b></center></div>

<%} %>
                    
                    
                    <s:form action="employee_send_mail_click" cssClass="form" method="post" enctype="multipart/form-data" id="login_frm">
                    	
                    	
                    	<s:textfield name="sentMailMasterBean.reciptanceEmailId" label="To" value="%{sentMailMasterBean.reciptanceEmailId}"  size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    			
                    		
                    	
                    	<s:textfield name="sentMailMasterBean.emailSubject" label="Subject" value="%{sentMailMasterBean.emailSubject}" size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    	<tr>
                    	<s:textarea name="sentMailMasterBean.emailBody" cols="52" id="area1" label="Text" value="%{sentMailMasterBean.emailBody}" rows="" />
                    		
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		
                    		
						<tr>
						<td></td>
						<td><s:a ><s:file theme="simple" cssClass="" name="userImage"/></s:a></td>
						</tr>
							
                    	<tr>
						<td></td>
						<td><s:submit value="Send" name="submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit>
						<s:submit value="Save&cancel" name="submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
						</tr>
						
					</s:form>
					<s:div name="div_content" id="div_content" cssStyle="display:none">
					
							<b>Loading &nbsp;&nbsp;&nbsp;</b><img src="${pageContext.request.contextPath}/img/loading_mail.gif" alt="Ginger" />
						
					</s:div>
					<script type="text/javascript">
					function load_content()
            			{
						 document.getElementById('div_content').style.display='block';
                		}	
					</script>
				

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

