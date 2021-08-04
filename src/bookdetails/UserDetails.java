package bookdetails;

public class UserDetails {
public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public void setRole(String role) {
		this.role = role;
	}
private String userId;
private String password;
private String role;
	
}
