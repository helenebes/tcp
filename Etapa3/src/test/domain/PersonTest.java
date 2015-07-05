package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Person;

public class PersonTest {
	
	Person person;

	@Test
	public void CheckFirstNameTest() {
		person = new Person("besancon", "helene");
		assertEquals(person.getFirstName(), "helene");
	}
	
	@Test
	public void CheckLastNameTest() {
		person = new Person("besancon", "helene");
		assertEquals(person.getLastName(), "besancon");
	}

}
