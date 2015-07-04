<%@page import="java.sql.ResultSet"%>
<%-- <%@page import="assys.com.dbDAO.Contact_detail_master"%>
<%@page import="assys.com.dbDAO.Contact_email_detail"%>
<%@page import="assys.com.dbDAO.Contact_phone_no_detail"%>
<%@page import="assys.com.dbBean.Contact_detail_master_bean"%>
<%@page import="assys.com.dbBean.Contact_email_detail_bean"%>
<%@page import="assys.com.dbBean.Contact_phone_no_detail_bean"%> --%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="assys.com.joinQuery.ShowContacts"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

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

<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Add Project</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <%
                    String sd = (String)session.getAttribute("employee_ID");
                    String clientID=(String) request.getAttribute("clientID1");
                    request.setAttribute("clientID",clientID);
                    String clientName=(String)request.getAttribute("clientName");
                    request.setAttribute("clientName", clientName);
                    String clientCompanyName=(String)request.getAttribute("clientCompanyName");
                    request.setAttribute("clientCompanyName", clientCompanyName);
                    %>
                    
                    
                    <s:form action="manager_add_project_click" cssClass="form" method="post">
					<s:textfield label="Client ID" name="projectDetailBean.clientEmpUserId" size="50" value="%{projectDetailBean.clientEmpUserId}" id="clientID"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Shows generated Client ID</s:label>
                    			<td>
                    		</tr>
                    		
					<s:textfield name="projectDetailBean.clientName" size="50" value="%{projectDetailBean.clientName}" label="Client Name" id="clnEmailId"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Email ID of client on which ClientID be send</s:label>
                    			<td>
                    		</tr>
                    		
                    <s:textfield name="projectDetailBean.projectName" size="50" value="%{projectDetailBean.projectName}" label="Project Name" id="clnEmailId"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Shows the Client Name</s:label>
                    			<td>
                    </tr>
                    		
                    <s:textfield name="projectDetailBean.startingDateOfProject"  size="23" value="%{projectDetailBean.startingDateOfProject}" label="Starting Date of Project" cssClass="tcal" />
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Shows the Company Name of the Client</s:label>
                    			<td>
                    </tr>
                    
                    <s:textfield name="projectDetailBean.endDateOfProject" size="23" value="%{projectDetailBean.endDateOfProject}" label="Ending Date of Project" cssClass="tcal" />
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Add Phone Number of the Client</s:label>
                    			<td>
                    </tr>
                    
                    <s:textarea name="projectDetailBean.projectDesc" value="%{projectDetailBean.projectDesc}" label="Project Description" rows="4" cols="15" id="clnEmailId"/>
					<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Add Phone Number of the Client</s:label>
                    			<td>
                    </tr>	
                    	<td></td>
						
						<td><s:submit value="Register" cssClass=" btn-grey btn-person" theme="simple" id="update"></s:submit></td>
					
					</s:form>
                    
                    
                    
                    
                    
                    
				<s:div name="div_content">
		
					</s:div>
					<script>
					function load_content()
            			{
                			$("#div_content").css('background-color', 'black');
                		}	
					</script>

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

                    