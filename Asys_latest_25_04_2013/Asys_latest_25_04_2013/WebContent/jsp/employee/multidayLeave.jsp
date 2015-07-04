<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
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
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").validate({
                rules: {
                    "leaveMasterBean.leaveFromDate": "required",
                    "leaveMasterBean.leaveToDate": "required"
                },
                messages: {
                    "leaveMasterBean.leaveFromDate": "Please enter From Date",
                    "leaveMasterBean.leaveToDate": "Please enter To Date"
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


<%

						String id= null;

							GmailAuthenticationBean gmailAuthenticationBean = new GmailAuthenticationBean();
							gmailAuthenticationBean.setUserName("Admin");
							
							GmailAuthentication gmailAuthentication = new GmailAuthentication();
							 
							ResultSet rs = gmailAuthentication.select(gmailAuthenticationBean);
							
							while(rs.next())
							{
		               				id=	rs.getString(3);
								
		               				System.out.println(id);
		               				
		               				request.setAttribute("id", id);
		               				
							}
								



%>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Multiday Leave</h2>
                <s:div cssClass="block">
                
                    <s:div id="chart1">
                    <s:form action="employee_emergencyLeave_click" cssClass="form" method="post" id="login_frm" name="login_frm">
                    	
                    	
                    	<s:textfield name="leaveMasterBean.reciptanceEmailId" label="To" value="%{#request.id}"  size="65" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
             	
                    	
                    	<s:textfield name="leaveMasterBean.leaveSubject" label="Subject" value="Multiday Leave " size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		<s:textfield name="leaveMasterBean.leaveFromDate" label="From" value="%{leaveMasterBean.leaveFromDate}" size="23" cssClass="tcal"/>
                    		
                    		<s:textfield name="leaveMasterBean.leaveToDate" label="To" value="%{leaveMasterBean.leaveToDate}" size="23" cssClass="tcal" />
                    		
                    		
                    		
                    		
                    		<s:textarea name="leaveMasterBean.leaveBody" label="causes" id="area1" value="%{leaveMasterBean.leaveBody}" rows="0" cols="51" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		
                    	
							
                    	<tr>
						<td></td>
						<td><s:submit value="Submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
						</tr>
						
					</s:form>
					<s:div name="div_content">
					</s:div>
					

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

