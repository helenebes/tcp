package test.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import contest.domain.ExaminationBoard;
import contest.domain.Person;

public class ExaminationBoardTest {
	
	ExaminationBoard examinationBoard;
	Person member1, member2;
	List<Person> surrogates,members;
	
	@Before
	public void setUp() {
		member1 = new Person("besancon", "helene");
		member2 = new Person("Silva", "Pedro");
		surrogates = new ArrayList<Person>();
		surrogates.add(member1);
		members = new ArrayList<Person>();
		surrogates.add(member2);
		examinationBoard = new ExaminationBoard(members, surrogates, member1);
	}

	@Test
	public void CheckBoardTest() {		
		assertEquals(examinationBoard.getExaminationBoard(), members);
	}
	
	@Test
	public void CheckSurrogatesTest() {		
		assertEquals(examinationBoard.getSurrogate(), surrogates);
	}
	
	@Test
	public void CheckPresidentTest() {		
		assertEquals(examinationBoard.getPresidentBanking(), member1);
	}

}
