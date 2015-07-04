<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.util.Random"%>

 
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
                    <s:form action="manager_assign_work_click" cssClass="form" method="post" enctype="multipart/form-data">
                    	
                    	<%
                    	String emailID= request.getParameter("emailId");
                    	request.setAttribute("emailID", emailID);
                    	%>
                    	<s:textfield name="assignWorkMasterBean.reciptanceEmailId" label="To" value="%{#request.emailID}"  size="65" readonly="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		<%
                    		
                    		Random rnd=new Random();
                    		int workId=rnd.nextInt(Integer.MAX_VALUE)+1;
                			String WorkId ="work"+workId;
                			System.out.print(WorkId);
                    		request.setAttribute("WorkId", WorkId);
                    		
                    		HttpSession session1 = ServletActionContext.getRequest().getSession();
            				
            				session1.setAttribute("WorkId", WorkId);
            				request.setAttribute("defValue", 0);
                    		%>
                    		
                    	<s:textfield name="assignWorkMasterBean.workId" label="Work Id" value= "%{#request.WorkId}"  size="65" readonly="true" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>	
                    		
                    		<s:textfield name="assignWorkMasterBean.workMsgSubject" label="Work Subject" value="%{assignWorkMasterBean.workMsgSubject}"  size="65"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
               
                    		<s:textarea name="assignWorkMasterBean.workMsgBody" label="Work Description" value="%{assignWorkMasterBean.workMsgBody}" rows="10" cols="51"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    	
                    	<tr>
                    	<td><s:label theme="simple"><b>Duration:</b></s:label></td>
                    	<td><s:textfield name="assignWorkMasterBean.day" label="Start Time" value="%{#request.defValue}" title="dfdf" size="5" theme="simple"/>:
                    	<s:textfield name="assignWorkMasterBean.hour" label="Start Time" value="%{#request.defValue}"  size="5" theme="simple"/>:
                    	<s:textfield name="assignWorkMasterBean.minute" label="Duration" value="%{#request.defValue}"  size="5" theme="simple"/><b>(Day:hours:Minute)</b></td>
                    	</tr>
               	
						<tr>
						<td></td>
						<%-- <td><s:file value="%{assignWorkMasterBean.fileName}"  theme="simple" cssClass="upload-btn" name="assignWorkMasterBean.fileName"></s:file></td> --%>
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
					  $(function() {
					    $( "#datepicker" ).datepicker();
					  });
					  </script>	
					

                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

