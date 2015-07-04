<%@page import="assys.com.action.admin.AddUserAction"%>
<% 
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