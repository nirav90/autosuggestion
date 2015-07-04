<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.AssignWorkMaster"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#login_frm").validate({
                rules: {
                    "sentMailMasterBean.reciptanceEmailId": "required",
                    "workSubmitMasterBean.workId": "required",
                    "sentMailMasterBean.emailSubject": "required",
                    "sentMailMasterBean.emailBody": "required"
                    
                    
                    
                },
                messages: {
                	"sentMailMasterBean.reciptanceEmailId": "Enter Reciptance email id",
                    "workSubmitMasterBean.workId": "Enter work id",
                    "sentMailMasterBean.emailSubject": "Enter email Subject",
                    "sentMailMasterBean.emailBody": "Enter email text"
                     
                }/* ,
                 submitHandler: function(form) {
                    form.submit();
                } */
            });
		
    });		
	

</script>

<script type="text/javascript">
bkLib.onDomLoaded(function() {
    new nicEditor().panelInstance('area1');
    new nicEditor({fullPanel : true}).panelInstance('area2');
    new nicEditor({iconsPath : '../nicEditorIcons.gif'}).panelInstance('area3');
    new nicEditor({buttonList : ['fontSize','bold','italic','underline','strikeThrough','subscript','superscript','html','image']}).panelInstance('area4');
    new nicEditor({maxHeight : 100}).panelInstance('area5');
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
                <h2> Given Work</h2>
                <s:div cssClass="block">
                 <h6><font color="green">Assigned Work Detail</font></h6>
                    <s:div id="chart1">
                    
                    <%-- <jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean" />
							
							<jsp:setProperty name="ContactDetailMasterBean" property="contactId" value="nirav" /> --%>
					<%        
            
						String sd = (String)session.getAttribute("employee_ID");
					
						String wrkID=request.getParameter("workID");
	                    String workId;
	        			String receiptanceId;
	        			String[] temp;
	        			temp = wrkID.split("-", 2);
	        			for(int i =0; i < temp.length ; i++)
	        			{System.out.println(temp[i]);
	        			
	        			}
	        			workId=temp[0];
	        			receiptanceId=temp[1];
						
						AssignWorkMasterBean assignWorkMasterBean = new   AssignWorkMasterBean();
						
						
						
						assignWorkMasterBean.setWorkId(workId);
						
						
						
						AssignWorkMaster assignWorkMaster = new AssignWorkMaster();
						
						ResultSet rs =  assignWorkMaster.select(assignWorkMasterBean);
						if(!rs.next()){%>
						<h6><font color="red">Your Work Already has been approved....</font></h6>
						<u><s:a href="employee_work_submited_jsp.action">back...</s:a></u>
						
						<%
							request.setAttribute("if", "if");	
						}
						else{
							rs.beforeFirst();	
						
							while(rs.next())
							{
								
								String To = rs.getString(4);
								String workIds = rs.getString(2);
								String worksubject = rs.getString(5);
								String workdescription = rs.getString(6);
								String Duration = rs.getString(8);
								
								request.setAttribute("To", To);
								request.setAttribute("workId", workIds);
								request.setAttribute("worksubject", worksubject);
								request.setAttribute("workdescription", workdescription);
								request.setAttribute("Duration", Duration);
								
							
						
						
						
						%>	
					<s:form action="employee_Edit_Contact_detail_click" cssClass="form" method="post">
					
					
					<s:textfield label="To" name="assignWorkMasterBean.reciptanceEmailId" value="%{#request.To}" readonly="true" id="Firstname" size="40"/>
					
							
					<s:textfield name="assignWorkMasterBean.workId" value="%{#request.workId}" label="Work Id" readonly="true" id="Lastname" size="40"/>
					
					<s:textfield name="assignWorkMasterBean.workMsgSubject" label="Work Subject" value="%{#request.worksubject}" readonly="true" id="EmailAddress" size="40"/>
					
					<s:textarea name="assignWorkMasterBean.workMsgBody" label="Work Description" value="%{#request.workdescription}" readonly="true" rows="4" id="Address" cols="32"/>
							
					
							
					<s:textfield name="assignWorkMasterBean.duration" label="Duration" value="%{#request.Duration}" readonly="true" id="MobileNo" size="40"/>
							
					
					</s:form>
					<%	
							}
						}
					%>
					
				
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>


<%      
            String ifs=(String)request.getAttribute("if");
			if(ifs!=null){
				
			}
			else{
             %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
            
                <h2>Submit Work</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <%
                    
                    String wrkID=request.getParameter("workID");
                    String workId;
        			String receiptanceId;
        			String[] temp;
        			temp = wrkID.split("-", 2);
        			for(int i =0; i < temp.length ; i++)
        			{System.out.println(temp[i]);
        			
        			}
        			workId=temp[0];
        			receiptanceId=temp[1];
        			request.setAttribute("workId",workId );
        			request.setAttribute("receiptanceId",receiptanceId );

                    %>
                    <s:form id="login_frm" action="employee_work_submit_click" cssClass="form" method="post" enctype="multipart/form-data">
                    	
                    	
                    	<s:textfield name="sentMailMasterBean.reciptanceEmailId" label="To" value="%{#request.receiptanceId}"  size="65" readonly="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    	<s:textfield name="workSubmitMasterBean.workId" label="Work Id" value="%{#request.workId}"  size="65" readonly="true"/>
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
                    		
                    	
                    		
                    		
                    		<s:textarea name="sentMailMasterBean.emailBody" id="area1" label="Work Description" value="%{sentMailMasterBean.emailBody}" rows="0" cols="51"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    	
                    		
                    		
                    		
						<tr>
						<td></td>
						<%-- <td><s:file value="%{sentMailMasterBean.attachFile}"  theme="simple" cssClass="upload-btn" name="sentMailMasterBean.attachFile"></s:file></td> --%>
						<td><s:file  theme="simple" cssClass="upload-btn" name="userImage"></s:file></td>
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
 <%
					 } 
					%>
