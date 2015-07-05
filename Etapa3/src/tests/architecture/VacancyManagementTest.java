package tests.architecture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contest.architecture.VacancyManagementImpl;
import contest.database.Database;
import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public class VacancyManagementTest {

	VacancyManagementImpl vacancyManagement;
	Database database;
	
	@Before
	public void setUp() throws BusinessException {
		database = new Database();
		vacancyManagement = new VacancyManagementImpl(database);
	}

	@Test
	public void CreateVacancyTest() throws BusinessException {		
		Vacancy vacancyCreated = vacancyManagement.createVacancy("titular", "user");
		assertEquals(vacancyCreated, database.getVacancies().get(database.getVacancies().size() - 1));
	}

}
