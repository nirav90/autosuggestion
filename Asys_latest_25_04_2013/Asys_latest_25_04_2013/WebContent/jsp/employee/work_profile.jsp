<%@page import="assys.com.dbDAO.WorkProfileDetail"%>
<%@page import="assys.com.dbBean.WorkProfileDetailBean"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style type="text/css">  
 #update
{
	display:none;
}
#edit
{
	display:block;
}

</style>



<script type="text/javascript" language="javascript">
	
	
	
	function edit_block()
		{
				
			var label1=document.getElementById("txt1");
  			var label2=document.getElementById("txt2");
		  	var label3=document.getElementById("txt3"); 
  			var label4=document.getElementById("txt4");
  			  	
  	
  			label1.disabled=!label1.disabled;
  	
  			label2.disabled=!label2.disabled;
  	
  			label3.disabled=!label3.disabled; 
  	
  			label4.disabled=!label4.disabled;
  	
  			
  			update.style.display="block";
  			
  			edit.style.display="none";
			
  			return false;
		
		}
	
	
	
</script>



<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Work  Profile</h2>
                <s:div cssClass="block">
                 <s:div id="chart1">
                <%
                

               	 
               	WorkProfileDetailBean workProfileDetailBean = new WorkProfileDetailBean();
 
               	String sd = (String)session.getAttribute("employee_ID");
               	workProfileDetailBean.setEmpUserId(sd); 
               	//out.print(sd);
    
               	WorkProfileDetail workProfileDetail = new WorkProfileDetail();
               
               	ResultSet rs= workProfileDetail.select(workProfileDetailBean);	
               
               	
               	if(rs.next())
               	{
               		
               			
               		
               %>
               
                    	
                    	
                    	
                    	<%
                    	rs.beforeFirst();
                    	while(rs.next())
                    	{
                    		
                    		String experience= rs.getString("experience");
                       		String designation= rs.getString("designation");
                       		String skill= rs.getString("skill");
                       		String qualification= rs.getString("qualification");
                       		
                       		request.setAttribute("qualification", qualification);
                       		request.setAttribute("designation", designation);
                       		request.setAttribute("experience", experience);
                       		request.setAttribute("skill", skill);
                    	}	
                    		
                    		
                    	
                    	%>
               <s:form action="employee_edit_work_profile_click" cssClass="form" method="post">     	
                    	<s:textfield name="workProfileDetailBean.experience" label="Experience" value="%{#request.experience}" disabled="true" id="txt1"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Experience of employee</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textarea name="workProfileDetailBean.designation" label="Designation" value="%{#request.designation}" rows="4" cols="15" disabled="true" id="txt2"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify Designation</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	<s:textarea name="workProfileDetailBean.skill" label="Skill" value="%{#request.skill}" rows="4" cols="15" disabled="true" id="txt3"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Skill of Employee</s:label>
                    			<td>
                    		</tr>
             	
                    <s:textfield name="workProfileDetailBean.qualification" label="Qualification" value="%{#request.qualification}"  size="25" disabled="true" id="txt4"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Qualification</s:label>
                    			<td>
                    		</tr>
                    	
                    	
							
						<tr>
						<td></td>
						<td><s:submit value="Save Changes" cssClass="btn-grey btn-person" theme="simple" id="update"></s:submit></td>
						</tr>
						<tr>
						<td></td>
						<td><s:submit value="Edit" cssClass=" btn-grey btn-person" theme="simple" onclick="return edit_block()" id="edit"></s:submit></td>
					</tr>
					</s:form>
				
				<%-- <s:form onsubmit="return edit_block();" cssClass="form">
			       <tr>
			       <td></td><td></td><td></td>
			       		<td><s:submit cssClass="btn-grey btn-person" theme="simple" value="Edit" align="right"  id="edit"></s:submit></td>
			       </tr>
			    </s:form> --%>
               	
					
					<% 
               	}
               	else
               	{	
				%>
                
                 
                   <s:form action="employee_add_work_profile_click" cssClass="form" method="post">
                    	
                    	
                    	<s:textfield name="workProfileDetailBean.experience" label="Experience" value="%{workProfileDetailBean.experience}"  id="txt1"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Experience of employee</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textarea name="workProfileDetailBean.designation" label="Designation" value="%{workProfileDetailBean.designation}" rows="7"  id="txt2"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify Designation</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	<s:textarea name="workProfileDetailBean.skill" label="Skill" value="%{workProfileDetailBean.skill}" rows="7"  id="txt3"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Skill of Employee</s:label>
                    			<td>
                    		</tr>
             	
                    <s:textfield name="workProfileDetailBean.qualification" label="Qulification" value="%{workProfileDetailBean.qualification}"  size="25"  id="txt4"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the  Address</s:label>
                    			<td>
                    		</tr>
     <tr>
						<td></td>
						<td><s:submit value="Save Changes" cssClass=" btn-grey btn-person" theme="simple" ></s:submit></td>
						</tr>
						
					</s:form>	
				<%
				
               	}
				%>	
					
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

