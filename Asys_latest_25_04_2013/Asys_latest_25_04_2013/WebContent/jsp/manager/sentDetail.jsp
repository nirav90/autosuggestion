<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.dbBean.SentMailMasterBean"%>
<%@page import="assys.com.dbDAO.SentMailMaster"%>
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
                <h2>Sent Mail Content</h2>
                <s:div cssClass="block">
                 <s:div id="chart1">
                <%
                
                
                String sd = (String)session.getAttribute("employee_ID");
                
            	String s = request.getParameter("sentId");
            	
            	SentMailMasterBean sentMailMasterBean = new SentMailMasterBean();
            	
            	sentMailMasterBean.setSentId(s);
            	
            	SentMailMaster sentMailMaster = new SentMailMaster();
            	
               	ResultSet rs =  sentMailMaster.select(sentMailMasterBean);
                 
               	while(rs.next())
               	{
               			
                
                %>
                   
					Message Subject:<%= rs.getString("email_subject")%><br/>
					Message Body:<%=rs.getString("email_body") %>                   
					
					<%} %>
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

