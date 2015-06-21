package contest.architecture;

import java.util.List;

import contest.database.Database;
import contest.domain.Contest;
import contest.domain.User;
import contest.domain.Vacancy;
import contest.ui.graphic.action.BusinessException;

public class UserManagementImpl {
	
	private final Database database;
	
	public UserManagementImpl(Database database) {
		this.database = database;
	}

	public User login(String username, String password)
		throws BusinessException {
			User user = database.getUser(username);

			if (user == null) {
				throw new BusinessException("inexistent employee");
			}
			if (!user.getPassword().equals(password)) {
				throw new BusinessException("invalid password");
			}

			return user;
	}
	
	public List<Vacancy> getAllVacancies() {
		return database.getVacancies();
	}
	
	public List<Contest> getAllContests() {
		return database.getContests();
	}
}
