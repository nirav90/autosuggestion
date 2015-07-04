<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<style  type="text/css">

.upload-btn
{
	background-image: ${pageContext.request.contextPath}/img/attach.jpg;
}

</style>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Assign Work</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="employee_send_mail_click" cssClass="form" method="post" enctype="multipart/form-data">
                    	
                    	
                    	<s:textfield name="sentMailMasterBean.reciptanceEmailId" label="To" value="%{sentMailMasterBean.reciptanceEmailId}"  size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    	<s:textfield name="" label="Work Id" value=""  size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>	
                    		
                    		<s:textfield name="sentMailMasterBean.emailSubject" label="Work subject" value="%{sentMailMasterBean.emailSubject}"  size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>	
                    		
                    	
                    		
                    		
                    		<s:textarea name="sentMailMasterBean.emailBody" label="Work Description" value="%{sentMailMasterBean.emailBody}" rows="10" cols="51"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    	
                    		
                    		
                    		
						<tr>
						<td></td>
						<td><s:file value="%{sentMailMasterBean.attachFile}"  theme="simple" cssClass="upload-btn" name="sentMailMasterBean.attachFile"></s:file></td>
						</tr>
							
                    	<tr>
						<td></td>
						<td><s:submit value=" Send" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
						</tr>
						
					</s:form>
					<s:div name="div_content">
					</s:div>
					<script>
					function load_content()
            			{
                			$("#div_content").html("<h3>Loading.......</h3>");
                		}	
					</script>

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

