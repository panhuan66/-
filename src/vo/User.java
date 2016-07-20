package vo;

public class User {
	private String email;
	private String ps;

	public User() {
		super();
	}
	
	public User(String email, String ps) {
		super();
		this.email = email;
		this.ps = ps;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}

	
}
