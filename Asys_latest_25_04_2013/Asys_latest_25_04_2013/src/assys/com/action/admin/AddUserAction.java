package assys.com.action.admin;

import assys.com.DAO.admin.AddUserDAO;
import assys.com.bean.admin.AddUser;

/**
 * @author slesha
 *
 */
public class AddUserAction {
	
	private AddUser addUser;
	AddUserDAO addUserDAO=new AddUserDAO();
	boolean flag=false;
	public String add_user_success()
	{
		
		System.out.println("in login_success");
		flag=addUserDAO.add_user_insert(addUser);
		
		if(flag==true)
		{
			return "true";
		}
		else
		{
			return "false";
		}
		
	}
	
	public AddUser getAddUser() {
		return addUser;
	}
	public void setAddUser(AddUser addUser) {
		this.addUser = addUser;
	}
}
