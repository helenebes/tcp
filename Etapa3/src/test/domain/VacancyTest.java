package test.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import contest.domain.Contest;
import contest.domain.User;
import contest.domain.Vacancy;

public class VacancyTest {
	
	Vacancy vacancy;

	@Test
	public void CheckProfileTest() {
		User previousRecord = new User("Silva", "guilherme", 1, "user", "password", "teacher", null);
		vacancy = new Vacancy("assistente", previousRecord);
		assertEquals(vacancy.getProfile().getProfile(), "assistente");
	}
	
	@Test
	public void CheckPreviousRecordTest() {
		User previousRecord = new User("Silva", "guilherme", 1, "user", "password", "teacher", null);
		vacancy = new Vacancy("assistente", previousRecord);
		assertEquals(vacancy.getVacancyPreviousRecord(), previousRecord);
	}
	
	@Test
	public void CheckContestTest() {
		User previousRecord = new User("Silva", "guilherme", 1, "user", "password", "teacher", null);
		vacancy = new Vacancy("assistente", previousRecord);
		Contest contest = new Contest("title", new ArrayList<String>(), "20H");
		vacancy.addContest(contest);
		assertEquals(vacancy.getContest(), contest);
	}

}
