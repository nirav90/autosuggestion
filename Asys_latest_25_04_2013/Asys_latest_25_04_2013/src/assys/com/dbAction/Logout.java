package assys.com.dbAction;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class Logout {
	
	

		public String execute()
		{
		       HttpSession ss   =  ServletActionContext.getRequest().getSession();  
		       
		       ss.invalidate();
			
			return "SUCCESS";
			
		}
		
		
		
		
		
		
}
