package contest.domain;

import java.util.List;

public class User extends Person implements Credentials{

	private int id;
	private String userName;
	private String password;
	private String role;
	private List<Person> affiliation;
	
	public User(String lastName, String firstName, int id, String userName, String password, String role,
			List<Person> affiliation) {
		super(lastName, firstName);
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.affiliation = affiliation;
	}
	
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
	
}
