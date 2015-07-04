<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbBean.DraftMasterBean"%>
<%@page import="assys.com.dbDAO.DraftMaster"%>
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
                <h2>Draft Mail</h2>
                <s:div cssClass="block">
                
                <%
                
                
                String sd = (String)session.getAttribute("employee_ID");
                
            	String s = request.getParameter("draftId");
            	
            	DraftMasterBean draftMasterBean = new DraftMasterBean();
            	
            	draftMasterBean.setDraftId(s);
            	
            	DraftMaster draftMaster = new DraftMaster();
            	
               	ResultSet rs =  draftMaster.select(draftMasterBean);
                 
               	while(rs.next())
               	{
               		String to = rs.getString("email_id");
               		String subject = rs.getString("draft_subject");
               		String body = rs.getString("draft_body");
               		
               		
               		request.setAttribute("to", to);
               		request.setAttribute("subject", subject);
               		request.setAttribute("body", body);
               	}	
               		
                
                %>
                    <s:div id="chart1">
                    <s:form action="employee_send_mail_click" cssClass="form" method="post" enctype="multipart/form-data">
                    	
                    	
                    	<s:textfield name="sentMailMasterBean.reciptanceEmailId" label="To" value="%{#request.to}"  size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    	<%-- <s:textfield name="" label="Cc" value=""  size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>	
                    	 --%>	
                    	
                    	<s:textfield name="sentMailMasterBean.emailSubject" label="Subject" value="%{#request.subject}" size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		<s:textarea name="sentMailMasterBean.emailBody" label="Text" value="%{#request.body}" rows="10" cols="51"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		
                    		
						<%-- <tr>
						<td></td>
						<td><s:file theme="simple" cssClass="upload-btn" name="userImage" /></td>
						</tr> --%>
							
                    	<tr>
						<td></td>
						<td><s:submit value="Send" name="submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit>
					</td>
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

