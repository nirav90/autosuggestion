<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Add New User</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="add_user_click" cssClass="form" method="post">
                    	<s:textfield name="name" label="Name"/>
                    	<s:textfield name="sentMailMasterBean.reciptanceEmailId" label="Email ID" value="%{sentMailMasterBean.reciptanceEmailId}"></s:textfield>
                    	
						<s:select list="#{'Employee':'Employee','Project Manager':'Project Manager','Client':'Client'}" name="empUserIdBean.empCategory" label="Select Category" value="%{empUserIdBean.empCategory}"/>
						<tr>
						<td></td>
						<td><s:submit value="Add User" cssClass="btn-icon btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
						</tr>
						<%-- <s:submit value="Add User" cssClass="btn-icon btn-grey btn-person"/>
						<button class="btn-icon btn-grey btn-person"><span></span>Add User</button> --%>
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

