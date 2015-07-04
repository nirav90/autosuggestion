<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbBean.EmpDetailBean"%>
<%@page import="assys.com.dbDAO.EmpDetail"%>
<%@page import="java.util.Map"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="org.apache.struts2.interceptor.SessionAware"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

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
			
			var label1=document.getElementById("text1");
  			var label2=document.getElementById("text2");
		  	/* var gen=document.getElementById("gen");
		  	alert("hi"); */
  			/* var label4=document.getElementById("text4"); */
  			var label5=document.getElementById("text5");
  			var label6=document.getElementById("text6");
  			var label7=document.getElementById("text7");
  			var label8=document.getElementById("text8");
  			var label9=document.getElementById("text9");
  			var label10=document.getElementById("text10");
  		  	
  		/* 	alert("hi"); */
  			//label1.disabled=!label1.disabled;
  			label1.readonly=!label1.readonly;
  			label2.disabled=!label2.disabled;
  	
  			/* gen.disabled=!gen.disabled;
  			alert(gen.disabled);	 */
  			/* label4.disabled=!label4.disabled; */
  	
  			label5.disabled=!label5.disabled;
  	
  			label6.disabled=!label6.disabled;
  	
  			label7.disabled=!label7.disabled;
  	
  			label8.disabled=!label8.disabled;
  			
  			label9.disabled=!label9.disabled;
  			
  			label10.disabled=!label10.disabled;
  	
  			update.style.display="block";
  			
  			edit.style.display="none";
		
  		
		
  	return false;
		
		}
	
	
	
</script>

<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Personal Profile</h2>
                <s:div cssClass="block ">
      
                <%
                

               	 
               	EmpDetailBean empDetailBean = new EmpDetailBean();
               	 String sd = (String)session.getAttribute("employee_ID");
               	  empDetailBean.setEmpUserId(sd); 
               	  
    
               	EmpDetail empDetail = new EmpDetail();
               ResultSet rs=	empDetail.select(empDetailBean);
				%>
				       <s:div id="chart1">
				     
				        
                    <s:form action="employee_Edit_personal_profile_click" cssClass="form" method="post" name="form1">
                    	
                <% 
               	while(rs.next())
               	{
             
               		String first_name= rs.getString("first_name");
               		String last_name= rs.getString("last_name");
               		String address= rs.getString("address");
               		String phone_no= rs.getString("phone_no");
               		DateFormat dateFormatBday=new SimpleDateFormat("yyyy-MM-dd");
               		Date birthdate= rs.getDate("birthdate");
               		String city =rs.getString("add_city");
               		String state =rs.getString("add_state");
               		String country =rs.getString("add_country");
               		String gender=rs.getString("gender");
               		/* out.println(first_name);
               		out.println(last_name);
               		out.println(address);
               		out.println(phone_no);
               		out.println(birthdate);
               		out.println("city:"+city);
               		out.println("state:"+state);
               		out.println("country: "+country);
               		out.println(gender); */
               		request.setAttribute("first_name", first_name);
               		request.setAttribute("last_name", last_name);
               		request.setAttribute("address", address);
               		request.setAttribute("phone_no", phone_no);
               		request.setAttribute("birthdate", birthdate);
               		request.setAttribute("city", city);
               		request.setAttribute("state", state);
               		request.setAttribute("country", country);
               		request.setAttribute("gender", gender);
                %>
             
                    	
                    	<s:textfield name="empDetailBean.firstName" label="First Name"  id="text1" value="%{#request.first_name}" disabled="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the First name</s:label>
                    			<td>
                    		</tr>
                    	
                    	<s:textfield name="empDetailBean.lastName" label="Last Name" value="%{#request.last_name}" id="text2"  disabled="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the  Last name</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	<%-- <s:textfield name="" label="Email Address" value="%{#request.address}" id="text3" size="30" disabled="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Email Address</s:label>
                    			<td>
                    		</tr>
                    	 --%>
                    	
                    	<s:radio list="#{'Male':'Male','Female':'Female'}" name="notification" label="Gender" value="%{#request.gender}" id="gen"></s:radio>
                    	<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Gender</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	
                    	
                    	
                    <s:textarea name="empDetailBean.address" label="Address" value="%{#request.address}" disabled="true" rows="3" cols="20" id="text5"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the  Address</s:label>
                    			<td>
                    		</tr>
                    	
                    <s:textfield name="empDetailBean.addCity" label="City" value="%{#request.city}" disabled="true" id="text10"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the city</s:label>
                    			<td>
                    		</tr>
                    		
                    <s:textfield name="empDetailBean.addState" label="State" value="%{#request.state}" disabled="true" id="text9"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the State</s:label>
                    			<td>
                    		</tr>
                    
                    
                    <s:textfield name="empDetailBean.addCountry" label="Country" value="%{#request.country}" disabled="true" id="text6"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the Country</s:label>
                    			<td>
                    		</tr>
                    
                    
                    
                    
                    <s:textfield name="empDetailBean.phoneNo" label="Phone No" value="%{#request.phone_no}" disabled="true" id="text7" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple">Specify the  Address</s:label>
                    			<td>
                    		</tr>
                    	
                    	
                    	
                    	
<%--                     	<sx:datetimepicker label="Birthdate" name="empDetailBean.birthdate" disabled="false" value="%{#request.birthdate}" id="text8"></sx:datetimepicker> --%>
                    <s:textfield  label="Birthdate " name="empDetailBean.birthdate" disabled="true" value="%{#request.birthdate}" id="text8" cssClass="tcal"> </s:textfield>
                    <tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple" value="Birthdate shown in format (mm/dd/yy)"/>
                    			<td>
                    		</tr>	
                    	<!-- <input type="text" id="date-picker" class="hasDatepicker"> -->
            	
                    		<%} %>
  	
						<tr>
						<td></td>
						<td><s:submit value="Update" cssClass=" btn-grey btn-person" theme="simple" id="update"></s:submit></td>
						</tr>
						<tr>
						<td></td>
						<td><s:submit value="Edit" cssClass=" btn-grey btn-person" theme="simple" onclick="return edit_block()" id="edit"></s:submit></td>
						</tr>
						
					</s:form>
					  <%-- <s:form onsubmit="return edit_block()" cssClass="form">
				       <tr>
				       <td></td><td></td><td></td>
				       		<td><s:submit cssClass=" btn-grey btn-person" theme="simple" value="Edit" align="right"  id="edit"></s:submit></td>
				       </tr>
				       </s:form> --%>
					<s:div name="div_content">
					</s:div>
				
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

