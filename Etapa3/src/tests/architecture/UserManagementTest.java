package tests.architecture;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.architecture.UserManagementImpl;
import contest.database.Database;
import contest.ui.graphic.action.BusinessException;

public class UserManagementTest {
	
	UserManagementImpl userManagment;
	Database database;

	@Test
	public void LoginTest() throws BusinessException {
		//test done knowing the user User("Silva", "Guilherme", 1, "user", "a", "secretary", null) is in the base
		database = new Database();
		userManagment = new UserManagementImpl(database);
		assertEquals(userManagment.login("user", "a").toString(), database.getUser("user").toString());
	}
	
	@Test (expected=BusinessException.class)
	public void InvalidLoginTest() throws BusinessException {
		//test done knowing the user User("Silva", "Guilherme", 1, "user", "a", "secretary", null) is in the base
		database = new Database();
		userManagment = new UserManagementImpl(database);
		userManagment.login("aa", "a");
	}
	
	@Test
	public void VacanciesTest() throws BusinessException {
		database = new Database();
		userManagment = new UserManagementImpl(database);
		assertEquals(userManagment.getAllVacancies(), database.getVacancies());
	}
	
	@Test
	public void ContestTest() throws BusinessException {
		database = new Database();
		userManagment = new UserManagementImpl(database);
		assertEquals(userManagment.getAllContests(), database.getContests());
	}

}
