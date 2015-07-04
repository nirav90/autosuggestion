package assys.com.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		String message = "login";
		/*// Take the session map
		Map session = invocation.getInvocationContext().getSession();
		// Read the key from session.
		String userLogedIn = (String) session.get("logedIn");

		*//**
		 * If user is already logged in than the request will be processed. Else
		 * user will redirected to Login page.
		 **//*
		if (userLogedIn != null && userLogedIn.equals("yes")) {
			message = invocation.invoke();
			System.out.println("Go to requested page");
		} else {
			System.out.println("Go to Login page");
		}*/

		HttpSession session = ServletActionContext.getRequest().getSession();
		String emp_id=(String) session.getAttribute("employee_ID");
		System.out.println("in custom interceptor"+emp_id);
		if(emp_id==null)
		{
			return "login";
		}
		else{
			System.out.println("invocatn.invoke"+invocation.invoke().toString());
			return invocation.invoke();
		}
		
	}

}
