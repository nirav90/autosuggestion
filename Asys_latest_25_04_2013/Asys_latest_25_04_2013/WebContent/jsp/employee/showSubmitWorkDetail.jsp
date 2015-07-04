<%@page import="assys.com.dbBean.AssignWorkMasterBean"%>
<%@page import="assys.com.dbDAO.AssignWorkMaster"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbDAO.WorkSubmitMaster"%>
<%@page import="assys.com.dbBean.WorkSubmitMasterBean"%>
<%@page import="assys.com.action.admin.AddUserAction"%>
<%@page import="assys.com.joinQuery.ShowContacts"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

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


<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2> Submitted Work</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    
                    <%-- <jsp:useBean id="ContactDetailMasterBean"  class="assys.com.dbBean.ContactDetailMasterBean" />
							
							<jsp:setProperty name="ContactDetailMasterBean" property="contactId" value="nirav" /> --%>
					<%
                    String wrkID=request.getParameter("WorkId");
                    String workID;
        			String approveWork;
        			String[] temp;
        			temp = wrkID.split("-", 2);
        			for(int i =0; i < temp.length ; i++)
        			{System.out.println(temp[i]);
        			
        			}
        			workID=temp[0];
        			approveWork=temp[1];
        			boolean apprvWork=false;
        			if(approveWork.equals("0")){
        				apprvWork=false;
        			}
        			if(approveWork.equals("1")){
        				apprvWork=true;
        			}
            
						String sd = (String)session.getAttribute("employee_ID");
					
						
						
						WorkSubmitMasterBean workSubmitMasterBean = new WorkSubmitMasterBean();
						WorkSubmitMaster workSubmitMaster = new WorkSubmitMaster();
						workSubmitMasterBean.setWorkId(workID);
						workSubmitMasterBean.setWorkApprove(apprvWork);
						ResultSet rs1=workSubmitMaster.select(workSubmitMasterBean);
						
						while(rs1.next())
						{
							
							String To = rs1.getString("reciptance_email_id");
							String workId = rs1.getString(2);
							String worksubject = rs1.getString("work_msg_subject");
							String workdescription = rs1.getString(6);
							
							request.setAttribute("To", To);
							request.setAttribute("workId", workId);
							request.setAttribute("worksubject", worksubject);
							request.setAttribute("workdescription", workdescription);
							
							
							
						
						
						
						%>	
					<s:form action="employee_Edit_Contact_detail_click" cssClass="form" method="post">
					
					
					
					<s:textfield label="To" name="" value="%{#request.To}" readonly="true" id="Firstname" size="40"/>
					
							
					<s:textfield name="" value="%{#request.workId}" label="Work Id" readonly="true" id="Lastname" size="40"/>
					
					<s:textfield name="" label="Work Subject" value="%{#request.worksubject}" readonly="true" id="EmailAddress" size="40"/>
					
					<s:textarea name="" label="Work Description" value="%{#request.workdescription}" readonly="true" rows="4" id="Address" cols="32"/>
							
					
							
					
							
					
					</s:form>
					<%	
						}
					%>
					
				
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

