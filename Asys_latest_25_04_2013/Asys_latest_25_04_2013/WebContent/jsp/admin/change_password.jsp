<%@page import="assys.com.action.admin.AddUserAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div cssClass="grid_10">
            <s:div cssClass="box round first1 ">
                <h2>Change Password</h2>
                <s:div cssClass="block">
                    <s:div id="chart1">
                    <s:form action="change_password.action" cssClass="form" method="post">
                    	<s:textfield name="addUser.name" label="New Password" value="%{addUser.name}"/>
                    	<s:textfield name="addUser.phone" label="Confirm Password" value="%{addUser.phone}"></s:textfield>
                    	
						
						<tr>
						<td></td>
						<td><s:submit value="Submit" cssClass=" btn-grey btn-person" theme="simple" onclick="load_content()"></s:submit></td>
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
<%-- <% 
String flag;
AddUserAction ad  = new AddUserAction();

flag=ad.add_user_success();

if(flag.equals("true"))
{
	out.print("success");
}
else
{
	out.print("fail");
	}	



%>
					
					
					
					<script language="javascript" type="text/javascript">
            var url = "http://localhost:8089/Asys_latest/jsp/admin/add_user.jsp";
           // var url = "http://localhost:8080/dboperation/ajaxload.jsp";
          
           
          // reload_content();
            function load_content()
            {
                $("#div_content").html("loading..");
                $.ajax({

                       url:url,
                       /* data:{"val":$("#txt1").val(),}, */
                       datatype:"HTML",
                       type:"post",
                       success:function(data)
                            {
                               $("#div_content").append(data);

                            }
                        });

            }

        </script>
				 --%>	
                    </s:div>
               </s:div> 
            </s:div>
            </s:div>

