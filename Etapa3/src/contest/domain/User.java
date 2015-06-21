package contest.domain;

import java.util.List;

public class User extends Person{

	private int id;
	private String userName;
	private String password;
	private String role;
	private List<Person> affiliation;
	
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
		return affiliation;
	}
	
	public void User() {
		
	}
	
}
