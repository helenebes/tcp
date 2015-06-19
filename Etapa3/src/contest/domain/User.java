package contest.domain;

import java.util.List;

public class User {

	private int id;
	private String userName;
	private String password;
	private String role;
	private String affiliation;
	
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public List<Person> getAffiliation() {
		return null;
	}
	
	public void User() {
		
	}
	
}
