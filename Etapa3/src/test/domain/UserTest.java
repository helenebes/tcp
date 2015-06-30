package test.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import contest.domain.Person;
import contest.domain.User;

public class UserTest {
	
	User user;
	List<Person> affiliation;

	@Test
	public void CheckIdTest() {
		affiliation = new ArrayList<Person>();
		user = new User("Silva", "guilherme", 1, "userName", "password", "secretaria", affiliation);
		assertEquals(user.getId(), 1);
	}
	
	@Test
	public void CheckLastName() {
		affiliation = new ArrayList<Person>();
		user = new User("Silva", "guilherme", 1, "userName", "password", "secretaria", affiliation);
		assertEquals(user.getLastName(), "Silva");
	}
	
	@Test
	public void CheckFirstName() {
		affiliation = new ArrayList<Person>();
		user = new User("Silva", "guilherme", 1, "userName", "password", "secretaria", affiliation);
		assertEquals(user.getFirstName(), "guilherme");
	}
	
	@Test
	public void CheckUserName() {
		affiliation = new ArrayList<Person>();
		user = new User("Silva", "guilherme", 1, "userName", "password", "secretaria", affiliation);
		assertEquals(user.getUserName(), "userName");
	}
	
	@Test
	public void CheckPassword() {
		affiliation = new ArrayList<Person>();
		user = new User("Silva", "guilherme", 1, "userName", "password", "secretaria", affiliation);
		assertEquals(user.getPassword(), "password");
	}

	@Test
	public void CheckRole() {
		affiliation = new ArrayList<Person>();
		user = new User("Silva", "guilherme", 1, "userName", "password", "secretaria", affiliation);
		assertEquals(user.getRole(), "secretaria");
	}
	
	@Test
	public void CheckAffiliation() {
		affiliation = new ArrayList<Person>();
		Person person1 = new User("Silva", "Maria", 2, "userName", "password", "madre", null);
		affiliation.add(person1);
		user = new User("Silva", "guilherme", 1, "userName", "password", "secretaria", affiliation);
		assertTrue(user.getAffiliation().contains(person1));
	}
}
