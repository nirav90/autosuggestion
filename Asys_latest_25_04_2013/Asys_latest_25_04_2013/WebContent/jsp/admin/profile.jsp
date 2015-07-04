<%@page import="assys.com.dbDAO.WorkProfileDetail"%>
<%@page import="assys.com.dbBean.WorkProfileDetailBean"%>
<%@page import="assys.com.dbAction.employee.Work_profile"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbBean.EmpDetailBean"%>
<%@page import="assys.com.dbDAO.EmpDetail"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="grid_10">
            <div class="box round first1">
                <h2>
                    Profile</h2>
                    
                   	
                    	
                    	
                    <% 
                    
                    String sd = (String)session.getAttribute("employee_ID");
                    EmpDetailBean empDetailBean = new EmpDetailBean();
                    
                    empDetailBean.setEmpUserId(sd);
                    EmpDetail empDetail = new EmpDetail();
                    
                    ResultSet rs = empDetail.select(empDetailBean);
                    
                    
                    while(rs.next())
                    {	
                    %>
                <div class="block">
                	
							
                    <div id="chart1">
                    <s:form cssClass="form">
                    <fieldset>
                    
                    <table>
                    <tr>
                    <td><img src="${pageContext.request.contextPath}/img/profile_pc.jpg"/></td>
                    </tr>
                    
                 </table>
                    
  					<legend ><h4 style="color: #1B548D">Personal Profile:</h4></legend>
                    
                    <table width="100%" style="line-height:20px;">
                    
                    
                    
                    
                    
                    <tr>
                    <td><b>First Name</b></td><td>:</td><td><%= rs.getString("first_name")%></td>
                    </tr>
                    <tr>
                    <td><b>Last Name</b></td><td>:</td><td><%= rs.getString("last_name")%></td>
                    </tr>
                    
                    <%-- <tr>
                    <td><b>Birth Date</b></td><td>:</td><td><%= rs.getString("birthdate")%></td>
                    </tr> --%>
                    
                    <tr>
                    <td><b>Gender</b></td><td>:</td><td><%= rs.getString("gender")%></td>
                    </tr>
                    
                   <tr>
                    <td><b>Phone No</b></td><td>:</td><td><%= rs.getString("phone_no")%></td>
                    </tr>
                    
                    
                    <%-- <tr>
                    <td><b>Address</b></td><td>:</td><td><%= rs.getString("address")%></td>
                    </tr> --%>
                    </table>
                    </fieldset>
                    </s:form>
                    <%} %>
                    
                    
                    
                    <% 
					
                    
                    	WorkProfileDetailBean	workProfileDetailBean = new WorkProfileDetailBean();
                    	
                    	WorkProfileDetail  workProfileDetail = new WorkProfileDetail();
                    	
                    	
                    	workProfileDetailBean.setEmpUserId(sd);
                    	
                    	ResultSet rs1 = workProfileDetail.select(workProfileDetailBean);
                    	
                    	
                    	
                    	while(rs1.next())
                    	{
                  
                    %>
                    
                     <s:form cssClass="form">
                    <fieldset>
  					<legend><h4 style="color: #1B548D ;text-align: center;">Work Profile:</h4></legend>
                    
                    <table width="100%" style="line-height:20px;">
                    <tr>
                    <td><b>Experience</b></td><td>:</td><td><%= rs1.getString("experience")%></td>
                    </tr>
                    <tr>
                    <td><b>Designation:</b></td><td>:</td><td><%= rs1.getString("designation")%></td>
                    </tr>
                    
                    <tr>
                    <td><b>Skill:</b></td><td>:</td><td><%= rs1.getString("skill")%></td>
                    </tr>
                    
                    <tr>
                    <td><b>Qualification</b></td><td>:</td><td><%= rs1.getString("qualification")%></td>
                    </tr>
                    
                    </table>
                    </fieldset>
                    </s:form>
                    <%} %>
                    
                    
                    
                    
                    
                    
                    </div>
                </div>
            </div>

        </div>
                <div class="clear">
        </div>
    </div>
