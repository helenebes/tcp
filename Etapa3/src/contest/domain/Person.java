package contest.domain;

public class Person {

	protected String firstName;
	protected String lastName;
	
	public Person(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
}
