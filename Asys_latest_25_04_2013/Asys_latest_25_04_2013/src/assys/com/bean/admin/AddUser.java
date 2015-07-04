package assys.com.bean.admin;

import java.io.Serializable;

/**
 * @author slesha
 *
 */
public class AddUser implements Serializable{
	private String empCategory;
	private String name;
	private String phone;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmpCategory() {
		return empCategory;
	}

	public void setEmpCategory(String empCategory) {
		this.empCategory = empCategory;
	}
	
	public AddUser()
	{
		this.empCategory=null;
	}

}
