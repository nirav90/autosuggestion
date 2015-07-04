package assys.com.bean.welcome_login;

	/**
	 * @author Nirav
	 *
	 */
public class Registration {
		
		
		private String firstName;
		private String lastName;
		private String email;
		
		private String username;
		private String password;
		private String phone;
		private String gender;
		private String EmployeeID;
		
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getEmployeeID() {
			return EmployeeID;
		}
		public void setEmployeeID(String employeeID) {
			EmployeeID = employeeID;
		}
		
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
}
