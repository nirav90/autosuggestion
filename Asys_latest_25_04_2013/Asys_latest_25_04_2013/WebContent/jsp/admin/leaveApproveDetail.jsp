<%@page import="com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher"%>
<%@page import="assys.com.dbDAO.LeaveMaster"%>
<%@page import="assys.com.dbBean.LeaveMasterBean"%>
<%@page import="assys.com.dbDAO.EmpDetail"%>
<%@page import="assys.com.dbBean.EmpDetailBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.GmailAuthentication"%>
<%@page import="assys.com.dbBean.GmailAuthenticationBean"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<style  type="text/css">

.upload-btn
{
	background-image: ${pageContext.request.contextPath}/img/attach.jpg;
}

</style>


<%

			/* String leaveId = request.getParameter("leaveID"); */
			String empid = request.getParameter("empID");
			System.out.println("Emp ID Get From Request Object"+empid);
			String empid1;
			String leaveId1;
			String[] temp;
			temp = empid.split("-", 2);
			for(int i =0; i < temp.length ; i++)
			{System.out.println(temp[i]);
			
			}
			empid1=temp[1];
			leaveId1=temp[0];
			System.out.println("split leave  id:::"+leaveId1);
			System.out.println("emp id"+empid1);
			System.out.println(empid);
			request.setAttribute("leaveId", leaveId1);
			request.setAttribute("empid",empid1);
			 
			 
			 
			EmpDetailBean empDetailBean = new EmpDetailBean();
			empDetailBean.setEmpUserId(empid1);

			EmpDetail empDetail = new EmpDetail();
			
			ResultSet rs = empDetail.select(empDetailBean);
			
			
			while(rs.next())
			{
				String name = rs.getString(2);
				request.setAttribute("name", name);
			}
			
			LeaveMasterBean leaveMasterBean = new LeaveMasterBean();
			
			leaveMasterBean.setLeaveId(leaveId1);
			leaveMasterBean.setEmpUserId(empid1);
			LeaveMaster leaveMaster  = new LeaveMaster();
			
			ResultSet rs1 = leaveMaster.select(leaveMasterBean);
			
			
			
			while(rs1.next())
			{
			
				String fromid = rs1.getString(3);
				String fromdate = rs1.getString(7);
				String todate = rs1.getString(8);
				String subject = rs1.getString(5);
				String body = rs1.getString(6);
			
				request.setAttribute("fromid", fromid);
				request.setAttribute("fromdate", fromdate);
				request.setAttribute("todate", todate);
				request.setAttribute("subject", subject);
				request.setAttribute("body", body);
				
				
			}	
				
		

%>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Leave Detail</h2>
                <s:div cssClass="block">
                
                    <s:div id="chart1">
                    <s:form action="admin_leaveApprove_click" cssClass="form" method="post">
                    	
                    	<s:hidden name="leaveMasterBean.empUserId" value="%{#request.empid}"> </s:hidden>
                    	<s:hidden name="leaveMasterBean.leaveId" value="%{#request.leaveId}"></s:hidden>
                    	<s:textfield name="empDetailBean.firstName" label="Name" value="%{#request.name}"  size="65"  readonly="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
             	
             				
             				<s:textfield name="leaveMasterBean.reciptanceEmailId" label="email" value="%{#request.fromid}" size="65" readonly="true" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
             	
             	
             	
                    	
                    	<s:textfield name="leaveMasterBean.leaveSubject" label="Subject" value="%{#request.subject}" size="65" readonly="true" />
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		<s:textfield name="leaveMasterBean.leaveFromDate" label="From" value="%{#request.fromdate}" size="30" readonly="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		<s:textfield name="leaveMasterBean.leaveToDate" label="To" value="%{#request.todate}" size="30" readonly="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		
                    		
                    		<s:textarea name="leaveMasterBean.leaveBody" label="causes" value="%{#request.body}" rows="10" cols="51" readonly="true"/>
                    		<tr>
                    		<td></td>
                    			<td>
                    				<s:label theme="simple"></s:label>
                    			<td>
                    		</tr>
                    		
                    		
                    		
                    	
							
                    	<tr>
						<td></td>

						</tr>
						
					</s:form>
					<s:div name="div_content">
					</s:div>
					
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

