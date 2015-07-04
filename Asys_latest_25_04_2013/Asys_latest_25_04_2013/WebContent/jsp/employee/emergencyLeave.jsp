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
  

<style type="text/css">
        #progress-bar
        {
            width: 400px;
        }
    </style>
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
                <h2>Emergency Leave</h2>
                <s:div cssClass="block">
                
                    <s:div id="chart1">
                    <s:form action="employee_emergencyLeave_click" cssClass="form" method="post">
                    	
                    	
                    	<s:textfield name="leaveMasterBean.reciptanceEmailId" label="To" value="%{#request.id}"  size="65" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
             	
                    	
                    	<s:textfield name="leaveMasterBean.leaveSubject" label="Subject" value="Emergency Leave" size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		<s:textfield name="leaveMasterBean.leaveFromDate" cssClass="tcal" label="From" value="%{leaveMasterBean.leaveFromDate}" size="23"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"><b>Formate (yyyy-MM-dd)</b></s:label>
                    			<td>
                    		</tr>
                    		
                    		<s:textfield name="leaveMasterBean.leaveToDate" cssClass="tcal" label="To" value="%{leaveMasterBean.leaveToDate}" size="23"/>
                    		<tr>
                    		<td>
                    		
                    		</td>
                    			<td>
                    				<s:label theme="simple"><b>Formate (yyyy-MM-dd)</b></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		
                    		
                    		<s:textarea cssClass="tinymce" cols="50" id="area1"  name="leaveMasterBean.leaveBody" label="Reasons for Absence" value="%{leaveMasterBean.leaveBody}" rows="0" />
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

