package tests.architecture;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import contest.architecture.ContestManagementImpl;
import contest.database.Database;
import contest.domain.Contest;
import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public class ContestManagementTest {
	
	ContestManagementImpl contestManagement;
	Database database;
	
	@Before
	public void setUp() throws BusinessException {
		database = new Database();
		contestManagement = new ContestManagementImpl(database);
	}

	@Test
	public void CreateContestTest() {		
		Contest contestCreated = contestManagement.createContest("title", new ArrayList<String>(), "20H", "program");
		assertEquals(contestCreated, database.getContests().get(database.getContests().size() - 1));
	}
	
	@Test
	public void CheckAssociateContestTest() {
		Vacancy vacancy = new Vacancy("titular", null);
		Contest contest = new Contest("title", new ArrayList<String>(), "20H", "program");
		contestManagement.associate(vacancy, contest);
		assertEquals(contest.getVacancies().get(contest.getVacancyAmount() - 1), vacancy);
		assertEquals(vacancy.getContest(), contest);
	}
	
	@Test
	public void CheckCloseContestTest() {
		Contest contest = new Contest("title", new ArrayList<String>(), "20H", "program");
		contestManagement.closeContest(contest);
		assertEquals(contest.getStatusLog().get(contest.getStatusLog().size() - 1).getStatus(), "closed");
	}
	
	@Test
	public void VacanciesTest() {
		assertEquals(contestManagement.getAllVacancies(), database.getVacancies());
	}
	
	@Test
	public void ContestsTest() {
		assertEquals(contestManagement.getAllContestsNotClosed(), database.getContests());
	}
	
	@Test
	public void ContestsWithClosedTest() {
		Contest contest = new Contest("title", new ArrayList<String>(), "20H", "program");
		contestManagement.closeContest(contest);
		database.save(contest);
		assertEquals(contestManagement.getAllContestsNotClosed().size() + 1, database.getContests().size());
	}

}
