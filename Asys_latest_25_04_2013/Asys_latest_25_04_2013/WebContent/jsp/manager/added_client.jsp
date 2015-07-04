<%@page import="java.sql.ResultSet"%>
<%@page import="assys.com.joinQuery.showEmployeeDetail"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%-- <%@page import="assys.com.dbBean.Client_id_generator_bean"%>
<%@page import="assys.com.dbDAO.Client_id_generator"%>
<%@page import="assys.com.dbBean.Authentication_detail_bean"%>
<%@page import="assys.com.dbDAO.Authentication_detail"%> --%>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Client Register</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    
                    Client ID <b><%=request.getAttribute("clientID1") %></b> already Registered....
					<s:a action="manager_add_client_status_jsp">Back</s:a>                    	
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

